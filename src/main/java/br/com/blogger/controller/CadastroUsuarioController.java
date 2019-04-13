package br.com.blogger.controller;

import br.com.blogger.model.usuario.UsuarioBe;
import br.com.blogger.model.usuario.UsuarioVo;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class CadastroUsuarioController implements Serializable {

    private UsuarioVo usuarioVo;
    private UsuarioBe usuarioBe;

    public UsuarioBe getUsuarioBe() {
        
        if(this.usuarioBe == null){
        this.usuarioBe = new UsuarioBe();
        }
        return usuarioBe;
    }

    public CadastroUsuarioController() {
        if(this.usuarioVo == null){
        this.usuarioVo = new UsuarioVo();
        }
    }

    public void cadastrarUsuario() {
        getUsuarioBe().cadastrarUsuario(usuarioVo);
    }

    public UsuarioVo getUsuarioVo() {
        return usuarioVo;
    }

    public void setUsuarioVo(UsuarioVo usuarioVo) {
        this.usuarioVo = usuarioVo;
    }

}
