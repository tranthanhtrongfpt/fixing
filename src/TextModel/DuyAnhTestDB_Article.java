/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextModel;

import Class.*;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class DuyAnhTestDB_Article {
    /**
     * Main fucntion
     * @param args 
     */
    public static void main(String[] args) {
        try {
            ArticleModel am = new ArticleModel();
            am.Load();
            ArrayList<Article> list = am.getsArticleList();
            for (int i = 0; i < list.size(); i++) {
              System.out.println(list.get(i).toString());
            }
        } catch (SQLException ex) {
           //Logger.getLogger(DuyAnhTestDB_Article.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
