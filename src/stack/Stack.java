

package stack;

import Excepciones.isEmptyException;
import Excepciones.isFullException;


public interface Stack<T>{
    
    public long size();                                         
    public void isempty()       throws isEmptyException;        
    public void isfull()        throws isFullException;         
    public void push(T value)   throws isFullException;         
    public T    pop()           throws isEmptyException;
    public T    peek()          throws isEmptyException;
    
}
