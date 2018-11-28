package testessemestresanteriores;
import aulas.Node;

import java.util.Comparator;

public class T1_16_17_SI {

    public static void main(String[] args) {
        int [] arr = {-8,-3,2,4,6};
        int [] result = squareSorted(arr);
        System.out.printf("Square Sorted:\n" +
                "Expected\n" +
                "{4,9,16,36,64}\n");
        for(int i:result)
            System.out.printf("%d ",i);
        System.out.println();

        System.out.printf("\nIntersection Point:\nList1 = {3,5,2,7,4}" +
                "\nList2 = {9,3,7,8,2,7,4}" +
                "\nExpected: 2\n");
        Node<Integer> list1 = new Node<>();
        Node<Integer> n1    = new Node<>();
        list1.next=n1;
        n1.prev= list1;
        n1.value=3;
        Node<Integer> n2 = new Node<>();
        n1.next=n2;
        n2.prev=n1;
        n2.value=5;
        Node<Integer> n3 = new Node<>();
        n2.next=n3;
        n3.prev=n2;
        n3.value=2;
        Node<Integer> n4 = new Node<>();
        n3.next=n4;
        n4.prev=n3;
        n4.value=7;
        Node<Integer> n5 = new Node<>();
        n4.next=n5;
        n5.prev=n4;
        n5.next=list1;
        n5.value=4;
        list1.prev = n5;

        Node<Integer> list2 = new Node<>();
        Node<Integer> n6 = new Node<>();
        list2.next =n6;
        n6.prev=list2;
        n6.value=9;
        Node<Integer> n7 = new Node<>();
        n7.prev=n6;
        n6.next=n7;
        n7.value=3;
        Node<Integer> n8 = new Node<>();
        n8.prev=n7;
        n7.next=n8;
        n8.value=7;
        Node<Integer> n9 = new Node<>();
        n9.prev=n8;
        n8.next=n9;
        n9.value=8;
        Node<Integer> n10 = new Node<>();
        n10.prev=n9;
        n9.next=n10;
        n10.value=2;
        Node<Integer> n11 = new Node<>();
        n11.prev=n10;
        n10.next=n11;
        n11.value=7;
        Node<Integer> n12 = new Node<>();
        n12.prev=n11;
        n11.next=n12;
        n12.value=4;
        n12.next = list2;
        list2.prev = n12;
        Node<Integer> res = intersectionPoint(list1, list2, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        System.out.printf("Actual: %d\n", res.value);
    }

    public static int [] squareSorted(int[] v){
        int lower =0;
        int upper = v.length-1;
        int [] res = new int [v.length];
        int i=v.length-1;
        while(lower<=upper){
            if(Math.abs(v[lower])>Math.abs(v[upper])) {//avançar esq
                res[i]= v[lower]*v[lower];
                lower++;
                i--;
            }
            else{
                res[i] = v[upper]*v[upper];
                upper--;
                i--;
            }
        }
        return res;
    }
    public static <E> Node <E> intersectionPoint(Node<E> list1, Node<E> list2, Comparator<E> cmp){
        list1 = list1.prev;
        list2 = list2.prev;
        while(list1.value!=null && list2.value!=null && list1.value.equals(list2.value)){
            list1 = list1.prev;
            list2 = list2.prev;
            if(list1.value==null && list2.value==null)
                return list1.next;
        }
        return list1.next;
    }

}
