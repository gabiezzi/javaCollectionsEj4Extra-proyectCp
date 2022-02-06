package implement;

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
    HashMap<Integer, CodPostEntity> codigosPostales;

    public CodPostServiceImplement() {
        this.read = new Scanner(System.in).useDelimiter("\n");
        this.codigosPostales = new HashMap<>();
    }

    @Override
    public CodPostEntity createNewCP() {

        CodPostEntity newCP = new CodPostEntity();

        System.out.println("Insert the cp : \n");
        newCP.setCodigoPostal(read.nextInt());

        System.out.println("Insert the city : \n");
        newCP.setCiudad(read.next());

        return newCP;
    }

    @Override
    public String addToTheMap(CodPostEntity newCP) {

        codigosPostales.put(newCP.getCodigoPostal(), newCP);
        String createdElement = "Element added : ";
        for (Map.Entry<Integer, CodPostEntity> unitaryCP : codigosPostales.entrySet()) {

            createdElement = unitaryCP.toString()+ "\n";

        }

        return createdElement;
    }

    @Override
    public String showAllCp() {

        String listedElements = "The listed elements are : \n";

        for (Map.Entry<Integer, CodPostEntity> entry : codigosPostales.entrySet()) {

            listedElements += entry.getValue().toString() + "\n";

        }

        return listedElements;
    }

    @Override
    public Boolean showCpSelected(int cpSelected) {

        for (Map.Entry<Integer, CodPostEntity> unitaryCp : codigosPostales.entrySet()) {
            if (unitaryCp.getKey() == cpSelected) {

                System.out.println(unitaryCp.getValue().getCiudad() + " , " + unitaryCp.getValue().getCodigoPostal());
                return true;
            }

        }

        return false;

    }

    @Override
    public Boolean removeCpsSelected(int[] cpsToRemove) {

        boolean conditionRemove3cps= false;

        for (int i = 0; i < codigosPostales.size(); i++) {
            
            
            for (int j = 0; j < 3; j++) {

                if (codigosPostales.containsKey(cpsToRemove[j])) {

                    System.out.println(codigosPostales.get(cpsToRemove[j]).getCodigoPostal()+" , "+ codigosPostales.get(cpsToRemove[j]).getCiudad());
                    
                    codigosPostales.remove(cpsToRemove[j]);


                    conditionRemove3cps= true;
                } 
            }
        }
        return conditionRemove3cps;

    }

    @Override
    public void menu() {

        int option;

        for (int i = 0; i < 5; i++) {
            System.out.println("Insert the cp and country " + (i + 1) + " : \n");
            addToTheMap(createNewCP());
        }

        do {

            System.out.println(constants.CodPostConstants.MENU_MESSAGE);

            option = read.nextInt();

            switch (option) {
                case 1:

                    addToTheMap(createNewCP());

                    break;

                case 2:

                    System.out.println(showAllCp());
                    break;
                case 3:
                    System.out.println("Insert the Cp to show :");
                    int cpSearched = read.nextInt();
                    if (!showCpSelected(cpSearched)) {
                        System.out.println("Book doesnt exist in our library.");
                    }
                    break;
                case 4:

                    System.out.println("Insert the 3 cp you want to remove.");
                    int[] cpsToRemove = new int[3];
                    for (int i = 0; i < 3; i++) {
                        cpsToRemove[i] = read.nextInt();
                    }
                    if(! removeCpsSelected(cpsToRemove)){
                        System.out.println("There is one or more than one cp that doesnt exist in the list!");
                    }
                    break;
                case 5:

                    String optExit;

                    System.out.println("Do you want to exit ?");

                    optExit = read.next();

                    if (optExit.equalsIgnoreCase("y")) {
                        System.out.println("The program has finished.");
                    } else {

                        option = 0;
                    }
                    break;
                default:
                    throw new AssertionError();
            }

        } while (option != 5);

    }

}
