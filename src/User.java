
import java.util.ArrayList;


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
     * @throws RoleException
     */
    public void setID(int ID) throws RoleException {
        if (ID <= 0) {
            throw new RoleException("Id must greater tha zero");
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
     * @throws RoleException
     */
    public void setUsername(String username) throws RoleException {
        if (username.isEmpty()) {
            throw new RoleException("Username title cannot empty");
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
     * @throws RoleException
     */
    public void setPassword(String password) throws RoleException {
        if (password.isEmpty()) {
            throw new RoleException("Password title cannot empty");
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
     * @throws RoleException
     */
    public void setName(String name) throws RoleException {
        if (name.isEmpty()) {
            throw new RoleException("Name title cannot empty");
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
     * @throws RoleException
     */
    public void setEmail(String email) throws RoleException {
        if (email.isEmpty()) {
            throw new RoleException("Email title cannot empty");
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
     * @throws RoleException
     */
    public void setGender(String gender) throws RoleException {
        if (gender.isEmpty()) {
            throw new RoleException("Gender title cannot empty");
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
     * @throws RoleException
     */
    public void setBirthday(String birthday) throws RoleException {
        if (birthday.isEmpty()) {
            throw new RoleException("Birthday title cannot empty");
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
     * @throws RoleException
     */
    public void setPhone(String phone) throws RoleException {
        if (phone.isEmpty()) {
            throw new RoleException("Phone title cannot empty");
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
     * @throws RoleException
     */
    public void setRole_ID(int role_ID) throws RoleException {
        if (role_ID <= 0) {
            throw new RoleException("Role ID title cannot empty");
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
