Atividade realizada na disciplina de UX/UI para o curso de ADS na Facens.
Aluno: Lincon Amaro de Arruda
RA: 210026


NOTAÇÃO DE GRAFO DE FLUXO:

        [Início]

           |
           v

[ConectarBD + montar SQL]

           |
           v

    [Executar query]

           |
           v

       (rs.next?)

         /    \
        v      v

      true    false

         \     /
            v

          [Fim]


COMPLEXIDADE CICLOMÁTICA:

M = E - N + 2P

Arestas (E) = 7

Nós (N) = 6

Componente (P) = 1

M = 7 − 6 + 2 ∗ 1 = 3

A complexidade ciclomática M desse código é 3.

CAMINHOS BÁSICOS:

Caminho 1:
Conecta ao banco de dados → Executa o SQL → rs.next() = true → result = true → return true.

Caminho 2:
Conecta ao banco de dados → Executa o SQL → rs.next() = false → result = false → return false.

Caminho 3:
Exceção acontece quando cria o Statement ou executa o SQL → catch → result = false → retorna false.




