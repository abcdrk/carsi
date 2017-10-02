package com.example.dilrubareyyan.carsi;

        import android.app.Activity;
        import android.content.ContentValues;
        import android.content.Context;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.BaseAdapter;
        import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.LinearLayout;
        import android.widget.TextView;

        import java.util.List;

/**
 * Created by dilrubareyyan on 24/08/17.
 */

public class ItemAdapter extends BaseAdapter {

    Context context;
    LinearLayout list_item;
    private LayoutInflater mInflater;
    private List<Item> mItemList;

    public ItemAdapter(Activity activity, List<Item> items, Context context) {



        //XML'i alıp View'a çevirecek inflater'ı örnekleyelim
        mInflater = (LayoutInflater) activity.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);

        //gösterilecek listeyi de alalım
        mItemList = items;
        this.context = context;
    }

    public ItemAdapter(Context ctx) {
        // TODO Auto-generated constructor stub
        this.context=ctx;
    }

    public void addItem(Item item) {
        this.mItemList.add(0, item);
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


        View row = convertView;
        if(row == null)
        {
            row = mInflater.inflate(R.layout.list_item , parent , false);
        }

        TextView headerView =
                (TextView) row.findViewById(R.id.itemHeader);

        TextView supplierView =
                (TextView) row.findViewById(R.id.itemSupplier);

        TextView priceView =
                (TextView) row.findViewById(R.id.itemPrice);

        ImageView imageView =
                (ImageView) row.findViewById(R.id.itemPhoto);

        LinearLayout ly = (LinearLayout) row.findViewById(R.id.list_item_layout);

        final Item item = mItemList.get(position);

        headerView.setText(item.getHeader());
        priceView.setText("" + item.getPrice() + " tl");
        supplierView.setText(item.getSupplier());

        imageView.setImageResource(R.drawable.ic_box);


        ly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle kutu = new Bundle();
                kutu.putString("header", item.getHeader());
                kutu.putString("price", item.getPrice());
                kutu.putString("supplier", item.getSupplier());
                kutu.putString("location", item.getLocation());

                Intent intent = new Intent(context, InsideListActivity.class);
                intent.putExtras(kutu);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

//        row.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent createAccount = new Intent(activity, InsideListItemActivity.class);
//                startActivity(createAccount);
//            }
//        });

        return row;

    }

}



