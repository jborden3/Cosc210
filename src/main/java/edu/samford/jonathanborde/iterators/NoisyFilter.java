/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.samford.jonathanborde.iterators;

import edu.samford.jonathanborden.lists.DLinkedList;
import java.util.Iterator;

/**
 *
 * @author borde
 */
public class NoisyFilter {

    static DLinkedList<Integer> temps = new DLinkedList<>();

    public static void main(String[] args) {
        double rate = 0.04;
        double avg1;
        double avg2;
        do {
        generateNoisyData(90, 110, rate);
         avg1 = calculateAverage();
        System.out.println("Average with noisy data" + avg1);
        filterNoisyData(90, 110);
         avg2 = calculateAverage();
        System.out.println("Average without noisy data" + avg2);
        rate = rate + .0001;
        } while (Math.abs(avg2-avg1)<1);
        System.out.println("Final rate: " + rate);
    }

    /**
     * Generate data between low and high with 1-noiseprob probability.
     *
     * @param low
     * @param high
     * @param noiseprob
     */
    private static void generateNoisyData(int low, int high, double noiseprob) {
        java.util.Random r = new java.util.Random();
        temps = new DLinkedList<>();
        for (int i = 0; i < 1000; i++) {
            if (Math.random() < noiseprob) {
                // genrate a nosiy reading
                temps.insertLast(r.nextInt(200));
            } else {
                // generate typical alabama summer reading
                temps.insertLast(low + r.nextInt(high - low));
            }

        }
    }

    private static double calculateAverage() {
        double total = 0;
        for (Integer temp : temps) {
            total += temp;

        }
        double average = total / temps.size();
        return average;
    }

    /**
     * Remove any data outside the expected range
     */
    private static void filterNoisyData(int low, int high) {
        Iterator<Integer> it = temps.iterator();
        while (it.hasNext()) {
            int temp = it.next();
            if (temp < low || temp > high) {
                it.remove();
            }
        }
    }

}
