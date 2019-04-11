package leetcode.homework;

public class Q622 {
    class MyCircularQueue {
        private class Node{
            int val;
            Node next;
            public Node(int val) {
                this.val = val;
            }
        }
        int ceil;
        int size;
        Node front;
        Node tail;

        /** Initialize your data structure here. Set the size of the queue to be k. */
        public MyCircularQueue(int k) {
            this.ceil = k;
            this.size = 0;
        }

        /** Insert an element into the circular queue. Return true if the operation is successful. */
        public boolean enQueue(int value) {
            if(size==ceil) return false;
            if(size==0) {
                front = new Node(value);
                tail = front;
                tail.next = front;
                front.next = tail;
                size++;
                return true;
            } else {
                Node node = new Node(value);
                node.next = tail;
                front.next = node;
                tail = node;
                size++;
                return true;
            }
        }

        /** Delete an element from the circular queue. Return true if the operation is successful. */
        public boolean deQueue() {
            if(size==0) return false;
            if(size==1) {
                tail=null;
                front=null;
                size--;
                return true;
            } else {
                Node node = tail;
                for(int i=1 ; i<size-1 ; i++) {
                    node = node.next;
                }
                front = node;
                front.next = tail;
                size--;
                return true;
            }

        }

        /** Get the front item from the queue. */
        public int Front() {
            if(front==null) return -1;
            return front.val;
        }

        /** Get the last item from the queue. */
        public int Rear() {
            if(tail==null) return -1;
            return tail.val;
        }

        /** Checks whether the circular queue is empty or not. */
        public boolean isEmpty() {

            return size==0;

        }

        /** Checks whether the circular queue is full or not. */
        public boolean isFull() {
            return size==ceil;
        }
    }
}
