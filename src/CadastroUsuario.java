import javax.swing.*;
import java.awt.*;
import java.util.Dictionary;

public class CadastroUsuario {

    public CadastroUsuario(){
        //System.out.println("Construtor de CadastroUsuario chamado!");

        JFrame janelaCadastro = new JFrame("Cadastro de Usuário");
        janelaCadastro.setSize(400, 600);
        janelaCadastro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        janelaCadastro.setLocationRelativeTo(null); // Centraliza a janela na tela
        janelaCadastro.setLayout(null);

        JLabel titulo = new JLabel("Cadastro de Usuário", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setBounds(100, 30, 200, 30); // posição fixa no centro visual da tela
        JLabel labelUsuario = new JLabel("Usuário:");
        labelUsuario.setBounds(150, 80, 100, 30);
        JTextField campoUsuario = new JTextField();
        campoUsuario.setBounds(125, 110, 150, 30);
        JLabel labelSenha = new JLabel("Senha:");
        labelSenha.setBounds(150, 150, 100, 30);
        JPasswordField campoSenha = new JPasswordField();
        campoSenha.setBounds(125, 180, 150, 30);
        JButton botaoCadastrar = new JButton("Cadastrar");
        botaoCadastrar.setBounds(150, 230, 100, 40);

        janelaCadastro.add(titulo);
        janelaCadastro.add(labelUsuario);
        janelaCadastro.add(campoUsuario);
        janelaCadastro.add(labelSenha);
        janelaCadastro.add(campoSenha);
        janelaCadastro.add(botaoCadastrar);
        //System.out.println("Componentes adicionados à janela de cadastro!");
        // Listener do botão
        botaoCadastrar.addActionListener(e -> {
            System.out.println("apertou o button");

            String usuario = campoUsuario.getText();
            String senha = new String(campoSenha.getPassword());
            if (usuario.trim().isEmpty() || senha.trim().isEmpty()){
                JOptionPane.showMessageDialog(janelaCadastro, "Preencha os campos corretamente!");
            }else{
                System.out.println("entrou no else");
                Acessos acessosOBJ= new Acessos();
                Dictionary<String, String> acessos = acessosOBJ.getAcessos();
                System.out.println("criou dicionario");

                if (acessos.get(usuario) !=null) {

                    JOptionPane.showMessageDialog(janelaCadastro, "Usuário já cadastrado!");
                }else{

                    acessosOBJ.adicionarAcesso(usuario, senha);
                    JOptionPane.showMessageDialog(janelaCadastro, "Usuário cadastrado com sucesso!");
                    janelaCadastro.dispose(); // Fecha a janela de cadastro após o sucesso
                    new TelaInicial(); // Abre a tela inicial novamente
                    }
                }



        });
        //System.out.println("O CadastroUsuario foi criado!");
        janelaCadastro.setVisible(true);

    }
}
