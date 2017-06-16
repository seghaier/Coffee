package com.example.formation.coffee;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Formation on 14/06/2017.
 */

public class OrderAdapter extends ArrayAdapter<Order> {

    //orders est la liste des models à afficher
    public OrderAdapter(Context context, List<Order> orders) {
        super(context, 0, orders);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.command,parent, false);
        }

        OrderViewHolder viewHolder = (OrderViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new OrderViewHolder();
            viewHolder.qteCoffee = (TextView) convertView.findViewById(R.id.qteCoffee);
            viewHolder.qteCoffeeChantilly = (TextView) convertView.findViewById(R.id.qteCoffeeChantilly);
            viewHolder.qteChocolat = (TextView) convertView.findViewById(R.id.qteChocolat);
            viewHolder.qteChocolatChantilly = (TextView) convertView.findViewById(R.id.qteChocolatChantilly);
            viewHolder.total = (TextView) convertView.findViewById(R.id.total);
            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<Tweet> tweets
        Order order = getItem(position);

        //il ne reste plus qu'à remplir notre vue
        viewHolder.qteCoffee.setText(order.getQteCoffee());
        viewHolder.qteCoffeeChantilly.setText(order.getQteCoffeeChantilly());
        viewHolder.qteChocolat.setText(order.getQteChocolat());
        viewHolder.qteChocolatChantilly.setText(order.getQteChocolatChantilly());
        viewHolder.total.setText(order.getTotal());

        return convertView;
    }

    private class OrderViewHolder {
        public TextView qteCoffee, qteCoffeeChantilly,qteChocolat, qteChocolatChantilly,total;

    }
}


