package org.pk.kakfa.producer.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Comment {
    private int commentId;
    private String comment;
    private String commentedBy;
    private LocalDateTime commentDate;

    public Comment() {
    }

    public Comment(int commentId, String comment, String commentedBy) {
        this.commentId = commentId;
        this.comment = comment;
        this.commentedBy = commentedBy;
        this.commentDate = LocalDateTime.now();
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCommentedBy() {
        return commentedBy;
    }

    public void setCommentedBy(String commentedBy) {
        this.commentedBy = commentedBy;
    }

    public LocalDateTime getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(LocalDateTime commentDate) {
        this.commentDate = commentDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comment comment1)) return false;
        return commentId == comment1.commentId && Objects.equals(comment, comment1.comment) && Objects.equals(commentedBy, comment1.commentedBy) && Objects.equals(commentDate, comment1.commentDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId, comment, commentedBy, commentDate);
    }

    @Override
    public String toString() {

        return """
                {
                "commentId":%s,
                "comment":%s,
                "commentedBy":%s,
                "commentDate":%s
                }""".formatted(commentId, comment, commentedBy, commentDate);
    }
}
