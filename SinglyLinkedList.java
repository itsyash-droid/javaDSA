public class SinglyLinkedList{

    private static ListNode head;
    private static class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data = data;
            this.next = null;
        }

        // Override toString() method to print node's data
    @Override
    public String toString() {
        return "Node data: " + data;
    }
    }

    public void display(){
        ListNode current = head;
        while(current != null){
            System.out.print(current.data + "-->");
            current = current.next;
        }
        System.out.print("null");
    }

    public void displayNode(ListNode node) {
        if (node == null) {
            System.out.println("The node is null.");
        } else {
            System.out.println("Node data: " + node.data);
        }
    }
    

        public int listLength(){
            int count = 0;
            ListNode current = head;
            while(current != null){
                count++;
                current = current.next;
            }
            return count;
        }

        public void insertLast(int n){
            ListNode newNode = new ListNode(n);
            if(head == null){
                head = newNode;
                return;
            }
            else{
                ListNode current = head;
                while(null!=current.next){
                current = current.next;
                }
                current.next = newNode;
            }
        }

        public void insertFirst(int n){
            ListNode newNode = new ListNode(n);
            newNode.next = head;
            head = newNode;
        }

        public void insertAtX(int p,int q){
            ListNode node = new ListNode(p);
            if(q == 1){
                node.next = head;
                head = node;
            }
            else{
                ListNode previous = head;
                int count = 1;
                while(count < q-1){
                    previous = previous.next;
                    count++;
                }
                ListNode current = previous.next;
            node.next = current;
            previous.next = node;
            }
        }

        public ListNode deleteFirst(){
            if(head == null){
                return null;
            }
            ListNode temp = head;
            head = head.next;
            temp.next = null;
            return temp;
        }

        public ListNode deleteLast(){
            if(head == null || head.next == null){
                return head;
            }
            ListNode current = head;
            ListNode previous = null;
            while(current.next != null){
                previous = current;
                current = current.next;
            }
            previous.next = null;
            return current;
        }

        public void deleteAtX(int position){
            if(position == 1){
                head = head.next;
            }
            else{
                ListNode previous = head;
                int count = 1;
                while(count < position-1){
                    previous = previous.next;
                    count++;
                }
                ListNode current = previous.next;
                previous.next = current.next;
            }
        }

        public boolean search(int searchKey){
            ListNode current = head;
            while(current != null){         
                if(current.data == searchKey){
                    return true;
                }
            current  = current.next;
            }
            return false;
        }

        public ListNode reverse(){
            ListNode current = head;
            ListNode previous = null;
            ListNode next = null;
            while(current != null){
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }
            head = previous;
            return head;
        }

        public ListNode nthNodeFromEnd(int n){
            ListNode mainPtr = head;
            ListNode refPtr = head;
            int count = 0;
            while(count < n){
                refPtr = refPtr.next;
                count++;
            } 
            while(refPtr != null){
                refPtr = refPtr.next;
                mainPtr = mainPtr.next;
            }
            return mainPtr;
        } 

        public void removeDuplicates(){
            ListNode current = head;
            while(current != null && current.next != null){
                if(current.data == current.next.data){
                current.next = current.next.next;
            }
        
        else{
            current = current.next;
        }
    }
        }

        public ListNode insertNewNode(ListNode newNode){
            ListNode current = head;
            ListNode temp = null;
            while(current != null && current.data < newNode.data){
                temp = current;
                current = current.next;
            }
            newNode.next = current;
            temp.next = newNode;
            return head;
        }

        public void removeNode(int key){
            ListNode current = head;
            ListNode temp = null;
            while(current!=null && current.data!=key){
                temp = current;
                current = current.next;
            }
            if(current == null){
                return;
            }
            temp.next = current.next;
        }

        public boolean isLoop(){
            ListNode fastPtr = head;
            ListNode slowPtr = head;
            while(fastPtr!=null && fastPtr.next!=null){
                fastPtr = fastPtr.next.next;
                slowPtr = slowPtr.next;

                if(fastPtr == slowPtr){
                    return true;
                }
            }
            return false;
        }

        public ListNode getStartingNode(ListNode slowPtr){
            ListNode temp = head;
            while(slowPtr!=temp){
                temp = temp.next;
                slowPtr = slowPtr.next;
            }
            return temp;
        }

        public ListNode startingNodeOfLoop(){
            ListNode fastPtr = head;
            ListNode slowPtr = head;
            while(fastPtr!=null && slowPtr!=null){
                fastPtr = fastPtr.next.next;
                slowPtr = slowPtr.next;
                if(fastPtr == slowPtr){
                    return getStartingNode(fastPtr);
                }
            }
            return null;
        }

        public void removeLoop(){
            ListNode fastPtr  = head;
            ListNode slowPtr = head;
            while(fastPtr != null && fastPtr.next != null){
                fastPtr = fastPtr.next.next;
                slowPtr = slowPtr.next;
                if(fastPtr == slowPtr){
                    remove(slowPtr);
                    return;
                }
            }
        }

        public ListNode remove(ListNode slowPtr){
            ListNode temp = head;
            while(slowPtr != temp){
                temp = temp.next;
                slowPtr = slowPtr.next;
            }
            slowPtr.next = null;
            return head;
        }

        public static void main(String[] args){
        SinglyLinkedList sll = new SinglyLinkedList();
        SinglyLinkedList.head = new ListNode(10);
        ListNode second = new ListNode(5);
        ListNode third = new ListNode(8);
        ListNode fourth = new ListNode(11);
        ListNode fifth = new ListNode(12);
        ListNode sixth = new ListNode(15);
        ListNode seventh = new ListNode(1);

        SinglyLinkedList.head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = seventh;
        seventh.next = fourth;
        
        System.out.println(sll.isLoop());
        ListNode x = sll.startingNodeOfLoop();
        System.out.println(x);
        sll.removeLoop();
        sll.display();

        /*sll.display();
        System.out.println();
        sll.removeDuplicates();
        sll.display();
        sll.removeNode(8);
        sll.display();*/

        //ListNode n = sll.nthNodeFromEnd(2);
        //System.out.println(n);
        //sll.Reverse();
        //sll.display();

        /*SinglyLinkedList ll = new SinglyLinkedList();
        ll.insertAtX(1,1);
        ll.insertAtX(6,2);
        ll.insertAtX(10,2);
        ll.display();
        
        int length = ll.listLength();
        System.out.println();
        System.out.println(length);*/
        
        /*sll.display();
        sll.deleteFirst();
        sll.deleteFirst();
        sll.deleteFirst();
        sll.deleteFirst();
        sll.deleteFirst();
        System.out.println();
        sll.display();
        ListNode t = sll.deleteFirst();
        System.out.println(t);*/
        /*sll.deleteLast();
        sll.deleteLast();
        sll.deleteLast();
        sll.display();*/

        //sll.deleteAtX(3);
        //sll.display();
        //boolean t = sll.search(19);
        //System.out.println(t);
    }
}
