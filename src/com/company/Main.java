package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    System.out.println("Ввыедите строку:");
        System.out.println("Примеры: 3[xyz]4[xy]z , 2[3[x]y]");
        Scanner console = new Scanner(System.in);
        String inputString = "";
        inputString = console.nextLine();
        if(CorrectString(inputString)){
            System.out.println(StrFormater(inputString));
        }
        else {
            System.out.println("Строка не корректна!");
        }
    }

    public static String  StrFormater(String string) {
        String temp = "";
        int numberOfRepetitions = 0, size = 0;

        for (int i = string.length() - 1; i >= 0; i--) {
            if (Character.isDigit(string.charAt(i))) {
                if(string.charAt(i+1) != '['){
                    string = "Строка не корректна!";
                    break;
                }
                numberOfRepetitions = Character.getNumericValue(string.charAt(i));
                temp = string.substring(i + 1);
                temp = temp.replaceAll(".*\\[|\\].*", "");
                size = temp.length();
                temp = temp.repeat(numberOfRepetitions);
                string = string.substring(0, i) + temp + string.substring(i + size + 3);
            }
        }
        return string;
    }

    public static boolean CorrectString(String string){
        if(string.length() != 0 && !Character.isDigit(string.charAt(string.length()-1))){
            // string.matches([a-zA-Z1-9][\Q[\E][\Q]\E])  ???
            return true;
        }
        else {
            return false;
        }
    }
}
