#ifndef CONTROLEELEITORAL_H_INCLUDED
#define CONTROLEELEITORAL_H_INCLUDED

#include "FuncoesAuxiliares.h"

void votacao(void *tabela, unsigned int tipo, THashLinear prefeito, THashLinear vereador,
             FILE *arquivoEntrada, FILE *arquivoSaida);
void* inicializaTabela(unsigned int tipo, unsigned int tamanho);
void terminaTabelasEleicao(void *tabela, unsigned int tipo, THashLinear prefeito, THashLinear vereador);
int inserirVotoPrefeito(void *tabela, unsigned int tipo, cedulaEleitoral cedula, THashLinear prefeito);
int inserirVotoVereador(void *tabela, unsigned int tipo, cedulaEleitoral cedula, THashLinear vereador);
void apuracao(THashLinear prefeito, THashLinear vereador);
int removerEleitor(void *tabela, unsigned int tipo, cedulaEleitoral cedula, THashLinear prefeito, THashLinear vereador);
#endif
