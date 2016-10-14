package com.example.bjlz.chat;

import android.graphics.BitmapFactory;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SwipeRefreshLayout.OnRefreshListener {
    private LinearLayout ll_back;//返回操作
    private ImageView iv_back;//返回图标
    private TextView tv_title;//标题
    private SwipeRefreshLayout srl_refresh;//刷新条目
    private ListView lv_content;//展示条目
    private List<MessageObj> msg = new ArrayList();
    private MsgAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        setOnCLick();
    }

    private void setOnCLick() {
        ll_back.setOnClickListener(this);
        srl_refresh.setOnRefreshListener(this);
    }

    private void initData() {
        tv_title.setText("示例聊天");
        MessageObj obj = new MessageObj();
        obj.setMsgText("获取信息");
        obj.setMsgImageText(false);
        obj.setMsgId(0);
        obj.setMsgFrom("陈二狗");
        obj.setDirect(MessageObj.Direct.RECEIVE);
        obj.setMsgType(MessageObj.Type.TXT);
        MessageObj obj1 = new MessageObj();
        obj1.setMsgText("发送信息");
        obj1.setMsgId(1);
        obj1.setMsgFrom("王虎剩");
        obj.setDirect(MessageObj.Direct.SEND);
        obj1.setMsgImage(BitmapFactory.decodeResource(this.getResources(), R.mipmap.ic_launcher));
        obj1.setMsgType(MessageObj.Type.IMAGE);
        MessageObj obj2 = new MessageObj();
        obj2.setMsgText("图文信息");
        obj2.setMsgImageText(true);
        obj2.setMsgId(2);
        obj2.setMsgFrom("陈富贵");
        obj2.setMsgImage(BitmapFactory.decodeResource(this.getResources(), R.mipmap.ic_launcher));
        obj2.setDirect(MessageObj.Direct.SEND);
        obj2.setMsgType(MessageObj.Type.TXT);
        msg.add(obj);
        msg.add(obj1);
        msg.add(obj2);
        adapter = new MsgAdapter(this, msg);
        lv_content.setAdapter(adapter);
        lv_content.setSelection(adapter.getCount() - 1);
    }

    public void getData() {
        MessageObj obj  = new MessageObj();
        obj.setMsgText("收到信息");
        obj.setMsgId(2);
        obj.setMsgFrom("张三丰");
        obj.setMsgImageText(false);
        obj.setMsgType(MessageObj.Type.TXT);
        obj.setDirect(MessageObj.Direct.RECEIVE);
        MessageObj obj1  = new MessageObj();
        obj1.setMsgText("发送信息");
        obj1.setMsgId(3);
        obj1.setMsgFrom("陈二狗");
        obj1.setMsgType(MessageObj.Type.IMAGE);
        obj1.setMsgImage(BitmapFactory.decodeResource(this.getResources(), R.mipmap.ic_launcher));
        obj1.setDirect(MessageObj.Direct.SEND);
        MessageObj obj2  = new MessageObj();
        obj2.setMsgText("图文信息");
        obj2.setMsgId(4);
        obj2.setMsgFrom("陈富贵");
        obj2.setMsgImage(BitmapFactory.decodeResource(this.getResources(), R.mipmap.ic_launcher));
        obj2.setDirect(MessageObj.Direct.SEND);
        obj2.setMsgType(MessageObj.Type.TXT);
        obj2.setMsgImageText(true);
        msg.add(obj);
        msg.add(obj1);
        msg.add(obj2);
        adapter.notifyDataSetChanged();
        lv_content.setSelection(adapter.getCount()-1);
        this.srl_refresh.setRefreshing(false);
    }

    private void initView() {
        ll_back = (LinearLayout) findViewById(R.id.ll_back);
        iv_back = (ImageView) findViewById(R.id.iv_back);
        tv_title = (TextView) findViewById(R.id.tv_title);
        srl_refresh = (SwipeRefreshLayout) findViewById(R.id.srl_refresh);
        lv_content = (ListView) findViewById(R.id.lv_content);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.ll_back)
            finish();
    }

    @Override
    public void onRefresh() {
        getData();
    }
}
