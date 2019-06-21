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

    private static Connection conn;
    private static UserModel um;

    public static void main(String[] args) {
        try {
            conn = DataConnection.getConnection();
            um = new UserModel();
            um.Load();
            if (DataConnection.isConnection()) {
//                um.addUser("Duyanh", "12345678", "Duy Anh", "duyanh@gmail.com", "Male", "1999-11-05","0918241211", 1, true);
//                um = new UserModel();
//                um.Load();
//                ArrayList<User> list = um.getUserList();
//                for (int i = 0; i < list.size(); i++) {
//                    System.out.println(list.get(i).toString());
//                }
                
            } else {
                System.out.println("Error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
