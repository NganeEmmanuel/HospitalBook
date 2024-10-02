package com.gethealthy.userservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient("AUTHENTICATION-SERVICE")
public interface UserInterface {

}
