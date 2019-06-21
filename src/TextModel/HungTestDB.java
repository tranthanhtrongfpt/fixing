/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextModel;

import Class.*;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class HungTestDB {

    //get connection
    private static Connection conn;
    //gte usermodel
    private static UserModel um;
    //get role model
    private static RoleModel rm;

    public static void main(String[] args) {
        try {
            conn = DataConnection.getConnection();
            um = new UserModel();
            um.Load();
            rm = new RoleModel();
            rm.load();
            if (DataConnection.isConnection()) {
                //test Add
                //--------------------
                //um.addUser("longth", "Tran huynh Long", "hung@gmail.com", "Male", "1999-12-12", "0918241211", 3, true);
                //---------------------
                //Add success
                //=====================
                //Test update
                //---------------------
                //um.updateUser(16, "longth", "Long k pubg", "Long@gmail.com", "Male", "1990-12-12", "0918241211", 2, true);
                //---------------------
                //Update sucess
                //=====================
                //Test update psssword
                //---------------------
                //um.updatePasswordUser(16, "nguyendonghung");
                //---------------------
                //update success
                //=====================
                //search id
                //---------------------
                //System.out.println(um.SearchByID(1));
                //---------------------
                //search success
                //=====================
                //Test search by name
                //---------------------
                //System.out.println(um.SearchByName("l"));
                //---------------------
                //search success
                //=====================
                //Test search by email
                //---------------------
                //System.out.println(um.SearchByEmail("hung"));
                //---------------------
                //search success
                //=====================
                //Test search by phone
                //---------------------
                //System.out.println(um.SearchByPhone("09"));
                //---------------------
                //search success
                //=====================
                //Test Sort by name
                //---------------------
                //System.out.println(um.SortByName());
                //---------------------
                //sort success
                //=====================
                //Test get User
                //---------------------
                //System.out.println(um.getUser(13));
                //---------------------
                //get success
                //=====================
                //Test load Role
                //---------------------
                //System.out.println(rm.toString());
                //---------------------
                //load success
                //=====================
                //Test sarch by id
                //---------------------
                //System.out.println(rm.searchByID(2));
                //---------------------
                //search success
                //=====================
                //Test sarch by id 2
                //---------------------
                //System.out.println(rm.searchById2(2));
                //---------------------
                //search success
                //=====================
                //Test get role
                //---------------------
                //System.out.println(rm.getRole(2));
                //---------------------
                //get success
            } else {
                System.out.println("Error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
