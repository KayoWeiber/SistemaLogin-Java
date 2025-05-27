
import java.util.Dictionary;
import java.util.Hashtable;

public class Acessos {
    public static Dictionary<String, String> acessos() {
        Dictionary<String, String> acessos = new Hashtable<>();
        acessos.put("admin", "1234");
        return acessos;
    }
    public static void adicionarAcesso(String usuario, String senha) {
        acessos().put(usuario, senha);
    }
}
