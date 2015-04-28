#ifndef HEAPSORT_H_INCLUDED
#define HEAPSORT_H_INCLUDED
#include"HashLinear.h"


void heapRefaz(tipoVoto *v, int esq, int dir);
void heapConstroi(tipoVoto *v, int n);
void heapSort(tipoVoto *v, int n);

void heapRefaz1(tipoVoto *v, int esq, int dir);
void heapConstroi1(tipoVoto *v, int n);
void heapSort1(tipoVoto *v, int n);

#endif
