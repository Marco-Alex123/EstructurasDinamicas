

package priority;

import Excepciones.isEmptyException;
import Excepciones.isFullException;
import queueArray.QueueArray;

public class PriorityQueue {

    static QueueArray<Double>[] dobles = new QueueArray[5];

    enum prioridad { Muy_alta, Alta, Media, Baja, Muybaja };

    public static void insert(int prioridad, double dato) {
        try {
            dobles[prioridad].enqueque(dato);
        } catch (isFullException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void print(){
        for (QueueArray<Double> queueArray : dobles){
            try {
                queueArray.isempty();
                for(Double double1 : queueArray){
                    System.out.println("" + double1);
                }
            } catch (Exception e) {
                System.out.println("No existen elementos en esta prioridad");
            }
        }
    }

    /*
    public static void print(int i) {
        for (QueueArray<Double> queueArray : dobles) {
            try {
                queueArray.isempty();
                for (Double double1 : queueArray) {
                    System.out.println("" + double1);
                }
            } catch (Exception e) {
                System.out.println("No existen elementos en esta prioridad");
            }
        }
    }
    */
    
    public static void remove(int priority) {
        if (priority >= 0 && priority < dobles.length) {

            try {
                dobles[priority].isempty();
                System.out.println("Sacando los elementos de la prioridad: " + priority);
                System.out.println("La prioridad: " + prioridad.values()[priority]);
                System.out.println("" + dobles[priority].dequeque());

            } catch (isEmptyException e) {
                System.out.println("La prioridad: " + prioridad.values()[priority] + " esta vacia");
            }
        } else {
            System.out.println("¡Prioridad invalida!");
        }
    }

    public static void _init_() {
        for (int i = 0; i < dobles.length; i++) {
            dobles[i] = new QueueArray<>(Double.class, 4);
        }
    }

    public static void main(String[] args) {

        _init_();

        insert(prioridad.Alta.ordinal(), 7d);
        insert(prioridad.Muybaja.ordinal(), 3d);
        insert(prioridad.Media.ordinal(), 4d);
        insert(prioridad.Media.ordinal(), 5d);
        insert(prioridad.Baja.ordinal(), 6d);
        insert(prioridad.Muybaja.ordinal(), 6d);
        System.out.println("Removiendo de la prioridad muy alta");
        //remove(0);
        print();
    }

}
