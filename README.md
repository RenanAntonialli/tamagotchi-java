# Documentação do Projeto Tamagotchi

## Visão Geral

O sistema simula um Tamagotchi virtual – um pet digital cuja criação e cuidado são gerenciados por meio de um conjunto de ações que afetam atributos como fome, energia, felicidade, higiene, socialização e saúde. O projeto foi desenvolvido utilizando os conceitos de Programação Orientada a Objetos (POO) e possui duas classes principais:

- **TamagotchiApp**: Classe com o método `main`, que fornece uma interface de console para interação com o usuário e gerenciamento do ciclo de vida do Tamagotchi.
- **Tamagotchi**: Responsável pela modelagem do pet, seus atributos e comportamento.

---

## Classes e Componentes

### 1. Classe `TamagotchiApp`

#### Função Principal

- **main(String[] args):**  
  Essa classe atua como ponto de entrada do sistema.  
  - Inicializa um objeto `Scanner` para entrada de dados via console.
  - Solicita ao usuário o nome do Tamagotchi e cria uma instância da classe `Tamagotchi`.
  - Exibe um menu de ações que o usuário pode executar (alimentar, brincar, dormir, limpar, socializar, checar status, avançar tempo ou sair).
  - Em cada iteração do loop principal:
    - Processa a opção escolhida e chama o método correspondente do objeto `Tamagotchi`.
    - Chama o método `randomEvent()` para simular eventos aleatórios.
    - Verifica e alerta sobre a saúde com `checkHealth()`.
    - Encerra o jogo se o método `isDead()` retornar `true` (indicando que o pet faleceu).

---

### 2. Classe `Tamagotchi`

#### Atributos

- **name (String):** Nome do Tamagotchi, atribuído na criação.
- **age (int):** Representa a idade ou o tempo de vida do pet, usado para determinar sua fase de desenvolvimento (Bebê, Adolescente, Adulto).
- **hunger (int):** Nível de fome, variando de 0 (satisfeito) a 100 (muito faminto).
- **happiness (int):** Nível de felicidade, variando de 0 (triste) a 100 (muito feliz).
- **energy (int):** Nível de energia, de 0 (exausto) a 100 (muito disposto).
- **hygiene (int):** Nível de higiene, de 0 (sujo) a 100 (limpo).
- **social (int):** Nível de socialização, de 0 (isolado) a 100 (muito sociável).
- **health (int):** Representa a saúde geral, calculada como a média de outros atributos, com ajustes baseados em condições adversas.
- **stage (String):** Fase de desenvolvimento do pet: "Bebê", "Adolescente" ou "Adulto". Determinada pela idade.
- **rand (Random):** Instância da classe `Random` utilizada para gerar eventos aleatórios.

#### Construtor

- **Tamagotchi(String name):** Inicializa o Tamagotchi com valores padrão para os atributos (ex.: fome e energia iniciam em 50, saúde em 100). Define o estágio inicial como "Bebê" e prepara o gerador de números aleatórios.

#### Métodos Principais

- **feed():**  
  Simula a alimentação do pet.  
  - Reduz o nível de fome em 20 (limitado a zero, caso passe abaixo).
  - Aumenta a energia em 10 (limitado a 100).
  - Atualiza a saúde com base nos novos valores.

- **play():**  
  Representa o ato de brincar com o Tamagotchi.  
  - Aumenta a felicidade em 20 (até 100).
  - Reduz a energia em 15 e aumenta a fome em 10.
  - Incrementa o nível de socialização em 15 (até 100).
  - Atualiza a saúde após as alterações.

- **sleep():**  
  Simula o período de sono do pet.  
  - Aumenta a energia em 30 (até 100).
  - Incrementa a idade (representando a passagem do tempo) e, consequentemente, pode alterar o estágio do pet.
  - Atualiza a saúde com base nas mudanças.

- **clean():**  
  Permite realizar a higiene do Tamagotchi.  
  - Aumenta o nível de higiene em 30 (limitado a 100).
  - Atualiza a saúde.

- **socialize():**  
  Simula a socialização do pet.  
  - Aumenta a socialização em 20 e a felicidade em 10 (ambos limitados a 100).
  - Atualiza a saúde.

- **checkStatus():**  
  Exibe no console o estado atual do Tamagotchi, mostrando todos os atributos, como estágio, idade, fome, felicidade, energia, higiene, social e saúde.

- **passTime():**  
  Simula a passagem do tempo com efeitos cumulativos:  
  - Incrementa a idade.
  - Aumenta a fome e diminui energia, higiene, socialização e felicidade.
  - Limita os valores para não ultrapassar os intervalos definidos.
  - Chama os métodos para atualizar o estágio e a saúde do pet.

- **randomEvent():**  
  Implementa um evento aleatório com uma chance de 15% a cada ação.  
  - O evento pode ser:
    - **Dia chuvoso:** Diminui a energia.
    - **Acidente:** Diminui a saúde.
    - **Dia ensolarado:** Aumenta a felicidade.
  - Após o evento, a saúde é atualizada.

- **updateStage():**  
  Atualiza a fase do Tamagotchi com base na idade:
  - **Bebê:** idade menor que 3.
  - **Adolescente:** idade entre 3 e 5.
  - **Adulto:** idade 6 ou superior.

- **updateHealth():**  
  Calcula a saúde como a média de energia, higiene, felicidade e socialização, com ajuste negativo caso a fome esteja muito alta (acima de 80).  
  - Assegura que a saúde permaneça entre 0 e 100.

- **checkHealth():**  
  Verifica se algum atributo crítico (como energia, higiene, fome, felicidade ou socialização) está fora do ideal e alerta o usuário caso o pet não esteja se sentindo bem.

- **isDead():**  
  Retorna um valor booleano indicando se a saúde do Tamagotchi chegou a zero, ou seja, se o pet “morreu”.

---

#### Fluxo de Execução

1. **Inicialização:**  
   O programa solicita o nome do pet e cria a instância com atributos iniciais.

2. **Interação com o Usuário:**  
   O menu interativo permite que o usuário escolha ações. Cada ação afeta atributos específicos do Tamagotchi, simulando o cuidado diário.

3. **Eventos e Atualizações:**  
   Após cada ação, o sistema:
   - Executa um evento aleatório (com chance de ocorrer).
   - Atualiza os atributos do pet, verificando se estão em níveis críticos.

4. **Condição de Término:**  
   Se a saúde do Tamagotchi cair para zero, o jogo é encerrado e uma mensagem informando que o pet faleceu é exibida.

---

## Considerações Adicionais

- **Restrições e Limitações dos Atributos:**  
  Cada atributo possui limites definidos (mínimo 0 e máximo 100) para manter a integridade dos dados. Isso é verificado em cada método que altera os atributos.

- **Atualização Dinâmica dos Atributos:**  
  Métodos como `passTime()` e `randomEvent()` demonstram como o estado do pet é afetado pelo tempo e por eventos inesperados, simulando um ambiente interativo e dinâmico.

- **Modularidade e Reutilização:**  
  A separação em duas classes (uma para a lógica do pet e outra para a interface de interação) permite uma melhor manutenção e a possibilidade de futuras expansões, como a implementação de uma interface gráfica ou a adição de novos comportamentos.
