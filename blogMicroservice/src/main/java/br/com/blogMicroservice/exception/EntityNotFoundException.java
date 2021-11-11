package br.com.blogMicroservice.exception;


public class EntityNotFoundException extends Exception {

    public EntityNotFoundException(Class topicClass, long topicId) {
        super("Error when searching entity class " + topicClass.getName() + " with id = " + topicId);
    }
}
