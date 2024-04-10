package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last; //Referencia para o ultimo nó da list

	//Construtor, faz com que qnd a list estiver vazia os nós apontem para o msm lugar
	public DoubleLinkedListImpl() {
		this.head = new DoubleLinkedListNode<T>(); //Inicializa a cabeça como novo nó
		this.last = (DoubleLinkedListNode<T>) head; //Ultimo nó como a cabeça.
	}

//Met. para inserir um elemento no inicio da lista. 
	@Override
	public void insertFirst(T element) {
		// Verifica se o elemento não é nulo
		if (element != null) {
			// Cria um novo nó para o elemento
			DoubleLinkedListNode<T> node = new DoubleLinkedListNode<>();
			// Define o elemento no novo nó
			node.setData(element);
			// Define o próximo nó como o nó atual da cabeça da lista
			node.setNext(this.getHead());
			// Define o nó anterior como um novo nó vazio
			node.setPrevious(new DoubleLinkedListNode<>());
			// Define o nó anterior da cabeça atual como o novo nó criado
			((DoubleLinkedListNode<T>) this.getHead()).setPrevious(node);
	
			// Verifica se a lista está vazia
			if (this.getHead().isNIL()) {
				// Se a lista está vazia, o novo nó se torna o último nó
				this.setLast(node);
			}
			// Define o novo nó como a cabeça da lista
			this.setHead(node);
		}
	}

	@Override
	public void removeFirst() {
		// Verifica se a lista não está vazia
		if (!this.isEmpty()) {
			// Atualiza a cabeça para o próximo nó, removendo assim o primeiro nó
			this.setHead(this.getHead().getNext());
			
			// Verifica se a lista ficou vazia após a remoção
			if (this.isEmpty()) {
				// Se a lista ficou vazia, ajusta o último nó para apontar para o novo primeiro nó
				this.setLast((DoubleLinkedListNode<T>) this.getHead());
			}
			
			// Define o nó anterior da nova cabeça como um novo nó vazio
			((DoubleLinkedListNode<T>) this.getHead()).setPrevious(new DoubleLinkedListNode<>());
		}
	}

	@Override
	public void removeLast() {
		if (!this.getLast().isNIL()) {
			this.setLast(this.getLast().getPrevious());
			if (this.getLast().isNIL()) {
				this.setHead(this.getLast());
			}
			this.getLast().setNext(new DoubleLinkedListNode<>());
		}
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			DoubleLinkedListNode<T> newLast = new DoubleLinkedListNode<>();
			newLast.setData(element);
			newLast.setPrevious(this.getLast());
			newLast.setNext(new DoubleLinkedListNode<>());

			this.getLast().setNext(newLast);

			if (this.getLast().isNIL()) {
				this.setHead(newLast);
			}
			this.setLast(newLast);
		}
	}

	@Override
	public void remove(T element) {
		if (!this.isEmpty() && element != null) {
			if (this.getHead().getData().equals(element)) {
				this.removeFirst();
			} else {
				DoubleLinkedListNode<T> aux = (DoubleLinkedListNode<T>) this.getHead();
				while (!aux.isNIL() && !aux.getData().equals(element)) {
					aux = (DoubleLinkedListNode<T>) aux.next;
				}
				if (!aux.isNIL()) {
					aux.getPrevious().setNext(aux.getNext());
					((DoubleLinkedListNode<T>) aux.getNext()).setPrevious(aux.getPrevious());
				}
			}
		}
	}

	@Override
	public T search(T element) {
		T found = null;
		if (!this.isEmpty() && element != null) {
			DoubleLinkedListNode<T> auxHead = (DoubleLinkedListNode<T>) this.getHead();
			DoubleLinkedListNode<T> auxLast = this.getLast();

			while (!auxHead.equals(auxLast) && !auxHead.getNext().equals(auxLast) && !auxHead.getData().equals(element)
					&& !auxLast.getData().equals(element)) {
				auxHead = (DoubleLinkedListNode<T>) auxHead.getNext();
				auxLast = auxLast.getPrevious();
			}

			if (auxHead.getData().equals(element)) {
				found = auxHead.getData();
			}

			if (auxLast.getData().equals(element)) {
				found = auxLast.getData();
			}
		}

		return found;

	}

	public DoubleLinkedListNode<T> getLast() {
		return this.last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}