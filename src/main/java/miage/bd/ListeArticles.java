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
                articleDto.setUniteL(a.getUniteL());
                
                for (Photo p : a.getPhotos()) {
                    if (p.isImgPrincipal()) {
                        articleDto.setPhoto(p.getLien());
                    }
                }
                
                switch((a.getNutriscore().getNutriscore())){
                    case "A": 
                            articleDto.setNutriscore("<img data-image='black' src='img/NutriscoreA.png' alt='' height='31' weight='51'>");
                        break;
                    case "B": 
                           articleDto.setNutriscore("<img data-image='black' src='img/NutriscoreB.png' alt='' height='31' weight='51'>");
                         break;
                    case "C":
                           articleDto.setNutriscore("<img data-image='black' src='img/NutriscoreC.png' alt='' height='31' weight='51'>");
                         break;
                     case "D":
                          articleDto.setNutriscore("<img data-image='black' src='img/NutriscoreD.png' alt='' height='31' weight='51'>");
                         break;
                     case "E":
                           articleDto.setNutriscore("<img data-image='black' src='img/NutriscoreE.png' alt='' height='31' weight='51'>");
                         break;
                }
                
                double a_nombre = (a.getPrixVente()/a.getContenance())*1000;
                float nombre = (float)arrondir(a_nombre, 2);
                
                articleDto.setPrixAuKilo(nombre);
                
                articleDtos.add(articleDto);

            }

        } catch (Exception e) {
            System.out.println("---------->"+e.getMessage());
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
                    
                    switch((a.getNutriscore().getNutriscore())){
                    case "A": 
                            articlePromoDto.setNutriscore("<img data-image='black' src='img/NutriscoreA.png' alt='' height='31' weight='51'>");
                        break;
                    case "B": 
                           articlePromoDto.setNutriscore("<img data-image='black' src='img/NutriscoreB.png' alt='' height='31' weight='51'>");
                         break;
                    case "C":
                           articlePromoDto.setNutriscore("<img data-image='black' src='img/NutriscoreC.png' alt='' height='31' weight='51'>");
                         break;
                     case "D":
                          articlePromoDto.setNutriscore("<img data-image='black' src='img/NutriscoreD.png' alt='' height='31' weight='51'>");
                         break;
                     case "E":
                           articlePromoDto.setNutriscore("<img data-image='black' src='img/NutriscoreE.png' alt='' height='31' weight='51'>");
                         break;
                }
                
                double a_nombrePAK = (a.getPrixVente()/a.getContenance())*1000;
                float nombrePAK = (float)arrondir(a_nombrePAK, 2);
                
                articlePromoDto.setPrixAuKilo(nombrePAK);
                articlePromoDto.setUniteL(a.getUniteL());
                    

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
