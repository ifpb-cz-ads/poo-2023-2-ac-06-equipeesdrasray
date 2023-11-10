package model;

import java.util.*;
import java.io.*;

public class Agenda implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Contato> contatos;

    public Agenda(){
        contatos = new ArrayList<>();
    }

    public List<Contato> getContatos(){
        Collections.sort(contatos);
        return contatos;
    }

    public boolean adicionar(Contato contato){
        return contatos.contains(contato) ? false : contatos.add(contato);
    }

    public boolean  remover(Contato contato){
        return contatos.remove(contato);
    }

    public boolean atualizarContato(Contato contatoAntigo, Contato contatoNovo){

        int index = contatos.indexOf(contatoAntigo);
        return index >= 0 ? contatos.set(index, contatoNovo) != null ? true : false : false;
    }

    @Override
    public String toString(){
        String result = "\n";
        for(Contato contato : getContatos())
            result += contato;
        
        return result;
    }

    @Override
    public boolean equals(Object o){
        if(o.getClass() == this.getClass()){
            Agenda agenda = (Agenda) o;
            return agenda.getContatos().equals(this.contatos);
        }

        return false;
    }
}