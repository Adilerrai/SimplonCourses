package com.ArtWood.model;

public class Article {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id = 0 ;
    private String nom;
    private String description;
    private double prix;

//    public int getArticle_id() {
//        return article_id;
//    }
//
//    public void setArticle_id(int article_id) {
//        this.article_id = article_id;
//    }

//    private int article_id;




    public Article( String nom, String description, double prix) {
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        id++;

    }

    public Article() {
        id++;
    }







    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }



}
