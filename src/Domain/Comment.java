package Domain;

public class Comment {
    private  String commented=" ";
    private  String comment=" ";
    private  String visitor=" ";
    private  String blogid=" ";
    private  String commentid=" ";
    private  String time=" ";

    public Comment(String commented, String comment, String visitor, String blogid, String commentid, String time) {
        this.commented = commented;
        this.comment = comment;
        this.visitor = visitor;
        this.blogid = blogid;
        this.commentid = commentid;
        this.time = time;
    }

    public Comment(){

    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getVisitor() {
        return visitor;
    }

    public void setVisitor(String visitor) {
        this.visitor = visitor;
    }

    public String getCommented() {
        return commented;
    }

    public void setCommented(String commented) {
        this.commented = commented;
    }

    public String getCommentid() {
        return commentid;
    }

    public void setCommentid(String commentid) {
        this.commentid = commentid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getBlogid() {
        return blogid;
    }

    public void setBlogid(String blogid) {
        this.blogid = blogid;
    }


}
