/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.samford.jonathanborden.lists;

/**
 *
 * @author borde
 */
public class SLinkedList<T> {
    //Attributes 
    protected int size;
    protected SNode<T> head;
    protected SNode<T> tail;
    
    public SLinkedList(){
    size =0;
    head = null;
    tail=  null;
}
    
    public void addFirst(SNode<T> newNode){
        // FIrst increment the size
        size++;
        //Now, order matters, tell new node that its next should be head
        newNode.setNext(head);
        // Update the head to reference the newly "added" node
        head = newNode;
        // Lastly, do something with the tail
        if (size ==1 ){
            tail = newNode;
        }
    }
    
    public SNode addFirst(T newdata){
        // Create the new Snode for our data
        SNode<T> newnode = new SNode<T>(newdata,null);
        addFirst(newnode);
        return newnode;
    }
     public void addLast(SNode<T> newNode){
        // FIrst increment the size
        size++;
        //Now, order matters, tell new node that its next should be head
        tail.setNext(newNode);
        // Update the head to reference the newly "added" node
        tail = newNode;
        // Lastly, do something with the head 
        if (size ==1 ){
            head = newNode;
        }
     }
    
    public SNode addLast(T newdata){
        // Create the new Snode for our data
        SNode<T> newnode = new SNode<T>(newdata,null);
        addLast(newnode);
        return newnode;
    }
    /**
     * Adds newnode to our list After the pos node
     * @param pos
     * @param newNode 
     */
    public void addAfter(SNode<T> pos, SNode<T> newNode){
        size++;
        newNode.setNext(pos.getNext());
        pos.setNext(newNode);
        if (pos==tail){
            tail=newNode;
        }
        
    }
    public SNode<T> find(T searchdata){
        SNode<T> cur= head;
        while(cur!= null){
            if (cur.element().equals(searchdata)){
                return cur;
            }
            cur = cur.getNext();
        }
        return null;
    }
    public SNode<T> addAfter(SNode<T> pos, T newdata){
        SNode<T> newnode = new SNode<T>(newdata,null);
        addAfter(pos, newnode);
        return newnode;
    }
    public SNode<T> remove(T searchdata){
        SNode<T> doomed = find(searchdata);
        if (doomed!=null){
            remove(doomed);
        }
        return doomed;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    @Override 
    public String toString(){
        String out ="";
        SNode<T> cur=head;
        while (cur!=null){
            out += cur.element();
            cur = cur.getNext();
            if (cur!=null){
            out += ',';
        }
        }
        
        return out;
    }

    private void remove(SNode<T> doomed) {
 // difficult to implement 
    }
}
