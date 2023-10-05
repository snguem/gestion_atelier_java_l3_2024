import java.util.ArrayList;
import java.util.Scanner;

import entities.ArticleConfection;
import entities.Categorie;
import entities.Unite;
import services.ArticleConfectionServiceImpl;
import services.CategorieServiceImpl;
import services.UniteServiceImpl;

public class App {
    private static Scanner scanner=new Scanner(System.in);
    private static CategorieServiceImpl categorieServiceImpl=new CategorieServiceImpl();
    private static ArticleConfectionServiceImpl articleConfectionServiceImpl=new ArticleConfectionServiceImpl();
    private static UniteServiceImpl uniteServiceImpl=new UniteServiceImpl();

    public static void main(String[] args) throws Exception {
        int choix;
        do{
            System.out.println("1- Gerer les categories");
            System.out.println("2- Gerer les articles");
            System.out.println("0- Quitter");
            choix=scanner.nextInt();
            scanner.nextLine();
            
            switch (choix) {
                case 1:
                    gererCategorie();
                    break;
            
                case 2:
                    gererArticle();
                    break;
                    
                default:
                    break;
            };
        }while(choix!=0);
    }

    public static int giveId(String texte){
        System.out.print("Entrer l'id "+ texte +" : ");
        return scanner.nextInt();
    }

    public static void gererCategorie(){
        int choix,id;
        do{
            System.out.println("1- Ajouter une categorie");
            System.out.println("2- lister les categories");
            System.out.println("3- supprimer une categorie");
            System.out.println("4- supprimer plusieurs categories");
            System.out.println("5- modifier une categorie");
            System.out.println("0- Retour");
            choix=scanner.nextInt();
            scanner.nextLine();
            
            switch (choix) {
                case 1:
                    System.out.print("Entrer le libelle : ");
                    Categorie categorie=new Categorie(scanner.nextLine());
                    switch (categorieServiceImpl.add(categorie)) {
                        case 0:
                            System.out.println("Echec de l insertion, le libelle existe deja !");
                            break;
                    
                        default:
                            break;
                    }
                    break;
            
                case 2:
                    categorieServiceImpl.getAll().forEach(System.out::println);
                    break;
                    
                case 3:
                    id=giveId("d une categorie");
                    switch (categorieServiceImpl.remove(id)) {
                        case 0:
                            System.out.println("Echec de suppression, id incorrect ou categorie inexistant");
                            break;
                    }
                    break;

                case 4:
                    ArrayList<Categorie> categories=categorieServiceImpl.getAll();
                    int[] ids=new int[categories.size()];
                    int nbr=0, rep;
                    
                    do {
                        ids[nbr++]=giveId("d une categorie");
                        System.out.println("Voulez-vous supprimer une autre categorie?");
                        System.out.println("1) oui");
                        System.out.println("2) non");
                        rep=scanner.nextInt();
                    } while (rep!=2);
                    for (int remove : categorieServiceImpl.remove(ids)) {
                        if(remove!=0)
                            System.out.println("Echec suppression, la categorie ayant l id "+remove+" est introuvable!");
                    };
                    break;

                case 5:
                    id=giveId("d une categorie");
                    scanner.nextLine();
                    categorie=categorieServiceImpl.show(id);
                    if(categorie!=null){
                        System.out.println("Last libelle : " + categorie.getLibelle());
                        System.out.println("Entrer le nouveau libelle : ");
                        categorie.setLibelle(scanner.nextLine());
                        categorieServiceImpl.update(categorie);
                    }else{
                        System.out.println("Echec de modification, id incorrect ou categorie inexistant");
                    }
                break;
                
                default:
                    break;
            };
        }while(choix!=0);
    }
    
    public static void gererArticle(){
        int choix,id,qte,rep;
        double prix;
        String lib;
        Categorie categorie;
        Unite unite;
        do{
            System.out.println("1- Ajouter un article");
            System.out.println("2- lister les articles");
            System.out.println("3- supprimer un article");
            System.out.println("4- supprimer plusieurs articles");
            System.out.println("5- afficher les unites d un article");
            System.out.println("6- modifier un article");
            System.out.println("0- Retour");
            choix=scanner.nextInt();
            scanner.nextLine();
            
            switch (choix) {
                case 1:
                    id=giveId("de l article");
                    scanner.nextLine();
                    System.out.print("Entrer le libelle : ");
                    lib=scanner.nextLine();
                    System.out.print("Entrer le prix : ");
                    prix=scanner.nextDouble();
                    System.out.print("Entrer la quantite : ");
                    qte=scanner.nextInt();
                    ArticleConfection article=new ArticleConfection(id,lib,prix,qte);
                    
                    do {
                        categorie=categorieServiceImpl.show(giveId("de la categorie"));
                        if(categorie==null){
                            System.out.println("erreur categorie");
                        }
                    } while (categorie==null);
                    article.setCategorie(categorie);

                    do {
                        unite=uniteServiceImpl.show(giveId("d une unite"));
                        if(unite==null){
                            System.out.println("Erreur unite ou id incorrect!");
                        }else{
                            article.addUnite(unite);
                        }
                        System.out.println("Ajouter une autre unite ?");
                        System.out.println("1-oui");
                        System.out.println("2-non");
                        rep=scanner.nextInt();
                    } while (rep!=2);
                    switch (articleConfectionServiceImpl.add(article)) {
                        case 0:
                            System.out.println("Echec d insertion, libelle ou id deja existant");
                            break;
                    
                        default:
                            break;
                    }
                    break;
            
                case 2:
                    articleConfectionServiceImpl.getAll().forEach(System.out::println);
                    break;
                    
                case 3:
                    id=giveId("d un article");
                    switch (articleConfectionServiceImpl.remove(id)) {
                        case 0:
                            System.out.println("Echec de suppression, id incorrect ou categorie inexistant");
                            break;
                    }
                    break;

                case 4:
                    ArrayList<ArticleConfection> articleConfections=articleConfectionServiceImpl.getAll();
                    int[] ids=new int[articleConfections.size()];
                    int nbr=0;
                    
                    do {
                        ids[nbr++]=giveId("d un article");
                        System.out.println("Voulez-vous supprimer un autre article?");
                        System.out.println("1) oui");
                        System.out.println("2) non");
                        rep=scanner.nextInt();
                    } while (rep!=2);
                    for (int remove : articleConfectionServiceImpl.remove(ids)) {
                        if(remove!=0)
                        System.out.println("Echec suppression, l article ayant l id "+remove+" est introuvable!");
                    };
                    break;
                case 5:
                    id=giveId("de l article");
                    article=articleConfectionServiceImpl.show(id);
                    switch (article) {
                        case null:
                            System.out.println("Erreur id, l article est introuvable!");
                            break;
                    
                        default:
                            article.getUnites().forEach(System.out::println);
                            break;
                    }
                    break;
                    
                default:
                    break;
            };
        }while(choix!=0);
    }
}
