$.validator.setDefaults({
submitHandler : function(form) {
// alert("提交事件!");
// $("#blogactionaddForm").submit();
form.submit();
}
});

$().ready(function() {
$("#addCurrencyInfoForm").validate({
rules : {
                                    name : {
            required : true,
                    },
                                symbol : {
            required : true,
                    },
                                volume : {
            required : true,
                        number : true,
                    },
                                circulatingVolume : {
            required : true,
                        number : true,
                    },
                                initPrice : {
            required : true,
                    },
                                initDate : {
            required : true,
                        number : true,
                    },
                                url : {
            required : true,
                    },
                                currencyDesc : {
            required : true,
                    },
                                srcWebId : {
            required : true,
                        number : true,
                    },
                                currencyIdName : {
            required : true,
                    },
                                detailLink : {
            required : true,
                    },
                                masterLink : {
            required : true,
                    },
            },
messages : {
                                        name : {
                required : "name字段必须填写!",
                            },
                                    symbol : {
                required : "symbol字段必须填写!",
                            },
                                    volume : {
                required : "volume字段必须填写!",
                                number : "请输入合法的数字",
                            },
                                    circulatingVolume : {
                required : "circulatingVolume字段必须填写!",
                                number : "请输入合法的数字",
                            },
                                    initPrice : {
                required : "initPrice字段必须填写!",
                            },
                                    initDate : {
                required : "initDate字段必须填写!",
                                number : "请输入合法的数字",
                            },
                                    url : {
                required : "url字段必须填写!",
                            },
                                    currencyDesc : {
                required : "currencyDesc字段必须填写!",
                            },
                                    srcWebId : {
                required : "srcWebId字段必须填写!",
                                number : "请输入合法的数字",
                            },
                                    currencyIdName : {
                required : "currencyIdName字段必须填写!",
                            },
                                    detailLink : {
                required : "detailLink字段必须填写!",
                            },
                                    masterLink : {
                required : "masterLink字段必须填写!",
                            },
            }
});

$("#editCurrencyInfoForm").validate({
rules : {
    currencyId : {
        required : true,
                number : true,
            },
    name : {
        required : true,
            },
    symbol : {
        required : true,
            },
    volume : {
        required : true,
                number : true,
            },
    circulatingVolume : {
        required : true,
                number : true,
            },
    initPrice : {
        required : true,
            },
    initDate : {
        required : true,
                number : true,
            },
    url : {
        required : true,
            },
    currencyDesc : {
        required : true,
            },
    srcWebId : {
        required : true,
                number : true,
            },
    currencyIdName : {
        required : true,
            },
    detailLink : {
        required : true,
            },
    masterLink : {
        required : true,
            },
},
messages : {
    currencyId : {
    required : "currencyId 字段必须填写!",
        number : "请输入合法的数字",
    },
    name : {
    required : "name 字段必须填写!",
    },
    symbol : {
    required : "symbol 字段必须填写!",
    },
    volume : {
    required : "volume 字段必须填写!",
        number : "请输入合法的数字",
    },
    circulatingVolume : {
    required : "circulatingVolume 字段必须填写!",
        number : "请输入合法的数字",
    },
    initPrice : {
    required : "initPrice 字段必须填写!",
    },
    initDate : {
    required : "initDate 字段必须填写!",
        number : "请输入合法的数字",
    },
    url : {
    required : "url 字段必须填写!",
    },
    currencyDesc : {
    required : "currencyDesc 字段必须填写!",
    },
    srcWebId : {
    required : "srcWebId 字段必须填写!",
        number : "请输入合法的数字",
    },
    currencyIdName : {
    required : "currencyIdName 字段必须填写!",
    },
    detailLink : {
    required : "detailLink 字段必须填写!",
    },
    masterLink : {
    required : "masterLink 字段必须填写!",
    },
}
});

});