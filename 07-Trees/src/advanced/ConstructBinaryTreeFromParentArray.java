package advanced;

/**
 * Created by hemant on 17/10/15.
 */
public class ConstructBinaryTreeFromParentArray {

    public static void main(String[] args) {
        int[] parentArray = new int[] {1, 5, 5, 2, 2, -1, 3};
        constructTree(parentArray);

    }

    public static void constructTree(int[] parentArray){

        BPNode[] nodeArray =  new BPNode[parentArray.length];

        for (int i = 0; i < parentArray.length; i++) {

            BPNode currentNode = new  BPNode(i);
            if (parentArray[i] == -1 ){
                currentNode.parent = null;
                nodeArray[i] = currentNode;
            } else {
                if (nodeArray[parentArray[i]] == null){
                    BPNode parentNode = new  BPNode(parentArray[i]);
                    currentNode.parent = parentNode;
                    nodeArray[i] = currentNode;
                    nodeArray[parentArray[i]] = parentNode;
                }else {
                    nodeArray[i] = currentNode;
                    currentNode.parent = nodeArray[parentArray[i]];
                }
            }
        }

        for (int i = 0; i <nodeArray.length ; i++) {
            System.out.print("\nThe node at array index "+i+" is "+ nodeArray[i].data);
            String parentData = (nodeArray[i].parent != null) ? ""+nodeArray[i].parent.data : "NA";
            System.out.print( " and parent data is " + parentData );
        }

    }
}
