package model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Person {
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Person() {

    }

    protected static void readFileAndCreateObjects() throws FileNotFoundException {
        FileReader fileReader = new FileReader("src/main/java/model/data.txt");
        Scanner scanner = new Scanner(fileReader);
        int IDcounter = 0;
        Map<Integer, Person> allPersonsList = new HashMap<Integer, Person>();

        while (scanner.hasNextLine()) {
            Person person = new Person();
            String[] data = scanner.nextLine().split(",");
            IDcounter++;
            person.setFirstName(data[0]);
            person.setLastName(data[1]);
            person.setPhoneNumber(data[2]);

            allPersonsList.put(IDcounter, person);
            }
        printAllList(allPersonsList);
    }

    private static void printAllList(Map<Integer, Person> allPersonsList) {
        for (Integer line: allPersonsList.keySet()){
            Integer key = line;
            String value = allPersonsList.get(line).toString();
            System.out.println("ID " + key + ". " + value);
        }
    }

    @Override
    public String toString() {
        return  "Name: " + " " + firstName + '\t'+
                "Surname: " + lastName + '\t' +
                "Phone number: " + phoneNumber;
        }
}
