/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Nguyen
 */
public class Validation {
    public static Scanner sc = new Scanner(System.in);
    public static int getAnInteger(String inputMsg, String errorMsg, int lowerBound) {
        int n;
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                if (n < lowerBound)
                    throw new Exception();                
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }
    public static double getADouble(String inputMsg, String errorMsg, double lowerBound) {
        double n;
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Double.parseDouble(sc.nextLine());
                if (n <= lowerBound)
                    throw new Exception();                
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static int getAnInteger(String inputMsg, String errorMsg, int lowerBound, int upperBound) {
        int n;
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                if (n < lowerBound || n > upperBound)
                    throw new Exception();                
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }
        
    public static String getID(String inputMsg, String errorMsg, String format) {
        String id;
        boolean match;
        while (true) {
            System.out.print(inputMsg);
            id = sc.nextLine().trim().toUpperCase();
            match = id.matches(format);
            if (id.length() == 0 || id.isEmpty() || match == false)
                System.out.println(errorMsg);
            else
                return id;            
        }
    }
 
    public static String getString(String inputMsg, String errorMsg) {
        String id;        
        while (true) {
            System.out.print(inputMsg);
            id = sc.nextLine().trim().toUpperCase();            
            if (id.length() == 0 || id.isEmpty())
                System.out.println(errorMsg);
            else 
                return id;
        }
    }
    public static boolean yesOrNO(String check){
        if(check.equalsIgnoreCase("Y"))
            return true;
        return false;
    }
    public static boolean checkIDEmployee(ArrayList<Employee> list, String id){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId().equalsIgnoreCase(id))
                return true;
        }
        return false;
    }
    public static boolean checkIDRequest(ArrayList<Request> lRequest, String id){
        for (int i = 0; i < lRequest.size(); i++) {
            if(lRequest.get(i).getrID().equalsIgnoreCase(id))
                return true;
        }
        return false;
    }
    public static boolean checkIDBorrow(ArrayList<Borrow> lBorrow, String id){
        for (int i = 0; i < lBorrow.size(); i++) {
            if(lBorrow.get(i).getbID().equalsIgnoreCase(id))
                return true;
        }
        return false;
    }
    public static boolean checkPassWord(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        String password_MD5 = DatatypeConverter.printHexBinary(digest);
        if (password_MD5.equalsIgnoreCase("e10adc3949ba59abbe56e057f20f883e")) {
            return true;
        }
        return false;
    }
    public static Asset checkIDAsset(ArrayList<Asset> lAsset, String id){
        if(lAsset.isEmpty())
            return null;
        for (int i = 0; i < lAsset.size(); i++) {
            if(lAsset.get(i).getId().equalsIgnoreCase(id))
                return lAsset.get(i);
        }
        return null;
    }
}
