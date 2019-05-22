package InOut;

import data.Entry;
import data.EntryStorage;
import exceptions.DataExportException;
import exceptions.DataImportException;

import java.io.*;
import java.util.Scanner;

public class FileManager {

    private static final String FILE_NAME = "storage.csv";

    public static void exportData (EntryStorage entryStorageForExport){    //wywołując metodę podamy co jest exportowane

        try (
                FileWriter fileWriter = new FileWriter(FILE_NAME);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)
                ){

            for (Entry x:entryStorageForExport.getEntryTab()){
                bufferedWriter.write(x.convertToCsv());
                bufferedWriter.newLine();
            }

            } catch (IOException e){
                throw new DataExportException("błąd zapisu do pliku "+FILE_NAME);
        }
    }

    public static EntryStorage importData(){

            EntryStorage entryStorage = new EntryStorage();

            try(
                    Scanner fileReader = new Scanner(new File(FILE_NAME))
            ){
                while (fileReader.hasNextLine()){
                    String line = fileReader.nextLine();
                    Entry importedEntry = createEntryFromString(line);
                    entryStorage.add(importedEntry);
                }
            } catch (FileNotFoundException e){
                throw new DataImportException("brak pliku "+FILE_NAME);
            }
            return entryStorage;
    }

    private static Entry createEntryFromString(String csvLine){

        String[] split = csvLine.split(";");

        String readDate = split[0];
        String readTitle = split[1];
        int readValue = Integer.valueOf(split[2]);

        return new Entry (readDate, readTitle, readValue);
    }
}

