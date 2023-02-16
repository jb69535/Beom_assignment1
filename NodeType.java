package Beom_assignment1;

public class NodeType {
    public NodeType(ItemType item) {
        info = item;
    }
    public NodeType() {
        info = null;
        next = null;
    }
    public ItemType info;
    public NodeType next;

}
