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
public class Employee {
    private String id;
    private String name;
    private String birthDate;
    private String role;
    private String sex;
    private String password;

    public Employee(String id, String name, String birthDate, String role, String sex, String password) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.role = role;
        this.sex = sex;
        this.password = password;
    }

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + birthDate + "," + role + "," + sex + "," + password;
    }
    
}
