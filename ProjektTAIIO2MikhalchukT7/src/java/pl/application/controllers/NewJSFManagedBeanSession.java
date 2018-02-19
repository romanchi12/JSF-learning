/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.application.controllers;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import pl.application.common.DataRow;
import pl.application.common.MenuItem;


@ManagedBean
@SessionScoped
public class NewJSFManagedBeanSession {
    ArrayList<MenuItem> menuItemList = new ArrayList<>();
    ArrayList<DataRow> dataRow = new ArrayList();
    /**
     * Creates a new instance of NewJSFManagedBeanSession
     */
    public NewJSFManagedBeanSession() {
        menuItemList.add(new MenuItem("Karuzela","/views/carouselView"));
        menuItemList.add(new MenuItem("Tabela", "/views/tableView"));
        menuItemList.add(new MenuItem("Wylogowanie", "/logoutWindow"));
        
        dataRow.add(new DataRow("Adam", "Nowak", 25, "Warszawa", "56321234"));
        dataRow.add(new DataRow("Miciej", "Kowalski", 35, "Gdansk", "4253121"));
        dataRow.add(new DataRow("Kamil", "Kaminski", 37, "Gdynia", "4321367"));
    }

    public ArrayList<MenuItem> getMenuItemList() {
        return menuItemList;
    }

    public void setMenuItemList(ArrayList<MenuItem> menuItemList) {
        this.menuItemList = menuItemList;
    }

    public ArrayList<DataRow> getDataRow() {
        return dataRow;
    }

    public void setDataRow(ArrayList<DataRow> dataRow) {
        this.dataRow = dataRow;
    }
    
}
