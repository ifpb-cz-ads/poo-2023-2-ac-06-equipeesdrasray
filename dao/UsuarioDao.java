package dao;

import java.io.*;
import java.util.*;
import model.Usuario;

public class UsuarioDao {
    private File file;

    public UsuarioDao(){
        file = new File("usuarios");

        //se o arquivo não existir
        if(!file.exists()){
            try{
                file.createNewFile();
            }catch(IOException e){
                System.out.println("Falha ao criar o arquivo!");
            }
        }
    }

    private boolean atualizarArquivo(List<Usuario> lista){
           try{
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
            out.writeObject(lista);
            return true;
        }catch(IOException e){
            System.out.println("Arquivo não encontrado: " + e);
        }

        return false;
    }

    public List<Usuario> listarUsuarios (){

        if(file.length() > 0 ){
            try{
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
                List<Usuario> lista = (List<Usuario>) in.readObject();
                return lista;

            }catch(IOException e){
                System.out.println("Arquivo não encontrado: " + e);
            } catch(ClassNotFoundException e){
                System.out.println("Classe não encontrada!");
            }
        }

     
        return new ArrayList<>();
       
    }

    public boolean adicionarUsuario(Usuario usuario){

        if(buscarPorEmail(usuario.getEmail()) == null){
            List<Usuario> usuarios = listarUsuarios();

            if(usuarios.add(usuario))
                return atualizarArquivo(usuarios);
        }

        return false;
    }

    /**
     * Remove o usuário do arquivo "usuarios"
    */
    public boolean deletarUsuario(Usuario usuario){
        List<Usuario> usuarios = listarUsuarios();
        if(usuarios.remove(usuario)){
            return atualizarArquivo(usuarios);
        } 

        return false;
    }

    public Usuario buscarPorEmail(String email){
        List<Usuario> usuarios = listarUsuarios();
        for(Usuario usuario : usuarios){
            if(usuario.getEmail().equals(email))
                return usuario;
        }

        return null;
    }

    public boolean atualizarUsuario(Usuario novoUsuario){
        Usuario usuario =  buscarPorEmail(novoUsuario.getEmail());

        if(usuario != null){
            List<Usuario> usuarios = listarUsuarios();

            int index = usuarios.indexOf(usuario);

            usuarios.remove(index);
            usuarios.add(index, novoUsuario);

            atualizarArquivo(usuarios);
            return true;
        }

        return false;
    }

}