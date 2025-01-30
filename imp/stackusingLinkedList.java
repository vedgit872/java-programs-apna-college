package imp;

public class stackusingLinkedList {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    static class Stack{
       static Node head=null;//only to be created once  
       
       public boolean isEmpty(){
          return head==null;
       }
       public int pop(){
        if (isEmpty()) {
            return -1;            
        }
        int val=head.data;
        head=head.next;
        return val;
       }
       
       public int peek(){
        if (isEmpty()) {
            return -1;            
        }
        return head.data;
       }
        public void push(int data){
            Node newNode=new Node(data);
            if (isEmpty()) {
                head=newNode;
                return; //imp as can cause a recursive  case
            }
            newNode.next=head;
            head=newNode;
        }
    }
    public static void main(String[] args) {
        Stack s=new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }

    }
}
