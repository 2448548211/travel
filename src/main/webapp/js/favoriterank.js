const BASE_URL = "http://localhost:8080/api/topAll";

const BASE_CONDITION_URL = "http://localhost:8080/api/topCondition";


$(function () {
    let params = {
        page: 1
    }

    $.get(BASE_URL,params,function (result) {
        if (result.code === 200){
            //数据展示 -- 前端未分页
            showTopFavorite(result.data.list);
        }
    })

    // <li>
    //     <span class="num one">1</span>
    //     <a href="route_detail.html"><img src="images/jiangxuan_4.jpg" alt=""></a>
    //     <h4><a href="route_detail.html">【尾单特卖】全国-曼谷6-7天自由行 泰国出境旅游 特价往6-7天自由行 泰国出境旅游 特价往..</a></h4>
    //     <p>
    //         <b class="price">&yen;<span>899</span>起</b>
    //         <span class="shouchang">已收藏450次</span>
    //     </p>
    // </li>
    //数据展示函数
    function showTopFavorite(topAll) {
        let index = 1;
        for (const topSingle of topAll) {
            $("#topFavorite").append(
                $("<li>").append(
                    $("<span>").addClass("num one").text(index++)
                ).append(
                    $("<a>").attr("href","route_detail.html?id="+topSingle.rid).append(
                        $("<img>").attr("src",topSingle.rimage)
                    )
                ).append(
                    $("<h4>").append(
                        $("<a>").attr("href","route_detail.html?id="+topSingle.rid).text(topSingle.rname)
                    )
                ).append(
                    $("<p>").append(
                        $('<b class="price">').text("￥"+topSingle.price).append(
                            $("<span>").text("起")
                        )
                    ).append(
                        $('<span class="shouchang">').text("已收藏"+topSingle.count+"次")
                    )
                )
            )
        }
    }


    //数据拿到 -- 前端未分页
    $("#btn").click(function () {
        //获取输入框的内容
        let params = {
            title: $("#title").val(),
            minPrice: $("#min").val(),
            maxPrice: $("#max").val(),
            //通过 page ++/-- 获取数据的偏移量
            page: 1
        }
        $.get(BASE_CONDITION_URL,params,function (result) {
            console.log(result.code)
            if (result.code === 200){
                //先清除原页面的数据 -- 设内容为空
                $("#topFavorite").html("");
                //再把获取的数据显示到页面
                showTopFavorite(result.data.list);
            }
        })
    })
})
