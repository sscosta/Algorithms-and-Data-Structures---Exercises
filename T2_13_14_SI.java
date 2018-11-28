package testessemestresanteriores;

import series.serie3.planningsubwaytrip.model.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class T2_13_14_SI {


    public static void main(String[]args){
        List<String> a = new ArrayList<>(Arrays.asList("aaa","abc","aed","aed","afd"));
        Iterable<Pair<String,Integer>> ge = groupingEquals(a);
        Iterator <Pair<String,Integer>> it = ge.iterator();
        while(it.hasNext()) {
            Pair<String,Integer> p = it.next();
            System.out.println(p.getKey() + "" +p.getValue());
        }
    }


    public static Iterable<Pair<String,Integer>> groupingEquals(Iterable<String> words){
        return new Iterable<Pair<String, Integer>>() {
            @Override
            public Iterator<Pair<String, Integer>> iterator() {
                return new Iterator<Pair<String, Integer>>() {
                    Iterator <String> it = words.iterator();
                    String curr,prev;
                    Integer count =0;
                    Pair<String,Integer> p;
                    @Override
                    public boolean hasNext() {
                        if(p!=null)return true;
                        while(it.hasNext()){
                            curr = it.next();
                            if(prev==null || curr.compareTo(prev)==0) {
                                count++;
                                prev = curr;
                            }
                            else {
                                p= new Pair<>(prev,count);
                                prev = curr;
                                return true;
                            }
                        }
                        return false;
                    }

                    @Override
                    public Pair<String, Integer> next() {
                        Pair<String,Integer> aux = p;
                        p = null;
                        count =1;
                        return aux;
                    }
                };
            }
        };
    }
}
