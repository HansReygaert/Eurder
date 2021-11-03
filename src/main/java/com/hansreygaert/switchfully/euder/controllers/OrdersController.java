package com.hansreygaert.switchfully.euder.controllers;

import com.hansreygaert.switchfully.euder.dtos.OrdersDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/orders")
public class OrdersController {

  @PostMapping(consumes = "application/json", produces = "application/json")
  @ResponseStatus(HttpStatus.CREATED)
  @ResponseBody
  public OrdersDto createOrder(@RequestHeader(value = "uuid") String idToken) {
    return null;
  }
}
