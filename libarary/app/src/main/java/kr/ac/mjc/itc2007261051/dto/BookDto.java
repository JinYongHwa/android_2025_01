package kr.ac.mjc.itc2007261051.dto;

public class BookDto {

    private int id;
    private String thumbnailUrl;
    private String titleStatement;
    private String author;
    private String publication;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getTitleStatement() {
        return titleStatement;
    }

    public void setTitleStatement(String titleStatement) {
        this.titleStatement = titleStatement;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }
}
