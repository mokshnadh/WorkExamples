/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.bcu.cmp7038.jax;

import java.io.Serializable;

/**
 *
 * @author cmp7038User
 */
public class Car implements Serializable{
    private int carId = -1;
    private String carKey = "";

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getCarKey() {
        return carKey;
    }

    public void setCarKey(String carKey) {
        this.carKey = carKey;
    }        
}
