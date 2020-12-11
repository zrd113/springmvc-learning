package org.zrd.service;

import org.springframework.stereotype.Service;

/**
 * @Author zrd
 * @Date 2020/12/11
 */
@Service
public class HelloService {

    public String hello(String name) {
        return "hello " + name;
    }
}
