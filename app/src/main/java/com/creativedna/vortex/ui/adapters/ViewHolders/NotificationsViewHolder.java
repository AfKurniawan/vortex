package com.creativedna.vortex.ui.adapters.ViewHolders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.creativedna.vortex.R;
import com.creativedna.vortex.models.Notifications;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Bryan Lamtoo - creativeDNA (U) LTD.
 */
public class NotificationsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    @Bind(R.id.tvNotificationName)
    TextView mNotificationName;

    @Bind(R.id.tvNotificationDescription)
    TextView tvNotificationDescription;

    private final Context context;
    View itemView;

    public NotificationsViewHolder(Context context, View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.itemView = itemView;
        this.context = context;
    }

    @Override
    public void onClick(View v) {

    }

    public void renderView(Notifications notification) {
        mNotificationName.setText(notification.getTitle());
        tvNotificationDescription.setText(Html.fromHtml(notification.getContent()));
    }
}
