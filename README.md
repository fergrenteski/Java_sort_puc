# Análise de Algoritmos de Ordenação

## Descrição do Projeto

Este projeto implementa e analisa três algoritmos de ordenação clássicos em Java:
- **Bubble Sort**
- **Insertion Sort**
- **Quick Sort**

O objetivo é comparar o desempenho de cada algoritmo em diferentes cenários, utilizando conjuntos de dados com tamanhos variados (100, 1.000 e 10.000 elementos) e diferentes ordenações iniciais (aleatória, crescente e decrescente).

## Estrutura do Projeto

```
PRBL04/
├── src/
│   ├── AnalisadorOrdenacao.java       # Classe principal
│   ├── algoritmos/
│   │   └── AlgoritmosOrdenacao.java   # Classe unificada com 3 métodos de ordenação
│   ├── estruturas/
│   │   └── ListaDinamica.java         # Lista dinâmica customizada
│   ├── modelo/
│   │   ├── ResultadoTeste.java        # Classe para armazenar resultados
│   │   └── ListaResultados.java       # Lista de resultados
│   ├── relatorio/
│   │   └── GeradorRelatorio.java      # Gerador de relatórios
│   └── util/
│       └── LeitorCSV.java             # Leitor de arquivos CSV
└── data/
    ├── aleatorio_100.csv
    ├── aleatorio_1000.csv
    ├── aleatorio_10000.csv
    ├── crescente_100.csv
    ├── crescente_1000.csv
    ├── crescente_10000.csv
    ├── decrescente_100.csv
    ├── decrescente_1000.csv
    └── decrescente_10000.csv
```

## Características Importantes

### Implementação
- `ListaDinamica`: Implementação customizada de ArrayList
- `ListaResultados`: Lista customizada para armazenar resultados
- `LeitorCSV`: Leitor de arquivos CSV sem Collections

### Algoritmos Implementados

A classe `AlgoritmosOrdenacao` contém **três métodos de ordenação** em um único arquivo:

#### 1. bubbleSort(int[] array)
- Complexidade: O(n²) no pior caso, O(n) no melhor caso
- Otimização com parada antecipada quando não há trocas
- Compara elementos adjacentes e troca se necessário
- Conta comparações e trocas

#### 2. insertionSort(int[] array)
- Complexidade: O(n²) no pior caso, O(n) no melhor caso
- Eficiente para conjuntos pequenos ou quase ordenados
- Constrói a lista ordenada elemento por elemento
- Conta comparações e trocas

#### 3. quickSort(int[] array)
- Complexidade: O(n log n) em média, O(n²) no pior caso
- Implementação recursiva com divisão e conquista
- Particionamento com pivô escolhido como último elemento
- Conta comparações e trocas

### Métricas Coletadas

Para cada teste, o sistema coleta:
- **Tempo de execução** (em nanossegundos e milissegundos)
- **Número de comparações** realizadas
- **Número de trocas** de elementos

## Como Compilar e Executar

### Compilação

#### Opção 1: Usando o script (Recomendado)
```bash
# Dar permissão de execução (apenas uma vez)
chmod +x executar.sh

# Compilar e executar
./executar.sh
```

#### Opção 2: Compilação manual
```bash
# Navegar até o diretório do projeto
cd /Users/fergrenteski/PRBL04

# Criar diretório bin
mkdir -p bin

# Compilar todos os arquivos Java
javac -d bin \
    src/estruturas/ListaDinamica.java \
    src/util/LeitorCSV.java \
    src/algoritmos/AlgoritmosOrdenacao.java \
    src/modelo/ResultadoTeste.java \
    src/modelo/ListaResultados.java \
    src/relatorio/GeradorRelatorio.java \
    src/AnalisadorOrdenacao.java
```

### Execução

```bash
# Executar o programa
java -cp bin AnalisadorOrdenacao
```

## Saída do Programa

O programa gera um relatório completo com:

### 1. Tabela Completa de Resultados
Mostra todos os testes realizados com:
- Algoritmo utilizado
- Tipo de conjunto (Aleatório, Crescente, Decrescente)
- Tamanho do conjunto
- Tempo de execução em milissegundos
- Número de comparações
- Número de trocas

### 2. Resumos por Tipo de Conjunto
Tabelas separadas para cada tipo de ordenação inicial, facilitando a comparação entre algoritmos.

### 3. Análise Detalhada
Análise qualitativa incluindo:
- Comportamento em conjuntos aleatórios
- Comportamento em conjuntos já ordenados
- Comportamento em conjuntos ordenados inversamente
- Conclusões gerais sobre complexidade e escalabilidade
- Recomendações de uso

## Conjuntos de Dados

Os arquivos CSV contêm:
- **Aleatórios**: Números em ordem aleatória
- **Crescentes**: Números já ordenados em ordem crescente (1, 2, 3, ...)
- **Decrescentes**: Números ordenados em ordem decrescente

Tamanhos: 100, 1.000 e 10.000 elementos

## Resultados Esperados

### Conjuntos Aleatórios
- **Quick Sort**: Mais rápido (O(n log n))
- **Insertion Sort**: Intermediário (O(n²))
- **Bubble Sort**: Mais lento (O(n²))

### Conjuntos Crescentes (Já Ordenados)
- **Insertion Sort**: Muito rápido (O(n))
- **Bubble Sort**: Rápido com otimização (O(n))
- **Quick Sort**: Mantém O(n log n)

### Conjuntos Decrescentes (Pior Caso)
- **Quick Sort**: Mais eficiente (O(n log n))
- **Insertion Sort**: Lento (O(n²))
- **Bubble Sort**: Muito lento (O(n²))

## Observações Técnicas

1. **System.nanoTime()**: Usado para medição precisa do tempo de execução
2. **Cópias de Arrays**: Cada algoritmo recebe uma cópia dos dados para garantir testes justos
3. **Validação**: Após cada ordenação, o programa verifica se o array foi ordenado corretamente
4. **Sem Dependências Externas**: Projeto utiliza apenas bibliotecas padrão do Java
5. **Classe Unificada**: Os três algoritmos estão implementados como **métodos** na mesma classe `AlgoritmosOrdenacao`, facilitando a manutenção e organização do código

## Exemplo de Uso da Classe AlgoritmosOrdenacao

```java
// Criar instância da classe
AlgoritmosOrdenacao algoritmo = new AlgoritmosOrdenacao();

// Usar Bubble Sort
int[] dados1 = {5, 2, 8, 1, 9};
algoritmo.bubbleSort(dados1);
System.out.println("Tempo: " + algoritmo.getTempoExecucaoMs() + " ms");

// Usar Insertion Sort
int[] dados2 = {5, 2, 8, 1, 9};
algoritmo.insertionSort(dados2);
System.out.println("Comparações: " + algoritmo.getNumeroComparacoes());

// Usar Quick Sort
int[] dados3 = {5, 2, 8, 1, 9};
algoritmo.quickSort(dados3);
System.out.println("Trocas: " + algoritmo.getNumeroTrocas());
```

## Autor

Trabalho desenvolvido para análise e comparação de algoritmos de ordenação.

## Licença

Projeto educacional - Livre para uso acadêmico.
