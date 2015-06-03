#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "FuncoesAuxiliares.h"
#include "ControleEleitoral.h"

int main()
{
    //Declara as vari�veis que ser�o utilizadas no programa.
    void *tabela;
    THashLinear prefeito, vereador;
    int tipo, tamTabEleitores, tamTabVereador, tamTabPrefeito, operacao;
    //cedulaEleitoral cedula;

    //Abre o arquivo que sera usando para leitura dos dados.
    FILE* arquivoEntrada = fopen("votos.txt","r");
    if(!arquivoEntrada)
        exit(1);

    //Abre o arquivo que ser� usado para escrita das saidas.
    FILE* arquivoSaida = fopen("saida.txt","w+");
    if(!arquivoSaida)
        exit(1);
    /*
    Le as primeiras linhas do arquivo, a primeira equivale ao tipo de estrutura que ser� utilizada.
    A segunda linha equivale ao tamanho das tabelas que ser�o criadas.*/
    fscanf(arquivoEntrada,"%d",&tipo);
    fscanf(arquivoEntrada,"%d %d %d",&tamTabEleitores,&tamTabPrefeito, &tamTabVereador);

    //Calcula o tamanho das tabelas.
    tamTabEleitores = calcTamTabela(tamTabEleitores);
    tamTabPrefeito = calcTamTabela(tamTabPrefeito);
    tamTabVereador = calcTamTabela(tamTabVereador);

    //Inicializa as tabelas.
    tabela = inicializaTabela(tipo,tamTabEleitores);
    prefeito = criarTHashLinear(tamTabPrefeito);
    vereador = criarTHashLinear(tamTabVereador);

    do{
        //L� a opera��o que ser� processada
        fscanf(arquivoEntrada,"%d",&operacao);
        setbuf(stdin, NULL);
        switch(operacao){
            case 0: votacao(tabela,tipo,prefeito, vereador,arquivoEntrada,arquivoSaida); break;
            //case 1: apurarVotos(tabela); break;
            //case 2: removerVoto(tabela); break;
        }

    }while(operacao != 3);

    //Libera a mem�ria alocada para as tabelas.
    terminaTabelasEleicao(tabela,tipo,prefeito,vereador);

    //Fecha os arquivos utilizados.
    fclose(arquivoSaida);
    fclose(arquivoEntrada);
    return 0;

}
