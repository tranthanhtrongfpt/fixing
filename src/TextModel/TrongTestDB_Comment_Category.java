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
public class TrongTestDB_Comment_Category {

    /**
     * Main function
     * @param args 
     */
    public static void main(String[] args) {
        try {
            //==================== CATEGORY ====================================
            //===== Showing
            CategoryModel cm = new CategoryModel();
            cm.load();
            ArrayList<Category> list = cm.getCates();
            for (int i = 0; i < list.size(); i++) {
                //System.out.println("Here is list of category!");
                //System.out.println(list.get(i).toString());
            }
            //===== Add
            //cm.add("New1", false);
            
            //===== Update
            //cm.update(4, "Category Updated", true);
            
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            
            //==================== COMMENT =====================================
            //===== Showing
            CommentModel comm = new CommentModel();
            comm.load();
            ArrayList<Comment> listComs = comm.getComs();
            for (int i = 0; i < listComs.size(); i++) {
                //System.out.println("Here is list of comment!");
                //System.out.println(listComs.get(i).toString());
            }
            //===== Add
             //comm.add(12, "Boring art", "thanhtrong@gam.com","1999-12-12", true);
            
            //===== Update
            //comm.update(12, 12, "updated comment success", "thanhtrong@gmail.con","1999-12-12", true);
        } catch (SQLException e) {
        }
    }
}
