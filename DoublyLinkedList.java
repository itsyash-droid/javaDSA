public class DoublyLinkedList{
    private static ListNode head;
    private static ListNode tail;

    public static class ListNode{
        int data;
        ListNode previous;
        ListNode next;

        public ListNode(int data){
            this.data = data;
        }
    }

    public void displayTail(){
        ListNode temp = tail;
        while(temp != null){
            System.out.print(temp.data+"<-->");
            temp = temp.previous;
        }
        System.out.println("null");
    } 

    public void displayHead(){
        ListNode temp = head;
        while (temp != null){
            System.out.print(temp.data+"<-->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public boolean isEmpty(){
        return head == null;
    }
    
    public void insertFirst(int value){
        ListNode temp = new ListNode(value);
        if(isEmpty()){
            tail = temp;
        }
        else{
            head.previous = temp;
        }
        temp.next = head;
        head = temp;
    }

    public void insertLast(int value){
        ListNode temp = new ListNode(value);
        if(isEmpty()){
            head = temp;
        }
        else{
            tail.next = temp;
            temp.previous = tail;
        }
        tail = temp;
    }

public static void main(String[] args){
    DoublyLinkedList dll = new DoublyLinkedList();
    DoublyLinkedList.head = new ListNode(10);
    ListNode second  = new ListNode(9);
    ListNode third = new ListNode(8);
    ListNode fourth = new ListNode(7);
    DoublyLinkedList.tail = new ListNode(5);
    DoublyLinkedList.head.next = second;
    DoublyLinkedList.head.previous = null;
    second.previous = head;
    second.next = third;
    third.previous = second;
    third.next = fourth;
    fourth.previous = third;
    fourth.next = tail;
    DoublyLinkedList.tail.previous = fourth;
    DoublyLinkedList.tail.next = null;

    dll.displayHead();
    dll.displayTail();

}

}