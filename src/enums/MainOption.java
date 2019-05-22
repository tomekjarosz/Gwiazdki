package enums;

public enum MainOption{

    EXIT(0,"zapisanie danych i wyjście z programu"),
    ADD_ENTRY(1, "dodanie nowego wpisu"),
    DISPLAY_ENTRIES(2, "wyświetlenie wszystkich wpisów"),
    COUNT_STARS(3,"policzenie i wyświetlenie ilości gwiazdek");

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
