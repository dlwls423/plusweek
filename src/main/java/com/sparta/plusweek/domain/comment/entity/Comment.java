package com.sparta.plusweek.domain.comment.entity;

import com.sparta.plusweek.domain.post.entity.Post;
import com.sparta.plusweek.domain.user.entity.User;
import com.sparta.plusweek.global.TimeStamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "tb_comment")
public class Comment extends TimeStamp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long commentId;

    @Column(nullable = false, length = 500)
    private String text;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "postId")
    private Post post;

    @Builder
    public Comment(Long commentId, String text, User user, Post post) {
        this.commentId = commentId;
        this.text = text;
        this.user = user;
        this.post = post;
    }
}
