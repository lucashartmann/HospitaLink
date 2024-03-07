import java.util.Scanner;

public class App {

    Endereco endereco = new Endereco("Avenida Bento Gonçalves", 205, "90C", "Santo Antonio", "Soledade", "RS", "90650-001");
    Hospital clinicas = new Hospital("Clinicas", endereco);
    Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args){
        App app = new App();
        app.menu();
    }

    public void menu(){
        System.out.println("Digite o número do procedimento");
        System.out.println("1 -- Modificar consulta");
        System.out.println("2 -- Ver hospital");
        System.out.println("3 -- ");
        System.out.println("4 -- ");
        System.out.println("5 -- Sair do Menu ");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                consulta();
                break;
            case 2: 
                verHospital();
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                System.exit(option);
                break;
            default:
                break;
        }

    }

    public void verHospital(){
       System.out.println(clinicas.toString());
    }

    public void consulta(){
        String nome, rg, genero, data_nascimento;
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
                System.out.println("Digite o nome do paciente:");
                nome = scanner.next();
                System.out.println("Digite o RG do paciente:");
                rg = scanner.next();
                System.out.println("Digite o genero do paciente:");
                genero = scanner.next();
                System.out.println("Digite o data de nascimento do paciente:");
                data_nascimento = scanner.next();
                paciente = new Paciente(nome, rg, genero, data_nascimento);
                System.out.println("Digite o nome do médico: ");
                nome = scanner.next();
                medico = clinicas.consultarMedicos(nome);
                consulta = new Consulta(null, medico, paciente);
                break;  
            case 2:
                System.out.println("Digite o nome do paciente:");
                nome = scanner.next();
                paciente = clinicas.consultarPacientes(nome);
                consulta = clinicas.consultarAgenda(paciente);
                System.out.println("Digite novo dia");
                System.out.println("Digite novo mes");
                System.out.println("Digite nova hora");
                System.out.println("Digite novo minutos");
                break;
            case 3: 
                break;
            case 4:
                System.exit(option);
            default:
                break;
        }
    }

}