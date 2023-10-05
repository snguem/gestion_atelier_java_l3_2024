package repositories.list;

import java.util.ArrayList;

import entities.AbstractEntitie;
// import entities.ArticleConfection;
import repositories.ITables;

public class Table<T extends AbstractEntitie> implements ITables<T> {
    private ArrayList<T> tables=new ArrayList<>();
    
    @Override
    public int insert(T data) {
        if(indexOf(data.getLibelle())==-1 && indexOf(data.getId())==-1){
            tables.add(data);
            return 1;
        }
        return 0;
    }

    @Override
    public int update(T data) {
        int pos=indexOf(data.getId());
        if(pos!=-1){
            tables.set(pos, data) ;
            return 1;
        }
        return 0;
    }

    @Override
    public ArrayList<T> findAll() {
        return tables;
    }

    @Override
    public T findById(int id) {
            int pos=indexOf(id);
            if(pos!=-1){
                return tables.get(pos);
            }
            return null;
    }

    @Override
    public int delete(int id) {
        int index=indexOf(id);
        if(index!=-1){
            tables.remove(index);
            return 1;
        }
        return 0;
    }

    @Override
    public  int indexOf(int id){
        int pos=0;
       for (T cat : tables) {
           if(cat.getId()==id){
             return pos;
           }
           pos++;
       }
       return -1;
    }
    public int indexOf(String libelle){
        int pos=0;
       for (T cat : tables) {
           if(cat.getLibelle().equals(libelle)){
             return pos;
           }
           pos++;
       }
       return -1;
    }
}

