package InOut;

import InOut.Printer;

public class Info {

    public static void welcome() {
        Printer.display(
                "Witaj w programie <<Gwiazdki v1.0>> :-) \n" +
                      "\n" +
                      "Celem programu jest umożliwienie ewidencji gwiazdek przyznawanych dzieciom za dobre zachowanie, \n" +
                      "jak również ewidencja ich odbierania (kara/odbiór nagrody).\n"  +
                      "\n" +
                      "Na obecnym etapie program pozwala na ewidencję zdarzeń jednego dziecka, ale to się z czasem zmieni. \n" +
                      "Pojedynczy wpis na postać: data w formacie DD.MM.YYYY, treść oraz liczba całkowita, \n" +
                      "która oznacza ilość przyznanych/odebranych gwiazek. \n"
        );
    }

    public static void printByeBye(){} //TBD
}