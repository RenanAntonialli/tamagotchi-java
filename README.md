# Projeto Tamagotchi

## Visão Geral

O sistema simula um Tamagotchi virtual – um pet digital cuja criação e cuidado são gerenciados por meio de um conjunto de ações que afetam atributos como fome, energia, felicidade, higiene, socialização e saúde. O projeto foi desenvolvido utilizando os conceitos de Programação Orientada a Objetos (POO) utilizando a linguagem JAVA.

──────────────────────────────
1. Estrutura do Código
──────────────────────────────

O projeto está dividido em três arquivos principais:

Tamagotchi.java:
Esta classe encapsula toda a lógica do pet virtual. Ela define os atributos essenciais (nome, idade, fome, felicidade, energia, higiene, socialização, saúde e fase de vida) e implementa métodos que modificam esses atributos de acordo com as ações do usuário e a passagem do tempo.

Atributos:
Os atributos são utilizados para simular o estado do Tamagotchi, e seus valores são limitados a intervalos pré-definidos (0 a 100) para garantir consistência e evitar valores inválidos.

Métodos de Ação:
São métodos como feed(), play(), sleep(), clean() e socialize(). Cada um desses métodos modifica os atributos relevantes do pet (por exemplo, alimentar reduz a fome e aumenta a energia).

Passagem do Tempo e Eventos Aleatórios:
O método passTime() simula a passagem do tempo e altera os atributos progressivamente. O método randomEvent() gera eventos aleatórios (ex.: dia chuvoso que diminui energia ou dia ensolarado que aumenta a felicidade) com uma chance determinada, fazendo com que o comportamento do pet se torne mais dinâmico.

Atualização de Fase e Saúde:
O método updateStage() define a fase de vida do Tamagotchi com base na idade (Bebê, Criança, Adolescente, Adulto), enquanto updateHealth() calcula a saúde como uma média dos atributos essenciais, com penalizações caso alguns valores (como fome) estejam fora do ideal.

Validação de Estado:
A função isDead() verifica se a saúde do pet atingiu zero, encerrando a simulação.

──────────────────────────────
2. Funcionalidades Implementadas
──────────────────────────────

O projeto implementa as seguintes funcionalidades principais:

Interação por Ações:
O usuário pode acionar diversas interações com o pet, como:

Alimentar: Reduz a fome e aumenta a energia.

Brincar: Aumenta a felicidade e socialização, mas diminui energia e aumenta fome.

Dormir: Recupera energia e passa um ciclo de tempo, incrementando a idade.

Higiene: Melhora o nível de higiene.

Socializar: Aumenta os níveis de socialização e também a felicidade.

Passagem do Tempo:
A simulação da passagem do tempo é realizada em dois cenários:

Modo Console (TamagotchiApp.java):
O usuário pode avançar o tempo manualmente através do menu, facilitando testes e depuração.

Modo GUI (TamagotchiGUI.java):
Um timer (javax.swing.Timer) é iniciado para simular "ticks" de 10 segundos. Em cada tick, ocorre a passagem do tempo e possíveis eventos aleatórios, atualizando os atributos do pet de forma contínua.

Eventos Aleatórios:
Eventos aleatórios são gerados para simular imprevistos do cotidiano (ex.: dias chuvosos ou ensolarados, acidentes) que afetam os atributos do pet. Essa funcionalidade adiciona imprevisibilidade à simulação.

Atualização da Fase de Vida e Imagem:
Com base na idade, o pet passa pelas fases: Bebê, Criança, Adolescente e Adulto.

A GUI usa arquivos .png diferentes para cada fase, e há um arquivo de imagem exclusivo para quando o pet morre (por exemplo, "morto.png").

A função updateImage() na classe GUI escolhe dinamicamente a imagem correspondente ao estado atual do Tamagotchi.

Área de Log na Interface Gráfica:
Além dos indicadores visuais (barras de progresso), uma área de log foi incorporada à GUI para exibir mensagens de status, como ações realizadas, eventos aleatórios e alertas de saúde. Isso aproxima a experiência do usuário da sensação de interação em dispositivos físicos, onde feedback imediato é essencial.

──────────────────────────────
3. Decisões de Projeto e Considerações
──────────────────────────────

Durante o desenvolvimento, foram tomadas as seguintes decisões:

Separação de Responsabilidades:

A lógica de negócio e o comportamento do pet foram encapsulados na classe Tamagotchi.java.

As interfaces de usuário são separadas em dois modos:

Console (TamagotchiApp.java) para depuração e testes manuais;

GUI (TamagotchiGUI.java) para uma experiência interativa e visual que se assemelha a um Tamagotchi físico.

Atualização Automática com Timer:
A utilização do javax.swing.Timer na GUI permite que o tempo avance automaticamente, simulando um pet "vivo" e garantindo feedback visual constante. Essa abordagem elimina a necessidade de interação manual contínua para testar a evolução do pet.

Utilização de Imagens Dinâmicas:
Decidiu-se pela alteração da imagem do pet conforme sua fase de vida para proporcionar uma experiência visual mais rica e realista, aproximando o software da experiência oferecida pelos dispositivos Tamagotchi originais.

A imagem muda dinamicamente para refletir as fases: Bebê, Criança, Adolescente e Adulto.

Uma imagem exclusiva é exibida se a saúde do pet chegar a zero, informando ao usuário que o pet "morreu".

Feedback Visual e Textual:
A área de log na GUI foi implementada para que todas as mensagens geradas pelo sistema — desde a execução de ações até a geração de eventos aleatórios — sejam visíveis na própria interface. Isso ajuda tanto o usuário quanto o desenvolvedor a entender o que está ocorrendo no sistema em tempo real.

Validação e Limitação dos Atributos:
Para garantir que os atributos permaneçam em intervalos válidos, o código inclui verificações que evitam que valores como fome, energia e saúde ultrapassem limites definidos (0 a 100). Essa abordagem previne erros e torna a simulação mais realista.

──────────────────────────────
4. Conclusão
──────────────────────────────

Este projeto de Tamagotchi combina conceitos de Programação Orientada a Objetos com uma interface gráfica interativa, permitindo simular um pet virtual com características e comportamento dinâmicos. As funcionalidades implementadas — desde a interação do usuário com ações básicas até a simulação automatizada do tempo e a exibição de feedback visual e textual — foram pensadas para proporcionar uma experiência completa que se aproxima da experiência de um Tamagotchi real.

As decisões de design, como a separação da lógica de negócio da interface e o uso de imagens dinâmicas, permitem que o projeto seja facilmente mantido e expandido, possibilitando futuras melhorias, como a adição de sons ou animações, caso desejado.

Esta documentação interna serve para orientar desenvolvedores na compreensão da estrutura e dos objetivos do projeto, facilitando possíveis alterações ou expansões que venham a ser necessárias.
