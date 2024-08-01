package day_0801.model;

// (Data Transfor Object) DTO == (Variable Object)Vo == BEAN
public class BoardDTO {
    private int no;
    private String title;
    private String content;
    private String writer;
    private int readCount;
    private String regDate;

    public BoardDTO() {}

    public BoardDTO(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

    public int getNo() {
        return no;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getWriter() {
        return writer;
    }

    public int getReadCount() {
        return readCount;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    @Override
    public String toString() {
        return "BoardDTO{" +
                "no=" + no +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", readCount=" + readCount +
                ", regDate='" + regDate + '\'' +
                '}';
    }
}
