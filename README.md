# 3ads2017-jokenpo

Veja a implementação sendo realizada com explicações em https://youtu.be/srQUnrKmHdA

# Texto da Atividade

uem ganhou no Jokenpô (Pedra, papel e tesoura)

Todos em algum momento na vida devem ter resolvido alguma disputa com um tradicional jogo de Jokenpô.
Se você nunca jogou e não conhece você pode ver mais detalhes aqui https://pt.wikipedia.org/wiki/Pedra,_papel_e_tesoura

Nesta atividade você deve dizer quem ganhou uma série de disputas de Jokenpô.
Para isso vamos as regras!

Os símbolos dos jogos serão repesentados da seguinte forma:
P -> Pedra
p -> Papel
t -> Tesoura

Como mandam as regras do jogo:
Pedra ganha da tesoura (amassando-a ou quebrando-a).
Tesoura ganha do papel (cortando-o).
Papel ganha da pedra (embrulhando-a).

Um mesmo jogador não pode jogar Pedra duas vezes seguidas, quando acontece isso ele perde.

Para resolução será recebido uma lista de Strings representando cada jogada.
Exemplo 1:
"Pp"
"tp"
"pt"
"PP"

Exemplo 2:
"ppt"
"tPp"
"ttP"
"ptP"
"ptp"

Exemplo 3:
"ptPp"
"PptP"
"ttpp"
"tPpP"


A solução deve validar que todas as Strings devem ser do mesmo tamanho.

Como definir quem ganhou?
Cada posição da String representa a jogada de um jogador.

Por exemplo:
"ptPp"

Jogador 1 -> p
Jogador 2 -> t
Jogador 3 -> P
Jogador 4 -> p

Agora basta avaliar o resultado de cada disputa:
((Jogador 1 x Jogador 2) x Jogador 3) x Jogador 4
((p x t) x P) x p
(t x P) x p
P x p
p

Neste caso o campeão é o Jogador 4!

O resultado esperado de cada análise é uma saída dizendo quantas partidas cada jogador ganhou e quem é o campeão.
Exemplo:
Jogador 1 -> 5 pontos
Jogador 2 -> 3 pontos
Jogador 3 -> 4 pontos
-----------------------
Campeão => Jogador 1


Mãos a obra!
