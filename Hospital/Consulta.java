import java.util.Date;

public class Consulta {
    Date dia_hora;
    Medico medico;
    Paciente paciente;

    public Consulta(Date dia_hora, Medico medico, Paciente paciente) {
        this.dia_hora = dia_hora;
        this.medico = medico;
        this.paciente = paciente;
    }

    public Date getDia_hora() {
        return dia_hora;
    }

    public void setDia_hora(Date dia_hora) {
        this.dia_hora = dia_hora;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public String toString() {
        return "Consulta [dia_hora=" + dia_hora + ", medico=" + medico + ", paciente=" + paciente + "]";
    }

}
