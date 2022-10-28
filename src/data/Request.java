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
public class Request {
    private String rID;
    private String assetID;
    private String employeeID;
    private int quantity;
    private String requestDate;

    public Request(String rID, String assetID, String employeeID, int quantity, String requestDate) {
        this.rID = rID;
        this.assetID = assetID;
        this.employeeID = employeeID;
        this.quantity = quantity;
        this.requestDate = requestDate;
    }

    public String getrID() {
        return rID;
    }

    public void setrID(String rID) {
        this.rID = rID;
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

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    @Override
    public String toString() {
        return rID + "," + assetID + "," + employeeID + "," + quantity + "," + requestDate;
    }
    
}
