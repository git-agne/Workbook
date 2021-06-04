package ires.corso.part1;

public class StringTest {

    // Scrivere un programma in Java che:
    // 1. accetta in input 3 stringhe (da riga di comando)
    // 2. verifica che le stringhe siano 3
    // 3. calcola la lunghezza di ciascuna stringa
    // 4. trova il carattere iniziale e finale di ciascuna stringa
    // 5. per tutte e 3 le stringhe stampa un report:
    //
    // "La stringa " .... " ha lunghezza " .... " comincia per " ... " e fniisce per " ...

    public static void main(String[] args){

        if(args[2] != null){
            int l1 = args[0].length();
            int l2 = args[1].length();
            int l3 = args[2].length();

            char c1 = args[0].charAt(0);
            char c2 = args[1].charAt(0);
            char c3 = args[2].charAt(0);

            char cl1;

            String str1 = String.format("La stringa %s, ha lunghezza %d, comincia per %c...", args[0], l1, c1);
            String str2 = String.format("La stringa %s, ha lunghezza %d, comincia per %c...", args[1], l2, c2);
            String str3 = String.format("La stringa %s, ha lunghezza %d, comincia per %c...", args[2], l3, c3);

            System.out.println(str1);
            System.out.println(str2);
            System.out.println(str3);
        }
    }
}
