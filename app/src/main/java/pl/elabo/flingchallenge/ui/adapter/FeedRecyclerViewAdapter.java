package pl.elabo.flingchallenge.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import pl.elabo.flingchallenge.R;
import pl.elabo.flingchallenge.model.Item;
import pl.elabo.flingchallenge.util.UrlUtil;

public class FeedRecyclerViewAdapter extends RecyclerView.Adapter<FeedRecyclerViewAdapter.FeedViewHolder> {

	private List<Item> mItems = new ArrayList<>();

	public FeedRecyclerViewAdapter() {
	}

	@Override
	public FeedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
		return new FeedViewHolder(v);
	}

	@Override
	public void onBindViewHolder(FeedViewHolder holder, int position) {
		Item item = mItems.get(position);
		holder.mTitle.setText(item.getTitle());
		Glide.clear(holder.mImage);
		Glide.with(holder.mImage.getContext()).load(UrlUtil.photoUrl(item.getImageId())).sizeMultiplier(0.5f).crossFade().diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(false).into(holder.mImage);

		holder.itemView.setTag(item);
	}

	@Override
	public int getItemCount() {
		return mItems.size();
	}

	public void setFeedItems(List<Item> items) {
		mItems.clear();
		mItems.addAll(items);
		notifyDataSetChanged();
	}

	public List<Item> getItems() {
		return mItems;
	}

	protected static class FeedViewHolder extends RecyclerView.ViewHolder {
		@Bind(R.id.image)
		public ImageView mImage;
		@Bind(R.id.title)
		public TextView mTitle;

		public FeedViewHolder(View itemView) {
			super(itemView);
			ButterKnife.bind(this, itemView);
		}
	}
}
