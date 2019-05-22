package enums;

public enum MainOption{

    EXIT(0,"zapisanie danych i wyjście z programu"),
    ADD_ENTRY(1, "dodanie nowego wpisu"),
    REMOVE_ENTRY(2,"usuń wybrany wpis"),
    DISPLAY_ENTRIES(3, "wyświetlenie wszystkich wpisów"),
    COUNT_STARS(4,"policzenie i wyświetlenie ilości gwiazdek");

    private int value;
    private String description;

    MainOption(int value, String description) {
         this.value = value;
         this.description = description;
        }

    public int getValue() {
            return value;
        }

    public String getDescription() {
            return description;
        }

    public static MainOption createFromInt (int option){
         return MainOption.values()[option]; //to nic innego jak pozycja "option" z domyślnej tablicy "values" :-)
    }
}
//wiem, tu można zrobić interface do opcji... może później
