package alan.build_a_burger;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    Button calculate;
    CheckBox checkMushrooms,checkLettuce, checkTomato,
            checkPickles, checkMayo, checkMustard;
    Spinner bunSpinner, meatSpinner;
    EditText numberOfBurgers;
    Burger burger = new Burger();
    Calculator calculator = new Calculator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numberOfBurgers = (EditText)findViewById(R.id.numberOfBurgers);

        addListenerOnButton();

        //burger = new Burger();
        //calculator = new Calculator();
    }
    public void addListenerOnButton() {
        bunSpinner = (Spinner) findViewById(R.id.bunSpinner);
        meatSpinner = (Spinner) findViewById(R.id.meatSpinner);
        calculate = (Button) findViewById(R.id.calculate);

        checkMushrooms = (CheckBox) findViewById(R.id.checkMushrooms);
        checkLettuce = (CheckBox) findViewById(R.id.checkLettuce);
        checkTomato = (CheckBox) findViewById(R.id.checkTomato);
        checkPickles = (CheckBox) findViewById(R.id.checkPickles);
        checkMayo = (CheckBox) findViewById(R.id.checkMayo);
        checkMustard = (CheckBox) findViewById((R.id.checkMustard));


        bunSpinner.setOnItemSelectedListener(new CustomOnItemListener());
        meatSpinner.setOnItemSelectedListener(new CustomOnItemListener());


        //burger.setUserInput(Integer.parseInt(numberOfBurgers.getText().toString()));

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                burger.setMeat(meatSpinner.getSelectedItemPosition());
                burger.setBun(bunSpinner.getSelectedItemPosition());
                if (checkMushrooms.isChecked()) {
                    burger.setTop(0);
                }
                if (checkLettuce.isChecked()) {
                    burger.setTop(1);
                }
                if (checkTomato.isChecked()) {
                    burger.setTop(2);
                }
                if (checkPickles.isChecked()) {
                    burger.setTop(3);
                }
                if (checkMayo.isChecked()) {
                    burger.setTop(4);
                }
                if (checkMustard.isChecked()) {
                    burger.setTop(5);
                }
                try {
                    double value = Double.parseDouble(numberOfBurgers.getText().toString());
                    burger.setUserInput(value);
                }
                catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this,
                            "Please Enter a number greater than 0",
                            Toast.LENGTH_SHORT).show();
                }
                calculator.calculateTotal(burger.getBunCal(), burger.getMeatCal(), burger.getTotalTopCal(),
                        burger.bunPrice, burger.getMeatPrice(), burger.getTotalTopPrice(), burger.getUserInput());

                Toast.makeText(MainActivity.this,
                        calculator.toString(),
                        Toast.LENGTH_SHORT).show();
                burger.clearTop();
            }
        });
    }

    public class CustomOnItemListener implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {
            //Toast.makeText(parent.getContext(),
                    //"OnItemSelectedListener : " + parent.getSelectedItemPosition(),
                    //Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub
        }


    }
}
