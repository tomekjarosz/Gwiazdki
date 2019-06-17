package data;

import java.util.ArrayList;

import data.Entry;

public class EntryStorage{

    public static final int MAX_ENTRIES = 100;

    private ArrayList<Entry> entryTab = new ArrayList<>();

    public ArrayList<Entry> getEntryTab(){   //zwykły getter
        return entryTab;    //odwołujemy się to elementu tablicy entry przez getEntryTab[i]. a nie entryTab... kosmetyka
    }

    public void add(Entry entry){   //wiem, to taki backdoor trochę...
        entryTab.add(entry);
    }

    public int getLength(){
        return entryTab.size();
    }
}
