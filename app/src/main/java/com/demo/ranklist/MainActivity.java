package com.demo.ranklist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RankListView rlv_jf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rlv_jf = findViewById(R.id.rlv_jf);
        rlv_jf.updateData(getRankList());
    }

    private List<RankListBean> getRankList() {
        List<RankListBean> rankList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            RankListBean bean = new RankListBean("姓名" + i,
                    10000 - 100 * i,
                    "",
                    i);
            rankList.add(bean);
        }
        return rankList;
    }
}
