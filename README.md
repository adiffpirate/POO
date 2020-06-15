# Deckquest

Um jogo simples, single-player, offline, e em turnos para te entreter um pouco nessa pandemia.
  
  
## Como jogar

Antes de começar, saiba que o número de batalhas e a quantidade de personagens no deck são gerados aleatoriamente, só para deixar as coisas menos repetitivas :wink:

**1.** Veja quantos personagens lutarão por ti nesse combate e escolha quantos terão em cada [classe](https://github.com/marcelats/POO#classes).
> Em um combate de 10 personagens, você pode ter 4 guerreiros + 2 arqueiros + 2 bruxos + 2 curandeiros, ou 5 guerreiros + 5 curandeiros, ou até mesmo 10 bruxos! Mas tenha sempre em mente as forças e fraquezas de cada um.

**2.** Escolha um personagem para colocar em batalha, seu oponente escolherá um também.

**3.** Caso seu personagem tenha mais _agilidade_ escolha qual ação ele realizará, senão, espere seu oponente fazer uma ação e depois pode agir.
> Se um personagem for morto, mesmo que tenha feito ação ou não, a batalha se encerra e quem foi derrotado entrega seus pontos de experiência para o adversário.

**4.** Repita o passo 2 e 3 até que o número de batalhas acabe ou todos os personagens de um jogador morram.

Bem fácil, né? :smile:

## Classes

Existem 4 classes no jogo:

**Guerreiros:** Equilibrados em ataque e defesa, guerreiros são sua confiável linha de frente em qualquer momento.

**Arqueiros:** Atacam rápido e dão um dano considerável, porém são mais frágeis que seus companheiros de espada e escudo.

**Bruxos:** A classe que mais demora atacar no jogo, mas quando conseguem conjurar sua magia é melhor sair da frente. Causam um dano absurdo, mas também morrem bem fácil.

**Curandeiros:** Seu suporte nas horas difíceis, conseguem curar os aliados e carregam um bastão para ~~tentar~~ causar dano aos oponentes na hora do desespero.


## Atributos

Cada personagem tem uma série de atributos que são usados em diversas funções do jogo:

**Saúde:** Representa a vida do personagem, que é morto caso esse valor chegue a zero. É recuperada a cada batalha fora de combate (por um valor igual a quantidade de _constituição_ do personagem) e também via magias de cura, mas nunca podendo exceder seu valor máximo.

**Ataque:** Usado por _Guerreiros_, _Arqueiros_ e _Curandeiros_ (caso decida atacar invés de curar) para calcular o dano causado.

**Defesa:** Usado para diminuir o dano causado por ataques inimigos.

**Inteligência:** Usado por _Bruxos_ para calcular o dano causado, e por _Curandeiros_ para calcular a cura realizada.

**Constituição:** Determina a quantidade de pontos de saúde recuperados a cada batalha que o personagem passa fora de combate. Se um personagem tem 10 de _constituição_, ele recuperará 10 pontos de _saúde_.

**Agilidade:** Determina quem começará a batalha atacando.

**Experiência:** Se um personagem derrota outro, os pontos de _experiência_ do derrotado são acresentados aos pontos do vitorioso. Quando esse valor é maximizado (ou ultrapassado), há um aumento de _nível_.

**Nível:** Diz respeito à força de um personagem, quanto maior esse valor, mais forte e mais difícil de ser derrotado é o personagem. Quando alguém sobe de nível, a quantidade máxima de seus atributos é aumentada, de acordo a seguinte tabela:

Atributo | Aumento
:------: | :-----:
Saúde | ?
Experiência | x2
Ataque | ?
Defesa | ?
Inteligência | ?
Constituição | ?
Agilidade | ?


## Ações

Existem 2 tipos de ações no jogo, cada personagem podendo realizar uma ação em seu turno. São elas:

**Ataque:** Causa dano a um oponente escolhido, diminuindo sua _saúde_ de acordo sua _defesa_.

**Cura:** Magia somente usada por _Curandeiros_ que recupera a _saúde_ de um companheiro por uma quantidade de pontos iguais ao seu valor de _inteligência_.

## Cálculo de dano
Classe | Fórmula
:----: | :-----:
Guerreiro | seu ataque - defesa adversária
Arqueiro | seu ataque - defesa adversária
Bruxo | sua inteligência - defesa adversária
Curandeiro | seu ataque - defesa adversária


## Glossário

**Batalha:** É o ciclo que da ritmo ao jogo. No início de uma batalha cada jogador pega um personagem do deck e coloca em combate, aquele com maior valor de _agilidade_ atacará primeiro e depois é a vez do oponente. Ao final da batalha os personagens com _saúde_ voltam para o deck enquanto os mortos (caso hajam) entregam seus pontos de _experência_ ao adversário. Caso um personagem morra antes da sua vez ele é impossibilitado de realizar ações, ou seja, a batalha acaba quando alguém morre.

**Combate:** Um número determinado de batalhas. Ao final do combate cada jogador soma os pontos de _experiência_ de seus personagens, consagrando ganhador do jogo aquele com mais pontos.


## Sobre o projeto

Deckquest foi criado por um pequeno grupo de alunos da USP - São Carlos para reforçar conceitos de Programação Orientada a Objetos, por isso o código é completamente encapsulado e escrito em JAVA.
