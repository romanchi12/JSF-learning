/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.DaneDAO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import to.DaneTO;


@ManagedBean
@SessionScoped
public class NewJSFManagedBeanSession {
       List<DaneTO> daneTO = new ArrayList<>();
    /**
     * Creates a new instance of NewJSFManagedBeanSession
     */
    public NewJSFManagedBeanSession() {
        daneTO.add(new DaneTO(1l,"2016-01", "factura", "jeszcze nie wydrukowana", false));
        daneTO.add(new DaneTO(2l,"2016-02", "factura", "wydrukowana", false));
        daneTO.add(new DaneTO(3l,"2016-03", "factura", "wydrukowana", true));
        
    }

    public String saveData(){
        Iterator<DaneTO> nameIterator = daneTO.iterator();
        while(nameIterator.hasNext()){
            nameIterator.next().setEdited(false);
        }
        return "";
    }
    
    public String refreshData(){
        DaneDAO daneDao = new DaneDAO();
        daneTO.clear();
        daneTO = daneDao.findAll();
        return "";
    }
    
    public List<DaneTO> getDaneTO() {
        return daneTO;
    }

    public void setDaneTO(List<DaneTO> daneTO) {
        this.daneTO = daneTO;
    }
    
}
