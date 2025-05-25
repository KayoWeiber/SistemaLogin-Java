public class VerificacaoLogin {
    //new String(campoSenha.getPassword())
    private String usuario;
    private String senha;


    public VerificacaoLogin(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }
    public boolean verificar() {
        java.util.Dictionary<String, String> acessos = Acessos.acessos();
        if(acessos.get(usuario) != null) {
            if (acessos.get(usuario).equals(senha)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }
}