package lista;

public class Lista {
	
	private int pri_ocup;
	private int ult_ocup;
	private int pri_livre;
	private int lista_dados[];
	private int array_prox[];
	private int qtde_itens;
	
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
		qtde_itens = 0;
		
	}
	
	public boolean listaCheia(){
		/*
		*  verifica se o item na posição do pri_livre no array_prox é -1,
		*  se for, ele e o ultimo item, e a lista esta cheia
		*/
		return qtde_itens == lista_dados.length;
	}
	
	public boolean listaVazia(){
		/*
		 *  verifica se o primeiro ocupado(pri_ocup) é igual a -1,
		 *  se for, a lista esta vazia
		 */
		return pri_ocup == -1;
		
	}
	
	
	public void inserirNoFinal(int elemento) throws Exception{
		
		//verifica se a lista esta cheia
		if(listaCheia()) throw new Exception("Lista Cheia");
		
		
		if(listaVazia()) pri_ocup = pri_livre;
		ult_ocup = pri_livre;
		
		//insere o elemento na lista
		lista_dados[pri_livre] = elemento;
		//altera o valor do pri_livre para o proximo livre;
		pri_livre = array_prox[pri_livre];
		
		qtde_itens++;
		

	}//inserirNoFinal
	
	
	public void inserirNoInicio(int elemento) throws Exception{
		
		//verifica se a lista esta cheia
		if(listaCheia()) throw new Exception("Lista Cheia");
		
		//passa o pri_ocup pra uma variavel temporaria
		int temp_pri_ocup = pri_ocup;
		//altera o primeiro ocupado para a pos do item que esta sendo inserido
		pri_ocup = array_prox[ult_ocup];
		System.out.println("Pri oc " +pri_ocup);
		//altera o proximo item do ult_ocup para o do primeiro livre
		array_prox[ult_ocup] = array_prox[pri_livre];
		
		
		//aponta o atual primeiro item da lista para o antigo primeiro atual segundo item
		array_prox[pri_livre] = temp_pri_ocup;
		
		//insere o elemento na lista
		lista_dados[pri_livre] = elemento;
		//altera o valor do pri_livre para o proximo livre;
		pri_livre = array_prox[pri_livre];
		
		qtde_itens++;
		
	}//inserirNoInicio
	
	
	public void inserirNaPosicao(int posicao, int elemento) throws Exception{
		
		//verifica se a lista esta cheia
		if(listaCheia()) throw new Exception("Lista Cheia");
		//verifica se a posição esta dentro dos parâmetros para inserir valor no meio
		if(posicao-1 < 0 || posicao >= array_prox.length) 
			throw new Exception("Posição fora dos parâmetros da lista");
		//insere o elemento na lista
		lista_dados[pri_livre] = elemento;
		
		//variável temporaria para o proximo item da lista
		int pos_proximo_array = array_prox[pri_ocup];
		
		//percorre a lista de posições
		for(int i = 0; i < array_prox.length; i++){
			
			if(i == posicao){
				//variável temporaria para posicao -1
				int temp_pos_item_anterior = array_prox[pos_proximo_array];
			
				array_prox[pos_proximo_array] = pri_livre;
				array_prox[pri_livre] = temp_pos_item_anterior;
						
			}else{
				pos_proximo_array = array_prox[pos_proximo_array];
			}
			
		}
		
		//altera o valor do pri_livre para o proximo livre;
		pri_livre = array_prox[pri_livre];
		
		qtde_itens++;
		
	}//inserirNaPosicao
	
	
	public void inserirAntes(int posicao, int elemento) throws Exception{
		
		
		qtde_itens++;
	}//inserirAntes
	
	public void inserirDepois(int posicao, int elemento) throws Exception{
		
		qtde_itens++;
	}//inserirDepois
	
	public void removerItem(int posicao) throws Exception{
		
		qtde_itens--;
	}//removerItem
	
	public void removerPrimeiro() throws Exception{
		
		qtde_itens--;
	}//removerPrimeiro
	
	public void removerUltimo() throws Exception{
		
		qtde_itens--;
	}//removerUltimo
	
	public boolean buscar(int elemento) throws Exception{
		
		return true;
	
	}//buscarElemento
	
	@Override
	public String toString(){
		
		String array_retorno = "[";
				
		//variável temporaria para o proximo item da lista
		
		int pos_proximo_array = pri_ocup;
				
		//percorre a lista de posições
	
		/*for(int i = 0; i < array_prox.length; i++){			
			
			array_retorno += lista_dados[pos_proximo_array];
			
			if(array_prox[pos_proximo_array] == -1 || qtde_itens-1 == i)break;
			else{
			pos_proximo_array = array_prox[pos_proximo_array];
			array_retorno += ", ";
			}
			
		}*/
		
		System.out.println(pri_ocup);
		for(int i : array_prox){
			array_retorno += i + ", ";
		}
		
		return array_retorno + "]";  
	}
}//


