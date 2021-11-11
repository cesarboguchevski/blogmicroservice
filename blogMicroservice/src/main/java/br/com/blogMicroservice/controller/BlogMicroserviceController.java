package br.com.blogMicroservice.controller;

import br.com.blogMicroservice.dto.PostDTO;
import br.com.blogMicroservice.dto.TopicDTO;
import br.com.blogMicroservice.exception.EntityNotFoundException;
import br.com.blogMicroservice.service.TopicService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import static org.springframework.http.HttpStatus.OK;


@Slf4j
@Validated
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class BlogMicroserviceController {

    private final TopicService topicService;

    @GetMapping("/list-post-titles-and-topics")
    public Page<PostDTO> listPostTitlesAndTopics(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") @Min(10) @Max(25) Integer size) {
        return new PageImpl<>(topicService.listPostTitlesAndTopics(page, size));
    }

    @PutMapping("/update-topic/{id}")
    @ResponseStatus(OK)
    public void updateTopic(@PathVariable("id") @NotNull @Positive Integer id, @RequestBody @Valid TopicDTO topicDTO) {
        try {
            topicService.updateTopic(id, topicDTO);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
        }
    }
}
