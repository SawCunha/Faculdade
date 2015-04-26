#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>
#include "FuncoesAuxiliares.h"
#include "HashExternoLista.h"
#include "HashLinear.h"
#include "HashDuplo.h"
#include "Hash_ABP.h"
#include "HeapSort.h"

/*Calcula e retorna o tamanho da tabela baseado na quantidade de dados a ser
  recebida.*/
unsigned int calcTamTabela(unsigned int qtdDados){
    unsigned int tamanhoTabela;
    tamanhoTabela = procurarNumeroPrimo(qtdDados + (qtdDados * 0.5));
    return tamanhoTabela;
}

/*Procura um número primo maior do que o valor recebido por parâmetro. Retorna
  o número primo encontrado.*/
unsigned int procurarNumeroPrimo(unsigned int numero){
    int i, div = 0, aux = numero;

    while(1){
        for(i = 1; i <= aux; i++)
            if(aux % i == 0)
                div++;

        if(div == 2)
            break;
        aux++;
        div = 0;
    }
    return aux;
}

/*Verifica se o titulo é válido (foi digitado todo em minúsculo).*/
unsigned int validarTitulo(tipoChave chave){
    tipoChave buffer;
    int i, tamanho;

    tamanho = strlen(chave);
    if(tamanho > 8) return 0;

    for(i = 0; i < tamanho; i++)
        buffer[i] = tolower(chave[i]);

    if(!strcmp(buffer,chave))
        return 1;
    return 0;
}

/*Funções Hashing Externo Lista.*/

/*Pesquisa e verifica se o eleitor já votou pra este cargo, caso tenha votado
  retorna 1, caso não tenha, retorna 0.*/
unsigned int pesquisarVotoVereadorTHLista(TabelaLista tabela, tipoChave chave){
    cedulaEleitoral cedula;
    if(pesquisarItemTabelaLista(tabela,chave,&cedula))
    {
        if(cedula.flagVereador == 1)
            return 1;
    }
    return 0;
}

/*Pesquisa e verifica se o eleitor já votou pra este cargo, caso tenha votado
  retorna 1, caso não tenha, retorna 0.*/
unsigned int pesquisarVotoPrefeitoTHLista(TabelaLista tabela, tipoChave chave){
    cedulaEleitoral cedula;
    if(pesquisarItemTabelaLista(tabela,chave,&cedula))
    {
        if(cedula.flagPrefeito == 1)
            return 1;
    }
    return 0;
}

/*Recebe os voto e verifica se o eleitor já tenha votado pra o candidato, caso tenha
  retorna 0. Se o eleitor não tiver votado, computa o voto e retorna 1. A função recebe
  como parâmetros, a tabela que armazenára os titulos dos eleitores e seus respectivos
  votos, a cedula contendo seu titulo e seu voto e a tabela na qual
  serao armazenados os votos.*/
unsigned int cadastraVotoPrefeitoTHLista(TabelaLista tabela, cedulaEleitoral cedula, THashLinear prefeito){
    tipoVoto voto;
    cedulaEleitoral auxiliar;

    /*Verifico se o titulo já votou para está categoria.*/
    if(pesquisarVotoPrefeitoTHLista(tabela,cedula.tituloEleitor)) return 0;

    /*Atribui o valor para o tipoVoto que guardará as informações para apuração..*/
    voto.numeroCandidato = cedula.votoPrefeito;
    voto.qtdDeVotosCandidato = 0;
    cedula.votoPrefeito = 1; /*Sinaliza que o candidato possui um voto.*/

    /*Verificar se o eleitor já está cadastrado (Se votou em outra categoria). Caso
      já esteja cadastrado ele altera apenas inserindo o novo voto na categoria.*/
    if(pesquisarItemTabelaLista(tabela, cedula.tituloEleitor,&auxiliar)){
        auxiliar.flagPrefeito = 1;
        auxiliar.votoPrefeito = cedula.votoPrefeito;
        atualizarItemTabelaLista(tabela, cedula.tituloEleitor,auxiliar);
    }
    else
         inserirItemTabelaLista(tabela,cedula);

    /*Cadastra o voto. Caso ocorra algum erro, retorna 0.*/
    if(!inserirItemTHashLinear(prefeito, voto)) return 0;
    return 1;
}

/*Recebe os voto e verifica se o eleitor já tenha votado pra o candidato, caso tenha
  retorna 0. Se o eleitor não tiver votado, computa o voto e retorna 1. A função recebe
  como parâmetros, a tabela que armazenára os titulos dos eleitores e seus respectivos
  votos, a cedula contendo seu titulo e seu voto e a tabela na qual
  serao armazenados os votos.*/
unsigned int cadastraVotoVereadorTHLista(TabelaLista tabela, cedulaEleitoral cedula, THashLinear vereador){
    tipoVoto voto;
    cedulaEleitoral auxiliar;

    /*Verifico se o titulo já votou para está categoria.*/
    if(pesquisarVotoVereadorTHLista(tabela,cedula.tituloEleitor)) return 0;

    /*Atribui o valor para o tipoVoto que guardará as informações para apuração..*/
    voto.numeroCandidato = cedula.votoVereador;
    voto.qtdDeVotosCandidato = 0;
    cedula.flagVereador = 1; /*Sinaliza que o candidato possui votos.*/

    /*Verificar se o eleitor já está cadastrado (Se votou em outra categoria). Caso
      já esteja cadastrado ele altera apenas inserindo o novo voto na categoria.*/
    if(pesquisarItemTabelaLista(tabela, cedula.tituloEleitor,&auxiliar)){
        auxiliar.flagVereador = 1;
        auxiliar.votoVereador = cedula.votoVereador;
        atualizarItemTabelaLista(tabela, cedula.tituloEleitor,auxiliar);
    }
    else
         inserirItemTabelaLista(tabela,cedula);

    /*Cadastra o voto. Caso ocorra algum erro, retorna 0.*/
    if(!inserirItemTHashLinear(vereador, voto)) return 0;

    return 1;
}



/*Funções Hashing Externo Árvore binária de busca.*/

/*Pesquisa e verifica se o eleitor já votou pra este cargo, caso tenha votado
  retorna 1, caso não tenha, retorna 0.*/
unsigned int pesquisarVotoVereadorTHArvore(HashTabelaArvore tabela, tipoChave chave){
    cedulaEleitoral cedula;
    if(pesquisaItemTabelaArvore(tabela,chave,&cedula))
    {
        if(cedula.flagVereador == 1)
            return 1;
    }
    return 0;
}

/*Pesquisa e verifica se o eleitor já votou pra este cargo, caso tenha votado
  retorna 1, caso não tenha, retorna 0.*/
unsigned int pesquisarVotoPrefeitoTHArvore(HashTabelaArvore tabela, tipoChave chave){
    cedulaEleitoral cedula;
    if(pesquisaItemTabelaArvore(tabela,chave,&cedula))
    {
        if(cedula.flagPrefeito == 1)
            return 1;
    }
    return 0;
}

/*Recebe os voto e verifica se o eleitor já tenha votado pra o candidato, caso tenha
  retorna 0. Se o eleitor não tiver votado, computa o voto e retorna 1. A função recebe
  como parâmetros, a tabela que armazenára os titulos dos eleitores e seus respectivos
  votos, a cedula contendo seu titulo e seu voto e a tabela na qual
  serao armazenados os votos.*/
unsigned int cadastraVotoPrefeitoTHArvore(HashTabelaArvore tabela, cedulaEleitoral cedula, THashLinear prefeito){
    tipoVoto voto;
    cedulaEleitoral auxiliar;

    /*Verifico se o titulo já votou para está categoria.*/
    if(pesquisarVotoPrefeitoTHArvore(tabela,cedula.tituloEleitor)) return 0;

    /*Atribui o valor para o tipoVoto que guardará as informações para apuração..*/
    voto.numeroCandidato = cedula.votoPrefeito;
    voto.qtdDeVotosCandidato = 0;
    cedula.votoPrefeito = 1; /*Sinaliza que o candidato possui um voto.*/

    /*Verificar se o eleitor já está cadastrado (Se votou em outra categoria). Caso
      já esteja cadastrado ele altera apenas inserindo o novo voto na categoria.*/
    if(pesquisaItemTabelaArvore(tabela, cedula.tituloEleitor,&auxiliar)){
        auxiliar.flagPrefeito = 1;
        auxiliar.votoPrefeito = cedula.votoPrefeito;
        insereItemTabelaArvore(tabela, auxiliar);
    }
    else
         insereItemTabelaArvore(tabela,cedula);

    /*Cadastra o voto. Caso ocorra algum erro, retorna 0.*/
    if(!inserirItemTHashLinear(prefeito, voto)) return 0;

    return 1;
}

/*Recebe os voto e verifica se o eleitor já tenha votado pra o candidato, caso tenha
  retorna 0. Se o eleitor não tiver votado, computa o voto e retorna 1. A função recebe
  como parâmetros, a tabela que armazenára os titulos dos eleitores e seus respectivos
  votos, a cedula contendo seu titulo e seu voto e a tabela na qual
  serao armazenados os votos.*/
unsigned int cadastraVotoVereadorTHArvore(HashTabelaArvore tabela, cedulaEleitoral cedula, THashLinear vereador){
    tipoVoto voto;
    cedulaEleitoral auxiliar;

    /*Verifico se o titulo já votou para está categoria.*/
    if(pesquisarVotoVereadorTHArvore(tabela,cedula.tituloEleitor)) return 0;

    /*Atribui o valor para o tipoVoto que guardará as informações para apuração..*/
    voto.numeroCandidato = cedula.votoVereador;
    voto.qtdDeVotosCandidato = 0;
    cedula.flagVereador = 1; /*Sinaliza que o candidato possui um voto.*/

    /*Verificar se o eleitor já está cadastrado (Se votou em outra categoria). Caso
      já esteja cadastrado ele altera apenas inserindo o novo voto na categoria.*/
    if(pesquisaItemTabelaArvore(tabela, cedula.tituloEleitor,&auxiliar)){
        auxiliar.flagVereador = 1;
        auxiliar.votoVereador = cedula.votoVereador;
        insereItemTabelaArvore(tabela, auxiliar);
    }
    else
         insereItemTabelaArvore(tabela,cedula);

    /*Cadastra o voto. Caso ocorra algum erro, retorna 0.*/
    if(!inserirItemTHashLinear(vereador, voto)) return 0;

    return 1;
}




/*Funções Hashing Linear Duplo.*/

/*Pesquisa e verifica se o eleitor já votou pra este cargo, caso tenha votado
  retorna 1, caso não tenha, retorna 0.*/
unsigned int pesquisarVotoVereadorTHDupla(THashDupla tabela, tipoChave chave){
    cedulaEleitoral cedula;
    if(pesquisarItemTHashDupla(tabela,chave,&cedula))
    {
        if(cedula.flagVereador == 1)
            return 1;
    }
    return 0;
}

/*Pesquisa e verifica se o eleitor já votou pra este cargo, caso tenha votado
  retorna 1, caso não tenha, retorna 0.*/
unsigned int pesquisarVotoPrefeitoTHDupla(THashDupla tabela, tipoChave chave){
    cedulaEleitoral cedula;
    if(pesquisarItemTHashDupla(tabela,chave,&cedula))
    {
        if(cedula.flagPrefeito == 1)
            return 1;
    }
    return 0;
}

/*Recebe os voto e verifica se o eleitor já tenha votado pra o candidato, caso tenha
  retorna 0. Se o eleitor não tiver votado, computa o voto e retorna 1. A função recebe
  como parâmetros, a tabela que armazenára os titulos dos eleitores e seus respectivos
  votos, a cedula contendo seu titulo e seu voto e a tabela na qual
  serao armazenados os votos.*/
unsigned int cadastraVotoPrefeitoTHDupla(THashDupla tabela, cedulaEleitoral cedula, THashLinear prefeito){
    tipoVoto voto;
    cedulaEleitoral auxiliar;

    /*Verifico se o titulo já votou para está categoria.*/
    if(pesquisarVotoPrefeitoTHDupla(tabela,cedula.tituloEleitor)) return 0;

    /*Atribui o valor para o tipoVoto que guardará as informações para apuração..*/
    voto.numeroCandidato = cedula.votoPrefeito;
    voto.qtdDeVotosCandidato = 0;
    cedula.votoPrefeito = 1; /*Sinaliza que o candidato possui um voto.*/

    /*Verificar se o eleitor já está cadastrado (Se votou em outra categoria). Caso
      já esteja cadastrado ele altera apenas inserindo o novo voto na categoria.*/
    if(pesquisarItemTHashDupla(tabela, cedula.tituloEleitor,&auxiliar)){
        auxiliar.flagPrefeito = 1;
        auxiliar.votoPrefeito = cedula.votoPrefeito;
        atualizarItemTHashDupla(tabela, cedula.tituloEleitor,auxiliar);
    }
    else
         inserirItemTHashDupla(tabela,cedula);

    /*Cadastra o voto. Caso ocorra algum erro, retorna 0.*/
    if(!inserirItemTHashLinear(prefeito, voto)) return 0;

    return 1;
}

/*Recebe os voto e verifica se o eleitor já tenha votado pra o candidato, caso tenha
  retorna 0. Se o eleitor não tiver votado, computa o voto e retorna 1. A função recebe
  como parâmetros, a tabela que armazenára os titulos dos eleitores e seus respectivos
  votos, a cedula contendo seu titulo e seu voto e a tabela na qual
  serao armazenados os votos.*/
unsigned int cadastraVotoVereadorTHDupla(THashDupla tabela, cedulaEleitoral cedula, THashLinear vereador){
    tipoVoto voto;
    cedulaEleitoral auxiliar;

    /*Verifico se o titulo já votou para está categoria.*/
    if(pesquisarVotoVereadorTHDupla(tabela,cedula.tituloEleitor)) return 0;

    /*Atribui o valor para o tipoVoto que guardará as informações para apuração..*/
    voto.numeroCandidato = cedula.votoVereador;
    voto.qtdDeVotosCandidato = 0;
    cedula.flagVereador = 1; /*Sinaliza que o candidato possui um voto.*/

    /*Verificar se o eleitor já está cadastrado (Se votou em outra categoria). Caso
      já esteja cadastrado ele altera apenas inserindo o novo voto na categoria.*/
    if(pesquisarItemTHashDupla(tabela, cedula.tituloEleitor,&auxiliar)){
        auxiliar.flagVereador = 1;
        auxiliar.votoVereador = cedula.votoVereador;
        atualizarItemTHashDupla(tabela, cedula.tituloEleitor,auxiliar);
    }
    else
         inserirItemTHashDupla(tabela,cedula);

    /*Cadastra o voto. Caso ocorra algum erro, retorna 0.*/
    if(!inserirItemTHashLinear(vereador, voto)) return 0;

    return 1;
}
/*Remove os votos dos Eleitor removido.*/
void retiraVotos(THashLinear prefeito,THashLinear vereador,cedulaEleitoral cedula){
    int rt=0, rt1=0;
    unsigned int totalDeVotos;
    tipoVoto votosPrefeito, votosVereador;
    /*Usa a flagPrefeito para verificar se o usuario voto no prefeito.*/
    if(cedula.flagPrefeito == 1){
        /*Atualiza o voto do candidato, primeiro remove o voto da tabela Hash
        decrementa a quantidade de votos e depois insere na tabela de novo.*/
        if(removerItemTHashLinear(prefeito,cedula.votoPrefeito,&votosPrefeito)){
            votosPrefeito.qtdDeVotosCandidato--;
            inserirItemTHashLinear(prefeito,votosPrefeito);
            rt = 1;
        }
    }
    if(cedula.flagVereador == 1){
         /*Atualiza o voto do candidato, primeiro remove o voto da tabela Hash
        decrementa a quantidade de votos e depois insere na tabela de novo.*/
       if(removerItemTHashLinear(vereador,cedula.votoVereador,&votosVereador)){
            votosVereador.qtdDeVotosCandidato--;
            inserirItemTHashLinear(vereador,votosVereador);
            rt1 = 1;
        }
    }

    totalDeVotos = totalDeVotosNoSistema(prefeito,vereador);
    if(rt == 1 || rt1 == 1)
         printf("\nMeliante removido, %d voto(s) válidos no sistema.",totalDeVotos);
    else
         printf("\nMeliante não removido, %d voto(s) válidos no sistema.",totalDeVotos);
}

/*Remove o Eleitor do Hash Arvore Binaria e remove os votos*/
int removeEleitorHashArvore(HashTabelaArvore tabelaArvore,THashLinear prefeito,THashLinear vereador){
    cedulaEleitoral cedula;
    tipoChave chave;

    printf("\nForneça o Titulo de Eleitor: ");
    setbuf(stdin,NULL);
    /*Le o titulo de eleitor a ser removido.*/
    fgets(chave,TAMANHO_CHAVE,stdin);
    setbuf(stdin,NULL);

    /*Verifica se o titulo de eleitor está no Hash*/
    if(removeItemTabelaArvore(tabelaArvore,chave,&cedula)){
        retiraVotos(prefeito,vereador,cedula);
        return 1;
    }
    return 0;
}

/*Remove o Eleitor do Hash Duplo e remove os votos*/
int removeEleitorHashDupla(THashDupla tabelaDupla,THashLinear prefeito,THashLinear vereador){
    cedulaEleitoral cedula;
    tipoChave chave;

    printf("\nForneça o Titulo de Eleitor: ");
    setbuf(stdin,NULL);
    /*Le o titulo de eleitor a ser removido.*/
    fgets(chave,TAMANHO_CHAVE,stdin);
    setbuf(stdin,NULL);

    /*Verifica se o titulo de eleitor está no Hash*/
    if(removerItemTHashDupla(tabelaDupla,chave,&cedula)){
        retiraVotos(prefeito,vereador,cedula);
        return 1;
    }
    return 0;
}

/*Remove o Eleitor do Hash Externo e remove os votos*/
int removeEleitorHashExterno(TabelaLista tabelaLista,THashLinear prefeito,THashLinear vereador){
    cedulaEleitoral cedula;
    tipoChave chave;

    printf("\nForneça o Titulo de Eleitor: ");
    setbuf(stdin,NULL);
    /*Le o titulo de eleitor a ser removido.*/
    fgets(chave,TAMANHO_CHAVE,stdin);
    setbuf(stdin,NULL);

    /*Verifica se o titulo de eleitor está no Hash*/
    if(removerItemTabelaLista(tabelaLista,chave,&cedula)){
        retiraVotos(prefeito,vereador,cedula);
        return 1;
    }
    return 0;
}

unsigned int totalDeVotosNoSistema(THashLinear prefeito, THashLinear vereador){
    int indice = 0, totalDeVotos = 0;
    tipoVoto voto;
    for(indice = 0; indice < prefeito->quantidadeDados; indice++)
        if(prefeito->campoDeControle[indice] == 1){
                voto = prefeito->votos[indice];
            totalDeVotos += voto.qtdDeVotosCandidato;
        }

    for(indice = 0; indice < vereador->quantidadeDados; indice++)
        if(vereador->campoDeControle[indice] == 1){
                voto = vereador->votos[indice];
            totalDeVotos += voto.qtdDeVotosCandidato;
        }
    return totalDeVotos;
}

/*Apura os votos de todos os candidatos. E exibe o numero de candidatos que o usuario informar.
E o ususario informa se deseja apurar os votos do prefeito ou vereador.*/
void apurarVotos(THashLinear prefeito,THashLinear vereador,int classeCandidato ,unsigned int tamanhoRanking){
    int indice, tamanhoTotal = 0, votosRepetido = 0, posicao;
    tipoVoto *voto;
    tipoVoto votoRepetido;
    /*Verifica se o dessa apurar o votos de Prefeito ou vereador.*/
    if(classeCandidato == 0){
        tamanhoTotal = prefeito->quantidadeDados;
        /*Aloca espaço para o vetor de votos.*/
         voto = (tipoVoto*)malloc(sizeof(tipoVoto)*tamanhoTotal);
         for(indice = 0; indice < tamanhoTotal;indice++){
            /*Verifica se aposiçao da tabela Hash esta ocupada, caso esteja
            copia para o vetor de votos.*/
            if(prefeito->campoDeControle[indice] == 1)
                voto[indice] = prefeito->votos[indice];
         }
    }else{
        tamanhoTotal = vereador->quantidadeDados;
        /*Aloca espaço para o vetor de votos.*/
        voto = (tipoVoto*)malloc(sizeof(tipoVoto)*tamanhoTotal);
        for(indice = 0; indice < tamanhoTotal;indice++){
            /*Verifica se aposiçao da tabela Hash esta ocupada, caso esteja
            copia para o vetor de votos.*/
            if(vereador->campoDeControle[indice] == 1)
                voto[indice] = vereador->votos[indice];
         }
    }

    /*Verifica se a candidatos empatados, caso tenha a variavel votosRepetidos vai
    receber o valor 1. caso nao continuara com o valor 0.*/
    votoRepetido = voto[0];
    for(indice = 1; indice < tamanhoTotal;indice++){
        for(posicao = indice;posicao < tamanhoTotal; posicao++)
            if(votoRepetido.qtdDeVotosCandidato == voto[posicao].qtdDeVotosCandidato){
                votosRepetido = 1;
                break;
            }
        votoRepetido = voto[indice];
    }
    /*verifica se a canditados empatatos*/
    if(votosRepetido == 0){
        /*Ordena o vetor voto pela quantidade de votos.*/
        heapSort(voto,tamanhoTotal);
        for(indice = tamanhoRanking-1;indice >= 0 ;indice--)
            printf("\n %d  %d",voto[indice].numeroCandidato,voto[indice].qtdDeVotosCandidato);
    }else{
        /*Ordena pelo numero do candidato.*/
        heapSort1(voto,tamanhoTotal);
        for(indice = 0;indice < tamanhoRanking ;indice++)
            printf("\n %d  %d",voto[indice].numeroCandidato,voto[indice].qtdDeVotosCandidato);
    }
}
