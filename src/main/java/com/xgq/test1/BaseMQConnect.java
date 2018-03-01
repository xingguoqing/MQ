package com.xgq.test1;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

/**
 * @author xingguoqing
 * @date 2018/3/1 上午9:32
 */
public class BaseMQConnect {

    //通道
    protected Channel channel;
    //连接
    protected Connection connection;
    //队列名称
    protected String queueName;

    public BaseMQConnect(String queueName) throws IOException {
        this.queueName = queueName;
        //打开连接和创建频道
        ConnectionFactory factory = new ConnectionFactory();
        //设置MabbitMQ所在主机ip或者主机名  127.0.0.1即localhost
        factory.setHost("127.0.0.1");
        //创建连接
        connection = factory.newConnection();
        //创建通道
        channel = connection.createChannel();
        //声明创建了一个队列
        channel.queueDeclare(queueName, false, false, false, null);
    }
}
