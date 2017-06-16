package com.example.formation.coffee;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class ImportActivity extends AppCompatActivity {

    ListView command;
    String[] prenoms = new String[]{
            "Commande1", "Commande2", "Commande3", "Commande4", "Commande5", "Commande6",
            "Commande7", "Commande8", "Commande9", "Commande10", "Commande11", "Commande12",
            "Commande13", "Commande14", "Commande15", "Commande16", "Commande17", "Commande18",
            "Commande19", "Commande20"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_import);

        setTitle("Import"); // title

        /* flèche de retour au niveau menu bar */
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        command = (ListView) findViewById(R.id.command);

        //android.R.layout.simple_list_item_1 est une vue disponible de base dans le SDK android,
        //Contenant une TextView avec comme identifiant "@android:id/text1"

//        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(ImportActivity.this,
//                android.R.layout.simple_list_item_1, prenoms);
//        command.setAdapter(adapter);

        List<Order> orders = genererTweets();

        OrderAdapter order = new OrderAdapter(ImportActivity.this, orders);
        command.setAdapter(order);
    }

    private List<Order> genererTweets(){
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        List<Order> orders =databaseHelper.getAllOrders();




        return orders;
    }


}
