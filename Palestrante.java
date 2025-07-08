public class Palestrante extends Pessoa {
    private String especializacao;
    private String instituicaoVinculo;
    private String biografia;
    private String disponibilidade;
    private String formacao;

    public Palestrante(String nome, String email, String telefone, int cpf, String endereco, String sexo, String tipo,
                       String especializacao, String instituicaoVinculo, String biografia,
                       String disponibilidade, String formacao) {
        super(nome, email, telefone, cpf, endereco, sexo, tipo);
        this.especializacao = especializacao;
        this.instituicaoVinculo = instituicaoVinculo;
        this.biografia = biografia;
        this.disponibilidade = disponibilidade;
        this.formacao = formacao;
    }

    public boolean confirmarPresenca(String evento) {
        System.out.println("Presença confirmada no evento: " + evento);
        return true;
    }

    public void editarPerfil(String novosDados) {
        this.biografia = novosDados;
        System.out.println("Perfil atualizado!");
    }

    public void enviarMaterial(String atividade) {
        System.out.println("Material enviado para atividade: " + atividade);
    }

    @Override
    public String toString() {
        return super.getNome() + " - " + especializacao + " - " + instituicaoVinculo;
    }
}