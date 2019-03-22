
package tree;


import Excepciones.*;
import Node.Node;

public interface Tree<T extends Comparable<T>> {
    
    public boolean  add                 (T value);
    public boolean  add                 (Node<T> node);
    public boolean  remove              (T value);
    public void     isEmpty             ()                  throws isEmptyException;
    public Node<T>  search              (T value)           throws isEmptyException;
    public T        depthfirstsearch    (T value)           throws isEmptyException;
    
    public void     balance             ()                  throws isEmptyException;
    public void     levelUpdate         ()                  throws isEmptyException;
    
    public T        biggest             ()                  throws isEmptyException;
    public T        minor               ()                  throws isEmptyException;
    public Node<T>  minor               (Node<T> node)      throws isEmptyException;
    
    public void     preorder            ()                  throws isEmptyException;
    public void     inorder             ()                  throws isEmptyException;
    public void     postorder           ()                  throws isEmptyException;
    
    public int      height              ()                  throws isEmptyException;
    public int      width               ()                  throws isEmptyException;
    public int      between             (T start, T end)    throws isEmptyException;   
    
    
    
}
