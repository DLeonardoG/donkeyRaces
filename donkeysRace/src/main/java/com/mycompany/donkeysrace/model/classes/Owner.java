
package com.mycompany.donkeysrace.model.classes;

import java.util.ArrayList;
import java.util.List;

public class Owner {
    private int idOwner;
    private String ID;
    private String name;
    private List<Donkey> donkeys;
    
    public Owner(String ID, String name) {
        this.ID = ID;
        this.name = name;
        this.donkeys= new ArrayList<Donkey>();
    }
    
    public Owner(int idOwner, String ID, String name) {
        this.ID = ID;
        this.name = name;
        this.donkeys= new ArrayList<Donkey>();
    }
    
    public Owner() {
        this.donkeys= new ArrayList<Donkey>();
    }

    public int getIdOwner() {
        return idOwner;
    }

    public void setIdOwner(int idOwner) {
        this.idOwner = idOwner;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Donkey> getDonkeys() {
        return donkeys;
    }

    public void setDonkeys(List<Donkey> donkeys) {
        this.donkeys = donkeys;
    }

    @Override
    public String toString() {
        return "ControllerOwner{" + "idOwner=" + idOwner + ", ID=" + ID + ", name=" + name + ", donkeys=" + donkeys + '}';
    }
    
}
