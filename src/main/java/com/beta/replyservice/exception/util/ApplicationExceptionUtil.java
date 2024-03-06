package com.beta.replyservice.exception.util;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.beta.replyservice.exception.dto.ErrorVo;

@ControllerAdvice
@RestController
public class ApplicationExceptionUtil {
	
	/**
	 * Handles exceptions of type ResponseStatusException by returning an error response with the appropriate status code and message.
	 *
	 * @param e The ResponseStatusException that was thrown
	 * @return A ResponseEntity containing an ErrorVo object with the status code and message extracted from the given exception
	 */
	@ExceptionHandler(ResponseStatusException.class)
	public ResponseEntity<ErrorVo> checkBadRequest(ResponseStatusException e) {
		ErrorVo errorVo = new ErrorVo();
		errorVo.setCode(e.getStatus().value());
		errorVo.setMessage(e.getReason());
		ResponseEntity<ErrorVo> respErr = new ResponseEntity<>(errorVo, e.getStatus());
		return respErr;
	}
}
