package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
    int price=5;
    int p1=0;
    int p2=0;
    public void submitOrder(View view) {
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkbox);
        if (checkBox.isChecked()) {
           ch=true;
            p1=1;

        }
        else
        {
            ch=false;
            p1=0;
        }

        CheckBox checkBox1=(CheckBox) findViewById(R.id.checkbox1);
        if (checkBox1.isChecked()){
            co=true;
            p2=2;

        }
        else {
            co=false;
            p2=0;
        }
        price=5;
        price=price+p1+p2;
        EditText editText=(EditText) findViewById(R.id.name);
        customerName=editText.getText().toString();
        //displayMessage(createOrderSummary(noOfCoffees));
        composeEmail();



    }
    public void composeEmail() {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"+"manulalrevathy@gmail.com")); // only email apps should handle this
        //intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Order Summary for "+customerName);
        intent.putExtra(Intent.EXTRA_TEXT, createOrderSummary(noOfCoffees));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private String createOrderSummary(int noOfCoffees){

        String priceMessage="Name: "+customerName+"\nAdd whipped cream? "+ch+"\nAdd chocolate? "+co+"\nQuantity: "+noOfCoffees+"\nTotal:$"+noOfCoffees*price+"\nThank you!";
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
//    private void displayMessage(String message) {
//        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
//        orderSummaryTextView.setText(message);
//    }

    public void increment(View view) {
        if ((noOfCoffees < 100)) {
            noOfCoffees = noOfCoffees + 1;

        }
        else if(noOfCoffees==100){
            Toast.makeText(this, "Sorry!Maximum order limit attained.", Toast.LENGTH_SHORT).show();

        }
        display(noOfCoffees);
    }

    public void decrement(View view){
        if(noOfCoffees>0){
        noOfCoffees=noOfCoffees-1;}
        else if(noOfCoffees==0){
            Toast.makeText(this, "You just selected 0 coffees!", Toast.LENGTH_SHORT).show();
        }
        display(noOfCoffees);
    }

}