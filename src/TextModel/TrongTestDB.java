/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextModel;

import Class.Category;
import Class.CategoryModel;
import Class.Comment;
import Class.CommentModel;
import Class.User;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class TrongTestDB {

    /**
     * Main function
     * @param args 
     */
    public static void main(String[] args) {
        try {
            
            //category
            CategoryModel cm = new CategoryModel();
            cm.load();
            ArrayList<Category> list = cm.getCates();
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).toString());
            }
            // cm.add("New Cate", false);
            // cm.update(1, "SUper han", true);
            //comment
            CommentModel comm = new CommentModel();
            comm.load();
            ArrayList<Comment> listComs = comm.getComs();
            for (int i = 0; i < listComs.size(); i++) {
                System.out.println(listComs.get(i).toString());
            }
            // comm.add(12, "Boring art", "thanhtrong@gam.com","1999-12-12", true);
            //  comm.update(12, 12, "iidesune", "thanhtrong@gmail.con","1999-12-12", true);
        } catch (SQLException e) {
        }
    }
}
