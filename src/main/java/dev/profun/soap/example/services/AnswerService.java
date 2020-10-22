package dev.profun.soap.example.services;

import org.springframework.stereotype.Component;

import dev.profun.soap.example.samples.Answer;

@Component
public class AnswerService {
  
  public Answer getAnswer(String text) {
    Answer answer = new Answer();
    answer.setText(text);
    return answer;
  } 

}
