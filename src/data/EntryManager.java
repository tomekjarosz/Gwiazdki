package data;

import InOut.Printer;
import InOut.Reader;

public class EntryManager {

    public int entryCount = 0;
    public EntryStorage entryStorageProper = new EntryStorage();

    public EntryStorage addStorageFromFile(EntryStorage importedStorage){

        int actualEntriesCount = 0;

        for (int i=0; i<importedStorage.getLength(); i++){
            if (importedStorage.getEntryTab()[i]!=null) {actualEntriesCount++;}
        }

        entryCount = actualEntriesCount;

        return importedStorage;
    }

    public void addEntry(Entry entry){

        if (entryCount<entryStorageProper.getEntryTab().length) {

            //check if there is "enough" stars to enter negative entry
            if ((countStars()+entry.getValue())>=0){
                entryStorageProper.getEntryTab()[entryCount] = entry;
                entryCount++;
            } else {

                //case if entry would bring stars count to negative
                Printer.display("nie można utworzyć wpisu ponieważ liczba gwiazdek byłaby ujemna");
                Printer.display("czy chcesz automatycznie zmniejszyć ilość odbieranych gwiazdek do dostępnej ilości? (tak/nie)");
                String userSelection = Reader.sc.nextLine();

                //prompt user for automatic modification of negative starts to amount currently avaliable
                if (userSelection.equals("tak")){
                    entry.setValue(-countStars());
                    entryStorageProper.add(entry,entryCount);
                    entryCount++;
                } else {

                    //discontinue adding entry if user does not agree for the above
                    Printer.display("to wracamy do menu");
                }
            }
        } else {
            Printer.display("mamy już zbyt dużo wpisów");
        }
    }

    public int countStars(){
        int total =0;
        for (Entry x:entryStorageProper.getEntryTab()){
            if (x!=null) {total = total + x.getValue();}
        }
        return total;
    }

    public void displayEntries(){
        Printer.display("wpisy w dzienniku:");
        for (Entry x:entryStorageProper.getEntryTab()){
            if (x != null) Printer.display(x.toString());
        }
    }
}
