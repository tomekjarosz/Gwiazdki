package InOut;

import data.Entry;
import enums.InputDateOption;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Reader {

    public static Scanner sc = new Scanner(System.in);
    private DateTimeFormatter datePattern = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public static Entry readNewEntry(){

        LocalDate inputDate = null;

        displayTakeDateOption();

        InputDateOption dateOption = takeUserDateOption();

        switch (dateOption) {

            case TODAY:
                inputDate = LocalDate.now();
                break;

            case YESTERDAY:
                inputDate = LocalDate.now().minusDays(1);
                break;

            case DAY_BEFORE_YESTERDAY:
                inputDate = LocalDate.now().minusDays(2);
                break;

            case MANUAL:
                inputDate = takeManualDate();
                break;
        }

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

    private static void displayTakeDateOption(){
        Printer.display("WYBIERZ OPCJĘ:");
        for (InputDateOption o:InputDateOption.values()){
            Printer.display(o.getValue()+" - "+o.getDescription());
        }
    }

    private static InputDateOption takeUserDateOption(){
        boolean error = true;
        InputDateOption dateOption = InputDateOption.MANUAL;

        do {
            try {
                dateOption = InputDateOption.createFromInt(Reader.sc.nextInt());
                error = false;
            } catch (InputMismatchException | ArrayIndexOutOfBoundsException exc) {
                Printer.display("spróbuj wybrać wartość spośród podanych możliwości");
            } finally {
                Reader.sc.nextLine();
            }
        } while (error);

        return dateOption;
    }

    private static LocalDate takeManualDate(){

        boolean dateError = true;
        LocalDate inputDate = null;
        DateTimeFormatter datePattern = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        do {
            try {
                inputDate = LocalDate.parse(sc.nextLine(), datePattern);
                dateError = false;
            } catch (DateTimeParseException e) {
                Printer.display("data niepoprawna, spróbuj ponownie");
            }
        } while (dateError);

        return inputDate;
    }
}
