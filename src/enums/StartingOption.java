package enums;

public enum StartingOption {

    LOAD_FROM_FILE(0, "wczytanie danych z pliku"),
    CREATE_NEW_DATABASE(1,"utworzenie nowej bazy");

    private int value;
    private String description;

    StartingOption(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    public static StartingOption createFromInt (int option){
        return StartingOption.values()[option]; //to nic innego jak pozycja "option" z domyślnej tablicy "values" :-)
    }
}
