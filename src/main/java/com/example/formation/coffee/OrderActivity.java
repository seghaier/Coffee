package com.example.formation.coffee;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity implements View.OnClickListener{
    TextView nbreCoffee, priceCoffee, nbreChocolat, pricechocolat, nbreCoffeeChantilly,
            nbreChocolatChantilly, priceCoffeeChantilly, priceChocolatChantilly, total, pseudoOrderTV;
    int valCoffee = 0 ;
    int priceTotCoffee = 5;
    int valChocolat = 0 ;
    int priceTotChocolat = 5;
    int valCoffeeChantilly = 0;
    int priceTotCoffeeChantilly = 1;
    int valChocolatChantilly = 0;
    int priceTotChocolatChantilly = 1;
    CheckBox chantillyCoffee;
    CheckBox chantillyChocolat;
    int totalCommand = 0;
    Button button1Coffee;
    Button button2Coffee;
    Button button1Chocolat;
    Button button2Chocolat;
    Button button1CoffeeChantilly;
    Button button2CoffeeChantilly;
    Button button1ChocolatChantilly;
    Button button2chocolatChantilly;
    Button order;
    Button actionImport;
    Button action_save;

    //pour le menubar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //ajoute les entrées de menu_test à l'ActionBar
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    /* Menu */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        setTitle("Order"); // title

        /* flèche de retour au niveau menu bar */
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.Extra_Message);
        pseudoOrderTV = (TextView) findViewById(R.id.pseudoOrderView);
        pseudoOrderTV.setText(message);

        nbreCoffee = (TextView) findViewById(R.id.nbreCoffee);
        button1Coffee = (Button) findViewById(R.id.button1Coffee);
        button1Coffee.setOnClickListener(this); // calling onClick() method
        button2Coffee = (Button) findViewById(R.id.button2Coffee);
        button2Coffee.setOnClickListener(this);
        priceCoffee = (TextView) findViewById(R.id.priceCoffee);
        total = (TextView) findViewById(R.id.total);


        nbreChocolat = (TextView) findViewById(R.id.nbreChocolat);
        button1Chocolat = (Button) findViewById(R.id.button1Chocolat);
        button1Chocolat.setOnClickListener(this); // calling onClick() method
        button2Chocolat = (Button) findViewById(R.id.button2Chocolat);
        button2Chocolat.setOnClickListener(this);
        pricechocolat = (TextView) findViewById(R.id.priceChocolat);

        chantillyCoffee = (CheckBox) findViewById(R.id.chantillyCoffee);
        nbreCoffeeChantilly = (TextView) findViewById(R.id.nbreCoffeeChantilly);
        button1CoffeeChantilly = (Button) findViewById(R.id.button1CoffeeChantilly);
        button1CoffeeChantilly.setOnClickListener(this); // calling onClick() method
        button2CoffeeChantilly = (Button) findViewById(R.id.button2CoffeeChantilly);
        button2CoffeeChantilly.setOnClickListener(this);
        priceCoffeeChantilly = (TextView) findViewById(R.id.priceCoffeeChantilly);

        chantillyChocolat = (CheckBox)findViewById(R.id.chantillyChocolat);
        nbreChocolatChantilly = (TextView) findViewById(R.id.nbreChocolatChantilly);
        button1ChocolatChantilly = (Button) findViewById(R.id.button1ChocolatChantilly);
        button1ChocolatChantilly.setOnClickListener(this); // calling onClick() method
        button2chocolatChantilly = (Button) findViewById(R.id.button2ChocolatChantilly);
        button2chocolatChantilly.setOnClickListener(this);
        priceChocolatChantilly = (TextView) findViewById(R.id.priceChocolatChantilly);

        total = (TextView)findViewById(R.id.total);

        order = (Button) findViewById(R.id.order);
        order.setOnClickListener(this);

        /*actionImport = (Button) findViewById((R.id.actionImport));
        actionImport.3(this);*/


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.button1Coffee:
                if(valCoffee > 0) {
                    valCoffee--;
                    nbreCoffee.setText("" + valCoffee);
                    priceCoffee.setText("" + priceTotCoffee * valCoffee + "€");
                    if (valCoffee<valCoffeeChantilly){
                        valCoffeeChantilly= valCoffee;
                        nbreCoffeeChantilly.setText(""+ valCoffeeChantilly);
                        priceCoffeeChantilly.setText("" + priceTotCoffeeChantilly * valCoffeeChantilly + "€");
                    }
                    calculTotal();
                }
                break;

            case R.id.button2Coffee:
                if(valCoffee < 9) {
                    valCoffee++;
                    nbreCoffee.setText("" + valCoffee);
                    priceCoffee.setText("" + priceTotCoffee * valCoffee + "€");
                    calculTotal();
                }
                break;

            case R.id.button1Chocolat:
                if (valChocolat > 0){
                    valChocolat--;
                    nbreChocolat.setText("" + valChocolat);
                    pricechocolat.setText("" + priceTotChocolat * valChocolat + "€");
                    if (valChocolat<=valChocolatChantilly){
                        valChocolatChantilly= valChocolat;
                        nbreChocolatChantilly.setText(""+ valChocolatChantilly);
                        priceChocolatChantilly.setText("" + priceTotCoffeeChantilly * valChocolatChantilly + "€");
                    }
                    calculTotal();
                }
                break;

            case R.id.button2Chocolat:
                if (valChocolat < 9){
                    valChocolat++;
                    nbreChocolat.setText("" + valChocolat);
                    pricechocolat.setText("" + priceTotChocolat * valChocolat + "€");
                    calculTotal();
                }
                break;

            case R.id.button1CoffeeChantilly:
                if( valCoffeeChantilly>0  && chantillyCoffee.isChecked() ){
                    valCoffeeChantilly--;
                    nbreCoffeeChantilly.setText("" + valCoffeeChantilly);
                    priceCoffeeChantilly.setText("" + priceTotCoffeeChantilly * valCoffeeChantilly + "€");
                }

                break;

            case R.id.button2CoffeeChantilly:
                if( valCoffeeChantilly < valCoffee && chantillyCoffee.isChecked() ){
                    valCoffeeChantilly++;
                    nbreCoffeeChantilly.setText("" + valCoffeeChantilly);
                    priceCoffeeChantilly.setText("" + priceTotCoffeeChantilly * valCoffeeChantilly + "€");
                    calculTotal();
                }

                break;


            case R.id.button1ChocolatChantilly:
                if( valChocolatChantilly>0 && chantillyChocolat.isChecked()){
                    valChocolatChantilly--;
                    nbreChocolatChantilly.setText("" + valChocolatChantilly);
                    priceChocolatChantilly.setText("" + priceTotChocolatChantilly * valChocolatChantilly + "€");
                    calculTotal();
                }

                break;

            case R.id.button2ChocolatChantilly:
                if( valChocolatChantilly< valChocolat && chantillyChocolat.isChecked()){
                    valChocolatChantilly++;
                    nbreChocolatChantilly.setText("" + valChocolatChantilly);
                    priceChocolatChantilly.setText("" + priceTotChocolatChantilly * valChocolatChantilly + "€");
                    calculTotal();
                }

                break;

            case R.id.order:
                sendEmail();
                break;




            default:
                break;
        }

    }


    // utilisation des boutons au niveau du menubar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case android.R.id.home :
                onBackPressed();
                return true;

            case R.id.actionSave :
               action_save();
                return true;

            case R.id.actionImport :
                Intent sendIntent = new Intent(OrderActivity.this,ImportActivity.class);
                startActivity(sendIntent);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void action_save() {
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        databaseHelper.addCoffee(new Order(
                ""+ valCoffee,
                ""+ valCoffeeChantilly,
                ""+ valChocolat,
                ""+ valChocolatChantilly,
                 ""+ calculTotal()));
        Toast.makeText(getApplicationContext(), "command saved ", Toast.LENGTH_SHORT).show();
    }

    public int calculTotal(){

           int result =  ((valCoffee+valChocolat)*5)+ valCoffeeChantilly + valChocolatChantilly;
           total.setText("TOTAL : " + result + "€" );
        return  result;

    }

    public String affiche() {

        if (valCoffee > 0) {
            if (valCoffeeChantilly > 0 && valChocolatChantilly == 0 && valChocolat == 0) {
                return "" + nbreCoffee.getText() + " café(s) " + " * " + priceTotCoffee + "€" + " =" + priceCoffee.getText() + '\n'
                        + nbreCoffeeChantilly.getText() + " chantilly " + " + " + priceTotCoffeeChantilly + "€" + " =" + priceCoffeeChantilly.getText() +
                        '\n' + total.getText();
            }
            if (valCoffeeChantilly > 0 && valChocolatChantilly > 0 && valChocolat > 0) {
                return "" + nbreCoffee.getText() + " café(s) " + " * " + priceTotCoffee + "€" + " =" + priceCoffee.getText() + '\n'
                        + nbreCoffeeChantilly.getText() + " chantilly " + " + " + priceTotChocolatChantilly + "€" + " =" + priceCoffeeChantilly.getText() + '\n'
                        + nbreChocolat.getText() + " chocolat(s) " + " * " + priceTotChocolatChantilly + "€" + " =" + pricechocolat.getText() + '\n'
                        + nbreChocolatChantilly.getText() + " chantilly " + " * " + priceTotChocolatChantilly + "€" + " =" + priceChocolatChantilly.getText() +
                        '\n' + total.getText();
            }
            if (valCoffeeChantilly > 0 && valChocolatChantilly == 0 && valChocolat > 0) {
                return "" + nbreCoffee.getText() + " café(s) " + " * " + priceTotCoffee + "€" + " =" + priceCoffee.getText() + '\n'
                        + nbreCoffeeChantilly.getText() + " chantilly " + " + " + priceTotCoffeeChantilly + "€" + " =" + priceCoffeeChantilly.getText() + '\n'
                        + nbreChocolat.getText() + " chocolat(s) " + " * " + priceTotChocolat + "€" + " =" + pricechocolat.getText() + '\n'
                        + '\n' + total.getText();
            }
            if (valCoffeeChantilly == 0 && valChocolatChantilly > 0 && valChocolat > 0) {
                return "" + nbreCoffee.getText() + " café(s) " + " * " + priceTotCoffee + "€" + " =" + priceCoffee.getText() + '\n'
                        + nbreChocolat.getText() + " chocolat(s) " + " * " + priceTotChocolat + "€" + " =" + pricechocolat.getText() + '\n'
                        + nbreChocolatChantilly.getText() + " chantilly " + " * " + priceTotChocolatChantilly + "€" + " =" + priceChocolatChantilly.getText() +
                        '\n' + total.getText();
            }
            if (valCoffeeChantilly == 0 && valChocolatChantilly == 0 && valChocolat > 0) {
                return "" + nbreCoffee.getText() + " café(s) " + " * " + priceTotCoffee + "€" + " =" + priceCoffee.getText() + '\n'
                        + nbreChocolat.getText() + " chocolat(s) " + " * " + priceTotChocolat + "€" + " =" + pricechocolat.getText() + '\n'
                        + '\n' + total.getText();
            }else
                return "" + nbreCoffee.getText() + " café(s) " + " * " + priceTotCoffee + "€" + " =" + priceCoffee.getText() +
                        '\n' + total.getText();
        } else if (valCoffee == 0) {
            if (valChocolatChantilly > 0 && valChocolat > 0) {
                return "" + nbreChocolat.getText() + " chocolat(s) " + " * " + priceTotChocolat + "€" + " =" + pricechocolat.getText() + '\n'
                        + nbreChocolatChantilly.getText() + " chantilly " + " * " + priceTotChocolatChantilly + "€" + " =" + priceChocolatChantilly.getText() +
                        '\n' + total.getText();
            }
            if (valChocolatChantilly == 0 && valChocolat > 0) {
                return "" + nbreChocolat.getText() + " chocolat(s) " + " * " + priceTotChocolat + "€" + " =" + pricechocolat.getText() + '\n'
                        + '\n' + total.getText();
            }
        }
            return "";
    }



    protected void sendEmail() {
        Log.i("Send email", "");

        String[] TO = {"someone@gmail.com"};
        String[] CC = {"xyz@gmail.com"};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");


        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT,affiche());

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Finished sending email.", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(OrderActivity.this,
                    "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }



}
