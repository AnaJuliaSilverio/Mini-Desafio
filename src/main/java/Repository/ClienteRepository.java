package Repository;

import Model.Cliente;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {
    List<Cliente> clientes = new ArrayList<>();

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

}
