
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

        if (head.getData() instanceof Contact && c.compareTo(((Contact) head.getData())) < 0) {
            Node<T> temp = head;
            head = new Node<T>((T) c);
            head.setNext(temp);
            return "Contact added successfully!";
        }
        Node<T> newNode = new Node<T>((T) c);
        current = head;
        Node<T> prev = null;
        while (current != null) {
            if (current.getData() instanceof Contact) {
                if (c.compareTo(((Contact) current.getData())) < 0) {

                    newNode.setNext(current);
                    prev.setNext(newNode);
                    current = newNode;
                    return "Contact added successfully!";
                }
            }
            prev = current;
            current = current.getNext();
        }
        if (current == null) {
            prev.setNext(newNode);
            current = head;
            return "Contact added successfully!";
        }

        return "Contact Not added successfully!";
    }

    private String addEvent(Event e) {
        if (head == null) {
            head = new Node<T>((T) e);
            return "Event added successfully!";
        }
        if (head.getData() instanceof Event && e.compareTo(((Event) head.getData())) < 0) {
            Node<T> temp = head;
            head = new Node<T>((T) e);
            head.setNext(temp);
            return "Event added successfully!";
        }
        Node<T> newNode = new Node<T>((T) e);
        if(dateTimeConflict(head, e))
        return"Date Conflict";
        current = head;
        Node<T> prev = null;
        while (current != null) {
            if (current.getData() instanceof Event && e.compareTo((Event) current.getData()) < 0) {
                newNode.setNext(current);
                prev.setNext(newNode);
                current = newNode;
                return "Event added successfully!";
            }
            prev = current;
            current = current.getNext();
        }

        if (current == null) {
            prev.setNext(newNode);
            current = head;
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
        current =head;
        while (current != null) {
            if (current.getData() instanceof Event) {
                Event existingEvent = (Event) current.getData();
                if (existingEvent.getContactName().equalsIgnoreCase(event.getContactName())&&existingEvent.getDataAndTime().equalsIgnoreCase(event.getDataAndTime()))
                    return true;
            } 
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
                head = head.getNext();
                System.out.println("delete contact ");
                return;
            }
        }
        current = head;
        while (current.next != null) {
            if (current.next.data instanceof Contact) {
                if (((Contact) current.next.data).getPhoneNumber().equalsIgnoreCase(phone_number)) {
                    String ContactEventname = ((Contact) head.data).getContactName();
                    current.setNext( current.getNext().getNext());
                    System.out.println("delete contact ");
                    return;// delete contact
                }
            }
            current = current.getNext();
        }
    }// end remove

    public void removeEvent(String ContactEvent) { // start remove event from contact
        current = head;
        if (head == null) {
            return;
        }
        if (head.data instanceof Event) {// check for first one
            if (((Event) head.data).getContactName().equalsIgnoreCase(ContactEvent)) {
                head = head.getNext();
            }
        }
        while (current.next != null) {
            if (current.next.data instanceof Event) {
                if (((Event) current.next.data).getContactName().equalsIgnoreCase(ContactEvent)) {
                	current.setNext( current.getNext().getNext());
                }
            }
            current = current.getNext();
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
                      
                        return current.data;
                    } // end if
                    current = current.getNext();
                } // end while
                break;
            case 2:
                while (current != null) {// start while
                    if (current.data instanceof Contact && ((Contact) current.data).getPhoneNumber().equals(name)) {// start
                                                                                                                    // if
                        System.out.println("Contact found!");
                        
                        return current.data;
                    } // end if
                    current = current.getNext();
                } // end while
                break;
            case 3:
                while (current != null) {// start while
                    if (current.data instanceof Contact && ((Contact) current.data).getEmail().equals(name)) {// start
                                                                                                              // if
                        System.out.println("Contact found!");
                        
                        return current.data;
                    } // end if
                    current = current.getNext();
                } // end while
                break;
            case 4:
                while (current != null) {// start while
                    if (current.data instanceof Contact && ((Contact) current.data).getAddress().equals(name)) {// start
                                                                                                                // if
                        System.out.println("Contact found!");
                       
                        return current.data;
                    } // end if
                    current = current.getNext();
                } // end while
                break;
            case 5:
                while (current != null) {// start while
                    if (current.data instanceof Contact && ((Contact) current.data).getBirthday().equals(name)) {// start
                                                                                                                 // if
                        System.out.println("Contact found!");
                       
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
        System.out.println(((Event) current.data).toString());
    } // end PrintEvent

    public void PrintAllEvent() {
        if (head == null)
            return;
        current = head;
        while (current != null) {
            if (current.data instanceof Event) {
                 System.out.print(((Event) current.data).toString());
            }
            current = current.next;
        }
    }

    /*private void PrintContact(Node<T> temp) {
       System.out.print(((Event) temp.data).toString());

    }*/

    private String Firstname(String name) {
        String Firstname = "";
        for (int i = 0; i < name.length(); i++) {
            if (name.substring(i, i) != " ")
                Firstname += name.substring(i, i);
            else
                break;
        }
        System.out.println(Firstname);
        return Firstname;
    }

    public void PrintByFirstName(String Name) {
        if (head == null)
            System.out.println("No Contacts found!");

        current = head;
        while (current != null) {
            if (current.getData() instanceof Contact)
                if ((Firstname(Name).compareToIgnoreCase(Firstname(((Contact) current.data).getContactName()))) == 0)
                    System.out.println(current.getData().toString() + "\n");
            current = current.getNext();
        }

    }

    public void SearchAll(String s){
        if (head == null)
            System.out.println("No Contacts found!");

        current = head;
        while (current != null) {
            if (current.getData() instanceof Contact)
                if(((Contact)current.getData()).getAddress().equalsIgnoreCase(s)||((Contact)current.getData()).getEmail().equalsIgnoreCase(s)||((Contact)current.getData()).getBirthday().equalsIgnoreCase(s))
                    System.out.println(current.getData().toString());
            current = current.getNext();
        }

    }
    

} // end LinkedList
