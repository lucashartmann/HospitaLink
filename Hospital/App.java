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
        System.out.println("Digite o número do procedimento");
        System.out.println("1 -- Modificar consulta");
        System.out.println("2 -- Ver hospital");
        System.out.println("3 -- ");
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
    }

    public void verHospital() {
        System.out.println(clinicas.toString());
    }

    public void consulta() {
        String nome, rg, genero, data_nascimento, data, hora_minuto;
        Paciente paciente;
        Medico medico;
        Consulta consulta;
        System.out.println("Selecione a opção da operação");
        System.out.println("Marcar");
        System.out.println("Remarcar");
        System.out.println("Cancelar");
        System.out.println("Sair");
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
                System.out.println("Digite o data de nascimento do paciente:");
                data_nascimento = scanner.next();
                System.out.println("Digite o nome do médico: ");
                nome = scanner.next();
                System.out.println("Digite a data(formato ddmmuuuu)");
                data = scanner.next();
                System.out.println("Digite a hora e minuto (formato horaminuto)");
                hora_minuto = scanner.next();
                data = calendario.formatarData(data);
                hora_minuto = calendario.formatarHora(hora_minuto);
                medico = clinicas.consultarMedicos(nome);
                paciente = new Paciente(nome, rg, genero, data_nascimento);
                consulta = new Consulta(paciente, medico, data, hora_minuto);
                System.out.println("Consulta marcada");
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
                medico = consulta.getMedico();
                data = calendario.formatarData(data);
                hora_minuto = calendario.formatarHora(hora_minuto);
                consulta = new Consulta(paciente, medico, data, hora_minuto);
                System.out.println("Consulta remarcada");
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
    }

}