package com.example.asm2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.ListView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class NavFrg extends Fragment {

    private Context mContext;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View  rootView = inflater.inflate(R.layout.nav_menu,container,false);
        
        initViews(rootView);
        
        return rootView;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        mContext= context;

    }

    private void initViews(View rootView) {

        ListView lvMenu = rootView.findViewById(R.id.lvItemMenu);

        List<ItemMenu> itemList = getlistData();
        lvMenu.setAdapter(new NavAdapter(mContext,itemList));
        lvMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object o = lvMenu.getItemAtPosition(position);
                ItemMenu item = (ItemMenu) o;
                ((MainActivity) getActivity()).showFrg(item.getIdText());
            }
        });
    }

   private List<ItemMenu> getlistData() {

        List<ItemMenu> list = new ArrayList<>();

        list.add(new ItemMenu(R.drawable.ic_sms,R.string.peding_sms));
        list.add(new ItemMenu(R.drawable.ic_phonecall,R.string.phone_call));
        list.add(new ItemMenu(R.drawable.ic_alarm,R.string.alarm));

        return list;
    }

}
