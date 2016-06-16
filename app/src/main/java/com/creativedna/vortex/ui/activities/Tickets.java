package com.creativedna.vortex.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.colintmiller.simplenosql.NoSQL;
import com.colintmiller.simplenosql.NoSQLEntity;
import com.creativedna.vortex.R;
import com.creativedna.vortex.data.API;
import com.creativedna.vortex.data.RetrofitAdapter;
import com.creativedna.vortex.data.callbacks.TicketsCallback;
import com.creativedna.vortex.helpers.SharedPreferenceManager;
import com.creativedna.vortex.models.EventTicket;
import com.creativedna.vortex.models.UserModel;
import com.creativedna.vortex.ui.adapters.TicketsAdapter;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class Tickets extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.ivActivity_tickets_placeholder)
    ImageView mPlaceHolderImage;
    @Bind(R.id.tvActivity_tickets_empty_text)
    TextView mPlaceHolderText;
    @Bind(R.id.rvActivity_tickets_recycler)
    RecyclerView mTicketsRecycler;

    @Bind(R.id.progressBar)
    ProgressBar progressBar;

    private TicketsAdapter ticketsAdapter;
    private ArrayList<EventTicket> tickets = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tickets);

        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        mTicketsRecycler.setLayoutManager(new LinearLayoutManager(this));
        ticketsAdapter = new TicketsAdapter(tickets);
        mTicketsRecycler.setAdapter(ticketsAdapter);


        fetchTickets();
    }

    private void fetchTickets() {

        UserModel userModel = SharedPreferenceManager.getSharedInstance()
                .getUserModelFromPreferences();
//        Toast.makeText(Tickets.this, "USER ID = "+userModel.userID, Toast.LENGTH_SHORT).show();

        //API
        API api = RetrofitAdapter.createAPI();
        Observable<TicketsCallback> ticketsCallbackObservable = api.getTickets(Integer.valueOf(userModel.userID));
        ticketsCallbackObservable
                .distinct()
                .take(20)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Subscriber<TicketsCallback>() {
                    @Override
                    public void onCompleted() {
//                            mPlaceHolderImage.setVisibility(ImageView.GONE);
//                            progressBar.setVisibility(ProgressBar.GONE);
//                            mTicketsRecycler.setVisibility(RecyclerView.VISIBLE);
                        Log.d("getting my ticket...", "Completed");
                    }

                    @Override
                    public void onError(Throwable e) {
                        String error = String.format("%s", "Error occurred!");
                        e.printStackTrace();
                        Log.e("Tickets", "Error Occurred!");
                        mPlaceHolderImage.setVisibility(ImageView.VISIBLE);

                        progressBar.setVisibility(ProgressBar.GONE);
                        mTicketsRecycler.setVisibility(RecyclerView.GONE);

                    }

                    @Override
                    public void onNext(TicketsCallback ticketsCallback) {
                        if (ticketsCallback.getNumFound() > 0) {
                            mPlaceHolderImage.setVisibility(ImageView.GONE);
                            progressBar.setVisibility(ProgressBar.GONE);
                            mTicketsRecycler.setVisibility(RecyclerView.VISIBLE);
                            mPlaceHolderText.setVisibility(View.GONE);

                            tickets.clear();
                            for (int i = 0; i < ticketsCallback.getNumFound(); i++) {

                                EventTicket eventTicket = ticketsCallback.getEventTickets().get(i);
                                tickets.add(eventTicket);
                                save(eventTicket);

                            }
                            Log.d(Tickets.class.getSimpleName(),"SIZE OF TICKETS + " +
                                    ""+ticketsCallback.getEventTickets().size());

                            ticketsAdapter.notifyDataSetChanged();



                        } else {
                            mPlaceHolderText.setVisibility(View.VISIBLE);
                            mPlaceHolderImage.setVisibility(ImageView.VISIBLE);
                            progressBar.setVisibility(ProgressBar.GONE);

                            Log.d("My Tickets: ", "No tickets for my events");
                        }
                    }
                });

    }

    public void save(EventTicket ticket) {
        NoSQLEntity<EventTicket> entity = new NoSQLEntity<EventTicket>("my_tickets", ticket.getTicketId() + "");
        entity.setData(ticket);
        NoSQL.with(this).using(EventTicket.class).save(entity);
    }
}
