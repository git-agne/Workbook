package ires.corso.part1;

import java.util.Scanner;

public class InputTest {

    public static void main(String[] args) {
        Scanner s;
        s = new Scanner(System.in);

        System.out.println("Inserisci tre numeri: ");
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        int n3 = s.nextInt();

        if(n1 > n2 && n1 > n3){
            System.out.println("Il numero maggiore è il primo e vale " + n1);
        }
        else if(n2 > n1 && n2 > n3){
            System.out.println("Il numero maggiore è il secondo e vale " + n2);
        }
        else if(n3 > n1 && n3 > n2){
            System.out.println("Il numero maggiore è il terzo e vale " + n3);
        }
        else if(n1 == n2 && n2 == n3){
            System.out.println("I tre numeri sono uguali");
        }
        else if(n1 == n2 && n1 > n3){
            System.out.println("Il numero maggiore è il primo e vale " + n1);
        }
        else if(n2 == n3 && n2 > n1){
            System.out.println("Il numero maggiore è il secondo e vale " + n2);
        }
        else if(n1 == n3 && n1 > n2){
            System.out.println("Il numero maggiore è il primo e vale " + n1);
        }
    }
}
