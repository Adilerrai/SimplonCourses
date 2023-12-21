package com.ArtWood.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.ArtWood.dao.ArticleDao;
import com.ArtWood.model.Article;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import static java.lang.System.out;

@WebServlet("/ArticleServlet")
public class ArticleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "add":
                    addArticle(request, response);
                    break;
                case "edit":
                    editArticle(request, response);
                    break;
                case "delete":
                    deleteArticle(request, response);
                    break;
                default:
                    out.println("Invalid action");
            }
        } else {
            out.println("Action parameter is missing");
        }
    }

    private void addArticle(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nom = request.getParameter("bkname");
        String description = request.getParameter("bkdes");
        double prix = Double.parseDouble(request.getParameter("prix"));
        Article article = new Article(nom, description, prix);

        try {
            ArticleDao articleDao = new ArticleDao();
            if (articleDao.addArticleAndGetId(article)!=-1) {
                response.sendRedirect("articles.jsp");
            } else {
                out.print("Failed to add article");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void editArticle(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int articleId = Integer.parseInt(request.getParameter("id"));
        String nom = request.getParameter("bkname");
        String description = request.getParameter("bkdes");
        double prix = Double.parseDouble(request.getParameter("prix"));
        Article article = new Article(nom, description, prix);

        try {
            ArticleDao articleDao = new ArticleDao();
            if (articleDao.updateArticle(articleId, article)) {
                response.sendRedirect("index.jsp");
            } else {
                out.print("Failed to update article");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteArticle(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nom = request.getParameter("bkname");

        try {
            ArticleDao articleDao = new ArticleDao();
            articleDao.deleteArticle(nom);
            response.sendRedirect("articles.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
