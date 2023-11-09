package List;

public class LinkedList {

    protected Node head;
    protected Node tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public Node getHead(){
        return head;
    }

    public void insertFirst(Node newNode) {
        if (isEmpty()) {
            tail = newNode;
        }
        newNode.setNext(head);
        head = newNode;
    }

    public void deleteFirst(){
        head = head.getNext();
        if (isEmpty()){
            tail = null;
        }
    }
    
    public String toString(){
        StringBuilder result = new StringBuilder();
        Node tmp = head;
        while (tmp != null) {
            result.append(tmp).append(" ");
            tmp = tmp.getNext();
        }
        return result.toString();
    }

    //1.Write a function that finds the smallest number in the linked list. 
    public int smallest(){
        Node tmp = head;
        int smallest = tmp.getData();
        while (tmp != null) {
            if (tmp.getData() < smallest){
                smallest = tmp.getData();
            }
            tmp = tmp.getNext();
        }
        return smallest;
    }

    //2.Write a function to delete the second node from a singly linked list.
    public void deleteSecond(){
        try {
            Node secondNode = head.getNext(); 
            head.setNext(secondNode.getNext());
        } catch (NullPointerException e) {
            System.out.println("There is no second node");
        }
        
    }

    /**3.Write a function that will delete the odd indexed elements from a singly linked list. 
    The function will also return the deleted nodes as a new linked list. */

    public LinkedList oddIndexedElements(){
        LinkedList deletedNodes = new LinkedList();
        Node prev = null;
        Node curr = head;
        int index = 0;
        while (curr != null) {
            if (index % 2 != 0){
                deletedNodes.insertFirst(new Node(curr.getData()));
                prev.setNext(curr.getNext());
            } else {
                prev = curr;
            }
            curr = curr.getNext();
            index++;
        }
        return deletedNodes;
    }

    /**  4.Write a function that will delete even indexed elements from a 
    singly linked list.*/ 
    public void deleteEvenIndexed(){ 
        Node prev = new Node(0);
        Node curr = head; 
        int index = 0; 
        deleteFirst();
        while(curr != null){
            if(index % 2 == 0){
                prev.setNext(curr.getNext());
            } else {
                prev = curr;
            }
            curr = curr.getNext();
            index++;
        }
    }

    /**5.  Write a function that will add a new node before the last node of a
singly linked list.*/

    public void insertBeforeLast (Node newNode){
        if(head == null){
            head = newNode; 
            return; 
        }
        Node curr = head; 
        Node prev = null; 
        while(curr.getNext() != null){
            prev = curr; 
            curr = curr.getNext(); 
        }
        prev.setNext(newNode);
        newNode.setNext(curr);
    }

    /** 6. Given a sorted linked list, write a function to add a 
    new integer without destroying the sortedness property. */

    public void AddToSortedList(int x){
        Node addNode = new Node(x);
        if(head == null){
            head = addNode; 
            return;
        }
        Node prev = head; 
        Node curr = head; 
        while(curr.getNext() != null){
            if(prev.getData() < x && x < curr.getData()){
                prev.setNext(addNode);  
                addNode.setNext(curr); 
                break; 
            } else {
                prev = curr; 
                curr = curr.getNext(); 
            }
        }
    }

    /** 7.Write a function to delete k’th node from a singly linked list.*/

    public void deleteKth(int k){ 
        if(head == null){
            System.out.println("Linkedlist is empty");
            return; 
        }
        if(k == 1){
            deleteFirst();
            return; 
        }
        Node prev = head;
        Node curr = head.getNext();
        int index = 2; 
        while(curr.getNext() != null){
            if(index == k){
                prev.setNext(curr.getNext());
                curr = curr.getNext(); 
            } else {
                prev = curr; 
                curr = curr.getNext();
            }
            index++; 
        }
    }

    /** 9.Given node X, write a function to move that node n position forward.
    Assume that there are at least n nodes after node X */
    public void move(Node X, int n){
        if(head == null){
            System.out.println("No node inside");
            return; 
        } 
        Node prev = null; 
        Node curr = head;
        if(X == head){
            deleteFirst();
            while(curr.getNext() != null){
                for(int i = 0; i < n && curr != null; i++){
                    prev = curr; 
                    curr = curr.getNext(); 
                    if(curr.getNext() == null){
                        prev.setNext(X);
                        X.setNext(curr);
                    }
                    return; 
                }
                prev.setNext(X);
                X.setNext(curr);
            }
            return; 
        }

        while(curr.getNext() != null && curr != X){
            prev = curr; 
            curr = curr.getNext(); 
           
        } if(curr.getNext() == null){
            curr.setNext(X);
        } if (curr == X){
            prev.setNext(curr.getNext());
            curr = prev.getNext(); 
            for(int i = 0; i < n && curr != null; i++){
                prev = curr; 
                curr = curr.getNext(); 
            }
            prev.setNext(X);
            X.setNext(curr);
            return; 
        }


    }

   /**  13.Given an integer N, write a function which returns the prime factors
of N as singly linked list. */
    LinkedList primeFactors(int N){
        LinkedList primeLinkedList = new LinkedList(); 
        for(int i = 2; i <= N; i++){
            if(N % i == 0){
                boolean isPrime = true; 
                for(int j = 2; j <= Math.sqrt(i); j++){
                    if(i % j == 0){
                        isPrime = false; 
                        break;  
                    }
                }
                if(isPrime){
                    primeLinkedList.insertFirst(new Node(i));
                    N /= i;
                    i--;
                }
            }
        }
        return primeLinkedList; 
    }

    /** 14.Write a function that will delete all nodes whose contents are divisible
by N. The function will also return the deleted nodes as a new linked
list. */
    LinkedList removeDivisibleByN(int N){
        LinkedList deletedLinkedList = new LinkedList(); 
        Node prev = null; 
        Node curr = head; 
        if(head == null){
            System.out.println("Linkedlist is empty");
            return deletedLinkedList; 
        } 
        while(curr != null){
            if(curr.getData() % N == 0){
                deletedLinkedList.insertFirst(new Node(curr.getData()));
                if(prev == null){
                    deleteFirst();
                    curr = head; 
                } else {
                    prev.setNext(curr.getNext());
                    curr = curr.getNext();
                }
            } else {
                prev = curr; 
                curr = curr.getNext();
            }
    }
    return deletedLinkedList; 
    }

    /** 15. Write a function that will return the reverse of a singly link list.*/
    LinkedList reverse() {
        LinkedList reversedLinkedList = new LinkedList(); 
        Node prev = null; 
        Node curr = head; 
        if(head == null){
            System.out.println("No nodes inside");
            return reversedLinkedList; 
        }
        while(curr != null){
            reversedLinkedList.insertFirst(new Node(curr.data));
            prev = curr;
            curr = curr.getNext(); 
        }
        return reversedLinkedList; 
    }
    
   
    
}