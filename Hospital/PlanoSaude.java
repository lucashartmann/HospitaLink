public class PlanoSaude {
    private String nome;
    private int id_plano;
    private int id_paciente;

    public PlanoSaude(String nome, int id_plano, int id_paciente) {
        this.nome = nome;
        this.id_plano = id_plano;
        this.id_paciente = id_paciente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId_plano() {
        return id_plano;
    }

    public void setId_plano(int id_plano) {
        this.id_plano = id_plano;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    @Override
    public String toString() {
        return "PlanoSaude [nome=" + nome + ", id_plano=" + id_plano + ", id_paciente=" + id_paciente + "]";
    }

    
    
}
