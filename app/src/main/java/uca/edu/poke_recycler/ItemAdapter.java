package uca.edu.poke_recycler;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    public static final int SPAN_COUNT_ONE = 1;
    public static final int SPAN_COUNT_THREE = 3;

    private static final int VIEW_TYPE_SMALL = 1;
    private static final int VIEW_TYPE_BIG = 2;

    private List<Item> mItems;
    private GridLayoutManager mLayoutManager;

//    Dialog myDialog;


    public ItemAdapter (List<Item> items, GridLayoutManager layoutManager){
        mItems = items;
        mLayoutManager = layoutManager;
    }

    @Override
    public int getItemViewType (int position){
        int spanCount = mLayoutManager.getSpanCount();
        if (spanCount == SPAN_COUNT_ONE){
            return VIEW_TYPE_BIG;
        } else {
            return VIEW_TYPE_SMALL;
        }
    }


    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view;
        if (viewType == VIEW_TYPE_BIG){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_big, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_small, parent, false);
        }
        return new ItemViewHolder(view, viewType);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {

        ImageView iv;
        TextView title;
        TextView info;

        Item item = mItems.get(position % 10);
        holder.title.setText(item.getTitle());
        holder.iv.setImageResource(item.getImgResId());
        if (getItemViewType(position) == VIEW_TYPE_BIG){
            holder.info.setText(item.getDescripcion());
        }
/*
        myDialog = new Dialog(myDialog.getContext());
        myDialog.setContentView(R.layout.fragment_dialog);
        iv = (ImageView) myDialog.findViewById(R.id.imgDialog);
        title = (TextView) myDialog.findViewById(R.id.titDialog);
        info = (TextView) myDialog.findViewById(R.id.descDialog);
        iv.setImageResource(mItems.get(holder.getAdapterPosition()).getImgResId());
        title.setText(mItems.get(holder.getAdapterPosition()).getTitle());
        info.setText(mItems.get(holder.getAdapterPosition()).getDescripcion());

        holder.item_fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.show();
            }
        });*/
    }


    @Override
    public int getItemCount() {
        return 10;
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder{
//        private LinearLayout item_fragment;
        ImageView iv;
        TextView title;
        TextView info;

        ItemViewHolder(View itemView, int viewType){
            super(itemView);
            if (viewType == VIEW_TYPE_BIG){
//                item_fragment = (LinearLayout) itemView.findViewById(R.id.rvBig);
                iv = (ImageView) itemView.findViewById(R.id.imgItem);
                title = (TextView) itemView.findViewById(R.id.tvTitulo);
                info = (TextView) itemView.findViewById(R.id.tvDescripcion);
            } else {
                iv = (ImageView) itemView.findViewById(R.id.imager_small);
                title = (TextView) itemView.findViewById(R.id.title_small);
            }
        }
    }
}
