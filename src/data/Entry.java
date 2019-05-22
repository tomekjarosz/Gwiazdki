package data;

public class Entry{

    private static final long serialVersionUID = 3812017177088226528L;

    private String date;
    private String title;
    private int value;

    public Entry(String date, String title, int value) {
        this.date = date;
        this.title = title;
        this.value = value;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String convertToCsv(){
        return date+";"+title+";"+value;
    }

    @Override
    public String toString(){
        return "DATA: "+date+"; TYTUŁ: "+title+", GWIAZDKI: "+value;
    }
}
