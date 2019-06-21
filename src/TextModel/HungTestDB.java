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
//            rm = new RoleModel();
//            rm.load();
            if (DataConnection.isConnection()) {
                um.updateUser(15, "khang", "1212121", "khang lam", "khang@gmail.com", "Male", "1999-12-12", "0918241211", 3, true);
//                um = new UserModel();
//                um.Load();
//                ArrayList<User> list = um.SearchByEmail("con");
//                for (int i = 0; i < list.size(); i++) {
//                    System.out.println(list.get(i).toString());
//                }
                System.out.println(um.getUser(15).getName());

//                ArrayList<Role> list = rm.getRoleList();
//                for (int i = 0; i < list.size(); i++) {
//                    System.out.println(list.get(i).toString());
//                }
//                
//                System.out.println(rm.getRole(1).getRole_Title());
            } else {
                System.out.println("Error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
