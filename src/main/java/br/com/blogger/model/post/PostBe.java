package br.com.blogger.model.post;

import br.com.blogger.features.exceptions.DaoException;
import br.com.blogger.features.persistence.PersistenceProperties;
import br.com.blogger.model.abstracts.AbstractBe;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PostBe extends AbstractBe {

    public void cadastrarPost(PostVo postVo) {

       EntityManagerFactory fabricaConexao = Persistence.createEntityManagerFactory("BLOG_PG_PU", new PersistenceProperties().getConfigPersistence());
       //   EntityManagerFactory fabricaConexao = Persistence.createEntityManagerFactory("BLOG_PG_PU"); //Conexão local

        EntityManager conexao = fabricaConexao.createEntityManager();

        EntityTransaction tx = conexao.getTransaction();
        tx.begin();

        conexao.persist(postVo);

        tx.commit();

        conexao.close();
        fabricaConexao.close();
    }
   public PostVo listarPosts() throws DaoException {
        EntityManager em = getConexao();
        PostVo posts = new PostVo();
        try {
            posts = new PostDao(em).listarPosts();
        } catch (DaoException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        } finally {
            close(em);
        }
        return posts;
    }
}
