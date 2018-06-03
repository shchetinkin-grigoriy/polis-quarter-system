package com.andrgree.house.proxy;


import com.andrgree.house.model.Appeal;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@FeignClient(name = "appeal-service", fallback = AppealServiceProxy.AppealServiceFallback.class)
@RibbonClient(name = "appeal-service")
public interface AppealServiceProxy {

    @RequestMapping("/")
    Appeal getAppeal();

    default Appeal getOldAppeal() {
        return new RestTemplate()
                .getForObject("http://localhost:8091/", Appeal.class);
    }

    @Component
    class AppealServiceFallback implements AppealServiceProxy {
        @Override
        public Appeal getAppeal() {
            return null;
        }
    }
}
