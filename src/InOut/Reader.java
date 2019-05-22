package InOut;

import data.Entry;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Reader {

    public static Scanner sc = new Scanner(System.in);

    public static Entry readNewEntry(){

        Printer.display("podaj datę wpisu (DD.MM.YYYY):");
        String inputDate = sc.nextLine();

        Printer.display("podaj treść wpisu:");
        String inputName = sc.nextLine();

        Printer.display("podaj ilość gwiazdek:");

        int inputValue = 0;
        boolean error = true;

        do {
            try{
                inputValue = sc.nextInt();
                error = false;
            } catch (InputMismatchException exc) {
                Printer.display("to nie jest poprawna wartość, wprowadź liczbę całkowitą");
            } finally {
                sc.nextLine();
            }
        } while (error);

        return new Entry(inputDate, inputName, inputValue);
    }
}
