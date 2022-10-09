package hello.ajax.controller;

import hello.ajax.repository.domain.Item;
import hello.ajax.service.ItemService;
import hello.ajax.util.ItemFinder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class APIController {

    private final ItemService service;
    private final ItemFinder finder;

    @GetMapping( "/items")
    ResponseEntity<Object> findAll(String keyword){
        List<Item> allItemList = service.findAll();
        if(!keyword.isEmpty()){
            allItemList = finder.searchListByItemName(keyword, allItemList);
        }

        return new ResponseEntity<>(allItemList, HttpStatus.OK);
    }
}
