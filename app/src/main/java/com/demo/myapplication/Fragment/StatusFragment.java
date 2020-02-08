package com.demo.myapplication.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.demo.myapplication.Adapter.ChatAdapter;
import com.demo.myapplication.Adapter.StatusAdapter;
import com.demo.myapplication.Model.Chats;
import com.demo.myapplication.Model.Statuspg;
import com.demo.myapplication.R;

import java.util.ArrayList;


public class StatusFragment extends Fragment {
	
	private ArrayList<Statuspg> statuspgArrayList;
	private RecyclerView rvsts;
	private StatusAdapter statusAdapter;
	private int Img_string1 = R.drawable.sky;
	private int Img_string2 = R.drawable.tree;
	private int Img_string3 = R.drawable.pro;
	private int Img_string4 = R.drawable.light;
	private int Img_string5 = R.drawable.flower;
	int img_string = R.drawable.rose;
	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return inflater.inflate(R.layout.status_layout, container, false);
	}
	
	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		rvsts = view.findViewById(R.id.rvStatus);
		statuspgArrayList = new ArrayList<>();
		statusAdapter = new StatusAdapter(getContext(), statuspgArrayList);
		rvsts.setLayoutManager(new LinearLayoutManager(getContext()));
		rvsts.setAdapter(statusAdapter);
		StatusData();

		
	}

	private void StatusData() {

		statuspgArrayList.add(new Statuspg(img_string, "Amit Gupta", "8:15PM "));
		statuspgArrayList.add(new Statuspg(Img_string1, "Afsar", "8:15PM "));
		statuspgArrayList.add(new Statuspg(Img_string2, "Vinay", "8:15PM "));
		statuspgArrayList.add(new Statuspg(Img_string3, "Arun", "8:15PM "));
		statuspgArrayList.add(new Statuspg(Img_string4, "Supriya", "Just Now "));
		statuspgArrayList.add(new Statuspg(Img_string5, "James", "8:15PM "));
		statuspgArrayList.add(new Statuspg(img_string, "Ram", "8:15PM "));

	}


}
