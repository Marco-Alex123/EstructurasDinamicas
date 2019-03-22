

package stackDoubleList;

import Excepciones.isEmptyException;
import Excepciones.isFullException;
import List.doublelinkedlist;
import java.util.Comparator;
import java.util.Iterator;
import stack.Stack;


public class stackDoubleList<T> implements Stack<T>, Comparable <stackDoubleList>,Comparator <stackDoubleList>, Iterable<T>{
    
    //doublelinkedlist<T> pila;
    
    @Override
    public long size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void isempty() throws isEmptyException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void isfull() throws isFullException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void push(T value) throws isFullException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T pop() throws isEmptyException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T peek() throws isEmptyException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int compareTo(stackDoubleList arg0) {
        return 0;/*for (T object : o){
            
        }*/
    }

    @Override
    public int compare(stackDoubleList arg0, stackDoubleList arg1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
