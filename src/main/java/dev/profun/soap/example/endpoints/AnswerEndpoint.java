package dev.profun.soap.example.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import dev.profun.soap.example.samples.GetRequest;
import dev.profun.soap.example.samples.GetResponse;
import dev.profun.soap.example.services.AnswerService;

@Endpoint
public class AnswerEndpoint {

  private AnswerService answerService;
  
  @Autowired
  public void setAnswerService(AnswerService answerService) {
    this.answerService = answerService;
  }
  
  @PayloadRoot(namespace = "http://profun.dev/soap/example/samples", localPart = "getRequest")
  @ResponsePayload
  public GetResponse getResponse(@RequestPayload GetRequest request) {
    GetResponse response = new GetResponse();
    response.setAnswer(answerService.getAnswer(request.getValue()));
    return response;
  }
  
}
