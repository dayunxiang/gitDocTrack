package com.avp.mems.backstage.tesk;

import com.avp.mems.backstage.entity.push.Message;
import com.avp.mems.backstage.util.DateUtil;
import com.avp.mems.backstage.util.PicurlUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by len on 2017/6/26.
 */
@Component
public class PushWeekReport {
    @Value("${app.resource.push.url}")
    private String pushResourceUrl;

    RestTemplate restTemplate = new RestTemplate();

    @Value("${wechat.push.url}")
    private String url;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private Integer count = 0;


    @Scheduled(cron = "${business.scheduled.pushweekcron}")
    //@Scheduled(cron = "0/15 * * * * ?")
    public void lastWeekReoprt() {

        Message message = new Message();
        List<String> targetUsers = new ArrayList();
        targetUsers.add("admin");
        List<String> targetApps = new ArrayList();
        targetApps.add("wechat");
        targetApps.add("6");
        message.setTargetApps(targetApps);
        message.setTargetUsers(targetUsers);
        Integer year = DateUtil.getYear(new Date());
        Integer weekofyear =  DateUtil.getWeekOfYear(DateUtil.getBeforeDayBeginTIme());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateSrting = formatter.format(new Date());
        message.setWechattitle("周报：" + year +"年第" + weekofyear + "周");
        message.setWechatcontent(dateSrting +" 您的周报，每周一准时送达。");
        message.setIsWechatWorkorder("wechatworkorder");
        message.setUrl("http://" + url + "/skip?path=report/pushReportWeek");
        message.setPicurl(PicurlUtil.picurlRound(count,url));
        count++;
        logger.debug("pushToWechat,message:{}", message.toString());
        try {
            URI uri = UriComponentsBuilder.fromUriString(pushResourceUrl).path("/push").build().toUri();
            restTemplate.postForObject(uri, message, Object.class);
        } catch (Exception e) {
            System.out.println("Push create msg failed --" + e.getMessage());
        }

    }

}
