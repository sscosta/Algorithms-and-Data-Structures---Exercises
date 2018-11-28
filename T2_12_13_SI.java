package testessemestresanteriores;

import java.util.Iterator;

public class T2_12_13_SI {

    /*1.
    * A         Q - ABCD
    * AB        Q - CDEG
    * ABC       Q - DEGF
    * ABCD      Q - EGF
    * ABCDEGF
    * */

    /*2.
    * contar numero de nós numa arvore resultante de conjuntos disjuntos
    * Espaço - O(n) com n o número de convidados
    * Tempo - numero de pares=m : (Carregamento) O(2m) + (Compressão) O(k log n) + O(1)
     */

    /*3
    *
     */
    public static Iterable<Integer> getValuesLessThan(Iterable<Integer> src, int value){
        return new Iterable<Integer>() {
            @Override
            public Iterator<Integer> iterator() {
                return new Iterator<Integer>() {
                    Integer toRet;
                    Integer bef;
                    Iterator<Integer> it = src.iterator();
                    @Override
                    public boolean hasNext() {
                        if(toRet!=null) return true;
                        while(it.hasNext()){
                            toRet=it.next();
                            if(toRet<=value && toRet!=bef)return true;
                        }
                        toRet=null;
                        return false;
                    }

                    @Override
                    public Integer next() {
                        bef = toRet;
                        toRet=null;
                        return bef;
                    }
                };
            }
        };
    }
    public static int countLeavesAtLevel(Node<Integer> root, int k){
        if(k==0)return 1;
        if(root.right==null && root.left==null)return 0;
        if(root.right==null) return countLeavesAtLevel(root.left, k-1);
        if(root.left==null) return countLeavesAtLevel(root.right,k-1);
        return countLeavesAtLevel(root.right,k-1) + countLeavesAtLevel(root.left, k-1);
    }
}
