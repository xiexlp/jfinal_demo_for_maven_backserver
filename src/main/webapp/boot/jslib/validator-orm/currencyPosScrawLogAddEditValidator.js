$.validator.setDefaults({
submitHandler : function(form) {
// alert("提交事件!");
// $("#blogactionaddForm").submit();
form.submit();
}
});

$().ready(function() {
$("#addCurrencyPosScrawLogForm").validate({
rules : {
                                    posBatchTime : {
            required : true,
                        number : true,
                    },
                                posBatchNum : {
            required : true,
                        number : true,
                    },
            },
messages : {
                                        posBatchTime : {
                required : "posBatchTime字段必须填写!",
                                number : "请输入合法的数字",
                            },
                                    posBatchNum : {
                required : "posBatchNum字段必须填写!",
                                number : "请输入合法的数字",
                            },
            }
});

$("#editCurrencyPosScrawLogForm").validate({
rules : {
    currencyPosScrawLogId : {
        required : true,
                number : true,
            },
    posBatchTime : {
        required : true,
                number : true,
            },
    posBatchNum : {
        required : true,
                number : true,
            },
},
messages : {
    currencyPosScrawLogId : {
    required : "currencyPosScrawLogId 字段必须填写!",
        number : "请输入合法的数字",
    },
    posBatchTime : {
    required : "posBatchTime 字段必须填写!",
        number : "请输入合法的数字",
    },
    posBatchNum : {
    required : "posBatchNum 字段必须填写!",
        number : "请输入合法的数字",
    },
}
});

});