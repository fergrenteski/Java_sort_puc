import algoritmos.AlgoritmosOrdenacao;
import estruturas.ListaDinamica;
import modelo.ResultadoTeste;
import modelo.ListaResultados;
import relatorio.GeradorRelatorio;
import util.LeitorCSV;

/**
 * Classe principal para executar a análise de algoritmos de ordenação
 */
public class AnalisadorOrdenacao {
    
    public static void main(String[] args) {
        System.out.println("Iniciando análise de algoritmos de ordenação...\n");
        
        // Cria lista para armazenar todos os resultados
        ListaResultados resultados = new ListaResultados();
        
        // Define os tipos de conjuntos e tamanhos
        String[] tipos = {"aleatorio", "crescente", "decrescente"};
        String[] tiposNome = {"Aleatório", "Crescente", "Decrescente"};
        int[] tamanhos = {100, 1000, 10000};
        
        // Executa testes para cada combinação
        for (int i = 0; i < tipos.length; i++) {
            for (int tamanho : tamanhos) {
                String nomeArquivo = "data/" + tipos[i] + "_" + tamanho + ".csv";
                
                System.out.println("Testando: " + tiposNome[i] + " - " + tamanho + " elementos");
                
                // Lê o arquivo CSV
                ListaDinamica dados = LeitorCSV.lerArquivo(nomeArquivo);
                
                if (dados.tamanho() == 0) {
                    System.err.println("  ERRO: Não foi possível ler o arquivo " + nomeArquivo);
                    continue;
                }
                
                System.out.println("  Arquivo lido com sucesso: " + dados.tamanho() + " elementos");
                
                // Testa Bubble Sort
                testarBubbleSort(dados, tiposNome[i], tamanho, resultados);
                
                // Testa Insertion Sort
                testarInsertionSort(dados, tiposNome[i], tamanho, resultados);
                
                // Testa Quick Sort
                testarQuickSort(dados, tiposNome[i], tamanho, resultados);
                
                System.out.println("  Testes concluídos!\n");
            }
        }
        
        System.out.println("\n=== GERANDO RELATÓRIO ===\n");
        
        // Gera o relatório completo
        GeradorRelatorio.gerarRelatorio(resultados);
        
        System.out.println("\nAnálise concluída com sucesso!");
    }
    
    /**
     * Testa o algoritmo Bubble Sort
     */
    private static void testarBubbleSort(ListaDinamica dados, String tipo, 
                                        int tamanho, ListaResultados resultados) {
        // Cria uma cópia dos dados
        int[] array = dados.paraArray();
        
        // Cria e executa o algoritmo
        AlgoritmosOrdenacao algoritmo = new AlgoritmosOrdenacao();
        algoritmo.bubbleSort(array);
        
        // Armazena o resultado
        ResultadoTeste resultado = new ResultadoTeste(
            "Bubble Sort",
            tipo,
            tamanho,
            algoritmo.getTempoExecucao(),
            algoritmo.getTempoExecucaoMs(),
            algoritmo.getNumeroComparacoes(),
            algoritmo.getNumeroTrocas()
        );
        
        resultados.adicionar(resultado);
        
        System.out.println("    Bubble Sort: " + algoritmo.getTempoExecucaoMs() + " ms");
        
        // Verifica se está ordenado
        if (!verificarOrdenacao(array)) {
            System.err.println("    ERRO: Array não foi ordenado corretamente!");
        }
    }
    
    /**
     * Testa o algoritmo Insertion Sort
     */
    private static void testarInsertionSort(ListaDinamica dados, String tipo, 
                                           int tamanho, ListaResultados resultados) {
        // Cria uma cópia dos dados
        int[] array = dados.paraArray();
        
        // Cria e executa o algoritmo
        AlgoritmosOrdenacao algoritmo = new AlgoritmosOrdenacao();
        algoritmo.insertionSort(array);
        
        // Armazena o resultado
        ResultadoTeste resultado = new ResultadoTeste(
            "Insertion Sort",
            tipo,
            tamanho,
            algoritmo.getTempoExecucao(),
            algoritmo.getTempoExecucaoMs(),
            algoritmo.getNumeroComparacoes(),
            algoritmo.getNumeroTrocas()
        );
        
        resultados.adicionar(resultado);
        
        System.out.println("    Insertion Sort: " + algoritmo.getTempoExecucaoMs() + " ms");
        
        // Verifica se está ordenado
        if (!verificarOrdenacao(array)) {
            System.err.println("    ERRO: Array não foi ordenado corretamente!");
        }
    }
    
    /**
     * Testa o algoritmo Quick Sort
     */
    private static void testarQuickSort(ListaDinamica dados, String tipo, 
                                       int tamanho, ListaResultados resultados) {
        // Cria uma cópia dos dados
        int[] array = dados.paraArray();
        
        // Cria e executa o algoritmo
        AlgoritmosOrdenacao algoritmo = new AlgoritmosOrdenacao();
        algoritmo.quickSort(array);
        
        // Armazena o resultado
        ResultadoTeste resultado = new ResultadoTeste(
            "Quick Sort",
            tipo,
            tamanho,
            algoritmo.getTempoExecucao(),
            algoritmo.getTempoExecucaoMs(),
            algoritmo.getNumeroComparacoes(),
            algoritmo.getNumeroTrocas()
        );
        
        resultados.adicionar(resultado);
        
        System.out.println("    Quick Sort: " + algoritmo.getTempoExecucaoMs() + " ms");
        
        // Verifica se está ordenado
        if (!verificarOrdenacao(array)) {
            System.err.println("    ERRO: Array não foi ordenado corretamente!");
        }
    }
    
    /**
     * Verifica se um array está ordenado
     */
    private static boolean verificarOrdenacao(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
