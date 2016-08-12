package yinlei.play.daima;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import yinlei.play.R;

/**
 * Created by Administrator on 2016/8/12.
 */
public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.DebounceViewHolder> {

    List<GankBean.ResultsBean> images;

    @Override
    public DebounceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item, parent, false);
        return new DebounceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DebounceViewHolder holder, int position) {
        GankBean.ResultsBean item = images.get(position);
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SS'Z'");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
        Date date = null;
        try {
            date = inputFormat.parse(item.getCreatedAt());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Glide.with(holder.itemView.getContext()).load(item.getUrl()).into(holder.imageIv);
        holder.descriptionTv.setText(outputFormat.format(date));
    }

    public void setItems(List<GankBean.ResultsBean> images) {
        this.images = images;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return images== null ? 0 : images.size();
    }

    static class DebounceViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.imageIv)
        ImageView imageIv;
        @Bind(R.id.descriptionTv)
        TextView descriptionTv;

        public DebounceViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
