package DP.iterator.v2;




/**
 * 创建一个容器，可以添加任意对象
 * v1:使用数组
 * v2:使用链表
 */
public class Main {
    public static void main(String[] args) {
        LinkedList_ list = new LinkedList_();
        for (int i = 0; i < 15; i++) {
            list.add(new String("s" + i));
        }
        System.out.println(list.size());
    }
}

/**
 * 相比数组，这个容器不用考虑边界问题，可以动态扩展
 */
class LinkedList_ {
    Node head = null;
    Node tail = null;

    private int size = 0;

    public void add(Object o) {
        Node n = new Node(o);
        n.next = null;

        if (head == null){
            head =  n;
            tail =  n;
        }
    }

    public class Node {
        private Object o;
        Node next;

        public Node(Object o) {
            this.o = o;
        }

    }

    public int size() {
        return size;
    }

}