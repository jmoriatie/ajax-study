package hello.ajax.controller;

import hello.ajax.repository.domain.Item;
import hello.ajax.service.ItemService;
import hello.ajax.util.ItemFinder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final ItemService service;
    private final ItemFinder finder;

    @GetMapping("/")
    public String sendTestPage(){
        return "view";
    }

    @PostMapping("/items")
    public String sendItemsPage(@RequestParam String keyword, Model model){
        List<Item> items = service.findAll();
        items = finder.searchListByItemName(keyword, items);

        log.info("keyword={}", keyword);
        log.info("items size={}", items.size());

        model.addAttribute("items", items);
        model.addAttribute("isItemsZero", items.size() == 0);

        return "items-list";
    }


}
