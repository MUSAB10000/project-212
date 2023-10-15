import java.util.Scanner;

public class LinkedList<T> { // start LinkedList
    private Node<T> head;
    private Node<T> current;

    public Node<T> getHead() {
        return head;
    }

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

        if (head.getData() instanceof Contact && c.compareTo(((Contact) head.getData())) > 0) {
            Node<T> temp = head;
            head = new Node<T>((T) c);
            head.setNext(temp);
            return "Contact added successfully!";
        } 
 
        current = head;
        Node<T> Prev=null;
        while (current != null) {
            if (current.getData() instanceof Contact) {
                if (c.compareTo(((Contact) current.getData())) > 0) {
                    Node<T> temp = new Node<T>((T) c);
                    temp.setNext(current);
                    prev.setNexy(temp) ;
                    current=temp;
                    return "Contact added successfully!";
                }
            }
            prev=current;
            current = current.getNext();
        }
        current.setNext(new Node<T>((T) c));

        return "Contact added successfully!";
    }

    private String addEvent(Event e) {
        if (head == null) {
            head = new Node<T>((T) e);
            return "Event added successfully!";
        }

        Contact eventContact = e.getContact_inv();
        boolean eventContactExists = existForNumAndName(head, eventContact.getContactName(),
                eventContact.getPhoneNumber());
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
            if (current.getData() instanceof Event
                    && e.getEventTitle().compareTo(((Event) (current.getData())).getEventTitle()) > 0) {
                    Node<T> temp = new Node<T>((T) c);
                    temp.setNext(current);
                    prev.setNexy(temp) ;
                    current=temp;
                return "Event added successfully!";
            }
            current = current.getNext();
        }
        current.setNext(new Node<T>((T) e));

        return "Event added successfully!";
    }

    private boolean existForNumAndName(Node<T> head, String contactName, String phoneNumber) {
        Node<T> current = head;
        while (current != null) {
            if (current.getData() instanceof Contact) {
                Contact contact = (Contact) current.getData();
                if (contact.getContactName().equalsIgnoreCase(contactName)
                        && contact.getPhoneNumber().equals(phoneNumber)) {
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
                String ContactEventname = ((Contact) head.data).getContactName();
                removeEvent(ContactEventname);// caling method
                head = head.next;
                return;
            }
        }
        current = head;
        while (current.next != null) {
            if (current.next.data instanceof Contact) {
                if (((Contact) current.next.data).getPhoneNumber().equalsIgnoreCase(phone_number)) {
                    String ContactEventname = ((Contact) head.data).getContactName();
                    removeEvent(ContactEventname);
                    current.next = current.next.next;
                    return;// delete contact
                }
            }
            current = current.next;
        }
    }// end remove

    private void removeEvent(String ContactEvent) { // start remove event from contact
        Node<T> eventNode = head;
        if (eventNode == null) {
            return;
        }
        if (eventNode.data instanceof Event) {// check for first one
            if (((Event) eventNode.data).getContactName().equalsIgnoreCase(ContactEvent)) {
                eventNode = eventNode.next;
            }
        }
        while (eventNode.next != null) {
            if (eventNode.next.data instanceof Event) {
                if (((Event) eventNode.next.data).getContactName().equalsIgnoreCase(ContactEvent)) {
                    eventNode.next = eventNode.next.next;
                }
            }
            eventNode = eventNode.next;
        }
    }// end remove event from contact

    public T SearchContact(Node<T> head, String name , int num) { // start SearchContact
        if (head == null)
            return null;
        current = head;
        switch (num) { // start switch
            case 1:
                while (current != null) {// start while
                    if (current.data instanceof Contact && ((Contact) current.data).getContactName().equals(name)) {// start if
                        System.out.println("Contact found!");
                        return current.data;
                    } // end if
                    current = current.next;
                } // end while
                break;
            case 2:
                while (current != null) {// start while
                    if (current.data instanceof Contact && ((Contact) current.data).getPhoneNumber().equals(name)) {// start if
                        System.out.println("Contact found!");
                        return current.data;
                    } // end if
                    current = current.next;
                } // end while
                break;
            case 3:
                while (current != null) {// start while
                    if (current.data instanceof Contact && ((Contact) current.data).getEmail().equals(name)) {// start if
                        System.out.println("Contact found!");
                        return current.data;
                    } // end if
                    current = current.next;
                } // end while
                break;
            case 4:
                while (current != null) {// start while
                    if (current.data instanceof Contact && ((Contact) current.data).getAddress().equals(name)) {// start if
                        System.out.println("Contact found!");
                        return current.data;
                    } // end if
                    current = current.next;
                } // end while
                break;
            case 5:
                while (current != null) {// start while
                    if (current.data instanceof Contact && ((Contact) current.data).getBirthday().equals(name)) {// start if
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
    
    public void PrintEvent(Node<T> head, String name , int num) { // start PrintEvent
        if (head == null){ // start if
        System.out.println("Event not found!");
            return ;
        }//end if
        current = head;
        switch (num) { // start switch
            case 1:
            while (current != null) {// start while
                    if (current.data instanceof Event && ((Event) current.data).getContactName().equals(name)) {// start if
                        System.out.println("Event found!");
                        break;
                    } // end if
                } // end while
                break;
            case 2:
                while (current != null) {// start while
                    if (current.data instanceof Event && ((Event) current.data).getEventTitle().equals(name)) {// start if
                        System.out.println("Event found!");
                        break;
                    } // end if
                } // end while
                break;
        } // end switch
        if (current == null)
        return;
        System.out.println("Event title:" + ((Event)current.data).getEventTitle());
    } // end PrintEvent
} // end LinkedList
