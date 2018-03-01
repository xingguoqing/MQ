package com.xgq.test1;


import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;
import org.apache.commons.lang.SerializationUtils;

import java.io.IOException;

/**
 * @author xingguoqing
 * @date 2018/3/1 上午9:37
 */
public class MQReciver extends BaseMQConnect implements Runnable, Consumer {

    public MQReciver(String queueName) throws IOException {
        super(queueName);
    }

    public void run() {
        try {
            channel.basicConsume(queueName, true,this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void handleConsumeOk(String consumerTag) {
        System.out.println("Consumer "+consumerTag +" registered");
    }

    public void handleCancelOk(String s) {

    }

    public void handleCancel(String s) throws IOException {

    }

    public void handleShutdownSignal(String s, ShutdownSignalException e) {

    }

    public void handleRecoverOk(String s) {

    }

    public void handleDelivery(String consumerTag, Envelope env, AMQP.BasicProperties props, byte[] body) throws IOException {
        MessageInfo messageInfo = (MessageInfo) SerializationUtils.deserialize(body);
        System.out.println("Message ( "
                + "channel : " + messageInfo.getChannel()
                + " , content : " + messageInfo.getContent()
                + " ) received.");
    }
}
