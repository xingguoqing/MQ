package com.xgq.test1;

import java.io.Serializable;

/**
 * @author xingguoqing
 * @date 2018/3/1 上午9:44
 */
public class MessageInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    //渠道
    private String channel;
    //来源
    private String content;
    public String getChannel() {
        return channel;
    }
    public void setChannel(String channel) {
        this.channel = channel;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}
