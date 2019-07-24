$.validator.setDefaults({
submitHandler : function(form) {
// alert("提交事件!");
// $("#blogactionaddForm").submit();
form.submit();
}
});

$().ready(function() {
$("#addCurrencyPriceForm").validate({
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
                                currentPrice : {
            required : true,
                    },
                                priceChange : {
            required : true,
                    },
                                dexId : {
            required : true,
                        number : true,
                    },
                                dexName : {
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
                                volume : {
            required : true,
                        number : true,
                    },
                                circulatingVolume : {
            required : true,
                        number : true,
                    },
                                marketCap : {
            required : true,
                    },
                                rankMarketCap : {
            required : true,
                        number : true,
                    },
                                batchTime : {
            required : true,
                        number : true,
                    },
                                infoUrl : {
            required : true,
                    },
            },
messages : {
                                        currencyId : {
                required : "currencyId字段必须填写!",
                                number : "请输入合法的数字",
                            },
                                    name : {
                required : "name字段必须填写!",
                            },
                                    symbol : {
                required : "symbol字段必须填写!",
                            },
                                    currentPrice : {
                required : "currentPrice字段必须填写!",
                            },
                                    priceChange : {
                required : "priceChange字段必须填写!",
                            },
                                    dexId : {
                required : "dexId字段必须填写!",
                                number : "请输入合法的数字",
                            },
                                    dexName : {
                required : "dexName字段必须填写!",
                            },
                                    createTime : {
                required : "createTime字段必须填写!",
                                number : "请输入合法的数字",
                            },
                                    updateTime : {
                required : "updateTime字段必须填写!",
                                number : "请输入合法的数字",
                            },
                                    volume : {
                required : "volume字段必须填写!",
                                number : "请输入合法的数字",
                            },
                                    circulatingVolume : {
                required : "circulatingVolume字段必须填写!",
                                number : "请输入合法的数字",
                            },
                                    marketCap : {
                required : "marketCap字段必须填写!",
                            },
                                    rankMarketCap : {
                required : "rankMarketCap字段必须填写!",
                                number : "请输入合法的数字",
                            },
                                    batchTime : {
                required : "batchTime字段必须填写!",
                                number : "请输入合法的数字",
                            },
                                    infoUrl : {
                required : "infoUrl字段必须填写!",
                            },
            }
});

$("#editCurrencyPriceForm").validate({
rules : {
    currencyPriceId : {
        required : true,
                number : true,
            },
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
    currentPrice : {
        required : true,
            },
    priceChange : {
        required : true,
            },
    dexId : {
        required : true,
                number : true,
            },
    dexName : {
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
    volume : {
        required : true,
                number : true,
            },
    circulatingVolume : {
        required : true,
                number : true,
            },
    marketCap : {
        required : true,
            },
    rankMarketCap : {
        required : true,
                number : true,
            },
    batchTime : {
        required : true,
                number : true,
            },
    infoUrl : {
        required : true,
            },
},
messages : {
    currencyPriceId : {
    required : "currencyPriceId 字段必须填写!",
        number : "请输入合法的数字",
    },
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
    currentPrice : {
    required : "currentPrice 字段必须填写!",
    },
    priceChange : {
    required : "priceChange 字段必须填写!",
    },
    dexId : {
    required : "dexId 字段必须填写!",
        number : "请输入合法的数字",
    },
    dexName : {
    required : "dexName 字段必须填写!",
    },
    createTime : {
    required : "createTime 字段必须填写!",
        number : "请输入合法的数字",
    },
    updateTime : {
    required : "updateTime 字段必须填写!",
        number : "请输入合法的数字",
    },
    volume : {
    required : "volume 字段必须填写!",
        number : "请输入合法的数字",
    },
    circulatingVolume : {
    required : "circulatingVolume 字段必须填写!",
        number : "请输入合法的数字",
    },
    marketCap : {
    required : "marketCap 字段必须填写!",
    },
    rankMarketCap : {
    required : "rankMarketCap 字段必须填写!",
        number : "请输入合法的数字",
    },
    batchTime : {
    required : "batchTime 字段必须填写!",
        number : "请输入合法的数字",
    },
    infoUrl : {
    required : "infoUrl 字段必须填写!",
    },
}
});

});