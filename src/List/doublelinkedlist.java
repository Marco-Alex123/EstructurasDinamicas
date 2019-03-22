

package List;

import Excepciones.isEmptyException;
import Node.Node;
import java.util.Iterator;


public class doublelinkedlist <T extends Comparable <T>> implements Iterable <T>, Comparable <T>{   
    
    private Node<T> head,tail;
    private long lenght;
    
    public doublelinkedlist(){
        head = new Node<>();
        tail = new Node<>();
        lenght = 0;
    }
    
    public doublelinkedlist (T value){
        this();
        Node<T> _new = new Node<> (value);
        head.setNext(_new);
        tail.setBack(_new);
        lenght++;
    }
    
    public doublelinkedlist (Node<T> node){
        this(node.getValue());
    }
    
    public boolean add (T value) { 
        Node<T> _new = new Node<>(value);
        if(_new == null) return false;
        try {
            isEmpty();
            Node<T> tmp = tail.getBack();
            tmp.setNext(_new);
            _new.setBack(tmp);
            tail.setBack(_new);
            
        } catch (isEmptyException ee) {
            head.setNext(_new);
            tail.setBack(_new);
            
        }
        lenght++;
        return true;

    }
    
    public  boolean add(Node<T> node) { return add (node.getValue());}
    
    private Node<T> isThereNode(Node<T> node, T value) {
        if (node.getNext() == null) {
            return null;
        } else if (node.getNext().getValue().equals(value)) {
            return node;
        }
        return isThereNode(node.getNext(), value);
    }
    
    private boolean isThere(Node<T> node, T value) {
        if (node.getNext() == null) {
            return false;
        } else if (node.getNext().getValue().equals(value)) {
            return true;
        }
        return isThere(node.getNext(), value);
    }
    
    public  boolean removeAll1 (T value) { 
        
        boolean flag = false;

        try {
            isEmpty();
            while (isThere(head, value)) {
                remove(value);
                flag = true;
            }
            return flag;
        } catch (isEmptyException e) {
            return flag;
        }
        
        
    }
    
    public  boolean removeAll2 (T value) { 
        
        while (remove(value));
        return true;
    }
    
    private Node<T> getPrevElement(Node<T> node, T value) {
        if (node.getNext() == null) {
            return null;
        }
        if (node.getNext().getValue().equals(value)) {
            return node;
        } else {
            return getPrevElement(node.getNext(), value);
        }
    }
    
    //
    public  boolean remove (T value) { 
        try {
            isEmpty();
            Node<T> tmp = getPrevElement(head, value);
            if (tmp != null) {
                
                if(tmp.getNext().getNext() == null && tmp.getNext().getBack() == null){ 
                    head.setNext(null);
                    tail.setBack(null);                    
                } else if(tmp.getNext().getBack() == null){                           
                    tmp.getNext().getNext().setBack(null);
                    head.setNext(tmp.getNext().getNext());
                }else if(tmp.getNext().getNext() == null){                              
                    tmp.setNext(null);
                    tail.setBack(tmp);
                }else{                                                                  
                    tmp.setNext(tmp.getNext().getNext());
                    tmp.getNext().setBack(tmp);
                }
                lenght--;
                System.gc();
                return true;
            } else {
                return false;
            }

        } catch (isEmptyException e) {
            return false;
        }
    }
    
    public  boolean remove (Node <T> node) { 
        return remove(node.getValue());
    }
  /*  @Override
    public  boolean addAt (T after, T value) {
        try{
            isEmpty();
            Node<T> _new = new Node<>(value);
            Node<T> prev = isThereNode(head, after);
            if(prev != null){
                if(prev.getNext() == null){
                    prev.setNext(_new);
                    tail.setPrev(_new);
                    _new.setNext(null);
                } else {
                    Node<T> next = prev.getNext();
                    prev.setNext(_new);
                    _new.setPrev(prev);
                    _new.setNext(next);
                    next.setPrev(_new);
                }
                lenght++;
                return true;
            } else {
                return false;
            }
        } catch (isEmptyException e){
            return false;
        }
    
    }*/
    
    
    
    public  boolean addAt (Node<T> node, int position) { 
        return false;
    //return addAt(position, node.getValue());
    
    
    }   
    public  boolean addAfter(T after, T value) {
     try{
            isEmpty();
            Node<T> _new = new Node<>(value);
            Node<T> prev = isThereNode(head, after);
            if(prev != null){
                if(prev.getNext() == null){
                    prev.setNext(_new);
                    tail.setValue(after);
                    _new.setNext(null);
                } else {
                    Node<T> next = prev.getNext();
                    prev.setNext(_new);
                    _new.setValue(value);
                    _new.setNext(next);
                    next.setValue(after);
                }
                lenght++;
                return true;
            } else {
                return false;
            }
        } catch (isEmptyException e){
            return false;
        }
    
    }     
    
    public  boolean addBefore(T before, T value) { 
        try{
            isEmpty();
            Node<T> tmp= isThereNode(head, before);
            if (tmp == null){
                return false;
            }else{
                Node<T> _node = new Node<T>(value); 
                if (tmp.getBack() == null){ 
                    tmp.setBack(_node);
                    head.setNext(_node);
                    _node.setNext(tmp);
                    //_node.setBack(null);
                }else{  
                    tmp.getBack().setNext(_node);
                    _node.setBack(tmp.getBack());
                    tmp.setBack(_node);
                    _node.setNext(tmp);    
                }
            }
            lenght++; 
            return true;
        }catch(isEmptyException w){
            return false;
        }
    }     
    
    public  boolean removeAfter(T value) { 
        try{
            isEmpty();
            Node<T> tmp=isThereNode (head,value);
            if(tmp != null && tmp.getNext() != null)
                return removeFrom(tmp.getNext());
            else
                return false;
                       
        }catch(isEmptyException e){
            return false;
        }
        
        
    }      
    
    private boolean removeFrom (Node<T> node){
        Node<T> tmp= node;
        if(tmp.getNext() == null)
            return false;
        else{
            if(tmp.getNext().getNext() == null){
                tmp.setNext(null);
                tail.setBack(tmp);
                return true;
            }else{
                tmp.setNext((tmp.getNext().getNext()));
                tmp.getNext().setBack(tmp);
                
            }
            return true;
        }
            
    }
    public  boolean removeBefore(T before, T value) {
        return false;
       // try{
            //isEmpty();
            //Node<T> _new = new Node<>(value);
            //Node<T> next = isThereNode(head, before);
           // if(next.getPrev() == null){
              //  head.setNext(_new);
                //_new.setNext(next);
                //next.setPrev(_new);
            //} else {
                //Node<T> prev = next.getPrev();
               // prev.setNext(_new);
                //_new.setPrev(prev);
                //_new.setNext(next);
               // next.setPrev(_new);
           // }
            //lenght++;
            //return true;
       // } catch (isEmptyException e){
            //return false;
    //}
}
    public  boolean addStart(T value) { Node<T> _new = new Node<>(value);
        try {
            isEmpty();
            Node<T> next = head.getNext();
            head.setNext(_new);
            _new.setNext(next);
            //next.setPrev(_new);
        } catch (isEmptyException e) {
            head.setNext(_new);
            //tail.setPrev(_new);
        }
        lenght++;
        return true;}      
    public  boolean addStart(Node<T> node) { 
        return addStart(node.getValue());}
    
    public Node<T> getElementAt(int value) {
        return getElementAt(head, 0, value);
    }

    private Node<T> getElementAt(Node<T> node, int index, int value) {
        if (node.getNext() == null) {
            return null;
        } else {
            if (value == index) {
                return node.getNext();
            } else {
                if (index >= value) {
                    return null;
                } else {
                    return getElementAt(node.getNext(), ++index, value);
                }
            }
        }
    } 
    
    public boolean isEmpty() throws isEmptyException {  
        if (head.getNext() == null) {
            throw new isEmptyException("La lista esta vacia");
        } else {
            return true;
        }
    }
    
    public long length(){ return this.length();}
    
    public void rprint(){
        rprint(tail);
    }
    
    private void rprint(Node<T> node){
        if (node.getBack() == null)
            return;
        else 
            System.out.println(node.getBack().getValue());
        rprint(node.getBack());
    }

    @Override
    public Iterator<T> iterator() {
       return new Iterator<T>() {
            Node<T> cpy = head.getNext(), sub_head;

            @Override
            public boolean hasNext() {
                if (cpy == null) {
                    return false;
                } else {
                    sub_head = cpy;
                    cpy = cpy.getNext();
                    return true;

                }

            }

            @Override
            public T next() {
                return sub_head.getValue();
            }
        }; 
    }

    @Override
    public int compareTo(T o) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
   public void setLenght(int lenght) {
        this.lenght = lenght;
    }
}

    

