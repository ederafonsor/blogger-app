package br.com.blogger.model.post;

import br.com.blogger.features.persistence.PersistenceProperties;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PostBe implements Serializable {

    public void cadastrarPost(PostVo postVo) {

        EntityManagerFactory fabricaConexao = Persistence.createEntityManagerFactory("BLOG_PG_PU", new PersistenceProperties().getConfigPersistence());
        //  EntityManagerFactory fabricaConexao = Persistence.createEntityManagerFactory("BLOG_PG_PU"); //Conexão local

        EntityManager conexao = fabricaConexao.createEntityManager();

        EntityTransaction tx = conexao.getTransaction();
        tx.begin();

        conexao.persist(postVo);

        tx.commit();

        conexao.close();
        fabricaConexao.close();
    }

}
