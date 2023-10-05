package entities;

public class Categorie extends AbstractEntitie {
     //Attributs   Instances
 
     public Categorie(int id, String libelle) {
        super(id,libelle);
     }
 
     public Categorie(String libelle) {
        super(libelle);
     }
 
     //Contructeur Par Defaut
     public Categorie() {
        super();
     }

     @Override
     public String toString() {
         return "Categorie [" + super.toString() + "]";
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
        Categorie other = (Categorie) obj;
        if (id != other.id)
            return false;
        return true;
    }
 
     
}
