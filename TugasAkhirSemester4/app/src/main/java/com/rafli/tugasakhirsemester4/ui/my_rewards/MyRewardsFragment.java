package com.rafli.tugasakhirsemester4.ui.my_rewards;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rafli.tugasakhirsemester4.DBquerries;
import com.rafli.tugasakhirsemester4.MyRewardsAdapter;
import com.rafli.tugasakhirsemester4.R;
import com.rafli.tugasakhirsemester4.RewardModel;
import com.rafli.tugasakhirsemester4.DBquerries;
import com.rafli.tugasakhirsemester4.R;

import java.util.ArrayList;
import java.util.List;

public class MyRewardsFragment extends Fragment {
    public MyRewardsFragment() {
    }
    public static MyRewardsFragment rewardsAdapter;
    private Dialog loadingDialog;
    private RecyclerView rewardsRecyclerView;
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_my_rewards, container, false);
        rewardsRecyclerView=root.findViewById(R.id.my_rewards_recyclerview);
//////////loading dialog

        loadingDialog=new Dialog(getContext());
        loadingDialog.setContentView(R.layout.loading_progress_dialog);
        loadingDialog.setCancelable(false);
        loadingDialog.getWindow().setBackgroundDrawable(getContext().getDrawable(R.drawable.slider_background));
        loadingDialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        loadingDialog.show();

        //////////loading dialog


        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        rewardsRecyclerView.setLayoutManager(linearLayoutManager);

        rewardsAdapter=new MyRewardsFragment(DBquerries.rewardModelList,false);
        rewardsRecyclerView.setAdapter(rewardsAdapter);

        if(DBquerries.rewardModelList.size() == 0){
            DBquerries.loadRewards(getContext(),loadingDialog,true);
        }else {
            loadingDialog.dismiss();
        }

        rewardsAdapter.notifyDataSetChanged();
        return root;
    }
}
