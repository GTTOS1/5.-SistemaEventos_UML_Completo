import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Presenca implements Serializable {
    private Pessoa pessoa;
    private boolean registro;
    private Date horario;
    private Date data;

    public Presenca(Pessoa pessoa, boolean registro, Date horario, Date data) {
        this.pessoa = pessoa;
        this.registro = registro;
        this.horario = horario;
        this.data = data;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public boolean isRegistro() {
        return registro;
    }

    public Date getHorario() {
        return horario;
    }

    public Date getData() {
        return data;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm:ss");

        return "Presença registrada: " +
                pessoa.getNome() +
                " | Data: " + sdfData.format(data) +
                " | Hora: " + sdfHora.format(horario) +
                " | Presente: " + (registro ? "Sim" : "Não");
    }
}
