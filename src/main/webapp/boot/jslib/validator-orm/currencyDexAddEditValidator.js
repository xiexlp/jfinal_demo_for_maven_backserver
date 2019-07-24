$.validator.setDefaults({
submitHandler : function(form) {
// alert("提交事件!");
// $("#blogactionaddForm").submit();
form.submit();
}
});

$().ready(function() {
$("#addCurrencyDexForm").validate({
rules : {
                                    name : {
            required : true,
                    },
                                url : {
            required : true,
                    },
                                logoUrl : {
            required : true,
                    },
            },
messages : {
                                        name : {
                required : "name字段必须填写!",
                            },
                                    url : {
                required : "url字段必须填写!",
                            },
                                    logoUrl : {
                required : "logoUrl字段必须填写!",
                            },
            }
});

$("#editCurrencyDexForm").validate({
rules : {
    dexId : {
        required : true,
                number : true,
            },
    name : {
        required : true,
            },
    url : {
        required : true,
            },
    logoUrl : {
        required : true,
            },
},
messages : {
    dexId : {
    required : "dexId 字段必须填写!",
        number : "请输入合法的数字",
    },
    name : {
    required : "name 字段必须填写!",
    },
    url : {
    required : "url 字段必须填写!",
    },
    logoUrl : {
    required : "logoUrl 字段必须填写!",
    },
}
});

});