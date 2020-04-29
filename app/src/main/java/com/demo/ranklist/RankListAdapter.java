package com.demo.ranklist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RankListAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<RankListBean> list;
    private boolean isHidePhoto = false, isHideName = false;

    public RankListAdapter(Context context, List<RankListBean> DataList) {
        this.context = context;
        if (DataList != null) {
            this.list = DataList;
        } else {
            this.list = new ArrayList<>();
        }
    }

    public void update(List<RankListBean> DataList) {
        if (DataList != null) {
            this.list = DataList;
        } else {
            this.list = new ArrayList<>();
        }
        notifyDataSetChanged();
    }

    public void setHideInfo(boolean isHidePhoto, boolean isHideName) {
        this.isHidePhoto = isHidePhoto;
        this.isHideName = isHideName;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_rank_list_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder holder = (ViewHolder) viewHolder;
        RankListBean bean = list.get(i);
        holder.txt_tank.setText(String.valueOf(bean.getRanking()));
        if (isHideName) {
            holder.txt_name.setText(ToolUtils.getStarString(bean.getName()));
        } else {
            holder.txt_name.setText(bean.getName());
        }
        holder.txt_amount.setText(String.valueOf(bean.getIntegral()));
        if (isHidePhoto) {
            holder.icon_user.setImageResource(R.drawable.new_user);
        } else {
            ToolUtils.setImagePhoto(context, holder.icon_user, bean.getPhotoUrl());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txt_tank, txt_name, txt_amount;
        private CircleImageView icon_user;

        ViewHolder(View view) {
            super(view);
            txt_tank = view.findViewById(R.id.txt_tank);
            txt_name = view.findViewById(R.id.txt_name);
            txt_amount = view.findViewById(R.id.txt_amount);
            icon_user = view.findViewById(R.id.icon_user);
        }
    }
}
