package testessemestresanteriores;

import aulas.Node;

import java.util.Comparator;
import java.util.Iterator;

public class T1_11_12_SI {
    public static boolean hasEquals(int [] maxHeap, int sizeHeap){
        if(sizeHeap==0)return false;
        int n = 0;
        if( (n<<1)+1 <= sizeHeap && n<<1 <= sizeHeap && (maxHeap[n]==maxHeap[n<<1]|| maxHeap[n]==maxHeap[(n<<1)+1]))
            return true;
        if((n<<1) <= sizeHeap && maxHeap[n]==maxHeap[n<<1])
            return true;
        return false;
    }



    public static Node<Integer> getDistinct (Node<Integer>[] hashTable, int hastableSize, Comparator<Integer>cmp){
        Node<Integer> res = new Node<>();
        return res;
    }
    public static Iterable<String> getWordsThatContains(Iterable<Iterable<String>> src, String word){
        return new Iterable<String>() {
            @Override
            public Iterator<String> iterator() {
                return null;
            }
        };
    }
    public static int sumValuesByLevel(Node root, int level){
        return -1;
    }
}
