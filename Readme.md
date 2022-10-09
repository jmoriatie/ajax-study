
> # Ajax 활용한 비동기 통신( model, json 활용 )
> ### item list 검색해서 찾기 
___
#### [흐름]
````
view(input) -> ajax -> RestController -> service -> repository -> ajax -> view

장점: 예외처리 js(front 단)로 처리 가능
단점: 개인적인 표현 방법 미숙 append 활용 외 템플릿과 연계된 좋은 방법 서칭 필요
````
````
view(input) -> ajax -> Controller -> service -> repository
    -> Model에 담기 -> item-list.html -> view를 replaceWith

장점: Thymeleaf 가 이미 렌더링 된 값 간단하게 삽입 가능
단점: 예외처리 시 서버에 값 추가 필요
(Controller 에 check로직을 추가해줘야 한다는 점, 이미 랜더링 된 값을 교체하기 때문) 
````

#### [과정]
* item List 더미데이터 만들기 (util)
* item domain, repository, service 작성 
* Controller, RestController 작성
* 검색어 통해 찾아주는 ItemFinder 객체 분리
* static resources 추가 (item.js 및 jquery)
* 템플릿 작성 (view.html, item-list.html)
* html 작성 및 thymeleaf 연동
* model, json 객체 활용한 item List search 
* 검색되지 않았을 경우 예외처리 추가
 
