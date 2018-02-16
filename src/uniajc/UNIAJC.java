/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uniajc;

import java.util.ArrayList;

/**
 *
 * @author clopez
 */
public class UNIAJC {

    //declaracion de variables
    public static int n = 7;
    public static int[] array = {1, 2, 3, 4, 5, 6, 9};
    public static int[] arraynoOrden = {9, 3, 1};

    //metodo principal
    public static void main(String[] args) throws InterruptedException {
//        isNumberPerfect(n);
//        System.out.println("");
//        System.out.println("Array Invertido");
//        array = invertirArray(array);
//        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i]+" ");
//        }
//        System.out.println("");
//        ordenarArray(arraynoOrden);
        productoEscalar();
    }

    //saber si un numero es perfecto y sus divisores
    public static void isNumberPerfect(int n) {
        ArrayList<Integer> divisores = new ArrayList();
        //Encontrar los divisores
        System.out.println("los divisores de " + n + " son:");
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                divisores.add(i);
                System.out.print(i + " ");
            }
        }
        System.out.println("");
        //saber si es perfecto
        int perfect = 0;
        perfect = divisores.stream().map((divisor) -> divisor).reduce(perfect, Integer::sum);
        if (perfect == n) {
            System.out.println("El numero " + n + " es perfecto");
        } else {
            System.out.println("El numero " + n + " no es perfecto");
        }
    }

    //invertir array
    public static int[] invertirArray(int[] array) {
        int[] arrayNew = new int[array.length];
        int aux = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            arrayNew[aux] = array[i];
            aux++;
        }
        return arrayNew;
    }

    public static void ordenarArray(int[] array) throws InterruptedException {
//        arraynoOrden = {20, 2, 8, 1, 3, 9, 8, 4};
        int aux;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j + 1] < array[j]) {
                    aux = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = aux;
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            int j = array[i];
            System.out.print(j + " ");
        }
    }

    /*Se debe realizar un programa que llene dos vectores con datos
      aleatorios, Calcular el producto escalar entre dos vectores y
      muestre el mayor número par y el mayor número impar */
    public static void productoEscalar() {
        int[] v1, v2;
        v1 = new int[8];
        v2 = new int[8];
        for (int i = 0; i < v1.length; i++) {
            v1[i] = (int) (Math.random() * 10) + 1;
            v2[i] = (int) (Math.random() * 10) + 1;
        }
        System.out.print("v1 =");
        for (int i = 0; i < v1.length; i++) {
            System.out.print(" " + v1[i]);
        }
        System.out.println("");
        System.out.print("v2 =");
        for (int i = 0; i < v2.length; i++) {
            System.out.print(" " + v2[i]);
        }
        System.out.println("");
        System.out.println("----------------------------");
        String temp = "";
        String temp2 = "";
        int productoEscalar = 0;
        for (int i = 0; i < v1.length; i++) {
            productoEscalar += (v1[i] * v2[i]);
            if (v1[i] % 2 == 0) {
                temp += " " + v1[i];
            } else {
                temp2 += " " + v1[i];
            }
        }
        System.out.println("");
        System.out.println("Producto Escalar = " + productoEscalar);

        int numeroMayorParV1 = Integer.parseInt(temp.trim().split(" ")[0]);
        int numeroMayorImparV1 = Integer.parseInt(temp2.trim().split(" ")[0]);
        
        for (String split : temp.trim().split(" ")) {
            if (Integer.parseInt(split) > numeroMayorParV1) {
                numeroMayorParV1 = Integer.parseInt(split);
            }
        }
        for (String split : temp2.trim().split(" ")) {
            if (Integer.parseInt(split) > numeroMayorImparV1) {
                numeroMayorImparV1 = Integer.parseInt(split);
            }
        }
        System.out.println("");
        System.out.println("-----------Mayor Par e Impar--------------");
        System.out.println("Mayor Numero Par Vector1 = " + numeroMayorParV1 + " --- Mayor Numero Impar Vector1 = " + numeroMayorImparV1);
        System.out.println("");
    }

}
