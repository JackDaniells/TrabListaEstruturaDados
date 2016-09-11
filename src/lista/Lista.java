package lista;

import com.sun.org.apache.bcel.internal.generic.DADD;

public class Lista {
	
	private int pri_ocup;
	private int ult_ocup;
	private int pri_livre;
	private int lista_dados[];
	private int array_prox[];
	
	public Lista(int tam){
		
		lista_dados = new int[tam];
		
		//declaração array proximo
		array_prox = new int[tam];
		//preenche o array
		for(int i = 0; i< tam; i++) array_prox[i] = i+1; 
		 //define o ultimo como -1 pra sinalizar fim array
		array_prox[tam -1] = -1;
		
		pri_ocup = -1;
		ult_ocup = -1;
		pri_livre = 0;
		
	}
	
	public boolean listaCheia(){
		/*
		*  verifica se o item na posição do pri_livre no array_prox é -1,
		*  se for, ele e o ultimo item, e a lista esta cheia
		*/
		return array_prox[pri_livre] == -1;
	}
	
	public boolean listaVazia(){
		/*
		 *  verifica se o primeiro ocupado(pri_ocup) é igual a -1,
		 *  se for, a lista esta vazia
		 */
		return pri_livre == -1;
		
	}
	
	
	public void inserirNoFinal(int elemento) throws Exception{
		
		//verifica se a lista esta cheia
		if(listaCheia()) throw new Exception("Lista Cheia");
		//insere o elemento na lista
		lista_dados[pri_livre] = elemento;
		
		if(listaVazia()) pri_ocup = pri_livre;
		pri_ocup = pri_livre;
		
		//altera o valor do pri_livre para o proximo livre;
		pri_livre = array_prox[pri_livre];
	}//inserirNoFinal
	
	
	public void inserirNoInicio(int elemento) throws Exception{
		
		//verifica se a lista esta cheia
		if(listaCheia()) throw new Exception("Lista Cheia");
		//insere o elemento na lista
		lista_dados[pri_livre] = elemento;
		
		//passa o pri_ocup pra uma variavel temporaria
		int temp_pri_ocup = pri_ocup;
		//altera o primeiro ocupado para a pos do item que esta sendo inserido
		pri_ocup = array_prox[ult_ocup];
		//altera o proximo item do ult_ocup para o do primeiro livre
		array_prox[ult_ocup] = array_prox[pri_livre];
		//aponta o atual primeiro item da lista para o antigo primeiro atual segundo item
		array_prox[pri_ocup] = temp_pri_ocup;
		
	}//inserirNoInicio
	
	
	public void inserirNaPosicao(int posicao, int elemento) throws Exception{
		
		//verifica se a lista esta cheia
		if(listaCheia()) throw new Exception("Lista Cheia");
		//verifica se a posição esta dentro dos parâmetros para inserir valor no meio
		if(posicao-1 < 0 || posicao >= array_prox.length) 
			throw new Exception("Posição fora dos parâmetros da lista");
		//insere o elemento na lista
		lista_dados[pri_livre] = elemento;
		
		
		int temp_pos_item_anterior;
		//percorre a lista de posições
		for(int i = 0; i < array_prox.length; i++){
			//encontra a posicao "posicao-"'
			if(array_prox[i] == posicao -1){
				// salva a posição de "posicao-1" em variavel temporaria
				temp_pos_item_anterior = array_prox[i];
				//aponta o "posicao -1" para a nova 
				array_prox[i] = pri_livre;
			}
		}
		
		array_prox[pri_livre] = temp_pos_item_anterior;
		
		
	}//inserirNaPosicao
	
	
	public void inserirAntes(int posicao, int elemento) throws Exception{
		
	}//inserirAntes
	
	public void inserirDepois(int posicao, int elemento) throws Exception{
		
	}//inserirDepois
	
	public void removerItem(int posicao) throws Exception{
		
	}//removerItem
	
	public void removerPrimeiro() throws Exception{
		
	}//removerPrimeiro
	
	public void removerUltimo() throws Exception{
		
	}//removerUltimo
	
	public boolean buscar(int elemento) throws Exception{
	
	}//buscarElemento
	}

