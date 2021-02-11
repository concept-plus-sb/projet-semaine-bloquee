package miage.bd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import miage.bd.HibernateUtil;
import miage.dto.ArticleDto;
import miage.dto.ArticlePromoDto;
import miage.metier.Article;
import miage.metier.Disponibilite;
import miage.metier.EnumTypePromo;
import miage.metier.Magasin;
import miage.metier.Photo;
import org.hibernate.Session;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mamad
 */
public class ListeArticles {

    public static double arrondir(double nombre, double nbApVirg) {
        return (double) ((int) (nombre * Math.pow(10, nbApVirg) + .5)) / Math.pow(10, nbApVirg);
    }

    public static List<ArticleDto> listeArticlesByMagasin(int id) {

        ArrayList<ArticleDto> articleDtos = new ArrayList<>();

        /*----- Ouverture de la session -----*/
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();

            Magasin m = session.get(Magasin.class, id);

            Map<Article, Disponibilite> maliste = m.getDispo();

            for (HashMap.Entry<Article, Disponibilite> map : maliste.entrySet()) {
                Article a = map.getKey();
                Disponibilite disponibilite = map.getValue();
                ArticleDto articleDto = new ArticleDto();
                articleDto.setCodeArticle(a.getCodeA());
                articleDto.setLibelle(a.getLibelleA());
                articleDto.setPrixUnitaire(a.getPrixVente());
                articleDto.setQteDisponible(disponibilite.getQteDispo());
                for (Photo p : a.getPhotos()) {
                    if (p.isImgPrincipal()) {
                        articleDto.setPhoto(p.getLien());
                    }
                }
                articleDtos.add(articleDto);

            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return articleDtos;
    }

    public static List<ArticlePromoDto> ListeArticlesPromoByMagasin(int id) {

        ArrayList<ArticlePromoDto> articlePromoDtos = new ArrayList<>();

        /*----- Ouverture de la session -----*/
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();

            Magasin m = session.get(Magasin.class, id);

            Map<Article, Disponibilite> maliste = m.getDispo();

//            System.out.println(maliste);
            for (HashMap.Entry<Article, Disponibilite> map : maliste.entrySet()) {
                Article a = map.getKey();
                Disponibilite disponibilite = map.getValue();
                ArticlePromoDto articlePromoDto = new ArticlePromoDto();

//                System.out.println(a.getPromotion());
                if (a.getPromotion() != null) {
                    articlePromoDto.setCodeArticle(a.getCodeA());
                    articlePromoDto.setLibelle(a.getLibelleA());
                    articlePromoDto.setPrixUnitaire(a.getPrixVente());
                    articlePromoDto.setQteDisponible(disponibilite.getQteDispo());
                    for (Photo p : a.getPhotos()) {
                        if (p.isImgPrincipal()) {
                            articlePromoDto.setPhoto(p.getLien());
                        }
                    }

                    if (a.getPromotion().getTypePromo() == EnumTypePromo.unite) {
                        articlePromoDto.setPourcentage(a.getPromotion().getPourcentagePromo());
                        articlePromoDto.setLibellePromo(a.getPromotion().getLibellePromo());
                        double a_nombre = a.getPrixVente() - (a.getPrixVente() * a.getPromotion().getPourcentagePromo()) / 100;
                        float nombre = (float)arrondir(a_nombre, 2);
                        articlePromoDto.setPrixUnitairePromo(nombre);
                    } else {
                        articlePromoDto.setPourcentage(a.getPromotion().getPourcentagePromo());
                        articlePromoDto.setLibellePromo(a.getPromotion().getLibellePromo());
                        articlePromoDto.setRang(a.getPromotion().getNbArticlePromo());
                    }

                    articlePromoDtos.add(articlePromoDto);
                }

            }

        }

        return articlePromoDtos;

    }

}
