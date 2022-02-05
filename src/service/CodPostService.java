/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.CodPostEntity;

/**
 *
 * @author Anita
 */
public interface CodPostService {
    
    
    public CodPostEntity createNewCP();
    public String showAllCp();
    public String showCpSelected(int cpSelected);
    public String addToTheMap(Integer codPost, CodPostEntity newCP);
    public void menu();
}
