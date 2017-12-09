package com.open.tradingsystem.service.publictask;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Map;

@Component
public class MainTimer {
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    PublicApiService publicApiService;
    /**
     * @Scheduled(cron="* * * * * ?")：按cron规则执行
     * 第一次延迟1秒执行，然后在上一次执行完毕时间点后3秒再次执行
     */
    @Scheduled(fixedRate = 5000)
    public void mainTimerRate() {
//        System.out.println("#########   " + sdf.format(new Date()));
        Map<String, JSONObject> tickers = publicApiService.getTicker();
//        System.out.println(tickers.toString());
    }

//    //第一次延迟1秒执行，当执行完后3秒再执行
//    @Scheduled(initialDelay = 1000, fixedDelay = 3000)
//    public void timerInit() {
//        System.out.println("init : "+sdf.format(new Date()));
//    }
//
//    //每天23点27分50秒时执行
//    @Scheduled(cron = "50 27 23 * * ?")
//    public void timerCron() {
//        System.out.println("current time : "+ sdf.format(new Date()));
//    }

}
