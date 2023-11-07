package List;

public class Test {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(); 
        Node node1 = new Node(1); //0
        Node node2 = new Node(2); //1
        Node node3 = new Node(3); //2 
        Node node5 = new Node(5); //3 
        Node node6 = new Node(6); //4
        Node node7 = new Node(7); //5
        Node insert = new Node(4); 
        linkedList.insertFirst(node7); 
        linkedList.insertFirst(node6);
        linkedList.insertFirst(node5);
        linkedList.insertFirst(node3);
        linkedList.insertFirst(node2);
        linkedList.insertFirst(node1);
        linkedList.move(node5, 1);
        System.out.println(linkedList);
    }
}
