package services;

import java.util.ArrayList;

import entities.Unite;
import repositories.list.TableUnites;

public class UniteServiceImpl implements UniteService {
    private TableUnites unites=new TableUnites();

    public UniteServiceImpl() {
        unites.insert(new Unite(1, "unite1"));
        unites.insert(new Unite(2, "unite2"));
        unites.insert(new Unite(2, "unite3"));
        unites.insert(new Unite(4, "unite4"));
    }

    @Override
    public int add(Unite data) {
        return unites.insert(data);
    }

    @Override
    public ArrayList<Unite> getAll() {
        return unites.findAll();
    }

    @Override
    public int update(Unite data) {
        return unites.update(data);
    }

    @Override
    public Unite show(int id) {
        return unites.findById(id);
    }

    @Override
    public int remove(int id) {
        return unites.delete(id);
    }

    @Override
    public int[] remove(int[] ids) {
        int[] idsNotDelete=new int[ids.length];
        int nbre=0;
          for (int id = 0; id < ids.length; id++) {
              if (unites.delete(ids[id])==0) {
                idsNotDelete[nbre++]=ids[id];
              }
          }
          return idsNotDelete;
    }
    
}
