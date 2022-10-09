// const serverAddress = 'http://localhost:8080/v1/item-api/items';

// JSON -> this page id 값에 append(HTML 태그와 함께)
function getItems() {
    $('#t_view').empty();
    const keyword = $('#input-json-text').val();
    $.ajax({
        method: "get",
        url: "/api/items",
        data: {"keyword":keyword},
        dataType: "json"
    }).done(
        function (itemList) {
            console.log(itemList);
            if(itemList.length === 0){
                $('#t_view').append(`<p> 검색한 키워드의 아이템이 없습니다. </p>`)
            }
            itemList.forEach(item => {
                $('#t_view').append(
                    `
                    <tr>
                        <td><a href='/item/item?search-item=${item.id}'>${item.itemName}</a></td>
                        <td>${item.price}</td>
                        <td>${item.quantity}</td>
                    </tr>
                    `
                );
            })
        }).fail(function () {
        alert("오류");
    });
}

// 그냥 Controller 의 Model 객체
// ajax -> Controller -> return 삽입할 html page(with Model) -> replaceWith -> this page 해당 id 에 삽입
// ㄴ 장점은 Thymeleaf 가 렌더링 된 값을 삽입 가능
// ㄴ 단점은 검색된 item이 없을 때, Controller 에 check로직을 추가해줘야 한다는 점
function getItemsModel() {
    $('#t_view-model').empty();
    const inputData = $('#input-text').val();
    $.ajax({
        method: "post",
        url: "/items",
        data:{"keyword": inputData},
        dataType: "html"
    }).done(
        function (itemListHtml){
           console.log(itemListHtml);
           $('#t_view-model').replaceWith(itemListHtml);
        }
    )
}


function test(test) {
    alert("this is test : " + test);
}

function showAlert() {
    alert("The button was clicked!");
}