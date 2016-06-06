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
import com.colintmiller.simplenosql.RetrievalCallback;
import com.creativedna.vortex.R;
import com.creativedna.vortex.data.API;
import com.creativedna.vortex.data.RetrofitAdapter;
import com.creativedna.vortex.data.callbacks.ArtistCallback;
import com.creativedna.vortex.models.Artist;
import com.creativedna.vortex.ui.adapters.CategoryAdapter;
import com.creativedna.vortex.ui.views.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class CategoriesActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.list)
    RecyclerView recyclerView;
    @Bind(R.id.imageView)
    ImageView imageView;
    @Bind(R.id.tvTryAgain)
    TextView tryAgain;
    @Bind(R.id.tvSearchToolBar_title)
    TextView loadTitle;

    private ArrayList<Artist> categories = new ArrayList<>();
    private CategoryAdapter categoryListAdapter;
    @Bind(R.id.progressBar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        categoryListAdapter = new CategoryAdapter(categories);
        recyclerView.setAdapter(categoryListAdapter);
        RecyclerView.ItemDecoration dividerItemDecoration = new DividerItemDecoration(this
                .getResources().getDrawable(R.drawable.diver));
        recyclerView.addItemDecoration(dividerItemDecoration);


        downloadCategories();
    }


    public void downloadCategories() {

        //API
        API api = RetrofitAdapter.createAPI();
        Observable<ArtistCallback> artistCallbackObservable = api.getArtists();
        artistCallbackObservable
                .distinct()
                .take(20)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Subscriber<ArtistCallback>() {
                    @Override
                    public void onCompleted() {
                        imageView.setVisibility(ImageView.GONE);
                        progressBar.setVisibility(ProgressBar.GONE);
                        loadTitle.setVisibility(TextView.GONE);
                        recyclerView.setVisibility(RecyclerView.VISIBLE);
                        Log.d("getting my category...", "Completed");
                    }

                    @Override
                    public void onError(Throwable e) {
                        String error = String.format("%s", "Error occurred!");
                        e.printStackTrace();
                        Log.e("Categories", "Error Occurred!");
                        loadTitle.setText(error);
                        imageView.setVisibility(ImageView.VISIBLE);
                        tryAgain.setVisibility(TextView.VISIBLE);
                        tryAgain.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                downloadCategories();
                            }
                        });
                        progressBar.setVisibility(ProgressBar.GONE);
                        recyclerView.setVisibility(RecyclerView.GONE);

                    }

                    @Override
                    public void onNext(ArtistCallback artistCallback) {
                        if (artistCallback.getNumFound() > 0) {
                            loadTitle.setVisibility(TextView.GONE);
                            imageView.setVisibility(ImageView.GONE);
                            tryAgain.setVisibility(TextView.GONE);
                            progressBar.setVisibility(ProgressBar.GONE);
                            recyclerView.setVisibility(RecyclerView.VISIBLE);

                            categories.clear();
                            for (int i = 0; i < artistCallback.getNumFound(); i++) {
                                Artist category = artistCallback.getArtists().get(i);
                                categories.add(category);
                                save(category);
                                Log.d("My Category: ", category.getCategory_name());

                            }
                            categoryListAdapter.notifyDataSetChanged();
                        } else {
                            Log.d("My Categories: ", "No categories for my events");
                        }
                    }
                });


    }


    public void save(Artist category) {
        NoSQLEntity<Artist> entity = new NoSQLEntity<Artist>("my_artists", category.getId() + "");
        entity.setData(category);
        NoSQL.with(this).using(Artist.class).save(entity);
    }

    public void showCategories() {

        imageView.setVisibility(ImageView.VISIBLE);
        progressBar.setVisibility(ProgressBar.VISIBLE);
        loadTitle.setVisibility(TextView.VISIBLE);
        tryAgain.setVisibility(TextView.GONE);

        String error = String.format("%s", "Loading categories...");
        loadTitle.setText(error);
        recyclerView.setVisibility(RecyclerView.GONE);


        NoSQL.with(this).using(Artist.class)
                .bucketId("my_artists")
                .retrieve(new RetrievalCallback<Artist>() {
                    @Override
                    public void retrievedResults(List<NoSQLEntity<Artist>> entities) {
                        if (entities.size() > 0) {
                            loadTitle.setVisibility(TextView.GONE);
                            imageView.setVisibility(ImageView.GONE);
                            tryAgain.setVisibility(TextView.GONE);
                            progressBar.setVisibility(ProgressBar.GONE);
                            recyclerView.setVisibility(RecyclerView.VISIBLE);

                            categories.clear();
                            for (NoSQLEntity<Artist> entity : entities) {
                                Artist artist = entity.getData();
                                //order.setIs_accepted(true);
                                categories.add(artist);
                            }
                            categoryListAdapter.notifyDataSetChanged();

//                            Collections.sort(categories, new Comparator<Artist>() {
//                                public int compare(Artist artist1, Artist artist2) {
//                                    return artist1.getCategory_name().compareTo(artist2.getCategory_name());
//                                }
//                            });

                        }else {
                            downloadCategories();
                        }


                    }
                });

    }
}
