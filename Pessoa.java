import java.io.Serializable;

public class Pessoa implements Serializable {
    private String nome;
    private String email;
    private String telefone;
    private int cpf;
    private String endereco;
    private String sexo;
    private String tipo;

    public Pessoa(String nome, String email, String telefone, int cpf, String endereco, String sexo, String tipo) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
        this.endereco = endereco;
        this.sexo = sexo;
        this.tipo = tipo;
    }

    public String getNome() { return nome; }
    public int getCpf() { return cpf; }
    public String getTipo() { return tipo; }
}