

package stackArray;

import Excepciones.isEmptyException;
import Excepciones.isFullException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import stack.Stack;

public class StackArray<T extends Comparable<T>> implements Stack<T>, Iterable<T>, Comparable<StackArray>, Comparator<StackArray> {

    private T[]         stack = null;
    private Class<T>    type = null;
    private long        capacity; 
    private int         tope = -1;             

    public StackArray(Class<T> clazz) {
        this(clazz, 20);
    }

    public StackArray(Class<T> clazz, int capacity) {
        this.type = clazz;
        this.capacity = capacity;
        stack = (T[]) Array.newInstance(clazz, capacity);
    }

    @Override
    public long size() {
        return tope + 1;
    }       

    @Override
    public void isempty() throws isEmptyException {
        if (tope < 0) 
            throw new isEmptyException("Empty stack");
    }       

    @Override
    public void isfull() throws isFullException {
        if (tope == (capacity - 1)) {
            throw new isFullException("Full stack");
        }
    }       

    private boolean resize() {
        Scanner leer = new Scanner(System.in);
        String opc;

        System.out.println("¿Desea incrementar el tamaño del arreglo? si/no");
        opc = leer.next();
        if (opc.toLowerCase().equals("s") || opc.toLowerCase().equals("si")) {
            stack = Arrays.copyOf(stack, stack.length + 1);
            capacity++;
            return true;
        }
        return false;

    }

    @Override
    public void push(T value) throws isFullException {
        boolean flag = true;
        try {
            isfull();
            
        } catch (isFullException e) {
            System.err.println(e.getMessage());
            flag = resize();
        }finally{
            if(flag)
                stack[++tope] = value;          
                
        }
        //if (stack[++tope] = value;
    }         

    @Override
    public T pop() throws isEmptyException {
        try {
            isempty();
        } catch (Exception e) {
            throw new isEmptyException("Empty stack");
        }
        return stack[tope--];
    }        

    @Override
    public T peek() throws isEmptyException {
        try {
            isempty();
        } catch (Exception e) {
            throw new isEmptyException(e.getMessage());
        }
        return stack[tope];
    }          

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int _tope = tope;       
            
            @Override
            public boolean hasNext() {
                return (_tope!= -1)?true:false;
            }

            @Override
            public T next() {
                return stack[_tope--];
            }
        };
    }
    
    @Override
    public int compareTo(StackArray arg0) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public int compare(StackArray arg0, StackArray arg1) {
        return 0;//if (o1.compareTo )
    }
    

    public static void main (String [] args){
        StackArray<Double> pilaDobles = new StackArray (Double.class,3);
        StackArray<Double> stackD = new StackArray (Double.class,3);
        
        try {
            pilaDobles.push(32d);
            pilaDobles.push(-1d);
            pilaDobles.push(23d);
            pilaDobles.push(23d);
            //pilaDobles.pop();
            
            System.out.println("El ultimo valor ingresado es "+pilaDobles.peek());
            System.out.print("[ ");
            
            //if(stackD.compareTo(pilasDobles) ≤ 20)
            
            
            
            
            
            for (Double object : pilaDobles) {
                System.out.print(object+" ");
            }
            System.out.println(" ]");
            //System.out.println("Sacando el valor "+pilaDobles.pop());
        } catch (isEmptyException | isFullException e) {
            System.err.println(""+e.getMessage());
        }
        
        
        
    }

    

}
