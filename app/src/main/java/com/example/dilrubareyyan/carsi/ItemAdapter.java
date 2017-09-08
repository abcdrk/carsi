package com.example.dilrubareyyan.carsi;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by dilrubareyyan on 24/08/17.
 */

public class ItemAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<Item> mItemList;

    public ItemAdapter(Activity activity, List<Item> items) {

        //XML'i alıp View'a çevirecek inflater'ı örnekleyelim
        mInflater = (LayoutInflater) activity.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);

        //gösterilecek listeyi de alalım
        mItemList = items;
    }

    @Override
    public int getCount() {
        return mItemList.size();
    }

    @Override
    public Item getItem(int position) {
        //şöyle de olabilir: public Object getItem(int position)
        return mItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView;

        itemView = mInflater.inflate(R.layout.list_item, null);

        TextView headerView =
                (TextView) itemView.findViewById(R.id.itemHeader);

        TextView supplierView =
                (TextView) itemView.findViewById(R.id.itemSupplier);

        TextView priceView =
                (TextView) itemView.findViewById(R.id.itemPrice);

        ImageView imageView =
                (ImageView) itemView.findViewById(R.id.itemPhoto);



        Item item = mItemList.get(position);

        headerView.setText(item.getHeader());
        priceView.setText("" + item.getPrice() + " tl");
        supplierView.setText(item.getSupplier());

        if (item.getHasPhoto()) {
            imageView.setImageResource(R.drawable.ic_box);
        }
        else {
            imageView.setImageResource(R.drawable.ic_basket);
        }
        return itemView;
    }
}
