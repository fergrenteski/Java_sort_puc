package modelo;

/**
 * Classe para armazenar os resultados de um teste de ordenação
 */
public class ResultadoTeste {
    private String algoritmo;
    private String tipoConjunto;
    private int tamanhoConjunto;
    private long tempoNano;
    private double tempoMili;
    private int comparacoes;
    private int trocas;
    
    public ResultadoTeste(String algoritmo, String tipoConjunto, int tamanhoConjunto,
                         long tempoNano, double tempoMili, int comparacoes, int trocas) {
        this.algoritmo = algoritmo;
        this.tipoConjunto = tipoConjunto;
        this.tamanhoConjunto = tamanhoConjunto;
        this.tempoNano = tempoNano;
        this.tempoMili = tempoMili;
        this.comparacoes = comparacoes;
        this.trocas = trocas;
    }
    
    public String getAlgoritmo() {
        return algoritmo;
    }
    
    public String getTipoConjunto() {
        return tipoConjunto;
    }
    
    public int getTamanhoConjunto() {
        return tamanhoConjunto;
    }
    
    public long getTempoNano() {
        return tempoNano;
    }
    
    public double getTempoMili() {
        return tempoMili;
    }
    
    public int getComparacoes() {
        return comparacoes;
    }
    
    public int getTrocas() {
        return trocas;
    }
}
