/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package SingletonPattern;

/**
 *
 * @author admin
 */
public class Main {
    public static void main(String[] args) {

        SingleObject obj=SingleObject.getInstance();
//        SingleObject obj2=new SingleObject();
        obj.showMessage();
    }

}
