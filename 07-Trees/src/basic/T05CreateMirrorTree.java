package basic;


/**
 * Created by hemant on 17/10/15.
 */
public class T05CreateMirrorTree {
    public static void main(String[] args) {
        
        BNode root = new BNode(4);
        root.left = new BNode(5);
        root.right = new BNode(6);
        System.out.println(root);
        System.out.println(mirror(root));


    }
    public static BNode mirror(BNode BNode){
        if (BNode==null)	    return null;
        else	  {
            BNode tmp= new BNode(BNode.data);
            tmp.right = mirror(BNode.left);
            tmp.left = mirror(BNode.right);
            return tmp;
        }
    }

}
