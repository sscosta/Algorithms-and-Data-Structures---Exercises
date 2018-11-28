package testessemestresanteriores;

public class T2_16_17_SV {

    public static void replaceWithDiff(DNode<String,Integer>[] hashMap1, DNode<String,Integer>[] hashMap2){
        for(int i = 0;i<hashMap1.length;++i){
            DNode<String,Integer> n = hashMap1[i];
            while(n!=null){
                Integer diff = isIn(hashMap2,n);
                if(diff!=null)
                    n.value = diff;
                n=n.next;
            }
        }
    }

    private static Integer isIn(DNode<String, Integer>[] hashMap, DNode<String, Integer> node) {
        int m = node.value.hashCode()%hashMap.length;
        int index = m<0?m+hashMap.length:m;
        DNode<String,Integer> curr = hashMap[index];
        if(curr.key.equals(node.key))
            return node.value - curr.value;
        while(curr!=null){
            curr = curr.next;
            if(curr.key.equals(node.key))
                return node.value-curr.value;
        }
        return null;
    }

    public static int completeUntilLevel(Node<Integer> root, int k){
        if(root.left!=null && root.right!=null) return 1 +
                Math.min (  completeUntilLevel(root.left,k+1),
                            completeUntilLevel(root.right,k+1));
        else return 0;
    }

    public static void main(String[] args) {
        Node<Integer> a = new Node<>(1);
        Node<Integer> b = new Node<>(2);
        Node<Integer> c = new Node<>(3);
        Node<Integer> d = new Node<>(4);
        Node<Integer> e = new Node<>(5);
        Node<Integer> f = new Node<>(6);
        Node<Integer> g = new Node<>(7);
        Node<Integer> h = new Node<>(8);
        a.right = b;
        a.left = c;
        b.left = d;
        b.right = e;
        c.right=h;
        h.left = f;
        d.left = g;
        System.out.println(completeUntilLevel(a,0));

        Node<Integer> i = new Node<>(1);
        Node<Integer> j = new Node<>(2);
        Node<Integer> k = new Node<>(4);
        Node<Integer> l = new Node<>(5);
        Node<Integer> m = new Node<>(6);
        Node<Integer> n = new Node<>(7);
        Node<Integer> o = new Node<>(8);
        Node<Integer> p = new Node<>(9);
        i.left = j;
        i.right = m;
        j.left= k;
        j.right = l;
        k.left = n;
        m.left = p;
        m.right = o;
        System.out.println(completeUntilLevel(i,0));

    }
}
