import java.util.Scanner;

public class LinkedList<T> { // start LinkedList
    private Node<T> head;
    private Node<T> current;
    public Scanner input = new Scanner(System.in);

    public void add(T val) {
        if (val instanceof Contact) {
            System.out.println(addContact((Contact) val));
            return;
        }
        if (val instanceof Event) {
            System.out.println(addEvent((Event) val));
            return;
        }
        System.out.println("Can't add this type.");
    }
    
    private String addContact(Contact c) {
        if (head == null) {
            head = new Node<T>((T) c);
            return "Contact added successfully!";
        }
    
        boolean contactExists = existForNumAndName(head, c.getContactName(), c.getPhoneNumber());
        if (contactExists)
            return "The contact already exists.";
    
        if (head.getData() instanceof Contact && c.getContactName().compareTo(((Contact) head.getData()).getContactName()) <= 0) {
            Node<T> temp = head;
            head = new Node<T>((T) c);
            head.setNext(temp);
            return "Contact added successfully!";
        }
    
        Node<T> current = head;
        while (current != null) {
            if (current.getData() instanceof Contact) {
                if (c.getContactName().compareTo(((Contact) current.getData()).getContactName()) <= 0) {
                    Node<T> temp = current;
                    current = new Node<T>((T) c);
                    current.setNext(temp);
                    return "Contact added successfully!";
                }
            }
            current = current.getNext();
        }
    
        return "Contact not added.";
    }
    
    private String addEvent(Event e) {
        if (head == null) {
            head = new Node<T>((T) e);
            return "Event added successfully!";
        }
    
        Contact eventContact = e.getContact_inv();
        boolean eventContactExists = existForNumAndName(head, eventContact.getContactName(), eventContact.getPhoneNumber());
        if (!eventContactExists)
            return "The contact for the event does not exist.";
    
        boolean eventExists = eventExists(head, e);
        if (eventExists)
            return "The event already exists.";
    
        boolean dateTimeConflict = dateTimeConflict(head, e);
        if (dateTimeConflict)
            return "There is a date and time conflict with an existing event.";
    
        Node<T> current = head;
        while (current != null) {
            if (current.getData() instanceof Event&&e.getEventTitle().compareTo(((Event)(current.getData())).getEventTitle())<=0 {
                Node<T> temp = current;
                current = new Node<T>((T) e);
                current.setNext(temp);
                return "Event added successfully!";
            }
            current = current.getNext();
        }
    
        return "Event not added.";
    }
    
    private boolean existForNumAndName(Node<T> head, String contactName, String phoneNumber) {
        Node<T> current = head;
        while (current != null) {
            if (current.getData() instanceof Contact) {
                Contact contact = (Contact) current.getData();
                if (contact.getContactName().equalsIgnoreCase(contactName) && contact.getPhoneNumber().equals(phoneNumber)) {
                    return true;
                }
            }
            current = current.getNext();
        }
        return false;
    }
    
    private boolean eventExists(Node<T> head, Event event) {
        Node<T> current = head;
        while (current != null) {
            if (current.getData() instanceof Event) {
                Event existingEvent = (Event) current.getData();
                if (existingEvent.getEventTitle().equalsIgnoreCase(event.getEventTitle())) {
                    return true;
                }
            }
            current = current.getNext();
        }
        return false;
    }
    
    private boolean dateTimeConflict(Node<T> head, Event event) {
        Node<T> current = head;
        while (current != null) {
            if (current.getData() instanceof Event) {
                Event existingEvent = (Event) current.getData();
                if (existingEvent.getDataAndTime().equals(event.getDataAndTime())) {
                    return true;
                }
            }
            current = current.getNext();
        }
        return false;
    }

    public void Remove(String phone_number) {// start remove
        if (head == null) {
            return;
        } else if (head.data instanceof Contact) {
            if (((Contact) head.data).getPhoneNumber().equalsIgnoreCase(phone_number)) {
                removeEvent(head);// caling method
                head = head.next;
                return;
            }
        }
        current = head;
        while (current.next != null) {
            if (current.next.data instanceof Contact) {
                if (((Contact) current.next.data).getPhoneNumber().equalsIgnoreCase(phone_number)) {
                    removeEvent(current.next);
                    current.next = current.next.next;
                    return;// delete contact
                }
            }
            current = current.next;
        }
    }// end remove

    private void removeEvent(Node<T> ContactEvent) { // start remove event from contact
        if (ContactEvent.data instanceof Contact) {
            String ContactEventname = ((Contact) ContactEvent.data).getContactName();
            Node<T> eventNode = head;
            if (eventNode == null) {
                return;
            }
            if (eventNode.data instanceof Event) {// check for first one
                if (((Event) eventNode.data).getContact_inv().getContactName().equalsIgnoreCase(ContactEventname)) {
                    eventNode = eventNode.next;
                }
            }
            while (eventNode.next != null) {
                if (eventNode.next.data instanceof Event) {
                    if (((Event) eventNode.next.data).getContact_inv().getContactName()
                            .equalsIgnoreCase(ContactEventname)) {
                        eventNode.next = eventNode.next.next;
                    }
                }
                eventNode = eventNode.next;
            }
        }
    }// end remove event from contact

    public T Search(Node<T> head, int num) { // start Search
        if (head == null)
            return null;
        current = head;
        switch (num) { // start switch
            case 1:
                System.out.print("Enter the contact's name:");
                String name = input.next();
                while (current != null) {// start while
                    if (current.data instanceof Contact && ((Contact) current.data).getContactName().equals(name)) {// start
                                                                                                                    // if
                        System.out.println("Contact found!");
                        return current.data;
                    } // end if
                    current = current.next;
                } // end while
                break;
            case 2:
                System.out.print("Enter the contact's phone:");
                String phone = input.next();
                while (current != null) {// start while
                    if (current.data instanceof Contact && ((Contact) current.data).getPhoneNumber().equals(phone)) {// start
                                                                                                                     // if
                        System.out.println("Contact found!");
                        return current.data;
                    } // end if
                    current = current.next;
                } // end while
                break;
            case 3:
                System.out.print("Enter the contact's email:");
                String email = input.next();
                while (current != null) {// start while
                    if (current.data instanceof Contact && ((Contact) current.data).getEmail().equals(email)) {// start
                                                                                                               // if
                        System.out.println("Contact found!");
                        return current.data;
                    } // end if
                    current = current.next;
                } // end while
                break;
            case 4:
                System.out.print("Enter the contact's address:");
                String address = input.next();
                while (current != null) {// start while
                    if (current.data instanceof Contact && ((Contact) current.data).getAddress().equals(address)) {// start
                                                                                                                   // if
                        System.out.println("Contact found!");
                        return current.data;
                    } // end if
                    current = current.next;
                } // end while
                break;
            case 5:
                System.out.print("Enter the contact's birthday:");
                String birthday = input.next();
                while (current != null) {// start while
                    if (current.data instanceof Contact && ((Contact) current.data).getBirthday().equals(birthday)) {// start
                                                                                                                     // if
                        System.out.println("Contact found!");
                        return current.data;
                    } // end if
                    current = current.next;
                } // end while
                break;
            default:
                System.out.println("Wrong number, please do it again");
        } // end switch
        System.out.println("Contact not found!");
        return null;
    }// end Search
}// end LinkedList
