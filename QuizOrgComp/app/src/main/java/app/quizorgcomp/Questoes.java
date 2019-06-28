package app.quizorgcomp;

import java.sql.Struct;

/**
 * Classe que contem o banco de questoes, com quatro alternativas
 * cada, e a justificativa de cada uma.
 */
public class Questoes {

    /**
     * Vetor de strings com as questoes.
     */
    public String mQuestoes[] = {
            "Respectivamente, quais são as unidades de transferência da cache para a CPU e da Memória Principal para a cache?",
            "Qual dos tipos de memórias a seguir possui como principais características a não-volatividade e a imutabilidade de conteúdo?",
            "Considerando a hierarquia de memória, qual dos elementos abaixo está no nível mais alto da pirâmide?",
            "Qual das seguintes políticas de substituição substitui o bloco que está há mais tempo na cache?",
            "Joãozinho, ao observar uma tarefa de escrita em sua memória, notou que, após um write hit, um campo denominado “modificação” assumiu valor 1. Sendo assim, qual política de escrita sua memória possuía?",
            "Laura, ao abrir um antigo livro de Organização e Arquitetura de Computadores, encontrou a seguinte definição:\n" +
                    "\t“... é o tempo para buscar um bloco de um nível inferior para um nível superior, incluindo o tempo para acessar o bloco, transmitir de um bloco para outro e inseri-lo no nível que ocorreu a falha.”\n" +
                    "\tEntretanto, o termo ao qual esta definição se refere estava rasurado. Como um bom aluno dessa matéria, é fácil afirmar que o conceito em questão é:",
            "O que é uma memória?",
            "Como é composta a estrutura do mapeamento associativo por conjunto?",
            "Eduardo, ao simular o funcionamento de sua cache de 2 blocos, inicialmente vazia, e de sua memória principal endereçada a byte, observou que a leitura do endereço 3 foi armazenada na segunda posição de sua cache. A partir disso, é possível concluir que o mapeamento em questão é:",
            "Considere as seguintes configurações:\n" +
                    "Memória cache diretamente mapeada\n" +
                    "O tamanho da palavra é 8 bits (1 byte)\n" +
                    "É endereçada por palavra\n" +
                    "O endereço tem  20 bits\n" +
                    "A tag tem 11 bits\n" +
                    "Cada bloco armazena 16 bytes\n" +
                    "Quantos blocos possui a cache em questão?\n"
    };

    /**
     *  Matriz de strings com as alternativas de cada questao.
     */
    private String mRespostas[][] = {
            {"bloco e palavra", "bloco e bloco", "palavra e bloco", "palavra e palavra"},
            {"ROM", "RAM", "Flash", "E²PROM"},
            {"CD-ROM", "Cache", "Registradores", "Fita magnética"},
            {"Aleatória", "LFU", "LRU", "FIFO"},
            {"LRU", "Write-through", "Write-back", "Write-no-allocate"},
            {"penalidade por falta", "taxa de acerto", "tempo de acerto", "taxa de falha"},
            {"Uma parte do sistema que realiza as instruções de um programa", "Uma unidade responsável pela comunicação com dispositivos externos", "Todo componente capaz de armazenar bits de informação", "Unidade Lógica Aritmética"},
            {"tag | index | W.O. | B.O.", "tag | index | set | W.O. | B.O.", "tag | W.O. | B.O.", "tag | set | W.O. | B.O."},
            {"Direto", "Associativo total", "Associativo por conjunto", "FIFO"},
            {"2^3", "2^5", "2^4", "2^7"}
    };

    /**
     * Vetor de strings com as respostas corretas.
     */
    private String mRespostaCorreta[] = {
            "palavra e bloco",
            "ROM",
            "Registradores",
            "FIFO",
            "Write-back",
            "penalidade por falta",
            "Todo componente capaz de armazenar bits de informação",
            "tag | set | W.O. | B.O.",
            "Direto",
            "2^5"
    };

    /**
     * Vetor de string com as explicacoes de cada questao.
     */
    private String mExplicacao[] = {
            "Poxa... Você errou =(\n\nA transferência da cache para a CPU se dá por meio de palavras, já que esse tipo de transferência é rápida; como a transferência entre a memória principal e a cache é mais lenta, ela é feita em blocos, aproveitando, também, o princípio temporal (trazendo informações vizinhas à desejada).",
            "Poxa... Você errou =(\n\nA memória não volátil e que não muda o conteúdo é a ROM, já que a memória RAM é volátil e a Flash e a E²PROM possuem conteúdo mutável (apesar de não serem voláteis).",
            "Poxa... Você errou =(\n\nConsiderando que as memórias no topo da pirâmide são as de capacidade menor, mais rápidas e com custo/bit alto, a que ganha em todas essas características é o registrador.",
            "Poxa... Você errou =(\n\nConsiderando que a política de substituição aleatória escolhe um bloco ao acaso, a política LFU escolhe o bloco usado menos frequentemente, a LRU escolhe o usado menos recentemente e a FIFO escolhe o primeiro bloco transferido para a cache, podemos concluir que a política que substitui o bloco que está há mais tempo na cache é a FIFO, já que os blocos são ordenados pelo tempo de inserção e não pela frequência de acesso.",
            "Poxa... Você errou =(\n\nA política LRU é de substituição, enquanto a política write-no-allocate é utilizada em caso de write-miss. Entre o write-back e o write-through a última escreve diretamente na memória principal, enquanto a primeira altera na cache para depois passar para a memória principal (procedimento de flush), necessitando mudar para 1 o campo “modificação”.",
            "Poxa... Você errou =(\n\nA alternativa correta é a penalidade por falta, já que a taxa de acerto é a fração de acessos encontrados no nível, a taxa de falha é o complemento da taxa de acertos para chegar a 1 e o tempo de acerto é o tempo para acessar o nível atual e determinar se é, de fato, um acerto ou uma falha.",
            "Poxa... Você errou =(\n\nMemória é todo componente capaz de armazenar bits de informação, a alternativa a) refere-se à CPU, a alternativa b) refere-se ao módulo de entrada e saída e a d) é um componente interno a CPU.",
            "Poxa... Você errou =(\n\nO mapeamento associativo por conjunto utiliza uma mistura do mapeamento direto ( tag | index | W.O. | B.O) e do mapeamento associativo total ( tag | W.O | B.O.) a fim de minimizar as suas desvantagens. A estrutura da memória cache é dividida em conjuntos (sets) e nesses conjuntos é feito o mapeamento associativo; para que a cache consiga endereçar corretamente, o endereço é mapeado da seguinte forma: tag | set | W.O. | B.O.",
            "Poxa... Você errou =(\n\nComo não há política de substituição, o mapeamento é direto, e isso se confirma quando a leitura do endereço 3 é alocado no segundo bloco (lembrando que o endereço começa na posição 0) conforme a operação (endereço mod número de blocos), resultando em  1 => segundo bloco.",
            "Poxa... Você errou =(\n\nPara descobrir o número de blocos precisamos do index do endereço, já que a cache é mapeada diretamente. Como cada bloco armazena 16 bytes, cada bloco armazena 16 palavras (2⁴ palavras), assim precisamos de 4 bits para o Word Offset. E como cada palavra armazena 1 byte (2⁰ bits), precisamos de 0 bits para o Byte Offset. Logo, temos:\n" +
                    "\ttag (11 bits) | index (x bits) | w.o. (4 bits) | b.o. (0 bits)\n" +
                    "\tSendo que o endereço tem 20 bits:\n" +
                    "11 + x + 4 + 0 = 20\n" +
                    "\t\tx = 5 bits\n" +
                    "\tOu seja, temos 2⁵ blocos de memória na nossa cache.\n"
    };

    /**
     * Vetor de strings com as mensagens da tela final.
     */
    private String mStatusFinal[] = {
            "Fique calmo! Apesar de não ter ido tão bem, nem mesmo Patterson/Hennessy nasceram sabendo tudo sobre as caches.\nCom certeza na próxima você se sairá muito melhor!",
            "UAU! Patterson/Hennessy ficariam orgulhosos de seu desempenho! Embora ainda existam mais alguns conceitos a serem consolidados, você se saiu muito bem!",
            "Ora, ora! Esqueceram de avisar os desenvolvedores que o Patterson e o Hennessy em pessoa utilizariam o aplicativo!\nBrincadeiras a parte, parabéns pelo seu desempenho =)"
    };

    /**
     * Metodo que retorna uma questao, dado uma posicao do vetor de questoes;
     * @param pos Posicao da questao requisitada;
     * @return Questao localizada na posicao informada;
     */
    public String getQuestao(int pos){
        return mQuestoes[pos];
    }

    /**
     * Metodo que retorna a resposta 1 de uma questao, dado a posicao da mesma;
     * @param pos Posicao da questao requisitada;
     * @return Resposta 1 da questao localizada na posicao informada;
     */
    public String getResposta1(int pos){
        return mRespostas[pos][0];
    }

    /**
     * Metodo que retorna a resposta 2 de uma questao, dado a posicao da mesma;
     * @param pos Posicao da questao requisitada;
     * @return Resposta 2 da questao localizada na posicao informada;
     */
    public String getResposta2(int pos){
        return mRespostas[pos][1];
    }

    /**
     * Metodo que retorna a resposta 3 de uma questao, dado a posicao da mesma;
     * @param pos Posicao da questao requisitada;
     * @return Resposta 3 da questao localizada na posicao informada;
     */
    public String getResposta3(int pos){
        return mRespostas[pos][2];
    }

    /**
     * Metodo que retorna a resposta 4 de uma questao, dado a posicao da mesma;
     * @param pos Posicao da questao requisitada;
     * @return Resposta 4 da questao localizada na posicao informada;
     */
    public String getResposta4(int pos){
        return mRespostas[pos][3];
    }

    /**
     * Metodo que retorna a resposta correta de uma questao, dado a posicao da mesma;
     * @param pos Posicao da questao requisitada;
     * @return Resposta correta da questao localizada na posicao informada;
     */
    public String getRespostaCorreta(int pos){
        return mRespostaCorreta[pos];
    }

    /**
     * Metodo que retorna a justificativa de uma questao (caso o usuario erre), dado a posicao da mesma;
     * @param pos Posicao da questao requisitada;
     * @return Justificativa da questao localizada na posicao informada;
     */
    public String getJustificativa(int pos){
        return mExplicacao[pos];
    }

    /**
     * Metodo que retorna a mensagem da tela final, dependo da quantidade
     * de acertos do usuario.
     * @param acertos Quantidade de acertos do usuario;
     * @return Mensagem da tela final;
     */
    public String getStatusFinal(int acertos){
        if(acertos >= 0 && acertos <= 5)
            return mStatusFinal[0];
        else if(acertos > 5 && acertos <= 8)
            return mStatusFinal[1];
        else
            return mStatusFinal[2];
    }
}
