import java.util.ArrayList;
import java.util.Scanner;

class Person {
    private String fullName;
    private String mobileNumber;
    private String email;

    public Person(String fullName, String mobileNumber, String email) {
        this.fullName = fullName;
        this.mobileNumber = mobileNumber;
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void showDetails() {
        System.out.println("Full Name: " + fullName);
        System.out.println("Mobile Number: " + mobileNumber);
        System.out.println("Email: " + email);
        System.out.println("----------------------------");
    }
}

public class PRODIGY_SD_03 {
    private static ArrayList<Person> personList = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int option;

        do {
            System.out.println("Contact Manager");
            System.out.println("1. Add New Person");
            System.out.println("2. View All Contacts");
            System.out.println("3. Update Contact");
            System.out.println("4. Remove Contact");
            System.out.println("5. Exit");
            System.out.print("Enter your option: ");
            option = input.nextInt();
            input.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    addPerson();
                    break;
                case 2:
                    viewAllContacts();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    System.out.println("Exiting Contact Manager. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please enter a valid choice.");
            }

        } while (option != 5);

        input.close();
    }

    private static void addPerson() {
        System.out.print("Enter Full Name: ");
        String fullName = input.nextLine();
        System.out.print("Enter Mobile Number: ");
        String mobileNumber = input.nextLine();
        System.out.print("Enter Email: ");
        String email = input.nextLine();

        Person newPerson = new Person(fullName, mobileNumber, email);
        personList.add(newPerson);
        System.out.println("Person added successfully!");
    }

    private static void viewAllContacts() {
        if (personList.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            System.out.println("Contact List:");
            for (Person person : personList) {
                person.showDetails();
            }
        }
    }

    private static void updateContact() {
        if (personList.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            viewAllContacts();
            System.out.print("Enter the index of the contact you want to update: ");
            int index = input.nextInt();
            input.nextLine(); // Consume newline

            if (index >= 0 && index < personList.size()) {
                System.out.println("Updating Contact:");
                personList.get(index).showDetails();

                System.out.print("Enter new Full Name: ");
                String newFullName = input.nextLine();
                System.out.print("Enter new Mobile Number: ");
                String newMobileNumber = input.nextLine();
                System.out.print("Enter new Email: ");
                String newEmail = input.nextLine();

                Person updatedPerson = new Person(newFullName, newMobileNumber, newEmail);
                personList.set(index, updatedPerson);
                System.out.println("Contact updated successfully!");
            } else {
                System.out.println("Invalid index. Please enter a valid index.");
            }
        }
    }

    private static void removeContact() {
        if (personList.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            viewAllContacts();
            System.out.print("Enter the index of the contact you want to remove: ");
            int index = input.nextInt();
            input.nextLine(); // Consume newline

            if (index >= 0 && index < personList.size()) {
                System.out.println("Removing Contact:");
                personList.get(index).showDetails();
                personList.remove(index);
                System.out.println("Contact removed successfully!");
            } else {
                System.out.println("Invalid index. Please enter a valid index.");
            }
        }
    }
}
