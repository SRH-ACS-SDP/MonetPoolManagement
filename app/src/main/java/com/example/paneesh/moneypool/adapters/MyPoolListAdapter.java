package com.example.paneesh.moneypool.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.paneesh.moneypool.R;
import com.example.paneesh.moneypool.model.PoolDetails;

import java.util.ArrayList;

public class MyPoolListAdapter extends RecyclerView.Adapter<MyPoolListAdapter.MyViewHolder> {


    private View mView;
    private LinearLayout linearLayout;

    private ArrayList<PoolDetails> poolDetailsArrayList = new ArrayList<>();
    private onPoolItemClickListener mOnPoolItemClickListener;

    public MyPoolListAdapter(ArrayList<PoolDetails> poolDetailsArrayList) {
        this.poolDetailsArrayList = poolDetailsArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_my_pool_list_item,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(mView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {

        holder.mTextViewPoolName.setText(poolDetailsArrayList.get(position).getPoolName());
//        holder.mTextViewTotalMembersInPool.setText(poolDetailsArrayList.get(position).getPoolStrength());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               mOnPoolItemClickListener.onItemClick(holder.mTextViewPoolName.getText().toString());
            }
        });

    }

    @Override
    public int getItemCount() {
        return poolDetailsArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mTextViewPoolName;
        TextView mTextViewTotalMembersInPool;
        LinearLayout linearLayout;


        public MyViewHolder(View itemView) {
            super(itemView);
            this.mTextViewPoolName = mTextViewPoolName;
            this.mTextViewTotalMembersInPool = mTextViewTotalMembersInPool;
            mTextViewPoolName = itemView.findViewById(R.id.tv_my_pool_name);
            mTextViewTotalMembersInPool = itemView.findViewById(R.id.tv_my_pool_total_people);
            linearLayout = itemView.findViewById(R.id.ll_my_pool_list);

        }



    }

    public interface onPoolItemClickListener {
        void onItemClick(String name);
    }

    public void setOnItemClickListener(onPoolItemClickListener onPoolItemClickListener) {
        mOnPoolItemClickListener = onPoolItemClickListener;
    }
}