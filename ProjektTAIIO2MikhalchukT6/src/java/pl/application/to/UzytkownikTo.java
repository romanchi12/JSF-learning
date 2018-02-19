/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.application.to;

import java.io.Serializable;


public class UzytkownikTo implements Serializable {
    Long id;
    String imie = "";
    String nazwisko = "";
    boolean edited = false;

    public UzytkownikTo() {
    }
    
    public UzytkownikTo(Long id, String imie, String nazwisko, boolean edited){
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.edited = edited;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public boolean isEdited() {
        return edited;
    }

    public void setEdited(boolean edited) {
        this.edited = edited;
    }
    
}
