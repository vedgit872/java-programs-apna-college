package imp.binaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class buildTreePreorder {
    static class node {
        int data;
        node left;
        node right;

        node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class Binarytree {
        int ind = -1;

        public node buildtree(int[] nodes) {
            ind++;
            if (nodes[ind] == -1) {
                return null;
            }
            node newnode = new node(nodes[ind]);
            newnode.left = buildtree(nodes);
            newnode.right = buildtree(nodes);

            return newnode;
        }

        public static void preorder(node root) {
            if (root == null) {
                System.out.print(-1 + " ");
                return;
            }
            System.out.print(root.data + "  ");
            preorder(root.left);
            preorder(root.right);
        }

        public static void inorder(node root) {
            if (root == null) {
                return;
            }
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }

        public static void postorder(node root) {
            if (root == null) {
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }

        public static void levelorder(node root) {
            if (root == null) {
                return;
            }
            Queue<node> q = new LinkedList();
            q.add(root);
            q.add(null);
            node current;
            while (!q.isEmpty()) {
                current = q.remove();
                if (current == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        return;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(current.data + "  ");
                    if (current.left != null) {
                        q.add(current.left);
                    }
                    if (current.right != null) {
                        q.add(current.right);
                    }
                }
            }
            return;
        }

        public static int height(node root) {
            if (root == null) {
                return 0;
            }
            int lh = height(root.left);
            int rh = height(root.right);
            return Math.max(lh, rh) + 1;
        }

        public static int countNodes(node root) {
            if (root == null) {
                return 0;
            }
            int lh = countNodes(root.left);
            int rh = countNodes(root.right);
            return lh + rh + 1;
        }

        public static int sumNodes(node root) {
            if (root == null) {
                return 0;
            }
            int lh = sumNodes(root.left);
            int rh = sumNodes(root.right);
            return lh + rh + root.data;
        }

        public static int diameterApproach1(node root) {
            if (root == null) {
                return 0;
            }
            int lh = Binarytree.height(root.left);
            int rh = Binarytree.height(root.right);
            return Math.max(diameterApproach1(root.left), Math.max(diameterApproach1(root.right), lh + rh + 1));
        }

        public static class info {
            int diameter;
            int height;

            public info(int diameter, int height) {
                this.diameter = diameter;
                this.height = height;
            }
        }

        public static info diameterApproach2(node root) {
            if (root == null) {
                return new info(0, 0);
            }
            info li = diameterApproach2(root.left);
            info ri = diameterApproach2(root.right);
            return new info(Math.max(li.diameter, Math.max(ri.diameter, li.height + ri.height + 1)),
                    Math.max(li.height, ri.height) + 1);
        }

        public static boolean isSubtree(node root, node subroot) {
            if (root == null) {
                return false;
            }
            if (root.data == subroot.data) {
                if (isIdentical(root, subroot)) {
                    return true;
                }
            }
            return isSubtree(root.left, subroot) || isSubtree(root.right, subroot);
        }

        public static boolean isIdentical(node root, node subroot) {
            if (root == null && subroot == null) {
                return true;
            } else if (root == null || subroot == null || root.data != subroot.data) {
                return false;
            }
            // Check both left and right subtrees
            return isIdentical(root.left, subroot.left) && isIdentical(root.right, subroot.right);
        }

        public static class info1 {
            node root;
            int hd;

            public info1(node root, int hd) {
                this.root = root;
                this.hd = hd;
            }
        }

        public static void topView(node root) {
            if (root == null) {
                return;
            }

            Queue<info1> q = new LinkedList<>();
            HashMap<Integer, node> map = new HashMap<>();
            int min = 0, max = 0;

            q.add(new info1(root, 0)); // Add root with horizontal distance 0

            while (!q.isEmpty()) {
                info1 curr = q.remove();

                // If this horizontal distance is being visited for the first time
                if (!map.containsKey(curr.hd)) {
                    map.put(curr.hd, curr.root);
                }

                // Add left child to queue
                if (curr.root.left != null) {
                    q.add(new info1(curr.root.left, curr.hd - 1));
                    min = Math.min(min, curr.hd - 1);
                }

                // Add right child to queue
                if (curr.root.right != null) {
                    q.add(new info1(curr.root.right, curr.hd + 1));
                    max = Math.max(max, curr.hd + 1);
                }
            }

            // Print the top view from min to max horizontal distance
            for (int i = min; i <= max; i++) {
                if (map.get(i) != null) {
                    System.out.print(map.get(i).data + " ");
                }
            }
        }
         public static void kthlevelIterative(int k,node root){
            Queue<node> q=new LinkedList<>();
            q.add(root);
            q.add(null);
            int n=1;
            while (!q.isEmpty()) {
                node curr=q.remove();
                if (curr==null) {
                    if (q.isEmpty()) {
                        break;
                    }
                    else{
                        q.add(curr);
                        n++;
                        continue;
                    }
                }
                if (n==k && curr!=null) {
                    System.out.print(curr.data+" ");
                }
                if (curr.left!=null) {
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }

         }
         public static void kthlevelRecursive(node root,int k,int n){
            if (n==k) {
                System.out.print(root.data+" ");
                return;
            }
            if (root.left!=null) {
                kthlevelRecursive(root.left, k, n+1);
            }
            if (root.right!=null) {
                kthlevelRecursive(root.right, k, n+1);
            }
            
         }
         public static boolean getPath(node root,int n, ArrayList<Integer> a){
            if (root==null) {
                return false;
            }
            a.add(root.data);
            if(root.data==n){
                return true;
            }
            boolean left=getPath(root.left, n, a);
            boolean right=getPath(root.right, n, a);
            if(left||right){
                return true;
            }
            a.remove(a.size()-1);
            return false;

            
         }
        //  lowest common ancestor
         public static int lsa(node root,int a,int b){
            ArrayList<Integer> apath=new ArrayList<>();
            ArrayList<Integer> bpath=new ArrayList<>();

            getPath(root, a, apath);
            getPath(root, b, bpath);

            int i=0;
            for(i=0;i<apath.size() && i<bpath.size();i++){
               if(apath.get(i)!=bpath.get(i)){
                break;
               }
            }
            return apath.get(i-1);
         }
         public static node lca2(node root,int a,int b){
            if(root==null||root.data==a||root.data==b){
                return root;
            }
            node leftlca=lca2(root.left,a,b);
            node rightlca=lca2(root.right,a,b);
            if(leftlca==null){
                return rightlca;
            }
            if(rightlca==null){
                return leftlca;
            }
            return root;
         }
         public static int Dist(node root,int a){
            if(root==null){
                return -1;
            }
            if (root.data==a) {
                return 0;
            }
            int leftdist=Dist(root.left, a);
            int rightdist=Dist(root.right, a);
            if (leftdist==-1 &&rightdist==-1) {
                return-1;
            }else if(leftdist==-1){
                return rightdist+1;
            }else{
                return leftdist+1;
            }
         }
         public static int minDist(node root,int a,int b){
            node lca=lca2(root, a, b);
            int disa=Dist(lca,a);
            int disb=Dist(lca,b);
            return disa+disb;
         }
         public static int kthancestor(node root,int n,int k){
                   if (root==null) {
                       return -1;
                    }
                    if(root.data==n)
                    return 0;
                     
                    int left=kthancestor(root.left, n, k);
                    int right=kthancestor(root.right, n, k);

                    if(left==-1&&right==-1){
                        return -1;
                    }
                    int max=Math.max(left,right);
                    if(max+1==k){
                        System.out.println(root.data);
                    }
                    return max+1;

         }
         public static int sumTree(node root){
             if(root==null)
             return 0;
             int left=sumTree(root.left);
             int right=sumTree(root.right);
             int temp=root.data;
             root.data=left+right;
             return left+right+temp;
            }
               
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        int nodes1[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -8, -1, -1 };
        int nodes2[] = { 2, 4, -1, -1, 5, -1, -1 };

        Binarytree t = new Binarytree();
        Binarytree t1 = new Binarytree();
        Binarytree t2 = new Binarytree();

        node s = t.buildtree(nodes); // Main tree
        node s1 = t1.buildtree(nodes1); // Another tree for testing
        node s2 = t2.buildtree(nodes2); // Subtree to test

        Binarytree.preorder(s);
        System.out.println();
        Binarytree.inorder(s);
        System.out.println();
        Binarytree.postorder(s);
        System.out.println();
        Binarytree.levelorder(s);
        System.out.println();
        System.out.println(Binarytree.height(s));
        System.out.println(Binarytree.countNodes(s));
        System.out.println(Binarytree.sumNodes(s));
        System.out.println(Binarytree.diameterApproach1(s1));
        System.out.println(Binarytree.diameterApproach2(s1).diameter);
        // Check if s2 is a subtree of s
        System.out.println(Binarytree.isSubtree(s, s2)); // Expected: true or false
        Binarytree.topView(s);
        // Expected: true or false
        System.out.println();
        Binarytree.kthlevelIterative(3, s);
        System.out.println();
        Binarytree.kthlevelRecursive(s,3,1);
        System.out.println();
        System.out.println(Binarytree.lsa(s, 4, 5));
        System.out.println();
        System.out.println(Binarytree.lca2(s, 5, 6).data);
        System.out.println();
        System.out.println(Binarytree.minDist(s, 4, 6));
        // System.out.println(Binarytree.kthancestor(s, 6, 2));
        int n = 4, k = 1;
        int result = Binarytree.kthancestor(s, n, k);
        System.out.println();
        System.out.println(Binarytree.sumTree(s));
        System.out.println();
        Binarytree.preorder(s);
        
        
    }
}
