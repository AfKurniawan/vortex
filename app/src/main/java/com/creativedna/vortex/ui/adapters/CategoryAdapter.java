package com.creativedna.vortex.ui.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.creativedna.vortex.R;
import com.creativedna.vortex.models.Artist;
import com.creativedna.vortex.ui.activities.CategoryEvent;

import java.util.List;

/**
 * Created by Bryan Lamtoo - creativeDNA (U) LTD.
 */
public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    List<Artist> content;
    Context context;

    public CategoryAdapter(List<Artist> content) {
        this.content = content;

    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();

        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new CategoryViewHolder(
                inflater.inflate(R.layout.list_item_categgory, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        holder.text.setText(content.get(position).getArtist_name());
    }

    @Override
    public int getItemCount() {
        return content.size();
    }


    public class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,
            View.OnLongClickListener {

        public TextView text;

        public CategoryViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(android.R.id.text1);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }


        @Override
        public void onClick(View v) {

            Artist artist = content.get(getAdapterPosition());
            Intent intent = new Intent(context, CategoryEvent.class);
            intent.putExtra("title", artist.getArtist_name());
            intent.putExtra("cat_id", Integer.parseInt(artist.getId()));

            context.startActivity(intent);

        }

        @Override
        public boolean onLongClick(View v) {
            if (getAdapterPosition() % 2 == 0) {
                Toast.makeText(v.getContext(), "long item: " + getAdapterPosition() + " and not consumed",
                        Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
            Toast.makeText(v.getContext(), "long item: " + getAdapterPosition() + " and consumed", Toast.LENGTH_SHORT)
                    .show();
            return true;
        }
    }
}
