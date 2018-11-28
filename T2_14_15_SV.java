package testessemestresanteriores;

public class T2_14_15_SV {

    public static<K,V> void merge (DNode<K,V>[] hashMap1,DNode<K,V>[] hashMap2, Compose<K> compose){
        for(int i = 0; i< hashMap2.length;i++){
            DNode<K,V> n = hashMap2[i];
            while(n!=null){
                int j = n.key.hashCode()%hashMap1.length;
                int m = j<0?j+hashMap1.length:j;
                if(hashMap1[m]!=null){
                    DNode<K,V> p = hashMap1[m];
                    while(p!=null){
                        if( p.key.equals(n.key)){
                            //COMPOSE
                            //p.key = compose(p.key,n.key);
                            break;
                        }
                    }
                }
                DNode<K,V> k = n;
                n.next = hashMap1[m];
                hashMap1[m] = n;
                n=k.next;
            }
        }
    }
    public static <E> int countSubTreesWithKLeaves(Node<E> root,int k){
        k=k-1;
        if(root.left==null && root.right==null && k==0) return 1;
        if(root.left==null && root.right==null) return 0;
        if(root.left==null) return countSubTreesWithKLeaves(root.right,k);
        if(root.right==null) return countSubTreesWithKLeaves(root.left,k);
        return countSubTreesWithKLeaves(root.right,k) + countSubTreesWithKLeaves(root.left,k);
    }
}
