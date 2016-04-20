package com.creativedna.vortex.ui.adapters.ViewHolders;

/**
 * Created by Bryan Lamtoo - creativeDNA (U) LTD.
 */

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.creativedna.vortex.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class EventHeader extends RecyclerView.ViewHolder {
    @Bind(R.id.dateHeader)
    TextView dateHeader;

    public EventHeader(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void renderView(String header_text){
        dateHeader.setText(header_text);
    }
}
