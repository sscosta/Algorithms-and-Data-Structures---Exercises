package testessemestresanteriores;

import aulas.Node;

import java.util.Comparator;

public class T1_14_15_SI {

    public static void main(String[] args) {
        int elem1[] ={3,27,45,68,70,81,99};
        int elem2[] ={9,16,25,35,70,84};
        System.out.println(findMinDifference(elem1,elem2));



    }
    public static int findMinDifference(int[] elem1, int [] elem2){
        int min = Math.abs(elem1[0]-elem2[0]);
        for(int i =0, j=0;i<elem1.length && j<elem2.length;) {
            int diff = Math.abs(elem1[i] - elem2[j]);
            if (diff < min)min = diff;
            if(elem1[i]>elem2[j])++j;
            else ++i;
        }
        return min;
    }
    public static <E> Node<E> occurAtLeastKTimes(Node<E>[] lists, Comparator<E> cmp, int k){
        Node<E> res = new Node<>();
        res.prev = res;
        res.next = res;
        int dim = lists.length;
        buildMinHeap(lists,dim,cmp);
        int counter = 0;
        Node<E> aux=lists[0];
        while(dim>0){
            if(cmp.compare(lists[0].value,aux.value)==0)
                counter++;
            else{
                if(counter>k){
                    res.prev.next = aux;
                    aux.prev = res.prev;
                    res.prev = aux;
                    res.prev.next = res;
                }
                counter=1;
                aux = lists[0];
            }
            lists[0]=lists[0].next;
            if(lists[0]==null)
                lists[0] = lists[--dim];
           minHeapify(lists,0,dim,cmp);
        }
        return res;
    }

    public static <E> void minHeapify(aulas.Node<E> [] h, int i, int n, Comparator <E> compar) {
        int l = left(i);
        int r = right(i);
        int smallest;
        if (l < n && compar.compare(h[l].value,h[i].value)<0)
            smallest = l;
        else smallest = i;
        if (r < n && compar.compare(h[r].value,h[smallest].value)<0)
            smallest = r;
        if (smallest != i) {
            exchange(h, i, smallest);
            minHeapify(h, smallest, n,compar);
        }
    }
    private static <E> void exchange(E [] h, int i, int j) {
        E aux = h[i];
        h[i] = h[j];
        h[j] = aux;
    }
    public static int left(int i) {
        return 2 * i + 1;
    }

    public static int right(int i) {
        return 2 * i + 2;
    }
    public static <E> void buildMinHeap(Node<E> [] h, int n, Comparator<E> compar) {
        for (int i = n / 2 - 1; i >= 0; i--)
            minHeapify(h, i, n,compar);
    }
}
