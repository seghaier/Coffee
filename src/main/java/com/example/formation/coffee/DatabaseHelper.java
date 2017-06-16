package com.example.formation.coffee;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper{

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "coffeeApp";
    private static final String TABLE_COFFEE = "coffee";
    private static final String KEY_ID = "id";
    private static final String KEY_QTE_COFFEE = "nbr_coffee";
    private static final String KEY_QTE_COFFEE_CHANTILLY = "coffee_chantilly";
    private static final String KEY_QTE_CHOCOLAT = "nbr_chocolat";
    private static final String KEY_QTE_CHOCOLAT_CHANTILLY = "chocolat_chantilly";
    private static final String KEY_TOTAL_PRICE = "price_total";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION );
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String Create_Command_Table = "CREATE TABLE " + TABLE_COFFEE +
                "( " + KEY_ID + " INTEGER PRIMARY KEY," +
                KEY_QTE_COFFEE + " TEXT," +
                KEY_QTE_COFFEE_CHANTILLY + " TEXT," +
                KEY_QTE_CHOCOLAT + " TEXT," +
                KEY_QTE_CHOCOLAT_CHANTILLY + " TEXT," +
                KEY_TOTAL_PRICE + " TEXT" +
                " )" ;
        db.execSQL(Create_Command_Table);

    }


    /**
     * mettre à jour la table de la base de donnée
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COFFEE);
        onCreate(db);

    }

    /**
     * ajouter une commande à la table
     * @param order
     */
    void addCoffee(Order order){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QTE_COFFEE, order.getQteCoffee());
        values.put(KEY_QTE_COFFEE_CHANTILLY, order.getQteCoffeeChantilly());
        values.put(KEY_QTE_CHOCOLAT, order.getQteChocolat());
        values.put(KEY_QTE_CHOCOLAT_CHANTILLY, order.getQteChocolatChantilly());
        values.put(KEY_TOTAL_PRICE, order.getTotal());

        db.insert(TABLE_COFFEE, null, values);
        db.close();
    }

    // recuperer la commande
    Order getOrder(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_COFFEE, new String[]
                        {KEY_ID,
                                KEY_QTE_COFFEE,
                                KEY_QTE_COFFEE_CHANTILLY,
                                KEY_QTE_CHOCOLAT,
                                KEY_QTE_CHOCOLAT_CHANTILLY,
                                KEY_TOTAL_PRICE},
                KEY_ID + "=?", new String[]{String.valueOf(id)},null, null, null, null);

        if(cursor != null){
            cursor.moveToFirst();
        }

        Order order = new Order(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4),
                cursor.getString(5));

        return order;
    }
    //recuperer toutes les commandes
    public List<Order> getAllOrders(){
        List<Order> orderList = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_COFFEE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        //Log.d("Count ALL CURSOR ORDER", ""+cursor.getCount() );
        if(cursor.moveToFirst()){
            do {
                Order order = new Order();
                order.setId(Integer.parseInt(cursor.getString(0)));
                order.setQteCoffee(cursor.getString(1));
                order.setQteCoffeeChantilly(cursor.getString(2));
                order.setQteChocolat(cursor.getString(3));
                order.setQteChocolatChantilly(cursor.getString(4));
                order.setTotal(cursor.getString(5));
                orderList.add(order);
            }while (cursor.moveToNext());
        }

        return orderList;
    }

    //mettre à jour ma table
    public int updateOrder(Order order){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_QTE_COFFEE, order.getQteCoffee());
        values.put(KEY_QTE_COFFEE_CHANTILLY, order.getQteCoffeeChantilly());
        values.put(KEY_QTE_CHOCOLAT, order.getQteChocolat());
        values.put(KEY_QTE_CHOCOLAT_CHANTILLY, order.getQteChocolatChantilly());
        values.put(KEY_TOTAL_PRICE, order.getTotal());

        return db.update(TABLE_COFFEE, values, KEY_ID + "=?",
                new String[]{String.valueOf(order.getId())});
    }
    // supprimer une commande
    public void delteOrder(Order order){
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_COFFEE, KEY_ID + "=?",
                new String[]{String.valueOf(order.getId())});
        db.close();
    }

    // recuperer nbre de commandes
    public int getNumberOrders(){
        int countNumberOrders = 0;
        SQLiteDatabase db = this.getReadableDatabase();
        String countQuery = "SELECT * FROM " + TABLE_COFFEE;

        Cursor cursor = db.rawQuery(countQuery, null);
        countNumberOrders =  cursor.getCount();
        db.close();
        return countNumberOrders;
    }
}
