
/**
 * @author HAT team Group 3
 * Nguyen Dong Hung, Ho Duy Anh, Tran Thanh Trong
 */
public class Article {

    private int ID;
    private String content;
    private int mainAuthorID;
    private int editorID;
    private String datePub;
    private int cateID;
    private String desPic;
    private String destext;
    private String title;
    private boolean status;

//Constructor
    public Article(int iD, int mainAuthorID, int editorID, int cateID, String content, String datePub, String destext, String desPic, String title, boolean status) {
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

//getter and setter
    public int getID() {
        return ID;
    }

    public void setID(int aID) throws ArticleException {
        if (aID <= 0) {
            throw new ArticleException("Id must greater tha zero");
        } else {
            this.ID = ID;
        }
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) throws ArticleException {
        if (content.isEmpty()) {
            throw new ArticleException("Content of title cannot empty");
        } else {
            this.content = content;
        }
    }

    public int getMainAuthorID() {
        return mainAuthorID;
    }

    public void setMainAuthorID(int mainAuthorID) throws ArticleException {
        if (mainAuthorID <= 0) {
            throw new ArticleException("MainAuthorID must greater tha zero");
        } else {
            this.mainAuthorID = mainAuthorID;
        }
    }

    public int getEditorID() {
        return editorID;
    }

    public void setEditorID(int editorID) throws ArticleException {
        if (editorID <= 0) {
            throw new ArticleException("EditorID must greater tha zero");
        } else {
            this.editorID = editorID;
        }
    }

    public String getDatePub() {
        return datePub;
    }

    public void setDatePub(String datePub) throws ArticleException {
        if (datePub.isEmpty()) {
            throw new ArticleException("DatePub cannot empty");
        } else {
            this.datePub = datePub;
        }
    }

    public int getCateID() {
        return cateID;
    }

    public void setCateID(int cateID) throws ArticleException {
        if (cateID <= 0) {
            throw new ArticleException("CateID must greater tha zero");
        } else {
            this.cateID = cateID;
        }
    }

    public String getDesPic() {
        return desPic;
    }

    public void setDesPic(String aDesPic) throws ArticleException {
        if (aDesPic.isEmpty()) {
            throw new ArticleException("DesPic cannot empty");
        } else {
            this.desPic = desPic;
        }
    }

    public String getDestext() {
        return destext;
    }

    public void setDestext(String destext) throws ArticleException {
        if (destext.isEmpty()) {
            throw new ArticleException("Destext cannot empty");
        } else {
            this.destext = destext;
        }
    }

    public String getTittle() {
        return title;
    }

    public void setTittle(String aTitle) throws ArticleException {
        if (title.isEmpty()) {
            throw new ArticleException("Tittle cannot empty");
        } else {
            this.title = title;
        }
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) throws ArticleException {
        this.status = status;
    }
}
