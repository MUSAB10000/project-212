public class LinkedList<T> {
    private Node<T> head;
    private Node<T> current;
public void AddC(T val) {//add is not final version just a base to start with this is for contact only didnt run so check while runing 
        //add direct if empty
        if(head==null && val instanceof Contact){
            head=new Node<Contact>((Contact)val);
            return;
        }
        //add in place of head
        if(val instanceof Contact && head instanceof Contact &&((Contact)val).data.getContactName().compareTo(((Contact)head).data.getContactName())<= 0){//not sure about = 
            Node<Contact> temp=null;
            temp=head;
            head=new Node<Contact>((Contact)val);
            head.next=head;
            return;
        }
        //we look where to add
        while(current.next!=null&& val instanceof Contact && current instanceof Contact &&((Contact)val).data.getContactName().compareTo((Contact)current).data.getContactName())> 0){
            current=current.next;
        }
              //if we get out of the while then it's one of the two either it stopped in middle found something smaller or it run through the whole list then add at last
               Node<Contact> temp=null;
                temp=current;
                current=new Node<Contact>((Contact)val);
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
}
