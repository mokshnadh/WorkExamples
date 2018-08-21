/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.bcu.cmp7038.jax;

import javax.jws.WebService;
/**
 *
 * @author cmp7038User
 */
@WebService
public interface CarRegistryInterface {
     public boolean isAvailable(String code);
     public Car getAvailableCar(String code);
}
