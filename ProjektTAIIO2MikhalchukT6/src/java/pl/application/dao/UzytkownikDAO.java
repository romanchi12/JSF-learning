/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import pl.application.to.UzytkownikTo;


public class UzytkownikDAO {
    protected static String SQL_SELECT_ALL = "select id,imie,nazwisko from t_uzytkownik order by id";
    protected static String SQL_SELECT = "select id,imie, nazwisko from t_uzytkownik where id=?";
    protected static String SQL_UPDATE = "update t_uzytkownik set id=?, imie=?, nazwisko=? where id=?";
    protected static String SQL_INSERT = "insert into t_uzytkownik (id, imie, nazwisko) values(?,?,?)";
    protected static String SQL_DELETE = "delete from t_uzytkownik where id=?";
    Connection connection;

    public UzytkownikDAO() {
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
    private Long getNextId(){
        try{
            ResultSet wynikZapytania = 
                   connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                          ResultSet.CONCUR_READ_ONLY).executeQuery("select max(id) from t_uzytkownik");
            wynikZapytania.first();
            long lMaxId = wynikZapytania.getLong(1) + 1;
            return lMaxId;
        }catch(Exception ex){
            FacesContext facesContext = FacesContext.getCurrentInstance();
            javax.servlet.ServletContext servletContext = (javax.servlet.ServletContext) facesContext.getExternalContext().getContext();
            servletContext.log(servletContext.getContextPath()+":"+ex.toString());
            facesContext.addMessage(null, new FacesMessage(ex.toString()));
            return null;
        }
    }
    public Long create(UzytkownikTo uzytkownikTo){
        Long uzytkownikToId;
        try{
            uzytkownikToId = getNextId();
            PreparedStatement zapytanie = connection.prepareStatement(SQL_INSERT);
            zapytanie.setLong(1,uzytkownikToId);
            zapytanie.setString(2, uzytkownikTo.getImie());
            zapytanie.setString(3, uzytkownikTo.getNazwisko());
            int iLiczbaZmian = zapytanie.executeUpdate();
            return uzytkownikToId;
        }catch(Exception ex){
            FacesContext facesContext = FacesContext.getCurrentInstance();
            javax.servlet.ServletContext servletContext = (javax.servlet.ServletContext) facesContext.getExternalContext().getContext();
            servletContext.log(servletContext.getContextPath()+":"+ex.toString());
            facesContext.addMessage(null, new FacesMessage(ex.toString()));
            return null;
        }finally{
            if(connection!=null){
                try{
                    connection.close();
                    connection = null;
                }catch(Exception ex){
                    FacesContext facesContext = FacesContext.getCurrentInstance();
                    javax.servlet.ServletContext servletContext = (javax.servlet.ServletContext) facesContext.getExternalContext().getContext();
                    servletContext.log(servletContext.getContextPath()+":"+ex.toString());
                    facesContext.addMessage(null, new FacesMessage(ex.toString()));
                }
            }
        }
    }
    public Long delete(Long id){
        try{
           PreparedStatement zapytanie = connection.prepareStatement(SQL_DELETE);
           zapytanie.setLong(1, id);
           int iLiczbaZmian = zapytanie.executeUpdate();
           return id;
        }catch(Exception ex){
            FacesContext facesContext = FacesContext.getCurrentInstance();
            javax.servlet.ServletContext servletContext = (javax.servlet.ServletContext) facesContext.getExternalContext().getContext();
            servletContext.log(servletContext.getContextPath()+":"+ex.toString());
            facesContext.addMessage(null, new FacesMessage(ex.toString()));
            return -1l;
        }finally{
            if(connection != null){
                try{
                    connection.close();
                    connection = null;
                }catch(Exception ex){
                    FacesContext facesContext = FacesContext.getCurrentInstance();
                    javax.servlet.ServletContext servletContext = (javax.servlet.ServletContext) facesContext.getExternalContext().getContext();
                    servletContext.log(servletContext.getContextPath()+":"+ex.toString());
                    facesContext.addMessage(null, new FacesMessage(ex.toString()));
                }
            }
        }
    }
    public Long update(UzytkownikTo uzytkownikTo){
        try{
           PreparedStatement zapytanie = connection.prepareStatement(SQL_UPDATE);
           zapytanie.setLong(1, uzytkownikTo.getId());
           zapytanie.setString(2,uzytkownikTo.getImie());
           zapytanie.setString(3, uzytkownikTo.getNazwisko());
           zapytanie.setLong(4,uzytkownikTo.getId());
           int iLiczbaZmian = zapytanie.executeUpdate();
           return uzytkownikTo.getId();
        }catch(Exception ex){
            FacesContext facesContext = FacesContext.getCurrentInstance();
            javax.servlet.ServletContext servletContext = (javax.servlet.ServletContext) facesContext.getExternalContext().getContext();
            servletContext.log(servletContext.getContextPath()+":"+ex.toString());
            facesContext.addMessage(null, new FacesMessage(ex.toString()));
            return -1l;
        }finally{
            if(connection != null){
                try{
                    connection.close();
                    connection = null;
                }catch(Exception ex){
                    FacesContext facesContext = FacesContext.getCurrentInstance();
                    javax.servlet.ServletContext servletContext = (javax.servlet.ServletContext) facesContext.getExternalContext().getContext();
                    servletContext.log(servletContext.getContextPath()+":"+ex.toString());
                    facesContext.addMessage(null, new FacesMessage(ex.toString()));
                }
            }
        }
    }
    public ArrayList<UzytkownikTo> findAll(){
        try{
            ArrayList<UzytkownikTo> uzytkownikToList = new ArrayList();
            ResultSet wynikZapytania = connection.
                   prepareStatement(SQL_SELECT_ALL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery();
            boolean bCzyJestWiersz = wynikZapytania.first();
            while(bCzyJestWiersz){
                uzytkownikToList.add(new UzytkownikTo(wynikZapytania.getLong("id"), wynikZapytania.getString("imie"), wynikZapytania.getString("nazwisko"),false));
                bCzyJestWiersz = wynikZapytania.next();
            }
            return uzytkownikToList;
        }catch(Exception ex){
            FacesContext facesContext = FacesContext.getCurrentInstance();
            javax.servlet.ServletContext servletContext = (javax.servlet.ServletContext) facesContext.getExternalContext().getContext();
            servletContext.log(servletContext.getContextPath()+":"+ex.toString());
            facesContext.addMessage(null, new FacesMessage(ex.toString()));
            return null;
        }finally{
            if(connection != null){
                try{
                    connection.close();
                    connection = null;
                }catch(Exception ex){
                    FacesContext facesContext = FacesContext.getCurrentInstance();
                    javax.servlet.ServletContext servletContext = (javax.servlet.ServletContext) facesContext.getExternalContext().getContext();
                    servletContext.log(servletContext.getContextPath()+":"+ex.toString());
                    facesContext.addMessage(null, new FacesMessage(ex.toString()));
                }
            }
        }
    }
}
