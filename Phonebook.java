import java.util.Scanner;
import java.util.Date;

public class Phonebook {

    LinkedList<Contact> contacts;
    LinkedList<Event> events;
    public Scanner input = new Scanner(System.in);

    public Phonebook() {
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
                            "8. Exit");
             try{               
             choice = input.nextInt();
             }catch(Exception e){
                   e.getMessage();
             }

            switch (choice) {// start big switch
                case 1:
                    System.out.print("Enter the contact's name: ");
                    String name = input.next();

                    System.out.print("\nEnter the contact's phone number: ");
                    String phoneNumber = input.next();

                    System.out.print("\nEnter the contact's email address: ");
                    String email = input.next();

                    System.out.print("Enter the contact's address: ");
                    String address = input.next();

                    System.out.print("Enter the contact's birthday: ");
                    String birthday = input.next();

                    System.out.print("Enter any notes for the contact: ");
                    String notes = input.next();
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
                            contacts.SearchContact(contacts.getHead(), name, choice2);
                            break;
                        case 2:
                            System.out.println("Enter the contact's phone number:");
                            phoneNumber = input.next();
                            contacts.SearchContact(contacts.getHead(), phoneNumber, choice2);
                            break;
                        case 3:
                            System.out.println("Enter the contact's email address:");
                            email = input.next();
                            contacts.SearchContact(contacts.getHead(), email, choice2);
                            break;
                        case 4:
                            System.out.println("Enter the contact's address: ");
                            address = input.next();
                            contacts.SearchContact(contacts.getHead(), address, choice2);
                            break;
                        case 5:
                            System.out.println("Enter the contact's birthday: ");
                            birthday = input.next();
                            contacts.SearchContact(contacts.getHead(), birthday, choice2);
                            break;
                        default:
                            System.out.println("Wrong number, please do it again");
                    }// end small switch
                    break;
                case 3:
                    System.out.println("Enter phone number to delete a contact");
                    String phone = input.next();
                    contacts.Remove(phone);
                    break;
                case 4:
                    System.out.print("Enter event title: ");
                    String eventTitle = input.next();

                    System.out.print("Enter contact name: ");
                    String contactName = input.next();

                    System.out.print("Enter event date and time (MM/DD/YYYY HH:MM): ");
                    Date dateTime = new Date(input.next());

                    System.out.print("Enter event location: ");
                    String location = input.next();
                    Contact contact = contacts.SearchContact(contacts.getHead(), contactName, 1);
                    if(contact==null){
                       System.out.println("Contant Not Exist");
                       break;
                    }
                   
                    Event event1 = new Event(eventTitle, dateTime, location, contact);
                      System.out.println("1NewEVENT  ;;");
                    events.add(event1);
                    System.out.println("2NewEVENT  ;;");
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
                            events.PrintEvent(events.getHead(), contactName, choice2);
                            break;
                        case 2:
                            System.out.println("Enter the event title:");
                            eventTitle = input.next();
                            events.PrintEvent(events.getHead(), eventTitle, choice2);
                            break;
                        default:
                            System.out.println("Wrong number, please do it again");
                    }
                    break;

                case 6:
                 
                 

                    break;
                case 7:
                    events.PrintAllEvent();
                    break;

            }
        } while (choice != 8);
        // end big switch
    }
    
    
}
