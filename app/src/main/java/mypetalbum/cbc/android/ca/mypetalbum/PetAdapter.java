package mypetalbum.cbc.android.ca.mypetalbum;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.ViewHolder> {

    private List<PetItemData> mImages;
    private OnItemCLickListener mItemClickListener;

    public PetAdapter(List<PetItemData> images) {
        this.mImages = images;
    }

    public PetItemData getItem(int position) {
        return mImages.get(position);
    }

    @Override
    public PetAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gridview_element, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PetAdapter.ViewHolder holder, int position) {
        holder.mImageView.setImageResource(getItem(position).getImageID());
        holder.mImageView.setTransitionName(
                getImageTransitionName(holder.mImageView.getContext(), position)
        );
    }
    public String getImageTransitionName(Context context, int position) {
        return "transition" + position;
    }

    @Override
    public int getItemCount() {
        return mImages.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @InjectView(R.id.imageview)
        ImageView mImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            mItemClickListener.onItemClick(
                    mImageView,
                    getItem(getLayoutPosition()).getImageID(),
                    getImageTransitionName(mImageView.getContext(), getLayoutPosition())
            );
        }
    }


    public interface OnItemCLickListener {
        void onItemClick(View imageView, int imageRefId, String imageTransitionName);
    }

    public void setOnItemClickListener(final OnItemCLickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }

}
