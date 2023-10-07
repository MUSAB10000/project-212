import java.util.Scanner;
public class LinkedList<T> { //start LinkedList
    private Node<T> head;
    private Node<T> current;
    public Scanner input = new Scanner(System.in);

    public void AddC(T val) {//add is not final version just a base to start with this is for contact only didnt run so check while runing 
        //add direct if empty
        if(head==null && val instanceof Contact){
            head=new Node<T>(val);
            return;
        }
        //add in place of head
        if(val instanceof Contact && head.data instanceof Contact &&((Contact)val).getContactName().compareTo(((Contact)head.data).getContactName())<= 0){//not sure about = 
            Node<T> temp=null;
            temp=head;
            head=new Node<T>(val);
            head.next=head;
            return;
        }
        //we look where to add
        while(current.next!=null&& val instanceof Contact && current.data instanceof Contact &&((Contact)val).compareTo((Contact)current.data)> 0){
            current=current.next;
        }
              //if we get out of the while then it's one of the two either it stopped in middle found something smaller or it run through the whole list then add at last
               Node<T> temp=null;
                temp=current;
                current=new Node<T>(val);
                current.next=temp;
    

       
    }
    
    public void Remove(String phone_number) {
        if (head == null) {
            return;// list is empty
        } else if (head.data instanceof Contact) {
            if (((Contact) head.data).getPhoneNumber().equalsIgnoreCase(phone_number)) {
                removeEvent(head);// caling method
                head = head.next;
                return;// this will delete contact if the contact in the first one
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
    }

    private void removeEvent(Node<T> ContactEvent) { // we used to romve event from contact
        if (ContactEvent.data instanceof Contact) {
            String ContactEventname = ((Contact) ContactEvent.data).getContactName();
            Node<T> eventNode = head;
            if (eventNode == null) {
                return;// if event list is empty
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
    }
    
    public T Search(Node<T> head, int num){ //start Search
        if (head == null)
            return null;
        current = head;
        switch(num){ //start switch
            case 1: System.out.print("Enter the contact's name:");
                    String name = input.next();
                    while(current != null){//start while
                        if(current.data instanceof Contact && ((Contact)current.data).getContactName().equals(name)) {//start if
                            System.out.println("Contact found!");
                            return current.data;
                        }//end if
                        current = current.next;
                    }//end while
                    break;
            case 2: System.out.print("Enter the contact's phone:");
                    String phone = input.next();
                    while(current != null){//start while
                        if(current.data instanceof Contact && ((Contact)current.data).getPhoneNumber().equals(phone)) {//start if
                            System.out.println("Contact found!");
                            return current.data;
                        }//end if
                        current = current.next;
                    }//end while
                    break;
            case 3: System.out.print("Enter the contact's email:");
                    String email = input.next();
                    while(current != null){//start while
                        if(current.data instanceof Contact && ((Contact)current.data).getEmail().equals(email)) {//start if
                            System.out.println("Contact found!");
                            return current.data;
                        }//end if
                        current = current.next;
                    }//end while
                    break;
            case 4: System.out.print("Enter the contact's address:");
                    String address = input.next();
                    while(current != null){//start while
                        if(current.data instanceof Contact && ((Contact)current.data).getAddress().equals(address)) {//start if
                            System.out.println("Contact found!");
                            return current.data;
                        }//end if
                        current = current.next;
                    }//end while
                    break;
            case 5: System.out.print("Enter the contact's birthday:");
                    String birthday = input.next();
                    while(current != null){//start while
                        if(current.data instanceof Contact && ((Contact)current.data).getBirthday().equals(birthday)) {//start if
                            System.out.println("Contact found!");
                            return current.data;
                        }//end if
                        current = current.next;
                    }//end while
                    break;
            default: System.out.println("Wrong number, please do it again");
        } //end switch
        System.out.println("Contact not found!");
        return null;
    }//end Search
}//end LinkedList
