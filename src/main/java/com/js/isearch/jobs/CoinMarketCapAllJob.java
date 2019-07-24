package com.js.isearch.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class CoinMarketCapAllJob implements Job {


    private static Logger _log = LoggerFactory.getLogger(CoinMarketCapAllJob.class);

    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        _log.info("quartz job to index data:" + new Date());
        CoinMarketCapAll.getDataFromCoinMarketCap();
    }
}
