package testessemestresanteriores;

import aulas.Node;
import series.serie1.Auxiliar;

import java.util.Comparator;

public class T1_13_14_SV {
    public static void main(String[] args) {
        String [] v = {"agendar","dia","teste"};
        String res = greaterCommonPrefix(v,0,2,"agendas");
        System.out.println(res);


        Node<Integer> [] lists = new Node[4];
        lists[0] = new Node<>();
        lists[0].value = 1;
        Node<Integer> n1= new Node<>();
        n1.value=3;
        lists[0].next =n1;
        n1.prev = lists[0];

        lists[1] = new Node<>();
        lists[1].value = 2;
        Node<Integer> n2= new Node<>();
        n2.value = 4;
        n2.prev = lists[1];
        lists[1].next = n2;
        Node<Integer>n3 = new Node<>();
        n3.value = 12;
        n3.prev = n2;
        n2.next = n3;

        lists[2] = new Node<>();
        lists[2].value = 3;

        lists[3]= new Node<>();
        lists[3].value = 2;
        Node<Integer> n4 = new Node<>();
        n4.value = 3;
        n4.prev= lists[3];
        lists[3].next = n4;
        Integer res2 = mostOccurrent(lists, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        System.out.println(res2);
    }
    //imagino que haverá uma forma melhor de resolver este problema
    public static String greaterCommonPrefix(String[]v,int l, int r, String word){
        if(v.length<1 || l>r)return null;
        int i = word.length();
        while(i>0){
            String prefix = word.substring(0,i);
            for(int j=l;j<r;++j) {
                if(v[j].length()>=prefix.length()){
                    String tmp = v[j].substring(0, prefix.length() );
                    if (tmp.equals(prefix))
                        return v[j];
                }
            }
                i--;
        }
        return "";
    }
    public static <E> E mostOccurrent(Node<E> [] lists, Comparator<E> cmp){
        int count=0;
        int max;
        E maxElem = lists[0].value;
        int dim = lists.length;
        Auxiliar.buildMinHeap(lists,dim,cmp);

        E elem = lists[0].value;
        max = 0;
        while(dim>0){
            if(lists[0].value.equals(elem))
                count++;
            else{
                if(count>max){
                    max= count;
                    maxElem = elem;
                }
                elem = lists[0].value;
                count=1;
            }
            lists[0]=lists[0].next;
            if(lists[0]==null)
                lists[0]=lists[--dim];
            Auxiliar.minHeapify(lists,0,dim,cmp);
        }
        return maxElem;
    }
}
