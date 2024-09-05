import java.util.Date;

public class Cirurgia {
    private int id_cirurgia;
    private Date data_hora;
    private int id_paciente;
    private int id_medico;
    private int id_sala;

    public Cirurgia(int id_cirurgia, Date data_hora, int id_paciente, int id_medico, int id_sala) {
        this.id_cirurgia = id_cirurgia;
        this.data_hora = data_hora;
        this.id_paciente = id_paciente;
        this.id_medico = id_medico;
        this.id_sala = id_sala;
    }

    public int getId_cirurgia() {
        return id_cirurgia;
    }

    public void setId_cirurgia(int id_cirurgia) {
        this.id_cirurgia = id_cirurgia;
    }

    public Date getData_hora() {
        return data_hora;
    }

    public void setData_hora(Date data_hora) {
        this.data_hora = data_hora;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public int getId_medico() {
        return id_medico;
    }

    public void setId_medico(int id_medico) {
        this.id_medico = id_medico;
    }

    public int getId_sala() {
        return id_sala;
    }

    public void setId_sala(int id_sala) {
        this.id_sala = id_sala;
    }

    @Override
    public String toString() {
        return "Cirurgia [id_cirurgia=" + id_cirurgia + ", data_hora=" + data_hora + ", id_paciente=" + id_paciente
                + ", id_medico=" + id_medico + ", id_sala=" + id_sala + "]";
    }

}
