/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextModel;

import Class.User;
import Class.UserModel;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class DuyAnhTestDB {
    public static void main(String[] args) {
        try {
            UserModel um = new UserModel();
            um.Load();
            ArrayList<User> list = um.getUserList();
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).toString());
            }
        } catch (Exception e) {
        }
    }
}
