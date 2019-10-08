/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.samford.jonathanborden.lists;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 *
 * @author borde
 */
public class DLinkedListIterator<T> implements Iterator<T>{
    protected DLinkedList<T> theList;
    protected DNode<T> cur;
    public DLinkedListIterator(DLinkedList theLIst){
        this.theList = theList;
        cur = theList.first();
    }

    @Override
    public boolean hasNext() {
        return cur!=null;
    }

    @Override
    public T next() {
        T theData = cur.element();
        cur = theList.next(cur);
        cur= cur.getNext();
        return theData;
    }

    @Override
    public void forEachRemaining(Consumer<? super T> cnsmr) {
        Iterator.super.forEachRemaining(cnsmr); //To change body of generated methods, choose Tools | Templates.
    }
/**
 * Remove the node that was returned the last time next() was called.
 * 
 */
    @Override
    public void remove() {
        DNode<T> doomed = theList.prev(cur);
        theList.remove(doomed);
        
    }
    
}
