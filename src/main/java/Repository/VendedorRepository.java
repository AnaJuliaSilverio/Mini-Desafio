package Repository;

import Model.Vendedor;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VendedorRepository {
    private List<Vendedor> vendedores = new ArrayList<>();

    public VendedorRepository() {
        iniciarBDVendedor();
    }

    public List<Vendedor> getVendedores() {
        if (vendedores.isEmpty())throw new NullPointerException("Lista de vendedores vazia");
        return vendedores;
    }
    public boolean vendedorJaExiste(Vendedor vendedor){
        for (Vendedor v:vendedores) {
            if (v.getCpf().equals(vendedor.getCpf())||v.getEmail().equals(vendedor.getEmail())) return true;
        }
        return false;
    }

    public void adicionarVendedor(Vendedor vendedor){
        criptografarSenha(vendedor);
        vendedores.add(vendedor);
    }
    public void criptografarSenha(Vendedor vendedor){
        String hashSenha = BCrypt.hashpw(vendedor.getSenha(), BCrypt.gensalt());
        vendedor.setSenha(hashSenha);
    }
    public Vendedor procuraVendedorEmail(String email,String senha) {
        for (Vendedor v:vendedores) {
            if (v.getEmail().equals(email)&& verificaSenhaCriptografada(v,senha))return v;
        }
        return null;
    }
    public boolean verificaSenhaCriptografada(Vendedor vendedor,String senha){
        return BCrypt.checkpw(senha,vendedor.getSenha());
    }
    public Vendedor turnoDaVez(){
        Random random = new Random();
        int idvendedoraleatorio = random.nextInt(vendedores.size())+1;
        return vendedores.get(idvendedoraleatorio);
    }
    public void iniciarBDVendedor(){
        adicionarVendedor(new Vendedor("Eduardo", "478.539.980-58", "eduardo@example.com","G!h6F"));
        adicionarVendedor(new Vendedor("Fernanda", "119.831.720-57", "fernanda@example.com", "E@i4D"));
        adicionarVendedor(new Vendedor("Ricardo", "427.038.280-55", "ricardo@example.com", "B%v7N"));
        adicionarVendedor(new Vendedor("Juliana", "796.287.960-20", "juliana@example.com", "K$m1I"));
        adicionarVendedor(new Vendedor("Mariana", "454.318.410-68", "mariana@example.com", "T&u0S"));
    }
}
