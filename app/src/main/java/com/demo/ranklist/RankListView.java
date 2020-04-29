package com.demo.ranklist;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;


import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RankListView extends ConstraintLayout {
    private ConstraintLayout conlay_top_three, conlay_one, conlay_two, conlay_three;
    private CircleImageView cimg_photo_one, cimg_photo_two, cimg_photo_three;
    private TextView txt_name_one, txt_number_one, txt_name_two, txt_number_two, txt_name_three, txt_number_three;
    private ConstraintLayout conlay_bottom;
    private View view_line;
    private RecyclerView rv_rank;
    private Context context;
    private RankListAdapter rankAdapter;
    private List<RankListBean> rankList;
    private boolean isHidePhoto = false, isHideName = false;

    public RankListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        LayoutInflater.from(context).inflate(R.layout.layout_rank_list, this, true);
        initView();
    }

    public void setHideInfo(boolean isHidePhoto, boolean isHideName) {
        this.isHidePhoto = isHidePhoto;
        this.isHideName = isHideName;
        if (rv_rank != null && rankAdapter != null)
            rankAdapter.setHideInfo(isHidePhoto, isHideName);
        if (rankList != null) setRankSort();
    }

    /**
     * 回復默認值
     */
    private void setDefault() {
        setFirst(null);
        setSecond(null);
        setThird(null);
        setLastRank(null);
    }

    /**
     * 更新列表數據
     *
     * @param rankList
     */
    public void updateData(List<RankListBean> rankList) {
        if (rankList == null) {
            this.rankList = new ArrayList<>();
        } else {
            this.rankList = rankList;
        }
        setRankSort();
    }

    public void updateData(List<RankListBean> rankList, boolean isHidePhoto, boolean isHideName) {
        this.isHidePhoto = isHidePhoto;
        this.isHideName = isHideName;
        if (rv_rank != null && rankAdapter != null)
            rankAdapter.setHideInfo(isHidePhoto, isHideName);
        if (rankList == null) {
            this.rankList = new ArrayList<>();
        } else {
            this.rankList = rankList;
        }
        setRankSort();
    }

    private void setRankSort() {
        if (rankList.size() < 4) setDefault();
        List<RankListBean> lists = new ArrayList<>();
        if (rankList != null && rankList.size() > 0) {
            for (RankListBean bean : rankList) {
                if (bean.getRanking() == 1) {
                    setFirst(bean);
                } else if (bean.getRanking() == 2) {
                    setSecond(bean);
                } else if (bean.getRanking() == 3) {
                    setThird(bean);
                } else {
                    lists.add(bean);
                }
            }
            setLastRank(lists);
        }
    }

    /**
     * 初始化控件
     */
    private void initView() {
        conlay_top_three = this.findViewById(R.id.conlay_top_three);
        conlay_one = this.findViewById(R.id.conlay_one);
        conlay_two = this.findViewById(R.id.conlay_two);
        conlay_two = this.findViewById(R.id.conlay_two);
        conlay_three = this.findViewById(R.id.conlay_three);
        cimg_photo_one = this.findViewById(R.id.cimg_photo_one);
        cimg_photo_two = this.findViewById(R.id.cimg_photo_two);
        cimg_photo_three = this.findViewById(R.id.cimg_photo_three);
        txt_name_one = this.findViewById(R.id.txt_name_one);
        txt_number_one = this.findViewById(R.id.txt_number_one);
        txt_name_two = this.findViewById(R.id.txt_name_two);
        txt_number_two = this.findViewById(R.id.txt_number_two);
        txt_name_three = this.findViewById(R.id.txt_name_three);
        txt_number_three = this.findViewById(R.id.txt_number_three);
        conlay_bottom = this.findViewById(R.id.conlay_bottom);
        view_line = this.findViewById(R.id.view_line);
        rv_rank = this.findViewById(R.id.rv_rank);

        rv_rank.setLayoutManager(new GridLayoutManager(context, 1));
        rankAdapter = new RankListAdapter(context, null);
        rv_rank.setAdapter(rankAdapter);
    }

    /**
     * 设置第一名
     */
    private void setFirst(RankListBean bean) {
        if (bean == null) {
            if (conlay_one != null) conlay_one.setVisibility(INVISIBLE);
            return;
        } else {
            if (conlay_one != null) conlay_one.setVisibility(VISIBLE);
        }
        if (txt_name_one != null) {
            if (isHideName) {
                txt_name_one.setText(ToolUtils.getStarString(bean.getName()));
            } else {
                txt_name_one.setText(bean.getName());
            }
        }
        if (txt_number_one != null) txt_number_one.setText(String.valueOf(bean.getIntegral()));
        if (isHidePhoto) {
            if (cimg_photo_one != null) cimg_photo_one.setImageResource(R.drawable.new_user);
        } else {
            ToolUtils.setImagePhoto(context, cimg_photo_one, bean.getPhotoUrl());
        }
    }

    /**
     * 设置第二名
     */
    private void setSecond(RankListBean bean) {
        if (bean == null) {
            if (conlay_two != null) conlay_two.setVisibility(INVISIBLE);
            return;
        } else {
            if (conlay_two != null) conlay_two.setVisibility(VISIBLE);
        }
        if (txt_name_two != null) {
            if (isHideName) {
                txt_name_two.setText(ToolUtils.getStarString(bean.getName()));
            } else {
                txt_name_two.setText(bean.getName());
            }
        }
        if (txt_number_two != null) txt_number_two.setText(String.valueOf(bean.getIntegral()));
        if (isHidePhoto) {
            if (cimg_photo_two != null) cimg_photo_two.setImageResource(R.drawable.new_user);
        } else {
            ToolUtils.setImagePhoto(context, cimg_photo_two, bean.getPhotoUrl());
        }
    }

    /**
     * 设置第三名
     */
    private void setThird(RankListBean bean) {
        if (bean == null) {
            if (conlay_three != null) conlay_three.setVisibility(INVISIBLE);
            return;
        } else {
            if (conlay_three != null) conlay_three.setVisibility(VISIBLE);
        }
        if (txt_name_three != null) {
            if (isHideName) {
                txt_name_three.setText(ToolUtils.getStarString(bean.getName()));
            } else {
                txt_name_three.setText(bean.getName());
            }
        }
        if (txt_number_three != null) txt_number_three.setText(String.valueOf(bean.getIntegral()));
        if (isHidePhoto) {
            if (cimg_photo_three != null) cimg_photo_three.setImageResource(R.drawable.new_user);
        } else {
            ToolUtils.setImagePhoto(context, cimg_photo_three, bean.getPhotoUrl());
        }
    }

    /**
     * 设置第三名往后的
     */
    private void setLastRank(List<RankListBean> rankList_new) {
        if (rankAdapter != null && rankList_new != null && rankList_new.size() > 0) {
            if (conlay_bottom != null) conlay_bottom.setVisibility(VISIBLE);
            if (rv_rank != null && rankAdapter != null) rankAdapter.update(rankList_new);
        } else {
            if (conlay_bottom != null) conlay_bottom.setVisibility(INVISIBLE);
        }
    }
}
