/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import data.Person;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class NewJSFManagedBeanSession {
        
    ArrayList<Person> personsList;
    /**
     * Creates a new instance of NewJSFManagedBeanSession
     */
    public NewJSFManagedBeanSession() {
        personsList = new ArrayList<Person>();
        personsList.add(new Person(1l,"Adam", "Sosnowiec", "254-32-32", false));
        personsList.add(new Person(2l,"Rafał","Katowice", "274-32-12", false));
        personsList.add(new Person(3l,"Mateusz", "Warszawa", "354-32-42", false));
        
    }
    public String addRow(Person person){
        int indexObject = personsList.indexOf(person);
        long nextId = personsList.size() + 1;
        Person newPersonTO = new Person(nextId, "","","", true);
        personsList.add(indexObject + 1, newPersonTO);
        return "";
    }
    public String delRow(Person person){
        int indexObject = personsList.indexOf(person);
        personsList.remove(indexObject);
        return "";
    }
    public String modifyRow(Person person){
        int indexObject = personsList.indexOf(person);
        personsList.get(indexObject).setEdited(true);
        return "";
    }
    public String saveData(){
        for(Person person:personsList){
            person.setEdited(false);
        }
        return "";
    }
    public String refreshData(){
        personsList.clear();
        personsList.add(new Person(1l,"Adam", "Sosnowiec", "254-32-32", false));
        personsList.add(new Person(2l,"Rafał","Katowice", "274-32-12", false));
        personsList.add(new Person(3l,"Mateusz", "Warszawa", "354-32-42", false));
        for(Person person:personsList){
            person.setEdited(false);
        }
        return "";
    }
    public ArrayList<Person> getPersonsList() {
        return personsList;
    }

    public void setPersonsList(ArrayList<Person> personsList) {
        this.personsList = personsList;
    }
    
}
