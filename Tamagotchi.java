public class Tamagotchi {
    private String name;
    private int age;
    private int hunger;
    private int happiness;
    private int energy;
    private int hygiene;
    private int social;
    private int health;
    private String stage;
    private java.util.Random rand;

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
        rand = new java.util.Random();
    }

    public void feed() {
        System.out.println(name + " está comendo...");
        hunger -= 20;
        if (hunger < 0) hunger = 0;
        energy += 10;
        if (energy > 100) energy = 100;
        updateHealth();
    }

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

    public void sleep() {
        System.out.println(name + " está dormindo...");
        energy += 30;
        if (energy > 100) energy = 100;
        age++;
        updateStage();
        updateHealth();
    }

    public void clean() {
        System.out.println(name + " está se higienizando...");
        hygiene += 30;
        if (hygiene > 100) hygiene = 100;
        updateHealth();
    }

    public void socialize() {
        System.out.println(name + " está socializando...");
        social += 20;
        if (social > 100) social = 100;
        happiness += 10;
        if (happiness > 100) happiness = 100;
        updateHealth();
    }

    public void checkStatus() {
        System.out.println("------ Status de " + name + " ------");
        System.out.println("Fase: " + stage);
        System.out.println("Idade: " + age);
        System.out.println("Fome: " + hunger);
        System.out.println("Felicidade: " + happiness);
        System.out.println("Energia: " + energy);
        System.out.println("Higiene: " + hygiene);
        System.out.println("Social: " + social);
        System.out.println("Saúde: " + health);
        System.out.println("------------------------------");
    }

    public void passTime() {
        System.out.println("O tempo passou...");
        age++;
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
        updateStage();
        updateHealth();
    }

    public void randomEvent() {
        int chance = rand.nextInt(100);
        if (chance < 15) {
            int eventType = rand.nextInt(3);
            switch (eventType) {
                case 0:
                    System.out.println("Evento aleatório: Dia chuvoso. Energia diminuiu.");
                    energy -= 10;
                    if (energy < 0) energy = 0;
                    break;
                case 1:
                    System.out.println("Evento aleatório: " + name + " se machucou brincando. Saúde diminuiu.");
                    health -= 15;
                    if (health < 0) health = 0;
                    break;
                case 2:
                    System.out.println("Evento aleatório: Dia ensolarado. Felicidade aumentou.");
                    happiness += 10;
                    if (happiness > 100) happiness = 100;
                    break;
            }
            updateHealth();
        }
    }

    public void updateStage() {
        if (age < 3) {
            stage = "Bebê";
        } else if (age < 6) {
            stage = "Adolescente";
        } else {
            stage = "Adulto";
        }
    }

    public void updateHealth() {
        health = (energy + hygiene + happiness + social) / 4;
        if (hunger > 80) {
            health -= 10;
        }
        if (health > 100) health = 100;
        if (health < 0) health = 0;
    }

    public void checkHealth() {
        if (energy < 20 || hygiene < 20 || hunger > 80 || happiness < 20 || social < 20) {
            System.out.println("Atenção: " + name + " não está se sentindo bem. Cuide dele!");
        }
    }

    public boolean isDead() {
        return (health <= 0);
    }
}