package exersize.module32and33;
public class closestElementBst {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }


    // we can use static variables key ,mindiff in this so space complexity is complexity is less
    public static class info{
        Node data;
        int mindiff;
        info(Node data , int mindiff){
            this.data=data;
            this.mindiff=mindiff;
        }
    }
    public static info closest(Node root, int cl){
        if (root == null) {
            return new info(null, Integer.MAX_VALUE);
        }
    
        int temp1 = Math.abs(cl - root.data);
        if (root.data == cl) {
            return new info(root, 0);
        } else if (root.data > cl) {
            info temp = closest(root.left, cl);
            if (temp1 < temp.mindiff) {  // Use temp.mindiff instead of temp.data.data
                return new info(root, temp1);
            } else {
                return temp;
            }
        } else {
            info temp = closest(root.right, cl);
            if (temp1 < temp.mindiff) {  // Use temp.mindiff instead of temp.data.data
                return new info(root, temp1);
            } else {
                return temp;
            }
        }
    }
    
    public static void main(String[] args) {
        Node root1 = new Node(10);
        root1.left = new Node(5);
        root1.right = new Node(15);
        root1.left.left = new Node(3);
        root1.left.right = new Node(6); 
        root1.right.left = new Node(12);

        System.out.println("Closest element is "+closest(root1, 15).mindiff+" "+closest(root1, 15).data.data);
    }
}
