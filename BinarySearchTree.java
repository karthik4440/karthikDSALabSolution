import java.util.ArrayList;
class Node {

 int data;
 Node left, right;

 Node(int d)
 {
     data = d;
     left = right = null;
 }
}

class BinarySearchTree {

 Node root;

 BinarySearchTree()
 {
     root = null;
 }

 void inorder()
 {
     inorderUtil(this.root);
 }

 void inorderUtil(Node node)
 {
     if (node == null)
         return;

     inorderUtil(node.left);
     System.out.print(node.data + " ");
     inorderUtil(node.right);
 }

 void insert(int key)
 {
     root = insertRec(root, key);
 }

 Node insertRec(Node root, int data)
 {

     if (root == null) {
         root = new Node(data);
         return root;
     }

     if (data < root.data)
         root.left = insertRec(root.left, data);
     else if (data > root.data)
         root.right = insertRec(root.right, data);

     return root;
 }

 ArrayList<Integer> treeToList(Node node, ArrayList<Integer>
                                              list)
 {
     if (node == null)
         return list;

     treeToList(node.left, list);
     list.add(node.data);
     treeToList(node.right, list);

     return list;
 }

 boolean isPairPresent(Node node, int target)
 {
     ArrayList<Integer> a1 = new ArrayList<>();

     ArrayList<Integer> a2 = treeToList(node, a1);

     int start = 0; 

     int end = a2.size() - 1; 

     while (start < end) {

         if (a2.get(start) + a2.get(end) == target) 
         {
        	 System.out.println("Sum = " + target);
        	 System.out.println("Pair is (" + a2.get(start)+","+a2.get(end)+")");
             
             return true;
         }

         if (a2.get(start) + a2.get(end) > target) 
         {
             end--;
         }

         if (a2.get(start) + a2.get(end) < target) 
         {
             start++;
         }
     }

     System.out.println("Nodes are not found.");
     return false;
 }


 public static void main(String[] args)
 {
     BinarySearchTree tree = new BinarySearchTree();
     /*
                40
             /     \
           20      60
          / \     /  \
         10  30   50  70    */
     tree.insert(40);
     tree.insert(20);
     tree.insert(60);
     tree.insert(10);
     tree.insert(30);
     tree.insert(50);
     tree.insert(70);

     tree.isPairPresent(tree.root, 33);
 }
}