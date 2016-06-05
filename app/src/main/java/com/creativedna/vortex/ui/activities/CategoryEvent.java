package com.creativedna.vortex.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.creativedna.vortex.R;
import com.creativedna.vortex.data.API;
import com.creativedna.vortex.data.RetrofitAdapter;
import com.creativedna.vortex.data.callbacks.ArtistEventCallback;
import com.creativedna.vortex.models.Event;
import com.creativedna.vortex.ui.adapters.AllEventsAdapter;
import com.creativedna.vortex.utils.DividerDecoration;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersDecoration;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class CategoryEvent extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.popularRecycler)
    RecyclerView popularRecycler;
    @Bind(R.id.imageView)
    ImageView imageView;
    @Bind(R.id.tvSearchToolBar_title)
    TextView loadTitle;
    @Bind(R.id.progressBar)
    ProgressBar progressBar;
    @Bind(R.id.tvTryAgain)
    TextView tryAgain;
    AllEventsAdapter allEventsAdapter;
    ArrayList<Event> events;
    int categoryID;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_event);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Bundle intent = getIntent().getExtras();
        String title = intent.getString("title");
        categoryID = intent.getInt("cat_id");

        tryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getEvents();
            }
        });
        setTitle(title);

        events = new ArrayList<>();
        getEvents();
    }



    private void getEvents() {
        imageView.setVisibility(ImageView.VISIBLE);
        progressBar.setVisibility(ProgressBar.VISIBLE);
        loadTitle.setVisibility(TextView.VISIBLE);
        tryAgain.setVisibility(TextView.GONE);

        String error = String.format("%s", "Loading your events...");
        loadTitle.setText(error);

        //API
        API api = RetrofitAdapter.createAPI();
        Observable<ArtistEventCallback> eventArtistCallbackObservable = api.getCategoryEvents(categoryID);
        eventArtistCallbackObservable
                .distinct()
                .take(20)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Subscriber<ArtistEventCallback>() {
                    @Override
                    public void onCompleted() {

                        Log.d("getting events...", "Completed");

                        imageView.setVisibility(ImageView.GONE);
                        progressBar.setVisibility(ProgressBar.GONE);
                        loadTitle.setVisibility(TextView.GONE);
                        popularRecycler.setVisibility(RecyclerView.VISIBLE);

                        if(null == events || events.size()<=0){
                            imageView.setVisibility(ImageView.VISIBLE);
                            progressBar.setVisibility(ProgressBar.GONE);
                            loadTitle.setVisibility(TextView.VISIBLE);
                            popularRecycler.setVisibility(RecyclerView.GONE);

                            loadTitle.setText("No Events Found");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        //  Toast.makeText(getActivity(), "Error: " + e.toString(), Toast.LENGTH_SHORT).show();
                        Log.e("Category Event error", e.toString());
                        String error = String.format("%s", "Error occurred!");
                        loadTitle.setText(error);
                        loadTitle.setVisibility(TextView.VISIBLE);
                        tryAgain.setVisibility(TextView.VISIBLE);
                        progressBar.setVisibility(ProgressBar.GONE);

                    }

                    @Override
                    public void onNext(ArtistEventCallback artistEventCallback) {

                        if (artistEventCallback.getNumFound() > 0) {
                            events = artistEventCallback.getEvents();
                            popularRecycler.setLayoutManager(new LinearLayoutManager(CategoryEvent
                                    .this));
                            allEventsAdapter = new AllEventsAdapter(events, CategoryEvent.this);
                            popularRecycler.setAdapter(allEventsAdapter);
                            final StickyRecyclerHeadersDecoration headersDecor = new StickyRecyclerHeadersDecoration(allEventsAdapter);
                            popularRecycler.addItemDecoration(headersDecor);
                            popularRecycler.addItemDecoration(new DividerDecoration(CategoryEvent
                                    .this));
                            allEventsAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
                                @Override
                                public void onChanged() {
                                    super.onChanged();
                                    headersDecor.invalidateHeaders();
                                }
                            });
                        }
                    }
                });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }

}
