package hello.ajax.service;

import hello.ajax.repository.domain.Item;

import java.util.List;

public interface ItemService {

    Item saveItem(Item item);
    List<Item> findAll();
    Item findById(Long id);
    Item findByName(String itemName);
    void updateItem(Long id, Item item);
    void deleteItem(Long id);
}
