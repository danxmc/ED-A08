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
public class EDDMartínezCA08 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        doubleLinkedListClass Lista = new doubleLinkedListClass();
        Lista.insertFirst('O');
        Lista.insertFirst('L');
        Lista.insertFirst('L');
        Lista.insertFirst('A');
        Lista.insertFirst('H');
        Lista.insertLast(100);
        Lista.showList();
        Lista.eNodeFirst();
        Lista.showList();
        Lista.eNodeLast();
        Lista.showList();
        Lista.showListReverted();
    }
    
}
