package model;

import java.io.Serializable;
import java.util.Objects;

public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    private String email;
    private String senha;
    private Agenda agenda;

    //constructor
    public Usuario(String email, String senha){
        this.email = email;
        this.senha = senha;
        this.agenda = new Agenda();
    }

    //getters and setters
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Agenda getAgenda() {
        return this.agenda;
    }

    @Override 
    public String toString(){
        return "\nEmail: " + email + '\n' +
                "Senha: " + senha + '\n';
    }

    @Override
    public boolean equals(Object o){
        if(o.getClass() == this.getClass()){
            Usuario usuario = (Usuario) o;

            return usuario.getEmail().equals(this.email);
        }

        return false;
    }


}