public class SinglyLinkedList<E> {
    
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedList(){

    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E first(){
        if (isEmpty()){
            return null;
        } 
        return head.getElement();
    }

    public E last(){
        if (isEmpty()){
            return null;
        }
        return tail.getElement();
    }

    public void addFirst(E e){
        head = new Node<>(e, head);

        if (isEmpty()){
            tail = head;
        }
        size++;
    }

    public void addLast(E e){
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()){
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    public E removeFirst(){
        if (isEmpty()){
            return null;
        }

        E answer = head.getElement();
        head = head.getNext();
        size--;

        if (isEmpty()){
            tail = null;
        }
        return answer;
    }

    // Write your codes below
    public String toString() {
        String result = "";
        Node<E> current = head;

        while (current != null) {
            result += current.getElement();

            if (current.getNext() != null) {
                result += " ";
            }

            current = current.getNext();
        }

        return result;
    }

    public E removeLast(){
        if (isEmpty()) {
            return null;
        }

        E answer = tail.getElement();

        if (size == 1) {
            head = null;
            tail = null;
        } else {
            Node<E> current = head;

            while (current.getNext() != tail) {
                current = current.getNext();
            }

            tail = current;
            tail.setNext(null);
        }

        size--;
        return answer;
    }

    public void reverse(){       
        Node<E> previous = null;
        Node<E> current = head;

        tail = head;

        while (current != null) {
            Node<E> next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }

        head = previous;              
    }
}