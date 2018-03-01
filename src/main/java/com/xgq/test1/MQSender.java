package com.xgq.test1;

import org.apache.commons.lang.SerializationUtils;

import java.io.IOException;
import java.io.Serializable;

/**
 * @author xingguoqing
 * @date 2018/3/1 上午9:35
 */
public class MQSender extends BaseMQConnect {


    public MQSender(String queueName) throws IOException {
        super(queueName);
    }

    /**
     * 要发送的消息要实现序列化接口
     *
     * @param object
     * @throws IOException
     */
    public void sendMessage(Serializable object) throws IOException {
        channel.basicPublish("", queueName, null, SerializationUtils.serialize(object));
    }
}
