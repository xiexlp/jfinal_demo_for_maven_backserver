package com.js.isearch.index;


import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataIndexJob implements Job{

    private static Logger _log = LoggerFactory.getLogger(DataIndexJob.class);

    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        _log.info("quartz job to index data:" + new Date());
        DataIndex.taskModelIndex();
    }

}