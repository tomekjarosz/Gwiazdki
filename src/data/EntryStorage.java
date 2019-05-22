package data;

import data.Entry;

public class EntryStorage{

    public static final int MAX_ENTRIES = 100;
    private Entry[] entryTab = new Entry[MAX_ENTRIES];

    public Entry[] getEntryTab(){   //zwykły getter
        return entryTab;    //odwołujemy się to elementu tablicy entry przez getEntryTab[i]. a nie entryTab... kosmetyka
    }

    public void add(Entry entry, int index){   //wiem, to taki backdoor trochę...
        entryTab[index] = entry;
    }

    public int getLength(){
        return entryTab.length;
    }
}
