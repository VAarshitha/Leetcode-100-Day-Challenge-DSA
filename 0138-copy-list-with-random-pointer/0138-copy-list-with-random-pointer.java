public class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // Step 1: Interweave original and copied nodes
        Node current = head;
        while (current != null) {
            Node copy = new Node(current.val);
            copy.next = current.next;
            current.next = copy;
            current = copy.next;
        }

        // Step 2: Copy random pointers
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        // Step 3: Separate the original and copied lists
        Node dummy = new Node(0);
        Node copy = dummy, temp;
        current = head;
        while (current != null) {
            temp = current.next.next;
            copy.next = current.next;
            current.next = temp;
            copy = copy.next;
            current = temp;
        }

        return dummy.next;
    }
}
