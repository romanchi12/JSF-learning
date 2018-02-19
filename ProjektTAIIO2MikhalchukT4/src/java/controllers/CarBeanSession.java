/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import data.Car;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class CarBeanSession {
    ArrayList<Car> carsList;
    /**
     * Creates a new instance of CarBeanSession
     */
    public CarBeanSession() {
        carsList = new ArrayList<>();
        carsList.add(new Car(1l,"Mersedes", "2013", false));
        carsList.add(new Car(2l,"Audi", "2010", false));
        carsList.add(new Car(3l,"Opel", "2016", false));
        carsList.add(new Car(4l,"BMW", "1999", false));
    }

    public String addRow(Car car){
        int indexObject = carsList.indexOf(car);
        long nextId = carsList.size() + 1;
        Car newCarTO = new Car(nextId, "","", true);
        carsList.add(indexObject + 1, newCarTO);
        return "";
    }
    public String delRow(Car car){
        int indexObject = carsList.indexOf(car);
        carsList.remove(indexObject);
        return "";
    }
    public String modifyRow(Car car){
        int indexObject = carsList.indexOf(car);
        carsList.get(indexObject).setEdited(true);
        return "";
    }
    public String saveData(){
        for(Car car:carsList){
            car.setEdited(false);
        }
        return "";
    }
    public String refreshData(){
        carsList.clear();
        carsList.add(new Car(1l,"Mersedes", "2013", false));
        carsList.add(new Car(2l,"Audi", "2010", false));
        carsList.add(new Car(3l,"Opel", "2016", false));
        carsList.add(new Car(4l,"BMW", "1999", false));
        for(Car car:carsList){
            car.setEdited(false);
        }
        return "";
    }
    public ArrayList<Car> getCarsList() {
        return carsList;
    }

    public void setCarsList(ArrayList<Car> carsList) {
        this.carsList = carsList;
    }
    
}
