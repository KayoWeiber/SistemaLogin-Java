import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaInicial {
    public TelaInicial(){
        JFrame janela = new JFrame("Login");// criar uma nova janela


        JLabel labelUsuario= new JLabel("Usuário:"); // criar um novo rótulo
        labelUsuario.setBounds(180, 50, 100, 30); // definir a posição e o tamanho do rótulo
        JTextField campoUsuario = new JTextField(); // criar um novo campo de texto
        campoUsuario.setBounds(133, 80, 150, 30); // definir a posição e o tamanho do campo de texto

        JLabel labelSenha = new JLabel("Senha:"); // criar um novo rótulo
        labelSenha.setBounds(180, 120, 100, 30); // definir a posição e o tamanho do rótulo
        JPasswordField campoSenha = new JPasswordField(); // criar um novo campo de senha
        campoSenha.setBounds(133, 150, 150, 30); // definir a posição e o tamanho do campo de senha

        JButton BotaoLogar = new JButton("Login"); // criar um novo botão
        BotaoLogar.setBounds(160, 200, 100, 50); // definir a posição e o tamanho do botão

        BotaoLogar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                realizarLogin(campoUsuario,campoSenha,janela);
            }
        });

    // Permitir login ao pressionar Enter nos campos de usuário ou senha
        ActionListener enterListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(campoUsuario!= null || campoSenha != null) {
                    realizarLogin(campoUsuario, campoSenha, janela);
                }else{
                    JOptionPane.showMessageDialog(janela, "Preencha os campos corretamente!");
                }
            }
        };
//        campoUsuario.addActionListener(enterListener);
//        campoSenha.addActionListener(enterListener);



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
    private void realizarLogin(JTextField campoUsuario, JPasswordField campoSenha, JFrame janela) { //obtendo os valores dos campos de usuário e senha
        //System.out.println("Teste botão foi clicado!");
        String usuario = campoUsuario.getText();
        String senha = new String(campoSenha.getPassword());
        boolean verificado = new VerificacaoLogin(usuario, senha).verificar();
        if (verificado) {
            JOptionPane.showMessageDialog(janela, "Login bem-sucedido!");
            campoUsuario.setText("");
            campoSenha.setText("");
        } else {
            JOptionPane.showMessageDialog(janela, "Usuário ou senha incorretos!");
        }
    };

}
