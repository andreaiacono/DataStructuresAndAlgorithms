package datastructures;

/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 01/07/14
 * Time: 14.25
 */
public class SortedLinkedList {

    private Item head;

    public void insert(int value) {

        if (head == null) {
            head = new Item(value);
            return;
        }


        if (value < head.getValue()) {
            Item newItem = new Item(value);
            newItem.setNext(head);
            head = newItem;
            return;
        }

        Item loopingItem = head;
        while (loopingItem.getValue() < value) {

            if (loopingItem.getNext() == null || loopingItem.getValue() >= value) {

                Item newItem = new Item(value);
                newItem.setNext(loopingItem.getNext());
                loopingItem.setNext(newItem);
                break;
            }
            loopingItem = loopingItem.getNext();
        }
    }


    public int getSize() {

        int counter = 0;
        Item item = head;
        while (item != null) {
            item = item.getNext();
            counter ++;
        }

        return counter;
    }


    class Item {

        private int value;
        private Item next;

        public Item(int value) {
            this.value = value;
        }

        public int getValue() {return value;}

        public void setNext(Item next) {
            this.next = next;
        }

        public Item getNext() {
            return next;
        }
    }
}
