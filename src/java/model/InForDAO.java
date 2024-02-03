/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class InForDAO {
    public  static  List<InFor>  ls = new ArrayList<>();
    public void save(InFor t){
        ls.add(t);
    }
    
}
