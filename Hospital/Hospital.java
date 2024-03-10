import java.util.ArrayList;
import java.util.Random;

public class Hospital {
    private String nome;
    private int id_hospital;
    private Endereco endereco_hospital;
    private Medico medico;
    private Paciente paciente;
    private Consulta consulta;

    private ArrayList<Medico> junta;
    private ArrayList<Paciente> multidao;
    private ArrayList<Consulta> agenda;

    public Hospital(String nome, Endereco endereco_hospital) {
        junta = new ArrayList<>();
        multidao = new ArrayList<>();
        agenda = new ArrayList<>();
        this.nome = nome;
        this.endereco_hospital = endereco_hospital;
    }

    public void cadastrarConsultas(Consulta consulta) {
        agenda.add(consulta);
    }

    public void removerConsultas(Consulta consulta) {
        agenda.remove(consulta);
    }

    public Consulta consultarAgenda(Paciente paciente) {
        if (!agenda.isEmpty()) {
            for (int i = 0; i <= multidao.size(); i++) {
                Consulta consulta = agenda.get(i);
                if (consulta.getPaciente().equals(paciente)) {
                    return consulta;
                }
            }
            return consulta;
        } else {
            return null;
        }
    }

    public void cadastrarPacientes(Paciente paciente) {
        multidao.add(paciente);
    }

    public void removerPacientes(Paciente paciente) {
        multidao.remove(paciente);
    }

    public Paciente consultarPacientes(String nome) {
        if (!multidao.isEmpty()) {
            for (int i = 0; i <= multidao.size(); i++) {
                Paciente paciente = multidao.get(i);
                if (paciente.getNome().equals(nome)) {
                    return paciente;
                }
            }
            return paciente;
        } else {
            return null;
        }
    }

    public void cadastrarMedicos(Medico medico) {
        junta.add(medico);
    }

    public void removerMedicos(Medico medico) {
        junta.remove(medico);
    }

    public Medico consultarMedicos(String nome) {
        if (!junta.isEmpty()) {
            for (int i = 0; i <= junta.size(); i++) {
                Medico medico = junta.get(i);
                if (medico.getNome().equals(nome)) {
                    return medico;
                }
            }
            return medico;
        } else {
            return null;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int id_hospital() {
        Random rand = new Random();
        int id_hospital = 0;
        for (int i = 0; i <= 10; i++) {
            id_hospital = rand.nextInt();
        }
        return id_hospital;
    }

    public Endereco getEndereco_hospital() {
        return endereco_hospital;
    }

    public void setEndereco_hospital(Endereco endereco_hospital) {
        this.endereco_hospital = endereco_hospital;
    }

    @Override
    public String toString() {
        return "Hospital [nome=" + nome + ", id_hospital=" + id_hospital + ", endereco_hospital=" + endereco_hospital
                + ", medico=" + medico + ", paciente=" + paciente + ", consulta=" + consulta + ", junta=" + junta
                + ", multidao=" + multidao + ", agenda=" + agenda + "]";
    }

}
