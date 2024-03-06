package com.beta.replyservice.tests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.beta.replyservice.service.ReplyServiceImpl;

@SpringBootTest
public class ReplyServiceTests {

  @Autowired
  private ReplyServiceImpl replyServiceImpl;

  @Test
  public void testGetReverse() {
    String ip = "jason",op = "nosaj";
    String output = replyServiceImpl.getReverse(ip);
    Assert.isTrue(output.equals(op), "String not reverse");
  }

  @Test
  public void testGetFormattedResponseA() {
    String ip = "11-kbzw9ru",op = "kbzw9ru";
    String output = replyServiceImpl.getFormattedResponse(ip);
    Assert.isTrue(output.equals(op), "Expected output is not received");
  }

  @Test
  public void testGetFormattedResponseB() {
    String ip = "12-kbzw9ru",op = "5a8973b3b1fafaeaadf10e195c6e1dd4";
    String output = replyServiceImpl.getFormattedResponse(ip);
    Assert.isTrue(output.equals(op), "Expected output is not received");
  }

  @Test
  public void testGetFormattedResponseC() {
    String ip = "22-kbzw9ru",op = "e8501e64cf0a9fa45e3c25aa9e77ffd5";
    String output = replyServiceImpl.getFormattedResponse(ip);
    Assert.isTrue(output.equals(op), "Expected output is not received");
  }
}