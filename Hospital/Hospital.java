import java.util.ArrayList;
import java.util.Random;

public class Hospital {
    private String nome;
    private int id_hospital;
    private Endereco endereco_hospital;
    private Medico medico;
    private Paciente paciente;
    private Consulta consulta;
    private int quantidadeConsultas;
    private int quantidadeMedicos;
    private int quantidadePacientes;


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
        if (!agenda.contains(consulta)) {
            agenda.add(consulta);
            quantidadeConsultas++;
            System.out.println("Consulta adicionada");
        } else {
            System.out.println("A consulta já está na agenda");
        }
    }

    public void removerConsultas(Consulta consulta) {
        if (agenda.isEmpty()) {
            System.out.println("A agenda está vazia");
        } else if (!agenda.contains(consulta)) {
            System.out.println("A consulta não está na agenda");
        } else {
            agenda.remove(consulta);
            quantidadeConsultas--;
            System.out.println("Consulta removida");
        }
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

    public void listaConsultas(){
        System.out.println("-- Lista de consultas --");
        for(Consulta a: agenda){
            a.toString();
        }
    }
    public void listaPacientes(){
        System.out.println("-- Lista de pacientes --");
        for(Paciente a: multidao){
            a.toString();
        }
    }
    public void listaMedicos(){
        System.out.println("-- Lista de médicos --");
        for(Medico a: junta){
            a.toString();
        }
    }


    public int getQuantidadeConsultas() {
        return quantidadeConsultas;
    }

    public int getQuantidadeMedicos() {
        return quantidadeMedicos;
    }

    public int getQuantidadePacientes() {
        return quantidadePacientes;
    }

    public void cadastrarPacientes(Paciente paciente) {
        if (!multidao.contains(paciente)) {
            multidao.add(paciente);
            quantidadePacientes++;
            System.out.println("Paciente adicionado");
        } else {
            System.out.println("O paciente já está cadastrado");
        }
    }

    public void removerPacientes(Paciente paciente) {
        if (multidao.isEmpty()) {
            System.out.println("A lista de pacientes está vazia");
        } else if (!multidao.contains(paciente)) {
            System.out.println("O paciente não está cadastrado");
        } else {
            multidao.remove(paciente);
            quantidadePacientes--;
            System.out.println("Paciente removido");
        }
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
        if (!junta.contains(medico)) {
            junta.add(medico);
            quantidadeMedicos++;
            System.out.println("Médico adicionado");
        } else {
            System.out.println("Médico já cadastrado");
        }
    }

    public void removerMedicos(Medico medico) {
        if (junta.isEmpty()) {
            System.out.println("A lista de médicos está vazia");
        } else if (!junta.contains(medico)) {
            System.out.println("O médico não está cadastrado");
        } else {
            junta.remove(medico);
            quantidadeMedicos--;
            System.out.println("Médico removido");
        }
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
