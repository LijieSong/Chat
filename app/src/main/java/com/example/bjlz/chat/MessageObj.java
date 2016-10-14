/*
                   _ooOoo_
                  o8888888o
                  88" . "88
                  (| -_- |)
                  O\  =  /O
               ____/`---'\____
             .'  \\|     |//  `.
            /  \\|||  :  |||//  \
           /  _||||| -:- |||||-  \
           |   | \\\  -  /// |   |
           | \_|  ''\---/''  |   |
           \  .-\__  `-`  ___/-. /
         ___`. .'  /--.--\  `. . __
      ."" '<  `.___\_<|>_/___.'  >'"".
     | | :  `- \`.;`\ _ /`;.`/ - ` : | |
     \  \ `-.   \_ __\ /__ _/   .-` /  /
======`-.____`-.___\_____/___.-`____.-'======
                   `=---='
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
         佛祖保佑       永无BUG
*/
//          佛曰:
//                  写字楼里写字间，写字间里程序员；
//                  程序人员写程序，又拿程序换酒钱。
//                  酒醒只在网上坐，酒醉还来网下眠；
//                  酒醉酒醒日复日，网上网下年复年。
//                  但愿老死电脑间，不愿鞠躬老板前；
//                  奔驰宝马贵者趣，公交自行程序员。
//                  别人笑我忒疯癫，我笑自己命太贱；

package com.example.bjlz.chat;

import android.graphics.Bitmap;

import static com.example.bjlz.chat.MessageObj.Direct.*;

/**
 * 项目名称：Chat
 * 类描述：
 * 创建人：slj
 * 创建时间：2016-10-14 21:27
 * 修改人：slj
 * 修改时间：2016-10-14 21:27
 * 修改备注：
 * 邮箱:slj@bjlingzhuo.com
 */
public class MessageObj {
    public MessageObj() {
    }
    public String msgText;
    public long msgTime;
    public String msgFrom;
    public String msgUserName;
    public int msgId;
    public Boolean msgImageText;

    public Boolean getMsgImageText() {
        return msgImageText;
    }

    public void setMsgImageText(Boolean msgImageText) {
        this.msgImageText = msgImageText;
    }

    public String getMsgFrom() {
        return msgFrom;
    }

    public void setMsgFrom(String msgFrom) {
        this.msgFrom = msgFrom;
    }

    public String getMsgUserName() {
        return msgUserName;
    }

    public void setMsgUserName(String msgUserName) {
        this.msgUserName = msgUserName;
    }

    public int getMsgId() {
        return msgId;
    }

    public void setMsgId(int msgId) {
        this.msgId = msgId;
    }

    public Bitmap msgImage;

    private MessageObj.Type msgType;

    public Direct getDirect() {
        return direct;
    }

    public void setDirect(Direct direct) {
        this.direct = direct;
    }

    private MessageObj.Direct direct;
    public MessageObj.Type getMsgType() {
        return this.msgType ==Type.TXT? Type.TXT: Type.IMAGE;
    }

    public void setMsgType(MessageObj.Type msgType) {
        this.msgType = msgType;
    }
    public String getMsgText() {
        return msgText;
    }

    public void setMsgText(String msgText) {
        this.msgText = msgText;
    }

    public long getMsgTime() {
        return msgTime;
    }

    public void setMsgTime(long msgTime) {
        this.msgTime = msgTime;
    }

    public Bitmap getMsgImage() {
        return msgImage;
    }

    public void setMsgImage(Bitmap msgImage) {
        this.msgImage = msgImage;
    }
    public MessageObj.Direct direct() {
        return this.direct == SEND? SEND: RECEIVE;
    }
    public static enum Direct {
        SEND,
        RECEIVE;
        private Direct() {
        }
    }

    public static enum Type {
        TXT,
        IMAGE,
        IMAGE_TEXT;
        private Type() {
        }
    }
}
