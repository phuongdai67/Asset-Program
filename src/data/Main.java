/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Nguyen
 */
public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException{
        Menu menu = new Menu("Management program for Manager.    ");
        menu.addNewOption("        1. Login.");
        menu.addNewOption("        2. Search asset by name.");
        menu.addNewOption("        3. Create new asset.");
        menu.addNewOption("        4. Updating asset's information.");
        menu.addNewOption("        5. Approve the request of employee.");
        menu.addNewOption("        6. Show list of borrow asset.");
        menu.addNewOption("        7. Exit.");

        Menu menu_Sub = new Menu("Management program for Employees. ");
        menu_Sub.addNewOption("      1. Login.");
        menu_Sub.addNewOption("      2. Search asset by name");
        menu_Sub.addNewOption("      3. Create a  request to borrow assets.");
        menu_Sub.addNewOption("      4. Exit.");

        AssetList a = new AssetList();
        a.addFromFile();
        int choice;
        do {
            choice = Validation.getAnInteger(("Enter your choice(1.BY MANAGER or 2.BY EMPLOYEES or 3.EXIT):  "), "Just 1 or 2 or 3.", 1, 3);
            if (choice == 1) {
                int choice_Manager;
                do {
                    menu.printMenu();
                    choice_Manager = menu.getChoice();
                    switch (choice_Manager) {
                        case 1:
                            boolean check  = a.loginManager();
                            if(check == true)
                                System.out.println("You login successfully.");
                            else
                                System.out.println("Fail.");
                            break;
                        case 2:
                            a.searchAsset();
                            break;
                        case 3:
                            a.createAsset();
                            a.writeToFile();
                            break;
                        case 4:
                            a.updateAsset();
                            a.writeToFile();
                            break;
                        case 5:
                            a.approveRequest();
                            a.writeToFile();
                            break;
                        case 6:
                            a.showListBorrow();
                            break;
                        case 7:                      
                            a.writeToFile();
                            System.out.println("Return main menu!");
                            break;
                    }
                } while (choice_Manager != 7);

            } else if (choice == 2) {
                int choice_Employees;
                do {
                    menu_Sub.printMenu();
                    choice_Employees = menu_Sub.getChoice();
                    switch (choice_Employees) {
                        case 1:
                            boolean check = a.loginEmployee();
                            if(check == true)
                                System.out.println("You login successfully.");
                            else
                                System.out.println("Wrong userID or password.");
                            break;
                        case 2:
                            a.searchAsset();
                            break;
                        case 3:
                            a.requestAsset();
                            break;
                        case 4:                      
                            a.writeToFile();
                            System.out.println("Return main menu!");
                            break;
                    }
                } while (choice_Employees != 4);

            } else {
                System.out.println("Bye,bye.See you next time!");
            }
        } while (choice != 3);

    }
}
