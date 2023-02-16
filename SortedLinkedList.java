package Beom_assignment1;

public class SortedLinkedList {
    private NodeType head;
    private NodeType currentPos;

    public static int EQUAL = 0;
    public static int GREATER = 1;
    public static int LESS = -1;

    public SortedLinkedList() {
        this.head = new NodeType();
        this.currentPos = head;
    }

    @Override // Citation
    // https://stackoverflow.com/questions/29895197/how-to-return-string-without-excess
    public String toString() {
        String ret = "";
        NodeType current = head.next;
        while (current != null) {
            ret += current.info.getValue() + " ";
            current = current.next;
        }
        return ret + " ";
    }

    public int getLength() {
        int length = 0;
        while (this.currentPos.next != null) {
            length++;
            this.currentPos = currentPos.next;
        }
        currentPos = head;
        return length;
    }

    public void insertItem(ItemType item) {
        NodeType newNode = new NodeType(item);

        if (this.head.next == null) {
            this.head.next = newNode;
            return;
        }

        currentPos = head;

        while (currentPos.next != null) {
            if (currentPos.next.info.compareTo(item) == GREATER) {
                newNode.next = currentPos.next;
                currentPos.next = newNode;
                return;
            } else if (currentPos.next.info.compareTo(item) == EQUAL) {
                System.err.println("Sorry. You cannot insert the duplicates");
                return;
            }
            currentPos = currentPos.next;
        }
        if (currentPos.info.compareTo(item) == LESS) {
            currentPos.next = newNode;
        }
        currentPos = head;
    }

    public void deleteItem(ItemType item) {
        if (head.next == null) {
            System.out.println("the list is empty.");
        } else {
            NodeType delete = head;
            do {
                if (delete.next.info.compareTo(item) == EQUAL) {
                    if (delete.next.next == null) {
                        delete.next = null;
                        return;
                    } else {
                        delete.next = delete.next.next;
                        return;
                    }
                }
                delete = delete.next;
            } while (delete.next != null);
            System.err.println("Item not found.");
        }
    }

    public int searchItem(ItemType item) {
        NodeType search = head;
        int cannotFind = -1;
        int n = 1;
        while (search.next != null) {
            if (search.next.info.compareTo(item) == EQUAL) {
                return n;
            } else {
                n++;
                search = search.next;
            }
        }
        if (search.next == null) {
            System.err.println("Item not found");
        }
        return cannotFind;
    }

    public ItemType getNextItem() {
        if (head.next == null) {
            System.out.println("List is empty");
            return null;
        } else if (currentPos.next == null) {
            System.out.println("List reached the last value. \n ...");
            System.out.println("Reseting to first list...");
            currentPos = head.next;
            return currentPos.info;
        }
        currentPos = currentPos.next;
        return currentPos.info;
    }

    public void resetList() {
        currentPos = head.next;
    }

    public SortedLinkedList mergeList(SortedLinkedList list, SortedLinkedList newList) {
        do {
            try {
                newList.insertItem(list.currentPos.info);
            } catch (Exception e) {
                System.err.println("The second list is empty. \n Nothing to merge");
            }
            list.currentPos = list.currentPos.next;
        } while (list.currentPos != null);
        currentPos = head;
        return newList;
    }

    public void DeleteAlternate() {
        NodeType newNode = head;

        int count = 0;

        while (newNode.next != null) {
            if (count % 2 == 1) {
                deleteItem(new ItemType(newNode.next.info.getValue()));
            } else {
                newNode = newNode.next;
            }
            count++;
        }
    }

    public void intersection(SortedLinkedList listed){
        String intersectionList = "Intersection: ";
        NodeType node = head;
        do {
            if(intersection(listed, node.next.info) == EQUAL){
                intersectionList += node.next.info.getValue() + " ";
            }
            node = node.next;
        } while (node.next != null);
        System.out.println(intersectionList);
    }

    public int intersection(SortedLinkedList listed, ItemType item){
        NodeType node = listed.head;
        do {
            if(node.next.info.compareTo(item)==EQUAL){
                return EQUAL;
            }
            node = node.next;
        }while(node.next != null);
        return LESS;
    }

    /* 
    public SortedLinkedList intersection(SortedLinkedList list1, SortedLinkedList list2) {
        SortedLinkedList currA = list1;
        SortedLinkedList currB = list2;

        SortedLinkedList intersectedList = null;

        while (currA != null) {
            currB = list2;
            while (currB != null) {
                return currA;
            }
            currB = currB.next.info;
        }

    } */

}