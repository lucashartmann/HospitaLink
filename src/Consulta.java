public class Consulta {

    String hora;
    String data;
    Medico medico;
    Paciente paciente;

    public Consulta(Paciente paciente, Medico medico, String data, String hora) {
        this.data = data;
        this.hora = hora;
        this.medico = medico;
        this.paciente = paciente;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
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
        return "Consulta [hora=" + hora + ", data=" + data + ", medico=" + medico + ", paciente=" + paciente + "]";
    }

}
