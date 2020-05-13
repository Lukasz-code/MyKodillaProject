package com.crud.tasks.controller;

import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.trello.client.TrelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/v1/trello")
public class TrelloController {

    @Autowired
    private TrelloClient trelloClient;

    @RequestMapping(method = RequestMethod.GET, value = "getTrelloBoards")
    public void getTrelloBoards() {
        System.out.println("wywołane getTrelloBoards");
        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();
        System.out.println("wyświetl ile elementów ma lista: " + trelloBoards.size());
        trelloBoards.stream()
           .map(s -> s.getName() +" id: " + s.getId())
                .filter(s -> s.contains("Kodilla"))
                .forEach(System.out::println);

    }
}