package com.open.tradingsystem.service.publictask;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.open.tradingsystem.utils.Constents;
import com.open.tradingsystem.utils.HttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 公共API获取
 */
@Service
public class PublicApiService {
    private final Logger log = LoggerFactory.getLogger(PublicApiService.class);

    /**
     * 所有币种
     */
    private String[] symbols = new String[]{"eosusd"};
//    private String[] symbols = new String[]{"btcusd","ltcusd","ethusd","etcusd","bccusd","bcuusd","iotusd","eosusd"};
    private Map<String, JSONObject> tickers = new HashMap<>();

    public void getSymbols(){
//        try {
//            String url = HttpUtils.Get(Constents.URL_BASE + Constents.METHOD_SYMBOLS, null);
//            log.info(url);
//            symbols = JSON.parseArray(url);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public Map<String, JSONObject> getTicker(){
//        if (symbols == null || symbols.isEmpty()){
//            getSymbols();
//            return null;
//        }

        for (String key:symbols){
            try {
                tickers.put(key, JSON.parseObject(HttpUtils.Get(Constents.URL_BASE + Constents.METHOD_TICKER + key, null)));
                System.out.println(tickers.get(key).toJSONString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return tickers;
    }


}
