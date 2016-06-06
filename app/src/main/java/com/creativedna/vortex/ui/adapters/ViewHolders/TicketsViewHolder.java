package com.creativedna.vortex.ui.adapters.ViewHolders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.balysv.materialripple.MaterialRippleLayout;
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

    @Bind(R.id.tvEvent_details_ticket_code)
    TextView tvTicketCurrencyCode;

    @Bind(R.id.tvEventTicketsExpiry)
    TextView tvEventTicketsExpiry;

    @Bind(R.id.tvEvent_details_ticket_amount)
    TextView tvTicketAmount;

    @Bind(R.id.tvEventBook)
    TextView rlEventBooking;

    @Bind(R.id.rlTicketEvent)
    MaterialRippleLayout mBookingView;

    @Bind(R.id.tvTicketQuantity)
    TextView tvTicketQuantity;

    public TicketsViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void renderView(final Context context, final Ticket ticket) {
        tvEventTicketTitle.setText(ticket.getType());
        String time = "Expires on - Not Specified";

        if (ticket.getDealine() != null)
            time = DataFormatter.formatDate(ticket.getDealine());
        tvEventTicketsExpiry.setText(time);

        tvTicketCurrencyCode.setText(ticket.getCurrencyCode());

        tvTicketQuantity.setText(ticket.getTotalAvailable() + " left");

        tvTicketAmount.setText(ticket.getAmount());

        mBookingView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Booked!", Toast.LENGTH_SHORT).show();
                rlEventBooking.setText("Booked");
                tvTicketQuantity.setText((Integer.parseInt(ticket.getTotalAvailable()) - 1) + " left");
            }
        });
    }
}
