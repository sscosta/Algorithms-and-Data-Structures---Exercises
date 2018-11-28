package testessemestresanteriores;

import aulas.Node;

public class T1_15_16_SV {

    public static void main(String[] args) {
        System.out.println(isShuffle("dabecf","abc","def"));

        Node<Integer> list = new Node<>();
        list.value = null;
        Node<Integer> fn = new Node<>();
        fn.value=1;
        list.next = fn;
        fn.prev = list;
        Node<Integer> n1 = new Node<>();
        n1.value=4;
        fn.next = n1;
        n1.prev = fn;
        Node<Integer> n2 = new Node<>();
        n2.value=7;
        n2.prev = n1;
        n1.next = n2;
        Node<Integer> n3 = new Node<>();
        n3.value=2;
        n2.next = n3;
        n3.prev = n2;
        Node<Integer> n4 = new Node<>();
        n4.value=5;
        n4.prev = n3;
        n3.next = n4;
        Node<Integer> n5 = new Node<>();
        n5.value=8;
        n4.next = n5;
        list.prev = n5;
        Node<Integer> n6 = new Node<>();
        n6.value = 3;
        n5.next = n6;
        n6.prev = n5;
        Node <Integer> n7 = new Node<>();
        n7.value = 6;
        n7.prev = n6;
        n6.next = n7;
        Node <Integer> n8 = new Node<>();
        n8.value = 9;
        n8.prev = n7;
        n7.next = n8;
        Node<Integer> n9 = new Node<>();
        n9.value=4;
        n9.prev = n8;
        n8.next = n9;
        Node <Integer> n10 = new Node<>();
        n10.value=10;
        n9.next= n10;
        n10.prev=n9;
        n10.next = list;
        list.prev = n10;
        Node<Node<Integer>> res = distribute(list,4);

        }

    public static boolean isShuffle(String isShuffle, String str1, String str2) {
        if (isShuffle.length() != str1.length() + str2.length()) return false;
        int index1 = 0;
        int index2 = 0;
        int shuffleIndex  = 0;
        while (index1 < str1.length() && index2 < str2.length() && shuffleIndex < isShuffle.length()) {
            if (isShuffle.charAt(shuffleIndex)==str1.charAt(index1))
                index1++;
            else if (isShuffle.charAt(shuffleIndex)==str2.charAt(index2))
                index2++;
            else return false;
            shuffleIndex++;
        }
        return true;
    }
    public static <E> Node<Node<E>> distribute (Node<E> list, int k){
        int i =0;
        Node<Node<E>> result = new Node<>();
        result.next = result;
        result.prev = result;
        while(i<k){
            Node<Node<E>> novo = new Node<>();//inserção à cauda
            result.prev.next = novo;
            novo.prev = result.prev;
            result.prev = novo;
            novo.next = result;
            ++i;
            Node<E> aux = new Node<>();
            novo.value = aux;
            novo.value.next = aux;
            novo.value.prev = aux;
        }
        list = list.next;
        Node<Node<E>> curr = new Node<>();
        curr = result.next;
        while(list.value!=null){
            if(curr.value==null)//sentinela
                curr=curr.next;
            curr.value.prev.next = list;
            list.prev = curr.value.prev;
            curr.value.prev=list;
            list = list.next;
            curr.value.prev.next = curr.value;
            curr = curr.next;
        }
        return result;
    }
}
