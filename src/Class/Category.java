package Class;


import java.util.ArrayList;

/**
 * @author HAT team Group 3 Nguyen Dong Hung, Ho Duy Anh, Tran Thanh Trong
 */
public class Category {

    private int id;//declare variables
    private String name;
    private boolean status;

    /**
     * Constructor
     */
    public Category() {
    }

    /**
     * constructor
     *
     * @param id
     * @param name
     * @param status
     */
    public Category(int id, String name, boolean status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    /**
     * get ID
     *
     * @return
     */
    public int getID() {
        return this.id;
    }

    /**
     * set ID
     *
     * @param aID
     */
    public void setID(int ID) throws CategoryException {
        if (ID <= 0) {
            throw new CategoryException("ID must be valid");
        } else {
            this.id = ID;
        }
    }

    /**
     * get Name
     *
     * @return
     */
    public String getName() {
        return this.name;
    }

    /**
     * set Name
     *
     * @param name
     */
    public void setName(String name) throws CategoryException {
        if (name.isEmpty()) {
            throw new CategoryException("Name must be valid");
        } else {
            this.name = name;
        }
    }

    /**
     * get Status
     *
     * @return
     */
    public boolean getStatus() {
        return this.status;
    }

    /**
     * set status
     *
     * @param status
     */
    public void setStatus(boolean status) throws CategoryException {
        if (status == true || status == false) {
            this.status = status;
        } else {
            throw new CategoryException("Status must be valid");
        }
    }

    /**
     * disable
     * @param id 
     */
    public void disable(int id) {
        if (this.id == id) {
            this.status = false;
        }
    }

    /**
     * active function
     * @param id 
     */
    public void active(int id) {
        if (this.id == id) {
            this.status = true;
        }
    }

    /**
     * get article function
     * @param la
     * @param id
     * @return 
     */
    public ArrayList<Article> getArticlesByCateID(ArrayList<Article> la, int id) {
        ArrayList<Article> list = new ArrayList<>();
        for (int i = 0; i < la.size(); i++) {
            if (la.get(i).getCateID() == id) {
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
