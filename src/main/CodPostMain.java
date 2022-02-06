/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import entity.CodPostEntity;
import implement.CodPostServiceImplement;

/**
 *
 * @author Anita
 */
public class CodPostMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        CodPostServiceImplement newService = new CodPostServiceImplement();
        newService.menu();
        
       

    }
    
}
