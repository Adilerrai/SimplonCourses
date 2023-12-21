package com.ArtWood.dao;

import com.ArtWood.model.Article;
import com.ArtWood.service.DbConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticleDao {
    private final DbConnector dbConnector = DbConnector.getInstance();

    public ArticleDao() {

    }

    public int addArticleAndGetId(Article article) {
        int generatedId = -1; // Default value if ID retrieval fails

        try (Connection connection = dbConnector.getConnection()) {
            String sql = "INSERT INTO articles (nom, description, prix) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                statement.setString(1, article.getNom());
                statement.setString(2, article.getDescription());
                statement.setDouble(3, article.getPrix());
                int affectedRows = statement.executeUpdate();

                if (affectedRows > 0) {
                    // Retrieve the generated ID
                    try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            generatedId = generatedKeys.getInt(1);
                        } else {
                            throw new SQLException("Failed to retrieve generated ID.");
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception or log the error
        }

        return generatedId;
    }

    public List<Article> getAllArticles() {
        List<Article> articles = new ArrayList<>();
        try (Connection connection = dbConnector.getConnection()) {
            String sql = "SELECT * FROM articles";
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Article article = new Article();
                    article.setNom(resultSet.getString("nom"));
                    article.setDescription(resultSet.getString("description"));
                    article.setPrix(resultSet.getDouble("prix"));
                    articles.add(article);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception or re-throw if needed
        }
        return articles;
    }

    public Article getArticleById(int articleId) {
        Article article = null;
        try (Connection connection = dbConnector.getConnection()) {
            String sql = "SELECT * FROM articles WHERE article_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, articleId);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        article = new Article();
                        article.setNom(resultSet.getString("nom"));
                        article.setDescription(resultSet.getString("description"));
                        article.setPrix(resultSet.getDouble("prix"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception or re-throw if needed
        }
        return article;
    }

    public boolean updateArticle(int articleId, Article article) {
        try (Connection connection = dbConnector.getConnection()) {
            String sql = "UPDATE articles SET nom = ?, description = ?, prix = ? WHERE article_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, article.getNom());
                statement.setString(2, article.getDescription());
                statement.setDouble(3, article.getPrix());
                statement.setInt(4, articleId);
                statement.executeUpdate();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void deleteArticle(String nom) {
        try (Connection connection = dbConnector.getConnection()) {
            String sql = "DELETE FROM articles WHERE nom = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, nom);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
