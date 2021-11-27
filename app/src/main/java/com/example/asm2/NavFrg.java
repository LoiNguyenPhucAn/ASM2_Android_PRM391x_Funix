package com.example.asm2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class NavFrg extends Fragment implements View.OnClickListener {

    // Tạo mảng chỉ để các file icon để sử dụng làm itemlist, lưu ý phải sắp xếp đúng thứ tự với tiêu đề
    private static final int[] ID_DRAWABLES = {R.drawable.ic_sms, R.drawable.ic_phonecall, R.drawable.ic_alarm};

    //Tạo mảng chỉ đến các string để sử dụng làm tiêu đề cho itemlist, lưu ý phải sắp xếp đúng thứ tự với icon
    private static final int[] ID_TEXTS = {R.string.peding_sms, R.string.phone_call, R.string.alarm};

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

        LinearLayout lnMenu = rootView.findViewById(R.id.layout_ItemMenu);
        lnMenu.removeAllViews();

        try{

            for (int i = 0; i<ID_TEXTS.length; i++){

                // khởi tạo 1 phần tử vItemMenu (View type) với thành phần gồm: ivIconItem và tvTitleItem
                // ivIconItem (ImageView type) để chứa icon cho itemlist
                // tvTitleItem (TextView type) để chứa title cho itemlist
                View vItemMenu = LayoutInflater.from(mContext).inflate(R.layout.nav_item, null);
                ImageView ivIconItem = vItemMenu.findViewById(R.id.ivIconNavigation);
                TextView tvTitleItem = vItemMenu.findViewById(R.id.tvItemNavigation);

                // gán image vào vItemMenu (view)
                ivIconItem.setImageResource(ID_DRAWABLES[i]);

                // gán text vào vItemMenu (view)
                tvTitleItem.setText(getString(ID_TEXTS[i]));

                // gán thành phần vItemMenu (view) vừa tạo vào LinearLayout ID: nav_item
                lnMenu.addView(vItemMenu);

                // gán thuộc tính tag của thành phần vItemMenu (view) bằng giá trị ID của TEXT
                vItemMenu.setTag(ID_TEXTS[i]);

                // lắng nghe sự kiện click
                vItemMenu.setOnClickListener(this);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

/*
        ListView lvMenu = rootView.findViewById(R.id.lv_ItemMenu);

        List<ItemMenu> itemList = getlistData();
        lvMenu.setAdapter(new NavAdapter(mContext,itemList));
*/
    }

   /*
   private List<ItemMenu> getlistData() {

        List<ItemMenu> list = new ArrayList<>();

        list.add(new ItemMenu(R.drawable.ic_sms,R.string.peding_sms));
        list.add(new ItemMenu(R.drawable.ic_phonecall,R.string.phone_call));
        list.add(new ItemMenu(R.drawable.ic_alarm,R.string.alarm));

        return list;
    }
    */

    // Khi xảy ra sự kiện onClick trên itemMenu thì gọi hàm showFrg() để hiển thị srceen tiếp theo
    // hàm showFrg() sẽ có tham số đi cùng là giá trị thuộc tính tag lầy được từ phần tử itemMenu
    @Override
    public void onClick(View v) {
        ((MainActivity) getActivity()).showFrg((int) v.getTag());
    }
}
