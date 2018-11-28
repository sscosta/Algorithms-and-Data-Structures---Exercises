package testessemestresanteriores;
import aulas.Node;
public class T1_16_17_SV {
    public static void main(String[] args) {
        Node<Integer> list2 = new Node<>();
        list2.value = 1;

        Node<Integer> n1 = new Node<>();
        n1.value = 3;
        list2.next = n1;
        n1.prev = list2;
        Node<Integer> n2 = new Node<>();
        n2.value = 2;
        n1.next = n2;
        n2.prev = n1;
        Node<Integer> n3 = new Node<>();
        n3.value= 5;
        n3.prev = n2;
        n2.next = n3;
        Node<Integer> n4 = new Node<>();
        n4.value = 4;
        n4.prev = n3;
        n3.next = n4;


        Node<Integer> list1 = new Node<>();
        list1.value = 1;

        Node<Integer> n5 = new Node<>();
        n5.value = 1;
        list1.next = n5;
        n5.prev = list1;
        Node<Integer> n6 = new Node<>();
        n6.value = 3;
        n5.next = n6;
        n6.prev = n5;
        Node<Integer> n7 = new Node<>();
        n7.value= 2;
        n7.prev = n6;
        n6.next = n7;
        Node<Integer> n8 = new Node<>();
        n8.value = 5;
        n8.prev = n7;
        n7.next = n8;
        Node<Integer> n9 = new Node<>();
        n9.value = 4;
        n8.next = n9;
        n9.prev = n8;
        Node<Integer> n10 = new Node<>();
        n10.value= 10;
        n10.prev = n9;
        n9.next = n10;
        //Node<Integer> n11 = new Node<>();
        //n11.value = 10;
        //n11.prev = n10;
        //n10.next = n11;

        System.out.println(sublist(list1,list2));
        }
    public static int countSubKSequences(int[]a,int k){
    return 0;
    }

    public static <E> boolean sublist(Node<E> list1, Node<E> list2){
        while(list1!=null && list1.value!=list2.value)
            list1 = list1.next;
        if(list1==null) return false;
        while(list1!=null && list2!=null &&list1.value==list2.value){
            list1 = list1.next;
            list2 = list2.next;
        }
        if(list2==null)return true;
        else return sublist(list1,list2);
    }
}
