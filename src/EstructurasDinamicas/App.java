
package EstructurasDinamicas;

import List.LinkedList;
import List.doublelinkedlist;
import Node.Node;

public class App {

    //static LinkedList <Double> dobles = new LinkedList<>();
    static doublelinkedlist <Double> dobles = new doublelinkedlist<>();
    
    
    public static void fill(int n, int m){
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dobles.add((Double)Math.abs(Math.floor(Math.random()*(n-m+1)+m)));
            }
            
        }
    }
    
    public static void main(String[] args) {
        
        
        
        //LinkedList<Double> dobles = new LinkedList<>();
        
        dobles.add(370d);
        dobles.add(9d);
        dobles.add(18d);
        dobles.add(26d);
        dobles.add(26d);
        dobles.add(43d);
        dobles.add(43d);
        dobles.add(370d);
        dobles.add(26d);
        dobles.add(19d);
        dobles.add(370d);
        //dobles.removeAll1(26d);
        dobles.addBefore(370d,10d);
        //while (dobles.removeAfter(26d));
        //dobles.removeAll1(26d);
        //dobles.removeAll2(370d);
        //dobles.remove(18d);
        //dobles.addAfter(18d,18d);
        //dobles.rprint();
        /*
        if(dobles.removeBefore(461d))
            System.out.println("Se borro el valor");
        else
            System.out.println("No se puede");
        */
        //dobles.remove(50d);
        //dobles.removeAll(9d);
        
        
        //Node<Double> nodo = new Node<Double>();
        //nodo.setValue(18d);
        //dobles.add(nodo);
        
        //fill(1,2000);
        
        for (Double object : dobles) {      
            System.out.println(object);
        }
        
        
        
    }
    
}
