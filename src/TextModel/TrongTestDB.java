/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextModel;

import Class.Category;
import Class.CategoryModel;
import Class.User;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class TrongTestDB {
    public static void main(String[] args) {
        try {
            CategoryModel um = new CategoryModel();
            um.load();
            ArrayList<Category> list = um.getCates();
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).toString());
            }
        } catch (SQLException e) {
        }
    }
}
