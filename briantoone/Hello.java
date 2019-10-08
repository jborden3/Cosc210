/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.samford.briantoone;

import java.util.Scanner;

/**
 *
 * @author briantoone
 */
public class Hello {
    public static void main(String[] args) {
        System.out.println("hello, world");
        Scanner stdin = new Scanner(System.in);
        System.out.println("what is your name?");
        String yourname = stdin.nextLine();
        System.out.println("hello " + yourname);
    }
}
