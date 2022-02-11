

public class ListaDuplamenteEncadeadaNaoOrdenada implements TListaMiniProjeto {
	
	private NoDuplo inicio;
	private NoDuplo fim;
	
	@Override
	public void add(String s) throws Exception {
		
		NoDuplo novoElemento = new NoDuplo(s);
		NoDuplo aux = inicio;
		
		if(inicio == null) {
			novoElemento.proximo = null;
			novoElemento.anterior = null;
			inicio = novoElemento;
			fim = novoElemento;
		} else {
			while(aux.proximo != null) {
				if(aux.dado.equals(s)) {
					throw new Exception("Elemento repetido");
				} else {
					aux = aux.proximo;
				}
			}
			novoElemento.proximo = null;
			aux.proximo = novoElemento;
			novoElemento.anterior = aux;
			fim = novoElemento;
		}
	}

	@Override
	public void add(String s, int i) throws Exception {
		
		if(i < 0 || i > size()) {
			throw new Exception("Posição inválida");
		}
		
		NoDuplo novoElemento = new NoDuplo(s);
		NoDuplo aux = inicio;
		
		if(i == 0) {
			if(size() != 0) {
				novoElemento.proximo = aux;
				aux.anterior = novoElemento;
				inicio = novoElemento;
				novoElemento.anterior = null;
			} else {
				inicio = novoElemento;
			}
		} else {
			int cont = 1;
			while (cont < i) {
				aux = aux.proximo;
				cont++;
			}
			novoElemento.proximo = aux.proximo;
			novoElemento.anterior = aux;
			aux.proximo = novoElemento;
		}
		
	}

	@Override
	public String removeIndex(int i) throws Exception {
		
		NoDuplo aux = inicio;
		NoDuplo lixo = null;
		
		if(size() == 0)
			throw new Exception("A lista está vazia");
		if(i<0 || i > size())
			throw new Exception("Indice não existe atualmente na lista");
		
		if(i == 0) {
			lixo = aux;
			aux = aux.proximo;
			inicio = aux;
		}else {
			int cont = 0;
			while(cont<i) {
				aux = aux.proximo;
				cont ++;
			}
			lixo = aux;
			aux.anterior.proximo = aux.proximo;
			if(aux != fim)
				aux.proximo.anterior = aux.anterior;
			else
				fim = aux;
		}
		return lixo.dado;
	}

	@Override
	public void removeElem(String s) throws Exception {
	
		if(size() == 0) {
			throw new Exception ("A lista vazia.");
		}
		
		NoDuplo aux = inicio;
		
		boolean excluiu = false;
		while(aux != null && aux.dado != s) {
			if(aux.dado.equals(s)) {
				if(aux == inicio) {
					inicio = inicio.proximo;
					excluiu = true;
				}else {
					aux.anterior.proximo = aux.proximo;
					aux.proximo = aux.anterior;
					excluiu = true;
				}
			}aux = aux.proximo;
		}
		if(excluiu == false)
			throw new Exception("O elemento não faz parte da lista.");		
	}	

	@Override
	public String previous(String s) throws Exception {
		
		if(size() == 0)
			throw new Exception("Lista está vazia.");
		
		NoDuplo aux = inicio;
		
		while(aux != null) {
			if(aux.dado.equals(s)) {
				if(aux == inicio) {
					throw new Exception("Não existe antecessor.");
				} else {
					return aux.anterior.dado;
				}
			}aux = aux.proximo;
		}		
		throw new Exception("O elemento não faz parte da lista.");
	}

	@Override
	public int index(String s) throws Exception {
		
		if(size() == 0)
			throw new Exception("Lista vazia");
		
		NoDuplo aux = inicio;
		
		int contador = 0;
		while(aux != null) {
			if(aux.dado.equals(s)) {
				return contador;
			}else {
				aux = aux.proximo;
				contador ++;
			}		
		}throw new Exception("O elemento não faz parte da lista.");
	}
		
	@Override
	public String elemen(int i) throws Exception {
		
		if(size() == 0)
			throw new Exception("Lista vazia");
		if(i < 0 || i > size())
			throw new Exception("Indice não existe");
		
		NoDuplo aux = inicio;
		
		int contador = 0;
		while(contador <=i) {
			if(contador == i) {
				return aux.dado;
			}else {
				aux = aux.proximo;
				contador++;
			}
		}
		return aux.dado;
	
	}

	@Override
	public int size() {
		
		NoDuplo aux = inicio;
		int tamanho = 0;
		
		while(aux != null) {
			tamanho ++;
			aux = aux.proximo;
		}
		return tamanho;
	}

	@Override
	public String first() {
		if(size() != 0)
			return inicio.dado;
		return null;
		
	}

	@Override
	public String last() {
		if(size() != 0)
			return fim.dado;
		return null;
	}

	@Override
	public String maior() throws Exception {
		
		if(size() == 0)
			throw new Exception("Lista vazia.");
		
		NoDuplo aux = inicio;
		
		String maior = aux.dado;
		
		while(aux != null) {
			if(aux.dado.compareTo(maior) > 0) {
				maior = aux.dado;
			}else {
				aux = aux.proximo;
			}
		}	
		return maior;
	}

	@Override
	public void print() {		
		System.out.print("LISTA -> ");
		
		NoDuplo aux = inicio;
		
		while (aux != null) {
			System.out.print(aux.dado + " -> ");
			aux = aux.proximo;
			
		}
		System.out.print("NULL\n");
	}

}
