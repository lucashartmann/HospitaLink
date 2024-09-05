public class Material {
    private int id_material;
    private String nome;
    private double valor;

    public Material(int id_material, String nome, double valor) {
        this.id_material = id_material;
        this.nome = nome;
        this.valor = valor;
    }

    public int getId_material() {
        return id_material;
    }

    public void setId_material(int id_material) {
        this.id_material = id_material;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Material [id_material=" + id_material + ", nome=" + nome + ", valor=" + valor + "]";
    }

}
