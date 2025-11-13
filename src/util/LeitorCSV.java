package util;

import estruturas.ListaDinamica;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Classe para ler arquivos CSV
 */
public class LeitorCSV {
    
    /**
     * Lê um arquivo CSV e retorna uma lista dinâmica com os valores inteiros
     */
    public static ListaDinamica lerArquivo(String caminhoArquivo) {
        ListaDinamica dados = new ListaDinamica();
        BufferedReader leitor = null;
        
        try {
            leitor = new BufferedReader(new FileReader(caminhoArquivo));
            String linha;
            
            while ((linha = leitor.readLine()) != null) {
                linha = linha.trim();
                
                // Ignora linhas vazias
                if (linha.length() == 0) {
                    continue;
                }
                
                try {
                    int valor = Integer.parseInt(linha);
                    dados.adicionar(valor);
                } catch (NumberFormatException e) {
                    // Ignora linhas que não são números
                    System.err.println("Aviso: Linha ignorada (não é um número): " + linha);
                }
            }
            
        } catch (IOException e) {
            System.err.println("Erro ao ler arquivo: " + caminhoArquivo);
            e.printStackTrace();
        } finally {
            if (leitor != null) {
                try {
                    leitor.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        return dados;
    }
    
    /**
     * Verifica se um arquivo existe e pode ser lido
     */
    public static boolean arquivoExiste(String caminhoArquivo) {
        try {
            FileReader fr = new FileReader(caminhoArquivo);
            fr.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
