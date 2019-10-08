/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.samford.jonathanborden.lists;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author borde
 */
public class PerformanceComparison {

    public static final int MAX = 1_000_000;

    public static void main(String[] args) throws FileNotFoundException {
        //0. set aside a couple of longs for instrumentation
        long start = 0;
        long finish = 0;
        long arraytime = 0;
        long listtime = 0;
        //1. Generate alot of data
        generateDate();
        //2. Prepare output for excel
        System.out.println("operation, array, linkedlist");

        //3. Start measuring .... construction first
        start = System.currentTimeMillis();
        double array[] = new double[MAX];
        finish = System.currentTimeMillis();
        arraytime = finish - start;
        start = System.currentTimeMillis();
        DLinkedList<Double> numlist = new DLinkedList<>();
        finish = System.currentTimeMillis();
        listtime = finish - start;

        System.out.println("construction," + arraytime + "," + listtime);
        // populating entire data structure 
        File f = new File("randomnums.txt");
        Scanner filein = new Scanner(f);
        int i = 0;
        arraytime = 0;
        listtime = 0;
        while (filein.hasNextDouble()) {
            double d = filein.nextDouble();
            start = System.nanoTime();
            numlist.insertLast(d);
            finish = System.nanoTime();
            listtime += (finish - start);

            start = System.nanoTime();
            array[i++] = d;
            finish = System.nanoTime();
            arraytime += (finish - start);
        }
        System.out.println("populating," + arraytime / 1_000_000 + "," + listtime / 1_000_000);

        //inserting an item at the beginging of each data structure
        double newItem = Math.random();
        start = System.nanoTime();
        numlist.insertFirst(newItem);
        finish = System.nanoTime();
        listtime = finish - start;

        start = System.nanoTime();
        double temp[] = new double[array.length + 1];
        for (int j = 1; j < temp.length; j++) {
            temp[j] = array[j - 1];

        }
        array = temp;
        array[0] = newItem;
        finish = System.nanoTime();
        arraytime = finish - start;

        System.out.println("insert beginging," + arraytime / 1_000_000 + "," + listtime / 1_000_000);
        // inserting an item in the middle of a data structure
        newItem = Math.random();
        start = System.nanoTime();
        temp = new double[array.length + 1];
        for (int k = 0; k < temp.length / 2; k++) {
            temp[k] = array[k];
        }
        for (int j = 1; 1 + j < temp.length / 2; j++) {
            temp[j] = array[j - 1];

        }
        array = temp;
        array[temp.length / 2] = newItem;
        finish = System.nanoTime();
        arraytime = finish - start;

        start = System.nanoTime();
        int middle = numlist.size() / 2;
        DNode cur = numlist.first();
        i = 0;
        while (i < middle) {
            cur = cur.getNext();
            i++;
        }
        numlist.insertAfter(cur, newItem);
        finish = System.nanoTime();
        listtime = finish - start;
        System.out.println("insert middle," + arraytime / 1_000_000 + "," + listtime / 1_000_000);
        // Removing at the beginning of the structure

        start = System.nanoTime();
        cur = numlist.first();
        i = 0;
        while (i < middle) {
            cur = cur.getNext();
            i++;
        }
        numlist.remove(cur);
        finish = System.nanoTime();
        listtime = finish - start;

        start = System.nanoTime();
        temp = new double[array.length - 1];
        // Removing from the middle 
        start = System.nanoTime();
        for (int k = 0; k < temp.length / 2; k++) {
            temp[k] = array[k];
        }
        for (int j = temp.length / 2; j < temp.length; j++) {
            temp[j] = array[j + 1];

        }
        array = temp;
        array[temp.length / 2] = newItem;
        finish = System.nanoTime();
        arraytime = finish - start;

        start = System.nanoTime();
        middle = numlist.size() / 2;
        cur = numlist.first();
        i = 0;
        while (i < middle) {
            cur = cur.getNext();
            i++;
        }
        numlist.insertAfter(cur, newItem);
        finish = System.nanoTime();
        listtime = finish - start;

        array = temp;
        array[0] = newItem;
        finish = System.nanoTime();
        arraytime = finish - start;
        // removing from the end 

        // replacing data in the array
        start = System.nanoTime();
        array[1_000_000] = Math.random();

        cur.setElement(Math.random());
        finish = System.nanoTime();

        System.out.println(
                "Replacing at the end, " + arraytime / 1_000_000 + "," + listtime / 1_000_000);

    }

    private static void generateDate() throws FileNotFoundException {
        File f = new File("randomnums.txt");
        PrintWriter out = new PrintWriter(f);
        for (int i = 0; i < MAX; i++) {
            out.println(Math.random());
        }
        out.close();
    }
}
