
import entity.CodPostEntity;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import service.CodPostService;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Anita
 */
public class CodPostServiceImplement implements CodPostService {
    
    Scanner read;
    HashMap<Integer,CodPostEntity> codigosPostales;

    public CodPostServiceImplement() {
        this.read = new Scanner(System.in);
        this.codigosPostales = new HashMap<>();
    }
    
    
    @Override
    public CodPostEntity createNewCP(){
        
        CodPostEntity newCP = new CodPostEntity();
        
        System.out.println("");
        newCP.setCodigoPostal(read.nextInt());
        
        System.out.println("");
        newCP.setCiudad(read.next());
        
        return newCP;
    }
    
    @Override
    public String addToTheMap(Integer codPost, CodPostEntity newCP){
        
        
        codigosPostales.put(codPost,newCP);
        String createdElement= "Element added : ";
        for (Map.Entry<Integer, CodPostEntity> unitaryCP : codigosPostales.entrySet()) {
            if (unitaryCP.getKey() == codPost) {
                createdElement = unitaryCP.toString();
            }
            
        }
        
        return createdElement;
    }
    
    @Override
    public String showAllCp(){
        
        String listedElements = "The listed elements are : \n";
        
        for (Map.Entry<Integer, CodPostEntity> entry : codigosPostales.entrySet()) {
            
            
            listedElements += entry.getValue().toString() + "\n";
            
        }
        
        
        return listedElements;
    }

    @Override
    public String showCpSelected(int cpSelected){
        
        String cpSelectedToString = "The cp selected is : \n";
        
        for (Map.Entry<Integer, CodPostEntity> unitaryCp : codigosPostales.entrySet()) {
            if (unitaryCp.getKey() == cpSelected) {
                
                cpSelectedToString += unitaryCp.getValue().toString();
                
            }
            
        }
        
        return cpSelectedToString;
        
        
    }

    @Override
    public void menu(){
        
        
        
        
        
        
        
    }
    
}
