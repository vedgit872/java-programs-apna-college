package imp;

public class linkedlist {
    public linkedlist() {
        head = null;
        tail = null;
        size = 0;
    }

    public static class node {
        int data;
        node next;

        public node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static node head;
    public static node tail;
    public static int size;

    // methods of linked list
    public void addFirst(int data) {
        node newnode = new node(data);
        size++;
        if (head == null) {
            head = tail = newnode;
            return;
        }
        newnode.next = head;
        head = newnode;

    }

    public void addlast(int data) {
        node newnode = new node(data);
        size++;
        if (head == null) {
            head = tail = newnode;
            return;
        }
        tail.next = newnode;
        tail = newnode;
    }

    // public void add(int data, int pos) {
    // node newnode = new node(data);
    // if (head == null) {
    // head = tail = newnode;
    // return;
    // } else {
    // int ctr = count();
    // if (pos == 1) {
    // if (head == null) {
    // head = tail = newnode;
    // return;
    // }
    // newnode.next = head;
    // head = newnode;
    // } else if (pos == ctr) {
    // if (head == null) {
    // head = tail = newnode;
    // return;
    // }
    // tail.next = newnode;
    // tail = newnode;
    // } else {
    // node temp, prev;
    // temp = prev = head;
    // int k = 1;
    // while (k < pos) {
    // prev = temp;
    // temp = temp.next;
    // k++;
    // }
    // prev.next = newnode;
    // newnode.next = temp;
    // }
    // }
    // }

    public void add(int data, int pos) {
        node newnode = new node(data);
        int ctr = size;
        // int ctr=count();
        if (head == null || pos == 0) {
            addFirst(data);
        } else if (pos == ctr) {
            addlast(data);
        } else if (0 < pos && pos < ctr) {
            node temp;
            size++;
            temp = head;
            int k = 0;
            while (k < pos - 1) {
                temp = temp.next;
                k++;
            }
            newnode.next = temp.next;
            temp.next = newnode;
        } else {
            System.out.println("invalid position");
        }
    }

    public int removefirst() {
        int val;
        if (head == null) {
            System.out.println("null list");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            size--;
            val = head.data;
            head = tail = null;
            return val;
        } else {
            size--;
            val = head.data;
            head = head.next;
            return val;
        }
    }

    public int removelast() {
        int val;
        if (head == null) {
            System.out.println("null list");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            val = head.data;
            head = tail = null;
            size = 0;
            return val;
        } else {
            int k = 0;
            node temp = head;
            while (k < size - 2) {
                temp = temp.next;
                k++;
            }
            val = tail.data;
            temp.next = null;
            tail = temp;
            size--;
            return val;
        }
    }

    public void removemidlast(int n) {
        if (head == null) {
            return;
        }
        if (size == n) {
            head = head.next;
            return;
        } else if (size > n) {
            node prev;
            node temp = prev = head;
            int r = 0;
            while (r < size - n) {
                prev = temp;
                temp = temp.next;
                r++;
            }
            // temp is also current node can use prev.next.next; also
            prev.next = temp.next;
        } else {
            return;
        }
    }

    public int searchite(int key) {// O(n ) ->time complexity
        int i = 0;
        if (size == 0) {
            return -1;
        }
        node temp = head;
        while (temp.next != null) {
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    public int helper(node head, int key) {// O(n)->time and space complexity
        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return 0;
        }
        int i = helper(head.next, key);
        if (i == -1) {
            return -1;
        } else
            return i + 1;
    }

    public int searchrec(int key) {
        return helper(head, key);
    }

    public void reverse() {
        if (head == null) {
            return;
        }
        node prev, curr, future;
        prev = null;
        curr = tail = head;
        while (curr != null) {
            future = curr.next;
            curr.next = prev;
            prev = curr;
            curr = future;
        }
        head = prev;
    }

    public boolean palindrome() {
        if (head == null && head.next == null) {
            return true;
        }
        // step 1: find mid
        node mid = mid(head);

        // step 2:reverse the 2nd half
        node prev = null;
        node curr = mid, future;
        while (curr != null) {
            future = curr.next;
            curr.next = prev;
            prev = curr;
            curr = future;
        }

        // step 3:check the 2 halfs are eqaul or not
        node temp = head;
        while (temp != null && prev != null) {
            if (temp.data != prev.data) {
                return false;
            }
            temp = temp.next;
            prev = prev.next;
        }
        return true;
    }

    public void print() {
        if (head.next == null) {
            System.out.println("null list");
            return;
        }
        node temp;
        temp = head;
        System.out.print("[ ");
        while (temp != null) {
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.println("X ]");
    }

    public int count() {
        node temp;
        int ctr = 0;
        if (head == null) {
            ctr = 0;
        } else {
            temp = head;
            ctr = 1;
            while (temp.next != null) {
                temp = temp.next;
                ctr++;
            }
        }
        return ctr;
    }

    public node mid(node head) {
        node fast = head;
        node slow = head;

        while (fast != null &&fast.next != null ) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        linkedlist l1 = new linkedlist();
        l1.addlast(1);
        l1.addlast(2);
        l1.addlast(3);
        l1.addFirst(0);
        l1.addFirst(-1);
        l1.add(6, 3);
        l1.add(-9, 6);
        l1.add(8, 7);
        l1.removefirst();
        l1.removelast();
        l1.print();
        System.out.println(l1.searchite(-1));
        System.out.println();
        System.out.println(l1.searchrec(-1));
        System.out.println();
        System.out.println(l1.count());
        System.out.println(size);//size assesed in a static way
        l1.reverse();
        System.out.println();
        l1.print();
        l1.reverse();
        System.out.println();
        l1.print();
        l1.removemidlast(6);
        System.out.println();
        l1.print();
        System.out.println();
        l1.addlast(3);
        l1.print();
        System.out.println(l1.mid(head).data);
        // l1.addlast(2);
        // l1.addlast(1);
        // l1.addlast(2);
        // l1.addlast(3);
        // l1.addFirst(1);
        System.out.println(l1.palindrome());
    }
}
