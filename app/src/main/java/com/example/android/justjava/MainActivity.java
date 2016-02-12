package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    int noOfCoffees=2;
    Boolean ch;
    Boolean co;
    String customerName;
    public void submitOrder(View view) {
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkbox);
        if (checkBox.isChecked()) {
           ch=true;
        }
        else
        {
            ch=false;
        }

        CheckBox checkBox1=(CheckBox) findViewById(R.id.checkbox1);
        if (checkBox1.isChecked()){
            co=true;
        }
        else {
            co=false;
        }

        EditText editText=(EditText) findViewById(R.id.name);
        customerName=editText.getText().toString();
        displayMessage(createOrderSummary(noOfCoffees));


    }
    private String createOrderSummary(int noOfCoffees){

        String priceMessage="Name: "+customerName+"\nAdd whipped cream? "+ch+"\nAdd chocolate? "+co+"\nQuantity: "+noOfCoffees+"\nTotal:$"+noOfCoffees*5+"\nThank you!";
        return priceMessage;
    };

    /**
     * Calculates the price of the order.
     *
     * @param noOfCoffees is the number of cups of coffee ordered
     */


    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    /*
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
    */
    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    public void increment(View view){
        noOfCoffees=noOfCoffees+1;
        display(noOfCoffees);
    }

    public void decrement(View view){
        if(noOfCoffees>0){
        noOfCoffees=noOfCoffees-1;}
        display(noOfCoffees);
    }
}