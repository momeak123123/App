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
import com.example.hz52.app.Entity.Familysea;
import com.example.hz52.app.R;

import java.util.List;

public class FamilyViewAdapter extends RecyclerView.Adapter {
    private static final String TAG = FamilyViewAdapter.class.getSimpleName();

    private Context mContext;
    private List<Familysea> mEntityList;
    private FamilyViewAdapter.OnItemClickListener mOnItemClickListener;
    public FamilyViewAdapter (Context context, List<Familysea> entityList){
        this.mContext = context;
        this.mEntityList = entityList;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.family_sealist, parent, false);
        return new FamilyViewAdapter.DemoViewHolder(view);
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }


    public void setOnItemClickListener(FamilyViewAdapter.OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Familysea entity = mEntityList.get(position);

        ((FamilyViewAdapter.DemoViewHolder)holder).name.setText(entity.getName());
        ((FamilyViewAdapter.DemoViewHolder)holder).id.setText("ID "+entity.getId());
        if(entity.getType().equals("1")){
            ((DemoViewHolder)holder).type.setVisibility(View.GONE);
            ((DemoViewHolder)holder).like.setVisibility(View.GONE);
        }else{
            Glide.with(mContext).load(R.drawable.l_nolove).into(((DemoViewHolder)holder).type);
            ((FamilyViewAdapter.DemoViewHolder)holder).like.setText(entity.getLike());
        }

        Glide.with(mContext).load(entity.getImagesrc()).into(((FamilyViewAdapter.DemoViewHolder)holder).imagesrc);
        if (mOnItemClickListener != null)
        {
            holder.itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(holder.itemView, pos);
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener()
            {
                @Override
                public boolean onLongClick(View v)
                {
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

    private class DemoViewHolder extends RecyclerView.ViewHolder{

        private TextView name;
        private TextView id;
        private ImageView type;
        private ImageView imagesrc;
        private TextView like;

        public DemoViewHolder(View itemView) {
            super(itemView);
            name=(TextView) itemView.findViewById(R.id.textView2);
            id=(TextView) itemView.findViewById(R.id.textView3);
            type=(ImageView) itemView.findViewById(R.id.imageView38);
            imagesrc=(ImageView) itemView.findViewById(R.id.imageView28);
            like=(TextView) itemView.findViewById(R.id.textView179);
        }
    }


    public void addData(int position, Familysea entity) {
        mEntityList.add(position,entity);
        notifyItemInserted(position);
    }

    public void removeData(int position) {
        mEntityList.remove(position);
        notifyItemRemoved(position);
    }
}
