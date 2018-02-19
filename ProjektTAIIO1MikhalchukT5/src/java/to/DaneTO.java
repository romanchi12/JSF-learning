/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package to;


public class DaneTO {
    private Long id = -1l;
    private String nr="xx";
    private String tytul = "xx";
    private String opis = "xx";
    private boolean edited = false;
    public DaneTO(){}
    public DaneTO(Long id, String nr, String tytul, String opis, boolean edited){
        this.id = id;
        this.nr = nr;
        this.tytul = tytul;
        this.opis = opis;
        this.edited = edited;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNr() {
        return nr;
    }

    public void setNr(String nr) {
        this.nr = nr;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public boolean isEdited() {
        return edited;
    }

    public void setEdited(boolean edited) {
        this.edited = edited;
    }
    
}
