# Aula 25
- Revisão
- Exercicios
  

1)No universo de programação, baseada em Estruturas de Dados e Orientação a Objetos, há classes ou estruturas para armazenar dados em memória. Cite e explique as 3 principais estruturas em que programadores armazenam dados em memória e conseguem acessar dados de maneira mais eficaz.

R:Listas, Arvores e Tabelas Hash

2)Dentro dos métodos de pesquisa, há o sequencial e o binário. Entretanto, a pesquisa binária mostra-se muito mais eficaz. Para usá-la, como a estrutura deve se apresentar e qual a filosofia de trabalho da pesquisa binária.

R: A estrutura precisa estar ordenada e a filosofia de trabalho baseada em árvore binária de pesquisa

3)No universo de Tabelas Hash (técnica de espalhamento), os dados são armazenados e acessados rapidamente, com uma complexidade O(1). Qual o recurso utilizado para que isso aconteça.

R: Função Hash, ou função de cálculo de endedeço sobre um chave

4)Tendo como base o algoritmo de pesquisa binária, contabilize e mostra quantas comparações ocorrem na estrutura até o número 24 ser localizado na lista.

IMAGEM

OBS: codigo da pesquisa binária
def binaria(numero, lista)
    int = 0
    fim  = lengt(lista)-1
    whele(ini <= fim)     
        meio = ini((ini + fim)/2)
        if(numero == lista [meio]):
            return meio
        else if(numero < lista[meio]):
            fim = meio - 1
        else:
            ini = meio + 1
    return -1

 # Aula 24 - 19/10/2026
- Exercicio sobre Hash
- [Código](https://github.com/leonardo-t-gomes/pesquisa-ordenacao/tree/main/Codigos/Aula%2024)

# Aula 23 - 15/10/2026
- Exercicio sobre telefonia 
- [Código](https://github.com/leonardo-t-gomes/pesquisa-ordenacao/tree/main/Codigos/aula%2021)


# Aula 22 - 14/10/2026

### Trabalho semestral 
1) armazene em um HashMap os dados do arquivo telephony_sessions.txt, usando como classe a classe implementada em Sessao.java
    - ler o arquivo
    - splitar as linhas
    - criar um objeto do tipo Sessao
    - adicionar (put) no HashMap
    - usar MVC

2) permite procurar um número de celular e o retorne seja os dados da sessão

3) DESAFIO: pesquise sobre uso de threads e tente procurar N celulares ao mesmo tempo

### Hash 
- Função de espalhamento, ou seja, um dado é armazenado ou pesquisado na estrutura via um código de endereçamento
- **Tabela Hash**: estrutura de dados que armazena os dados e não possui índice (não podendo usar for, por exemplo, porque não existe posições [0], [1], etc)
- **Função Hash**: cálculo de endereçamento para armazenar e buscar elementos na estrutura
- Hash não é possível ordenar, por isso que em uma table se usa list, por exemplo

```java
import java.util.HashSet;

public class Sessao {
    public String numeroCelular;
    public String dadosSessao;

    public Sessao(String numeroCelular, String dadosSessao) {
        this.numeroCelular = numeroCelular;
        this.dadosSessao = dadosSessao;
    }

    @Override
    public String toString() {
        return "Sessao [numeroCelular=" + numeroCelular + ", dadosSessao=" + dadosSessao + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((numeroCelular == null) ? 0 : numeroCelular.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Sessao other = (Sessao) obj;
        if (numeroCelular == null) {
            if (other.numeroCelular != null)
                return false;
        } else if (!numeroCelular.equals(other.numeroCelular))
            return false;
        return true;
    }
}
```

### Diferença de HashMap x HashSet

| Característica | HashMap | HashSet |
| :--- | :--- | :--- |
| **Interface** | Implementa a interface `Map`. | Implementa a interface `Set`. |
| **Estrutura** | Armazena dados em **pares de Chave e Valor** (`Key-Value`). | Armazena **apenas elementos únicos** (valores isolados). |
| **Duplicatas** | Chaves **não** podem ser duplicadas (se repetir, o valor é sobrescrito). Valores podem ser repetidos. | **Não** permite elementos duplicados. Tentativas de adicionar itens repetidos são ignoradas. |
| **Método de inserção** | Utiliza o método `put(chave, valor)`. | Utiliza o método `add(elemento)`. |
| **Consulta** | Busca por meio da chave (`get(chave)`). | Verifica apenas se o elemento existe (`contains(elemento)`). |

### Exemplo de `HashMap`
O `HashMap` é ideal quando você precisa associar um identificador (chave) a um dado (valor), como um dicionário ou um cadastro de usuários por ID.

```java
import java.util.HashMap;

public class ExemploHashMap {
    public static void main(String[] args) {
        // Criando um HashMap onde a chave é o ID (Integer) e o valor é o Nome (String)
        HashMap<Integer, String> usuarios = new HashMap<>();

        // Adicionando elementos com put()
        usuarios.put(1, "Ana Silva");
        usuarios.put(2, "Carlos Souza");
        usuarios.put(3, "Mariana Lima");

        // Tentando adicionar uma chave já existente (substitui o valor anterior)
        usuarios.put(1, "Ana Silva Atualizada");

        // Buscando um valor pela chave
        System.out.println("Usuário ID 1: " + usuarios.get(1)); 
        // Saída: Usuário ID 1: Ana Silva Atualizada

        // Exibindo todos os registros
        System.out.println("Todos os usuários: " + usuarios);
    }
}
```

### Exemplo de `HashMap`
O `HashSet` é ideal quando você precisa garantir a unicidade de uma coleção de itens e não se importa com pares, apenas se o item está presente ou não (ex: lista de CPFs cadastrados, e-mails únicos).

```java
import java.util.HashSet;

public class ExemploHashSet {
    public static void main(String[] args) {
        // Criando um HashSet de Strings para armazenar frutas
        HashSet<String> frutas = new HashSet<>();

        // Adicionando elementos com add()
        frutas.add("Maçã");
        frutas.add("Banana");
        frutas.add("Laranja");

        // Tentando adicionar um elemento duplicado
        boolean adicionouMaçãNovamente = frutas.add("Maçã"); 
        System.out.println("Conseguiu adicionar 'Maçã' de novo? " + adicionouMaçãNovamente); 
        // Saída: false (já existia)

        // Verificando se um elemento existe
        System.out.println("Contém Banana? " + frutas.contains("Banana")); 
        // Saída: true

        // O tamanho será 3, pois duplicatas foram ignoradas
        System.out.println("Total de frutas únicas: " + frutas.size());
    }
}
```

### Tipos de tratamento de colisões
- Listas encadeadas

###  Tipos de Hash
- Open addressing ou closed hashing

# Aula 21 - 05/10/2026
## Pesquisa
### Árvores TRIE
- Estrutura usada para armazenar e pesquisar palavras/chaves.
- Cada caminho da árvore representa uma sequência de caracteres.
- A busca é rápida, pois percorre os caracteres da palavra.
- Exemplo: palavras CASA e CARRO compartilham o início CA.

### P.A.T.R.I.C.I.A
- É uma versão mais eficiente da TRIE.
- Remove caminhos que possuem apenas um filho, compactando a árvore.
- Ocupa menos espaço e mantém buscas rápidas.
- Muito usada para pesquisar strings/chaves de forma eficiente.

### Diferença das ativações de tecla
 - keyPressed → executado quando uma tecla é pressionada.
 - keyReleased → executado quando uma tecla é solta.
 - keyTyped → executado quando um caractere é digitado.



# Aula 20 - 01/10/2026
## Pesquisa
  - depende da ordenação
  - quando a estrutura está DESORDENADA, há SOMENTE a pesquisa SEQUENCIAL
  - para medir a Complexidade da pesquisa usa apenas a quantidade de comparações
### Sequencial
  - A estrutura não precisa estar ordenada
### Binária
  - baseada na teoria de árvore, porém a estrutura precisa estar ordenada
  - retorna somente um elemento, caso ele esteja repetido na estrutura
  - se tiver dois números iguais dá erro

    


# Aula 19 - 28/09/2026
## HEAPSORT
- HEAPMAXIMO- garantir que raiz da subarvore seja maior ou igual que seus filhos. Se isso não ocorrer, fazer as trocas
- tenta deixar os maiores para cima, baseado em arvore dentro do vetor
- tem uma peculariedade a primeira posição não pode ser "0", tem que descartar
- Ineficiente, tem muitas trocas 

# Aula 18 - 24/09/2026
## SHELL
  - Baseado no Insersão
  - Utiliza a distancia- pré - organiza a lista, acabando com o problema dos dados tartaruga
## ATIVIDADE EM AULA
  - colocar MERGE, QUICKSORT e SHELL

# Aula 17 - 21/09/2026

# Aula 15 - 17/09/2026
- Atividade em Aula
- MiniCursos Sirc

# Aula 14 - 14/09/2026
- Continuação da atividade da última aula(finalização do projeto e adição dos dados em uma tabela comparativa)
- [Clique Aqui - Para ver](https://github.com/leonardo-t-gomes/pesquisa-ordenacao/tree/main/Codigos/Aula%2015)

# Aula 13 - 10/09/2026
- Atividade de Pesquisa e Ordenação no Netbeens(criação de uma interface para comparar métodos de ordenação)
- [Atividade Mencionada](https://github.com/leonardo-t-gomes/pesquisa-ordenacao/tree/main/Codigos/Aula%2013)

# Aula 12 - 03/09/2026
- **Métodos de Baixa complexidade, porém "difíceis" de implementar**
## MERGE
- Intercalar: empilhamento
- Recursivo
- Composto por 2 métodos:
  - merge → recursivo
  - divide homogeneamente 
  - intercalar → ordenar no retorno do "empilhamento" → no processo de intercalação
- Ordenação se dá na volta da recursão
- Pra baixo vai dividindo por 2, pra cima vai intercalando
- Complexidade: O(n. log n)
- OBS: O processo é baseado em divisões da estrutura recursivamente, sempre no meio
- 
## QUICKSORT
- pivo: quem é ordenado
- recursivo
- Composto por 2 métodos:
  - quick → recursivo
  - posicionar → ordenar o pivo
- Complexidade: O(n. log n)
- OBS: O processo é baseado em divisões da estrutura recursivamente, porém obedecendo a posição do pivo

# Aula 11 - 31/08/2026
  ## Correção da Prova 1 - 27/08/2026
  - Questão 1:
  - Questão 2:
  A)
  B)Estáveis- bolha,inserção,
    Instáveis - Seleção, pente
  - Questão 3: Comparable , CompareTo , -1, 1
  - Questão 4: Bolha e Insersão
  - Questão 5:
    A) Ao ir da esquerda para direita ele leva os maiores e na volta ele trás os menores
    B) ao olhar a distancia eu consigo trazer os menores para o início com menos comparações

- Exercício da aula

# Aula 10 - 27/08/2026

# Aula 09 - 24/08/2026
- Resolução do desafio da ultima aula

## Exemplo da aula
- Pessoa
  
  ````java
    import java.util.Objects;
    public class Pessoa implements Comparable<Pessoa>{
    String nome;
    int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + ", idade=" + idade + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.nome);
        hash = 97 * hash + this.idade;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (this.idade != other.idade) {
            return false;
        }
        return Objects.equals(this.nome, other.nome);
    }

    @Override
    public int compareTo(Pessoa o) {
       int resultado = this.getNome().compareTo(o.getNome());
       if(resultado != 0){
           return resultado;
       }
       return Integer.compare(this.idade, o.getIdade());
    }
}
```
- Principal
````java

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Principal {
    public static void main(String[] args) {
        List<Pessoa> lista = new ArrayList<>();
        
        lista.add(new Pessoa("Gabriel", 19));
        lista.add(new Pessoa("Alex", 52));
        lista.add(new Pessoa("Gabriel", 20));
        lista.add(new Pessoa("Alex", 51));
        
        Collections.sort(lista);       
        System.out.println(lista);
        
        lista.sort((p1, p2) -> Integer.compare(p2.getIdade(), p1.getIdade()));
        System.out.println(lista);
    }
}

```

# Aula 08 - 20/08/2026
## Pente(combo sort)
 - Uso da distancia
 - Instável
 - Variável de comparação de valores
 - Comparações a distancia
 - Pré-Orientação
 - Diminue a cada Troca
 - Para quando a distancia for 1(dai ele vira bolha) e não tiver troca

## Atividades

# Aula 07 - 17/08/2026
  - [Trabalho](https://github.com/leotgomes2007-byte/pesquisa-ordenacao/tree/main/Codigos/Aula%206/CodigoDaAula/Minhavers%C3%A3o/C%23/source)
  
  - Verificação das anotações de aula

# Aula 06 - 13/08/2026
## Agitação
  - Tentativa de melhorar o Bolha(Bubble)
  - Estável
  - Memória Interna
  - Um bolha duas vezes(dois 'FOR'), um que vai do inicio até o fim e outro que vai do fim até o inicio, se não encontrar troca e não executará o outro for

## ATIVIDADE 
- fazer o modelo MVC testando os metodos de ordenação(nativo e os que aprendemos)



# Aula 05 - 10/08/2026
## Bolha - O (n²) 
  - simples
  - estável
  - memória RAM
  - Parte ordenada está no final da estrutura
  - A ideia de bolha é pq o maior valor em cada  "pesado" é levado até o final da estrutura

## Seleção - O (n²)
 - Simples
 - Instavel
 - memória RAM
 - parte ordenada está no inicio da estrutura
 - A ideia da seleção é pq a cada célula de vetor, avançará, se selecione(ou laça) o menor valor para aquela posição

## Inserção O(n²)
 - Simples
 - estável
 - memoria RAM
 - Parte Ordenada está no inicio da estrutura
 - A ideia de Inserção é pq cada vetor da porção de direita de estrutura é inserido na sua posição correta na porção de esquerda 

# Aula 04 - Premissa da Disciplina - 06/08/2026
 - Padrão de desenvolvimento
     -> MVC
     ->Documentação
  - beanchmark
     ->Medições(complexibilidade,tempo)
    
  - Medir tempo de ordenação:
    (https://github.com/JuuJaoBRzao/Pesquisa_Ordenacao/tree/main/Exercicios/Exercicio%201)

  - Atividade Prática sobre model , view e controller(MVC)

  Model - cria o link com o banco de dados, é responsavel pelos dados,chaves estrangeiras
  Controller - são as regras de negocios, os calculos/metodos, e liga o view ao model
  View - é responsável pela parte visual, a aparencia, a parte que o usuário vê

# Aula 03 - Padrões de Arquitetura e Algoritmos de Ordenação - 03/08/2026

## Módulo 1: O Padrão Arquitetural MVC

O **MVC** (*Model-View-Controller*) é uma das abordagens estruturais mais consagradas no desenvolvimento de sistemas. Sua meta central é a **divisão clara de responsabilidades**, fracionando a aplicação em três componentes integrados para promover um código mais fácil de manter, reutilizar e escalar.

- MVC (Model View Controller):
   (https://github.com/alexandrezamberlan/estruturasDeDados/tree/master/00%20-%20anosAnteriores/exemploJava_usoLista_MVC)

---

### 1. Descrição dos Componentes

#### Model (Modelo)
* **Conceito:** Representa o núcleo funcional do sistema. Engloba o gerenciamento de dados, as diretrizes de negócio e as regras operacionais da aplicação.
* **Atribuições:**
  * Manipulação direta da camada de dados (operações de persistência e banco de dados).
  * Aplicação e verificação das regras de negócio.
  * Emissão de notificações para as camadas superiores caso ocorram mudanças em seu estado interno.

#### View (Visão)
* **Conceito:** Constitui a camada visual e de interação (Interface de Usuário). Inclui todas as telas, formulários, componentes visuais e relatórios apresentados ao usuário.
* **Atribuições:**
  * Apresentar as informações processadas pelo Model de forma intuitiva.
  * Capturar interações do usuário (digitação, cliques) e repassá-las ao Controller.
  * **Princípio fundamental:** A View deve ser isenta de regras de negócio complexas e não deve acessar o banco de dados diretamente.

#### Controller (Controlador)
* **Conceito:** Atua como o maestro do fluxo de dados, gerenciando a comunicação entre a View e o Model.
* **Atribuições:**
  * Capturar as solicitações enviadas pela View.
  * Tratar as entradas do usuário, acionando as operações correspondentes no Model.
  * Definir o resultado final e determinar qual View deve ser renderizada em resposta.

---

### 2. O Ciclo da Requisição

O fluxo operacional do padrão MVC ocorre na seguinte ordem:

1. **Interação do Usuário:** O usuário realiza uma ação na interface gráfica (**View**).
2. **Encaminhamento:** A **View** redireciona os dados da requisição para o **Controller**.
3. **Execução de Lógica:** O **Controller** analisa a solicitação e aciona as operações adequadas no **Model**.
4. **Resposta do Modelo:** O **Model** aplica a regra de negócio, consulta/muda o banco de dados e retorna o resultado ao **Controller**.
5. **Atualização da Interface:** O **Controller** direciona os dados recebidos para a **View** apropriada, atualizando a tela para o usuário.

---

### 3. Principais Benefícios

* **Isolamento de Responsabilidades:** Separação entre interface e lógica operacional, garantindo que mudanças no visual não afetem as regras de negócio.
* **Trabalho em Equipe Otimizado:** Desenvolvedores podem atuar em paralelo em camadas distintas (front-end na View, back-end no Model/Controller).
* **Testabilidade e Manutenção:** Facilidade para isolar componentes em testes unitários e realizar manutenções com menor risco de efeitos colaterais.
* **Reaproveitamento de Componentes:** A lógica contida no Model pode ser reutilizada por múltiplas interfaces (interfaces Web, aplicações mobile, APIs).

---

### Tabela Comparativa de Componentes

| Componente | Papel Principal | Conexões Diretas |
| :--- | :--- | :--- |
| **Model** | Regras de Negócio e Dados | Banco de Dados e Controller |
| **View** | Apresentação e Interface | Usuário e Controller |
| **Controller** | Orquestração do Fluxo | Model e View |

---

## Módulo 2: Métodos de Ordenação

### 1. Algoritmos Quadráticos e Básicos

#### Bubble Sort (Bolha)
* **Memória:** Interna
* **Estabilidade:** Estável
* **Complexidade:** $O(n)$ (melhor caso otimizado) | $O(n^2)$ (caso médio e pior)
* **Porção Ordenada:** Extremidade final (os maiores valores flutuam progressivamente até a última posição).

#### Selection Sort (Seleção)
* **Memória:** Interna
* **Estabilidade:** Instável (em sua forma clássica)
* **Complexidade:** $O(n^2)$ (em todos os cenários)
* **Porção Ordenada:** Extremidade inicial (o menor elemento do subvetor não ordenado é identificado e alocado à esquerda).

#### Insertion Sort (Inserção)
* **Memória:** Interna
* **Estabilidade:** Estável
* **Complexidade:** $O(n)$ (melhor caso, vetor já ordenado) | $O(n^2)$ (caso médio e pior)
* **Porção Ordenada:** Extremidade inicial (elementos são inseridos gradualmente na posição correta de um segmento já ordenado).

#### Comb Sort (Pente)
* **Memória:** Interna
* **Estabilidade:** Instável
* **Complexidade:** $O(n \log n)$ (caso médio) | $O(n^2)$ (pior caso)
* **Porção Ordenada:** Distribuída (elimina elementos pequenos no final utilizando intervalos/gaps variáveis).

#### Shake Sort / Cocktail Sort (Agitação)
* **Memória:** Interna
* **Estabilidade:** Estável
* **Complexidade:** $O(n^2)$
* **Porção Ordenada:** Bidirecional (intercala varreduras para o início e para o final).

---

### 2. Algoritmos Eficientes por Comparação ($O(n \log n)$)

#### Shellsort
* **Memória:** Interna
* **Estabilidade:** Instável
* **Complexidade:** Depende da sequência de lacunas escolhida (geralmente entre $O(n \log^2 n)$ e $O(n^{1.5})$)
* **Porção Ordenada:** Subvetores formados por saltos intercalados que diminuem gradativamente.

#### Heapsort
* **Memória:** Interna
* **Estabilidade:** Instável
* **Complexidade:** $O(n \log n)$ (em todos os cenários)
* **Porção Ordenada:** Extremidade final (retira iterativamente o maior elemento da estrutura de heap).

#### Mergesort
* **Memória:** Interna (exige memória extra $O(n)$) ou Externa (indicado para volumes massivos de dados)
* **Estabilidade:** Estável
* **Complexidade:** $O(n \log n)$ (em todos os cenários)
* **Porção Ordenada:** Subvetores divididos recursivamente e mesclados de forma ordenada.

#### Quicksort
* **Memória:** Interna
* **Estabilidade:** Instável (em sua implementação padrão)
* **Complexidade:** $O(n \log n)$ (caso médio) | $O(n^2)$ (pior caso)
* **Porção Ordenada:** Segmentada com base em um elemento pivô (menores à esquerda, maiores à direita).

---

### 3. Algoritmos Não Comparativos (Linear)

#### Bucketsort (Ordenação por Baldes)
* **Memória:** Interna (necessita de estrutura auxiliar para alocação dos baldes)
* **Estabilidade:** Estável (a depender do algoritmo utilizado dentro de cada balde)
* **Complexidade:** $O(n + k)$ (caso médio) | $O(n^2)$ (pior caso, se houver concentração total em um único balde)
* **Porção Ordenada:** Segmentada em faixas de valores (baldes) posteriormente unificadas.

#### Radixsort
* **Memória:** Interna
* **Estabilidade:** Estável
* **Complexidade:** $O(d \cdot (n + k))$ ($d$ = quantidade de dígitos, $k$ = base numérica)
* **Porção Ordenada:** Processada dígito a dígito (geralmente iniciando do dígito menos significativo ao mais significativo).

---

### Visão Geral e Comparativa

| Algoritmo | Memória | Estabilidade | Melhor Caso | Caso Médio | Pior Caso | Zona Ordenada |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| **Bubble Sort** | Interna | Estável | $O(n)$ | $O(n^2)$ | $O(n^2)$ | Final |
| **Selection Sort**| Interna | Instável | $O(n^2)$ | $O(n^2)$ | $O(n^2)$ | Início |
| **Insertion Sort**| Interna | Estável | $O(n)$ | $O(n^2)$ | $O(n^2)$ | Início |
| **Comb Sort** | Interna | Instável | $O(n \log n)$ | $O(n \log n)$ | $O(n^2)$ | Distribuída |
| **Shake Sort** | Interna | Estável | $O(n)$ | $O(n^2)$ | $O(n^2)$ | Início e Final (Bidirecional) |
| **Shellsort** | Interna | Instável | $O(n \log n)$ | $O(n \log^2 n)$ | $O(n^2)$ ou $O(n^{1.5})$ | Intercalada (por Gaps) |
| **Heapsort** | Interna | Instável | $O(n \log n)$ | $O(n \log n)$ | $O(n \log n)$ | Final |
| **Mergesort** | Interna/Externa | Estável | $O(n \log n)$ | $O(n \log n)$ | $O(n \log n)$ | Subvetores Mesclados |
| **Quicksort** | Interna | Instável | $O(n \log n)$ | $O(n \log n)$ | $O(n^2)$ | Particionados por Pivô |
| **Bucketsort**| Interna | Estável | $O(n + k)$ | $O(n + k)$ | $O(n^2)$ | Baldes Concatenados |
| **Radixsort** | Interna | Estável | $O(d \cdot (n + k))$ | $O(d \cdot (n + k))$ | $O(d \cdot (n + k))$ | Por Posicionamento/Dígito |

# Aula 02 - 30/07/2026

## Conceitos

- *CRUD: Create, Retrieve, Update, Delete*
- Por que ordenar? Para otimizar a busca ou pesquisa
- Pesquisar (search/find): localizar ou buscar um dado dentro de uma estrutura via alguma chave
- Recuperar (retrieve): busca ou localização de dados com relevância (semântica ou significado)
- Estabilidade: quanto a estrutura é desordenada até chegar na ordenação
- Complexidade de algoritmo: medida do esforço computacional (tempo e/ou memória)
- Quanto menor a complexidade, mais eficiente tende a ser o algoritmo
- Alta complexidade, mais esforço. Baixa complexidade, menos esforço
  
- **Notação Big O:** representa o crescimento do custo de um algoritmo conforme o tamanho da entrada aumenta
- Complexidades mais comuns:
  - **O(1):** constante
  - **O(log n):** logarítmica        - menor complexidade
  - **O(n!):** fatorial              - maior complexidade
  - **O(n):** linear
  - **O(n log n):** linearítmica
  - **O(n²):** quadrática
- Na análise de Big O, constantes e termos menores são desconsiderados, mantendo apenas o termo de maior crescimento
- Como mede a complexidade: trocas + comparações

# Aula 1 - 27/07/2026

  1.Apresentação inicial da materiae topicos que abordaremos ao decorrer do ano
  2.explicção do novo sistemas de notas, a partir do novo semestre

## Conceitos Base:
- Sort
- Seleção(Select)
- Bolha(Bubble)
- Inserção(Insert)
- Agitação, Shell, Pente, Radix, Bucket
- Merge,Quick, Hear


     
