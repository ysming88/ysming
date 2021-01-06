package Domain;

public class Blog {
    private  String writer=" ";
    private  String title=" ";
    private  String content=" ";
    private  String date=" ";
    private  String label=" ";
    private  String category=" ";
    private  String original=" ";
    private  String id=" ";
    private  String recommend=" ";

    public Blog(){

    }

    public Blog(String writer, String title, String content, String date, String label, String category, String original,String id,String recommend) {
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.date = date;
        this.label = label;
        this.category = category;
        this.original = original;
        this.id = id;
        this.recommend = recommend;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getOriginal() {
        return original;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "writer='" + writer + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", date='" + date + '\'' +
                ", label='" + label + '\'' +
                ", category='" + category + '\'' +
                ", original='" + original + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
