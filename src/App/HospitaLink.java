package App;

import java.util.Scanner;

import Dados.Calendario;
import Dados.Endereco;
import Dados.Hospital;
import Dados.Paciente;
import Dados.Consulta;
import Dados.Medico;
import Dados.PlanoSaude;

public class HospitaLink {

    // Criar calendário que vai ser usado quando marcar consultas
    Calendario calendario = new Calendario();
    // Endereço do hospital
    Endereco endereco = new Endereco("Avenida Bento Gonçalves", 205, "90C", "Santo Antonio", "Soledade", "RS",
            "90650-001");
    Hospital clinicas = new Hospital("Clinicas", endereco);
    Scanner scanner = new Scanner(System.in);
    int option;

    public void executar() {
        menu();
    }

    public void menu() {
        System.out.println("\n ### MENU HOSPITAL ###");
        System.out.println("Digite o número do procedimento desejado");
        System.out.println("1 -- Gerenciar consultas");
        System.out.println("2 -- Gerenciar pacientes");
        System.out.println("3 -- Gerenciar médicos");
        System.out.println("4 -- Ver dados do hospital");
        System.out.println("5 -- Encerrar o programa");
        option = scanner.nextInt();
        switch (option) {
            case 1:
                // Gerenciar médicos
                menuMedico();
                break;
            case 2:
                // Gerenciar consultas
                menuConsulta();
                break;
            case 3:
                // Gerenciar Pacientes
                menuPaciente();
                break;
            case 4:
                // Ver dados do hospital
                verHospital();
                break;
            case 5:
                // Encerrar o programa
                System.out.println("Você escolheu encerrar o programa");
                System.exit(option);
                break;
            default:
                // Número digitado pelo usuário não corresponde á 1 ou 2 ou 3 ou 4 ou 5
                System.out.println("Caracter inválido, tente novamente");
                break;
        }
        // Loop do menu
        menu();
    }

    public void verHospital() {
        // Exibe na tela todos os dados do hospital (pacientes, médicos, consultas...)
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
        System.out.println("\n ### MENU CONSULTA ###");
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
                // Criar e cadastrar consulta no sistema
                System.out.println("\n ### Marcar Consulta ###");
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
                plano_saude = new PlanoSaude(nomePlano, 0, 12312312);
                System.out.println("Digite o nome do médico: ");
                nomeMedico = scanner.next();
                System.out.println("Digite a data (formato DiaMesAno 05072003)");
                data = scanner.next();
                System.out.println("Digite a hora e minuto (formato HoraMinuto 1230)");
                hora_minuto = scanner.next();
                // Formata a data inserida e o horário
                data_nascimento = calendario.formatarData(data_nascimento);
                data = calendario.formatarData(data);
                hora_minuto = calendario.formatarHora(hora_minuto);
                // Chama o médico escolhido cadastrado no hospital (sistema)
                medico = clinicas.consultarMedicos(nomeMedico);
                paciente = new Paciente(nome, idade, num_documento, genero, data_nascimento, plano_saude);
                consulta = new Consulta(paciente, medico, data, hora_minuto);
                // Cadastra os dados da consulta no sistema
                clinicas.cadastrarConsultas(consulta);
                // Cadastra o cliente/paciente no sistema
                clinicas.cadastrarPacientes(paciente);
                // Exibe os dados da consulta
                System.out.println("Consulta marcada! " + consulta.toString());
                break;
            case 2:
                // Remarcar consulta cadastrada no sistema
                System.out.println("\n ### Remarcar Consulta ###");
                System.out.println("Digite o nome do paciente:");
                nome = scanner.next();
                // Chama o paciente se estiver cadastrado no sistema
                paciente = clinicas.consultarPacientes(nome);
                // Chama a consulta se estiver cadastrada no sistema
                consulta = clinicas.consultarAgenda(paciente);
                System.out.println("Digite a nova data (formato DiaMesAno 05072003)");
                data = scanner.next();
                System.out.println("Digite a nova hora e minuto (formato HoraMinuto 1230)");
                hora_minuto = scanner.next();
                // Formata a data inserida e o horário
                data = calendario.formatarData(data);
                hora_minuto = calendario.formatarHora(hora_minuto);
                // Muda a data pré-existente da consulta para a nova data
                consulta.setData(data);
                consulta.setHora(hora_minuto);
                System.out.println("Consulta remarcada! " + consulta.toString());
                break;
            case 3:
                // Cancelar consulta cadastrada no sistema
                System.out.println("\n ### Cancelar Consulta ###");
                System.out.println("Digite o nome do paciente:");
                nome = scanner.next();
                // Chama o paciente pelo nome
                paciente = clinicas.consultarPacientes(nome);
                // Chama a consulta cadastrada pelo paciente
                consulta = clinicas.consultarAgenda(paciente);
                // Remove a consulta do sistema
                clinicas.removerConsultas(consulta);
                System.out.println("Consulta cancelada!");
                break;
            case 4:
                // Exibir dados de consultas cadastradas no sistema
                clinicas.listaConsultas();
                break;
            case 5:
                // Exibir quantidade de consultas cadastradas no sistema
                clinicas.getQuantidadeConsultas();
                break;
            case 6:
                // Sair do menu de consultas
                System.out.println("Saindo do menu de consultas...");
                break;
            default:
                // Número digitado pelo usuário não corresponde á 1 ou 2 ou 3 ou 4 ou 5 ou 6
                System.out.println("Caracter inválido, tente novamente");
                break;
        }
        // Loop do menu
        menuConsulta();
    }

    public void menuMedico() {
        String nome, especialidade, uf_crm;
        int num_crm;
        Medico medico;
        System.out.println("\n ### MENU MÉDICO ###");
        System.out.println("\nDigite o número da operação desejada");
        System.out.println("1 -- Cadastrar médico");
        System.out.println("2 -- Remover médico");
        System.out.println("3 -- Ver médicos");
        System.out.println("4 -- Ver quantidade de consultas");
        System.out.println("5 -- Sair do menu de médicos");
        option = scanner.nextInt(); // Ler número digitado pelo usuário

        switch (option) {
            case 1:
                // Cadastrar médicos no sistema
                System.out.println("\n ### Cadastro de Médico ###");
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
                // Remover médicos cadastrados no sistema
                System.out.println("\n ### Remoção de Médico ###");
                System.out.println("Digite o nome do médico");
                nome = scanner.next();
                // Chama o médico cadastrado no sistema pelo seu nome
                medico = clinicas.consultarMedicos(nome);
                // Remove o cadastro do médico no sistema
                clinicas.removerMedicos(medico);
                break;
            case 3:
                // Exibir dados dos médicos cadastrados no sistema
                clinicas.listaMedicos();
                break;
            case 4:
                // Exibir quantidade de médicos cadastrados no sistema
                clinicas.getQuantidadeMedicos();
                break;
            case 5:
                // Sair do menu do médico
                System.out.println("Saindo do menu de médico...");
                break;
            default:
                // Número digitado pelo usuário não corresponde á 1 ou 2 ou 3 ou 4 ou 5
                System.out.println("Caracter inválido, tente novamente");
                break;
        }
        // Loop menu
        menuMedico();
    }

    public void menuPaciente() {
        String nome, num_documento, data_nascimento, nomePlano;
        char genero;
        int idade;
        PlanoSaude plano_saude;
        Paciente paciente;
        System.out.println("\n ### MENU PACIENTE ###");
        System.out.println("\nDigite o número da operação desejada");
        System.out.println("1 -- Cadastrar paciente");
        System.out.println("2 -- Remover paciente");
        System.out.println("3 -- Ver pacientes");
        System.out.println("4 -- Ver quantidade de pacientes");
        System.out.println("5 -- Sair do menu de pacientes");
        option = scanner.nextInt();

        switch (option) {
            case 1:
                System.out.println("\n ### CADASTRO PACIENTE ###");
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
                plano_saude = new PlanoSaude(nomePlano, 0, 3123232);
                data_nascimento = calendario.formatarData(data_nascimento);
                paciente = new Paciente(nome, idade, num_documento, genero, data_nascimento, plano_saude);
                clinicas.cadastrarPacientes(paciente);
                break;
            case 2:
                System.out.println("\n ### REMOVER PACIENTE ###");
                System.out.println("Digite o nome do paciente");
                nome = scanner.next();
                paciente = clinicas.consultarPacientes(nome);
                clinicas.removerPacientes(paciente);
                break;
            case 3:
                // Exibe os dados de todos os pacientes cadastrados no sistema
                clinicas.listaPacientes();
                break;
            case 4:
                // Exibe a quantidade de pacientes cadastrados no sistema
                clinicas.getQuantidadePacientes();
                break;
            case 5:
                // Sai do menu dos pacientes
                System.out.println("Saindo do menu de pacientes...");
                break;
            default:
                // Número digitado pelo usuário não corresponde á 1 ou 2 ou 3 ou 4 ou 5
                System.out.println("Caracter inválido, tente novamente");
                break;
        }
        // Loop do menu
        menuPaciente();
    }
}