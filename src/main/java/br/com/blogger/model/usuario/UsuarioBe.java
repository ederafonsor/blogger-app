package br.com.blogger.model.usuario;

import br.com.blogger.features.exceptions.DaoException;
import br.com.blogger.features.persistence.PersistenceProperties;
import br.com.blogger.features.security.ControleAcesso;
import br.com.blogger.model.abstracts.AbstractBe;
import br.com.blogger.model.post.PostDao;
import br.com.blogger.model.post.PostVo;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

public class UsuarioBe extends AbstractBe {

    private UsuarioDao usuarioDao;

    public void cadastrarUsuario(UsuarioVo usuarioVo) {

        validarCadastroUsuario(usuarioVo);

        EntityManagerFactory fabricaConexao = Persistence.createEntityManagerFactory("BLOG_PG_PU", new PersistenceProperties().getConfigPersistence());
        // EntityManagerFactory fabricaConexao = Persistence.createEntityManagerFactory("BLOG_PG_PU"); //Conexão Local

        EntityManager conexao = fabricaConexao.createEntityManager();

        EntityTransaction tx = conexao.getTransaction();
        tx.begin();

        conexao.persist(usuarioVo);

        tx.commit();

        close(conexao);
        fabricaConexao.close();
    }

  public void pesquisarUsuarioPorEmailSenha(UsuarioVo param) throws DaoException {

        EntityManager em = getConexao();
        try {
            this.usuarioDao = new UsuarioDao(em);
            
            
            UsuarioVo usuario = usuarioDao.pesquisarUsuarioPorEmailSenha(param);
            ControleAcesso.login(usuario);
            System.out.println("Usuario:"+usuario);

        } catch (NoResultException e) {
            throw new DaoException("Verifique os dados informados", e);
        } catch (DaoException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        } finally {
            close(em);
        }
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
