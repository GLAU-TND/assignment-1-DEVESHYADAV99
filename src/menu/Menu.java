package menu;

import person.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Menu {
    private ArrayList<Person> arrayList;
    private Scanner scan;

    public Menu() {
        scan = new Scanner(System.in);
        arrayList = new ArrayList<>();
    }

    public int showChoice() {
        System.out.println("Welcome to Devesh's Contact List App\n" +
                "Press 1 to add a new contact\n" +
                "Press 2 to view all contacts\n" +
                "Press 3 to search for a contact\n" +
                "Press 4 to delete a contact\n" +
                "Press 5 to exit program");
        return scan.nextInt();
    }

    public void addChoice() {
        Person person = new Person();
        String name;
        System.out.println("You have chosen to add a new contact: \n" +
                "Please enter the name of the Person\n");
        scan.nextLine();

        System.out.print("First Name: ");
        name = scan.nextLine().trim();
        person.setFirstName(name);

        System.out.print("Last Name: ");
        name = scan.nextLine().trim();
        person.setLastName(name);

        String number;
        System.out.print("Contact Number: ");
        number = scan.nextLine().trim();
        person.setPhoneNumbers(number);

        char c;
        System.out.print("Would you like to add another contact number? (y/n): ");
        c = scan.nextLine().trim().charAt(0);
        while (c == 'y') {
            System.out.print("Contact Number: ");
            number = scan.nextLine().trim();
            person.setPhoneNumbers(number);

            System.out.print("Would you like to add another contact number? (y/n): ");
            c = scan.nextLine().trim().charAt(0);
        }


        String email = null;
        System.out.print("Would you like to add email address? (y/n): ");
        c = scan.nextLine().trim().charAt(0);
        if (c == 'y') {
            System.out.print("Email Address: ");
            email = scan.nextLine().trim();
            person.setEmailID(email);
        } else {
            person.setEmailID("");
        }
        arrayList.add(person);
    }

    public void viewChoice() {
        Collections.sort(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }

    public void searchChoice() {
        int counter = 0;
        Collections.sort(arrayList);
        System.out.print("You could search for a contact from their first names: ");
        scan.nextLine();
        String name = scan.nextLine().trim();
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getFirstName().compareTo(name) == 0)
                counter++;
        }
        System.out.println(counter + " match found!");
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getFirstName().compareTo(name) == 0)
                System.out.println(arrayList.get(i));
        }
    }

    public void deleteChoice() {
        System.out.println("Here are all your contacts:");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println((i + 1) + ". " + arrayList.get(i).getFirstName() + " " + arrayList.get(i).getLastName());
        }
        System.out.print("Press the number against the contact to delete it: ");
        Person person = arrayList.remove(scan.nextInt() - 1);

        System.out.println(person.getFirstName() + " " + person.getLastName() + "'s contact deleted from list!");
    }

    public void exitChoice() {
        System.out.println("Exiting");
    }
}