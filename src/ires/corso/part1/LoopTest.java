package ires.corso.part1;

import java.util.Scanner;

public class LoopTest {
    public static void main(String[] args){

        Scanner s = new Scanner(System.in);

        int i, j, l;
        int n = 1;

        System.out.println("Inserisci numero di righe: ");
        l = s.nextInt();

        for(i = 1; i <= l; i++){
            for(j = 1; j <= i; j++){
                System.out.print(n);
                n++;
            }
            System.out.println();
        }
    }
}
