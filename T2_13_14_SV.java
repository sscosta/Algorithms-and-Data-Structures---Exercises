package testessemestresanteriores;

public class T2_13_14_SV {

    public static void main(String[] args) {
        DNode<String,Integer>[] hashMap = new DNode[11];
        DNode<String,Integer> a = new DNode<>("Pepe",1,null);
        if(hashMap[index(hashMap,a.key)]!=null)
            a.next=hashMap[index(hashMap,a.key)];
        hashMap[index(hashMap,a.key)]=a;

        DNode<String,Integer> b = new DNode<>("Cristiano Ronaldo",2,null);
        if(hashMap[index(hashMap,b.key)]!=null)
            b.next=hashMap[index(hashMap,b.key)];
        hashMap[index(hashMap,b.key)]=b;

        DNode<String,Integer> c = new DNode<>("Ricardo Quaresma",3,null);
        if(hashMap[index(hashMap,c.key)]!=null)
            c.next=hashMap[index(hashMap,c.key)];
        hashMap[index(hashMap,c.key)]=c;

        DNode<String,Integer> d = new DNode<>("André Silva",4,null);
        if(hashMap[index(hashMap,d.key)]!=null)
            d.next=hashMap[index(hashMap,d.key)];
        hashMap[index(hashMap,d.key)]=d;

        DNode<String,Integer> e = new DNode<>("Rui Patrício",5,null);
        if(hashMap[index(hashMap,e.key)]!=null)
            e.next=hashMap[index(hashMap,e.key)];
        hashMap[index(hashMap,e.key)]=e;

        DNode<String,Integer> f = new DNode<>("João Moutinho",6,null);
        if(hashMap[index(hashMap,f.key)]!=null)
            f.next=hashMap[index(hashMap,f.key)];
        hashMap[index(hashMap,f.key)]=f;

        DNode<String,Integer> g = new DNode<>("Cédric Soares",7,null);
        if(hashMap[index(hashMap,g.key)]!=null)
            g.next=hashMap[index(hashMap,g.key)];
        hashMap[index(hashMap,g.key)]=g;

        DNode<String,Integer> h= new DNode<>("William Carvalho",8,null);
        if(hashMap[index(hashMap,h.key)]!=null)
            h.next=hashMap[index(hashMap,h.key)];
        hashMap[index(hashMap,h.key)]=h;

        DNode<String,Integer> i = new DNode<>("José Fonte",9,null);
        if(hashMap[index(hashMap,i.key)]!=null)
            i.next=hashMap[index(hashMap,i.key)];
        hashMap[index(hashMap,i.key)]=i;

        DNode<String,Integer> j = new DNode<>("Raphael Guerreiro",10,null);
        if(hashMap[index(hashMap,j.key)]!=null)
            j.next=hashMap[index(hashMap,j.key)];
        hashMap[index(hashMap,j.key)]=j;

        DNode<String,Integer> k = new DNode<>("João Mário",11,null);
        if(hashMap[index(hashMap,k.key)]!=null)
            k.next=hashMap[index(hashMap,k.key)];
        hashMap[index(hashMap,k.key)]=k;

        System.out.println("With José Fonte and Ricardo Quaresma");
        for(int y =0;y<hashMap.length;++y ){
            DNode x = hashMap[y];
            while(x!=null) {
                System.out.println(x.key);
                x = x.next;
            }
        }

        LNode<String> l = new LNode<>("José Fonte",null);
        LNode<String> listaSubs = new LNode<>("Ricardo Quaresma", l);
        removeAll(hashMap,listaSubs);
        System.out.println("Without José Fonte and Ricardo Quaresma");

        for(int y =0;y<hashMap.length;++y ){
            DNode x = hashMap[y];
            while(x!=null) {
                System.out.println(x.key);
                x = x.next;
            }
        }

    }
    public static <K,V> void removeAll(DNode<K,V> [] hashMap, LNode<K> list){
        while(list!=null){
            int idx = index(hashMap,list.key);
            DNode<K,V> n = hashMap[idx];
            DNode<K,V> p = null;
            while(n.key!=list.key && n!=null){
                p=n;
                n=n.next;
            }
            if(n!=null && p!=null)
                p.next=n.next;
            else if(n!=null)
                hashMap[idx]=n.next;
            list = list.next;
        }
    }
    private static <K,V> int index(DNode<K,V>[] hashMap,K key){
        int hc = key.hashCode();
        int m = hc% hashMap.length;
        return m<0?m+hashMap.length:m;
    }

    /**
     * 4
     */
    public static <E> boolean isPerfectlyBalanced(Node<E> root){
        return root == null ||( isPerfectlyBalanced(root.left)&& isPerfectlyBalanced(root.right) &&
        height(root.left)-height(root.right)==0);
    }
    private static <E> int height(Node<E> root){
        if(root==null)return 0;
        return Math.max(height(root.right),height(root.left));
    }
}
