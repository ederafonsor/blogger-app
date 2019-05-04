package br.com.blogger.controller;

import br.com.blogger.features.exceptions.DaoException;
import br.com.blogger.model.post.PostBe;
import br.com.blogger.model.post.PostVo;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@ViewScoped
public class IndexController implements Serializable {

    private PostVo postsVo;

    public IndexController() {
        if (postsVo == null) {
            postsVo = new PostVo();
        }
        listarPosts();
    }

    public void listarPosts() {
        try {
            this.postsVo = getPostBe().listarPosts();
        } catch (DaoException e) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
    }

    public PostVo getPostsVo() {
        return postsVo;
    }

    public void setPostsVo(PostVo postsVo) {
        this.postsVo = postsVo;
    }

    public PostBe getPostBe() {
        if (postBe == null) {
            postBe = new PostBe();
        }
        return postBe;
    }

    public void setPostBe(PostBe postBe) {
        this.postBe = postBe;
    }
    private PostBe postBe;

    public String flowIndex() {
        return "/index";
    }
}
