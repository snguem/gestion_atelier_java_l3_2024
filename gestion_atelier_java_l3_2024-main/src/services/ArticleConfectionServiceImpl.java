package services;

import java.util.ArrayList;

import entities.ArticleConfection;
import repositories.list.TableArticleConfections;

public class ArticleConfectionServiceImpl implements ArticleConfectionService {

    private TableArticleConfections articleConf=new TableArticleConfections();


    @Override
    public int add(ArticleConfection data) {
        return articleConf.insert(data);
    }

    @Override
    public ArrayList<ArticleConfection> getAll() {
        return articleConf.findAll();
    }

    @Override
    public int update(ArticleConfection data) {
        return articleConf.update(data);
    }

    @Override
    public ArticleConfection show(int id) {
        return articleConf.findById(id);
    }

    @Override
    public int remove(int id) {
        return articleConf.delete(id);
    }

    @Override
    public int[] remove(int[] ids) {
        int[] idsNotDelete=new int[ids.length];
        int nbre=0;
          for (int id = 0; id < ids.length; id++) {
              if (articleConf.delete(ids[id])==0) {
                idsNotDelete[nbre++]=ids[id];
              }
          }
          return idsNotDelete;
    }
    
}
