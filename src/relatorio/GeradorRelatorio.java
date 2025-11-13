package relatorio;

import modelo.ResultadoTeste;
import modelo.ListaResultados;

/**
 * Classe para gerar relatórios de análise dos algoritmos de ordenação
 */
public class GeradorRelatorio {
    
    /**
     * Gera um relatório completo em formato texto
     */
    public static void gerarRelatorio(ListaResultados resultados) {
        imprimirCabecalho();
        imprimirTabelaCompleta(resultados);
        imprimirResumo(resultados);
        imprimirAnalise(resultados);
    }
    
    private static void imprimirCabecalho() {
        System.out.println("================================================================================");
        System.out.println("           ANÁLISE DE ALGORITMOS DE ORDENAÇÃO");
        System.out.println("================================================================================");
        System.out.println();
    }
    
    /**
     * Imprime uma tabela com todos os resultados
     */
    private static void imprimirTabelaCompleta(ListaResultados resultados) {
        System.out.println("TABELA COMPLETA DE RESULTADOS");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.printf("%-15s %-15s %-10s %-15s %-12s %-12s%n",
                "Algoritmo", "Tipo", "Tamanho", "Tempo (ms)", "Comparações", "Trocas");
        System.out.println("--------------------------------------------------------------------------------");
        
        for (int i = 0; i < resultados.tamanho(); i++) {
            ResultadoTeste r = resultados.obter(i);
            System.out.printf("%-15s %-15s %-10d %-15.4f %-12d %-12d%n",
                    r.getAlgoritmo(),
                    r.getTipoConjunto(),
                    r.getTamanhoConjunto(),
                    r.getTempoMili(),
                    r.getComparacoes(),
                    r.getTrocas());
        }
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println();
    }
    
    /**
     * Imprime tabelas resumidas por tipo de conjunto
     */
    private static void imprimirResumo(ListaResultados resultados) {
        String[] tipos = {"Aleatório", "Crescente", "Decrescente"};
        int[] tamanhos = {100, 1000, 10000};
        
        for (String tipo : tipos) {
            System.out.println("RESUMO - " + tipo.toUpperCase());
            System.out.println("--------------------------------------------------------------------------------");
            System.out.printf("%-15s", "Tamanho");
            System.out.printf("%-20s %-20s %-20s%n", "Bubble Sort (ms)", "Insertion Sort (ms)", "Quick Sort (ms)");
            System.out.println("--------------------------------------------------------------------------------");
            
            for (int tamanho : tamanhos) {
                System.out.printf("%-15d", tamanho);
                
                double tempoBubble = buscarTempo(resultados, "Bubble Sort", tipo, tamanho);
                double tempoInsertion = buscarTempo(resultados, "Insertion Sort", tipo, tamanho);
                double tempoQuick = buscarTempo(resultados, "Quick Sort", tipo, tamanho);
                
                System.out.printf("%-20.4f %-20.4f %-20.4f%n", tempoBubble, tempoInsertion, tempoQuick);
            }
            
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println();
        }
    }
    
    /**
     * Busca o tempo de execução para um teste específico
     */
    private static double buscarTempo(ListaResultados resultados, String algoritmo, 
                                     String tipo, int tamanho) {
        for (int i = 0; i < resultados.tamanho(); i++) {
            ResultadoTeste r = resultados.obter(i);
            if (r.getAlgoritmo().equals(algoritmo) && 
                r.getTipoConjunto().equals(tipo) && 
                r.getTamanhoConjunto() == tamanho) {
                return r.getTempoMili();
            }
        }
        return 0.0;
    }
    
    /**
     * Imprime análise detalhada dos resultados
     */
    private static void imprimirAnalise(ListaResultados resultados) {
        System.out.println("================================================================================");
        System.out.println("ANÁLISE DOS RESULTADOS");
        System.out.println("================================================================================");
        System.out.println();
        
        analisarConjuntoAleatorio(resultados);
        analisarConjuntoCrescente(resultados);
        analisarConjuntoDecrescente(resultados);
        analisarComportamentoGeral(resultados);
    }
    
    private static void analisarConjuntoAleatorio(ListaResultados resultados) {
        System.out.println("1. CONJUNTO ALEATÓRIO");
        System.out.println("   - Características: Dados em ordem aleatória");
        System.out.println();
        
        String melhor = encontrarMaisRapido(resultados, "Aleatório", 10000);
        
        System.out.println("   Análise:");
        System.out.println("   • Quick Sort: Geralmente o mais eficiente, com complexidade O(n log n)");
        System.out.println("     em média. Divide o problema recursivamente.");
        System.out.println();
        System.out.println("   • Insertion Sort: Desempenho moderado O(n²) no caso médio, mas pode");
        System.out.println("     ser eficiente para conjuntos pequenos.");
        System.out.println();
        System.out.println("   • Bubble Sort: Geralmente o mais lento O(n²), pois precisa fazer");
        System.out.println("     múltiplas passagens pelo array.");
        System.out.println();
        System.out.println("   Algoritmo mais eficiente: " + melhor);
        System.out.println();
    }
    
    private static void analisarConjuntoCrescente(ListaResultados resultados) {
        System.out.println("2. CONJUNTO JÁ ORDENADO (CRESCENTE)");
        System.out.println("   - Características: Melhor caso para alguns algoritmos");
        System.out.println();
        
        String melhor = encontrarMaisRapido(resultados, "Crescente", 10000);
        
        System.out.println("   Análise:");
        System.out.println("   • Bubble Sort: Beneficia-se da otimização de parada antecipada,");
        System.out.println("     atingindo O(n) quando já ordenado.");
        System.out.println();
        System.out.println("   • Insertion Sort: Muito eficiente O(n), pois cada elemento já está");
        System.out.println("     na posição correta.");
        System.out.println();
        System.out.println("   • Quick Sort: Mantém O(n log n), mas pode não se beneficiar tanto");
        System.out.println("     do caso já ordenado.");
        System.out.println();
        System.out.println("   Algoritmo mais eficiente: " + melhor);
        System.out.println();
    }
    
    private static void analisarConjuntoDecrescente(ListaResultados resultados) {
        System.out.println("3. CONJUNTO ORDENADO DECRESCENTE");
        System.out.println("   - Características: Pior caso para muitos algoritmos");
        System.out.println();
        
        String melhor = encontrarMaisRapido(resultados, "Decrescente", 10000);
        
        System.out.println("   Análise:");
        System.out.println("   • Bubble Sort: Pior caso O(n²), precisa fazer todas as trocas");
        System.out.println("     possíveis.");
        System.out.println();
        System.out.println("   • Insertion Sort: Pior caso O(n²), cada elemento precisa ser movido");
        System.out.println("     para o início do array.");
        System.out.println();
        System.out.println("   • Quick Sort: Mantém eficiência O(n log n) mesmo no pior caso,");
        System.out.println("     desde que o pivô seja bem escolhido.");
        System.out.println();
        System.out.println("   Algoritmo mais eficiente: " + melhor);
        System.out.println();
    }
    
    private static void analisarComportamentoGeral(ListaResultados resultados) {
        System.out.println("4. CONCLUSÕES GERAIS");
        System.out.println();
        System.out.println("   Complexidade Temporal:");
        System.out.println("   • Bubble Sort:     Melhor: O(n)    Médio: O(n²)   Pior: O(n²)");
        System.out.println("   • Insertion Sort:  Melhor: O(n)    Médio: O(n²)   Pior: O(n²)");
        System.out.println("   • Quick Sort:      Melhor: O(n log n) Médio: O(n log n) Pior: O(n²)*");
        System.out.println("   * Com escolha adequada de pivô, raramente atinge O(n²)");
        System.out.println();
        System.out.println("   Escalabilidade:");
        System.out.println("   • Para conjuntos pequenos (100 elementos): Diferenças mínimas");
        System.out.println("   • Para conjuntos médios (1.000 elementos): Quick Sort começa a se destacar");
        System.out.println("   • Para conjuntos grandes (10.000+ elementos): Quick Sort é significativamente");
        System.out.println("     mais rápido que os algoritmos O(n²)");
        System.out.println();
        System.out.println("   Recomendações:");
        System.out.println("   • Quick Sort: Melhor escolha para conjuntos grandes e dados aleatórios");
        System.out.println("   • Insertion Sort: Eficiente para conjuntos pequenos ou quase ordenados");
        System.out.println("   • Bubble Sort: Uso educacional, não recomendado para produção");
        System.out.println();
        System.out.println("================================================================================");
    }
    
    /**
     * Encontra o algoritmo mais rápido para um tipo e tamanho específicos
     */
    private static String encontrarMaisRapido(ListaResultados resultados, String tipo, int tamanho) {
        double menorTempo = Double.MAX_VALUE;
        String algoritmoMaisRapido = "";
        
        String[] algoritmos = {"Bubble Sort", "Insertion Sort", "Quick Sort"};
        
        for (String algoritmo : algoritmos) {
            double tempo = buscarTempo(resultados, algoritmo, tipo, tamanho);
            if (tempo > 0 && tempo < menorTempo) {
                menorTempo = tempo;
                algoritmoMaisRapido = algoritmo;
            }
        }
        
        return algoritmoMaisRapido;
    }
}
