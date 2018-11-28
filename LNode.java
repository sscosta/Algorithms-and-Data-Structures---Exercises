package testessemestresanteriores;

public class LNode<K> {
    K key;
    LNode<K> next;
    public LNode(K theKey,LNode<K> theNext){
        key=theKey;
        next=theNext;
    }
}
