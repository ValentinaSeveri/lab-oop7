package it.unibo.inner.api;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IterableWithPolicyImpl<T> implements IterableWithPolicy<T> {

	private T[] elems;
	Predicate<T> pred;

	public IterableWithPolicyImpl(T[] elements) {
		this(elements, t->true);  //richiama il secondo contruttore su un predicato SEMPRE vero
	}
	
	public IterableWithPolicyImpl(T[] elements, Predicate<T> p){
		this.elems = elements;
		this.pred = p;
	}
	
	@Override
	public void setIterationPolicy(Predicate<T> filter){
		this.pred = filter;
	}

	public Iterator<T> iterator() {
		return new IteratorImpl();
	}

	private class IteratorImpl implements Iterator<T>{
		private int index=0;

		public boolean hasNext() {
			while(index < elems.length){
				if(pred.test(elems[index])){
					return true;
				}
				index++;
			}
			return false;
		}

		public T next() {
			if(!hasNext()){
				throw new NoSuchElementException("Nessun elemento disponibile");
			}
			return elems[index++];
		}
	}
}
