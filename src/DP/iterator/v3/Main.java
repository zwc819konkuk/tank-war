package DP.iterator.v3;


/**
 * 创建一个容器，可以添加任意对象
 * v1:使用数组
 * v2:使用链表
 * v3:添加容器的共同接口，实现容器的替换
 */
public class Main {
    public static void main(String[] args) {
        Collection_ list = new ArrayList_();
        for (int i = 0; i < 15; i++) {
            list.add(new String("s"+i));
        }
        System.out.println(list.size());
    }
}

/**
 * 相比数组，这个容器不用考虑边界问题，可以动态扩展
 */
class ArrayList_  implements Collection_{
    Object[] objects = new Object[10];
    //objects中下一个空的位置在哪？或者说，目前容器中有几个元素
    private int index = 0;

    public void add(Object o) {
        if (index == objects.length) {
            Object[] newObjects = new Object[objects.length * 2];
            System.arraycopy(objects, 0, newObjects, 0, objects.length);
            objects = newObjects;
        }

        objects[index] = 0;
        index++;
    }

    public int size() {
        return index;
    }

}

class LinkedList_ implements Collection_{
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

interface  Collection_{
    void add(Object o);
    int size();
}