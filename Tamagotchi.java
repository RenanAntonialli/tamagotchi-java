/**
 * Classe que representa o Tamagotchi - um pet virtual com atributos que simulam seu estado.
 * Possui métodos para modificar os atributos por meio de ações (alimentar, brincar, dormir, etc.),
 * atualizar a fase de vida e calcular a saúde com base em suas necessidades.
 */
public class Tamagotchi {
    // Atributos básicos do Tamagotchi.
    private String name;      // Nome do pet.
    private int age;          // Idade (usada para determinar a fase de vida).
    private int hunger;       // Nível de fome (0 a 100).
    private int happiness;    // Nível de felicidade (0 a 100).
    private int energy;       // Nível de energia (0 a 100).
    private int hygiene;      // Nível de higiene (0 a 100).
    private int social;       // Nível de socialização (0 a 100).
    private int health;       // Saúde geral, calculada a partir dos outros atributos.
    private String stage;     // Fase de vida do pet (Bebê, Criança, Adolescente ou Adulto).
    private java.util.Random rand; // Gerador de números aleatórios para eventos.

    /**
     * Construtor que inicializa os atributos com valores padrão.
     * @param name Nome do Tamagotchi.
     */
    public Tamagotchi(String name) {
        this.name = name;
        this.age = 0;
        this.hunger = 50;
        this.happiness = 50;
        this.energy = 50;
        this.hygiene = 50;
        this.social = 50;
        this.health = 100;
        this.stage = "Bebê";
        rand = new java.util.Random(); // Inicializa o gerador de eventos aleatórios.
    }

    // Métodos getters para permitir acesso aos atributos.
    public String getName() { return name; }
    public int getAge() { return age; }
    public int getHunger() { return hunger; }
    public int getHappiness() { return happiness; }
    public int getEnergy() { return energy; }
    public int getHygiene() { return hygiene; }
    public int getSocial() { return social; }
    public int getHealth() { return health; }
    public String getStage() { return stage; }

    /**
     * Método que simula a ação de alimentar o pet.
     * Reduz o nível de fome e aumenta a energia.
     */
    public void feed() {
        System.out.println(name + " está comendo...");
        hunger -= 20;            // Reduz a fome.
        if (hunger < 0) hunger = 0; // Impede que o valor fique negativo.
        energy += 10;            // Aumenta a energia.
        if (energy > 100) energy = 100; // Limita o valor máximo.
        updateHealth();          // Atualiza a saúde com base nos novos valores.
    }

    /**
     * Método que simula a ação de brincar.
     * Aumenta a felicidade e socialização, mas diminui a energia e aumenta a fome.
     */
    public void play() {
        System.out.println(name + " está brincando...");
        happiness += 20;
        if (happiness > 100) happiness = 100;
        energy -= 15;
        hunger += 10;
        social += 15;
        if (energy < 0) energy = 0;
        if (hunger > 100) hunger = 100;
        if (social > 100) social = 100;
        updateHealth();
    }

    /**
     * Método que simula o sono.
     * Aumenta a energia e incrementa a idade, podendo alterar a fase de vida.
     */
    public void sleep() {
        System.out.println(name + " está dormindo...");
        energy += 30;
        if (energy > 100) energy = 100;
        age++;                  // Incrementa a idade.
        updateStage();          // Atualiza a fase (Bebê, Criança, etc.) com base na idade.
        updateHealth();
    }

    /**
     * Método para simular o cuidado com a higiene.
     * Aumenta o nível de higiene.
     */
    public void clean() {
        System.out.println(name + " está se higienizando...");
        hygiene += 30;
        if (hygiene > 100) hygiene = 100;
        updateHealth();
    }

    /**
     * Método que simula a socialização.
     * Aumenta os níveis de socialização e felicidade.
     */
    public void socialize() {
        System.out.println(name + " está socializando...");
        social += 20;
        if (social > 100) social = 100;
        happiness += 10;
        if (happiness > 100) happiness = 100;
        updateHealth();
    }

    /**
     * Método que simula a passagem do tempo.
     * Incrementa a idade e altera os atributos para refletir a necessidade contínua do pet.
     */
    public void passTime() {
        System.out.println("O tempo passou...");
        age++;              // Passa um "dia" ou unidade de tempo.
        hunger += 10;
        energy -= 10;
        hygiene -= 10;
        social -= 5;
        happiness -= 5;
        if (hunger > 100) hunger = 100;
        if (energy < 0) energy = 0;
        if (hygiene < 0) hygiene = 0;
        if (social < 0) social = 0;
        if (happiness < 0) happiness = 0;
        updateStage();      // Verifica se a mudança na idade altera a fase.
        updateHealth();     // Atualiza a saúde com base nos novos valores.
    }

    /**
     * Método que simula um evento aleatório, retornando uma mensagem que será exibida na GUI.
     * Pode ocorrer um evento que afeta energia, saúde ou felicidade.
     * @return mensagem descrevendo o evento ocorrido, ou string vazia caso nenhum evento ocorra.
     */
    public String randomEvent() {
        int chance = rand.nextInt(100);
        String message = "";
        if (chance < 15) { // 15% de chance de ocorrer um evento.
            int eventType = rand.nextInt(3);
            switch (eventType) {
                case 0:
                    message = "Evento: Dia chuvoso. Energia diminuiu.";
                    energy -= 10;
                    if (energy < 0) energy = 0;
                    break;
                case 1:
                    message = "Evento: " + name + " se machucou brincando. Saúde diminuiu.";
                    health -= 15;
                    if (health < 0) health = 0;
                    break;
                case 2:
                    message = "Evento: Dia ensolarado. Felicidade aumentou.";
                    happiness += 10;
                    if (happiness > 100) happiness = 100;
                    break;
            }
            updateHealth();
        }
        return message;
    }

    /**
     * Atualiza a fase de vida do Tamagotchi com base na sua idade.
     * Fases: Bebê (< 3), Criança (3 a 11), Adolescente (12 a 17), Adulto (18 ou mais).
     */
    public void updateStage() {
        if (age < 3) {
            stage = "Bebê";
        } else if (age < 12) {
            stage = "Criança";
        } else if (age < 18) {
            stage = "Adolescente";
        } else {
            stage = "Adulto";
        }
    }

    /**
     * Calcula a saúde do Tamagotchi com base na média dos atributos importantes.
     * Se o nível de fome estiver acima de 80, a saúde diminui.
     */
    public void updateHealth() {
        health = (energy + hygiene + happiness + social) / 4;
        if (hunger > 80) {
            health -= 10;
        }
        if (health > 100) health = 100;
        if (health < 0) health = 0;
    }

    /**
     * Verifica se algum atributo crítico está em níveis perigosos e imprime uma mensagem de alerta.
     */
    public void checkHealth() {
        if (energy < 20 || hygiene < 20 || hunger > 80 || happiness < 20 || social < 20) {
            System.out.println("Atenção: " + name + " não está se sentindo bem. Cuide dele!");
        }
    }

    /**
     * Retorna true se a saúde estiver em zero ou abaixo, indicando que o Tamagotchi "morreu".
     */
    public boolean isDead() {
        return (health <= 0);
    }
}
