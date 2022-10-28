/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Nguyen
 */
public class AssetList extends ArrayList<Asset> {

    private ArrayList<Employee> lEmployee = new ArrayList();
    private ArrayList<Request> lRequest = new ArrayList();
    private ArrayList<Borrow> lBorrow = new ArrayList();

    public void addFromFile() {
        try {
            FileReader fr = new FileReader("asset.dat");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String txt[] = line.split(",");
                String id = txt[0];
                String name = txt[1];
                String color = txt[2];
                int price = Integer.parseInt(txt[3]);
                double weight = Double.parseDouble(txt[4]);
                int quantity = Integer.parseInt(txt[5]);
                this.add(new Asset(id, name, color, price, weight, quantity));
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println("Read from file asset.txt is FAIL!!");
        }
        try {
            FileReader fr = new FileReader("employee.dat");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String txt[] = line.split(",");
                String id = txt[0];
                String name = txt[1];
                String birthdate = txt[2];
                String role = txt[3];
                String sex = txt[4];
                String password = txt[5];
                lEmployee.add(new Employee(id, name, birthdate, role, sex, password));
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println("Read from file employee.txt is FAIL!!");
        }
        try {
            FileReader fr = new FileReader("request.dat");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String txt[] = line.split(",");
                String rID = txt[0];
                String assetID = txt[1];
                String employeeID = txt[2];
                int quantity = Integer.parseInt(txt[3]);
                String requestDate = txt[4];
                lRequest.add(new Request(rID, assetID, employeeID, quantity, requestDate));
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println("Read from file request.txt is FAIL!!");
        }
        try {
            FileReader fr = new FileReader("borrow.dat");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String txt[] = line.split(",");
                String bID = txt[0];
                String assetID = txt[1];
                String employeeID = txt[2];
                int quantity = Integer.parseInt(txt[3]);
                String requestDate = txt[4];
                lBorrow.add(new Borrow(bID, assetID, employeeID, quantity, requestDate));
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println("Read from file borrow.txt is FAIL!!");
        }
    }
    public void writeToFile() {

        try {
            FileWriter fw = new FileWriter("asset.dat");
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < this.size(); i++) {
                bw.write(this.get(i).toString());
                bw.newLine();
            }          
            bw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println("FAIL!!!");
        }
        try {
            FileWriter fw = new FileWriter("employee.dat");
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < lEmployee.size(); i++) {
                bw.write(lEmployee.get(i).toString());
                bw.newLine();
            }          
            bw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println("FAIL!!!");
        }
        try {
            FileWriter fw = new FileWriter("request.dat");
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < lRequest.size(); i++) {
                bw.write(lRequest.get(i).toString());
                bw.newLine();
            }          
            bw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println("FAIL!!!");
        }
        try {
            FileWriter fw = new FileWriter("borrow.dat");
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < lBorrow.size(); i++) {
                bw.write(lBorrow.get(i).toString());
                bw.newLine();
            }          
            bw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println("FAIL!!!");
        }
    }
    public boolean loginEmployee() throws NoSuchAlgorithmException {
        showEmployee();
        String employID = Validation.getID("Enter userID(Exxxxxx): ", "Wrong.Input again.", "^[E|e]\\d{6}$");
        String password = Validation.getString("Enter password: ", "Not blank or empty.");
        boolean check = Validation.checkIDEmployee(lEmployee, employID);
        boolean check_1 = Validation.checkPassWord(password);
        if (check == false || check_1 == false) {
            return false;
        } else {
            return true;
        }
    }

    public boolean loginManager() throws NoSuchAlgorithmException {
        showEmployee();
        String manageID = Validation.getID("Enter userID(Exxxxxx): ", "Wrong.Input again.", "^[e|E]\\d{6}$");
        String password = Validation.getString("Enter password: ", "Not blank or empty.");
        boolean check = Validation.checkIDEmployee(lEmployee, manageID);
        boolean check_1 = Validation.checkPassWord(password);
        if (check == false || check_1 == false) {
            return false;
        } else {
            if (manageID.equalsIgnoreCase("E160052")) {
                System.out.println("You are manager.");
                return true;
            } else {
                System.out.println("You are not manager.");
                return false;
            }
        }
    }

    public void searchAsset() {
        if (this.isEmpty()) {
            System.out.println("List empty.Nothing to search.");
            return;
        }
        boolean check = false;
        String name = Validation.getString("Enter name search: ", "Not blank or empty.");
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getName().contains(name)) {
                System.out.printf("%-10s%-20s%-10s%-10d%-10.1f%-10d\n",
                        this.get(i).getId(),
                        this.get(i).getName(),
                        this.get(i).getColor(),
                        this.get(i).getPrice(),
                        this.get(i).getWeight(),
                        this.get(i).getQuantity());
                check = true;
            }
        }
        if (check == false) {
            System.out.println("Not find Asset.");
        }
    }

    public void createAsset() throws NoSuchAlgorithmException {
        String id, name, color;
        int price, quantity;
        double weight;
        Asset x;
        boolean check = loginManager();
        if (check == true) {
            do {
                id = Validation.getID("Enter ID Asset(Axxx): ", "Wrong.Input again.", "^[A|a]\\d{3}$");
                x = Validation.checkIDAsset(this, id);
                if (x != null) {
                    System.out.println("ID has been already in list.Input again.");
                }
            } while (x != null);
            name = Validation.getString("Enter name Asset: ", "Not blank or empty.");
            color = Validation.getString("Enter color Asset: ", "Not blank or empty.");
            price = Validation.getAnInteger("Enter price Asset: ", "Just integer and more than 0", 1);
            weight = Validation.getADouble("Enter weight Asset: ", "Just double and more than 0.", 1);
            quantity = Validation.getAnInteger("Enter quantity Asset: ", "Just integer and more than 0", 1);
            this.add(new Asset(id, name, color, price, weight, quantity));
            System.out.println("The Asset's information  has been sucessfully.");
            showAsset();
        } else {
            System.out.println("Wrong.You can't create asset.");
        }
    }

    public void updateAsset() throws NoSuchAlgorithmException {
        String id, name, color;
        int price, quantity;
        double weight;
        Asset x;
        boolean check = loginManager();
        if (check == true) {
            id = Validation.getID("Enter ID Asset(Axxx): ", "Wrong.Input again.", "^[A|a]\\d{3}$");
            x = Validation.checkIDAsset(this, id);
            if (x != null) {
                name = Validation.getString("Enter new name Asset: ", "Not blank or empty.");
                x.setName(name);
                color = Validation.getString("Enter new color Asset: ", "Not blank or empty.");
                x.setColor(color);
                price = Validation.getAnInteger("Enter new price Asset: ", "Just integer and more than 0", 1);
                x.setPrice(price);
                weight = Validation.getADouble("Enter new weight Asset: ", "Just double and more than 0.", 1);
                x.setWeight(weight);
                quantity = Validation.getAnInteger("Enter new quantity Asset: ", "Just integer and more than 0", 1);
                x.setQuantity(quantity);
                System.out.println("The Asset's information has been updated.");
                showAsset();
            } else {
                System.out.println("Not find ID.You can't update.");
            }
        } else {
            System.out.println("Wrong.You can't create asset.");
        }
    }

    public void approveRequest() throws NoSuchAlgorithmException {
        boolean check = loginManager();
        boolean check_ID;
        boolean flag = false;
        if (check == true) {
            showRequest();
            Asset x;
            String bID;
            String rID = Validation.getID("Enter ID of request(Rxxx):  ", "Wrong.Input agian.", "^[r|R]\\d{3}$");
            for (int i = 0; i < lRequest.size(); i++) {
                if (lRequest.get(i).getrID().equalsIgnoreCase(rID)) {
                    x = Validation.checkIDAsset(this, lRequest.get(i).getAssetID());
                    do {
                        bID = Validation.getID("Enter ID or borrow(Bxxx): ", "Wrong.Input again.", "^[B|b]\\d{3}$");
                        check_ID = Validation.checkIDBorrow(lBorrow, bID);
                        if (check_ID == true) {
                            System.out.println("ID has been already in list.Input again.");
                        }
                    } while (check_ID == true);
                    Date now = new Date();
                    SimpleDateFormat a = new SimpleDateFormat();
                    String date = a.format(now);
                    lBorrow.add(new Borrow(bID, lRequest.get(i).getAssetID(), lRequest.get(i).getEmployeeID(), lRequest.get(i).getQuantity(), date));
                    System.out.println("Sucessffully.");
                    x.setQuantity(x.getQuantity() - lRequest.get(i).getQuantity());
                    lRequest.remove(lRequest.get(i));
                    flag = true;
                }
            }
            if(flag == false){
                System.out.println("Not find ID.You can't approve the request.");
            }
        } else {
            System.out.println("Wrong.You can't approve the request.");
        }
    }

    public void showListBorrow() throws NoSuchAlgorithmException {
        boolean check = loginManager();
        if (check == true) {
            if (lBorrow.isEmpty()) {
                System.out.println("List empty.Nothing to print.");
            } else {
                showBorrow();
            }
        } else {
            System.out.println("Wrong.You can't show all list borrow.");
        }

    }

    public void requestAsset() throws NoSuchAlgorithmException {
        boolean check_Login = loginEmployee();
        boolean check_IDEmployee;
        String id, employID;
        if (check_Login == true) {
            showAsset();
            boolean check;
            do {
                id = Validation.getID("Enter ID Request(Rxxx): ", "Wrong.Input again.", "^[R|r]\\d{3}$");
                check = Validation.checkIDRequest(lRequest, id);
                if (check == true) {
                    System.out.println("ID Request has been already. Input again.");
                }
            } while (check == true);
            int index = Validation.getAnInteger("Enter your choice[1.." + this.size() + "]: ", "Just from 1 to " + this.size() + ".", 1, this.size());
            int quantity = Validation.getAnInteger("Enter quantity [1.." + this.get(index - 1).getQuantity() + "]: ", "From 1 to " + this.get(index - 1).getQuantity(), 1, this.get(index - 1).getQuantity());
            do {
                employID = Validation.getID("Enter ID(Exxxxxx) Employee: ", "Wrong.Input again.", "^[E|e]\\d{6}");
                check_IDEmployee = Validation.checkIDEmployee(lEmployee, employID);
                if (check_IDEmployee == false) {
                    System.out.println("ID Employee not exist in list.");
                }
            } while (check_IDEmployee == false);
            Date now = new Date();
            SimpleDateFormat x = new SimpleDateFormat();
            String date = x.format(now);
            lRequest.add(new Request(id, this.get(index - 1).getId(), employID, quantity, date));
            System.out.println("Sucessfully.");
            showRequest();
        } else {
            System.out.println("Wrong userID or password.");
        }
    }

    public void showAsset() {
        if (this.isEmpty()) {
            System.out.println("List empty.Nothing to print.");
            return;
        }
        System.out.println(" assetID          name          color        price     weight   quantity ");
        for (int i = 0; i < this.size(); i++) {
            System.out.printf("%-10s%-20s%-10s%10d%10.1f%10d\n",
                    this.get(i).getId(),
                    this.get(i).getName(),
                    this.get(i).getColor(),
                    this.get(i).getPrice(),
                    this.get(i).getWeight(),
                    this.get(i).getQuantity());
        }
    }

    public void showEmployee() {
        if (lEmployee.isEmpty()) {
            System.out.println("List empty.Nothing to print.");
            return;
        }
        System.out.println(" employID         name         birthdate       role      sex             password              ");
        for (int i = 0; i < lEmployee.size(); i++) {
            System.out.printf("%-10s%-20s%-10s%10s%10s%35s\n",
                    lEmployee.get(i).getId(),
                    lEmployee.get(i).getName(),
                    lEmployee.get(i).getBirthDate(),
                    lEmployee.get(i).getRole(),
                    lEmployee.get(i).getSex(),
                    lEmployee.get(i).getPassword());
        }
    }

    public void showRequest() {
        if (lRequest.isEmpty()) {
            System.out.println("List empty.Nothing to print.");
            return;
        }
        System.out.println(" rID     asssetID   employeeID  quantity     requestDateTime  ");
        for (int i = 0; i < lRequest.size(); i++) {
            System.out.printf("%-10s%-10s%-10s%10s%20s\n",
                    lRequest.get(i).getrID(),
                    lRequest.get(i).getAssetID(),
                    lRequest.get(i).getEmployeeID(),
                    lRequest.get(i).getQuantity(),
                    lRequest.get(i).getRequestDate());
        }
    }

    public void showBorrow() {
        if (lBorrow.isEmpty()) {
            System.out.println("List empty.Nothing to print.");
            return;
        }
        System.out.println(" bID     asssetID   employeeID  quantity     requestDateTime  ");
        for (int i = 0; i < lBorrow.size(); i++) {
            System.out.printf("%-10s%-10s%-10s%10s%20s\n",
                    lBorrow.get(i).getbID(),
                    lBorrow.get(i).getAssetID(),
                    lBorrow.get(i).getEmployeeID(),
                    lBorrow.get(i).getQuantity(),
                    lBorrow.get(i).getBorrowDate());
        }
    }

}
