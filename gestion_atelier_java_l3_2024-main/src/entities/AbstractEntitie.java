package entities;

public abstract class AbstractEntitie {
    private static int nbr;
    protected int id;
    protected String libelle;
    
    public AbstractEntitie() {
        id=++nbr;
    }
    public AbstractEntitie(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }
    public AbstractEntitie(String libelle) {
        id=++nbr;
        this.libelle = libelle;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    
    @Override
    public String toString() {
        return "id:" + id + ", libelle:" + libelle;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
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
        AbstractEntitie other = (AbstractEntitie) obj;
        if (libelle == null) {
            if (other.libelle != null)
                return false;
        } else if (!libelle.equals(other.libelle))
            return false;
        return true;
    }
}
