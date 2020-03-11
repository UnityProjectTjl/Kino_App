package de.threeyoungdevs.kinoapp.ui.currentMovies;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import de.threeyoungdevs.kinoapp.R;
import de.threeyoungdevs.kinoapp.adapter.CurrentMovieAdapter;

public class CurrentMoviesFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        recyclerView = (RecyclerView) root.findViewById(R.id.CurrentMovieList);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        String[] items = {"1", "2", "3", "1", "2", "3", "1", "2", "3", "1", "2", "3", "1", "2", "3"};

        // specify an adapter (see also next example)
        mAdapter = new CurrentMovieAdapter(items, getActivity());
        recyclerView.setAdapter(mAdapter);


        return root;
    }
}
