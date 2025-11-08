package it.unibo.inner.api;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IterableWithPolicyImpl<T> implements IterableWithPolicy<T> {

	private final T[] elems;
	private Predicate<T> pred;

	public IterableWithPolicyImpl(T[] elements){ //first constructor 
		this( elements, 
			new Predicate<T>() { //passing a predicate that is always true
				
				@Override
				public boolean test(T elem){ //
					return true;
				}
			}
			);
	}
	
	public IterableWithPolicyImpl(T[] elements, Predicate<T> p){ //second constructor 
		this.elems = elements;
		this.pred = p;
	}
	
	@Override
	public void setIterationPolicy(Predicate<T> filter){
		this.pred = filter; //change the filtering policy
	}

	public Iterator<T> iterator() {
		return new IteratorImpl(); //return new istance of the inner iteretor class
	}
	//inner class that implement the iteretor
	private class IteratorImpl implements Iterator<T>{
		private int index=0;

		@Override
		public boolean hasNext() {
			while(index < elems.length){
				if(pred.test(elems[index])){
					return true;
				}
				index++;
			}
			return false;
		}

		@Override
		public T next() {
			if(!hasNext()){
				throw new NoSuchElementException("Nessun elemento disponibile");
			}
			return elems[index++];
		}
	}
}
