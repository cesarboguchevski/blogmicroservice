package br.com.blogMicroservice.entity;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "text")
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topic_id")
    private Topic topic;


}
