package wholesomebot.dataStructures;

import java.util.Random;

public class Map<K, V>{

    private Node<K, V> head, tail;
    private int size;

    public Map(){
        size = 0;
        head = null;
        tail = null;
    }

    /*
     Adds an item to the end of the list

     Precondition: the list has been initialised

     Postcondition: and item is added to the end of the list
     */
    public void append(K key, V value){
        if(size==0){
            head = new Node<>(key, value, tail, null);
            tail = head;
        }
        else{
            Node<K,V> temp = new Node<>(key, value, null, tail);
            tail.setNext(temp);
            tail = temp;
            temp = null;
        }
        size++;
    }

    public void prepend(K key, V value){
        if(size==0){
            head = new Node<>(key, value, tail, null);
            tail = head;
        }
        else{
            Node<K,V> temp = new Node<>(key, value, head, null);
            head.setPrev(temp);
            head = temp;
            temp = null;
        }
        size++;
    }

    public void remove(K key){
        Node<K, V> current = head;
        for(int i=0; i<size; i++){
            if(current.getKey().equals(key)){
                current.getPrev().setNext(current.getNext());
                current.getNext().setPrev(current.getPrev());
                break;
            }
        }
    }

    public int size(){
        return size;
    }

    public K getRandom(){
        int rand = new Random().nextInt(size);
        Node<K,V> current = head;
        if(rand==0){
            return head.getKey();
        }
        while(rand>0){
            current = current.getNext();
            rand--;
        }
        return current.getKey();
    }

    public K get(int pos){
        int i=0;
        Node<K, V> current = head;
        while(i<pos){
            current = current.getNext();
            i++;
        }
        return current.getKey();
    }

    public V getValue(K key){
        Node<K, V> current = head;
        while(current!=null){
            if(current.getKey().equals(key)){
                return current.getValue();
            }
            else
                current = current.getNext();
        }
        return null;
    }

    public void replace(K key, V value){
        Node<K,V> current = head;
        while(current!=null){
            if(current.getKey().equals(key)){
                current.setKey(key);
                current.setValue(value);
                return;
            }
            else
                current = current.getNext();
        }
    }
}


