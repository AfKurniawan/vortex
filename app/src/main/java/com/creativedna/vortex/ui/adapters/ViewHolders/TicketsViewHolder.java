package com.creativedna.vortex.ui.adapters.ViewHolders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.creativedna.vortex.R;
import com.creativedna.vortex.models.Ticket;
import com.creativedna.vortex.utils.DataFormatter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Bryan Lamtoo - creativeDNA (U) LTD.
 */
public class TicketsViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.tvEventTicketTitle)
    TextView tvEventTicketTitle;
    @Bind(R.id.tvEventTicketsExpiry)
    TextView tvEventTicketsExpiry;
    @Bind(R.id.rlEventBooking)
    LinearLayout rlEventBooking;

    public TicketsViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void renderView(final Context context, final Ticket ticket) {
        tvEventTicketTitle.setText(ticket.getTotalAvailable());
        String time = DataFormatter.formatDate(ticket.getDealine());
        tvEventTicketsExpiry.setText(time);

        rlEventBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Booked!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
