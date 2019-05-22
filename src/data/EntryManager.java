package data;

import InOut.Printer;
import InOut.Reader;

public class EntryManager {

    public EntryStorage entryStorageProper = new EntryStorage();

    public EntryStorage addStorageFromFile(EntryStorage importedStorage){
        return importedStorage;
    }

    public void addEntry(Entry entry){


            //check if there is "enough" stars to enter negative entry
            if ((countStars()+entry.getValue())>=0){
                entryStorageProper.getEntryTab().add(entry);

            } else {

                //case if entry would bring stars count to negative
                Printer.display("nie można utworzyć wpisu ponieważ liczba gwiazdek byłaby ujemna");
                Printer.display("czy chcesz automatycznie zmniejszyć ilość odbieranych gwiazdek do dostępnej ilości? (tak/nie)");
                String userSelection = Reader.sc.nextLine();

                //prompt user for automatic modification of negative starts to amount currently avaliable
                if (userSelection.equals("tak")){
                    entry.setValue(-countStars());
                    entryStorageProper.getEntryTab().add(entry);
                } else {

                    //discontinue adding entry if user does not agree for the above
                    Printer.display("to wracamy do menu");
                }
            }
    }

    public void removeSpecifiedEntry(int index){
        entryStorageProper.getEntryTab().remove(index-1);
    }

    public int countStars(){
        int total =0;
        for (Entry x:entryStorageProper.getEntryTab()){
            total = total + x.getValue();
        }
        return total;
    }

    public void displayEntries(){

        int i = 1;
        Printer.display("wpisy w dzienniku:");

        for (Entry x:entryStorageProper.getEntryTab()){
            Printer.display(i + ": "+x.toString());
            i++;
        }
    }
}
