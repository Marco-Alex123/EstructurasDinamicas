
package queue;
import Excepciones.*;


public interface Queue<T> {
    
    public  boolean enqueque (T value)  throws isFullException;     
    public  T       dequeque ()         throws isEmptyException;
    public  boolean removeAll()         throws isEmptyException;
    public  void    isfull()            throws isFullException;
    public  void    isempty()           throws isEmptyException;
    public  T       front()             throws isEmptyException;    
    public  T       last()              throws isEmptyException;     
    
    
    
    
}
