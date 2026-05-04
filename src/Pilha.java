import java.util.NoSuchElementException;

public class Pilha<E> {

	private Celula<E> topo;
	private Celula<E> fundo;

	public Pilha() {

		Celula<E> sentinela = new Celula<E>();
		fundo = sentinela;
		topo = sentinela;

	}

	public boolean vazia() {
		return fundo == topo;
	}

	public void empilhar(E item) {

		topo = new Celula<E>(item, topo);
	}

	public E desempilhar() {

		E desempilhado = consultarTopo();
		topo = topo.getProximo();
		return desempilhado;

	}

	public E consultarTopo() {

		if (vazia()) {
			throw new NoSuchElementException("Nao há nenhum item na pilha!");
		}

		return topo.getItem();

	}

	/**
	 * Cria e devolve uma nova pilha contendo os primeiros numItens elementos
	 * do topo da pilha atual.
	 * 
	 * Os elementos são mantidos na mesma ordem em que estavam na pilha original.
	 * Caso a pilha atual possua menos elementos do que o valor especificado,
	 * uma exceção será lançada.
	 *
	 * @param numItens o número de itens a serem copiados da pilha original.
	 * @return uma nova instância de Pilha<E> contendo os numItens primeiros elementos.
	 * @throws IllegalArgumentException se a pilha não contém numItens elementos.
	 */
	public Pilha<E> subPilha(int numItens) {
		
		// Contar quantos elementos existem na pilha
		int totalElementos = 0;
		Celula<E> celulaAtual = topo;
		
		while (celulaAtual != fundo) {
			totalElementos++;
			celulaAtual = celulaAtual.getProximo();
		}
		
		// Verificar se há elementos suficientes
		if (numItens > totalElementos || numItens < 0) {
			throw new IllegalArgumentException("A pilha não contém " + numItens + " elementos!");
		}
		
		// Criar nova pilha e copiar os elementos
		Pilha<E> novaPilha = new Pilha<>();
		celulaAtual = topo;
		
		for (int i = 0; i < numItens; i++) {
			novaPilha.empilhar(celulaAtual.getItem());
			celulaAtual = celulaAtual.getProximo();
		}
		
		return novaPilha;
	}
}