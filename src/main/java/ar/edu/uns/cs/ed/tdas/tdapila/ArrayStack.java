package ar.edu.uns.cs.ed.tdas.tdapila;

import java.util.EmptyStackException;

public class ArrayStack<E> implements Stack<E>{
	
	private E[] array;
	private int t=-1;//indica la cantidad de elementos de la pila, se inicializa en -1 como convencion indicando que no hay elementos, pues t+1=0
	public static final int Max=1000;
	
	public ArrayStack(int MAX) {//Constructor 1, donde el usuario ingresa la capacidad maxima del arreglo
		array= (E[])new Object[MAX];
		t=0;
	}
	
	public ArrayStack() {this(Max);}//Constructor 2, se realiza con una capacidad predefinida
	
	public int size() {return (t+1);}
	
	public boolean isEmpty() {return (t==-1);}
	
	public E top() throws EmptyStackException{
		if(isEmpty()) {//si la pila se encuentra vacia entonces lanzamos excepcion EmptyStack\
			throw new EmptyStackException();
		}
		return array[t];
	}
	
	public void push(E element) throws IllegalStateException{
		if(size()==array.length) {throw new IllegalStateException("la pila esta llena");}
		array[t++]= element;//incremento t antes de almacenar el nuevo elemento, si no estaria pusheando sobre una posicion ocupada
	}
	
	public E pop() throws EmptyStackException{
		if(isEmpty()) {throw new EmptyStackException();}
		E elem=array[t];
		array[t]=null;//ayudo al recolector de basura de java >efficient
		t--;//disminuyo la cantidad de elementos asignados
		return elem;
	}
}
