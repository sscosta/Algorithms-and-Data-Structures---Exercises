package testessemestresanteriores;

import java.util.Iterator;

public class T2_14_15_SI {

        public static <K,V> Iterable<K> getKeys(DNode<K,V> [] hashMap){
        return new Iterable<K>() {
            @Override
            public Iterator<K> iterator() {
                return new Iterator<K>() {
                    int index = 0;
                    DNode<K,V> node;
                    DNode<K,V> prev;
                    @Override
                    public boolean hasNext() {
                        if(node!=null)return true;
                        //1ªvez
                        if(prev==null){
                            while(node==null)
                                node=hashMap[index++];
                            return true;
                        }
                        //navigate in collision list
                        node = prev.next;
                        //collision list ended- fectch next index(bucket) of hashmap
                        while(node==null&& index<hashMap.length-1)
                            node= hashMap[++index];
                        //end of map reached
                        if(index==hashMap.length-1&& node==null)return false;
                        return true;
                    }

                    @Override
                    public K next() {
                        prev = node;
                        node = null;
                        return prev.key;
                    }
                };
            }
        };
    }
    public static boolean hasPathWithAtLeastSum(Node<Integer> root, int sum){
            int val = sum - root.item;
            if(val<=0)return true;
            return hasPathWithAtLeastSum(root.left,val)||hasPathWithAtLeastSum(root.left,val);
    }
}
