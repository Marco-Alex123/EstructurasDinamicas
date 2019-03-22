

package tree;

import tree.TreePrinter;
import Excepciones.isEmptyException;
import Node.Node;
import java.util.logging.Level;
import java.util.logging.Logger;
import tree.Tree;

public class Btree<T extends Comparable<T>> implements Tree<T> {
    
    private Node<T> groot;   
    private int altura;
    
    
    
    
    public Btree(T value){
        groot = new Node<> (value);
        groot.setLevel(0);
        groot.setContador(0);
    }
    
    public Btree(Node<T> node){
        groot = node;
        groot.setLevel(0);
        groot.setContador(0);
    }
    
     public Btree() {
        groot = new Node<>();
    }

    @Override
    public boolean add(T value) {
        if(groot == null){             
            groot = new Node<>(value);
            return true;
        }
        
        if(value == null){
            return false;
        }else{
            if(groot.getValue() ==null){
                groot.setValue(value);
                return true;
            }else{
                if(add(groot, value,groot.getLevel()) != null)
                    return true;
                else
                    return false;
            }
        }
    }

    private Node<T> add(Node root, T value, long level) {
        if(root == null){
            root = new Node<> (value);
            root.setLevel(level);
            root.setContador(0);
            return root;
        }else{
            if(root.getValue().compareTo(value)==0){
                root.setContador(root.getContador()+1);
            }else if(root.getValue().compareTo(value)==1){ 
                root.setLeft(add(root.getLeft(),value,level+1));
            }else{
                root.setRight(add(root.getRight(),value,level+1));
            }
            return root;
        }
    }

    @Override
    public boolean add(Node<T> node) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    public String toString (){
        return TreePrinter.getTreeDisplay(groot);
    }
    
    public static void fill (Btree arbol, int n, int m) {  
        for (int i = 0; i < 20; i++) {
            arbol.add((int)Math.abs(Math.floor(Math.random()*(n-m+1)+m)));
        }
        
    }
    
    @Override
    public boolean remove(T value) {
        Node<T> tmp;
        boolean opc;
        try {
            if ( (tmp = search(value)) != null){
                //return remove(tmp);
                if ( (opc = remove(tmp)) == true) levelUpdate();
                return opc;
            }
        } catch (isEmptyException ex) {
            Logger.getLogger(Btree.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    private boolean remove (Node<T> rem){    
        
        if(rem.getContador() > 0){
            rem.setContador(rem.getContador()-1);
            try {
                levelUpdate();
            } catch (isEmptyException ex) {
                Logger.getLogger(Btree.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
        }
        Node<T> father = hasFather(rem,groot, null);
        
        
            try {
                if(father == null){                                
                    if(groot.getRight() != null){
                        Node<T> minor = minor(groot.getRight());
                        minor.setLeft(groot.getLeft());
                        groot = groot.getRight();
                    }else{
                        groot = groot.getLeft();
                    }
                    System.gc();
                        return true;
                }
                if (rem.getLeft() == null && rem.getRight() == null){    
                    if(rem.getValue().compareTo(father.getValue()) > 0 )
                        father.setRight(null);
                    else
                        father.setLeft(null);
                    return true;
                }
                if (rem.getRight() != null && rem.getLeft() == null){       
                    if(rem.getValue().compareTo(father.getValue()) > 0 )
                        father.setRight(rem.getRight());
                    else
                        father.setLeft(rem.getRight());
                }
                if (rem.getRight() != null && rem.getLeft() == null){       
                    if(rem.getValue().compareTo(father.getValue()) > 0 )
                        father.setRight(rem.getLeft());
                    else
                        father.setLeft(rem.getLeft());
                }else{
                    Node<T> minor = minor(rem.getRight());
                    minor.setLeft(rem.getLeft());
                    father.setRight(minor);
                    father.setLeft(null);
                    System.gc();
                    return true;
                }
                
            } catch (isEmptyException ex) {
                Logger.getLogger(Btree.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return false;
    }
    
    private Node<T> hasFather(Node<T> value, Node<T> root, Node<T> father){
        if(value.getValue().equals(root.getValue()))
            return father;
        if (value.getValue().compareTo(root.getValue()) <= -1)
            return hasFather(value, root.getLeft(), root);
        else
            return hasFather(value, root.getRight(), root);
    
    }
    
    @Override
    public void isEmpty() throws isEmptyException {
        if(groot == null)
            throw new isEmptyException("Empty tree");
    }

    @Override
    public Node<T> search(T value) throws isEmptyException {
        return search(value, groot);
    }
    
    private Node<T> search (T value, Node <T> root){
        if (root == null)
            return null;
        else{
            if (value.compareTo(root.getValue()) == 0){
                return root;
            }else{
                return value.compareTo(root.getValue())<0?search(value,root.getLeft()):search(value, root.getRight());
            }
        }
    }
    

    @Override
    public T depthfirstsearch(T value) throws isEmptyException {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void balance() throws isEmptyException {     
        throw new UnsupportedOperationException("Not supported yet."); //NO SE PUEDE
    }

     @Override
    public T biggest() {
        return biggest(groot);
    }

    private T biggest(Node<T> node) {
        return node.getRight() == null ? node.getValue() : biggest(node.getRight());
    }
    

    @Override
    public T minor() throws isEmptyException {
        return minor (groot).getValue();
    }

    @Override
    public Node<T> minor(Node<T> node) throws isEmptyException {
        if (node.getLeft() == null)
            return node;
        else
            return minor(node.getLeft());
    }
    
    @Override
    public void preorder() throws isEmptyException {    
        preorder(groot);
    }
    
    private void preorder(Node<T> root){
        if(root != null){
            System.out.print(root.getValue()+"{"+root.getLevel()+","+root.getContador()+"} ");
            preorder(root.getLeft());
            preorder(root.getRight());
        }
    }

    @Override
    public void inorder() throws isEmptyException {     
        inorder(groot);
    }
    
    private void inorder(Node<T> root){
        if(root != null){
            inorder(root.getLeft());
            System.out.print(root.getValue()+"{"+root.getLevel()+","+root.getContador()+"} ");
            inorder(root.getRight());
        }
    }

    @Override
    public void postorder() throws isEmptyException {   
        postorder(groot);
    }
    
    private void postorder(Node<T> root){
        if(root != null){
            postorder(root.getLeft());
            postorder(root.getRight());
            System.out.print(root.getValue()+"{"+root.getLevel()+","+root.getContador()+"} ");
            
        }
    }

    @Override
    public int height() throws isEmptyException {
        altura=0;
        height(groot,1);
        return altura;
    }
    
    private void height(Node reco, int nivel){
        if(reco != null){
            //reco.setLevel(nivel-1);
            height (reco.getLeft(), nivel+1);
            if(nivel>altura)
                altura=nivel;
            //reco.setLevel(nivel-1);
            height(reco.getRight(),nivel+1);
        }
    }

    @Override
    public int width() throws isEmptyException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  @Override
    public int between(T start, T end) {
        return getCount(groot, start, end);}
      private int getCount(Node<T> node, T low, T high) {
        if (node == null) 
        {return 0;}
        
        if (node.getValue().compareTo(low) > 0 || node.getValue().equals(low)
                
                &&node.getValue().compareTo(high) < 0 || node.getValue().equals(high)) {
            return 1 + this.getCount(node.getLeft(), low, high)
                    + this.getCount(node.getRight(), low, high);
        } else 
            if (node.getValue().compareTo(low) < 0) {
            return this.getCount(node.getRight(), low, high);
        } else {
           return this.getCount(node.getLeft(), low, high);}
    }
    
    @Override
    public void levelUpdate() throws isEmptyException {
        altura=0;
        try{
            isEmpty();
            levelUpdate(groot,0);
        }catch(Exception e){
            
        }
    }
    
    /*
    private void levelUpdate (Node reco, int nivel){
        if(reco != null){
            reco.setLevel(nivel-1);
            height (reco.getLeft(),nivel+1);
            if(nivel>altura)
                altura=nivel;
            reco.setLevel(nivel-1);
            height(reco.getRight(),nivel+1);
        }
    }
    */
    
    
    private void levelUpdate (Node root, long lvl){
        if (root.getLevel() != lvl)
            root.setLevel(lvl);
        if (root.getLeft() != null)
            levelUpdate(root.getLeft(), lvl+1);
        if (root.getRight() != null)
            levelUpdate(root.getRight(), lvl+1);
    }
    
    
    
    
    

    

    public static void main(String[] args) throws isEmptyException {
        
        Btree<Integer> arbol = new Btree<>(6);
        
        arbol.add(9);
        arbol.add(6);
        arbol.add(13);
        arbol.add(5);
        arbol.add(4);
        arbol.add(7);
        arbol.add(8);
        arbol.add(10);
        arbol.add(11);
        arbol.add(15);
        
        System.out.println("Preorder:");
        arbol.preorder();
        System.out.println();
        System.out.println("-----------------------------");
        System.out.println("Postorder:");
        arbol.postorder();
        System.out.println();
        System.out.println("-----------------------------");
        System.out.println("Inorder:");
        arbol.inorder();
        
        arbol.remove(8);        
        System.out.println();
        System.out.println("------------------------------------------");
        System.out.println("Inorder despues de borrar:");
        arbol.inorder();
        System.out.println();
        
        System.out.println("altura del arbol:"+arbol.height());
        System.out.println("\n"+arbol);
        arbol.remove(11);
        System.out.println("altura del arbol:"+arbol.height());
        System.out.println("\n"+arbol);
    
    }

    
    
}
