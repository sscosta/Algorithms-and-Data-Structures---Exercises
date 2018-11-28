package testessemestresanteriores;

import series.serie3.planningsubwaytrip.model.Pair;

public class HashNode<K,V> {
    Pair<K,V> pair;
    HashNode<K,V> next;
    public HashNode(Pair<K,V> thePair,HashNode<K,V> theNext){
        pair = thePair;
        next=theNext;
    }
}
