
var pageCurr;
$(function() {
    layui.use('table', function(){
        var table = layui.table
            ,form = layui.form;

        tableIns=table.render({
            elem: '#visitList'
            ,url:'/visit'
            ,method: 'get' //默认：get请求
            ,cellMinWidth: 80
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
                {field:'id', title:'ID',width:80, unresize: true, sort: true, minWidth:20}
                ,{field:'patientId', title:'patientId',sort: true}
                ,{field:'visitDate', title:'就诊日期'}
                ,{field:'age', title:'年龄'}
                ,{field:'mailingAddress', title:'邮寄地址'}
                ,{field:'birthPlace', title: '出生地'}
                ,{field:'zipCode', title: '邮编'}
                ,{field:'sex', title: '性别'}
                ,{field:'chargeType', title: '缴费方式'}
                ,{field:'identity', title: '身份'}
                ,{field:'nation', title: '民族'}
                ,{field:'idNo', title: '身份证号'}
                ,{field:'diagDesc', title: '诊断说明'}
                ,{field:'illnessDesc', title: '病情说明'}
                ,{field:'anamnesis', title: '病史'}
                ,{field:'familyIll', title: '家族病'}
                ,{field:'marrital', title: '婚否'}
                ,{field:'individual', title: '个体'}
                ,{field:'menses', title: '月经'}
                ,{field:'medHistory', title: '用药历史'}
                ,{field:'bodyExam', title: '体检'}
                ,{field:'deptName', title: '部门'}

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

        //监听在职操作
        form.on('switch(isJobTpl)', function(obj){
            //console.log(this.value + ' ' + this.name + '：'+ obj.elem.checked, obj.othis);
            setJobUser(obj,this.value,this.name,obj.elem.checked);
        });
        //监听工具条
        table.on('tool(userTable)', function(obj){
            var data = obj.data;
            if(obj.event === 'del'){
                delUser(data,data.id,data.username);
            } else if(obj.event === 'weibo'){
                //编辑
                getWeibo(data,data.userId);
            } else if(obj.event === 'recover'){
                //恢复
                recoverUser(data,data.id);
            }
        });
        //监听提交
        form.on('submit(userSubmit)', function(data){
            // TODO 校验
            formSubmit(data);
            return false;
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

function cleanUser(){
    //$("#id").val("");
    $("#username").val("");
    $("#mobile").val("");
    $("#email").val("");
    $("#password").val("");
}


