package br.com.blogMicroservice.dto;

import java.util.Set;

public class TopicDTO {
    private Integer id;
    private String name;
    private Set<PostDTO> posts;

    public TopicDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<PostDTO> getPosts() {
        return posts;
    }

    public void setPosts(Set<PostDTO> posts) {
        this.posts = posts;
    }
}
