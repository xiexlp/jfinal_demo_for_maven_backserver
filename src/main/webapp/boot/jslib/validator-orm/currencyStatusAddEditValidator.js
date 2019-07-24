$.validator.setDefaults({
submitHandler : function(form) {
// alert("提交事件!");
// $("#blogactionaddForm").submit();
form.submit();
}
});

$().ready(function() {
$("#addCurrencyStatusForm").validate({
rules : {
                                    posPanelNum : {
            required : true,
                        number : true,
                    },
                                pricePanelNum : {
            required : true,
                        number : true,
                    },
                                posLastBatchTime : {
            required : true,
                        number : true,
                    },
                                priceLastBatchTime : {
            required : true,
                        number : true,
                    },
                                createTime : {
            required : true,
                        number : true,
                    },
                                updateTime : {
            required : true,
                        number : true,
                    },
            },
messages : {
                                        posPanelNum : {
                required : "posPanelNum字段必须填写!",
                                number : "请输入合法的数字",
                            },
                                    pricePanelNum : {
                required : "pricePanelNum字段必须填写!",
                                number : "请输入合法的数字",
                            },
                                    posLastBatchTime : {
                required : "posLastBatchTime字段必须填写!",
                                number : "请输入合法的数字",
                            },
                                    priceLastBatchTime : {
                required : "priceLastBatchTime字段必须填写!",
                                number : "请输入合法的数字",
                            },
                                    createTime : {
                required : "createTime字段必须填写!",
                                number : "请输入合法的数字",
                            },
                                    updateTime : {
                required : "updateTime字段必须填写!",
                                number : "请输入合法的数字",
                            },
            }
});

$("#editCurrencyStatusForm").validate({
rules : {
    currencyStatusId : {
        required : true,
                number : true,
            },
    posPanelNum : {
        required : true,
                number : true,
            },
    pricePanelNum : {
        required : true,
                number : true,
            },
    posLastBatchTime : {
        required : true,
                number : true,
            },
    priceLastBatchTime : {
        required : true,
                number : true,
            },
    createTime : {
        required : true,
                number : true,
            },
    updateTime : {
        required : true,
                number : true,
            },
},
messages : {
    currencyStatusId : {
    required : "currencyStatusId 字段必须填写!",
        number : "请输入合法的数字",
    },
    posPanelNum : {
    required : "posPanelNum 字段必须填写!",
        number : "请输入合法的数字",
    },
    pricePanelNum : {
    required : "pricePanelNum 字段必须填写!",
        number : "请输入合法的数字",
    },
    posLastBatchTime : {
    required : "posLastBatchTime 字段必须填写!",
        number : "请输入合法的数字",
    },
    priceLastBatchTime : {
    required : "priceLastBatchTime 字段必须填写!",
        number : "请输入合法的数字",
    },
    createTime : {
    required : "createTime 字段必须填写!",
        number : "请输入合法的数字",
    },
    updateTime : {
    required : "updateTime 字段必须填写!",
        number : "请输入合法的数字",
    },
}
});

});