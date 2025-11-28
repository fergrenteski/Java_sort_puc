package modelo;

/**
 * Classe para armazenar e gerenciar uma lista de resultados de testes
 */
public class ListaResultados {
    private ResultadoTeste[] resultados;
    private int tamanho;
    private int capacidade;
    
    public ListaResultados() {
        this.capacidade = 30; // Capacidade para todos os testes
        this.resultados = new ResultadoTeste[capacidade];
        this.tamanho = 0;
    }
    
    public void adicionar(ResultadoTeste resultado) {
        if (tamanho == capacidade) {
            redimensionar();
        }
        resultados[tamanho] = resultado;
        tamanho++;
    }
    
    public ResultadoTeste obter(int indice) {
        if (indice < 0 || indice >= tamanho) {
            throw new IndexOutOfBoundsException("Índice inválido: " + indice);
        }
        return resultados[indice];
    }
    
    public int tamanho() {
        return tamanho;
    }
    
    private void redimensionar() {
        capacidade = capacidade * 2;
        ResultadoTeste[] novoArray = new ResultadoTeste[capacidade];
        for (int i = 0; i < tamanho; i++) {
            novoArray[i] = resultados[i];
        }
        resultados = novoArray;
    }
}
