
package br.com.blogger.features.exceptions;

public class UsuarioNaoLogadoException extends RuntimeException{

    public UsuarioNaoLogadoException() {
        super("Usuario não está logado");
    }
    
    
}