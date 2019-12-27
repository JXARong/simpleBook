function clickRelation() {

}

/**
 * 进行关注与取消关注
 * @param status false：取消关注   true：关注
 * @param cid 被关注人编号
 * @returns {boolean} true已关注，false未关注
 */
function relation(status,cid) {
    var flag = false;
    $.ajax({
        url: "/simpleBook/relation/changeRelational",
        data: {cid: cid, status: status},
        async:false,
        type: "post",
        success: function (data) {
            if (data) {
                flag=true;
                layer.msg(status == "true" ? "关注成功" : "取消关注成功");
            } else {
                layer.msg(status == "true" ? "关注失败" : "取消关注失败");
            }

        }, error: function () {
                layer.msg("啊哦，服务器繁忙，操作失败");
        }
    });
    return flag;
}

/**
 * 获取关注信息
 * @param cid 被关注人
 * @returns {boolean} true已关注，false未关注
 */
function getRelation(cid) {
    var isRelation=false;
    $.ajax({
        url: "/simpleBook/relation/verifyIsRelation",
        data: {cid: cid},
        async:false,
        type: "post",
        success: function (data) {
            isRelation=data;
        }
    });
    return isRelation;
}