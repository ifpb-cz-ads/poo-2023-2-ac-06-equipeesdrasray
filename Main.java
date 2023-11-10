import model.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

import dao.*;

public class Main {
    public static void main(String...args) {
        UsuarioDao dao = new UsuarioDao();
        String options[] = {"salvar usuário", "Listar Usuários", "Buscar por email"};

        String option = (String) JOptionPane.showInputDialog(
                null,
                "O que você deseja fazer?",
                "Opção",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
                );

        if(option.equals(options[0])){//salvar usuário
            JTextField email = new JTextField();
            JTextField senha = new JPasswordField();

            Object[] message = {
                    "email", email,
                    "senha", senha
            };

            JOptionPane.showConfirmDialog(null, message, "Salvar usuario", JOptionPane.OK_OPTION);
            boolean adicionado = dao.adicionarUsuario(new Usuario(email.getText(), senha.getText()));

            if(!adicionado){
                JOptionPane.showMessageDialog(null, "Erro ao salvar usuário", "Erro", JOptionPane.OK_OPTION);
            } else {
                JOptionPane.showMessageDialog(null, "Usuário adicionado!", "Confirmação", JOptionPane.OK_OPTION);
            }

        } else if(option.equals(options[1])){//listar usuários
            List<Usuario> usuariosLista = dao.listarUsuarios();
            JOptionPane.showMessageDialog(null, usuariosLista.toString()
                    .replace("[", "")
                    .replace("]", "")
                    .replace(",", ""));
        } else { //buscar por email

            String email = JOptionPane.showInputDialog(null, "email");

            Usuario usuario = dao.buscarPorEmail(email);

            if(usuario != null){
                JOptionPane.showMessageDialog(null, usuario);
            } else {
                JOptionPane.showMessageDialog(null, "Usuário não encontrado");
            }

        }

    }
}