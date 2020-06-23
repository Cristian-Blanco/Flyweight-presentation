/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package factory;
import java.util.ArrayList;
import java.util.List;
import weight.Coffee;
import weight.ICoffee;
/**
 *
 * @author jackl
 */
public class CoffeeFactory {
     private ArrayList<ICoffee> cafe;
     public static boolean existance;
     public CoffeeFactory(){
         this.cafe = new ArrayList<ICoffee>();
     }

    public ICoffee getCafe(String productName) {
        for(ICoffee coffee:this.cafe){
            if(coffee.getProductName().equals(productName)){
                CoffeeFactory.existance=true;
                return coffee;
            }
        }
        CoffeeFactory.existance=false;
        ICoffee cafes = new Coffee(productName);
        this.cafe.add(cafes);
        return cafes;
    }
     
}
