/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.samford.jonathanborden.lists;

import edu.samford.jonathanborden.lists.*;

/**
 *
 * @author borde
 */
public class TestDLinkedList {
    public static void main(String[] args) {
        DLinkedList<String> list = new DLinkedList<>();
        DLinkedList<Integer> rating = new DLinkedList<>();
        System.out.println("size == 0 "+ list.size());
        System.out.println("toString == '': "+ list.toString());
        System.out.println("size == 0 "+ rating.size());
        System.out.println("toString == '': "+ rating.toString());
       
        long starttime = System.nanoTime();
        list.insertFirst("BHM");
        long finishtime = System.nanoTime();
        System.out.println("insertFirst - one item list -"+(finishtime - starttime));
        rating.insertFirst(10);
        System.out.println("size == 1 "+ list.size());
        System.out.println("toString == 'BHM': "+ list.toString());
        System.out.println("size == 1 "+ rating.size());
        System.out.println("toString == '10': "+ rating.toString());
        
        list.insertLast("ATL");
        rating.insertLast(7);
        System.out.println("size == 2 "+ list.size());
        System.out.println("toString == 'BHM,ATL': "+ list);
        System.out.println("size == 2 "+ rating.size());
        System.out.println("toString == '10,7': "+ list);
    }
}
