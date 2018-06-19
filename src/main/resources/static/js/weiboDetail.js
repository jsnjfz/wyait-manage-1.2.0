/**
 * 用户管理
 */
var pageCurr;
$(function() {
    layui.use('table', function(){
        var table = layui.table
            ,form = layui.form;

        tableIns=table.render({
            elem: '#weiboDetail'
            ,url:'/weibo/detail?userId=' + getQueryStringArgs().userId
            ,method: 'get' //默认：get请求
            ,page: true,
            request: {
                pageName: 'page' //页码的参数名称，默认：page
                ,limitName: 'size' //每页数据量的参数名，默认：limit
            },response:{
                statusName: 'code' //数据状态的字段名称，默认：code
                ,statusCode: 200 //成功的状态码，默认：0
                ,countName: 'totals' //数据总数的字段名称，默认：count
                ,dataName: 'list' //数据列表的字段名称，默认：data
            }
            ,cols: [[
                {field:'userId', title:'用户id', minWidth:20}
                ,{field:'weiboContent', title:'微博内容', minWidth:200}
                ,{field:'yuanchuang', title: '是否原创', minWidth:10}
                ,{field:'weiboReContent', title: '转发内容'}
                ,{title:'全文',minWidth:20, toolbar: '#optBar'}
                ,{field:'weiboPlace', title: '微博地点', minWidth:20}
                ,{field:'publishTime', title: '发布时间', minWidth:30}
                ,{field:'publishTool', title: '发布工具', minWidth:30}
                ,{field:'upNum', title: '点赞数', minWidth:10}
                ,{field:'retweetNum', title: '转发数', minWidth:10}
                ,{field:'commentNum', title: '评论数', minWidth:10}
                // ,{field:'weiboId', display:'none'}
            ]]
            ,  done: function(res, curr, count){
                //如果是异步请求数据方式，res即为你接口返回的信息。
                //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
                //console.log(res);
                //得到当前页码
                //console.log(curr);
                //得到数据总量
                //console.log(count);
                pageCurr=curr;
            }
        });

        //监听工具条
        table.on('tool(userTable)', function(obj){
            var data = obj.data;
            if(obj.event === 'quanwen'){
                //编辑
                getUserAndRoles(data,data.weiboId);
            }
        });

    });

});

//解锁用户
function nolockUser(){
    //TODO 给个输入框，让用户管理员输入需要解锁的用户手机号，进行解锁操作即可
    layer.alert("TODO");
}

function load(obj){
    //重新加载table
    tableIns.reload({
        where: obj.field
        , page: {
            curr: pageCurr //从当前页码开始
        }
    });
}

function getQueryStringArgs() {
    var qs = (location.search.length > 0 ? location.search.substring(1) : '')
    var args = {}
    var items = qs.length ? qs.split('&') : []
    var item = null
    var name = null
    var value = null
    var len = items.length

    for (var i = 0; i < len; i++) {
        item = items[i].split('=')
        name = decodeURIComponent(item[0])
        value = decodeURIComponent(item[1])

        if (name.length) {
            args[name] = value
        }
    }

    return args
}

function getUserAndRoles(obj,id) {
        //回显数据
        $.get("/weibo/quanwen",{"weiboId":id},function(data){
                if(data.msg=="ok" && data.weibore!=null){
                    $("textarea[name='weiboContent']").val(data.weibore.weiboContent);
                    layer.open({
                        type:1,
                        title: "全文",
                        fixed:false,
                        resize :false,
                        shadeClose: true,
                        area: ['550px'],
                        content:$('#setUser')
                    });

                }else{
                    //弹出错误提示
                    layer.alert(data.msg,function () {
                        layer.closeAll();
                    });
                }
        });
}

