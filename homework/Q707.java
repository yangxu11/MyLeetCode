package leetcode.homework;

public class Q707 {
    class MyLinkedList {
        private class Node{
            int val;
            Node next;
            public Node(int val) {
                this.val = val;
            }
        }
        private int size;
        private Node start;


        /** Initialize your data structure here. */
        public MyLinkedList() {
            start = new Node(0);
            size=0;
        }

        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        public int get(int index) {
            if(index+1>size) {
                return -1;
            }
            Node node = start;
            for(int i=0 ; i<=index ; i++) {
                node = node.next;
            }
            return node.val;
        }

        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {
            // Node node = new Node(val);
            // node.next = start.next;
            // start.next = node ;
            // size++;
            addAtIndex(0,val);


        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
            // Node node = new Node(val);
            // Node temp = start;
            // for(int i=0 ; i<size ; i++) {
            //     temp = temp.next;
            // }
            // temp.next = node;
            // size++;
            addAtIndex(size,val);

        }

        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val) {
            if(index>size) return;
            Node node = new Node(val);
            Node temp = start;
            for(int i=0 ; i<index ; i++) {
                temp = temp.next;
            }
            node.next = temp.next;
            temp.next = node;
            size++;
        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
            if(index+1>size) return;
            Node temp = start;
            for(int i=0 ; i<index ; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            size--;
        }
    }
}
