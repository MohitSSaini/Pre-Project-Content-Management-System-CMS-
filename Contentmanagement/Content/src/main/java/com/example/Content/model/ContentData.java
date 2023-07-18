package com.example.Content.model;


import java.util.Objects;

public class ContentData {
    private int cid;
    private String title;
    private String description;
    private String  writer;
    private String topic;

    public ContentData() {
    }

    public ContentData(int cid, String title, String description, String writer, String topic) {
        this.cid = cid;
        this.title = title;
        this.description = description;
        this.writer = writer;
        this.topic = topic;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContentData that = (ContentData) o;
        return cid == that.cid && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(writer, that.writer) && Objects.equals(topic, that.topic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cid, title, description, writer, topic);
    }

    @Override
    public String toString() {
        return "ContentData{" +
                "cid=" + cid +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", writer='" + writer + '\'' +
                ", topic='" + topic + '\'' +
                '}';
    }
}
