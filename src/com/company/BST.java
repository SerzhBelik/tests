package com.company;

import java.util.NoSuchElementException;

public class BST<Key extends Comparable<Key>, Value> {
    Node root;
    int level;

    private class Node {
        private Key key;
        private Value value;
        private Node left;
        private Node right;
        private int size;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            size = 1;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.size;
    }

    public boolean isEmpty() {
        return root == null;
    }

    private boolean isKeyNotNull(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Не может key  равняться null");
        }
        return true;
    }

    public boolean contains(Key key) {
        isKeyNotNull(key);
        return get(key) != null;
    }

    public Value get(Key key) {
        return get(root, key);
    }


    private Value get(Node node, Key key) {
        isKeyNotNull(key);
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node.value;
        } else if (cmp < 0) {
            return get(node.left, key);
        } else {
            return get(node.right, key);
        }
    }


    public void put(Key key, Value value) {
        isKeyNotNull(key);
        if (value == null) {
            //delete(key)
            return;
        }
        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) {
            return new Node(key, value);
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            node.value = value;
        } else if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else {
            node.right = put(node.right, key, value);
        }
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    public Value min() {
        return min(root).value;
    }

    private Node min(Node node) {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }

    public Value max() {
        return max(root).value;
    }

    private Node max(Node node) {
        if (node.right == null) {
            return node;
        }
        return max(node.right);
    }

    public void deleteMin() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void delete(Key key) {
        isKeyNotNull(key);
        root = delete(root, key);
    }

    private Node delete(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = delete(node.left, key);
        } else if (cmp > 0) {
            node.right = delete(node.right, key);
        } else {
            if(node.left == null ){
                return node.right;
            }
            if(node.right == null ){
                return node.left;
            }
            Node temp = node;
            node = min(node.right);
            node.right = deleteMin(temp.right);
            node.left = temp.left;
        }
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    @Override
    public String toString() {
        return "BST{" +
                toString(root) +
                '}';
    }

    public String toString(Node node) {

        if (node == null) {
            return "";
        }
        return  toString(node.left) + " " + node.value.toString()
                + " " + toString(node.right);
    }

    public boolean isBalanced(Node root, int level) {
        this.level = level;
        if ((root.left == null && root.right != null)
        || (root.left != null && root.right == null)) return false;
        if ((root.left == null && root.right == null)) return true;
        this.level++;
        return isBalanced(root.left, this.level) && isBalanced(root.right, this.level);
    }

}
