import java.util.Scanner;

public class TamagotchiApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Bem-vindo ao Tamagotchi Virtual ===");
        System.out.print("Digite o nome do seu Tamagotchi: ");
        String nome = sc.nextLine();

        Tamagotchi pet = new Tamagotchi(nome);
        boolean sair = false;

        while (!sair) {
            System.out.println("\nEscolha uma ação:");
            System.out.println("1 - Alimentar");
            System.out.println("2 - Brincar");
            System.out.println("3 - Dormir");
            System.out.println("4 - Higiene");
            System.out.println("5 - Socializar");
            System.out.println("6 - Checar status");
            System.out.println("7 - Avançar tempo");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            int opcao = sc.nextInt();
            sc.nextLine();

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
                    pet.checkStatus();
                    break;
                case 7:
                    pet.passTime();
                    break;
                case 0:
                    sair = true;
                    continue;
                default:
                    System.out.println("Opção inválida!");
            }

            pet.randomEvent();
            pet.checkHealth();

            if (pet.isDead()) {
                System.out.println("Infelizmente, seu Tamagotchi faleceu. Fim do jogo.");
                sair = true;
            }
        }
        sc.close();
    }
}