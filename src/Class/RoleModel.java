package Class;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author HAT team Group 3 Nguyen Dong Hung, Ho Duy Anh, Tran Thanh Trong
 */
public class RoleModel {

    private String tableName = "Role";
    private Connection conn;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;
    private String sqlStr;
    private ArrayList<Role> roles;

    /**
     * Constructor for initial the things
     *
     * @throws SQLException
     */
    public RoleModel() throws SQLException {
        try {
            conn = DataConnection.getConnection();
            st = conn.createStatement();
            pst = null;
            rs = null;
            sqlStr = "";
            roles = new ArrayList<Role>();
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Load function for loading the stuff
     *
     * @throws SQLException
     */
    public void load() throws SQLException {
        try {
            sqlStr = "SELECT * FROM `role` WHERE 1";
            rs = st.executeQuery(sqlStr);
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    int Id = rs.getInt("ID");
                    String Title = rs.getString("Role_Title");
                    roles.add(new Role(Id, Title));
                }
            }
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * search by ID
     *
     * @param id
     * @return
     */
    public int searchByID(int id) {
        for (int i = 0; i < roles.size(); i++) {
            Role w = roles.get(i);
            if (w.getID() == id) {
                return i;
            }
        }
        return -1;
    }

    /**
     * search By id
     *
     * @param id
     * @return
     */
    public String searchById2(int id) {
        for (int i = 0; i < roles.size(); i++) {
            if (roles.get(i).getID() == id) {
                return roles.get(i).getRole_Title();
            }
        }
        return null;
    }

    /**
     * get role
     *
     * @param id
     * @return
     */
    public Role getRole(int id) {
        int idx = searchByID(id);
        if (idx != -1) {
            return this.roles.get(idx);
        } else {
            return null;
        }
    }

    /**
     * get size
     *
     * @return
     */
    public int getSize() {
        return roles.size();
    }

    @Override
    public String toString() {
        String str = "";
        for (Role w : roles) {
            str += w.getID() + ". " + w.getRole_Title() + "\n";
        }
        return str;
    }

    /**
     * return list of object
     *
     * @return
     */
    public ArrayList<Role> getRoleList() {
        return roles;
    }
}
