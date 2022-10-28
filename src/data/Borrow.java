/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Nguyen
 */
public class Borrow {
    private String bID;
    private String assetID;
    private String employeeID;
    private int quantity;
    private String borrowDate;

    public Borrow(String bID, String assetID, String employeeID, int quantity, String borrowDate) {
        this.bID = bID;
        this.assetID = assetID;
        this.employeeID = employeeID;
        this.quantity = quantity;
        this.borrowDate = borrowDate;
    }

    
    public String getbID() {
        return bID;
    }

    public void setbID(String bID) {
        this.bID = bID;
    }

    public String getAssetID() {
        return assetID;
    }

    public void setAssetID(String assetID) {
        this.assetID = assetID;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    @Override
    public String toString() {
        return bID + "," + assetID + "," + employeeID + "," + quantity + "," + borrowDate;
    }
    
    
}
