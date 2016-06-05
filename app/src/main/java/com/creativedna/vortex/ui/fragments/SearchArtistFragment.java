package com.creativedna.vortex.ui.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.creativedna.vortex.R;
import com.creativedna.vortex.data.API;
import com.creativedna.vortex.data.RetrofitAdapter;
import com.creativedna.vortex.models.Artist;
import com.creativedna.vortex.models.AutoSuggestSearchResult;
import com.creativedna.vortex.models.Performer;
import com.creativedna.vortex.ui.activities.SearchActivity;
import com.creativedna.vortex.ui.adapters.SearchArtistAdapter;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchArtistFragment extends android.support.v4.app.Fragment {
    @Bind(R.id.tvSearch_empty)
    TextView textEmpty;
    @Bind(R.id.rvArtist_search)
    RecyclerView artistSearchList;
    @Bind(R.id.progressBar3)
    ProgressBar searchProgress;
    SearchArtistAdapter searchArtistAdapter;
    private ArrayList<Artist> performers;
    private String searchTerm;

    public SearchArtistFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search_artist, container, false);
        ButterKnife.bind(this, view);

        SearchActivity searchActivity = (SearchActivity) getActivity();

        searchTerm = searchActivity.getSearchTerm();
        searchArtists();

        return view;
    }

    private void searchArtists() {
        API api = RetrofitAdapter.createAPI();
        final Observable<AutoSuggestSearchResult> autoSuggestArtist = api.autoSuggestArtist(searchTerm);
        autoSuggestArtist
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Subscriber<AutoSuggestSearchResult>() {
                    @Override
                    public void onCompleted() {
                        searchProgress.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError(Throwable e) {
                        searchProgress.setVisibility(View.GONE);
                        Log.e("Search artist error: ", e.toString());
                    }

                    @Override
                    public void onNext(AutoSuggestSearchResult autoSuggestSearchResult) {
                        if (autoSuggestSearchResult.getTotalArtistsFound() == 0) {
                            searchProgress.setVisibility(ProgressBar.GONE);
                            textEmpty.setVisibility(TextView.VISIBLE);
                            artistSearchList.setVisibility(RecyclerView.GONE);
                        } else {
                            performers = autoSuggestSearchResult.getArtists();
                            artistSearchList.setVisibility(RecyclerView.VISIBLE);
                            // searchArtistAdapter.notifyDataSetChanged();
                            searchProgress.setVisibility(ProgressBar.GONE);

                            searchArtistAdapter = new SearchArtistAdapter(performers, getContext());
                            artistSearchList.setLayoutManager(new LinearLayoutManager(getContext()));
                            artistSearchList.setAdapter(searchArtistAdapter);
                        }
                    }
                });


    }


}
