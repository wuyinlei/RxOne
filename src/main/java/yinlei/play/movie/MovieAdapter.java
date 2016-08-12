package yinlei.play.movie;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import yinlei.play.R;

/**
 * Created by Administrator on 2016/8/12.
 */
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    public void setResultBeen(List<Movice.ResultBean> resultBeen) {
        this.resultBeen = resultBeen;
        notifyDataSetChanged();
    }

    private List<Movice.ResultBean> resultBeen;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Movice.ResultBean resultBean = resultBeen.get(position);
        holder.tvId.setText(holder.itemView.getContext().getString(R.string.page_with_number, resultBean.getRid()));
        holder.tvTitle.setText("电影名称:"+resultBean.getName());
        holder.tvName.setText("主演："+resultBean.getActor());
        holder.tvTime.setText(resultBean.getWk());
        holder.tvPrice.setText(resultBean.getTboxoffice());
    }

    @Override
    public int getItemCount() {
        return resultBeen == null ? 0 : resultBeen.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.tv_id)
        TextView tvId;
        @Bind(R.id.tv_title)
        TextView tvTitle;
        @Bind(R.id.tv_name)
        TextView tvName;
        @Bind(R.id.tv_time)
        TextView tvTime;
        @Bind(R.id.tv_price)
        TextView tvPrice;
        @Bind(R.id.listItem)
        CardView listItem;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
