import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaInicial {
    public TelaInicial(){
        JFrame janela = new JFrame("Login");// criar uma nova janela


        JLabel labelUsuario= new JLabel("Usuário:"); // criar um novo rótulo
        labelUsuario.setBounds(50, 50, 100, 30); // definir a posição e o tamanho do rótulo
        JTextField campoUsuario = new JTextField(); // criar um novo campo de texto
        campoUsuario.setBounds(50, 80, 150, 30); // definir a posição e o tamanho do campo de texto

        JLabel labelSenha = new JLabel("Senha:"); // criar um novo rótulo
        labelSenha.setBounds(50, 120, 100, 30); // definir a posição e o tamanho do rótulo
        JPasswordField campoSenha = new JPasswordField(); // criar um novo campo de senha
        campoSenha.setBounds(50, 150, 150, 30); // definir a posição e o tamanho do campo de senha

        JButton BotaoLogar = new JButton("Login"); // criar um novo botão
        BotaoLogar.setBounds(150, 200, 100, 50); // definir a posição e o tamanho do botão

        BotaoLogar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Teste botão foi clicado!");
                String usuario = campoUsuario.getText(); // obter o texto do campo de texto
                String senha = new String(campoSenha.getPassword()); // obter o texto do campo de senha

                if (usuario.equals("admin") && senha.equals("1234")) { // verificar se o usuário e a senha estão corretos
                    JOptionPane.showMessageDialog(janela, "Login bem-sucedido!"); // mostrar uma mensagem de sucesso
                    campoUsuario.setText(""); // limpar o campo de texto
                    campoSenha.setText(""); // limpar o campo de senha
                } else {
                    JOptionPane.showMessageDialog(janela, "Usuário ou senha incorretos!"); // mostrar uma mensagem de erro
                }

            }
        });
        janela.add(BotaoLogar); //adicionar o botão na janela
        janela.add(labelUsuario); // adicionar o rótulo na janela
        janela.add(campoUsuario); // adicionar o campo de texto na janela
        janela.add(labelSenha); // adicionar o rótulo na janela
        janela.add(campoSenha); // adicionar o campo de senha na janela

        janela.setLayout(null);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //definir o que acontece quando a janela é fechada
        janela.setBounds(200,200,400,600); //definir tamanho da janela

        janela.setVisible(true);
    }

}
