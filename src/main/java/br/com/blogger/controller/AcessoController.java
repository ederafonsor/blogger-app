package br.com.blogger.controller;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class AcessoController implements Serializable {

    public String login() {
        if (true) {
            return "/index";
        } else {
            return null;
        }
    }

    public String flowLogin() {
        return "/login";
    }
}
