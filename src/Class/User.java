package Class;

import java.util.ArrayList;
/**
 * @author HAT team Group 3
 * Nguyen Dong Hung, Ho Duy Anh, Tran Thanh Trong
 */
public class User {

    //input data
    private int ID;
    private String username;
    private String password;
    private String name;
    private String email;
    private String gender;
    private String birthday;
    private String phone;
    private int role_ID;
    private boolean status;

    public User() {
    }

    /**
     * constructor
     *
     * @param ID
     * @param username
     * @param password
     * @param name
     * @param email
     * @param gender
     * @param birthday
     * @param phone
     * @param role_ID
     * @param status
     */
    public User(int ID, String username, String password, String name, String email, String gender, String birthday, String phone, int role_ID, boolean status) {
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.birthday = birthday;
        this.phone = phone;
        this.role_ID = role_ID;
        this.status = status;
    }

    /**
     * get id
     *
     * @return
     */
    public int getID() {
        return ID;
    }

    /**
     * set id
     *
     * @param ID
     * @throws UserException
     */
    public void setID(int ID) throws UserException {
        if (ID <= 0) {
            throw new UserException("Id must greater tha zero");
        } else {
            this.ID = ID;
        }
    }

    /**
     * get username
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     * set username
     *
     * @param username
     * @throws UserException
     */
    public void setUsername(String username) throws UserException {
        if (username.isEmpty()) {
            throw new UserException("Username title cannot empty");
        } else {
            this.username = username;
        }
    }

    /**
     * get password
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * set pass word
     *
     * @param password
     * @throws UserException
     */
    public void setPassword(String password) throws UserException {
        if (password.isEmpty()) {
            throw new UserException("Password title cannot empty");
        } else {
            this.password = password;
        }
    }

    /**
     * get name
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * set name
     *
     * @param name
     * @throws UserException
     */
    public void setName(String name) throws UserException {
        if (name.isEmpty()) {
            throw new UserException("Name title cannot empty");
        } else {
            this.name = name;
        }
    }

    /**
     * get email
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * set email
     *
     * @param email
     * @throws UserException
     */
    public void setEmail(String email) throws UserException {
        if (email.isEmpty()) {
            throw new UserException("Email title cannot empty");
        } else {
            this.email = email;
        }
    }

    /**
     * get gender
     *
     * @return
     */
    public String getGender() {
        return gender;
    }

    /**
     * set gender
     *
     * @param gender
     * @throws UserException
     */
    public void setGender(String gender) throws UserException {
        if (gender.isEmpty()) {
            throw new UserException("Gender title cannot empty");
        } else {
            this.gender = gender;
        }
    }

    /**
     * get birthday
     *
     * @return
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * set birth day
     *
     * @param birthday
     * @throws UserException
     */
    public void setBirthday(String birthday) throws UserException {
        if (birthday.isEmpty()) {
            throw new UserException("Birthday title cannot empty");
        } else {
            this.birthday = birthday;
        }
    }

    /**
     * get phone
     *
     * @return
     */
    public String getPhone() {
        return phone;
    }

    /**
     * set phone
     *
     * @param phone
     * @throws UserException
     */
    public void setPhone(String phone) throws UserException {
        if (phone.isEmpty()) {
            throw new UserException("Phone title cannot empty");
        } else {
            this.phone = phone;
        }
    }

    /**
     * get role id
     *
     * @return
     */
    public int getRole_ID() {
        return role_ID;
    }

    /**
     * set role id
     *
     * @param role_ID
     * @throws UserException
     */
    public void setRole_ID(int role_ID) throws UserException {
        if (role_ID <= 0) {
            throw new UserException("Role ID title cannot empty");
        } else {
            this.role_ID = role_ID;
        }
    }

    /**
     * get status
     *
     * @return
     */
    public boolean getStatus() {
        return status;
    }

    /**
     * set status
     *
     * @param status
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    
    /**
     * disable
     * @param id 
     */
    public void disable(int id) {
        if (this.ID == id) {
            this.status = false;
        }
    }

    /**
     * active function
     * @param id 
     */
    public void active(int id) {
        if (this.ID == id) {
            this.status = true;
        }
    }

    /**
     * get article function
     * @param la
     * @param id
     * @return 
     */
    public ArrayList<Article> getArticles(ArrayList<Article> la) {
        ArrayList<Article> list = new ArrayList<>();
        for (int i = 0; i < la.size(); i++) {
            if (la.get(i).getMainAuthorID() == this.ID) {
                list.add(la.get(i));
            }
        }
        if (list.isEmpty()) {
            return null;
        } else {
            return list;
        }
    }
}