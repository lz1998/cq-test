package com.example.demo.config;

import com.example.demo.plugin.DemoPlugin;
import net.lz1998.cq.EnableCQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@EnableCQ
public class Config {

    static DemoPlugin demoPlugin;
    static ApplicationContext applicationContext;

    public Config() {
    }

    @Autowired
    public Config(DemoPlugin demoPlugin, ApplicationContext applicationContext) {
        Config.demoPlugin = demoPlugin;
        Config.applicationContext = applicationContext;
    }

    public void test(){
        System.out.println(demoPlugin);
    }
}
