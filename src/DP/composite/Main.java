package DP.composite;

import java.util.ArrayList;
import java.util.List;

abstract class Node {
    abstract public void p();
}

class LeafNode extends Node {

    String content;

    public LeafNode(String content) {
        this.content = content;
    }

    @Override
    public void p() {
        System.out.println(content);
    }
}

class BranchNode extends Node {

    List<Node> nodes = new ArrayList<>();

    String name;

    public BranchNode(String name) {
        this.name = name;
    }

    @Override
    public void p() {
        System.out.println(name);
    }

    public void add(Node n) {
        nodes.add(n);
    }
}

public class Main {
    public static void main(String[] args) {
        BranchNode root = new BranchNode("root");
        BranchNode chapter01 = new BranchNode("chapter01");
        BranchNode chapter02 = new BranchNode("chapter02");

        LeafNode c11 = new LeafNode("c11");
        LeafNode c12 = new LeafNode("c12");

        BranchNode b21 = new BranchNode("section21");

        LeafNode c211 = new LeafNode("c211");
        LeafNode c212 = new LeafNode("c212");

        root.add(chapter01);
        root.add(chapter02);
        chapter01.add(c11);
        chapter01.add(c12);
        chapter02.add(b21);
        b21.add(c211);
        b21.add(c212);

        tree(root, 0);
    }

    static void tree(Node node, int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("--");
        }

        node.p();

        if (node instanceof BranchNode) {
            for (Node n : ((BranchNode) node).nodes) {
                tree(n, depth + 1);
            }
        }
    }
}
