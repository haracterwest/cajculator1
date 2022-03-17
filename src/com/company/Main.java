package com.company;

import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        char znak;
        int result;
        try {
            if (input.hasNextInt()) {
                int a = getInt();
                znak = getOperation();
                int b = getInt();
                if ((a > 10 || a < 1)||(b > 10 || b < 1)) throw new Exception("ввести целые числа от 1 до 10");

                result = calc(a, b, znak);
                System.out.println(result);

            } else if (input.hasNextLine()) {

                String str = input.nextLine();

                String stringArray[] = str.split(" ");
                String n = stringArray[0];
                String znak1 = stringArray[1];
                String m = stringArray[2];

                for (int i = 0; i < numbers.length; i++) {
                    if (m.equals(numbers[i])) throw new Exception("числа при вводе должны быть или римскими, или арабскими");
                    }

                int n1 = convertRimToArab(n);
                int m1 = convertRimToArab(m);
                if ((n1 > 10 || n1 < 1)||(m1 > 10 || m1 < 1)) throw new Exception("ввести значение от 1 до 10");
                if ((n1 - m1)<=0) throw new Exception("результат должен быть положительным");

                int resArab = calc(n1, m1, znak1.charAt(0));
                String resRim = convertArabToRim(resArab);
                System.out.println(resRim);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int getInt() throws Exception {
        int c;
        if (input.hasNextInt()) {
            c = input.nextInt();
        } else {
            throw new Exception("числа при вводе должны быть или римскими, или арабскими");
        }
        return c;
    }

    public static char getOperation() throws Exception {
        char znak;
        if(input.hasNextLine()){
            znak = input.next().charAt(0);
        } else {
              throw new Exception("попробуй ещё раз");
        }
        return znak;
    }

    public static int calc(int a, int b, char znak) throws Exception {
        int result;
        switch (znak){
            case '+':
                result = a+b;
                break;
            case '-':
                result = a-b;
                break;
            case '*':
                result = a*b;
                break;
            case '/':
                result = a/b;
                break;
            default:
                throw new Exception("некорректный оператор");
        }
        return result;
    }

    private static String [] numbers = {"0","1","2","3","4","5","6","7","8","9","10"};
    private static String [] letters = {"I","II","III","IV","V","VI","VII","VIII","IX",                                             //1-9
                                        "X","XI","XII","XIII","XIV","XV","XVI","XVII","XVIII","XIX",                                //10-19
                                        "XX","XXI","XXII","XXIII","XXIV","XXV","XXVI","XXVII","XXVIII","XXIX",                      //20-29
                                        "XXX","XXXI","XXXII","XXXIII","XXXIV","XXXV","XXXVI","XXXVII","XXXVIII","XXXIX",            //30-39
                                        "XL","XLI","XLII","XLIII","XLIV","XLV","XLVI","XLVII","XLVIII","XLIX",                      //40-19
                                        "L","LI","LII","LIII","LIV","LV","LVI","LVII","LVIII","LIX",                                //50-59
                                        "LX","LXI","LXII","LXIII","LXIV","LXV","LXVI","LXVII","LXVIII","LXIX",                      //60-69
                                        "LXX","LXXI","LXXII","LXXIII","LXXIV","LXXV","LXXVI","LXXVII","LXXVIII","LXXIX",            //70-79
                                        "LXXX","LXXXI","LXXXII","LXXXIII","LXXvIV","LXXXV","LXXXVI","LXXXVII","LXXXVIII","LXXXIX",  //80-89
                                        "XC","XCI","XCII","XCIII","XCIV","XCV","XCVI","XCVII","XCVIII","XCIX",                      //90-99
                                        "C"                                                                                         //100
    };

    private static int res;
    public static int convertRimToArab (String x) {
        for (int i = 1; i < 101; i++) {
                if ((letters[i - 1]).equals(x)){
                    res = i;
                }
        }
        return res;
    }
    private static String rim;
    public static String convertArabToRim (int x) {
        for (int i=1; i < 101; i++) {
            if (x == i + 1) {
                rim = letters[i];
            }
        }
        return rim;
    }
}
