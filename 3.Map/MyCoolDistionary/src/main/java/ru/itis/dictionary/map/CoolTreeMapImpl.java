package ru.itis.dictionary.map;

public class CoolTreeMapImpl<K extends Comparable<K>, V> implements CoolMap<K, V> {
    static class Node<K, V> {
        private final K key;
        private V value;
        Node<K, V> left;
        Node<K, V> right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public V setValue(V value) {
            this.value = value;
            return value;
        }
    }

    Node<K, V> root;

    private void insertNode(Node<K, V> node, K key, V value) {
        if(node.key.compareTo(key) < 0) {
            if(node.right == null) {
                node.right = new Node<>(key, value);
            } else {
                insertNode(node.right, key, value);
            }
        } else if(node.key.compareTo(key) > 0) {
            if(node.left == null) {
                node.left = new Node<>(key, value);
            } else {
                insertNode(node.left, key, value);
            }
        } else {
            node.value = value;
        }
    }

    @Override
    public void put(K key, V value) {
        if(root == null) {
            root = new Node<>(key, value);
            return;
        }
        insertNode(root, key, value);
    }

    private Node<K, V> findNode(Node<K,V> node, K key) {
        if(node == null) { return null; }
        if(node.key.compareTo(key) < 0) {
            return findNode(node.right, key);
        } else if(node.key.compareTo(key) > 0) {
            return findNode(node.left, key);
        } else {
            return node;
        }
    }

    @Override
    public V get(K key) {
        Node<K, V> node = findNode(root, key);
        if(node == null) {
            return null;
        }
        return node.value;
    }

    private void printTree(Node<K, V> node, String indent, Boolean last) {
        if (node != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("R----");
                indent += "   ";
            } else {
                System.out.print("L----");
                indent += "|  ";
            }
            System.out.println(node.key);
            printTree(node.left, indent, false);
            printTree(node.right, indent, true);
        }
    }

    public void print() {
        printTree(root, "", true);
    }
}
