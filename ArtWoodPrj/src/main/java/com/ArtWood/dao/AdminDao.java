package com.ArtWood.dao;

import com.ArtWood.model.Admin;
import com.ArtWood.service.DbConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class AdminDAO {
    private final DbConnector dbConnector = DbConnector.getInstance();

    public void addAdmin(Admin admin) {
        try (Connection connection = dbConnector.getConnection()) {
            String sql = "INSERT INTO admins (username, password) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, admin.getUsername());
                statement.setString(2, admin.getPassword());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Admin> getAllAdmins() {
        List<Admin> admins = new ArrayList<>();
        try (Connection connection = dbConnector.getConnection()) {
            String sql = "SELECT * FROM admins";
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Admin admin = new Admin();
                    admin.setAdminId(resultSet.getInt("admin_id"));
                    admin.setUsername(resultSet.getString("username"));
                    admin.setPassword(resultSet.getString("password"));
                    admins.add(admin);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admins;
    }

    public Admin getAdminById(int adminId) {
        Admin admin = null;
        try (Connection connection = dbConnector.getConnection()) {
            String sql = "SELECT * FROM admins WHERE admin_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, adminId);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        admin = new Admin();
                        admin.setAdminId(resultSet.getInt("admin_id"));
                        admin.setUsername(resultSet.getString("username"));
                        admin.setPassword(resultSet.getString("password"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }

    public void updateAdmin(Admin admin) {
        try (Connection connection = dbConnector.getConnection()) {
            String sql = "UPDATE admins SET username = ?, password = ? WHERE admin_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, admin.getUsername());
                statement.setString(2, admin.getPassword());
                statement.setInt(3, admin.getAdminId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception or re-throw if needed
        }
    }

    public void deleteAdmin(int adminId) {
        try (Connection connection = dbConnector.getConnection()) {
            String sql = "DELETE FROM admins WHERE admin_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, adminId);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
