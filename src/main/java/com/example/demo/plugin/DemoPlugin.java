package com.example.demo.plugin;

import com.example.demo.entity.Welcome;
import com.example.demo.repository.WelcomeRepository;
import lombok.extern.slf4j.Slf4j;
import net.lz1998.cq.event.message.CQGroupMessageEvent;
import net.lz1998.cq.event.message.CQPrivateMessageEvent;
import net.lz1998.cq.robot.CQPlugin;
import net.lz1998.cq.robot.CoolQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DemoPlugin extends CQPlugin {

    @Autowired
    WelcomeRepository welcomeRepository;
    @Autowired
    ApplicationContext applicationContext;

    @Override
    public int onPrivateMessage(CoolQ cq, CQPrivateMessageEvent event) {
        return super.onPrivateMessage(cq, event);
    }

    @Override
    public int onGroupMessage(CoolQ cq, CQGroupMessageEvent event) {
        String msg = event.getMessage();
        Long groupId = event.getGroupId();
        if (msg.startsWith("设置欢迎")) {
            // 去掉前面的这几个字
            String sentence = msg.substring("设置欢迎".length());

            // 构造对象，存入数据库
            Welcome welcome = new Welcome();
            welcome.setGroupId(groupId);
            welcome.setSentence(sentence);
            welcomeRepository.save(welcome);

            // 发送结果
            String result = "已保存入群欢迎 " + sentence;
            cq.sendGroupMsg(groupId, result, false);
        }
        return super.onGroupMessage(cq, event);
    }
}
