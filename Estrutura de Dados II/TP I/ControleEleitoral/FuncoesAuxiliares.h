#ifndef FUNCOESAUXILIARES_H_INCLUDED
#define FUNCOESAUXILIARES_H_INCLUDED

/*Define as estruturas básicas que serão usadas pra a manipulação
  e bom funcionamento do processo eleitoral de Alvinópolis City.*/

#include "HashExternoLista.h"
#include "HashLinear.h"
#include "HashDuplo.h"
#include "Hash_ABP.h"
#include "HeapSort.h"

/*Funções gerais.*/
unsigned int calcTamTabela(unsigned int);
unsigned int validarTitulo(tipoChave);
unsigned int procurarNumeroPrimo(unsigned int);

/*Funçoes cadastro Tabela Hashing Linear Duplo.*/
unsigned int cadastraVotoPrefeitoTHDupla(THashDupla, cedulaEleitoral, THashLinear);
unsigned int cadastraVotoVereadorTHDupla(THashDupla, cedulaEleitoral, THashLinear);
unsigned int pesquisarVotoVereadorTHDupla(THashDupla, tipoChave);
unsigned int pesquisarVotoPrefeitoTHDupla(THashDupla, tipoChave);

/*Funçoes cadastro Tabela Hashing Externo (Lista).*/
unsigned int cadastraVotoPrefeitoTHLista(TabelaLista, cedulaEleitoral, THashLinear);
unsigned int cadastraVotoVereadorTHLista(TabelaLista, cedulaEleitoral, THashLinear);
unsigned int pesquisarVotoVereadorTHLista(TabelaLista, tipoChave);
unsigned int pesquisarVotoPrefeitoTHLista(TabelaLista, tipoChave);

/*Funçoes cadastro Tabela Hashing Externo (ABB).*/
unsigned int cadastraVotoPrefeitoTHArvore(HashTabelaArvore, cedulaEleitoral, THashLinear);
unsigned int cadastraVotoVereadorTHArvore(HashTabelaArvore, cedulaEleitoral, THashLinear);
unsigned int pesquisarVotoVereadorTHArvore(HashTabelaArvore, tipoChave);
unsigned int pesquisarVotoPrefeitoTHArvore(HashTabelaArvore, tipoChave);

/*Separar depois pelas categorias certas.*/
int retirVotos(THashLinear,THashLinear,cedulaEleitoral);
int removeEleitorHashArvore(HashTabelaArvore,THashLinear ,THashLinear );
int removeEleitorHashDupla(THashDupla,THashLinear ,THashLinear );
int removeEleitorHashExterno(TabelaLista,THashLinear ,THashLinear );
unsigned int totalDeVotosNoSistema(THashLinear,THashLinear);
void apurarVotos(THashLinear prefeito,THashLinear vereador,int classeCandidato,unsigned int tamanhoRanking);

#endif
