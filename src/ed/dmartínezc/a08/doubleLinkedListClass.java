/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.dmartínezc.a08;

/**
 *
 * @author danx_
 */
public class doubleLinkedListClass<T> {

    //Atributos
    private nodeClass first;
    private nodeClass last;

    //Methods
    //Constructor
    public doubleLinkedListClass() {

    }

    /**
     * Inserta un nodo al inicio de la list
     *
     * @param data generic type, contiene informacion que se desea guardar
     */
    public void insertFirst(T data) {
        nodeClass node = new nodeClass(data);
        if (isEmpty()) {
            first = node;
            last = node;
        } else {//Si la lista tiene elementos
            node.next = first; //El apuntador "next" del nuevo nodo apunta al primer nodo de la lista
            first.prev = node; //El apuntador "prev" del primer nodo de la lista, apunta al nuevo nodo
            first = node; //El apuntador first se cambia al nuevo nodo
        }
    }

    public void insertLast(T data) {
        nodeClass node = new nodeClass(data);
        if (isEmpty()) {
            first = node;
            last = node;
        } else { //Si la lista tiene elementos
            node.prev = last;
            last.next = node;
            last = node;
        }
    }

    private boolean isEmpty() {
        return (first == null && last == null);
    }

    private nodeClass searchNode(T data) {
        nodeClass aux;
        System.out.print("El nodo con la informacion '" + data + "' fue borrado: ");
        if (isEmpty()) {
            return null; //Si esta vacio regresa vacio
        } else { //Si contiene elementos
            aux = first; //Se inicializa el auxiliar al principio de la lista
            while (aux.data != data && aux != null) { //Mientras que no se encuentre el dato, o no llegue al final de la lista
                try {
                    aux = aux.next;
                } catch (NullPointerException e) {
                    return null;
                }
            }
            if (aux.data == data) { //Se retorna el apuntador si lo que contiene es igual
                return aux;
            } else {//Se retorna nulo si no es lo mismo
                return null;
            }
        }
    }

    public boolean eNode(T data) {
        nodeClass aux = searchNode(data);
        if (aux == null) {
            System.out.println("No se encontro el nodo");
            return false;
        } else if (aux == first) {
            eNodeFirst();
        } else if (aux == last) {
            eNodeLast();
        } else {
            aux.next.prev = aux.prev;
            aux.prev.next = aux.next;
        }
        return true;
    }

    public void eNodeFirst() { //Corremos el primero un espacio adelante
        first = first.next;
        first.prev = null;
    }

    public void eNodeLast() { //Corremos el ultimo un espacio atras
        last = last.prev;
        last.next = null;
    }

    public void showList() {
        if (isEmpty()) {
            System.out.println("☠");
        } else {
            nodeClass aux = first;
            while (aux != null) {
                System.out.print("[" + aux.data + "] ");
                aux = aux.next;
            }
            System.out.println("");
        }
    }
    
    public void showListReverted() {
        if (isEmpty()) {
            System.out.println("☠");
        } else {
            nodeClass aux = last;
            while (aux != null) {
                System.out.print("[" + aux.data +"] ");
                aux = aux.prev;
            }
            System.out.println("");
        }
    }
}
