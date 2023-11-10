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
            JOptionPane.showInputDialog("Email do usário");
        } else if(option.equals(options[1])){//listar usuários
            List<Usuario> usuariosLista = dao.listarUsuarios();
            JOptionPane.showInputDialog(usuariosLista.toString()
                    .replace("[", "")
                    .replace("]", "")
                    .replace(",", ""));
        } else { //buscar por email

        }

    }
}