import java.util.ArrayList;

public class ListaEncadeadaOrdenada {
	
	private Node inicio;
	
	public void adicionar(User usuario) throws Exception {
		
		Node novoElemento = new Node(usuario);
		
		Node aux = inicio;
		Node aux2 = null;
		
		while((aux != null)&&(aux.usuario.getId() < novoElemento.usuario.getId())) {
			aux2 = aux;
			aux = aux.proximo;
		}
		
		if (inicio == null) {
			inicio = novoElemento;		
		} else if(aux == inicio) {
			novoElemento.proximo = inicio;
			inicio = novoElemento;
		}else {
			novoElemento.proximo = aux;
			aux2.proximo = novoElemento;
		}
	}
	
	public User recuperar(int id) {
		
		Node aux = inicio;
		
		while(aux != null) {
			if(aux.usuario.getId() == id) {
				return aux.usuario;
			}aux = aux.proximo;	
		}
		return null;
	}
	
	public ArrayList<User> recuperarUsuarios() {
		
		ArrayList<User> usuarios = new ArrayList<>();
		
		Node aux = inicio;
		
		while(aux != null) {
			usuarios.add(aux.usuario);
			aux = aux.proximo;
		}	
		return usuarios;
	}
	public boolean isVazia() {
		if(inicio == null)
			return true;
		else
			return false;
	}
	
	public void print() {
		
		System.out.print("INICIO -> ");
		
		Node aux = inicio;
		
		while (aux != null) {
			System.out.print(aux.usuario.getNome() + "(ID " + aux.usuario.getId() + ") -> ");
			aux = aux.proximo;
		}
		System.out.print("NULL\n");	

	}
	
	public int quantidade() {
		
		Node aux = inicio;
		int qnt = 0;
		while (aux != null) {
			qnt++;
			aux = aux.proximo;
		}
		return qnt;		
	}
}
	

