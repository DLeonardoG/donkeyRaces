package com.mycompany.donkeysrace.controller;

import com.mycompany.donkeysrace.model.classes.Owner;
import com.mycompany.donkeysrace.model.persistence.CRUD;
import com.mycompany.donkeysrace.model.persistence.DBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class ControllerOwner {

    public static Owner registerOwner(Scanner scanner) {
        String name = UtilityU.getValidInput(scanner, "Enter your name:");
        String ID = String.valueOf(UtilityU.getValidInt(scanner, "Enter your name:")); 
        Owner owner = new Owner(name, ID);
        return owner;
    }
    
    public static boolean add(Scanner scanner) {
        Owner owner = registerOwner(scanner);
        CRUD.setConnection(DBConnection.connectionDB());
        String insertion = """
                   INSERT INTO owners (ID, name) 
                   VALUES (?, ?)""";
        List<Object> parameters = new ArrayList<>();
        parameters.add(owner.getID());
        parameters.add(owner.getName());

        try {
            if (CRUD.setAutoCommitDB(false)) {
                boolean success = CRUD.insertDB(insertion, parameters);
                if (success) {
                    CRUD.commitDB();
                    return true;
                } else {
                    CRUD.rollbackDB();
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception e) {
            CRUD.rollbackDB();
            throw e;
        } finally {
            CRUD.closeCon();
        }
    }
    
    public static List<Owner> list() {
        CRUD.setConnection(DBConnection.connectionDB());
        List<Owner> listOwners = new ArrayList<>();
        String sql = "SELECT * FROM owners";
        List<Object> parameters = new ArrayList<>();

        try {
            ResultSet rs = CRUD.consultDB(sql, parameters);
            while (rs != null && rs.next()) {
                Owner owner = new Owner(
                        rs.getInt("idOwner"),
                        rs.getString("ID"),
                        rs.getString("name")
                );
                listOwners.add(owner);
            }
        } catch (SQLException ex) {
            System.out.println("Error listing Owners: " + ex.getMessage());
        } finally {
            CRUD.closeCon();
        }

        return listOwners;
    }

    public static Owner search(int id) {
        CRUD.setConnection(DBConnection.connectionDB());
        String query = """
               SELECT 
                   idOwner, ID, name
               FROM 
                   owners
               WHERE 
                   idOwner = ?""";
        List<Object> parameters = new ArrayList<>();
        parameters.add(id);

        try {
            ResultSet rs = CRUD.consultDB(query, parameters);
            if (rs != null && rs.next()) {
                return new Owner(
                        rs.getInt("idOwner"),
                        rs.getString("ID"),
                        rs.getString("name")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error while searching for Owner: " + e.getMessage());
        } finally {
            CRUD.closeCon();
        }
        return null;
    }

    public static Owner assign(Scanner scanner) {
        Owner owner = null;
        while (owner == null) {
            try {
                System.out.println("\n--- Owners List ---");
                ControllerOwner.list().forEach(System.out::println);
                System.out.println("---------------------");
                int id = UtilityU.getValidInt(scanner, "Choose one by ID: ");
                owner = ControllerOwner.search(id);
                if (owner == null) {
                    System.out.println("Not valid, enter a valid value.");
                }
            } catch (Exception e) {
                System.out.println("Error: enter correct format.");
                scanner.nextLine();
            }
        }
        return owner;
    }

    public static boolean update(Scanner scanner) {
        int id = search(UtilityU.getIntFromUser(scanner)).getIdOwner();
        Owner owner = registerOwner(scanner);
        owner.setIdOwner(id);
        CRUD.setConnection(DBConnection.connectionDB());
        String sql = "UPDATE owners SET ID = ?, name = ? WHERE idOwner = ?";
        List<Object> parameters = new ArrayList<>();
        parameters.add(owner.getID());
        parameters.add(owner.getName());

        try {
            if (CRUD.setAutoCommitDB(false)) {
                boolean success = CRUD.updateDB(sql, parameters);
                if (success) {
                    CRUD.commitDB();
                    System.out.println("Owner updated successfully.");
                    return true;
                } else {
                    CRUD.rollbackDB();
                    System.out.println("No owner found to update.");
                    return false;
                }
            } else {
                System.out.println("Failed to disable auto-commit.");
                return false;
            }
        } catch (Exception e) {
            CRUD.rollbackDB();
            System.out.println("Error updating owner: " + e.getMessage());
            return false;
        } finally {
            CRUD.closeCon();
        }
    }
    
    

}
