package com.xgq.test1;

/**
 * @author xingguoqing
 * @date 2018/3/1 上午9:47
 */
public class Test1 {

    public static void main(String[] args) throws Exception{
        MQReciver receiver = new MQReciver("testQueue");
        Thread receiverThread = new Thread(receiver);
        receiverThread.start();
        MQSender sender = new MQSender("testQueue");
        for (int i = 0; i < 5; i++) {
            MessageInfo messageInfo = new MessageInfo();
            messageInfo.setChannel("test");
            messageInfo.setContent("msg" + i);
            sender.sendMessage(messageInfo);
        }
    }
}
