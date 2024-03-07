public class Medico {
    private String nome;
    private String especialidade;
    private int id_medico;
    private int num_crm;
    private int uf_crm;

    public Medico(String nome, String especialidade, int id_medico, int num_crm, int uf_crm) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.id_medico = id_medico;
        this.num_crm = num_crm;
        this.uf_crm = uf_crm;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public int getId_medico() {
        return id_medico;
    }

    public void setId_medico(int id_medico) {
        this.id_medico = id_medico;
    }

    public int getNum_crm() {
        return num_crm;
    }

    public void setNum_crm(int num_crm) {
        this.num_crm = num_crm;
    }

    public int getUf_crm() {
        return uf_crm;
    }

    public void setUf_crm(int uf_crm) {
        this.uf_crm = uf_crm;
    }

    @Override
    public String toString() {
        return "Medico [nome=" + nome + ", especialidade=" + especialidade + ", id_medico=" + id_medico + ", num_crm="
                + num_crm + ", uf_crm=" + uf_crm + "]";
    }

    

    
}
