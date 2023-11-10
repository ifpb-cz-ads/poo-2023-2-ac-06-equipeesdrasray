package model;
import java.util.Objects;
import java.io.*;

public class Contato implements Comparable<Contato>, Serializable {
    private static final long serialVersionUID = 1L;
    
    private String nome;
    private String email;
    private String telefone;

    //constructor
    public Contato(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    //getters and setters
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override 
    public boolean equals(Object o){
        if(o == null && o.getClass() != getClass()) return false;

        Contato contato = (Contato) o;
        return Objects.equals(nome, contato.getNome()) && Objects.equals(telefone, contato.getTelefone());
    }

    @Override
    public String toString(){
        return "  Nome: " + nome + " | Telefone: " + telefone + '\n';
    }

    @Override
    public int compareTo(Contato contato){
        return nome.compareTo(contato.getNome());
    }
}