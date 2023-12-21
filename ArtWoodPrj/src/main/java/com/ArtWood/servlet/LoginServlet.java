package com.ArtWood.servlet;

import com.ArtWood.service.DbConnector;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get user input from the login form
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Database check
        if (isValidUser(username, password)) {
            // Successful login, redirect to the dashboard page
            response.sendRedirect("dashboard.jsp");
        } else {
            // Incorrect credentials, forward back to the login page with an error message
            request.setAttribute("error", "Invalid username or password");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
    private boolean isValidUser(String username, String password) {
        try (Connection connection = DbConnector.getConnection()) {
            String sql = "SELECT * FROM admins WHERE username = ? AND password = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, username);
                statement.setString(2, password);
                try (ResultSet resultSet = statement.executeQuery()) {
                    return resultSet.next(); // Return true if the user exists with the provided credentials
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception or re-throw if needed
        }
        return false;
    }
}