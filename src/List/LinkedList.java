

package List;

import Node.Node;
import java.util.Iterator;
import Excepciones.isEmptyException;

public class LinkedList<T extends Comparable<T>> implements Iterable<T> {

    private Node<T> head;
    private long lenght;

    public LinkedList(Node<T> _new) {
        this();
        this.head.setNext(_new);

    }

    public LinkedList() {
        this.head = new Node<>();
    }

    public boolean add(T value) {
        Node<T> _new = new Node<>(value);

        try {
            Node<T> tmp = null;
            isEmpty();
            tmp = getLastElement(this.head); 
            tmp.setNext(_new);
        } catch (isEmptyException e) {
            head.setNext(_new);
        }
        return false;
    }

    private Node<T> getLastElement(Node<T> tmp) {
        if (tmp.getNext() == null) {
            return tmp;
        }
        return getLastElement(tmp.getNext());
    }

    public boolean add(Node<T> node) {
        return add(node.getValue());
    }

    private boolean isThere(Node<T> node, T value) {
        if (node.getNext() == null) {
            return false;
        } else if (node.getNext().getValue().equals(value)) {
            return true;
        }
        return isThere(node.getNext(), value);
    }

    public boolean removeAll(T value) {
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

    /*
    public boolean removeAll(T value){
        while (remove (value));
        return true;
    }
    
     */
    public boolean remove(T value) {
        try {
            isEmpty();
            Node<T> tmp = getPrevElement(head, value);
            if (tmp != null) {
                tmp.setNext(tmp.getNext().getNext());
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

    public boolean remove(Node<T> node) {
        return remove(node.getValue());
    }

    public boolean removeAfter(T value) {
     try {
            isEmpty();
            if (isThere(head, value)) {
                return remove(getPrevElement(head, value).getNext());
            } else {
                return false;
            }
        } catch (isEmptyException e) {
            return false;
        }}

    public boolean removeBefore(T value) {
        try{
            isEmpty();
            if(isThere(head,value))
                return remove (getPrevElement(head, value));
            return false;
            
        }catch(isEmptyException e){
            return false;
        }
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

    public boolean addAt(int position, T value) {
        return false;
       // return addAt(position, value.getValue());}
    }

    public boolean addAt(T after, T value) {
     try {
            isEmpty();
            Node<T> _new, tmp;
            if ((tmp = getPrevElement(head, after)) != null) {
                _new = new Node<>(value);
                _new.setNext(tmp.getNext().getNext());
                tmp.getNext().setNext(_new);
                System.gc();
                lenght++;
                return true;
            } else {
                return false;
            }
        } catch (isEmptyException e) {
            return false;
        }}

    public boolean addAfter(T after, T value) {

        try {
            isEmpty();
            Node<T> tmp, _new;
            
            if ((tmp = getPrevElement(head, after))!= null) {
                _new = new Node<T>(value);
                _new.setNext(tmp.getNext().getNext());
                tmp.getNext().setNext(_new);
                System.gc();
                return true;
            }else
                return false;

        } catch (isEmptyException e) {
            return false;
        }

    }

    public boolean addBefore(T value) {return false;}

    public boolean addStart(T value) {
        Node<T> _new = new Node<>(value);

        try {
            isEmpty();
            Node<T> tmp = head.getNext();
            head.setNext(_new);
            _new.setNext(tmp);
            lenght++;
            return true;
        } catch (isEmptyException e) {
            head.setNext(_new);
            lenght++;
            return true;
        }

    }

    public boolean addStart(Node<T> node) {
        return addStart(node.getValue());
    }

    public Node<T> getElementAt(Node<T> node, int index, int value) {  
    
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
        }} 
    
    public boolean isEmpty() throws isEmptyException {  
        if (head.getNext() == null) {
            throw new isEmptyException("La lista esta vacia");
        } else {
            return true;
        }
    }

    public long lenght() {
        return this.lenght();
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

}
