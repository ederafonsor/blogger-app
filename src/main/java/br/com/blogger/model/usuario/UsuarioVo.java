package br.com.blogger.model.usuario;

import br.com.blogger.model.abstracts.AbstractVo;
import br.com.blogger.model.post.PostVo;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb02_usuario")
public class UsuarioVo extends AbstractVo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "email")
    private String email;
   
    private String senha;

    /*private Boolean ativo;
    private Date dataCriacao;
    private Date dataAtivacao;
    private String tokenAtivacao;
    private Date dataCriacaoToken; */
    public UsuarioVo() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UsuarioVo other = (UsuarioVo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<PostVo> getPosts() {
        return posts;
    }

    public void setPosts(List<PostVo> posts) {
        this.posts = posts;
    }

   @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   private List<PostVo> posts;


    /*  public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataAtivacao() {
        return dataAtivacao;
    }

    public void setDataAtivacao(Date dataAtivacao) {
        this.dataAtivacao = dataAtivacao;
    }

    public String getTokenAtivacao() {
        return tokenAtivacao;
    }

    public void setTokenAtivacao(String tokenAtivacao) {
        this.tokenAtivacao = tokenAtivacao;
    }

    public Date getDataCriacaoToken() {
        return dataCriacaoToken;
    }

    public void setDataCriacaoToken(Date dataCriacaoToken) {
        this.dataCriacaoToken = dataCriacaoToken;
    }
     */
    @Override
    public String toString() {
        return "ID: " + id + " - NOME: " + nome;

    }

}
