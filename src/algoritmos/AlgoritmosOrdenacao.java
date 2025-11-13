package algoritmos;

/**
 * Classe unificada contendo os três algoritmos de ordenação:
 * Bubble Sort, Insertion Sort e Quick Sort
 */
public class AlgoritmosOrdenacao {
    
    private long tempoExecucao;
    private int numeroComparacoes;
    private int numeroTrocas;
    
    public AlgoritmosOrdenacao() {
        this.tempoExecucao = 0;
        this.numeroComparacoes = 0;
        this.numeroTrocas = 0;
    }
    
    /**
     * Algoritmo 1: Bubble Sort
     * Ordena um array comparando pares adjacentes e trocando se necessário
     * Complexidade: O(n²) no pior caso, O(n) no melhor caso
     */
    public void bubbleSort(int[] array) {
        long inicio = System.nanoTime();
        numeroComparacoes = 0;
        numeroTrocas = 0;
        
        int n = array.length;
        boolean trocou;
        
        for (int i = 0; i < n - 1; i++) {
            trocou = false;
            
            for (int j = 0; j < n - i - 1; j++) {
                numeroComparacoes++;
                
                if (array[j] > array[j + 1]) {
                    // Troca os elementos
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    trocou = true;
                    numeroTrocas++;
                }
            }
            
            // Se não houve troca, o array já está ordenado
            if (!trocou) {
                break;
            }
        }
        
        long fim = System.nanoTime();
        tempoExecucao = fim - inicio;
    }
    
    /**
     * Algoritmo 2: Insertion Sort
     * Ordena construindo uma lista ordenada elemento por elemento
     * Complexidade: O(n²) no pior caso, O(n) no melhor caso
     */
    public void insertionSort(int[] array) {
        long inicio = System.nanoTime();
        numeroComparacoes = 0;
        numeroTrocas = 0;
        
        int n = array.length;
        
        for (int i = 1; i < n; i++) {
            int chave = array[i];
            int j = i - 1;
            
            // Move os elementos maiores que a chave uma posição à frente
            while (j >= 0) {
                numeroComparacoes++;
                
                if (array[j] > chave) {
                    array[j + 1] = array[j];
                    j--;
                    numeroTrocas++;
                } else {
                    break;
                }
            }
            
            array[j + 1] = chave;
        }
        
        long fim = System.nanoTime();
        tempoExecucao = fim - inicio;
    }
    
    /**
     * Algoritmo 3: Quick Sort
     * Ordena usando divisão e conquista com particionamento
     * Complexidade: O(n log n) em média, O(n²) no pior caso
     */
    public void quickSort(int[] array) {
        long inicio = System.nanoTime();
        numeroComparacoes = 0;
        numeroTrocas = 0;
        
        quickSortRecursivo(array, 0, array.length - 1);
        
        long fim = System.nanoTime();
        tempoExecucao = fim - inicio;
    }
    
    /**
     * Método auxiliar recursivo do Quick Sort
     */
    private void quickSortRecursivo(int[] array, int inicio, int fim) {
        if (inicio < fim) {
            int indicePivo = particionar(array, inicio, fim);
            
            quickSortRecursivo(array, inicio, indicePivo - 1);
            quickSortRecursivo(array, indicePivo + 1, fim);
        }
    }
    
    /**
     * Particiona o array e retorna o índice do pivô
     */
    private int particionar(int[] array, int inicio, int fim) {
        // Escolhe o último elemento como pivô
        int pivo = array[fim];
        int i = inicio - 1;
        
        for (int j = inicio; j < fim; j++) {
            numeroComparacoes++;
            
            if (array[j] <= pivo) {
                i++;
                
                // Troca array[i] com array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                
                if (i != j) {
                    numeroTrocas++;
                }
            }
        }
        
        // Troca array[i+1] com array[fim] (pivô)
        int temp = array[i + 1];
        array[i + 1] = array[fim];
        array[fim] = temp;
        
        if (i + 1 != fim) {
            numeroTrocas++;
        }
        
        return i + 1;
    }
    
    // ==================== MÉTODOS AUXILIARES ====================
    
    /**
     * Retorna o tempo de execução da última ordenação em nanossegundos
     */
    public long getTempoExecucao() {
        return tempoExecucao;
    }
    
    /**
     * Retorna o tempo de execução em milissegundos
     */
    public double getTempoExecucaoMs() {
        return tempoExecucao / 1_000_000.0;
    }
    
    /**
     * Retorna o número de comparações realizadas
     */
    public int getNumeroComparacoes() {
        return numeroComparacoes;
    }
    
    /**
     * Retorna o número de trocas realizadas
     */
    public int getNumeroTrocas() {
        return numeroTrocas;
    }
}
