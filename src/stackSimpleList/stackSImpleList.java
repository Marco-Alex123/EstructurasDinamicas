
package stackSimpleList;

import Excepciones.isEmptyException;
import Excepciones.isFullException;
import List.LinkedList;
import java.util.Comparator;
import java.util.Iterator;
import stack.Stack;

/**
 *
 * @author icarnegie14
 */
public class stackSImpleList<T> implements Stack<T>, Comparable <T>,Comparator <T>, Iterable<T> {
    
    //LinkedList <T> pila;

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
    public int compareTo(T arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int compare(T arg0, T arg1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
