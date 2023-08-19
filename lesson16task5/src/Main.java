import model.PersonList;
import model.Student;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        final String FILE_NAME = "src" + File.separator +
                "data" + File.separator + "people.txt";

        PersonList personList1 = new PersonList();
        personList1.loadFromFile(FILE_NAME);
        personList1.add(new Student("Petya", 25, 5));
        personList1.show();
        personList1.saveToFile(FILE_NAME);
    }
}
