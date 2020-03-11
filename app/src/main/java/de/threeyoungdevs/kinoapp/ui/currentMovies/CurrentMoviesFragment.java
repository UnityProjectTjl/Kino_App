package de.threeyoungdevs.kinoapp.ui.currentMovies;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.threeyoungdevs.kinoapp.API.Interface;
import de.threeyoungdevs.kinoapp.Model.Cinema;
import de.threeyoungdevs.kinoapp.R;
import de.threeyoungdevs.kinoapp.adapter.CurrentMovieAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

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

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://blog.threeyoungdevs.4lima.de/wp-json")
                .build();



        Interface service = retrofit.create(Interface.class);
        Call<List<Cinema>> repos = service.listRepos();


        repos.enqueue(new Callback<List<Cinema>>() {
            @Override
            public void onResponse(Call<List<Cinema>> call, Response<List<Cinema>> response)
            {
                //Mach was.
                //Mach was anderes
                //Mach was ganz anderes
                //Übergib was in ne Liste
                //ja.
                //Nein.
                //Vielleicht.
                //Möglich
                //Lukas hat Recht
                //Nein, ich spam hier grad keine Kommentare
                //Ja, mach das
                //No Risk No Fun
                //Ahja
                //Oke
                //Wie nennt man des?
                //Ah
                //Mhm
                //jajaja ich habs
                //Du musst ne liste erstellen
                List<Cinema> CList = response.body();


              /*  for (List<Cinema> l: Cinema)
                {
                    CList.add(l);
                }
                */





            }

            @Override
            public void onFailure(Call<List<Cinema>> call, Throwable t)
            {
                Toast.makeText(getActivity(), "Lies hier den Fehler ab: (Viel Spaß, hehe)"+ t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });



        return root;
    }
}
