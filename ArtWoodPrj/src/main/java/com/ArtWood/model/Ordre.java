package com.ArtWood.model;

import java.time.LocalDate;

public class Ordre {
    private int commandeId;

    public int getOrdreId() {
        return ordreId;
    }

    public void setOrdreId(int ordreId) {
        this.ordreId = ordreId;
    }

    private int ordreId;
    private int clientId;
    private LocalDate dateCommande;
    private int articleId;
    private String etat;

    public Ordre(int commandeId, int clientId, LocalDate dateCommande, int articleId, String etat) {
        this.commandeId = commandeId;
        this.clientId = clientId;
        this.dateCommande = dateCommande;
        this.articleId = articleId;
        this.etat = etat;
    }

    public Ordre() {
    }

    public int getCommandeId() {
        return commandeId;
    }

    public void setCommandeId(int commandeId) {
        this.commandeId = commandeId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public LocalDate getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(LocalDate dateCommande) {
        this.dateCommande = dateCommande;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

}
