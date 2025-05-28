
import java.util.Dictionary;
import java.util.Hashtable;

public class Acessos {
    private Dictionary<String, String> acessos = new Hashtable<>();
    public Acessos(){
        acessos.put("admin","1234");
    }

    public Dictionary<String, String> getAcessos() {
        return this.acessos;
    }
    public void adicionarAcesso(String usuario, String senha) {
        System.out.println("chegou aqui111");
        this.acessos.put(usuario, senha);
        System.out.println("Aqui foi2222");
    }
}
