public class LinkedList<T> { // start LinkedList
    private Node<T> head;
    private Node<T> current;

    public boolean empty() {
        return head == null;
    }

    public boolean last() {
        return current.getNext() == null;
    }

    public void findfirst() {
        current = head;
    }

    public void findnext() {
        current = current.getNext();
    }

    public T retrieve() {
        return current.getData();
    }

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
        if (dateTimeConflict(head, e))  // new edit
            return "Event Not Adeed! DateAndTime Conflict";

        if (head.getData() instanceof Event && e.compareTo(((Event) head.getData())) < 0) {
            Node<T> temp = head;
            head = new Node<T>((T) e);
            head.setNext(temp);
            return "Event added successfully!";
        }
        Node<T> newNode = new Node<T>((T) e);
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

    private boolean existForNumAndName(Node<T> head, String contactName, String phoneNumber) {//check if number or name have been used before in contact.
        if (SearchContact(head, contactName, 1) == null && SearchContact(head, phoneNumber, 2) == null)
            return false;
        else
            return true;
    }

    private boolean dateTimeConflict(Node<T> head, Event event) {//cheack if there is an event that has the same DateAndTime and the same name, Assuming the name of contact is unique.
        current = head;
        while (current != null) {
            if (current.getData() instanceof Event) {
                Event existingEvent = (Event) current.getData();
                if (existingEvent.getContactName().equalsIgnoreCase(event.getContactName())
                        && existingEvent.getDataAndTime().equalsIgnoreCase(event.getDataAndTime()))
                    return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public void RemoveContact(String phone_number) {
        if (head == null) {
            System.out.println("Contact not found");
            return;
        }

        if (head.data instanceof Contact && ((Contact) head.data).getPhoneNumber().equalsIgnoreCase(phone_number)) {
            head = head.getNext();
            System.out.println("Contact deleted");
            return;
        }

        current = head;
        while (current.getNext() != null) {
            if (current.getNext().data instanceof Contact) {
                if (((Contact) current.getNext().data).getPhoneNumber().equalsIgnoreCase(phone_number)) {
                    if (current.getNext().getNext() != null) {
                        current.setNext(current.getNext().getNext());
                    } else {
                        current.setNext(null);
                    }
                    System.out.println("Contact deleted");
                    return;
                }
            }
            current = current.getNext();
        }

        System.out.println("Contact not found");
    }// end remove

    public void RemoveEvent(String ContactEvent) {
        if (head == null) {
            return;
        }

        if (head.data instanceof Event && ((Event) head.data).getContactName().equalsIgnoreCase(ContactEvent)) {
            head = head.getNext();
            return;
        }

        current = head;
        while (current != null && current.getNext() != null) {
            if (current.getNext().data instanceof Event) {
                if (((Event) current.getNext().data).getContactName().equalsIgnoreCase(ContactEvent)) {
                    if (current.getNext().getNext() != null) {
                        current.setNext(current.getNext().getNext());
                    } else {
                        current.setNext(null);
                    }
                    return;
                }
            }
            current = current.getNext();
        }
    }

    public T SearchContact(Node<T> head, String name, int num) { // start SearchContact
        if (head == null) {
            return null;
        }
        current = head;
        switch (num) { // start switch
            case 1:
                while (current != null) {// start while
                    if (current.data instanceof Contact
                            && ((Contact) current.data).getContactName().equalsIgnoreCase(name)) {// start
                        // if
                        return current.data;
                    } // end if
                    current = current.getNext();
                } // end while
                break;
            case 2:
                while (current != null) {// start while
                    if (current.data instanceof Contact && ((Contact) current.data).getPhoneNumber().equals(name)) {// start
                                                                                                                    // if
                        return current.data;
                    } // end if
                    current = current.getNext();
                } // end while
                break;
            case 3:
                while (current != null) {// start while
                    if (current.data instanceof Contact && ((Contact) current.data).getEmail().equals(name)) {// start
                                                                                                              // if

                        return current.data;
                    } // end if
                    current = current.getNext();
                } // end while
                break;
            case 4:
                while (current != null) {// start while
                    if (current.data instanceof Contact && ((Contact) current.data).getAddress().equals(name)) {// start
                                                                                                                // if

                        return current.data;
                    } // end if
                    current = current.getNext();
                } // end while
                break;
            case 5:
                while (current != null) {// start while
                    if (current.data instanceof Contact && ((Contact) current.data).getBirthday().equals(name)) {// start
                                                                                                                 // if

                        return current.data;
                    } // end if
                    current = current.getNext();
                } // end while
                break;
        } // end switch
        return null;
    }// end Search

    public T SearchEvent(Node<T> head, String name, int num) { // start PrintEvent

        if (head == null) { // start if
            System.out.println("Event not found!");
            return null;
        } // end if
        current = head;
        switch (num) { // start switch
            case 1:
                while (current != null) {// start while
                    if (current.data instanceof Event && ((Event) current.data).getContactName().equals(name)) {// start
                                                                                                                // if
                        System.out.println("Event found!");
                        return current.data;
                    } // end if
                    current = current.getNext();
                } // end while
                break;
            case 2:
                while (current != null) {// start while
                    if (current.data instanceof Event && ((Event) current.data).getEventTitle().equals(name)) {// start
                                                                                                               // if

                        System.out.println("Event found!");
                        return current.data;
                    } // end if
                    current = current.getNext();
                } // end while
                break;
        } // end switch

        return null;

    } 

} // end LinkedList
