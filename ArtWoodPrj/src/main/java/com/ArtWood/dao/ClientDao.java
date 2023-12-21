package com.ArtWood.dao;

import com.ArtWood.model.Client;
import com.ArtWood.service.DbConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

 class ClientDAO {
    private final DbConnector dbConnector = DbConnector.getInstance();

    public void addClient(Client client) {
        try (Connection connection = dbConnector.getConnection()) {
            String sql = "INSERT INTO clients (nom, email, telephone, adresse) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, client.getNom());
                statement.setString(2, client.getEmail());
                statement.setString(3, client.getTelephone());
                statement.setString(4, client.getAdresse());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Client> getAllClients() {
        List<Client> clients = new ArrayList<>();
        try (Connection connection = dbConnector.getConnection()) {
            String sql = "SELECT * FROM clients";
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Client client = new Client();
                    client.setClientId(resultSet.getInt("client_id"));
                    client.setNom(resultSet.getString("nom"));
                    client.setEmail(resultSet.getString("email"));
                    client.setTelephone(resultSet.getString("telephone"));
                    client.setAdresse(resultSet.getString("adresse"));
                    clients.add(client);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    public Client getClientById(int clientId) {
        Client client = null;
        try (Connection connection = dbConnector.getConnection()) {
            String sql = "SELECT * FROM clients WHERE client_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, clientId);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        client = new Client();
                        client.setClientId(resultSet.getInt("client_id"));
                        client.setNom(resultSet.getString("nom"));
                        client.setEmail(resultSet.getString("email"));
                        client.setTelephone(resultSet.getString("telephone"));
                        client.setAdresse(resultSet.getString("adresse"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception or re-throw if needed
        }
        return client;
    }

    public void updateClient(Client client) {
        try (Connection connection = dbConnector.getConnection()) {
            String sql = "UPDATE clients SET nom = ?, email = ?, telephone = ?, adresse = ? WHERE client_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, client.getNom());
                statement.setString(2, client.getEmail());
                statement.setString(3, client.getTelephone());
                statement.setString(4, client.getAdresse());
                statement.setInt(5, client.getClientId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteClient(int clientId) {
        try (Connection connection = dbConnector.getConnection()) {
            String sql = "DELETE FROM clients WHERE client_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, clientId);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}