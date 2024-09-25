package com.example.lab3;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.List;

public class ProfileFragment extends Fragment {

    private RecyclerView recyclerView;
    private MessageAdapter adapter;
    private EditText searchBar;

    // Optional: Parameters for fragment
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    public ProfileFragment() {
        // Required empty public constructor
    }

    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Initialize the search bar
        searchBar = view.findViewById(R.id.searchBar);

        // Populate RecyclerView with data
        adapter = new MessageAdapter(getMessages());  // Assuming getMessages() returns a list of messages
        recyclerView.setAdapter(adapter);

        return view;
    }

    // Example method to get messages (replace this with actual data source)
    private List<Message> getMessages() {
        List<Message> messages = new ArrayList<>();
        messages.add(new Message("Survey Reminder", "3 months ago", "Complete the 2024 school-wide survey."));
        messages.add(new Message("Payment Reminder", "5 months ago", "Reminder to complete financial obligation for Summer 2024."));
        messages.add(new Message("Exam Schedule", "2 months ago", "Summer 2024 Half 1 exam schedule is now available."));
        // Add more messages here
        return messages;
    }
}
