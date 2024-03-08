public class Sala {
    private int id_sala;
    private int num_sala;
    private int ala;
    private int andar;
    private int metragem;

    public Sala(int id_sala, int num_sala, int ala, int andar, int metragem) {
        this.id_sala = id_sala;
        this.num_sala = num_sala;
        this.ala = ala;
        this.andar = andar;
        this.metragem = metragem;
    }

    public int getId_sala() {
        return id_sala;
    }

    public void setId_sala(int id_sala) {
        this.id_sala = id_sala;
    }

    public int getNum_sala() {
        return num_sala;
    }

    public void setNum_sala(int num_sala) {
        this.num_sala = num_sala;
    }

    public int getAla() {
        return ala;
    }

    public void setAla(int ala) {
        this.ala = ala;
    }

    public int getAndar() {
        return andar;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }

    public int getMetragem() {
        return metragem;
    }

    public void setMetragem(int metragem) {
        this.metragem = metragem;
    }

    @Override
    public String toString() {
        return "Sala [id_sala=" + id_sala + ", num_sala=" + num_sala + ", ala=" + ala + ", andar=" + andar
                + ", metragem=" + metragem + "]";
    }
    
}
