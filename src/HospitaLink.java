import java.util.Scanner;

public class HospitaLink {

    Calendario calendario = new Calendario();
    Endereco endereco = new Endereco("Avenida Bento Gonçalves", 205, "90C", "Santo Antonio", "Soledade", "RS",
            "90650-001");
    Hospital clinicas = new Hospital("Clinicas", endereco);
    Scanner scanner = new Scanner(System.in);
    int option;

    public void executar() {
        menu();
    }

    public void menu() {
        System.out.println("\nDigite o número do procedimento desejado");
        System.out.println("1 -- Gerenciar consultas");
        System.out.println("2 -- Gerenciar pacientes");
        System.out.println("3 -- Gerenciar médicos");
        System.out.println("4 -- Ver Hospital");
        System.out.println("5 -- Sair do Menu ");
        option = scanner.nextInt();
        switch (option) {
            case 1:
                menuMedico();
                break;
            case 2:
                // gerenciar consultas
                menuConsulta();
                break;
            case 3:
                menuPaciente();
                break;
            case 4:
                // ver sistema do hospital
                verHospital();
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
        menu();
    }

    public void verHospital() {
        System.out.println(clinicas.toString());
    }

    public void menuConsulta() {
        String nome, num_documento, data_nascimento, data, hora_minuto, nomeMedico, nomePlano;
        int idade;
        char genero;
        Paciente paciente;
        Medico medico;
        Consulta consulta;
        PlanoSaude plano_saude;
        System.out.println("\nDigite o número da operação desejada");
        System.out.println("1 -- Marcar");
        System.out.println("2 -- Remarcar");
        System.out.println("3 -- Cancelar");
        System.out.println("4 -- Ver consultas");
        System.out.println("5 -- Ver quantidade de consultas");
        System.out.println("6 -- Sair do menu de consultas");
        option = scanner.nextInt();
        switch (option) {
            case 1:
                // Marcar consulta
                System.out.println("Digite o nome do paciente:");
                nome = scanner.next();
                System.out.println("Digite a idade do paciente");
                idade = scanner.nextInt();
                System.out.println("Digite o RG ou CPF do paciente:");
                num_documento = scanner.next();
                System.out.println("Digite o genero do paciente: (usando M ou F)");
                genero = scanner.next().charAt(0);
                System.out.println("Digite o data de nascimento do paciente: (formato ddmmuuuu)");
                data_nascimento = scanner.next();
                System.out.println("Digite o nome do plano de saúde do paciente: ");
                nomePlano = scanner.next();
                plano_saude = new PlanoSaude(nomePlano, 0);
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
                paciente = new Paciente(nome, idade, num_documento, genero, data_nascimento, plano_saude);
                plano_saude.setId_paciente(paciente.getId_paciente());
                consulta = new Consulta(paciente, medico, data, hora_minuto);
                clinicas.cadastrarConsultas(consulta);
                clinicas.cadastrarPacientes(paciente);
                System.out.println("Consulta marcada! " + consulta.toString());
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
                System.out.println("Consulta remarcada! " + consulta.toString());
                break;
            case 3:
                // cancelar consulta
                System.out.println("Digite o nome do paciente:");
                nome = scanner.next();
                paciente = clinicas.consultarPacientes(nome);
                consulta = clinicas.consultarAgenda(paciente);
                clinicas.removerConsultas(consulta);
                System.out.println("Consulta cancelada!");
                break;
            case 4:
                clinicas.listaConsultas();
                break;
            case 5:
                clinicas.getQuantidadeConsultas();
                break;
            case 6:
                break;
            default:
                System.out.println("Caracter inválido, tente novamente");
                break;
        }
        menuConsulta();
    }

    public void menuMedico() {
        String nome, especialidade, uf_crm;
        int num_crm;
        Medico medico;

        System.out.println("\nDigite o número da operação desejada");
        System.out.println("1 -- Cadastrar médico");
        System.out.println("2 -- Remover médico");
        System.out.println("3 -- Ver médicos");
        System.out.println("4 -- Ver quantidade de consultas");
        System.out.println("5 -- Sair do menu de médicos");
        option = scanner.nextInt();

        switch (option) {
            case 1:
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
                break;
            case 2:
                System.out.println("Digite o nome do médico");
                nome = scanner.next();
                medico = clinicas.consultarMedicos(nome);
                clinicas.removerMedicos(medico);
                break;
            case 3:
                clinicas.listaMedicos();
                break;
            case 4:
                clinicas.getQuantidadeMedicos();
                break;
            case 5:
                break;
            default:
                System.out.println("Caracter inválido, tente novamente");
                break;
        }
        menuMedico();

    }

    public void menuPaciente(){
        String nome, num_documento, data_nascimento, nomePlano;
        char genero;
        int idade;
        PlanoSaude plano_saude;
        Paciente paciente;
        System.out.println("\nDigite o número da operação desejada");
        System.out.println("1 -- Cadastrar paciente");
        System.out.println("2 -- Remover paciente");
        System.out.println("3 -- Ver pacientes");
        System.out.println("4 -- Ver quantidade de pacientes");
        System.out.println("5 -- Sair do menu de pacientes");
        option = scanner.nextInt();

        switch (option) {
            case 1:
                System.out.println("Digite o nome do paciente");
                nome = scanner.next();
                System.out.println("Digite a idade do paciente");
                idade = scanner.nextInt();
                System.out.println("Digite o RG ou CPF do paciente");
                num_documento = scanner.next();
                System.out.println("Digite o gênero do paciente (usando M ou F)");
                genero = scanner.next().charAt(0);
                System.out.println("Digite o data de nascimento do paciente: (formato ddmmuuuu)");
                data_nascimento = scanner.next();
                System.out.println("Digite o nome do plano de saúde do paciente: ");
                nomePlano = scanner.next();
                plano_saude = new PlanoSaude(nomePlano, 0);
                data_nascimento = calendario.formatarData(data_nascimento);
                paciente = new Paciente(nome, idade, num_documento, genero, data_nascimento, plano_saude);
                plano_saude.setId_paciente(paciente.getId_paciente());
                clinicas.cadastrarPacientes(paciente);
                break;
            case 2:
                System.out.println("Digite o nome do paciente");
                nome = scanner.next();
                paciente = clinicas.consultarPacientes(nome);
                clinicas.removerPacientes(paciente);
                break;
            case 3:
                clinicas.listaPacientes();
                break;
            case 4:
                clinicas.getQuantidadePacientes();
                break;
            case 5:
                break;
            default:
                System.out.println("Caracter inválido, tente novamente");
                break;
        }
        menuPaciente();

    }

}