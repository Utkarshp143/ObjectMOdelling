package com.crio.codingame.repositories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.swing.text.html.parser.Entity;
import com.crio.codingame.entities.Level;
import com.crio.codingame.entities.Question;

public class QuestionRepository implements IQuestionRepository {

    private final Map<String,Question> questionMap;
    private Integer autoIncrement = 0;

    public QuestionRepository(){
        questionMap = new HashMap<String,Question>();
    }

    public QuestionRepository(Map<String, Question> questionMap) {
        this.questionMap = questionMap;
        this.autoIncrement = questionMap.size();
    }

    @Override
    public Question save(Question entity) {
        if( entity.getId() == null ){
            autoIncrement++;
            Question q = new Question(Integer.toString(autoIncrement),entity.getTitle(),entity.getLevel(),entity.getScore());
            questionMap.put(q.getId(),q);
            return q;
        }
        questionMap.put(entity.getId(),entity);
        return entity;
    }

    // TODO: CRIO_TASK_MODULE_SERVICES
    // Find all the list of Question Present in the Repository
    // Tip:- Use Java Streams

    @Override
    public List<Question> findAll() {
    //  return Collections.emptyList();
        List<Question> result = new ArrayList<>(questionMap.values());
        return result;
    }

    @Override
    public Optional<Question> findById(String id) {
        return Optional.ofNullable(questionMap.get(id));
    }

    @Override
    public boolean existsById(String id) {
        // TODO Auto-generated method stub
        return questionMap.containsKey(id) ? true : false;
    }

    @Override
    public void delete(Question entity) {
        questionMap.remove(entity.getId());
        // TODO Auto-generated method stub
    }

    @Override
    public void deleteById(String id) {
        if(questionMap.containsKey(id))
        {
            questionMap.remove(id);
        }
        // TODO Auto-generated method stub
        
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        return 0;
    }

    // TODO: CRIO_TASK_MODULE_SERVICES
    // Find all the list of Question Present in the Repository provided Level
    // Tip:- Use Java Streams

    // @Override
    // public List<Question> findAllQuestionLevelWise(Level level) {
    //     List<Question> levelWise=findAll().stream().filter(s -> s.getLevel() == level).collect(Collectors.toList());
    //  return levelWise;
    // }

    @Override
    public List<Question> findAllQuestionLevelWise(Level level) {
        // List<Question> requireslist=new ArrayList<>();
        // requireslist.addAll(questionMap.values());
    //  return Collections.emptyList();
    if(level == null){
        // // requireslist.addAll(questionMap.values());
        // return requireslist;
        return (List<Question>) questionMap.values();
    }
    else{
        return questionMap.values().stream().filter(entity -> entity.getLevel() == level).collect(Collectors.toList());
    }
    }
    
}
