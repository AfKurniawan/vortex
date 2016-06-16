package com.creativedna.vortex.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.creativedna.vortex.R;
import com.creativedna.vortex.models.EventTicket;
import com.creativedna.vortex.ui.views.CustomFontTextView;
import com.creativedna.vortex.utils.DataFormatter;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Bryan Lamtoo - creativeDNA (U) LTD.
 */
public class TicketsAdapter extends RecyclerView.Adapter<TicketsAdapter.TicketViewHolder> {
    List<EventTicket> content;
    Context context;

    public TicketsAdapter(List<EventTicket> content) {
        this.content = content;

    }

    @Override
    public TicketViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();

        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new TicketViewHolder(
                inflater.inflate(R.layout.list_item_ticket, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(TicketViewHolder holder, int position) {
        holder.ticketType.setText(content.get(position).getName());
        holder.tvTicketDescription.setText(content.get(position).getCurrencyCode()+content.get(position).getAmount()+"  -  "+content.get
                (position).getType
                ());
        String time = DataFormatter.formatTime(content.get(position).getEventDateLocal());
        holder.tvEventTime.setText(time);
        Picasso.with(context).load(content.get(position).getImageUrl()).placeholder(R.drawable
                .placeholder)
                .into
                (holder.icon);
        holder.tvTicketDate.setText(DataFormatter.formatDate(content.get(position).getEventDateLocal
                ()));



    }

    @Override
    public int getItemCount() {
        return content.size();
    }

    public class TicketViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,
            View.OnLongClickListener {

        public CustomFontTextView ticketType;
        public CustomFontTextView tvTicketDescription;
        public CustomFontTextView tvTicketDate;
        public TextView tvEventTime;
        CircleImageView icon;


        public TicketViewHolder(View itemView) {
            super(itemView);
            ticketType = (CustomFontTextView) itemView.findViewById(R.id.tvTicketType);
            tvTicketDescription = (CustomFontTextView) itemView.findViewById(R.id.tvTicketDescription);
            tvTicketDate = (CustomFontTextView) itemView.findViewById(R.id.tvTicketDate);
            tvEventTime = (TextView) itemView.findViewById(R.id.tvEventTime);
            icon = (CircleImageView) itemView.findViewById(R.id.icon);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }


        @Override
        public void onClick(View v) {

//            Artist artist = content.get(getAdapterPosition());
//            Intent intent = new Intent(context, CategoryEvent.class);
//            intent.putExtra("title", artist.getCategory_name());
//            intent.putExtra("cat_id", Integer.parseInt(artist.getId()));

//            context.startActivity(intent);

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
