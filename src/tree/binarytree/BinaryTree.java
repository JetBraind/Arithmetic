package tree.binarytree;

import tree.node.Node;

public class BinaryTree {
    //定义一个根节点，必须为树本身持有的对象
    private Node root;

    //插入操作
    public void insert(float f) {
        Node node = new Node();
        node.data = f;
        if (root == null)
            root = node;
        else {
            Node parent = root;
            while (true) {
                if (parent.data < node.data) {
                    if (parent.next == null) {
                        parent.next = node;
                        return;
                    }
                    parent = parent.next;
                } else {
                    if (parent.previous == null) {
                        parent.previous = node;
                        return;
                    }
                    parent = parent.previous;
                }
            }
        }
    }

    public void delete(float f) {
        Node node = new Node();
        node.data = f;
        if (root != null) {
            Node parent = root;
            while (true) {
                if (node.data > parent.data) {
                    Node current = parent.next;
                    //如果右节点为空，则停止
                    if (current == null)
                        return;
                    if (node.data == current.data) {
                        if (current.next == null && current.previous == null) {
                            //要删除的节点是右叶子节点
                            parent.next = null;
                            return;
                        } else if (current.next == null && current.previous != null) {
                            parent.next = current.previous;
                            return;
                        } else if (current.next != null && current.previous == null) {
                            parent.next = current.next;
                            return;
                        } else {
                            parent.next = current.previous;
                            parent.next.next = current.next;
                            return;
                        }
                    }
                    parent = parent.next;
                }
                if (node.data < parent.data) {
                    Node current = parent.previous;
                    //如果左节点为空，则停止
                    if (current == null) {
                        return;
                    }
                    if (current.data == node.data) {
                        //要删除的节点是左叶子节点
                        if (current.previous == null && current.previous == null) {
                            parent.previous = null;
                            return;
                        } else if (current.previous == null && current.next != null) {
                            parent.previous = current.next;
                            return;
                        } else if (current.previous != null && current.next == null) {
                            parent.previous = current.previous;
                            return;
                        } else {
                            parent.previous = current.previous;
                            parent.previous.previous = current.next;
                            return;
                        }
                    }
                    parent = parent.previous;
                }

                if (node.data == parent.data) {
                    if (parent.previous == null && parent.next == null) {
                        root = parent.next;
                        return;
                    } else if (parent.next == null) {
                        root = parent.previous;
                        return;
                    } else if (parent.previous == null) {
                        root = parent.next;
                        return;
                    } else {
                        parent = parent.previous;
                        while (true) {
                            Node current = parent.next;
                            if (current.next == null) {
                                root.data = current.data;
                                parent.next = current.previous;
                                return;
                            }
                            parent = parent.next;
                        }
                    }
                }
            }
        }
    }
}
