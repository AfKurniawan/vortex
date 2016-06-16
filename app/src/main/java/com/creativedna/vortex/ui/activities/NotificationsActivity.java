package com.creativedna.vortex.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.colintmiller.simplenosql.NoSQL;
import com.colintmiller.simplenosql.NoSQLEntity;
import com.creativedna.vortex.R;
import com.creativedna.vortex.data.API;
import com.creativedna.vortex.data.RetrofitAdapter;
import com.creativedna.vortex.data.callbacks.NotificationCallback;
import com.creativedna.vortex.models.Notifications;
import com.creativedna.vortex.ui.adapters.NotificationsAdapter;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersDecoration;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Aron on 10/29/2015.
 */
public class NotificationsActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.ivActivity_notifications_placeholder)
    ImageView mPlaceHolderImage;
    @Bind(R.id.tvActivity_notifications_empty_text)
    TextView mPlaceHolderText;
    @Bind(R.id.rvActivity_notifications_recycler)
    RecyclerView mNotificationsRecycler;
    private NotificationsAdapter notificationsAdapter;
    private ArrayList<Notifications> notifications = new ArrayList<>();

    @Bind(R.id.progressBar)
    ProgressBar progressBar;
    @Bind(R.id.tvTryAgain)
    TextView tryAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        fetchNotifications();

    }

    private void fetchNotifications() {
        API api = RetrofitAdapter.createAPI();
        Observable<NotificationCallback> notificationCallbackObservable = api.getNotifications();
        notificationCallbackObservable
                .distinct()
                .take(20)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Subscriber<NotificationCallback>() {
                    @Override
                    public void onCompleted() {
                        mPlaceHolderImage.setVisibility(ImageView.GONE);
                        progressBar.setVisibility(ProgressBar.GONE);
                        mPlaceHolderText.setVisibility(TextView.GONE);
                        mNotificationsRecycler.setVisibility(RecyclerView.VISIBLE);
                        Log.d("getting my notification", "Completed");
                    }

                    @Override
                    public void onError(Throwable e) {

                        String error = String.format("%s", "Error occurred!");
                        e.printStackTrace();
                        Log.e("Categories", "Error Occurred!");
                        mPlaceHolderText.setText(error);
                        mPlaceHolderImage.setVisibility(ImageView.VISIBLE);
                        tryAgain.setVisibility(TextView.VISIBLE);
                        tryAgain.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                fetchNotifications();
                            }
                        });
                        progressBar.setVisibility(ProgressBar.GONE);
                        mNotificationsRecycler.setVisibility(RecyclerView.GONE);
                    }

                    @Override
                    public void onNext(NotificationCallback notificationCallback) {
                        if (notificationCallback.getNumFound() > 0) {
                            mPlaceHolderText.setVisibility(TextView.GONE);
                            mPlaceHolderImage.setVisibility(ImageView.GONE);
                            tryAgain.setVisibility(TextView.GONE);
                            progressBar.setVisibility(ProgressBar.GONE);
                            mNotificationsRecycler.setVisibility(RecyclerView.VISIBLE);

                            notifications.clear();
                            for (int i = 0; i < notificationCallback.getNumFound(); i++) {
                                Notifications notification = notificationCallback.getNotifications().get(i);
                                notifications.add(notification);
                                save(notification);
                                Log.d("My Notification: ", notification.getTitle());

                            }


                            notifications = notificationCallback.getNotifications();
                            mNotificationsRecycler.setLayoutManager(new LinearLayoutManager
                                    (NotificationsActivity.this));
                            notificationsAdapter = new NotificationsAdapter(notifications,
                                    NotificationsActivity.this);

                            mNotificationsRecycler.setAdapter(notificationsAdapter);

                            final StickyRecyclerHeadersDecoration headersDecor = new
                                    StickyRecyclerHeadersDecoration(notificationsAdapter);
                            mNotificationsRecycler.addItemDecoration(headersDecor);
//                            mNotificationsRecycler.addItemDecoration(new DividerDecoration
//                                    (NotificationsActivity.this));
                            notificationsAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
                                @Override
                                public void onChanged() {
                                    super.onChanged();
                                    headersDecor.invalidateHeaders();
                                }
                            });

//                            notificationsAdapter.notifyDataSetChanged();
                        } else {
                            Log.d("My Categories: ", "No categories for my events");
                        }
                    }
                });
    }

    private void save(Notifications notification) {
        NoSQLEntity<Notifications> entity = new NoSQLEntity<Notifications>("my_notifications", notification
                .getId
                () + "");
        entity.setData(notification);
        NoSQL.with(this).using(Notifications.class).save(entity);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
