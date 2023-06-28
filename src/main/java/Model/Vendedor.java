package Model;

public class Vendedor {
    private String email, nome, senha, cpf;

    public Vendedor(String nome,String cpf,String email,String senha) {
        this.email = email;
        this.nome = nome;
        this.cpf = cpf;
        this.senha=senha;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String mostrar(){
        return "Nome: "+nome+"\nCPF: "+cpf+"\nEmail: "+email;
    }
}
