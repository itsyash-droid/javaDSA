public class BinarySearchTree{
    private TreeNode root;      //instance variable

    private class TreeNode{     //inner class
        private int data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int data){
            this.data = data;
        }
    }

    public void insert(int value){
        root = insert(root,value);
    }

    public void inOrder(){
        inOrder(root);
    }
    public void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public TreeNode insert(TreeNode root,int value){
        if(root == null){
            root = new TreeNode(value);
            return root;
        }
        if(value<root.data){
            root.left = insert(root.left,value);
        }
        else{
            root.right = insert(root.right,value);
        }
        return root;
    }

    public TreeNode Search(int key){
       return search(root,key);
    }
    public TreeNode search(TreeNode root, int key){
        if(root == null || root.data ==key){
            return root;
        }
        if(key<root.data){
            return search(root.left,key);
        }
        else{
            return search(root.right,key);
        }
    }

    public static void main(String[] args){
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(1);


    }
}