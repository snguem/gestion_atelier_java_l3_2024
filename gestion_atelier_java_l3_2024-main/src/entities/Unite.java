package entities;

public class Unite extends AbstractEntitie {

    //Contructeur Par Defaut
    public Unite() {
        super();
    }

    public Unite(int id, String libelle) {
        super(id,libelle);
    }

    @Override
    public String toString() {
        return "Unite [id=" + super.toString() + "]";
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
        Unite other = (Unite) obj;
        if (id != other.id)
            return false;
        return true;
    }

    

    
}
