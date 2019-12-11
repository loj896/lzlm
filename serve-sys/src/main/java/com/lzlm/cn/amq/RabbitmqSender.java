package com.lzlm.cn.amq;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/***
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-12-11 15:04
 *           '::::::::::::'           @description 消息队列发送
 *             .:::::::::: 
 *        '::::::::::::::.. 
 *             ..::::::::::::. 
 *           ``:::::::::::::::: 
 *            ::::``:::::::::'        .:::. 
 *           ::::'   ':::::'       .::::::::. 
 *         .::::'      ::::     .:::::::'::::. 
 *        .:::'       :::::  .:::::::::' ':::::. 
 *       .::'        :::::.:::::::::'      ':::::. 
 *      .::'         ::::::::::::::'         ``::::. 
 *  ...:::           ::::::::::::'              ``::. 
 * ```` ':.          ':::::::::'                  ::::.. 
 *                    '.:::::'                    ':'````.. 
 */
//启动这个绑定
@EnableBinding(Barista.class)
@Service //注入到spring容器
public class RabbitmqSender {

    //注入Barista
    @Resource
    private Barista barista;

    // 发送消息
    public String sendMessage(Object message, Map<String, Object> properties) throws Exception {
        try{
            MessageHeaders mhs = new MessageHeaders(properties);
            Message msg = MessageBuilder.createMessage(message, mhs);
            boolean sendStatus = barista.logoutput().send(msg);
            System.err.println("--------------sending -------------------");
            System.out.println("发送数据：" + message + ",sendStatus: " + sendStatus);
        }catch (Exception e){
            System.err.println("-------------error-------------");
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());

        }
        return null;
    }
}
