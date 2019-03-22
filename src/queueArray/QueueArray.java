

package queueArray;

import Excepciones.isEmptyException;
import Excepciones.isFullException;
import java.lang.reflect.Array;
import java.util.Iterator;
import queue.Queue;


public class QueueArray<T> implements Queue<T>, Iterable<T> {
    
    private T[]         queue;
    private int         size;               
    private int         front   =   -1;     
    private int         back    =   0;      
    private int         count   =   0;      
    private Class<T>    type    =   null;   
    
    
    public QueueArray(Class<T> type, int size){
        this.type   = type;
        this.size   = size;
        this.queue  = (T[]) Array.newInstance(type, size);
    }
    
    public QueueArray (Class<T> type){
        this (type,10);
    }

    @Override
    public boolean enqueque(T value) throws isFullException {
        try {
            isfull();
            queue[back++ % size] = value;   
            count ++;  
            return true;
        } catch (isFullException e) {
            System.err.println("Full Queue");
            return false;
        }
        
    }     

    @Override
    public T dequeque() throws isEmptyException {
        try {
            isempty();
            count--;
            return queue[++front % size];
        } catch (isEmptyException e) {
            System.err.println("Empty Queue");
            return null;
        }
    }

    @Override
    public boolean removeAll() throws isEmptyException {
        front = -1;
        back  =  0;
        count =  0;
        return true;
    }

    @Override
    public void isfull() throws isFullException {
        if (count == size)
            throw new isFullException("Full Queue");
    }
    
    @Override
    public void isempty() throws isEmptyException {
        if (count == 0)
            throw new isEmptyException("Empty Queue");
    }
    

    @Override
    public T front() throws isEmptyException {
        return queue[(front + 1) %size];
    }

    @Override
    public T last() throws isEmptyException {
        return queue [(back - 1) % size];
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    
    public static void main(String[] args) {
        
        QueueArray<Double> enteros = new QueueArray<>(Double.class,4);
        
        try {
            enteros.enqueque(20d);
            enteros.enqueque(17d);
            enteros.enqueque(12d);
            System.err.println("Salio el valor: " + enteros.dequeque());
            enteros.enqueque(-40d);
            enteros.enqueque(15d);
            enteros.enqueque(-1d);
            System.out.println("El valor de Front es: " + enteros.front());
            System.out.println("El valor de Last es: " + enteros.last());
        
        } catch (isEmptyException | isFullException e) {
            System.err.println(e.getMessage());
        }
        
        
    }
    
}
