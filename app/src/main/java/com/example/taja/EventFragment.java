package com.example.taja;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.taja.databinding.FragmentEventBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EventFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EventFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public EventFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EventFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EventFragment newInstance(String param1, String param2) {
        EventFragment fragment = new EventFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    FragmentEventBinding fragmentEventBinding;

    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentEventBinding = FragmentEventBinding.inflate(inflater, container, false);

        recyclerView = fragmentEventBinding.recycler;
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(fragmentEventBinding.getRoot().getContext()));

        List<Article> articleList = new ArrayList<>();
        articleList.add(new Article("Pelatihan Pembuatan Bokhasi", "user1", "03 Mei 2023"));
        articleList.add(new Article("Pelatihan Cara Tanam 4.0", "user2", "03 Mei 2023"));
        articleList.add(new Article("Pelatihan", "user3", "03 Mei 2023"));
        articleList.add(new Article("Pelatihan", "user3", "03 Mei 2023"));
        articleList.add(new Article("Pelatihan", "user3", "03 Mei 2023"));
        articleList.add(new Article("Pelatihan", "user3", "03 Mei 2023"));
        articleList.add(new Article("Pelatihan", "user3", "03 Mei 2023"));
        articleList.add(new Article("Pelatihan", "user3", "03 Mei 2023"));

        ArticleListAdapter articleListAdapter = new ArticleListAdapter(articleList, getActivity());
        recyclerView.setAdapter(articleListAdapter);

        return fragmentEventBinding.getRoot();
    }
}