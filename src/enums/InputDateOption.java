package enums;

import java.time.LocalDate;

public enum InputDateOption {

    TODAY(0, "dzisiaj ("+getDateMinusDays(0)+")"),
    YESTERDAY(1, "wczoraj ("+getDateMinusDays(1)+")"),
    DAY_BEFORE_YESTERDAY(2, "przedwczoraj ("+getDateMinusDays(2)+")"),
    MANUAL(3, "podaj inną datę");

    private int value;
    private String description;

    InputDateOption(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static InputDateOption createFromInt (int option){
        return InputDateOption.values()[option];
    }

    private static String getDateMinusDays(int x){

        LocalDate now = LocalDate.now();

        int day = now.getDayOfMonth()-x;
        int month = now.getMonthValue();
        int year = now.getYear();

        String twoDigitDay;
        if (day<10) {twoDigitDay="0"+day;} else {twoDigitDay=""+day;}

        String twoDigitMonth;
        if (month<10) {twoDigitMonth="0"+month;} else {twoDigitMonth=""+month;}

        return twoDigitDay+"."+twoDigitMonth+"."+year;
    }
}
