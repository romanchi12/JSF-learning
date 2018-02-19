/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import to.DaneTO;



public class DaneDAO {
    protected static String SQL_SELECT_ALL = "select id,nr,tytul,opis from t_dane";
    java.sql.Connection connection;
    public DaneDAO(){
        try{
            Context ctx = new InitialContext();
            DataSource datasource = (DataSource) ctx.lookup("java:comp/env/jdbc/bazaTestowaMSSQL");
            String name = datasource.toString();
            connection = datasource.getConnection();
        }catch(Exception ex){
            FacesContext facesContext = FacesContext.getCurrentInstance();
            javax.servlet.ServletContext servletContext = (javax.servlet.ServletContext) facesContext.getExternalContext().getContext();
            servletContext.log(servletContext.getContextPath()+":"+ex.toString());
            facesContext.addMessage(null, new FacesMessage(ex.toString()));
        }
    }
    public List<DaneTO> findAll(){
        List<DaneTO> daneToListFromSQL = new ArrayList();
        try{
            ResultSet wynikZapytania = connection.prepareStatement(SQL_SELECT_ALL,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
                   .executeQuery();
            if(wynikZapytania.first()){
                do{
                    Long id = wynikZapytania.getLong("id");
                    String nr = wynikZapytania.getString("nr");
                    String tytul = wynikZapytania.getString("tytul");
                    String opis = wynikZapytania.getString("opis");
                    daneToListFromSQL.add(new DaneTO(id, nr, tytul, opis, false));
                }while(wynikZapytania.next());
                connection.close();
                return daneToListFromSQL;
            }
            connection.close();
            return daneToListFromSQL;
        }catch(Exception ex){
            FacesContext facesContext = FacesContext.getCurrentInstance();
            javax.servlet.ServletContext servletContext = (javax.servlet.ServletContext) facesContext.getExternalContext().getContext();
            servletContext.log(servletContext.getContextPath()+":"+ex.toString());
            facesContext.addMessage(null, new FacesMessage(ex.toString()));
            return null;
        }
    }
}
