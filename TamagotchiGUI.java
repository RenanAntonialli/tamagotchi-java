import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Interface Gráfica para interação com o Tamagotchi.
 * Exibe informações do pet, barras de progresso para os atributos, área de log para mensagens e botões para executar ações.
 * Também atualiza a imagem do pet de acordo com a fase de vida ou se ele estiver morto.
 */
public class TamagotchiGUI extends JFrame {
    private Tamagotchi pet; // Instância do Tamagotchi
    // Componentes visuais para exibir os atributos
    private JProgressBar hungerBar, energyBar, happinessBar, hygieneBar, socialBar, healthBar;
    private JLabel stageLabel, ageLabel, nameLabel, imageLabel;
    // Área de log para exibição de mensagens de status
    private JTextArea logArea;
    // Timer para simular a passagem de tempo automaticamente
    private Timer timer;

    /**
     * Construtor que configura a janela, inicializa os componentes e inicia o timer.
     * @param petName Nome do Tamagotchi.
     */
    public TamagotchiGUI(String petName) {
        pet = new Tamagotchi(petName);
        setTitle("Tamagotchi Virtual - " + petName);
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();

        // Timer que executa a cada 10 segundos para simular o avanço do tempo
        timer = new Timer(10000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pet.passTime(); // Atualiza os atributos devido à passagem do tempo
                updateLog("O tempo passou...");
                String eventMsg = pet.randomEvent(); // Eventuais eventos aleatórios
                if (!eventMsg.isEmpty()) {
                    updateLog(eventMsg); // Registra a mensagem do evento no log
                }
                pet.checkHealth();
                updateStatus();
                checkIfDead();
            }
        });
        timer.start();
    }

    /**
     * Inicializa e organiza os componentes da interface gráfica.
     */
    private void initComponents() {
        // Painel superior para informações básicas do pet (nome, fase e idade).
        JPanel infoPanel = new JPanel(new FlowLayout());
        nameLabel = new JLabel("Nome: " + pet.getName());
        stageLabel = new JLabel("Fase: " + pet.getStage());
        ageLabel = new JLabel("Idade: " + pet.getAge());
        infoPanel.add(nameLabel);
        infoPanel.add(stageLabel);
        infoPanel.add(ageLabel);
        add(infoPanel, BorderLayout.NORTH);

        // Painel central para exibir a imagem do pet, status e log.
        JPanel centerPanel = new JPanel(new BorderLayout());

        // Painel de exibição com a imagem do pet.
        JPanel displayPanel = new JPanel(new BorderLayout());
        imageLabel = new JLabel("", SwingConstants.CENTER);
        updateImage(); // Define a imagem inicial com base na fase atual.
        displayPanel.add(imageLabel, BorderLayout.NORTH);

        // Painel de status com barras de progresso para cada atributo.
        JPanel statusPanel = new JPanel(new GridLayout(6, 2, 5, 5));
        statusPanel.add(new JLabel("Fome:"));
        hungerBar = new JProgressBar(0, 100);
        statusPanel.add(hungerBar);

        statusPanel.add(new JLabel("Energia:"));
        energyBar = new JProgressBar(0, 100);
        statusPanel.add(energyBar);

        statusPanel.add(new JLabel("Felicidade:"));
        happinessBar = new JProgressBar(0, 100);
        statusPanel.add(happinessBar);

        statusPanel.add(new JLabel("Higiene:"));
        hygieneBar = new JProgressBar(0, 100);
        statusPanel.add(hygieneBar);

        statusPanel.add(new JLabel("Social:"));
        socialBar = new JProgressBar(0, 100);
        statusPanel.add(socialBar);

        statusPanel.add(new JLabel("Saúde:"));
        healthBar = new JProgressBar(0, 100);
        statusPanel.add(healthBar);

        displayPanel.add(statusPanel, BorderLayout.CENTER);
        centerPanel.add(displayPanel, BorderLayout.NORTH);

        // Área de log para mostrar mensagens de status e eventos.
        logArea = new JTextArea(8, 50);
        logArea.setEditable(false);
        logArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane logScrollPane = new JScrollPane(logArea);
        centerPanel.add(logScrollPane, BorderLayout.SOUTH);

        add(centerPanel, BorderLayout.CENTER);

        // Painel inferior contendo os botões de ação.
        JPanel buttonPanel = new JPanel(new GridLayout(1, 5, 5, 5));
        JButton feedButton = new JButton("Alimentar");
        feedButton.addActionListener(e -> {
            updateLog(pet.getName() + " está comendo...");
            pet.feed();
            String eventMsg = pet.randomEvent();
            if (!eventMsg.isEmpty()) {
                updateLog(eventMsg);
            }
            pet.checkHealth();
            updateStatus();
            checkIfDead();
        });

        JButton playButton = new JButton("Brincar");
        playButton.addActionListener(e -> {
            updateLog(pet.getName() + " está brincando...");
            pet.play();
            String eventMsg = pet.randomEvent();
            if (!eventMsg.isEmpty()) {
                updateLog(eventMsg);
            }
            pet.checkHealth();
            updateStatus();
            checkIfDead();
        });

        JButton sleepButton = new JButton("Dormir");
        sleepButton.addActionListener(e -> {
            updateLog(pet.getName() + " está dormindo...");
            pet.sleep();
            String eventMsg = pet.randomEvent();
            if (!eventMsg.isEmpty()) {
                updateLog(eventMsg);
            }
            pet.checkHealth();
            updateStatus();
            checkIfDead();
        });

        JButton cleanButton = new JButton("Higiene");
        cleanButton.addActionListener(e -> {
            updateLog(pet.getName() + " está se higienizando...");
            pet.clean();
            String eventMsg = pet.randomEvent();
            if (!eventMsg.isEmpty()) {
                updateLog(eventMsg);
            }
            pet.checkHealth();
            updateStatus();
            checkIfDead();
        });

        JButton socializeButton = new JButton("Socializar");
        socializeButton.addActionListener(e -> {
            updateLog(pet.getName() + " está socializando...");
            pet.socialize();
            String eventMsg = pet.randomEvent();
            if (!eventMsg.isEmpty()) {
                updateLog(eventMsg);
            }
            pet.checkHealth();
            updateStatus();
            checkIfDead();
        });

        buttonPanel.add(feedButton);
        buttonPanel.add(playButton);
        buttonPanel.add(sleepButton);
        buttonPanel.add(cleanButton);
        buttonPanel.add(socializeButton);

        add(buttonPanel, BorderLayout.SOUTH);

        updateStatus(); // Atualiza os indicadores iniciais.
    }

    /**
     * Atualiza os valores dos componentes visuais (barras de progresso e labels) com base no estado atual do Tamagotchi.
     */
    private void updateStatus() {
        hungerBar.setValue(pet.getHunger());
        energyBar.setValue(pet.getEnergy());
        happinessBar.setValue(pet.getHappiness());
        hygieneBar.setValue(pet.getHygiene());
        socialBar.setValue(pet.getSocial());
        healthBar.setValue(pet.getHealth());
        stageLabel.setText("Fase: " + pet.getStage());
        ageLabel.setText("Idade: " + pet.getAge());
        updateImage(); // Atualiza a imagem conforme a fase ou condição do pet.
    }

    /**
     * Atualiza a imagem exibida de acordo com a fase de vida do Tamagotchi ou se ele estiver morto.
     * Se o pet estiver morto, carrega "morto.png"; do contrário, utiliza imagens específicas conforme a fase.
     */
    private void updateImage() {
        String imagePath = "";
        if (pet.isDead()){
            imagePath = "morto.png";
        } else {
            switch (pet.getStage()) {
                case "Bebê":
                    imagePath = "bebe.png";
                    break;
                case "Criança":
                    imagePath = "crianca.png";
                    break;
                case "Adolescente":
                    imagePath = "adolescente.png";
                    break;
                case "Adulto":
                    imagePath = "adulto.png";
                    break;
                default:
                    imagePath = "tamagotchi.png"; // Imagem fallback, se nenhuma fase corresponder.
            }
        }
        ImageIcon icon = new ImageIcon(imagePath);
        // Redimensiona a imagem para caber no display
        Image img = icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(img));
        imageLabel.setText(""); // Remove texto caso esteja definido.
    }

    /**
     * Atualiza a área de log adicionando novas mensagens.
     * Cada mensagem é acrescentada à área para que o usuário veja um histórico.
     * @param message A mensagem a ser adicionada.
     */
    private void updateLog(String message) {
        logArea.append(message + "\n");
        // Faz o log rolar automaticamente para a última mensagem inserida.
        logArea.setCaretPosition(logArea.getDocument().getLength());
    }

    /**
     * Verifica se o Tamagotchi está morto.
     * Se estiver, para o timer, atualiza a imagem para a do pet morto, exibe mensagem no log e encerra o jogo.
     */
    private void checkIfDead() {
        if (pet.isDead()) {
            timer.stop();
            updateImage(); // Garante que a imagem do pet morto seja exibida.
            updateLog("Infelizmente, " + pet.getName() + " faleceu. O jogo será encerrado.");
            JOptionPane.showMessageDialog(this, "Infelizmente, seu Tamagotchi faleceu. O jogo será encerrado.");
            System.exit(0);
        }
    }

    /**
     * Método principal que inicia a aplicação gráfica.
     * Solicita o nome do pet por meio de uma caixa de diálogo.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            String name = JOptionPane.showInputDialog("Digite o nome do seu Tamagotchi:");
            if (name == null || name.trim().isEmpty()) {
                name = "Tamagotchi";
            }
            new TamagotchiGUI(name).setVisible(true);
        });
    }
}
