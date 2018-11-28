package testessemestresanteriores;

import java.util.Iterator;

public class T2_17_18_SI {
    public static <E> Iterable<E> getEqualsAtSamePosition(Iterable<E> src1,Iterable<E> src2){
        return new Iterable<E>(){
          public Iterator<E> iterator(){
              return new Iterator<E>(){
                  E curr;
                  Iterator<E> it1 = src1.iterator();
                  Iterator<E> it2 = src2.iterator();
                  @Override
                  public boolean hasNext(){
                      if(curr!=null) return true;
                      if(!it1.hasNext()||!it2.hasNext())return false;
                      E e1 = it1.next();
                      E e2 = it2.next();
                      while(e1!=e2 && it1.hasNext() && it2.hasNext()){
                          e1=it1.next();
                          e2=it2.next();
                      }
                      //last can be equal
                      if(e1==e2){
                          curr=e1;
                          return true;
                      }
                      return false;
                  }
                  @Override
                  public E next(){
                      E aux = curr;
                      curr=null;
                      return aux;
                  }
              };
          }
        };
    }
    public static <E> boolean equalLeavesCountInSubTrees(Node<E> root){
       return countLeaves(root.left)==countLeaves(root.right);
    }

    private static <E> int countLeaves (Node<E> root){
        if(root==null)return 0;
        if(root.left==null && root.right==null) return 1;
        return countLeaves(root.left)+countLeaves(root.left);
    }

    public static void main(String[] args) {
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
        System.out.println(equalLeavesCountInSubTrees(i));

        Node<Integer> a = new Node<>(1);
        Node<Integer> b = new Node<>(2);
        Node<Integer> c = new Node<>(3);
        Node<Integer> d = new Node<>(4);
        Node<Integer> e = new Node<>(5);
        Node<Integer> f = new Node<>(6);
        Node<Integer> h = new Node<>(8);
        a.left=b;
        a.right=c;
        b.right=d;
        b.left=e;
        c.right=f;
        c.left=h;
        System.out.println(equalLeavesCountInSubTrees(a));
    }
}
