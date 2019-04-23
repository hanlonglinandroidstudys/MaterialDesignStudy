package hanlonglin.com.recyclerviewstudy.bean;

import java.util.ArrayList;
import java.util.List;

import hanlonglin.com.recyclerviewstudy.R;

public class DataUtils {

    public static List<QQMessage> initQQData() {
        List<QQMessage> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            QQMessage qqMessage = new QQMessage(R.drawable.ic_launcher_background, "韩龙林" + i, "今天约不约", "1");
            list.add(qqMessage);
        }
        return list;
    }
}
