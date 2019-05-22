package logic;

import InOut.FileManager;
import InOut.Printer;
import InOut.Reader;
import data.EntryManager;
import enums.MainOption;
import enums.StartingOption;

import java.util.InputMismatchException;

public class StorageApp {

    private EntryManager entryManager = new EntryManager();

    public void controlLoop() {

        displayStartingOptions();

        StartingOption initialOption = takeUserStartingOption();

        switch (initialOption) {

            case LOAD_FROM_FILE:
                //replace default "entryStorageProper" with csv file content
                entryManager.entryStorageProper = entryManager.addStorageFromFile(FileManager.importData());
                Printer.display("wczytano dane z pliku!");
                entryManager.displayEntries(); //not necessary
                break;

            case CREATE_NEW_DATABASE:
                //do nothing really
                Printer.display("utworzono nową bazę");
                break;
        }

        Printer.display("liczba wpisów w tej chwili: " + entryManager.entryCount);

        MainOption mainOption;

        do {
            displayMainOptions();
            mainOption = takeUserMainOption();

            switch (mainOption) {

                case ADD_ENTRY:
                    insertNewEntry();
                    break;

                case DISPLAY_ENTRIES:
                    entryManager.displayEntries();
                    break;

                case COUNT_STARS:
                    Printer.display("liczba gwiazdek na ten moment to " + entryManager.countStars());
                    break;

                case EXIT:
                    FileManager.exportData(entryManager.entryStorageProper);    // save to external .csv file
                    exit();
            }
        } while (mainOption != MainOption.EXIT);
    }

    private void displayStartingOptions() {
        Printer.display("WYBIERZ OPCJĘ:");
        for (StartingOption x : StartingOption.values()) {
            Printer.display(x.getValue() + " - " + x.getDescription());
        }
    }

    private StartingOption takeUserStartingOption() {
        boolean error = true;
        StartingOption startingOption = StartingOption.CREATE_NEW_DATABASE;

        do {
            try {
                startingOption = StartingOption.createFromInt(Reader.sc.nextInt());
                error = false;
            } catch (InputMismatchException | ArrayIndexOutOfBoundsException exc) {
                Printer.display("spróbuj wybrać liczbę spośród podanych możliwości");
            } finally {
                Reader.sc.nextLine();
            }
        } while (error);

        return startingOption;
    }

    private void displayMainOptions() {
        Printer.display("");
        Printer.display("WYBIERZ OPCJĘ:");
        for (MainOption o : MainOption.values()) {
            Printer.display(o.getValue() + " - " + o.getDescription());
        }
    }

    private MainOption takeUserMainOption() {
        boolean error = true;
        MainOption mainOption = MainOption.EXIT;
        do {
            try {
                mainOption = MainOption.createFromInt(Reader.sc.nextInt());
                error = false;
            } catch (InputMismatchException | ArrayIndexOutOfBoundsException exc) {
                Printer.display("spróbuj wybrać liczbę spośród podanych możliwości");
            } finally {
                Reader.sc.nextLine();
            }
        } while (error);

        return mainOption;
    }

    private void insertNewEntry() {
        entryManager.addEntry(Reader.readNewEntry());
        Printer.display("dodano nowy wpis \n");
    }

    private void exit() {
        Printer.display("zapisano dane, koniec programu");
        Reader.sc.close();
    }
}
