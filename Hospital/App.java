import java.util.Scanner;

public class App {

    Calendario calendario = new Calendario();
    Endereco endereco = new Endereco("Avenida Bento Gonçalves", 205, "90C", "Santo Antonio", "Soledade", "RS",
            "90650-001");
    Hospital clinicas = new Hospital("Clinicas", endereco);
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        App app = new App();
        app.menu();
    }

    public void menu() {
        System.out.println("Digite o número do procedimento desejado");
        System.out.println("1 -- Modificar consulta");
        System.out.println("2 -- Ver hospital");
        System.out.println("3 -- Cadastrar médicos");
        System.out.println("4 -- ");
        System.out.println("5 -- Sair do Menu ");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                // gerenciar consultas
                consulta();
                break;
            case 2:
                // ver sistema do hospital
                verHospital();
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                // sair do menu
                System.out.println("Você escolheu sair do menu");
                System.exit(option);
                break;
            default:
                System.out.println("Caracter inválido, tente novamente");
                break;
        }
        scanner.close();
    }

    public void verHospital() {
        System.out.println(clinicas.toString());
    }

    public void consulta() {
        String nome, rg, genero, data_nascimento, data, hora_minuto, nomeMedico;
        Paciente paciente;
        Medico medico;
        Consulta consulta;
        System.out.println("Digite o número da operação desejada");
        System.out.println("1 -- Marcar");
        System.out.println("2 -- Remarcar");
        System.out.println("3 -- Cancelar");
        System.out.println("4 -- Sair");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                // Marcar consulta
                System.out.println("Digite o nome do paciente:");
                nome = scanner.next();
                System.out.println("Digite o RG do paciente:");
                rg = scanner.next();
                System.out.println("Digite o genero do paciente:");
                genero = scanner.next();
                System.out.println("Digite o data de nascimento do paciente: (formato ddmmuuuu)");
                data_nascimento = scanner.next();
                System.out.println("Digite o nome do médico: ");
                nomeMedico = scanner.next();
                System.out.println("Digite a data(formato ddmmuuuu)");
                data = scanner.next();
                System.out.println("Digite a hora e minuto (formato horaminuto)");
                hora_minuto = scanner.next();
                data_nascimento = calendario.formatarData(data_nascimento);
                data = calendario.formatarData(data);
                hora_minuto = calendario.formatarHora(hora_minuto);
                medico = clinicas.consultarMedicos(nomeMedico);
                paciente = new Paciente(nome, rg, genero, data_nascimento, null);
                consulta = new Consulta(paciente, medico, data, hora_minuto);
                clinicas.cadastrarConsultas(consulta);
                clinicas.cadastrarPacientes(paciente);
                System.out.println("Consulta marcada" + consulta.toString());
                break;
            case 2:
                // Remarcar consulta
                System.out.println("Digite o nome do paciente:");
                nome = scanner.next();
                paciente = clinicas.consultarPacientes(nome);
                consulta = clinicas.consultarAgenda(paciente);
                System.out.println("Digite a nova data(formato ddmmuuuu)");
                data = scanner.next();
                System.out.println("Digite a nova hora e minuto (formato horaminuto)");
                hora_minuto = scanner.next();
                data = calendario.formatarData(data);
                hora_minuto = calendario.formatarHora(hora_minuto);
                consulta.setData(data);
                consulta.setHora(hora_minuto);
                System.out.println("Consulta remarcada" + consulta.toString());
                break;
            case 3:
                // cancelar consulta
                System.out.println("Digite o nome do paciente:");
                nome = scanner.next();
                paciente = clinicas.consultarPacientes(nome);
                consulta = clinicas.consultarAgenda(paciente);
                clinicas.removerConsultas(consulta);
                System.out.println("Consulta cancelada");
                break;
            case 4:
                // sair do menu
                System.out.println("Você escolheu sair do menu");
                System.exit(option);
                break;
            default:
                System.out.println("Caracter inválido, tente novamente");
                break;
        }
        scanner.close();
    }

    public void cadastroMedicos() {
        String nome, especialidade, uf_crm;
        int num_crm;
        Medico medico;

        System.out.println("Digite o nome do médico");
        nome = scanner.next();
        System.out.println("Digite a especialidade do médico");
        especialidade = scanner.next();
        System.out.println("Digite o número do CRM");
        num_crm = scanner.nextInt();
        System.out.println("Digite o UF do CRM");
        uf_crm = scanner.next();
        medico = new Medico(nome, especialidade, num_crm, uf_crm);
        clinicas.cadastrarMedicos(medico);

    }

}