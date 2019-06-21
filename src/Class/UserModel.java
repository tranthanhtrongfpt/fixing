package Class;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author HAT team Group 3 Nguyen Dong Hung, Ho Duy Anh, Tran Thanh Trong
 */
public class UserModel {

    //declare some variables
    private String tableName = "user";
    private Connection conn;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;
    private String sqlStr;
    private ArrayList<User> users;

    /**
     * Constructor for userModel
     *
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
     *
     * @throws SQLException
     */
    public void Load() throws SQLException {
        try {
            sqlStr = "SELECT * FROM `user` WHERE 1";
            rs = st.executeQuery(sqlStr);
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    int Id = rs.getInt("ID");
                    String username = rs.getString("Username");
                    String password = rs.getString("Password");
                    String name = rs.getString("Name");
                    String email = rs.getString("Email");
                    String gender = rs.getString("Gender");
                    String birthday = rs.getString("Birthdate");
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

    /**
     * Function for add the user
     *
     * @param username
     * @param password
     * @param name
     * @param email
     * @param gender
     * @param birthday
     * @param phone
     * @param role_id
     * @param status
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public boolean addUser(
            String username, String password, String name,
            String email, String gender, String birthday,
            String phone, int role_id, boolean status
    ) throws SQLException, Exception {
        try {
            sqlStr = "INSERT INTO `user`(`ID`, `Username`, `Password`, `Name`, `Email`, `Gender`, `Birthdate`, `Phone`, `Role_ID`, `Status`) VALUES (null,?,?,?,?,?,?,?,?,?)";
            pst = conn.prepareStatement(sqlStr, Statement.RETURN_GENERATED_KEYS);

            pst.setString(1, username);
            pst.setString(2, password);
            pst.setString(3, name);
            pst.setString(4, email);
            pst.setString(5, gender);
            pst.setString(6, birthday);
            pst.setString(7, phone);
            pst.setInt(8, role_id);
            pst.setBoolean(9, status);
            pst.executeUpdate();
            int sz = users.size();
            if (rs.next()) {
                int id = rs.getInt(1);
                users.add(new User(id, username, password, name, email, gender, birthday, phone, role_id, status));
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Function for updateUser
     *
     * @param id
     * @param username
     * @param password
     * @param name
     * @param email
     * @param gender
     * @param birthday
     * @param phone
     * @param role_id
     * @param status
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public boolean updateUser(
            int id, String username, String password, String name,
            String email, String gender, String birthday,
            String phone, int role_id, boolean status
    ) throws SQLException, Exception {
        try {
            sqlStr = "UPDATE " + tableName + " where `ID`=? VALUES (?,?,?,?,?,?,?,?,?,?);";
            pst = conn.prepareStatement(sqlStr);
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
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Function for search by ID
     *
     * @param id
     * @return
     */
    public int SearchByID(int id) {
        for (int i = 0; i < users.size(); i++) {
            User w = users.get(i);
            if (w.getID() == id) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Function for search by Name
     *
     * @param name
     * @return
     */
    public ArrayList SearchByName(String name) {
        ArrayList<User> arr = new ArrayList<>();
        for (User u : users) {
            if (u.getName().toLowerCase().contains(name.trim().toLowerCase())) {
                arr.add(u);
            }
        }
        return arr;
    }

    /**
     * Function for search by Phone
     *
     * @param phone
     * @return
     */
    public ArrayList SearchByPhone(String phone) {
        ArrayList<User> arr = new ArrayList<>();
        for (User u : users) {
            if (u.getPhone().toLowerCase().contains(phone.trim().toLowerCase())) {
                arr.add(u);
            }
        }
        return arr;
    }

    /**
     * Function for search by Email
     *
     * @param email
     * @return
     */
    public ArrayList SearchByEmail(String email) {
        ArrayList<User> arr = new ArrayList<>();
        for (User u : users) {
            if (u.getEmail().toLowerCase().contains(email.trim().toLowerCase())) {
                arr.add(u);
            }
        }
        return arr;
    }

    /**
     * sort array by name of user
     *
     * @return
     */
    public ArrayList SortByName() {
        ArrayList<User> u = new ArrayList<>();
        System.arraycopy(users, 0, u, 0, users.size());
        Collections.sort(u, new Comparator<User>() {
            @Override
            public int compare(User s1, User s2) {
                return s1.getUsername().compareTo(s2.getUsername());
            }
        });
        return u;
    }

    /**
     * function for get user by ID
     *
     * @param id
     * @return
     */
    public User getUser(int id) {
        int idx = SearchByID(id);
        if (idx != -1) {
            return this.users.get(idx);
        } else {
            return null;
        }
    }

    /**
     * function for get size
     *
     * @return
     */
    public int getSize() {
        return users.size();
    }

    /**
     * get to String function
     *
     * @return
     */
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

    public ArrayList<User> getUserList() {
        return users;
    }
}
