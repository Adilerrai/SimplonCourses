package com.ArtWood.dao;

import com.ArtWood.model.Article;

public class MAIN {
    public static void main(String[] args) {
        Article article = new Article();
        ArticleDao adao = new ArticleDao();

        article.setNom("adil");
        article.setPrix(50);
        article.setDescription("hello");
        System.out.println(adao.addArticleAndGetId(article));
        System.out.println(article.getId());
        article.setNom("hahah");
        article.setPrix(70);
        article.setDescription("dd");
        System.out.println(adao.addArticleAndGetId(article));
        System.out.println(article.getId());
    }
}
