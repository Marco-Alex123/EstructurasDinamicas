
package Node;


public class Node <T extends Comparable <T>>{
    private T       value;
    private Node<T> next;
    private Node<T> back; 
    private long    contador=0;     

    public long getContador() {
        return contador;
    }

    public void setContador(long contador) {
        this.contador = contador;
    }

    public long getLevel() {
        return level;
    }

    public void setLevel(long level) {
        this.level = level;
    }
    private long    level=0;        
    public Node(T value,Node<T> next) {
        this.next = next;
        this.value= value;
    }
    
    public Node(T value,Node<T> next,Node<T> back) {
        this.next = next;
        this.value= value;
        this.back = back; 
    }
    
    public Node (){
        this.value = null;
        this.next= null;
        this.back = null; 
    }
    
    public Node (T value){
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node <T> getBack() {
        return back;
    }

    public void setBack(Node <T> back) {
        this.back = back;
    }
    
    public Node <T> getNext() {
        return next;
    }

    public void setNext(Node <T> next) {
        this.next = next;
    }

    public Node <T> getRight() {
        return next;
    }

    public void setRight(Node <T> back) {
        this.next = back;
    }
    
    public Node <T> getLeft() {
        return back;
    }

    public void setLeft(Node <T> back) {
        this.back = back;
    }
    
    public String getText(){
        return ""+this.getValue()+this.getContador()+this.getLevel();
    }
    
}
