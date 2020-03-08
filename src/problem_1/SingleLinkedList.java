package problem_1;

// got help from geeksforgeeks with my reverseiterative
// got help from Kevin with my copyConstructor
// got help from other students

public class SingleLinkedList {

    private ListNode head;
    private int size;

    public SingleLinkedList() {
        head = new ListNode();  // dummy node
    }

    public SingleLinkedList(SingleLinkedList list) {
        // homework
        head = new ListNode();
        ListNode ptr = head;
        ListNode other = list.head.next;
        while (other != null){
            ptr.next = new ListNode(other.val);
            ptr = ptr.next;
            other = other.next;
            size++;
        }
    }


    public int remove(int val) {
        // homework
        ListNode ptr = head;
        ListNode temp;
        int track = 0;
        while (ptr != null){
            temp = ptr.next;
            if (temp != null && temp.val == val){
                ptr.next = temp.next;
                temp.next = null;
                track++;
                size--;
            }
            else {
                ptr = ptr.next;
            }
        }
        return track;
    }

    public void reverseIterative() {
        // homework
        if (head.next == null || size < 1) {
            return;
        }
        ListNode prev = null;
        ListNode ptr = head.next;
        ListNode temp;
        while (ptr != null){
            temp = ptr.next;
            ptr.next = prev;
            prev = ptr;
            ptr = temp;
        }
        head.next = prev;
    }

    // got help from another student i couldnt figure out a way
    // to switch the numbers around
    public void mergeSorted(SingleLinkedList listToMerge) {
        // homework

        ListNode ptr = head;
        ListNode other = listToMerge.head.next;
        ListNode list;

        while(other!=null && ptr!=null) {
            if(ptr == head && ptr.next.val > other.val) {
                list = new ListNode(other.val);
                list.next = ptr.next;
                ptr.next = list;
                ptr = ptr.next;
                other = other.next;


            }
            if(ptr.next != null && ptr.val <= other.val && other.val <= ptr.next.val) {
                list = new ListNode(other.val);
                list.next = ptr.next;
                ptr.next = list;
                ptr = ptr.next;
                other = other.next;
            }
            else if(ptr.val < other.val && ptr.next == null) {
                list = new ListNode(other.val);
                ptr.next = list;
                ptr = ptr.next;
                other = other.next;
            }
            else {
                ptr = ptr.next;
            }
        }
    }

    int size() {
        return size;
    }

    public Item getFirst() {
        return get(0);
    }

    public Item getLast() {
        return get(size-1);
    }

    // Returns the element at the specified position in this list
    public Item get(int index) {
        if (index<0 || index>=size) {
            return new Item(-1, false);
        }
        ListNode ptr = head.next;
        for (int i=0; i<index; i++) {
            if (ptr==null) {
                return new Item(-1, false);
            }
            ptr = ptr.next;
        }
        return new Item(ptr.val, true);
    }

    // Appends the specified element to the end of this list
    public void add(int val) {
        size++;
        ListNode ptr = head;
        while (ptr.next!=null) {
            ptr = ptr.next;
        }
        ptr.next = new ListNode(val);
    }

    // Inserts the specified element at the beginning of this list
    public void addFirst(int val) {
        size++;
        ListNode newNode = new ListNode(val);
        newNode.next = head.next;
        head.next = newNode;
    }

    // Removes and returns the first element from this list
    public void removeFirst() {
        if (head.next==null) {
            return;
        }
        head.next = head.next.next;
        size--;
    }

    // Removes and returns the last element from this list
    public void removeLast() {
        if (head.next == null) {
            return;
        }
        size--;

        ListNode p1 = head;
        ListNode p2 = head.next;

        while (p2.next!=null) {
            p1 = p2;
            p2 = p2.next;
        }
        p1.next = null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        ListNode ptr = head.next;
        while (ptr!=null) {
            builder.append(ptr.val + (ptr.next==null ? " -> end " : " -> "));
            ptr = ptr.next;
        };

        return builder.toString();
    }
}

