package DP.iterator.v5;


/**
 * 创建一个容器，可以添加任意对象
 * v1:使用数组
 * v2:使用链表
 * 插入（中间）链表，添加尾部链表，删除链表，随机访问数组，扩展链表
 * v3:添加容器的共同接口，实现容器的替换
 * v4:如何遍历？
 * v5:加入泛型
 */
public class Main {
    public static void main(String[] args) {
        Collection_<String> list = new ArrayList_<>();
        for (int i = 0; i < 15; i++) {
            list.add(new String("s" + i));
        }
        System.out.println(list.size());

        Iterator_<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }
    }
}

/**
 * 相比数组，这个容器不用考虑边界问题，可以动态扩展
 */
class ArrayList_<E> implements Collection_<E> {
    E[] objects = (E[]) new Object[10];
    //objects中下一个空的位置在哪？或者说，目前容器中有几个元素
    private int index = 0;

    public void add(E o) {
        if (index == objects.length) {
            E[] newObjects = (E[]) new Object[objects.length * 2];
            System.arraycopy(objects, 0, newObjects, 0, objects.length);
            objects = newObjects;
        }

        objects[index] = o;
        index++;
    }

    public int size() {
        return index;
    }

    @Override
    public Iterator_ iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator_ {

        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            if (currentIndex >= index) return false;
            return true;
        }

        @Override
        public Object next() {
            Object o = objects[currentIndex];
            currentIndex++;
            return o;
        }
    }

}

class LinkedList_ implements Collection_ {
    Node head = null;
    Node tail = null;

    private int size = 0;

    public void add(Object o) {
        Node n = new Node(o);
        n.next = null;

        if (head == null) {
            head = n;
            tail = n;
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

    @Override
    public Iterator_ iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator_ {

        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            if (currentIndex >= size) return false;
            return true;
        }

        @Override
        public Object next() {
            Object o = head;
            currentIndex++;
            return o;
        }
    }

}

interface Collection_<E> {
    void add(E o);

    int size();

    Iterator_ iterator();
}

interface Iterator_<E> {
    boolean hasNext();

    E next();
}//element E key K value V type T