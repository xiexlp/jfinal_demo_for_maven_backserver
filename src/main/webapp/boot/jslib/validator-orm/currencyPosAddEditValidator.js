$.validator.setDefaults({
submitHandler : function(form) {
// alert("提交事件!");
// $("#blogactionaddForm").submit();
form.submit();
}
});

$().ready(function() {
$("#addCurrencyPosForm").validate({
rules : {
                                    currencyName : {
            required : true,
                    },
                                symbol : {
            required : true,
                    },
                                logoUrl : {
            required : true,
                    },
                                currentPrice : {
            required : true,
                    },
                                priceChange : {
            required : true,
                    },
                                volume : {
            required : true,
                        number : true,
                    },
                                marketCap : {
            required : true,
                    },
                                roi : {
            required : true,
                    },
                                nodeNum : {
            required : true,
                        number : true,
                    },
                                requiredNum : {
            required : true,
                        number : true,
                    },
                                mnWorth : {
            required : true,
                    },
                                createTime : {
            required : true,
                        number : true,
                    },
                                updateTime : {
            required : true,
                        number : true,
                    },
                                infoUrl : {
            required : true,
                    },
                                currencyId : {
            required : true,
                        number : true,
                    },
                                batchTime : {
            required : true,
                        number : true,
                    },
                                detailLink : {
            required : true,
                    },
            },
messages : {
                                        currencyName : {
                required : "currencyName字段必须填写!",
                            },
                                    symbol : {
                required : "symbol字段必须填写!",
                            },
                                    logoUrl : {
                required : "logoUrl字段必须填写!",
                            },
                                    currentPrice : {
                required : "currentPrice字段必须填写!",
                            },
                                    priceChange : {
                required : "priceChange字段必须填写!",
                            },
                                    volume : {
                required : "volume字段必须填写!",
                                number : "请输入合法的数字",
                            },
                                    marketCap : {
                required : "marketCap字段必须填写!",
                            },
                                    roi : {
                required : "roi字段必须填写!",
                            },
                                    nodeNum : {
                required : "nodeNum字段必须填写!",
                                number : "请输入合法的数字",
                            },
                                    requiredNum : {
                required : "requiredNum字段必须填写!",
                                number : "请输入合法的数字",
                            },
                                    mnWorth : {
                required : "mnWorth字段必须填写!",
                            },
                                    createTime : {
                required : "createTime字段必须填写!",
                                number : "请输入合法的数字",
                            },
                                    updateTime : {
                required : "updateTime字段必须填写!",
                                number : "请输入合法的数字",
                            },
                                    infoUrl : {
                required : "infoUrl字段必须填写!",
                            },
                                    currencyId : {
                required : "currencyId字段必须填写!",
                                number : "请输入合法的数字",
                            },
                                    batchTime : {
                required : "batchTime字段必须填写!",
                                number : "请输入合法的数字",
                            },
                                    detailLink : {
                required : "detailLink字段必须填写!",
                            },
            }
});

$("#editCurrencyPosForm").validate({
rules : {
    currencyPosId : {
        required : true,
                number : true,
            },
    currencyName : {
        required : true,
            },
    symbol : {
        required : true,
            },
    logoUrl : {
        required : true,
            },
    currentPrice : {
        required : true,
            },
    priceChange : {
        required : true,
            },
    volume : {
        required : true,
                number : true,
            },
    marketCap : {
        required : true,
            },
    roi : {
        required : true,
            },
    nodeNum : {
        required : true,
                number : true,
            },
    requiredNum : {
        required : true,
                number : true,
            },
    mnWorth : {
        required : true,
            },
    createTime : {
        required : true,
                number : true,
            },
    updateTime : {
        required : true,
                number : true,
            },
    infoUrl : {
        required : true,
            },
    currencyId : {
        required : true,
                number : true,
            },
    batchTime : {
        required : true,
                number : true,
            },
    detailLink : {
        required : true,
            },
},
messages : {
    currencyPosId : {
    required : "currencyPosId 字段必须填写!",
        number : "请输入合法的数字",
    },
    currencyName : {
    required : "currencyName 字段必须填写!",
    },
    symbol : {
    required : "symbol 字段必须填写!",
    },
    logoUrl : {
    required : "logoUrl 字段必须填写!",
    },
    currentPrice : {
    required : "currentPrice 字段必须填写!",
    },
    priceChange : {
    required : "priceChange 字段必须填写!",
    },
    volume : {
    required : "volume 字段必须填写!",
        number : "请输入合法的数字",
    },
    marketCap : {
    required : "marketCap 字段必须填写!",
    },
    roi : {
    required : "roi 字段必须填写!",
    },
    nodeNum : {
    required : "nodeNum 字段必须填写!",
        number : "请输入合法的数字",
    },
    requiredNum : {
    required : "requiredNum 字段必须填写!",
        number : "请输入合法的数字",
    },
    mnWorth : {
    required : "mnWorth 字段必须填写!",
    },
    createTime : {
    required : "createTime 字段必须填写!",
        number : "请输入合法的数字",
    },
    updateTime : {
    required : "updateTime 字段必须填写!",
        number : "请输入合法的数字",
    },
    infoUrl : {
    required : "infoUrl 字段必须填写!",
    },
    currencyId : {
    required : "currencyId 字段必须填写!",
        number : "请输入合法的数字",
    },
    batchTime : {
    required : "batchTime 字段必须填写!",
        number : "请输入合法的数字",
    },
    detailLink : {
    required : "detailLink 字段必须填写!",
    },
}
});

});