package br.com.blogger.controller;

import br.com.blogger.model.post.PostBe;
import br.com.blogger.model.post.PostVo;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class CadastrarPostController implements Serializable {

    private PostVo postVo;
    private PostBe postBe;

    public CadastrarPostController() {
        if (postVo == null) {
            postVo = new PostVo();
        }
    }

    public void cadastrarPost() {
        try {

            getPostBe().cadastrarPost(postVo);
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Postado", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } catch (Exception e) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
    }

    public PostVo getPostVo() {
        return postVo;
    }

    public String flowCadastroPost() {
        return "/post/cadastro-post";
    }

    public void setPostVo(PostVo postVo) {
        this.postVo = postVo;
    }

    public PostBe getPostBe() {
        if (this.postBe == null) {
            this.postBe = new PostBe();
        }
        return postBe;
    }

    public void setPostBe(PostBe postBe) {
        this.postBe = postBe;
    }
}
