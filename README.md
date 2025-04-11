# Projeto Tamagotchi Virtual

Este projeto simula um Tamagotchi – um pet virtual que o usuário deve cuidar por meio de ações como alimentar, brincar, dormir, higienizar e socializar. O sistema foi desenvolvido em Java, utilizando os conceitos de Programação Orientada a Objetos e uma interface gráfica baseada em Swing para proporcionar uma experiência interativa e realista.

---

## Sumário

- [Visão Geral do Projeto](#visão-geral-do-projeto)
- [Estrutura do Código](#estrutura-do-código)
- [Funcionalidades](#funcionalidades)
- [Decisões de Projeto](#decisões-de-projeto)
- [Como Executar](#como-executar)
- [Possíveis Melhorias](#possíveis-melhorias)

---

## Visão Geral do Projeto

O projeto simula um Tamagotchi real, onde o pet virtual possui diversos atributos (como fome, energia, felicidade, higiene, social e saúde) que variam de 0 a 100. O comportamento do pet é afetado por ações realizadas pelo usuário e pela passagem do tempo. A interface gráfica apresenta:

- **Imagens Dinâmicas:** Diferentes imagens (em formato .png) são exibidas conforme a fase de vida do pet:
  - Bebê (idade < 3)
  - Criança (idade de 3 a 11)
  - Adolescente (idade de 12 a 17)
  - Adulto (idade ≥ 18)
  - Uma imagem específica é exibida quando o pet morre.
- **Área de Log:** Exibe mensagens de status e eventos, oferecendo feedback textual sobre as ações e ocorrências no sistema.
- **Barras de Progresso:** Indicam visualmente os níveis atuais dos atributos do pet.
- **Timer Automático:** A cada 10 segundos, o sistema simula a passagem do tempo, atualizando automaticamente os valores dos atributos e gerando eventos aleatórios.

---

## Estrutura do Código

O projeto está dividido em três arquivos principais:

1. **Tamagotchi.java**  
   - **Função:** Encapsula a lógica do pet virtual, definindo atributos como nome, idade, fome, energia, higiene, social, felicidade, saúde e fase de vida.
   - **Principais Métodos:**
     - Ações: `feed()`, `play()`, `sleep()`, `clean()`, `socialize()`
     - Simulação de tempo: `passTime()`
     - Eventos aleatórios: `randomEvent()`
     - Atualização: `updateStage()`, `updateHealth()`
     - Verificação do estado: `checkHealth()`, `isDead()`

2. **TamagotchiApp.java**  
   - **Função:** Fornece uma interface de linha de comando para testes e depuração do comportamento do pet, permitindo ações manuais e a visualização dos atributos no terminal.

3. **TamagotchiGUI.java**  
   - **Função:** Implementa a interface gráfica utilizando Swing.
   - **Componentes Principais:**
     - **Painel de Informações:** Exibe nome, fase e idade do pet.
     - **Display de Imagem:** Atualizado dinamicamente conforme a fase ou se o pet estiver morto.
     - **Barras de Progresso:** Para os atributos (fome, energia, felicidade, higiene, social, saúde).
     - **Área de Log:** Mostra mensagens e eventos em tempo real.
     - **Botões de Ação:** Permitem ao usuário interagir com o pet (alimentar, brincar, dormir, higiene e socialização).
     - **Timer:** Simula a passagem do tempo e aciona atualizações automáticas.

---

## Funcionalidades

- **Interação Manual:**  
  O usuário pode interagir com o pet por meio de ações que alteram seus atributos.
  
- **Passagem do Tempo:**  
  O sistema simula a passagem do tempo, modificando os atributos automaticamente ou através do modo de depuração manual.

- **Eventos Aleatórios:**  
  Eventos que afetam atributos (como dias chuvosos ou ensolarados) são gerados com uma probabilidade definida, adicionando imprevisibilidade ao comportamento do pet.

- **Feedback Visual e Textual:**  
  - **Barras de Progresso:** Indicadores visuais para os atributos.
  - **Área de Log:** Mensagens de status e eventos são exibidas para dar feedback ao usuário.
  - **Imagens Dinâmicas:** A interface exibe imagens que refletem a fase de vida atual do pet ou sua condição (vivo ou morto).

---

## Decisões de Projeto

- **Separação entre Lógica e Interface:**  
  A lógica do pet foi isolada na classe `Tamagotchi.java`, enquanto as interfaces (console e GUI) estão separadas, permitindo fácil manutenção e expansão do projeto.
  
- **Atualização Automática via Timer:**  
  Um `javax.swing.Timer` foi utilizado na GUI para simular a passagem do tempo, garantindo que o pet atualize seus atributos e gere eventos aleatórios periodicamente sem intervenção do usuário.

- **Uso de Imagens Dinâmicas:**  
  A decisão de utilizar diferentes imagens para cada fase de vida e um estado específico de "morte" visa enriquecer a experiência do usuário, aproximando a interface da experiência oferecida pelos dispositivos Tamagotchi originais.

- **Feedback Imediato:**  
  A implementação de uma área de log na GUI para exibir mensagens de status e eventos proporciona uma visão clara do que está ocorrendo na simulação, facilitando a interação e o debug.

---

## Como Executar

### Pré-requisitos

- **Java Development Kit (JDK):** Certifique-se de ter o JDK instalado em sua máquina.
- **Imagens Necessárias:**  
  Coloque os arquivos de imagem na mesma pasta do projeto:
  - `bebe.png`
  - `crianca.png`
  - `adolescente.png`
  - `adulto.png`
  - `morto.png`

### Compilação e Execução

1. **Para o modo GUI:**

   No terminal, navegue até o diretório do projeto e execute:

   ```bash
   javac Tamagotchi.java TamagotchiGUI.java
   java TamagotchiGUI
   ```

2. **Para o modo Console (Depuração):**

   Compile e execute:

   ```bash
   javac Tamagotchi.java TamagotchiApp.java
   java TamagotchiApp
   ```

---

## Possíveis Melhorias

- Adicionar sons e animações para enriquecer a experiência.
- Implementar um sistema de persistência para salvar o estado do pet.
- Criar mini-jogos que interajam com os atributos do Tamagotchi.
- Expandir as funcionalidades da interface gráfica, incluindo novos modos de interação.

---

> Este projeto é uma simulação educacional inspirada em jogos de pets virtuais. Não está afiliado, associado ou licenciado pela Bandai ou pela marca Tamagotchi.
