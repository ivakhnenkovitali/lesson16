package model;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class PersonList {
    private final int SIZE = 5;
    private Person[] people = new Person[SIZE];
    private int index = 0;

    public void add(Person person) {
        if (person != null) {
            if (index == people.length) {
                people = Arrays.copyOf(people, people.length * 2);
            }
            people[index++] = person;
        }
    }

    public void show(){
        System.out.println("people list:");
        for (int i = 0; i < index; i++) {
            System.out.println(people[i]);
        }
    }

    public void saveToFile(String fileName){

        try(PrintWriter pw = new PrintWriter(new FileWriter(fileName))){

            for (int i = 0; i < index; i++) {
                pw.println(people[i].toFileLine());
            }

        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }

    public void loadFromFile(String fileName) {
        try(Scanner scanner = new Scanner(new FileReader(fileName))){
            while (scanner.hasNextLine()){
                String fileLine = scanner.nextLine();
                String[] fields = fileLine.split(" ");
                switch (fields[0]){
                    case "Person":
                        add(new Person(fields[1], Integer.parseInt(fields[2])));
                        break;
                    case "Student":
                        add(new Student(fields[1], Integer.parseInt(fields[2]), Double.parseDouble(fields[3])));
                        break;
                    case "Employee":
                        add(new Employee(fields[1], Integer.parseInt(fields[2]), Double.parseDouble(fields[3])));
                        break;
                }
            }
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }

    }
}
