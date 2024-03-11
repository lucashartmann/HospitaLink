import java.util.Random;

public class Paciente {

    private int id_paciente;
    private String nome;
    private String num_documento;
    private char genero;
    private String data_nascimento;
    private int idade;
    private PlanoSaude plano_saude;

    public Paciente(String nome, int idade, String num_documento, char genero, String data_nascimento, PlanoSaude plano_saude) {
        this.nome = nome;
        this.idade = idade;
        this.num_documento = num_documento;
        this.genero = genero;
        this.data_nascimento = data_nascimento;
        this.plano_saude = plano_saude;
        this.id_paciente = gerarId_paciente();
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public int gerarId_paciente() {
        Random rand = new Random();
        for (int i = 0; i <=10; i++){
            id_paciente = rand.nextInt();
        } 
        return id_paciente;
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

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public PlanoSaude getPlano_saude() {
        return plano_saude;
    }

    public void setPlano_saude(PlanoSaude plano_saude) {
        this.plano_saude = plano_saude;
    }

    @Override
    public String toString() {
        return "Paciente [id_paciente=" + id_paciente + ", nome=" + nome + ", num_documento=" + num_documento
                + ", genero=" + genero + ", data_nascimento=" + data_nascimento + "]";
    }

}
