# Aula 07 - 17/08/2026
  - Trabalho( https://github.com/leotgomes2007-byte/pesquisa-ordenacao/tree/main/Codigos/Aula%206/CodigoDaAula/Minhavers%C3%A3o/C%23/source )
  
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


     
