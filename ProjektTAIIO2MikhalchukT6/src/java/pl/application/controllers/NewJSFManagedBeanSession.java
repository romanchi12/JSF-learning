/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.application.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import pl.application.dao.UzytkownikDAO;
import pl.application.to.UzytkownikTo;
 
@ManagedBean
@SessionScoped
public class NewJSFManagedBeanSession {
    List<UzytkownikTo> uzytkownikToList = new ArrayList<>();
    /**
     * Creates a new instance of NewJSFManagedBeanSession
     */
    public NewJSFManagedBeanSession() {
        refreshData();
    }
    public final void refreshData(){
        UzytkownikDAO danedao = new UzytkownikDAO();
        List<UzytkownikTo> uzytkownikToListLokal = danedao.findAll();
        if(uzytkownikToListLokal != null){
            uzytkownikToList.clear();
            uzytkownikToList = uzytkownikToListLokal;
        }
    }
    public List<UzytkownikTo> getUzytkownikToList() {
        return uzytkownikToList;
    }

    public void setUzytkownikToList(List<UzytkownikTo> uzytkownikToList) {
        this.uzytkownikToList = uzytkownikToList;
    }
    public void visibleChange(UzytkownikTo uzytkownikTo){
        int indexObject = uzytkownikToList.indexOf(uzytkownikTo);
        //uzytkownikTo.setEdited(!uzytkownikTo.isEdited());
        UzytkownikDAO daneDao = new UzytkownikDAO();
        if(daneDao.update(uzytkownikTo)!=-1){
            uzytkownikToList.set(indexObject, uzytkownikTo);
        }
    }
    public void deleteRow(UzytkownikTo uzytkownikTo){
        int indexObject = uzytkownikToList.indexOf(uzytkownikTo);
        UzytkownikDAO daneDao = new UzytkownikDAO();
           if(daneDao.delete(uzytkownikTo.getId())!=-1){
               uzytkownikToList.remove(indexObject);
           }
    }
    public void addRow(UzytkownikTo uzytkownikTo){
        int indexObject = uzytkownikToList.indexOf(uzytkownikTo);
        int listSize = uzytkownikToList.size();
        UzytkownikTo newRow = new UzytkownikTo(listSize+1l, "", "", true);
        UzytkownikDAO daneDao = new UzytkownikDAO();
        Long id = daneDao.create(newRow);
        if(id != null){
            newRow.setId(id);
            uzytkownikToList.add(indexObject+1, newRow);
        }
    }
    public void sort(String dir){
        Comparator<UzytkownikTo> comparator = (UzytkownikTo a, UzytkownikTo b) -> {
            int compareResult = 0;
            if(dir.equals("asc")){
                compareResult = a.getNazwisko().compareTo(b.getNazwisko());
            }else{
                compareResult = b.getNazwisko().compareTo(a.getNazwisko());
            }
            return compareResult;
        };
        Collections.sort(uzytkownikToList, comparator);
    }
}
