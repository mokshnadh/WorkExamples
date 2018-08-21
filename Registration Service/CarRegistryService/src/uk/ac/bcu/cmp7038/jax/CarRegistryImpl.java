/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.bcu.cmp7038.jax;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import javax.jws.WebService;
/**
 *
 * @author cmp7038User
 */
@WebService(endpointInterface = "uk.ac.bcu.cmp7038.jax.CarRegistryInterface", serviceName = "CarRegistryService")
public class CarRegistryImpl {
    private HashMap<String, ArrayList<Car>> carReg = new HashMap<String, ArrayList<Car>>();
    
    public CarRegistryImpl(){
        Car car1 = new Car();
        car1.setCarId(19);
        car1.setCarKey("XCVB"); 

        
        Car car2 = new Car();
        car2.setCarId(21);
        car2.setCarKey("YMAZ");        
        ArrayList<Car> cars1 = new ArrayList<Car>();
        cars1.add(car1);
        cars1.add(car2);
                
        ArrayList<Car> cars2 = new ArrayList<Car>();
        Car car3 = new Car();
        car3.setCarId(13);
        car3.setCarKey("ZSDF");        
        cars2.add(car3);        
        
        Car car4 = new Car();
        car4.setCarId(15);
        car4.setCarKey("QWER");        
        cars2.add(car4);                        
        carReg.put("B1", cars1);
        carReg.put("B2", cars2);
        carReg.put("B3", new ArrayList<Car>());
        carReg.put("B4", new ArrayList<Car>());                
    }
    
    public boolean isAvailable(String code){
        boolean retVal = false;
        if(carReg.containsKey(code)){
            ArrayList<Car> cars = carReg.get(code);
            if(cars.size() > 0)
                retVal = true;
        }
        return retVal;
    }
    
    public Car getAvailableCar(String code){
        Car retCar = new Car();
        System.out.println("Searching in " + code);
        if(carReg.containsKey(code)){
            ArrayList<Car> cars = carReg.get(code);
            if(cars.size() > 0){
                Random rand = new Random();
                int n = rand.nextInt(cars.size());
                retCar = cars.get(n);
            }                                      
        }
        System.out.println("Found " + retCar.getCarKey());
        return retCar;
    }
}
