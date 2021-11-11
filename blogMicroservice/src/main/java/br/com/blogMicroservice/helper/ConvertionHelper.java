package br.com.blogMicroservice.helper;

import br.com.blogMicroservice.dto.PostDTO;
import br.com.blogMicroservice.entity.Post;
import java.util.Objects;

public class ConvertionHelper {
    public static PostDTO buildPostDTO(final Post post) {
        if (Objects.nonNull(post)) {
            return new PostDTO(post.getId(), post.getTitle(), post.getText(),Objects.nonNull(post.getTopic()) ? post.getTopic().getName() : "");
        }
        return null;
    }

}
