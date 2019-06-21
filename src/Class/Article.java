package Class;

import java.util.Date;

/**
 * @author HAT team Group 3 Nguyen Dong Hung, Ho Duy Anh, Tran Thanh Trong
 */
public class Article implements Comparable {

    private int ID;
    private String content;
    private int mainAuthorID;
    private int editorID;
    private Date datePub;
    private int cateID;
    private String desPic;
    private String destext;
    private String title;
    private boolean status;

    /**
     * Article stuff
     *
     * @param iD
     * @param mainAuthorID
     * @param editorID
     * @param cateID
     * @param content
     * @param datePub
     * @param destext
     * @param desPic
     * @param title
     * @param status
     */
    public Article(int iD, int mainAuthorID, int editorID, int cateID, String content, Date datePub, String destext, String desPic, String title, boolean status) {
        this.ID = iD;
        this.mainAuthorID = mainAuthorID;
        this.content = content;
        this.editorID = editorID;
        this.datePub = datePub;
        this.destext = destext;
        this.desPic = desPic;
        this.title = title;
        this.status = status;
        this.cateID = cateID;
    }

    /**
     * get ID
     *
     * @return
     */
    public int getID() {
        return ID;
    }

    /**
     * set ID
     *
     * @param aID
     * @throws ArticleException
     */
    public void setID(int aID) throws ArticleException {
        if (aID <= 0) {
            throw new ArticleException("Id must greater tha zero");
        } else {
            this.ID = ID;
        }
    }

    /**
     * get content
     *
     * @return
     */
    public String getContent() {
        return content;
    }

    /**
     * set content
     *
     * @param content
     * @throws ArticleException
     */
    public void setContent(String content) throws ArticleException {
        if (content.isEmpty()) {
            throw new ArticleException("Content of title cannot empty");
        } else {
            this.content = content;
        }
    }

    /**
     * get main author ID
     *
     * @return
     */
    public int getMainAuthorID() {
        return mainAuthorID;
    }

    /**
     * set main author ID
     *
     * @param mainAuthorID
     * @throws ArticleException
     */
    public void setMainAuthorID(int mainAuthorID) throws ArticleException {
        if (mainAuthorID <= 0) {
            throw new ArticleException("MainAuthorID must greater tha zero");
        } else {
            this.mainAuthorID = mainAuthorID;
        }
    }

    /**
     * get editor id
     *
     * @return
     */
    public int getEditorID() {
        return editorID;
    }

    /**
     * set editor ID
     *
     * @param editorID
     * @throws ArticleException
     */
    public void setEditorID(int editorID) throws ArticleException {
        if (editorID <= 0) {
            throw new ArticleException("EditorID must greater tha zero");
        } else {
            this.editorID = editorID;
        }
    }

    /**
     * get Date publish
     *
     * @return
     */
    public Date getDatePub() {
        return datePub;
    }

    /**
     * set date publish
     *
     * @param datePub
     * @throws ArticleException
     */
    public void setDatePub(Date datePub) throws ArticleException {
        if (datePub.equals(null)) {
            throw new ArticleException("DatePub cannot empty");
        } else {
            this.datePub = datePub;
        }
    }

    /**
     * get category id
     *
     * @return
     */
    public int getCateID() {
        return cateID;
    }

    /**
     * set category id
     *
     * @param cateID
     * @throws ArticleException
     */
    public void setCateID(int cateID) throws ArticleException {
        if (cateID <= 0) {
            throw new ArticleException("CateID must greater tha zero");
        } else {
            this.cateID = cateID;
        }
    }

    /**
     * get description picture
     *
     * @return
     */
    public String getDesPic() {
        return desPic;
    }

    /**
     * set description picture
     *
     * @param aDesPic
     * @throws ArticleException
     */
    public void setDesPic(String aDesPic) throws ArticleException {
        if (aDesPic.isEmpty()) {
            throw new ArticleException("DesPic cannot empty");
        } else {
            this.desPic = desPic;
        }
    }

    /**
     * get description text
     *
     * @return
     */
    public String getDestext() {
        return destext;
    }

    /**
     * set description text
     *
     * @param destext
     * @throws ArticleException
     */
    public void setDestext(String destext) throws ArticleException {
        if (destext.isEmpty()) {
            throw new ArticleException("Destext cannot empty");
        } else {
            this.destext = destext;
        }
    }

    /**
     * get title
     *
     * @return
     */
    public String getTittle() {
        return title;
    }

    /**
     * set title
     *
     * @param aTitle
     * @throws ArticleException
     */
    public void setTittle(String aTitle) throws ArticleException {
        if (title.isEmpty()) {
            throw new ArticleException("Tittle cannot empty");
        } else {
            this.title = title;
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
     * @throws ArticleException
     */
    public void setStatus(boolean status) throws ArticleException {
        this.status = status;
    }

    /**
     * set equals
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        Article u = (Article) obj;
        return title.equals(u.getTittle());
    }

    /**
     * display user
     *
     * @return
     */
    @Override
    public String toString() {
        String str = "";
        str += ID + ". " + mainAuthorID + ". " + editorID
                + ". " + datePub + ". " + cateID + ". " + title
                + ". " + status + "\n";
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
        Article u = (Article) o;
        int result = this.title.compareToIgnoreCase(u.title);
        return result;
    }
}
