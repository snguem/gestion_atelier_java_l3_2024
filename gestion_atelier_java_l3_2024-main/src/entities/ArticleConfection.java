package entities;

import java.util.ArrayList;

public class ArticleConfection extends AbstractEntitie {
    private double prix;
    private double qte;

    //Attributs Navigationnels
    //@ManyToOne
      Categorie categorie;
      //@ManyToMany
      //Couplage Fort
       ArrayList <Unite> unites =new ArrayList<>();

  

    public void addUnite(Unite unite){
         unites.add(unite);
     }
  
    public ArrayList<Unite> getUnites() {
        return unites;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public ArticleConfection(int id, String libelle, double prix, double qte) {
        super(id,libelle);
        this.prix = prix;
        this.qte = qte;
    }

    public ArticleConfection() {
        super();

    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public double getQte() {
        return qte;
    }

    public void setQte(double qte) {
        this.qte = qte;
    }

    @Override
    public String toString() {
        return "ArticleConfection ["+super.toString()+", prix:" + prix + ", qte:" + qte+", categorie:"+categorie.getLibelle()+"]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ArticleConfection other = (ArticleConfection) obj;
        if (id != other.id)
            return false;
        return true;
    }
}
