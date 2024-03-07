public class Paciente {
    
    private int id_paciente;
    private String nome;
    private String num_documento;
    private String genero;
    private String data_nascimento;

    public Paciente(String nome, String num_documento, String genero, String data_nascimento) {
        this.id_paciente = id_paciente;
        this.nome = nome;
        this.num_documento = num_documento;
        this.genero = genero;
        this.data_nascimento = data_nascimento;
    }



    public int getId_paciente() {
        return id_paciente;
    }
    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNum_documento() {
        return num_documento;
    }
    public void setNum_documento(String num_documento) {
        this.num_documento = num_documento;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getData_nascimento() {
        return data_nascimento;
    }
    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }



    @Override
    public String toString() {
        return "Paciente [id_paciente=" + id_paciente + ", nome=" + nome + ", num_documento=" + num_documento
                + ", genero=" + genero + ", data_nascimento=" + data_nascimento + "]";
    }

    

    
}
