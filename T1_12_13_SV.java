package testessemestresanteriores;

import aulas.Node;
import series.serie1.Auxiliar;

import java.util.Comparator;

import static java.util.Arrays.binarySearch;

public class T1_12_13_SV {
    public static void main(String[] args) {
        int [] v1 = {2,5,6,9};
        int [] v2 = {10,11,12,13};
        int [] result = findSum(v1,v2,13);
        System.out.printf("{%d %d}\n",result[0],result[1]);


        Node<Integer> [] lists = new Node[4];
        lists[0] = new Node<>();
        lists[0].value = 9;
        Node<Integer> n1= new Node<>();
        n1.value=8;
        lists[0].next =n1;
        n1.prev = lists[0];

        lists[1] = new Node<>();
        lists[1].value = 7;
        Node<Integer> n2= new Node<>();
        n2.value = 6;
        n2.prev = lists[1];
        lists[1].next = n2;
        Node<Integer>n3 = new Node<>();
        n3.value = 3;
        n3.prev = n2;
        n2.next = n3;

        lists[2] = new Node<>();
        lists[2].value = 5;

        lists[3]= new Node<>();
        lists[3].value = 12;
        Node<Integer> n4 = new Node<>();
        n4.value = 3;
        n4.prev= lists[3];
        lists[3].next = n4;
        Node<Integer> resultado = kGreatestElements(lists, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        },4);
        System.out.printf("Expected:\n" +
                "{ 12 9 8 7 }\n");
        System.out.println("Actual:");
        printLinkedListWithSentinel(resultado);
    }
    //O(n log n)
    public static int [] findSum(int[]v1, int[] v2, int elem){
        int [] result = new int [2];
        for(int i=0;i<v1.length&&v1[i]<=elem;++i){
            int aux= elem -v1[i];
            if(binarySearch(v2,aux)!=-1){
                result[0]=v1[i];
                result[1]=aux;
            }
        }
        return result;
    }
    public static <E> Node <E> kGreatestElements(Node<E> [] lists, Comparator<E> cmp, int k){
        Node<E> res = new Node<>();
        res.next= res;
        res.prev = res;

        int i =0;
        int dim = lists.length;
        Auxiliar.buildMaxHeap(lists,dim,cmp);
        while(i!=k && dim>0){
            res.prev.next = lists[0];
            lists[0].prev = res.prev;
            res.prev= res.prev.next;
            lists[0]=lists[0].next;
            res.prev.next = res;

            if(lists[0]==null) lists[0] = lists[--dim];
            Auxiliar.maxHeapify(lists,0,dim,cmp);
            ++i;
        }
        return res;
    }
    public static <E> void printLinkedListWithSentinel(Node<E> list){
        list= list.next;
        System.out.print("{");
        while(list.value!=null){
            System.out.printf(" %d",list.value);
            list = list.next;
        }
        System.out.println(" }");
    }
}
