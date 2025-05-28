import java.util.Dictionary;

public class VerificacaoLogin {
    private String usuario;
    private String senha;

    public VerificacaoLogin(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    public boolean verificar() {
        int count=0;
        if (count>0){
            Acessos acessosOBJ = new Acessos();
        }
        Acessos acessosOBJ = new Acessos();
        Dictionary<String, String> acessos = acessosOBJ.getAcessos();
        String senhaArmazenada = acessos.get(usuario);
        count++;
        return senhaArmazenada != null && senhaArmazenada.equals(senha);
    }
}
