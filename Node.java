public class Node<w> {
    public w data;
    public Node<w> next;

    public Node(w data) {
        this.data = data;
        this.next = null;
    }
}
