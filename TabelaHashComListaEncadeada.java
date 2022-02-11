import java.util.ArrayList;

public class TabelaHashComListaEncadeada implements THashMiniProjeto {

	//Tabela hash com o método da divisão, com endereçamento fechado e tratamento de colisões usando uma lista encadeada ordenada. 
	private ListaEncadeadaOrdenada[] tabela;
	
	public TabelaHashComListaEncadeada(int tamanho) {
		this.tabela = new ListaEncadeadaOrdenada[tamanho];
		inicializar(tabela, tamanho);
	}
	
	public void inicializar(ListaEncadeadaOrdenada[] tabela, int tamanho) {
		for(int i = 0; i< tamanho; i++) {
			this.tabela[i] = new ListaEncadeadaOrdenada();
		}	
	}
	@Override
	public int hash(int id) {		
		return id % tabela.length;
	}

	@Override
	public boolean isCheia() {
		return false;
	}

	@Override
	public void adicionar(User u) throws Exception {
		int h = hash(u.getId());
		tabela[h].adicionar(u);	
	}

	@Override
	public User recuperar(int id) throws Exception {
		int h = hash(id);
		 
		if(tabela[h].recuperar(id) != null) 
			return tabela[h].recuperar(id);
		throw new Exception("Usuário não encontrado.");
	}

	@Override
	public void print() {
		for(int i = 0; i< tabela.length; i++) {
			System.out.print("[" + i + "] - ");
			tabela[i].print();
		}
		
	}

	@Override
	public void crescer() {
		 
		int tamanho = tabela.length;
		
		ListaEncadeadaOrdenada[] aux = tabela;
		
		ArrayList<User> usuarios = new ArrayList<>();
		
		//Salva todos os usuários da tabela hash dentro do arrayList
		for (int i = 0; i < aux.length; i++) {
			for(int j = 0; j <aux[i].recuperarUsuarios().size();j++) {
				usuarios.add(aux[i].recuperarUsuarios().get(j));
			}
		}
		
		this.tabela = new ListaEncadeadaOrdenada[tamanho *2];
		inicializar(this.tabela, this.tabela.length);
		
		//Redistribui os usuários na tabela hash duplicada 
		for(int i = 0; i < usuarios.size(); i++) {
			try {
				adicionar(usuarios.get(i));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public int qtd() {
		int quantidade = 0;
		for(int i = 0; i< tabela.length;i++) {
			for(int j = 0; j < tabela[i].quantidade(); j++) {
				quantidade++;
			}
		}
		return quantidade;
	}

}
