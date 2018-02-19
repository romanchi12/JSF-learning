/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;


@ManagedBean
@ApplicationScoped
public class ApplicationController {
    String appVariable = "Wersja 10.10.10";

    public String getAppVariable() {
        return appVariable;
    }

    public void setAppVariable(String appVariable) {
        this.appVariable = appVariable;
    }
    /**
     * Creates a new instance of ApplicationController
     */
    public ApplicationController() {
    }
    
}
