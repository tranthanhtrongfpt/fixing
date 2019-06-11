
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author HAT team Group 3 
 * Nguyen Dong Hung, Ho Duy Anh, Tran Thanh Trong
 */
public class UserModel {

    //declare some variables
    private String tableName = "User";
    private Connection conn;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;
    private String sqlStr;
    private ArrayList<User> users;

    /**
     * Constructor for userModel
     * @throws SQLException 
     */
    public UserModel() throws SQLException {
        try {
            conn = DataConnection.getConnection();
            st = conn.createStatement();
            pst = null;
            rs = null;
            sqlStr = "";
            users = new ArrayList<User>();
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }
    
    /**
     * Load function for loading the stuff
     * @throws SQLException 
     */
    public void Load() throws SQLException {
        try {
            sqlStr = "SELECT * FROM " + tableName + "";
            rs = st.executeQuery(sqlStr);
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    int Id = rs.getInt("ID");
                    String username = rs.getString("Username");
                    String password = rs.getString("Password");
                    String name = rs.getString("Name");
                    String email = rs.getString("Email");
                    String gender = rs.getString("Gender");
                    String birthday = rs.getString("Birthday");
                    String phone = rs.getString("Phone");
                    int role_id = rs.getInt("Role_ID");
                    boolean status = rs.getBoolean("Status");
                    users.add(new User(Id, username, password, name, email, gender, birthday, phone, role_id, status));
                }
            }
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean addUser(
            String username, String password, String name,
            String email, String gender, String birthday,
            String phone, int role_id, boolean status
    ) throws SQLException, Exception {
        try {
            sqlStr = "INSERT INTO " + tableName + " VALUES (?,?,?,?,?,?,?,?);";
            pst = conn.prepareStatement(sqlStr);
            int id = users.get(users.size() - 1).getID() + 1;
            pst.setInt(1, id);
            pst.setString(2, username);
            pst.setString(3, password);
            pst.setString(4, name);
            pst.setString(5, email);
            pst.setString(6, gender);
            pst.setString(7, birthday);
            pst.setString(8, phone);
            pst.setInt(9, role_id);
            pst.setBoolean(10, status);
            pst.executeUpdate();
            users.add(new User(id, username, password, name, email, gender, birthday, phone, role_id, status));
            return true;
        } catch (SQLException e) {
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean updateWord(
            int id, String username, String password, String name,
            String email, String gender, String birthday,
            String phone, int role_id, boolean status
    ) throws SQLException, Exception {
        try {
            sqlStr = "UPDATE " + tableName + " where `ID`=? VALUES (?,?,?,?,?,?,?,?,?,?);";
            pst = conn.prepareStatement(sqlStr);
            pst.setInt(1, id);
            pst.setInt(2, id);
            pst.setString(3, username);
            pst.setString(4, password);
            pst.setString(5, name);
            pst.setString(6, email);
            pst.setString(7, gender);
            pst.setString(8, birthday);
            pst.setString(9, phone);
            pst.setInt(10, role_id);
            pst.setBoolean(10, status);
            pst.executeUpdate();
            getUser(id).setUsername(username);
            getUser(id).setPassword(password);
            getUser(id).setName(name);
            getUser(id).setEmail(email);
            getUser(id).setGender(gender);
            getUser(id).setBirthday(birthday);
            getUser(id).setPhone(phone);
            getUser(id).setRole_ID(role_id);
            getUser(id).setStatus(status);
            return true;
        } catch (SQLException e) {
            return false;
        } catch (RoleException e) {
            return false;
        }
    }

    public int Search(int id) {
        for (int i = 0; i < users.size(); i++) {
            User w = users.get(i);
            if (w.getID() == id) {
                return i;
            }
        }
        return -1;
    }

    public User getUser(int id) {
        int idx = Search(id);
        if (idx != -1) {
            return this.users.get(idx);
        } else {
            return null;
        }
    }

    public int getSize() {
        return users.size();
    }

    @Override
    public String toString() {
        String str = "";
        for (User w : users) {
            str += w.getID() + ". " + w.getUsername() + ". " + w.getPassword()
                    + ". " + w.getName() + ". " + w.getEmail() + ". " + w.getGender()
                    + ". " + w.getBirthday() + ". " + w.getPhone()
                    + ". " + w.getRole_ID() + ". " + w.getStatus() + "\n";
        }
        return str;
    }
}
