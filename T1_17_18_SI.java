package testessemestresanteriores;

import aulas.Node;
public class T1_17_18_SI {
    public static void main(String[] args) {
        int a[] = {1,2,3,4,7,9};
        int b[] = {0,1,1,1,2,4};
        int c [] = countLessOrEqual(a,b);
        System.out.println("Count Less Or Equal");
        for(int i=0;i<c.length;++i){
            System.out.printf("%d ",c[i]);
        }
        System.out.println();

        Node<Integer> list = new Node<>();
        list.value = null;
        Node<Integer> fn = new Node<>();
        fn.value=7;
        list.next = fn;
        fn.prev = list;
        Node<Integer> n1 = new Node<>();
        n1.value=6;
        fn.next = n1;
        n1.prev = fn;
        Node<Integer> n2 = new Node<>();
        n2.value=9;
        n2.prev = n1;
        n1.next = n2;
        Node<Integer> n3 = new Node<>();
        n3.value=10;
        n2.next = n3;
        n3.prev = n2;
        Node<Integer> n4 = new Node<>();
        n4.value=20;
        n4.prev = n3;
        n3.next = n4;
        Node<Integer> n5 = new Node<>();
        n5.value=11;
        n4.next = n5;
        list.prev = n5;
        n5.next = list;
        n5.prev = n4;

        System.out.println("Retain Between");
        retainBetween(list,1,1);
        list = list.next;
        while(list.value!=null) {
            System.out.printf("%d ",list.value);
            list = list.next;
        }
        System.out.println();
    }
    public static int [] countLessOrEqual(int [] a, int [] b){
        int c [] = new int [a.length];
        int i = 0, j = 0;
        while(j<b.length && i<a.length){
            if(a[i]>=b[j])
                ++j;
            else{
                c[i]= j;
                ++i;
            }
        }
        if(j==b.length){
            for(;i<a.length;++i)
                c[i]=j;
        }
        return c;
    }

    public static <E> void retainBetween(Node<E> list, int m, int n){
        int i = 0;
        Node<E> aux = list.next;
        while(i!=m){
            if(aux.value==null){
                list.prev=list;
                list.next = list;
            }
            list.next = aux.next;
            list.next.prev = list;
            aux.prev = null;
            aux.next = null;
            aux = list.next;
            i++;
        }

        i=0;
        aux = list.prev;
        while(i!=n){
            if(aux.value==null){
                list.prev=list;
                list.next = list;
            }
            list.prev = aux.prev;
            list.prev.next=list;
            aux.prev = null;
            aux.next = null;
            aux = list.prev;
            i++;
        }
    }
}
