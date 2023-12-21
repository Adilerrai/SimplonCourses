package com.ArtWood.dao;

import com.ArtWood.model.Ordre;
import com.ArtWood.service.DbConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

 class OrdreDAO {
    private final DbConnector dbConnector = DbConnector.getInstance();

    public void addOrdre(Ordre ordre) {
        try (Connection connection = dbConnector.getConnection()) {
            String sql = "INSERT INTO commandes (client_id, date_commande, etat) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
                statement.setInt(1, ordre.getClientId());
                statement.setDate(2, java.sql.Date.valueOf(ordre.getDateCommande()));
                statement.setString(3, ordre.getEtat());
                statement.executeUpdate();

                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        ordre.setOrdreId(generatedKeys.getInt(1));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception or re-throw if needed
        }
    }

    public List<Ordre> getAllOrdres() {
        List<Ordre> ordres = new ArrayList<>();
        try (Connection connection = dbConnector.getConnection()) {
            String sql = "SELECT * FROM commandes";
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Ordre ordre = new Ordre();
                    ordre.setOrdreId(resultSet.getInt("commande_id"));
                    ordre.setClientId(resultSet.getInt("client_id"));
                    ordre.setDateCommande(resultSet.getDate("date_commande").toLocalDate());
                    ordre.setEtat(resultSet.getString("etat"));
                    ordres.add(ordre);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception or re-throw if needed
        }
        return ordres;
    }

    public Ordre getOrdreById(int ordreId) {
        Ordre ordre = null;
        try (Connection connection = dbConnector.getConnection()) {
            String sql = "SELECT * FROM commandes WHERE commande_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, ordreId);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        ordre = new Ordre();
                        ordre.setOrdreId(resultSet.getInt("commande_id"));
                        ordre.setClientId(resultSet.getInt("client_id"));
                        ordre.setDateCommande(resultSet.getDate("date_commande").toLocalDate());
                        ordre.setEtat(resultSet.getString("etat"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception or re-throw if needed
        }
        return ordre;
    }

    public void updateOrdre(Ordre ordre) {
        try (Connection connection = dbConnector.getConnection()) {
            String sql = "UPDATE commandes SET client_id = ?, date_commande = ?, etat = ? WHERE commande_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, ordre.getClientId());
                statement.setDate(2, java.sql.Date.valueOf(ordre.getDateCommande()));
                statement.setString(3, ordre.getEtat());
                statement.setInt(4, ordre.getOrdreId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception or re-throw if needed
        }
    }

    public void deleteOrdre(int ordreId) {
        try (Connection connection = dbConnector.getConnection()) {
            String sql = "DELETE FROM commandes WHERE commande_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, ordreId);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception or re-throw if needed
        }
    }
}
