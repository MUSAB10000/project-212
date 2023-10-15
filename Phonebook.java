import java.util.Scanner;

public class Phonebook {
    LinkedList<Contact> contact = new LinkedList<>();;
    LinkedList<Event> event = new LinkedList<>();;
    public Scanner input = new Scanner(System.in);

    public void display() {
        System.out.println("Welcome to the Linked Tree Phonebook!\n" +
                "Please choose an option:\n" +
                "1. Add a contact\n" +
                "2. Search for a contact\n" +
                "3. Delete a contact\n" +
                "4. Schedule an event\n" +
                "5. Print event details\n" +
                "6. Print contacts by first name\n" +
                "7. Print all events alphabetically\n" +
                "8. Exit");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                System.out.print("Enter the contact's name: ");
                String name = input.nextLine();

                System.out.print("Enter the contact's phone number: ");
                String phoneNumber = input.nextLine();

                System.out.print("Enter the contact's email address: ");
                String email = input.nextLine();

                System.out.print("Enter the contact's address: ");
                String address = input.nextLine();

                System.out.print("Enter the contact's birthday: ");
                String birthday = input.nextLine();

                System.out.print("Enter any notes for the contact: ");
                String notes = input.nextLine();
                Contact x = new Contact(name, phoneNumber, email, address, birthday, notes);
                contact.add(x);
                break;
            case 2:
                System.out.print("Enter search criteria:\n" +
                        "1. Name\n" +
                        "2. Phone Number\n" +
                        "3. Email Address\n" +
                        "4. Address\n" +
                        "5. Birthday\n" +
                        "Enter your choice: ");
                int choice2 = input.nextInt();
                contact.Search(contact.getHead(), choice2);
                break;
                1 // معتمد احطها خطأ
            case 3:
                System.out.println("Enter phone number to delete a contact");
                String phone = input.nextLine();
                contact.Remove(phone);
                break;
            case 4:
                System.out.print("Enter event title: ");
                String eventTitle = input.nextLine();

                System.out.print("Enter contact name: ");
                String contactName = input.nextLine();

                System.out.print("Enter event date and time (MM/DD/YYYY HH:MM): ");
                String dateTime = input.nextLine();

                System.out.print("Enter event location: ");
                String location = input.nextLine();
                Contact contact = new Contact(contactName);
                Event event1 = new Event(eventTitle, dateTime, location, contact);
                event.add(event1);
                break;
            case 5:

                break;

            case 6:

                break;
            case 7:

                break;

        }
    }
}
