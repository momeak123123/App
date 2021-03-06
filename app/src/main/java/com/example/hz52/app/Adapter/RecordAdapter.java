package com.example.hz52.app.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.hz52.app.Entity.Record;
import com.example.hz52.app.R;

import java.util.List;

public class RecordAdapter extends RecyclerView.Adapter {
    private static final String TAG = RecordAdapter.class.getSimpleName();

    private Context mContext;
    private List<Record> mEntityList;
    private RecordAdapter.OnItemClickListener mOnItemClickListener;

    public RecordAdapter(Context context, List<Record> entityList) {
        this.mContext = context;
        this.mEntityList = entityList;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.my_operation_record, parent, false);
        return new RecordAdapter.DemoViewHolder(view);
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }


    public void setOnItemClickListener(RecordAdapter.OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Record entity = mEntityList.get(position);

        ((RecordAdapter.DemoViewHolder) holder).amount.setText(entity.getAmount());
        ((RecordAdapter.DemoViewHolder) holder).date.setText(entity.getDate());
        if(entity.getType()==0){
            Glide.with(mContext).load(R.drawable.jinbi2).into(((RecordAdapter.DemoViewHolder)holder).icon);
            Glide.with(mContext).load(R.drawable.adds).into(((RecordAdapter.DemoViewHolder)holder).ima);
            ((RecordAdapter.DemoViewHolder) holder).txt.setText("充值");

        }else if(entity.getType()==1){
            Glide.with(mContext).load(R.drawable.zuanshi2).into(((RecordAdapter.DemoViewHolder)holder).icon);
            Glide.with(mContext).load(R.drawable.less).into(((RecordAdapter.DemoViewHolder)holder).ima);
            ((RecordAdapter.DemoViewHolder) holder).txt.setText("提现");
        }else{
            Glide.with(mContext).load(R.drawable.jinbi2).into(((RecordAdapter.DemoViewHolder)holder).icon);
            Glide.with(mContext).load(R.drawable.adds).into(((RecordAdapter.DemoViewHolder)holder).ima);
            ((RecordAdapter.DemoViewHolder) holder).txt.setText("兑换");
        }
        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(holder.itemView, pos);
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickListener.onItemLongClick(holder.itemView, pos);
                    return false;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mEntityList.size();
    }

    private class DemoViewHolder extends RecyclerView.ViewHolder {

        private ImageView icon;
        private ImageView ima;
        private TextView amount;
        private TextView txt;
        private TextView date;

        public DemoViewHolder(View itemView) {
            super(itemView);
            icon = (ImageView) itemView.findViewById(R.id.imageView16);
            ima = (ImageView) itemView.findViewById(R.id.imageView173);
            amount = (TextView) itemView.findViewById(R.id.textView174);
            txt = (TextView) itemView.findViewById(R.id.textView175);
            date = (TextView) itemView.findViewById(R.id.textView176);

        }
    }


    public void addData(int position, Record entity) {
        mEntityList.add(position, entity);
        notifyItemInserted(position);
    }

    public void removeData(int position) {
        mEntityList.remove(position);
        notifyItemRemoved(position);
    }
}
