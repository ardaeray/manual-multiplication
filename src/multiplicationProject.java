/*
    Arda ERAY
    Department of Computer Engineering (English)
    Faculty of Engineering and Natural Science
    Student ID: 230408051
*/

import java.util.*;

public class multiplicationProject {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the value here that will be the multiplied: ");
        long multiplied = input.nextLong();
        System.out.print("Enter the value here that will be the multiplied: ");
        long multiplier = input.nextLong();
        System.out.println("\nCalculation:\n");

        LinkedList<Long> multipliedList = new LinkedList<Long>();
        LinkedList<Long> multiplierList = new LinkedList<Long>();
        LinkedList<Long> resultList = new LinkedList<Long>();

        long multiplied1 = Math.abs(multiplied);

        for (int i = 0; multiplied1 >= 0; i++) {
            long digit = multiplied1 % 10; 
            multipliedList.add(digit);
            multiplied1 = multiplied1 / 10;
            if (multiplied1 == 0) {
                multiplied1 = -1;
            }
        }
        int sizeMultiplied = multipliedList.size();

        long multiplier1 = Math.abs(multiplier);

        for (int i = 0; multiplier1 >= 0; i++) {
            long digit = multiplier1 % 10; 
            multiplierList.add(digit);
            multiplier1 = multiplier1 / 10;
            if (multiplier1 == 0) {
                multiplier1 = -1;
            }
        }
        int sizeMultiplier = multiplierList.size();

        long result = 0;
        int sumSeperator = 0;

        for (int i = 0; i < sizeMultiplier; i++) {
            resultList.clear();
            long multiplierDigit = multiplierList.get(i);
            long remaining = 0;
            long multiplication = 0;

            for (int j = 0; j < sizeMultiplied; j++) {
                long multipliedDigit = multipliedList.get(j);
                
                if (j == 0) {
                    multiplication = multiplierDigit * multipliedDigit;
                    remaining = multiplication / 10;
                    resultList.add(multiplication % 10);
                }
                else {
                    multiplication = multiplierDigit * multipliedDigit + remaining;
                    remaining = multiplication / 10;
                    resultList.add(multiplication % 10);
                }

                if (j == (sizeMultiplied - 1)) {
                    resultList.add(remaining);
                }
            }
            
            String permanent = "";

            for (int k = resultList.size() - 1; k > -1; k--) {
                permanent += resultList.get(k);
            }
            long resultOfLayer = Long.parseLong(permanent);

            if (i == 0) {
                sumSeperator = resultList.size();
                for (int j = 0; j < (sumSeperator + sizeMultiplier - sizeMultiplied); j++) {
                    System.out.print(" ");
                }
                System.out.println(multiplied);
                for (int j = 0; j < (sumSeperator); j++) {
                    System.out.print(" ");
                }
                System.out.println(multiplier);
                System.out.print("x");
                for (int j = 1; j < (sizeMultiplier + sumSeperator); j++) {
                    System.out.print("_");
                }
                System.out.println("");
            }
            for (int j = (sizeMultiplier - i); j > 0; j--) {
                System.out.print(" ");
            }
            System.out.println(resultOfLayer);
            result += ((int)(Math.pow(10, i)) * resultOfLayer);
        }

        if (multiplied < 0 && multiplier > 0) {
            result = result * -1;
        }
        else if (multiplied > 0 && multiplier < 0) {
            result = result * -1;
        }
        for (int i = 0; i < (sizeMultiplier + sumSeperator); i++) {
            System.out.print("-");
        }
        System.out.println("");
        System.out.println(" " + result);
    }
}
