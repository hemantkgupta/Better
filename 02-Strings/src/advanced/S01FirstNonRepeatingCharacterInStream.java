package advanced;

/**
 * Created by root on 09/12/15.
 */
public class S01FirstNonRepeatingCharacterInStream {



        static int Size = 256;

        public static void main(String[] args) {
            char[] arr="geeksforgeeksandgeeksquizfor".toCharArray();
            S01FirstNonRepeatingCharacterInStream test = new S01FirstNonRepeatingCharacterInStream();
            boolean[] visited = new boolean[Size];
            SingleNode root = null;

            for (int i = 0; i < arr.length; i++) {
                root = test.findNonRepeating(root, arr[i], visited);
            }
            //System.out.println(root);
        }

        private SingleNode findNonRepeating(SingleNode root, char data,
                                            boolean[] visited) {
            // The visited char means root data is the answer
            if (visited[data]) {
                System.out.println(root.data);
                return root;
            }

            // First Node
            if (root == null) {
                root = new SingleNode(data);
                System.out.println(data);
                return root;
            }

            SingleNode node = root;

            // Check if char is in list
            while (node.next != null) {

                // Current node has char
                // delete the current node
                if (node.data == data) {
                    node= node.next;
                    visited[data] = true;
                    root=node;
                    break;
                }

                // Next node has data and next to next node exists
                if (node.next.next != null && node.next.data == data) {
                    node.next = node.next.next;
                    visited[data] = true;
                    break;
                }

                // Next node has data but next to next node does not exists
                if (node.next.next == null && node.next.data == data) {
                    node.next = null;
                    visited[data] = true;
                    break;
                }
                node = node.next;
            }

            // Add new node for non-visited char
            if (node != null && !visited[data]) {
                node.next = new SingleNode(data);
            }

            System.out.print(root.data+" ");
            return root;
        }

        class SingleNode {
            char data;
            SingleNode next;

            public SingleNode(char data) {
                this.data = data;
                next = null;
            }

            @Override
            public String toString() {
                return "SingleNode [data=" + data + "]";
            }

        }
    }

