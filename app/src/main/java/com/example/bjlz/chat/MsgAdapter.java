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

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 项目名称：Chat
 * 类描述：
 * 创建人：slj
 * 创建时间：2016-10-14 21:56
 * 修改人：slj
 * 修改时间：2016-10-14 21:56
 * 修改备注：
 * 邮箱:slj@bjlingzhuo.com
 */
public class MsgAdapter extends BaseAdapter {
    private Context context;
    private List<MessageObj> msgs = new ArrayList<>();
    public MsgAdapter(Context context, List<MessageObj> msgs) {
        this.context = context;
        this.msgs = msgs;
    }

    @Override
    public int getCount() {
        return msgs.size();
    }

    @Override
    public Object getItem(int position) {
        return msgs.get(position);
    }

    @Override
    public int getItemViewType(int position) {
        MessageObj obj = msgs.get(position);
        if (obj == null){
            return -1;
        }
        if (obj.getMsgType() == MessageObj.Type.TXT){
            return obj.direct() == obj.getDirect()? MessageObj.Direct.RECEIVE.ordinal():MessageObj.Direct.SEND.ordinal();
        }
        if (obj.getMsgType() == MessageObj.Type.IMAGE){
            return obj.direct() == obj.getDirect()? MessageObj.Direct.RECEIVE.ordinal():MessageObj.Direct.SEND.ordinal();
        }
        return -1;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        MessageObj obj = msgs.get(position);
        MessageObj.Type type = obj.getMsgType();
        String msgFrom = obj.getMsgFrom();
        if (convertView == null){
            holder = new ViewHolder();
            switch (type) {
                case TXT:
                    if (obj.getMsgImageText() == true) {
                        convertView = View.inflate(context, obj.direct() == obj.getDirect() ?
                                R.layout.layout_rec_image_text_msg : R.layout.layout_send_image_text_message, null);
                    }else {
                        convertView = View.inflate(context, obj.direct() == obj.getDirect() ?
                                R.layout.layout_rec_msg : R.layout.layout_send_message, null);
                    }
                    break;
                case IMAGE:
                    convertView = View.inflate(context,obj.direct() == obj.getDirect() ?
                            R.layout.item_chat_img_rec : R.layout.item_chat_img_send,null);
                    break;
                default:
                    break;
            }
            holder.image_chat = (ImageView) convertView.findViewById(R.id.image_chat);
            holder.img_chat_image = (ImageView) convertView.findViewById(R.id.img_chat_image);
            holder.textview_chat = (TextView) convertView.findViewById(R.id.textview_chat);
            holder.tv_chat_message = (TextView) convertView.findViewById(R.id.tv_chat_message);
            holder.tv_msg_time = (TextView) convertView.findViewById(R.id.tv_msg_time);
            convertView.setTag(holder);
        }  else {
        holder = (ViewHolder) convertView.getTag();
    }
         holder.tv_msg_time.setText(transferLongToDate("yyyy-MM-dd HH:mm:ss", obj.getMsgTime()));
         holder.textview_chat.setText(msgFrom);
        switch(type){
            case TXT:
                if (obj.getMsgText()!=null){
                    if (obj.getMsgImageText()==true){
                        holder.tv_chat_message.setText(obj.getMsgText());
                        if (obj.getMsgImage() !=null){
                            holder.img_chat_image.setBackgroundResource(R.mipmap.ic_launcher);
                        }
                    }else{
                        holder.tv_chat_message.setText(obj.getMsgText());
                    }
                }
                break;
            case IMAGE:
                if (obj.getMsgImage() !=null){
                    holder.img_chat_image.setBackgroundResource(R.mipmap.ic_launcher);
                }else{
                    holder.img_chat_image.setBackgroundResource(R.mipmap.ic_launcher);
                }
                break;
            default:
                break;
        }
        return convertView;
    }
    private class ViewHolder {
        ImageView image_chat, img_chat_image;
        TextView textview_chat, tv_chat_message, tv_msg_time;
    }
    /**
     * 把毫秒转化成日期
     * @param dateFormat(日期格式，例如：MM/ dd/yyyy HH:mm:ss)
     * @param millSec(毫秒数)
     * @return
     */
    public static String transferLongToDate(String dateFormat,Long millSec){
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Date date= new Date(millSec);
        return sdf.format(date);
    }
}
