package com.example.asm2;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

public class NavAdapter extends BaseAdapter {
    private List<ItemMenu> itemlist;
    private LayoutInflater layoutInflater;
    private Context context;

    public NavAdapter(Context mContext, List<ItemMenu> itemList) {
        this.context = mContext;
        this.itemlist = itemList;
        layoutInflater = LayoutInflater.from(mContext);
    }


    @Override
    public int getCount() {
        return itemlist.size();
    }

    @Override
    public Object getItem(int position) {
        return itemlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View vItemListView, ViewGroup parent) {

        ViewHolder holder;

        //Nếu vItemListView là một view rỗng, chưa được gắn các thành phần icon và title
        if (vItemListView == null) {
            //Lồng layout nav_item vào trong phần tử vItemListView (View type)
            vItemListView = layoutInflater.inflate(R.layout.nav_item, null);

            // khởi tạo 1 phần tử  holder mới có thành phần gồm: ivIconItem và tvTitleItem
            // ivIconItem (ImageView type) để chứa icon cho itemlist
            // tvTitleItem (TextView type) để chứa title cho itemlist
            holder = new ViewHolder();
            holder.ivIconItem = (ImageView) vItemListView.findViewById(R.id.ivIconNavigation);
            holder.tvTitleItem = (TextView) vItemListView.findViewById(R.id.tvItemNavigation);

            // gắn tag cho vItemListView bằng giá trị biến holder để đánh dấu id của icon và id của title
            // đã được liên kết với vItemListView này.
            vItemListView.setTag(holder);
        }
        //Nếu vItemListView không phải là 1 view rỗng thì lấy lại giá trị các id icon và id title đã được liên kết vào biến holder
        else
            {
            holder = (ViewHolder) vItemListView.getTag();
        }

        //lấy phần tử ở vị trí position trong itemlist
        ItemMenu itemInList = this.itemlist.get(position);

        //gán icon image vào ivIconItem của biến holder
        holder.ivIconItem.setImageResource(itemInList.getIdIcon());

        //gán text vào tvTitleItem của biến holder
        holder.tvTitleItem.setText(itemInList.getIdText());

        return vItemListView;
    }

    private class ViewHolder {
        ImageView ivIconItem;
        TextView tvTitleItem;
    }
}


