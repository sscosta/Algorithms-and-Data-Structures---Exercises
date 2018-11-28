package testessemestresanteriores;

import aulas.Node;
import series.serie1.Auxiliar;

import java.util.Comparator;

public class T1_12_13_SI {
    public static int retainIndexes(int[] v,int l, int r, int vi[], int li, int ri){
        return 0;
    }
    //este exercício faz parte da serie 2 deste ano
    public static <E> Node<E> merge (Node<E>[] lists, Comparator<E> cmp){
        Node<E> result = new Node<>();
        result.next= result;
        result.prev = result;
        //int dim = lists.length;
        int dim = 0;
        for(int j=0;j<lists.length;j++){
            if(lists[j]!=null)
                lists[dim++]=lists[j];
        }
        Auxiliar.buildMinHeap(lists,dim,cmp);
        while(dim>0){
            result.prev.next = lists[0];
            lists[0].prev = result.prev;
            result.prev = result.prev.next;
            result.prev.next = result;
            lists[0] = lists[0].next;
            if(lists[0]==null)lists[0]=lists[--dim];
            Auxiliar.minHeapify(lists,0,dim,cmp);
        }
        return result;
    }
}
