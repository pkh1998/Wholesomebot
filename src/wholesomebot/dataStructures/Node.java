package wholesomebot.dataStructures;

public class Node<K, V> {
    private K key;
    private V value;
    private Node<K, V> next, prev;

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
    public Node(K key, V value){
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }

    /*
     * Precondition: none
     *
     * Postcondition: a node object is created, if no next/prev nodes are specified, they are set to null
     */
    public Node(K key, V value, Node<K,V> next, Node<K,V> prev){
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
    public void setNext(Node<K,V> next){
        this.next = next;
    }

    /*
     * Precondition: a node has been created
     *
     * Postcondition: prev node is set
     */
    public void setPrev(Node<K,V> prev){
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
    public Node<K,V> getNext(){
        return next;
    }

    /*
     * Precondition: a node has been created
     *
     * Postcondition: prev node is returned
     */
    public Node<K,V> getPrev(){
        return prev;
    }
}
