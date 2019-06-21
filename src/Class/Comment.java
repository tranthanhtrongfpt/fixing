package Class;

/**
 * @author HAT team Group 3 Nguyen Dong Hung, Ho Duy Anh, Tran Thanh Trong
 */
import java.util.Date;
import java.util.ArrayList;

/**
 * Class for comment
 *
 * @author tranthanhtrong
 */
public class Comment implements Comparable {

    //Declare some variables
    private int ID;
    private int artID;
    private String content;
    private String email;
    private String dateComment;
    private boolean status;

    /**
     * Constructor for the comment class
     *
     * @param ID
     * @param artID
     * @param content
     * @param email
     * @param dateComment
     * @param status
     */
    public Comment(int ID, int artID, String content, String email, String dateComment, boolean status) {
        this.ID = ID;
        this.artID = artID;
        this.content = content;
        this.email = email;
        this.dateComment = dateComment;
        this.status = status;
    }

    /**
     * Get ID
     *
     * @return
     */
    public int getID() {
        return this.ID;
    }

    /**
     * set ID
     *
     * @param aID
     * @throws .CommentException
     */
    public void setID(int aID) throws CommentException {
        if (aID <= 0) {
            throw new CommentException("ID must be valid");
        }
        this.ID = aID;
    }

    /**
     * get Article ID
     *
     * @return
     */
    public int getArt_ID() {
        return this.artID;
    }

    /**
     * set Article ID
     *
     * @param aArt_ID
     * @throws .CommentException
     */
    public void setArt_ID(int aArt_ID) throws CommentException {
        if (aArt_ID <= 0) {
            throw new CommentException("Article ID must be valid");
        }
        this.artID = aArt_ID;
    }

    /**
     * get content
     *
     * @return
     */
    public String getContent() {
        return this.content;
    }

    /**
     * set Content
     *
     * @param aContent
     * @throws .CommentException
     */
    public void setContent(String aContent) throws CommentException {
        if (aContent.isEmpty()) {
            throw new CommentException("Content must be valid");
        }
        this.content = aContent;
    }

    /**
     * get the email
     *
     * @return
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * set the email
     *
     * @param aEmail
     * @throws .CommentException
     */
    public void setEmail(String aEmail) throws CommentException {
        if (aEmail.isEmpty()) {
            throw new CommentException("Email must be valid");
        }
        this.email = aEmail;
    }

    /**
     * get date comment
     *
     * @return
     */
    public String getDate_Comment() {
        return this.dateComment;
    }

    /**
     * set date comment
     *
     * @param aDate_Comment
     * @throws .CommentException
     */
    public void setDate_Comment(String aDate_Comment) throws CommentException {
        if (aDate_Comment.toString().isEmpty()) {
            throw new CommentException("Date must be valid");
        }
        this.dateComment = aDate_Comment;
    }

    /**
     * get status
     *
     * @return
     */
    public boolean getStatus() {
        return this.status;
    }

    /**
     * set status
     *
     * @param aStatus
     * @throws .CommentException
     */
    public void setStatus(boolean aStatus) throws CommentException {
        if (status == true || status == false) {
            this.status = aStatus;
        } else {
            throw new CommentException("Status must be valid");
        }
    }

    /**
     * disable
     *
     * @param id
     */
    public void disable(int id) {
        if (this.ID == id) {
            this.status = false;
        }
    }

    /**
     * active function
     *
     * @param id
     */
    public void active(int id) {
        if (this.ID == id) {
            this.status = true;
        }
    }

    /**
     * get article function
     *
     * @param la
     * @param id
     * @return
     */
    public Article getArticle(ArrayList<Article> la) {
        for (int i = 0; i < la.size(); i++) {
            if (la.get(i).getID() == this.artID) {
                return la.get(i);
            }
        }
        return null;
    }

    /**
     * set equals
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        Comment u = (Comment) obj;
        return ID >= u.getID();
    }

    /**
     * display user
     *
     * @return
     */
    @Override
    public String toString() {
        String str = "";

        str += ID + ". " + artID + ". " + content
                + ". " + email + ". " + dateComment
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
        Comment u = (Comment) o;
        int result = this.email.compareToIgnoreCase(u.getEmail());
        return result;
    }
}
