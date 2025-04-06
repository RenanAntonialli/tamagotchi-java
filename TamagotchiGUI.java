import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TamagotchiGUI extends JFrame {
    private Tamagotchi pet;
    private JTextArea statusArea;
    private JButton btnFeed, btnPlay, btnSleep, btnClean, btnSocialize, btnPassTime;

    public TamagotchiGUI() {
        // Solicita o nome do Tamagotchi ao usuário
        String name = JOptionPane.showInputDialog(this, "Digite o nome do seu Tamagotchi:");
        if (name == null || name.trim().isEmpty()) {
            name = "Tamagotchi";
        }
        pet = new Tamagotchi(name);
        initComponents();
        updateStatus();
    }

    private void initComponents() {
        setTitle("Tamagotchi Virtual");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Área para exibir o status do Tamagotchi
        statusArea = new JTextArea();
        statusArea.setEditable(false);
        statusArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        add(new JScrollPane(statusArea), BorderLayout.CENTER);

        // Painel de botões com layout em grade (2 linhas x 3 colunas)
        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new GridLayout(2, 3, 10, 10));

        btnFeed = new JButton("Alimentar");
        btnPlay = new JButton("Brincar");
        btnSleep = new JButton("Dormir");
        btnClean = new JButton("Higiene");
        btnSocialize = new JButton("Socializar");
        btnPassTime = new JButton("Avançar Tempo");

        panelButtons.add(btnFeed);
        panelButtons.add(btnPlay);
        panelButtons.add(btnSleep);
        panelButtons.add(btnClean);
        panelButtons.add(btnSocialize);
        panelButtons.add(btnPassTime);

        add(panelButtons, BorderLayout.SOUTH);

        // Ações dos botões
        btnFeed.addActionListener(e -> performAction(() -> pet.feed()));
        btnPlay.addActionListener(e -> performAction(() -> pet.play()));
        btnSleep.addActionListener(e -> performAction(() -> pet.sleep()));
        btnClean.addActionListener(e -> performAction(() -> pet.clean()));
        btnSocialize.addActionListener(e -> performAction(() -> pet.socialize()));
        btnPassTime.addActionListener(e -> performAction(() -> pet.passTime()));
    }

    // Método para executar uma ação e atualizar a interface
    private void performAction(Runnable action) {
        action.run();
        pet.randomEvent();
        pet.checkHealth();
        updateStatus();
        checkIfDead();
    }

    // Atualiza o texto da área de status
    private void updateStatus() {
        statusArea.setText(pet.getStatus());
    }

    // Verifica se o Tamagotchi morreu e, se sim, desabilita os botões
    private void checkIfDead() {
        if (pet.isDead()) {
            JOptionPane.showMessageDialog(this, "Infelizmente, seu Tamagotchi faleceu. Fim do jogo.",
                    "Fim de Jogo", JOptionPane.INFORMATION_MESSAGE);
            disableButtons();
        }
    }

    // Desabilita os botões para impedir novas ações
    private void disableButtons() {
        btnFeed.setEnabled(false);
        btnPlay.setEnabled(false);
        btnSleep.setEnabled(false);
        btnClean.setEnabled(false);
        btnSocialize.setEnabled(false);
        btnPassTime.setEnabled(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TamagotchiGUI().setVisible(true);
        });
    }
}