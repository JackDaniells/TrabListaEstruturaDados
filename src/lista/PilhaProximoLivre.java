package lista;

public class PilhaProximoLivre {
	
	private int array_pilha[];
	private int primeiro_item;
	
	public PilhaProximoLivre(int tamanho){
		array_pilha = new int [tamanho];
		for(int i = 0; i< tamanho; i++) array_pilha[i] = i;
		
	}

}
