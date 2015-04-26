#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "ControleEleitoral.h"
#include "FuncoesAuxiliares.h"

void votacao(void *tabela, unsigned int tipoDeTabela, THashLinear prefeito, THashLinear vereador,
             FILE *arquivoEntrada, FILE *arquivoSaida){
    int opcao;
    cedulaEleitoral cedula;
    cedula.flagPrefeito = 0;
    cedula.flagVereador = 0;
    tipoVoto voto;

    printf("\nTipo: ");
    fscanf(arquivoEntrada,"%d",&opcao);

    printf("\nTitulo: ");
    fscanf(arquivoEntrada, "%s", cedula.tituloEleitor);

    switch(opcao){
        case 0:
            printf("\nVoto: ");
            fscanf(arquivoEntrada,"%d",&cedula.votoPrefeito);
            cedula.flagPrefeito = 1;

            if(inserirVotoPrefeito(tabela,tipoDeTabela,cedula,prefeito)){
                pesquisarItemTHashLinear(prefeito,cedula.votoPrefeito,&voto);
                fprintf(arquivoSaida,"Voto computado, candidato %d possui %d voto(s).\n", voto.numeroCandidato, voto.qtdDeVotosCandidato);
            }
            else
                fprintf(arquivoSaida,"%s","Voto não computado.\n");
        break;
        case 1:
            printf("\nVoto: ");
            fscanf(arquivoEntrada,"%d",&cedula.votoVereador);
            cedula.flagVereador = 1;

            if(inserirVotoVereador(tabela,tipoDeTabela,cedula,vereador)){
                pesquisarItemTHashLinear(vereador,cedula.votoVereador,&voto);
                fprintf(arquivoSaida,"Voto computado, candidato %d possui %d voto(s).\n", voto.numeroCandidato, voto.qtdDeVotosCandidato);
            }
                else
                    fprintf(arquivoSaida,"%s","Voto não computado.\n");
        break;
    }
}//votacao()

//Inicializa a tabela escolhida para ser utilizada no processo eleitoral.
void* inicializaTabela(unsigned int tipo, unsigned int tamanho){
    void *tabela;
    switch(tipo){
        case 1: return tabela = (THashDupla) criarTHashDupla(tamanho,TAMANHO_CHAVE);
        case 2: return tabela = (TabelaLista) criarTabelaLista(tamanho,TAMANHO_CHAVE);
        case 3: return tabela = (HashTabelaArvore) criaTabelaHashArvore(tamanho,TAMANHO_CHAVE);
    }
    return NULL;
}

//Insere um novo voto para prefeito caso o eleitor não tenha votado para esta categoria.
int inserirVotoPrefeito(void *tabela, unsigned int tipo, cedulaEleitoral cedula, THashLinear prefeito){
    switch(tipo){
        case 1: if(cadastraVotoPrefeitoTHDupla(tabela,cedula, prefeito)) return 1; return 0;
        case 2: if(cadastraVotoPrefeitoTHLista(tabela,cedula, prefeito)) return 1; return 0;
        case 3: if(cadastraVotoPrefeitoTHArvore(tabela,cedula, prefeito)) return 1; return 0;
    }
    return 0;
}

//Insere um novo voto para vereador caso o eleitor não tenha votado para esta categoria.
int inserirVotoVereador(void *tabela, unsigned int tipo, cedulaEleitoral cedula, THashLinear vereador){
    switch(tipo){
        case 1: if(cadastraVotoVereadorTHDupla(tabela,cedula, vereador)) return 1; return 0;
        case 2: if(cadastraVotoVereadorTHLista(tabela,cedula, vereador)) return 1; return 0;
        case 3: if(cadastraVotoVereadorTHArvore(tabela,cedula, vereador)) return 1; return 0;
    }
    return 0;
}

//Remove o eleitor suspeito do cadastro e elimina os votos computados por ele.
int removerEleitor(void *tabela, unsigned int tipo, cedulaEleitoral cedula, THashLinear prefeito, THashLinear vereador){
    switch(tipo){
        case 1: if(removeEleitorHashDupla(tabela,prefeito,vereador)) return 1; return 0;
        case 2: if(removeEleitorHashExterno(tabela,prefeito,vereador)) return 1; return 0;
        case 3: if(removeEleitorHashArvore(tabela,prefeito,vereador)) return 1; return 0;
    }
    return 0;
}

void apuracao(THashLinear prefeito, THashLinear vereador){
    unsigned int classeCandidato, tamanhoRanck;

    printf("tipo: ");
    scanf("%d",&classeCandidato);
    printf("Tamanho Ranck: ");
    scanf("%d",&tamanhoRanck);
    apurarVotos(prefeito,vereador,classeCandidato,tamanhoRanck);
}

//Verifica a tabela que foi utilizada pelo seu tipo, desaloca o espaço reservado e para as tabelas de prefeito e vereador.
void terminaTabelasEleicao(void *tabela, unsigned int tipo, THashLinear prefeito, THashLinear vereador){
    switch(tipo){
        case 1: terminarTHashDupla(tabela); break;
        case 2: terminarTHashDupla(tabela); break;
        case 3: terminarTHashDupla(tabela); break;
    }
    terminarTHashLinear(prefeito);
    terminarTHashLinear(vereador);
}
