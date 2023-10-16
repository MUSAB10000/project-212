
import java.util.Date;

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
        Node<T> newNode= new Node<T>((T) c);
        current = head;
        Node<T> prev = null;
        while (current != null) {
            if (current.getData() instanceof Contact) {
                if (c.compareTo(((Contact) current.getData())) > 0) {
                    
                    newNode.setNext(current);
                    prev.setNext(newNode);
                    current = newNode;
                    return "Contact added successfully!";
                }
            }
            prev = current;
            current = current.getNext();
        }
        if(current==null){
        prev.setNext(newNode);
        current=head;
        return "Contact added successfully!";
        }


        return "Contact Not added successfully!";
    }

    private String addEvent(Event e) {
        if (head == null) {
            head = new Node<T>((T) e);
            return "Event added successfully!";
        }
        boolean dateTimeConflict = dateTimeConflict(head, e);
        if (dateTimeConflict){
            return "There is a date and time conflict with an existing event.";
        }
        if (head.getData() instanceof Event && e.compareTo(((Event) head.getData())) > 0) {
            Node<T> temp = head;
            head = new Node<T>((T) e);
            head.setNext(temp);
            return "Event added successfully!";
        }
        Node<T> newNode= new Node<T>((T) e);
        current = head;
        Node<T> prev = null;
        while (current != null) {
            if (current.getData() instanceof Event && e.compareTo((Event) current.getData()) > 0) {
                newNode.setNext(current);
                prev.setNext(newNode);
                current = newNode;
                return "Event added successfully!";
            }
           }
            prev = current;
            current = current.getNext();
             
        
        if(current==null){
        prev.setNext(newNode);
        current=head;
        return "Event added successfully!";
        }

        return "Event Not Adeed!";

    }

    private boolean existForNumAndName(Node<T> head, String contactName, String phoneNumber) {
        if (SearchContact(head, contactName, 1) == null || SearchContact(head, phoneNumber, 2) == null)
            return false;
        else
            return true;
    }

    private boolean dateTimeConflict(Node<T> head, Event event) {
        Node<T> current = head;
        while (current != null) {
            if (current.getData() instanceof Event) {
                Event existingEvent = (Event) current.getData();
                if (0 == existingEvent.getDataAndTime().compareTo(event.getDataAndTime()))
                    return true;
            } else
                current = current.getNext();
        }
        return false;
    }

    public void Remove(String phone_number) {// start remove
        if (head == null) {
            System.out.println("Contact not found");
            return;
        } else if (head.data instanceof Contact) {
            if (((Contact) head.data).getPhoneNumber().equalsIgnoreCase(phone_number)) {
                String ContactEventname = ((Contact) head.data).getContactName();
                removeEvent(ContactEventname);// caling method
                head = head.next;
                System.out.println("delete contact ");
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
                    System.out.println("delete contact ");
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

    public T SearchContact(Node<T> head, String name, int num) { // start SearchContact
        if (head == null) {
            System.out.println("Contact not found");
            return null;
        }
        current = head;
        switch (num) { // start switch
            case 1:
                while (current != null) {// start while
                    if (current.data instanceof Contact && ((Contact) current.data).getContactName().equals(name)) {// start
                                                                                                                    // if
                        System.out.println("Contact found!");
                        PrintContact(current);
                        return current.data;
                    } // end if
                    current = current.next;
                } // end while
                break;
            case 2:
                while (current != null) {// start while
                    if (current.data instanceof Contact && ((Contact) current.data).getPhoneNumber().equals(name)) {// start
                                                                                                                    // if
                        System.out.println("Contact found!");
                        PrintContact(current);
                        return current.data;
                    } // end if
                    current = current.next;
                } // end while
                break;
            case 3:
                while (current != null) {// start while
                    if (current.data instanceof Contact && ((Contact) current.data).getEmail().equals(name)) {// start
                                                                                                              // if
                        System.out.println("Contact found!");
                        PrintContact(current);
                        return current.data;
                    } // end if
                    current = current.next;
                } // end while
                break;
            case 4:
                while (current != null) {// start while
                    if (current.data instanceof Contact && ((Contact) current.data).getAddress().equals(name)) {// start
                                                                                                                // if
                        System.out.println("Contact found!");
                        PrintContact(current);
                        return current.data;
                    } // end if
                    current = current.next;
                } // end while
                break;
            case 5:
                while (current != null) {// start while
                    if (current.data instanceof Contact && ((Contact) current.data).getBirthday().equals(name)) {// start
                                                                                                                 // if
                        System.out.println("Contact found!");
                        PrintContact(current);
                        return current.data;
                    } // end if
                    current = current.next;
                } // end while
                break;
        } // end switch
        System.out.println("Contact not found!");
        return null;
    }// end Search

    public void PrintEvent(Node<T> head, String name, int num) { // start PrintEvent
        if (head == null) { // start if
            System.out.println("Event not found!");
            return;
        } // end if
        current = head;
        switch (num) { // start switch
            case 1:
                while (current != null) {// start while
                    if (current.data instanceof Event && ((Event) current.data).getContactName().equals(name)) {// start
                                                                                                                // if
                        System.out.println("Event found!");
                        break;
                    } // end if
                } // end while
                break;
            case 2:
                while (current != null) {// start while
                    if (current.data instanceof Event && ((Event) current.data).getEventTitle().equals(name)) {// start
                                                                                                               // if
                        System.out.println("Event found!");
                        break;
                    } // end if
                } // end while
                break;
        } // end switch
        if (current == null)
            return;
        System.out.println("Event title:" + ((Event) current.data).getEventTitle());
        System.out.println("Contact name:" + ((Event) current.data).getContactName());
        System.out.println("Event date and time (MM/DD/YYYY HH:MM):" + ((Event) current.data).getDataAndTime());
        System.out.println("Event Location:" + ((Event) current.data).getLocation());
    } // end PrintEvent


    public void PrintAllEvent() {
        if (head == null)
            return;
        current = head;
        while (current != null) {
            if (current.data instanceof Event) {
                System.out.println("Event title:" + ((Event) current.data).getEventTitle());
                System.out.println("Contact name:" + ((Event) current.data).getContactName());
                System.out.println("Event date and time (MM/DD/YYYY HH:MM):" + ((Event) current.data).getDataAndTime());
                System.out.println("Event Location:" + ((Event) current.data).getLocation());
            }
            current = current.next;
        }
    }

    private void PrintContact(Node<T> temp) {
        System.out.println("Name:" + ((Contact) temp.data).getContactName());
        System.out.println("Phone Number:" + ((Contact) temp.data).getPhoneNumber());
        System.out.println("Email Address:" + ((Contact) temp.data).getEmail());
        System.out.println("Address:" + ((Contact) temp.data).getAddress());
        System.out.println("Birthday:" + ((Contact) temp.data).getBirthday());
        System.out.println("Notes:" + ((Contact) temp.data).getNotes());

    }


    private String Firstname(String name){
        String Firstname = "";
        for(int i = 0; i < name.length(); i++){
            if(name.substring(i,i) != " ")
            Firstname += name.substring(i,i);
            else
            break;
        }
        System.out.println(Firstname);
        return Firstname;
     }
   public void PrintByFirstName(String Name){
    if (head==null)
        System.out.println("No Contacts found!");

    current=head;
    while(current!=null){
        if(current.getData() instanceof Contact)
        if ((Firstname(Name).compareToIgnoreCase(Firstname(((Contact)current.data).getContactName()))) == 0)
            System.out.println(current.getData().toString() + "\n");
        current=current.getNext();
    }

    }

} // end LinkedList
