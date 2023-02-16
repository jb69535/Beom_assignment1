package Beom_assignment1;

import java.util.*;

public class ItemType {

    private int value;
    public ItemType info;

    public ItemType(int num) {
        value = num;
    }

    public int compareTo(ItemType item) {
        if (this.value > item.getValue()) {
            return 1;
        }
        else if (this.value < item.getValue()) {
            return -1;
        }
        else {
            return 0;
        }
    }

    public int getValue() {
        return value;
    }


}
