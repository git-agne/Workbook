package ires.corso.part1;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayTest {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        System.out.println("Inserisci un array di numeri: ");
        System.out.print("===>");
        String arr = s.nextLine();

        System.out.println("Inserisci un numero dell'array:");
        System.out.print("===>");
        int elem = s.nextInt();

        String[] strArr = arr.split("\\|");
        int[] intArr = new int[strArr.length];

        for(int i = 0; i < strArr.length; i++){
            intArr[i] = Integer.parseInt(strArr[i]);
        }

        System.out.println(elemPositionInArray(intArr, elem));

        printArray(removeDuplicates(intArr));
    }

    public static void printArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static int[] removeDuplicates(int[] arrayDuplicates){

        int[] indexArr = new int[0];

        int l = 0;

        for(int i = 0; i < arrayDuplicates.length; i++){
            for(int j = i + 1; j < arrayDuplicates.length; j++){
                if(arrayDuplicates[i] == arrayDuplicates[j]){
                    int[] supportArr = new int[indexArr.length];
                    supportArr = Arrays.copyOf(indexArr, indexArr.length);

                    indexArr = new int[l + 1];

                    for(int x = 0; x < supportArr.length; x++){
                        indexArr[x] = supportArr[x];
                    }

                    indexArr[l] = j;
                    l++;
                }
            }
        }
        int[] arrWithoutDupl = new int[arrayDuplicates.length - l];

        int count = 0;

        //bug da risolvere: sostituire 0 nell'indexArray
        for(int m = 0; m < indexArr.length; m++){
             for(int n = 0; n < arrayDuplicates.length; n++){
                if(indexArr[m] != n){
                    arrWithoutDupl[count] = arrayDuplicates[n];
                    count++;
                } else {
                    break;
                }
            }
        }
        return arrWithoutDupl;
    }

    public static int elemPositionInArray(int[] intArray, int elem){

        int pos = 0;

        for(int i = 0; i < intArray.length; i++){
            if(intArray[i] == elem){
                pos = i;
                break;
            }
            else {
                pos = -1;
            }
        }
        return pos;
    }
}
