#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "HeapSort.h"

void heapRefaz(tipoVoto *v, int esq, int dir)
{
    int i = esq;
    int j = i*2 + 1; /*Primeiro filho de i*/

    tipoVoto aux = v[i]; /*aux = no i (pai de j).*/

    while(j <= dir){
        if(j < dir && v[j].qtdDeVotosCandidato < v[j + 1].qtdDeVotosCandidato)
            j++; /*j recebe o outro filho de i*/
        if(aux.qtdDeVotosCandidato >= v[j].qtdDeVotosCandidato)
            break;
        v[i] = v[j];
        i = j;
        j = i*2 + 1; /*j = primeiro filho de i*/
    }
    v[i] = aux;
}


void heapConstroi(tipoVoto *v, int n)
{
    int esq;
    esq = (n / 2) - 1; /*esq = nó anterior ao primeiro nó folha do heap*/
    while(esq >= 0){
        heapRefaz(v, esq, n-1);
        esq--;
    }
}


void heapSort(tipoVoto *v, int n)
{
    tipoVoto aux;

    heapConstroi(v,n);

    while(n > 1){
        aux = v[n - 1];
        v[n - 1] = v[0];
        v[0] = aux;
        n--;
        heapRefaz(v,0,n - 1); /*Refaz o heap.*/
    }
}

void heapRefaz1(tipoVoto *v, int esq, int dir)
{
    int i = esq;
    int j = i*2 + 1; /*Primeiro filho de i*/

    tipoVoto aux = v[i]; /*aux = no i (pai de j).*/

    while(j <= dir){
        if(j < dir && v[j].numeroCandidato < v[j + 1].numeroCandidato)
            j++; /*j recebe o outro filho de i*/
        if(aux.numeroCandidato >= v[j].numeroCandidato)
            break;
        v[i] = v[j];
        i = j;
        j = i*2 + 1; /*j = primeiro filho de i*/
    }
    v[i] = aux;
}


void heapConstroi1(tipoVoto *v, int n)
{
    int esq;
    esq = (n / 2) - 1; /*esq = nó anterior ao primeiro nó folha do heap*/
    while(esq >= 0){
        heapRefaz1(v, esq, n-1);
        esq--;
    }
}


void heapSort1(tipoVoto *v, int n)
{
    tipoVoto aux;

    heapConstroi(v,n);

    while(n > 1){
        aux = v[n - 1];
        v[n - 1] = v[0];
        v[0] = aux;
        n--;
        heapRefaz1(v,0,n - 1); /*Refaz o heap.*/
    }
}
