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

    public static int[] removeElement(int[] arr, int index) {

        int[] newArr = new int[arr.length - 1];

        for(int i = 0, j = 0; i < arr.length && j < newArr.length; i++, j++){
            if(i != index){
                newArr[j] = arr[i];
            }
            else{
                newArr[j] = arr[i + 1];
                i++;
            }
        }

        return newArr;
    }

    public static int[] removeDuplicates(int[] arrayDuplicates){

        int[] arrWithoutDupl;
        arrWithoutDupl = arrayDuplicates;

        int l = 0;

        for(int i = 0; i < arrayDuplicates.length; i++){
            for(int j = i + 1; j < arrayDuplicates.length; j++){
                if(arrayDuplicates[i] == arrayDuplicates[j]){

                    arrWithoutDupl = removeElement(arrWithoutDupl, j);

                    return removeDuplicates(arrWithoutDupl);
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
