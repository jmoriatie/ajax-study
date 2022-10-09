package hello.ajax.util;

import hello.ajax.repository.domain.Item;
import hello.ajax.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class TestObjectInit {

    private final ItemService itemService;

    private final String[] ITEM_TYPE = {"프린팅", "해골", "다이나믹", "골져스", "프리티","디스트로이", "빈티지", "다크", "오버핏", "트레이닝"};
    private final String[] ITEM_CATEGORY ={"티셔츠", "팬츠", "조끼", "후드", "와이트팬츠", "반바지", "셔츠", "카라티", "청바지", "긴팔티셔츠"};

    @PostConstruct
    void testObjectInit(){
        Random random = new Random();

        for(int i=1; i<=60; i++){
            int price = random.nextInt(100000) + 10;
            int quantity = random.nextInt(1500) + 1;
            String type = ITEM_TYPE[random.nextInt(ITEM_TYPE.length)];
            String category = ITEM_CATEGORY[random.nextInt(ITEM_TYPE.length)];

            itemService.saveItem(new Item(type+"-"+category, price, quantity, "www.test"+i+".com"));
        }
    }
}
