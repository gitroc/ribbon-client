package com.example.ribbonclient.service;

import com.example.ribbonclient.base.BaseErrorInterfaceInfo;
import com.example.ribbonclient.base.BaseRspEntity;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CompanyService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "findOneFallback")
    public Object findOne(int id) {
        return restTemplate.getForEntity("http://EUREKA-SONG/api/company/" + id, Object.class).getBody();
    }

    public Object findOneFallback(int id) {
        BaseRspEntity baseRspEntity = new BaseRspEntity(BaseErrorInterfaceInfo.SERVER_ERROR);
        baseRspEntity.setResult("can not find company, id = " + id);
        return baseRspEntity;
    }

    @HystrixCommand(fallbackMethod = "findListFallback")
    public Object findList(int page, int size, String updateTime) {
        return restTemplate.getForEntity("http://EUREKA-SONG/api/company/" + "?page=" + page + "&size=" + size + "&updateTime=" + updateTime, Object.class).getBody();
    }

    public Object findListFallback(int page, int size, String updateTime) {
        BaseRspEntity baseRspEntity = new BaseRspEntity(BaseErrorInterfaceInfo.SERVER_ERROR);
        baseRspEntity.setResult("no company find where page = " + page + "size = " + size + "updateTime = " + updateTime);
        return baseRspEntity;
    }
}
