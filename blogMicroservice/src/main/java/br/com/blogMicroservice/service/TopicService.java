package br.com.blogMicroservice.service;

import br.com.blogMicroservice.dto.PostDTO;
import br.com.blogMicroservice.dto.TopicDTO;
import br.com.blogMicroservice.entity.Post;
import br.com.blogMicroservice.entity.Topic;
import br.com.blogMicroservice.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class TopicService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void updateTopic(int topicId, TopicDTO updated) throws EntityNotFoundException {
        Topic topic = entityManager.find(Topic.class, topicId);
        if (topic != null) {
            topic.setName(updated.getName());
        } else {
            throw new EntityNotFoundException(Topic.class, topicId);
        }
    }


    public List<PostDTO> listPostTitlesAndTopics(int pageNumber, int pageSize) {
        List<Post> posts = entityManager
                .createQuery("SELECT p FROM Post p")
                .setFirstResult((pageNumber - 1) * pageSize)
                .setMaxResults(pageSize)
                .getResultList();
        List<PostDTO> result = new ArrayList(posts.size());

        for(Post post : posts) {
            PostDTO postDto = new PostDTO();
            postDto.setId(post.getId());
            postDto.setTitle(post.getTitle());
            postDto.setText(post.getText());
            postDto.setTopicName(post.getTopic().getName());
            result.add(postDto);
        }

        return result;
    }


}
