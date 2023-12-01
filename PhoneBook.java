import java.util.Scanner;

public class PhoneBook {

    LinkedList<Contact> contacts;
    LinkedList<Event> events;
    public Scanner input = new Scanner(System.in);

    public PhoneBook() {
        contacts = new LinkedList<>();
        events = new LinkedList<>();
    }

    public void display() {
        int choice = 0;
        System.out.println("Welcome to the Linked Tree Phonebook!\n");
        do {
            System.out.println(
                    "Please choose an option:\n" +
                            "1. Add a contact\n" +
                            "2. Search for a contact\n" +
                            "3. Delete a contact\n" +
                            "4. Schedule an event\n" +
                            "5. Print event details\n" +
                            "6. Print contacts by first name\n" +
                            "7. Print all events alphabetically\n" +
                            "8. Exit\n");
            System.out.println("Enter your choice:");
            choice = input.nextInt();// Assuming the user is reasnoable user

            switch (choice) {// start big switch
                case 1:
                    System.out.print("Enter the contact's name: ");
                    String name = input.next();
                    name += input.nextLine();
                    System.out.print("\nEnter the contact's phone number: ");
                    String phoneNumber = input.next();
                    System.out.print("\nEnter the contact's email address: ");
                    String email = input.next();

                    System.out.print("Enter the contact's address: ");
                    String address = input.next();
                    address += input.nextLine();
                    System.out.print("Enter the contact's birthday: ");
                    String birthday = input.next();
                    System.out.print("Enter any notes for the contact: ");
                    String notes = input.next();
                    notes += input.nextLine();
                    Contact x = new Contact(name, phoneNumber, email, address, birthday, notes);
                    contacts.add(x);
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
                    switch (choice2) {// start small switch
                        case 1:
                            System.out.println("Enter the contact's name:");
                            name = input.next();
                            name += input.nextLine();
                            Contact c = contacts.SearchContact(contacts.getHead(), name, choice2);
                            if (c != null) {
                                System.out.println("contact found!");
                                System.out.println(c.toString());
                            } else
                                System.out.println("contact not found!");
                            break;
                        case 2:
                            System.out.println("Enter the contact's phone number:");
                            phoneNumber = input.next();
                            c = contacts.SearchContact(contacts.getHead(), phoneNumber, choice2);
                            if (c != null) {
                                System.out.println("contact found!");
                                System.out.println(c.toString());
                            } else
                                System.out.println("contact not found!");
                            break;
                        case 3:
                            System.out.println("Enter the contact's email address:");
                            email = input.next();
                            if (contacts.SearchContact(contacts.getHead(), email, 3) != null) {
                                printContact(email);
                                break;
                            } else {
                                System.out.println("No Contacts found!");
                                break;

                            }
                        case 4:
                            System.out.println("Enter the contact's address: ");
                            address = input.next();
                            address += input.nextLine();
                            if (contacts.SearchContact(contacts.getHead(), address, 4) != null) {
                                printContact(address);
                                break;
                            } else {
                                System.out.println("No Contacts found!");
                                break;
                            }
                        case 5:
                            System.out.println("Enter the contact's birthday: ");
                            birthday = input.next();
                            if (contacts.SearchContact(contacts.getHead(), birthday, 5) != null) {
                                printContact(birthday);
                                break;
                            } else {
                                System.out.println("No Contacts found!");
                                break;
                            }
                        default:
                            System.out.println("Wrong number, please do it again");
                    }// end small switch
                    break;
                case 3:
                    System.out.println("Enter phone number to delete a contact");
                    String phone = input.next();

                    Contact numberPhon = contacts.SearchContact(contacts.getHead(), phone, 2);
                    if (numberPhon == null) {
                        System.out.println("Contact Number Not Found!");
                        break;
                    }
                    events.RemoveEvent(numberPhon.getContactName());
                    contacts.RemoveContact(phone);
                    break;
                case 4:
                    System.out.print("Enter event title: ");
                    String eventTitle = input.next();
                    eventTitle += input.nextLine();
                    System.out.print("Enter contact name: ");
                    String contactName = input.next();
                    contactName += input.nextLine();
                    System.out.print("Enter event date and time (MM/DD/YYYY HH:MM): ");
                    String dateTime = input.next();
                    dateTime += input.nextLine();
                    System.out.print("Enter event location: ");
                    String location = input.next();
                    location += input.nextLine();

                    Contact contact = contacts.SearchContact(contacts.getHead(), contactName, 1);
                    if (contact == null) {
                        System.out.println("The contact does not exist!");
                        break;
                    }
                    Event event1 = new Event(eventTitle, dateTime, location, contact);
                    events.add(event1);
                    break;
                case 5:
                    System.out.println("Enter search criteria:\r\n" + //
                            "1. contact name\r\n" + //
                            "2. Event tittle");
                    choice2 = input.nextInt();
                    switch (choice2) {
                        case 1:
                            System.out.println("Enter the Contact Name:");
                            contactName = input.next();
                            contactName += input.nextLine();
                            Event E = (Event) events.SearchEvent(events.getHead(), contactName, choice2);
                            System.out.println(E.toString());
                            break;
                        case 2:
                            System.out.println("Enter the event title:");
                            eventTitle = input.next();
                            eventTitle += input.nextLine();
                            if (events.SearchEvent(events.getHead(), eventTitle, 2) != null)
                                PrintEventTitle(eventTitle);
                            break;
                        default:
                            System.out.println("Wrong number, please do it again");
                    }
                    break;

                case 6:
                    System.out.println("Enter the First Name you want to search for:");

                    String FName = input.next();

                    printByFirstName(FName);
                    break;
                case 7:
                    PrintAllEvent();
                    break;

                case 8:
                    break;
                default:
                    System.out.println("Wrong number, please do it again");

            } // end big switch
        } while (choice != 8);

        System.out.println("Goodbye !");

    }

    private void printContact(String s) {// Print all contact that have the same S:Can be Email or Adrress or Birthday.
        contacts.findfirst();
        while (contacts.last() == false) {
            if (contacts.retrieve().getEmail().equalsIgnoreCase(s)
                    || contacts.retrieve().getAddress().equalsIgnoreCase(s)
                    || contacts.retrieve().getBirthday().equalsIgnoreCase(s)) {
                System.out.println("contact found");
                System.out.println(contacts.retrieve().toString());
            }
            contacts.findnext();

        }
        if (contacts.retrieve().getEmail().equalsIgnoreCase(s)
                || contacts.retrieve().getAddress().equalsIgnoreCase(s)
                || contacts.retrieve().getBirthday().equalsIgnoreCase(s)) {
            System.out.println("contact found");
            System.out.println(contacts.retrieve().toString());
        }

    }

    private void PrintAllEvent() {
        if (events.empty()) {
            System.out.println("There is No Event right now");
            return;
        }
        events.findfirst();
        while (events.last() == false) {
            System.out.println(events.retrieve().toString());
            events.findnext();
        }
        System.out.println(events.retrieve().toString());

    }

    private String extractFirstName(String name) {
        int index = name.indexOf(' ');
        if (index != -1) {
            return name.substring(0, index);
        }
        return name;
    }

    private void printByFirstName(String name) {
        if (contacts.empty()) {
            System.out.println("No Contacts found!");
            return;
        }

        Node<Contact> current = contacts.getHead();
        while (current != null) {
            String firstName = extractFirstName(current.data.getContactName());
            if (name.compareToIgnoreCase(firstName) == 0) {
                System.out.println(current.data.toString() + "\n");
            }
            current = current.next;
        }
    }

    private void PrintEventTitle(String title) {// Print the Event that has the same Title
        if (events.empty())
            System.out.println("No Contacts found!");

        events.findfirst();
        while (events.last() == false) {
            if (events.retrieve().getEventTitle().equalsIgnoreCase(title)) {
                System.out.println(events.retrieve().toString());
            }
            events.findnext();
        }
        if (events.retrieve().getEventTitle().equalsIgnoreCase(title)) {
            System.out.println(events.retrieve().toString());
        }

    }
}
