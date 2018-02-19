/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class SessionController {
    String sessVariable = "Session Text";
    String nextViewAlias = "index2Alias";
    @ManagedProperty(value="#{applicationController}")
    ApplicationController applicationControllerReference;
    /**
     * Creates a new instance of SessionController
     */
    public SessionController() {
    }

    public String getSessVariable() {
        return sessVariable;
    }

    public void setSessVariable(String sessVariable) {
        this.sessVariable = sessVariable;
    }

    public void setApplicationControllerReference(ApplicationController applicationControllerReference) {
        this.applicationControllerReference = applicationControllerReference;
    }
    public String getDataFromReference(){
        String appVariableModified = applicationControllerReference.appVariable;
        return appVariableModified + "-modyfikacja";
    }

    public String getNextViewAlias() {
        return nextViewAlias;
    }
    
}
