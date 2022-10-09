package hello.ajax.util;

import hello.ajax.repository.domain.Item;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ItemFinder {

    // 검색기능
    public List<Item> searchListByItemName(String keyword, List<Item> items) {
        List<Item> searchItems = new ArrayList<>();
        if(keyword.isEmpty()){
            searchItems = items;
        }else{
            for(Item item : items){
                if(item.getItemName().contains(keyword)){
                    searchItems.add(item);
                }
            }
        }
        return searchItems;
    }
}
