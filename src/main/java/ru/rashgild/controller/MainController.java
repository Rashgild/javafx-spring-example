package ru.rashgild.controller;


import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.rashgild.service.HelloService;

@Component
public class MainController extends AbstractController {

    @FXML
    public TextField text;
    @Autowired
    private HelloService service;

    @FXML
    public void sayHello() {
        text.setText(service.sayHello());
    }
}
