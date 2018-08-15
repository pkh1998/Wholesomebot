package wholesomebot.main.GoodMorningMesage;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Users<K, V> implements Iterable<K>{

    protected Node<K, V> head, tail;
    protected int size, modCount;

    public Users(){
        size = 0;
        modCount = 0;
    }

    public void append(K key, V value){

    }

    public void prepend(){}

    /*
     * Precondition: linkedlist is initialised
     *
     * Postcondition: private inner class containing iterator methods
     */
    @Override
    public KeyIterator iterator() {
        return new KeyIterator();
    }

    private class KeyIterator implements Iterator{

        private int expectedModCount;
        private Node curPos;

        /*
         * Precondition: SimpleIterator is initialised
         *
         * Postcondition: initialises SimpleIterator
         */
        private KeyIterator(){
            curPos = head;
            expectedModCount = modCount;
        }

        /*
         * Precondition: SimpleIterator is initialised
         *
         * Postcondition: checks to see if there is another object in the list, returns true if there is, otherwise false
         */
        public boolean hasNext(){
            if(curPos.getNext()!= null && curPos.getNext()!= tail)
                return true;
            else
                return false;
        }

        /*
         * Precondition: SimpleIterator is initialised
         *
         * Postcondition: returns the data of the next node, if there are no more nodes, throws an error
         */
        public K next(){
            if(modCount!=expectedModCount){
                throw new ConcurrentModificationException("Cannot mutate in context of iterator");
            }
            if(!hasNext()){
                throw new NoSuchElementException("There are no more elements");
            }
            else {
                curPos = curPos.getNext();
                return (K)curPos.getKey();
            }
        }

        /*
         * Precondition: SimpleIterator is initialised
         *
         * Postcondition: throws exception due to function not being implemented
         */
        public void remove(){
            throw new UnsupportedOperationException("Remove not supported");
        }
    }

    private class Node<K, V> {
        K key;
        V value;
        Node next, prev;

        /*
         * Precondition: none
         *
         * Postcondition: a node object is created, if no next/prev nodes are specified, they are set to null
         */
        public Node(){
            this.key = null;
            this.value = null;
            this.next = null;
            this.prev = null;
        }

        /*
         * Precondition: none
         *
         * Postcondition: a node object is created, if no next/prev nodes are specified, they are set to null
         */
        public Node(K key, V value, Node next, Node prev){
            this.key = key;
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        /*
         * Precondition: a node has been created
         *
         * Postcondition: data is set into the node
         */
        public void setKey(K key){
            this.key = key;
        }

        /*
         * Precondition: a node has been created
         *
         * Postcondition: value is set into the node
         */
        public void setValue(V value){
            this.value = value;
        }

        /*
         * Precondition: a node has been created
         *
         * Postcondition: next node is set
         */
        public void setNext(Node next){
            this.next = next;
        }

        /*
         * Precondition: a node has been created
         *
         * Postcondition: prev node is set
         */
        public void setPrev(Node prev){
            this.prev = prev;
        }

        /*
         * Precondition: a node has been created
         *
         * Postcondition: data is returned
         */
        public K getKey(){
            return key;
        }

        /*
         * Precondition: a node has been created
         *
         * Postcondition: value is returned
         */
        public V getValue(){
            return value;
        }

        /*
         * Precondition: a node has been created
         *
         * Postcondition: next node is returned
         */
        public Node getNext(){
            return next;
        }

        /*
         * Precondition: a node has been created
         *
         * Postcondition: prev node is returned
         */
        public Node getPrev(){
            return prev;
        }
    }
}


