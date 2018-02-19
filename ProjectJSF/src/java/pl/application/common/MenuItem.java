/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.application.common;


public class MenuItem {
    private String itemName;
    private String itemParam;

    public MenuItem(String itemName, String itemParam) {
        this.itemName = itemName;
        this.itemParam = itemParam;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemParam() {
        return itemParam;
    }
    
}
