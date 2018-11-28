package testessemestresanteriores;

import java.util.Iterator;

public class T2_15_16_SI {

    public static <K,V> Iterable <K> getKeysForAValue(HashNode<K,V>[] hashMap, V value){
        return new Iterable<K>(){
            public Iterator<K> iterator(){
                return new Iterator<K> (){
                    int index = 0;
                    HashNode<K,V> n,p;
                    @Override
                    public boolean hasNext() {
                        if(n!=null)return true;
                        if(p==null){
                            while(n==null &&index<hashMap.length){
                                n = hashMap[index++];
                                if(n.pair.getValue()==value)return true;
                                while(n!=null){
                                    n=n.next;
                                    if(n.pair.getValue()==value)return true;
                                }
                            }
                            return false;
                        }
                        n=p.next;
                        while(n!=null){
                            if(n.pair.getValue()==value)return true;
                            n=n.next;
                        }
                        while(n==null){
                            n=hashMap[index++];
                            if(n.pair.getValue()==value)return true;
                        }
                        return false;
                    }

                    @Override
                    public K next() {
                        p=n;
                        return p.pair.getKey();
                    }
                };
            }
        };
    }
    public static Integer lower(Node<Integer>root,int k){
        if(root==null) return null;
        Integer last = root.item;
        if(last>k) {
            if (root.left != null && root.left.item <= k)
                return root.left.item;
            else
                return lower(root.left, k);
        }
        else{
            if(root.right!=null && root.right.item<k)
                return lower(root.right,k);
            else
                return root.item;
        }
    }
}
