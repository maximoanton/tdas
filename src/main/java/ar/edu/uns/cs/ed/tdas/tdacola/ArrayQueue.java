package ar.edu.uns.cs.ed.tdas.tdacola;

import ar.edu.uns.cs.ed.tdas.excepciones.EmptyQueueException;

public class ArrayQueue<E> implements Queue<E>{
	private int f=0;//almacena el valor que representa el frente de la cola
	private int r=0;//es la posicion en la cual se va a insertar el siguiente elemento en un enqueue, es decir apunta al siguiente slot vacio
	private E[] array;
	private int N;//indica el tamaño minimo del arreglo con N-1
	
	public ArrayQueue(){this(1000);}//constructor que inicializa la cola con una capacidad default

	public ArrayQueue(int c){
		array = (E[])new Object[c];//constructor que crea una cola con capacidad ingresada por el usuario
		N=c;
	}
	
	public int size(){return (r-f+N)%N;}
	
	public boolean isEmpty() {return (f==r);}/*en este caso la se basa en que si la referencia que apunta al elemento en la posicion del frente de la cola es igual
	que la que apunta a la siguiente posicion libre entonces la posicion esta vacia, y por lo tanto la pila esta vacia*/
	
	public void enqueue(E elem) throws IllegalStateException{
		if(size()==N-1) {throw new IllegalStateException("La cola esta llena");}
		else {
			array[r]=elem;//inserto el elemento ingresado por parametro en la posicion r
			r=(r+1)%N;// Aumento r y hago que vuelva a 0 si alcanza N (circular)
		}
	}
	
	public E front() throws EmptyQueueException{
		if(isEmpty()) {throw new EmptyQueueException("La cola esta vacia");}
		else {return array[f];}
	}
	
	public E dequeue() throws EmptyQueueException{
		if(isEmpty()) {throw new EmptyQueueException("La cola esta vacia");}
		else {
			E elem=array[f];//guardo el elemento en una variable nueva local
			array[f]=null;//vacio la cola en la posicion f para ayudar al recolector de basura de java
			f=(f+1)%N;//actualizo el valor del frente de la cola
			return elem;
		}
	}
}
