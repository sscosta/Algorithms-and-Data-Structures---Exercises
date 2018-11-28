package testessemestresanteriores;

public class DNode<K,V> {
    K key;
    V value;
    public DNode <K,V> next;
    public DNode(K theKey, V theValue,DNode<K,V> theNext){
        key=theKey;
        value=theValue;
        next = theNext;
    }
}
