package com.example.springlearn.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.servlet.http.PushBuilder;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author : jiangchanghong
 * @version : 2019-11-22 10:05
 **/
@RestController
@RestControllerAdvice
public class Web1 {
  @ModelAttribute(name = "model")
  public String setUpForm() {
    return "modeltest";
  }
  @InitBinder
  public void initBinder(WebDataBinder binder) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    dateFormat.setLenient(false);
    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
  }
  @ExceptionHandler
  public ResponseEntity<String> handle(Exception ex,
      HandlerMethod handlerMethod) {
    return ResponseEntity.ok("ok"+handlerMethod.toString());
  }
  @PostMapping(path = "/web1"
//      ,
//      consumes = "application/json",//content type
//      produces = "application/json" //accept
      ,params = {"test"}
//      ,headers = "h1=1"
  )
  @ResponseBody
  public String web(WebRequest webRequest, PushBuilder pushBuilder,
      Locale locale,
      @PathVariable(value = "pathv",required = false) String pathv
  , @MatrixVariable(required = false) String mv
  ,@RequestParam String test
  ,@RequestHeader(required = false) String h1,
      @CookieValue(required = false) String cookie,
  @RequestPart(required = false) MultipartFile file,
  @RequestBody String body,@ModelAttribute(name = "model") String model,
      BindingResult bindingResult,
      @SessionAttribute(required = false) String session,
      @RequestAttribute(required = false) String reatrrribute) {
    return "ok";
  }
}
