package com.js.isearch.jobs;

import com.js.isearch.index.DataIndex;
import com.js.isearch.index.DataIndexJob;
import com.js.isearch.orm.CurrencyInfo;
import com.js.isearch.orm.CurrencyPos;
import com.js.isearch.orm.CurrencyStatus;
import com.js.isearch.serv.CurrencyInfoServ;
import com.js.isearch.serv.CurrencyPosServ;
import com.js.isearch.serv.CurrencyStatusServ;
import com.js.isearch.servread.CurrencyInfoServRead;
import okhttp3.*;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MasterNodesOnlineJob implements Job {


    private static Logger _log = LoggerFactory.getLogger(MasterNodesOnlineJob.class);

    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        _log.info("quartz job to index data:" + new Date());
        MasterNodesOnline.getDataFromMasterNodesOnline();
    }


}
