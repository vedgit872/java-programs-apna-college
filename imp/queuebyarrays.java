package imp;


public class queuebyarrays {
    static class queue{
        static int arr[];
        static int size;
        static int last;
        queue(int n){
            arr=new int[n];
            size=n;
            last=-1;
        }
        public static boolean isEmpty(){
            return last==-1;
        } 

        public static void add(int data){
            if (last==size-1) {
                System.out.println("queue is full");
                return;
            }
            last=last+1;
            arr[last]=data;
        }
        public static int delete(){
            if (!isEmpty()) {
                int front=arr[0];
                for (int i = 0; i < arr.length-1; i++) {
                    arr[i]=arr[i+1];
                }
                last=last-1;
                return front;

            }
            System.out.println("queue is empty");
            return -1;
        }
        public static int peek(){
            if (isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }
            return arr[0];
        }
    }
    public static void main(String[] args) {
        queue q=new queue(5); 
        q.add(20);
        q.add(30);
        q.add(40);
        System.out.println(q.peek());
        q.delete();
        System.out.println(q.peek());
        q.delete();
        System.out.println(q.peek());
        q.delete();
        System.out.println(q.peek());
    }
}
