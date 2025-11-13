package estruturas;

/**
 * Implementação customizada de uma lista dinâmica (ArrayList)
 */
public class ListaDinamica {
    private int[] elementos;
    private int tamanho;
    private int capacidade;
    
    public ListaDinamica() {
        this.capacidade = 10;
        this.elementos = new int[capacidade];
        this.tamanho = 0;
    }
    
    public ListaDinamica(int capacidadeInicial) {
        this.capacidade = capacidadeInicial;
        this.elementos = new int[capacidade];
        this.tamanho = 0;
    }
    
    /**
     * Adiciona um elemento ao final da lista
     */
    public void adicionar(int elemento) {
        if (tamanho == capacidade) {
            redimensionar();
        }
        elementos[tamanho] = elemento;
        tamanho++;
    }
    
    /**
     * Obtém um elemento pela posição
     */
    public int obter(int indice) {
        if (indice < 0 || indice >= tamanho) {
            throw new IndexOutOfBoundsException("Índice inválido: " + indice);
        }
        return elementos[indice];
    }
    
    /**
     * Define o valor de um elemento em uma posição específica
     */
    public void definir(int indice, int valor) {
        if (indice < 0 || indice >= tamanho) {
            throw new IndexOutOfBoundsException("Índice inválido: " + indice);
        }
        elementos[indice] = valor;
    }
    
    /**
     * Retorna o tamanho atual da lista
     */
    public int tamanho() {
        return tamanho;
    }
    
    /**
     * Converte a lista para um array padrão
     */
    public int[] paraArray() {
        int[] resultado = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            resultado[i] = elementos[i];
        }
        return resultado;
    }
    
    /**
     * Cria uma cópia da lista
     */
    public ListaDinamica copiar() {
        ListaDinamica copia = new ListaDinamica(this.capacidade);
        for (int i = 0; i < this.tamanho; i++) {
            copia.adicionar(this.elementos[i]);
        }
        return copia;
    }
    
    /**
     * Redimensiona o array interno quando necessário
     */
    private void redimensionar() {
        capacidade = capacidade * 2;
        int[] novoArray = new int[capacidade];
        for (int i = 0; i < tamanho; i++) {
            novoArray[i] = elementos[i];
        }
        elementos = novoArray;
    }
    
    /**
     * Verifica se a lista está vazia
     */
    public boolean estaVazia() {
        return tamanho == 0;
    }
    
    /**
     * Limpa todos os elementos da lista
     */
    public void limpar() {
        tamanho = 0;
        elementos = new int[capacidade];
    }
}
