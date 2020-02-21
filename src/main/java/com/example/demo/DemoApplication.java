package com.example.demo;

import com.example.demo.config.Config;
import com.example.demo.plugin.DemoPlugin;
import net.lz1998.cq.CQGlobal;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        CQGlobal.pluginList.add(DemoPlugin.class);

        SpringApplication.run(DemoApplication.class, args);
        new Config().test();

        new Thread(() -> {
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new Config().test();
        }).start();
    }

}
