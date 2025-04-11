import java.util.Scanner;

/**
 * Aplicação em modo console para depuração e testes do Tamagotchi.
 * Permite que o usuário execute ações manualmente e visualize os atributos do pet no terminal.
 */
public class TamagotchiApp {
    public static void main(String[] args) {
        // Cria um Scanner para ler a entrada do usuário
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Debug - Tamagotchi Virtual ===");
        System.out.print("Digite o nome do seu Tamagotchi: ");
        String nome = sc.nextLine();

        // Cria uma instância do Tamagotchi com o nome fornecido
        Tamagotchi pet = new Tamagotchi(nome);
        boolean sair = false;

        // Loop principal que permite o usuário escolher ações
        while (!sair) {
            // Mostra as opções do menu
            System.out.println("\nEscolha uma ação:");
            System.out.println("1 - Alimentar");
            System.out.println("2 - Brincar");
            System.out.println("3 - Dormir");
            System.out.println("4 - Higiene");
            System.out.println("5 - Socializar");
            System.out.println("6 - Checar status");
            System.out.println("7 - Avançar tempo (manual)");
            System.out.println("8 - Passar tempo automaticamente (debug: ciclo único com eventos)");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            int opcao = sc.nextInt();
            sc.nextLine(); // Limpa o buffer após ler a opção

            // Executa a ação escolhida
            switch (opcao) {
                case 1:
                    pet.feed();
                    break;
                case 2:
                    pet.play();
                    break;
                case 3:
                    pet.sleep();
                    break;
                case 4:
                    pet.clean();
                    break;
                case 5:
                    pet.socialize();
                    break;
                case 6:
                    // Nesta opção, apenas o status será impresso posteriormente.
                    break;
                case 7:
                    pet.passTime();
                    break;
                case 8:
                    // Passa o tempo e simula eventos aleatórios, além de checar a saúde.
                    pet.passTime();
                    pet.randomEvent();
                    pet.checkHealth();
                    break;
                case 0:
                    sair = true;
                    continue;
                default:
                    System.out.println("Opção inválida!");
            }

            // Após cada ação, executa um evento aleatório e atualiza avisos de saúde.
            pet.randomEvent();
            pet.checkHealth();

            // Imprime o status atualizado do Tamagotchi no console.
            System.out.println("------ Status de " + pet.getName() + " ------");
            System.out.println("Fase: " + pet.getStage());
            System.out.println("Idade: " + pet.getAge());
            System.out.println("Fome: " + pet.getHunger());
            System.out.println("Felicidade: " + pet.getHappiness());
            System.out.println("Energia: " + pet.getEnergy());
            System.out.println("Higiene: " + pet.getHygiene());
            System.out.println("Social: " + pet.getSocial());
            System.out.println("Saúde: " + pet.getHealth());
            System.out.println("------------------------------");

            // Se o pet "morreu", exibe uma mensagem e encerra o programa.
            if (pet.isDead()) {
                System.out.println("Infelizmente, seu Tamagotchi faleceu. Fim do debug.");
                sair = true;
            }
        }
        sc.close();
    }
}
