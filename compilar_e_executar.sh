#!/bin/bash

# Script para compilar e executar o projeto de análise de ordenação

echo "=== Compilando o projeto ==="
echo ""

# Cria o diretório bin se não existir
mkdir -p bin

# Compila todos os arquivos Java
javac -d bin \
    src/estruturas/ListaDinamica.java \
    src/util/LeitorCSV.java \
    src/algoritmos/AlgoritmosOrdenacao.java \
    src/modelo/ResultadoTeste.java \
    src/modelo/ListaResultados.java \
    src/relatorio/GeradorRelatorio.java \
    src/AnalisadorOrdenacao.java

if [ $? -eq 0 ]; then
    echo "✓ Compilação concluída com sucesso!"
    echo ""
    echo "=== Executando o programa ==="
    echo ""
    
    # Executa o programa
    java -cp bin AnalisadorOrdenacao
    
    echo ""
    echo "=== Execução finalizada ==="
else
    echo "✗ Erro na compilação!"
    exit 1
fi
