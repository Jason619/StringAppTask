package com.beta.replyservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.beta.replyservice.service.IReplyService;
@RestController
public class ReplyController {
	@Autowired
	public IReplyService replyService;
	@Value("${config.msg.regex}")
	public String regex;
	/*Existing code - Starts*/
	@GetMapping("/reply")
	public ReplyMessage replying() {
		return new ReplyMessage("Message is empty");
	}
	@GetMapping("/reply/{message}")
	public ReplyMessage replying(@PathVariable String message) {
		return new ReplyMessage(message);
	}
	/*Existing code - Ends*/
	/**
	 * Handles GET requests to '/v2/reply/{message}' endpoint.
	 *
	 * @param message The message path variable.
	 * @return The reply message object.
	 * @throws ResponseStatusException If the input message is invalid.
	 */
	@GetMapping("/v2/reply/{message}")
	public ReplyMessage replyTask(@PathVariable String message) {
		if (!message.matches(regex)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid input");
		}
		return new ReplyMessage(replyService.getFormattedResponse(message));
	}
}