package br.com.blogger.model.usuario;

import br.com.blogger.features.persistence.PersistenceProperties;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class UsuarioBe implements Serializable {

    public void cadastrarUsuario(UsuarioVo usuarioVo) {

        validarCadastroUsuario(usuarioVo);

       // EntityManagerFactory fabricaConexao = Persistence.createEntityManagerFactory("BLOG_PG_PU", new PersistenceProperties().getConfigPersistence());
         EntityManagerFactory fabricaConexao = Persistence.createEntityManagerFactory("BLOG_PG_PU"); //Conexão Local
        EntityManager conexao = fabricaConexao.createEntityManager();

        EntityTransaction tx = conexao.getTransaction();
        tx.begin();

        conexao.persist(usuarioVo);

        tx.commit();

        conexao.close();
        fabricaConexao.close();
    }

    private void validarCadastroUsuario(UsuarioVo usuario) {

        if (usuario.getNome().equals("")) {
            throw new IllegalArgumentException("Nome é obrigatório");
        }
        if (usuario.getEmail().equals("")) {
            throw new IllegalArgumentException("Email é obrigatório");
        }
        if (usuario.getSenha().equals("")) {
            throw new IllegalArgumentException("Senha é obrigatória");
        }

    }

}
