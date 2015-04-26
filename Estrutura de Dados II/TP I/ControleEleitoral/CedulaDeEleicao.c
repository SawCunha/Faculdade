#include <stdlib.h>
#include <time.h>
#include "CedulaDeEleicao.h"

void gerarPesos(unsigned int tamanho, tipoPesos pesos){
    int i;
    pesos = (tipoPesos) malloc(sizeof(unsigned int)*tamanho);
    srand(time(NULL));
    for(i = 0; i < tamanho; i++)
        pesos[i] = (unsigned int) rand();
}
