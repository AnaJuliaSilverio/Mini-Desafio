package Repository;

import Model.Cliente;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {
    List<Cliente> clientes = new ArrayList<>();
    public ClienteRepository() {
        iniciarBDCliente();
    }

    public void adicionarCliente(Cliente cliente){
        criptografarSenha(cliente);
        clientes.add(cliente);
    }
    public boolean clienteJaExiste(Cliente cliente){
        for (Cliente c:clientes) {
            if (c.getCpf().equals(cliente.getCpf())||c.getEmail().equals(cliente.getEmail())) return true;
        }
        return false;
    }
    public Cliente procuraClienteEmail(String email,String senha) {
        for (Cliente c:clientes) {
            if (c.getEmail().equals(email)&& verificaSenhaCriptografada(c,senha))return c;
        }
        return null;
    }
    public void criptografarSenha(Cliente cliente){
        String hashSenha = BCrypt.hashpw(cliente.getSenha(), BCrypt.gensalt());
        cliente.setSenha(hashSenha);
    }
    public boolean verificaSenhaCriptografada(Cliente cliente,String senha){
        return BCrypt.checkpw(senha,cliente.getSenha());
    }
    public List<Cliente> getClientes() {
        if (clientes.isEmpty())throw new NullPointerException("Lista de clientes vazia");
        return clientes;
    }
    private void iniciarBDCliente(){
        adicionarCliente(new Cliente("João", "572.571.860-30", "joao@example.com","A#b3C"));
        adicionarCliente(new Cliente("Maria", "246.564.540-44", "maria@example.com","X$y9Z"));
        adicionarCliente(new Cliente("Pedro", "309.930.100-08", "pedro@example.com", "M@p5Q"));
        adicionarCliente(new Cliente("Ana", "863.325.530-81", "ana@example.com", "L!k2J"));
        adicionarCliente(new Cliente("Carlos", "201.479.790-05", "carlos@example.com", "R#s8T"));
    }
}
