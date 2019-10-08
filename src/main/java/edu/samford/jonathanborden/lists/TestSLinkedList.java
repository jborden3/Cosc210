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
public class TestSLinkedList {
    public static void main(String[] args) {
        SLinkedList<String> list = new SLinkedList<>();
        SLinkedList<Integer> rating = new SLinkedList<>();
        System.out.println("size == 0 "+ list.size());
        System.out.println("toString == '': "+ list.toString());
        System.out.println("size == 0 "+ rating.size());
        System.out.println("toString == '': "+ rating.toString());
        
        list.addFirst("BHM");
       rating.addFirst(10);
        System.out.println("size == 1 "+ list.size());
        System.out.println("toString == 'BHM': "+ list.toString());
        System.out.println("size == 1 "+ rating.size());
        System.out.println("toString == '10': "+ rating.toString());
        
        list.addLast("ATL");
        rating.addLast(7);
        System.out.println("size == 2 "+ list.size());
        System.out.println("toString == 'BHM,ATL': "+ list);
        System.out.println("size == 2 "+ rating.size());
        System.out.println("toString == '10,7': "+ list);
        
        SNode<String> bhmnode = list.find("BHMMM");
        System.out.println(bhmnode.element());
    }
}
