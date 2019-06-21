package Class;

/**
 * @author HAT team Group 3 Nguyen Dong Hung, Ho Duy Anh, Tran Thanh Trong
 */
public class Role implements Comparable {

    //Input data
    private int ID;
    private String Role_Title;

    public Role() {
    }

    /**
     * Constructor
     *
     * @param ID
     * @param Role_Title
     */
    public Role(int ID, String Role_Title) {
        this.ID = ID;
        this.Role_Title = Role_Title;
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
     * get role title
     *
     * @return
     */
    public String getRole_Title() {
        return Role_Title;
    }

    /**
     * set role title
     *
     * @param Role_Title
     * @throws RoleException
     */
    public void setRole_Title(String Role_Title) throws RoleException {
        if (Role_Title.isEmpty()) {
            throw new RoleException("Role title cannot empty");
        } else {
            this.Role_Title = Role_Title;
        }
    }

    /**
     * set equals
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        Role u = (Role) obj;
        return Role_Title.equals(u.getRole_Title());
    }

    /**
     * display user
     *
     * @return
     */
    @Override
    public String toString() {
        String str = "";

        str += ID + ". " + Role_Title + "\n";
        return str;
    }

    /**
     * compare username
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(Object o) {
        Role u = (Role) o;
        int result = this.Role_Title.compareToIgnoreCase(u.getRole_Title());
        return result;
    }

}
