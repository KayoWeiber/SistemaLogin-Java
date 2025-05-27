import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaInicial {
    public TelaInicial() {
        JFrame janela = new JFrame("Login");
        janela.setSize(400, 600);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null); // Centraliza a janela na tela
        janela.setLayout(null);

        JLabel titulo = new JLabel("Tela de Login", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setBounds(100, 30, 200, 30); // posição fixa no centro visual da tela

        JLabel labelUsuario = new JLabel("Usuário:");
        labelUsuario.setBounds(150, 80, 100, 30);

        JTextField campoUsuario = new JTextField();
        campoUsuario.setBounds(125, 110, 150, 30);

        JLabel labelSenha = new JLabel("Senha:");
        labelSenha.setBounds(150, 150, 100, 30);

        JPasswordField campoSenha = new JPasswordField();
        campoSenha.setBounds(125, 180, 150, 30);

        JButton botaoLogar = new JButton("Login");
        botaoLogar.setBounds(150, 230, 100, 40);

        JButton botaoCadastro = new JButton("Cadastrar Usuário");
        botaoCadastro.setBounds(125, 290, 150, 30);

        // Listener do botão
        botaoLogar.addActionListener(e -> realizarLogin(campoUsuario, campoSenha, janela));
        botaoCadastro.addActionListener(e ->{   janela.dispose();
                    new CadastroUsuario();}
             );

        // Listener de Enter
        ActionListener enterListener = e -> {
            String usuario = campoUsuario.getText();
            String senha = new String(campoSenha.getPassword());
            if (usuario.trim().isEmpty() || senha.trim().isEmpty()) {
                JOptionPane.showMessageDialog(janela, "Preencha os campos corretamente!");
            } else {
                realizarLogin(campoUsuario, campoSenha, janela);
            }
        };
        campoUsuario.addActionListener(enterListener);
        campoSenha.addActionListener(enterListener);

        janela.add(titulo);
        janela.add(labelUsuario);
        janela.add(campoUsuario);
        janela.add(labelSenha);
        janela.add(campoSenha);
        janela.add(botaoLogar);
        janela.add(botaoCadastro);

        janela.setVisible(true);
    }

    private void realizarLogin(JTextField campoUsuario, JPasswordField campoSenha, JFrame janela) {
        String usuario = campoUsuario.getText();
        String senha = new String(campoSenha.getPassword());
        boolean verificado = new VerificacaoLogin(usuario, senha).verificar();

        if (verificado) {
            JOptionPane.showMessageDialog(janela, "Login bem-sucedido!");
            campoUsuario.setText("");
            campoSenha.setText("");
            // Aqui você pode abrir outra janela, se quiser
            // new TelaPrincipal();
            // janela.dispose(); // Fecha a tela de login
        } else {
            JOptionPane.showMessageDialog(janela, "Usuário ou senha incorretos!");
        }
    }
}
