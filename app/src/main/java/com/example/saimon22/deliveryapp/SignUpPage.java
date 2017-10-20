package com.example.saimon22.deliveryapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class SignUpPage extends AppCompatActivity implements View.OnClickListener {


    Button confirmButton,backToSignIn;
    EditText etFirstName, etLastName, etMiddleName,etUserName, etPassword,etconfirmPassword,etSSN,etDOB,etstoreId, etaddress;
    TextView Massage;
    boolean hasError= false;
    String massages="";






    public String gPassword(){
        if(!etPassword.getText().toString().isEmpty()){
            Pattern patternPassword = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{8,}");
            if(patternPassword.matcher(etPassword.getText().toString()).matches()){
                if(!etPassword.getText().toString().equals(etconfirmPassword)){
                    massages=massages+"\n Password does not match ";
                    hasError=true;
                    return etPassword.getText().toString();

                }

                return etPassword.getText().toString();
            }

        }
        massages=massages+"\n Please put Password ";
        hasError=true;
        return "";




    }
    public int gSSN(){
            int temp= 0;
        if (!etSSN.getText().toString().isEmpty()) {
            Pattern ssnPattern = Pattern.compile("^(?!000|666)[0-8][0-9]{2}(?!00)[0-9]{2}(?!0000)[0-9]{4}$");
            if (!ssnPattern.matcher(etSSN.getText().toString()).matches()) {
                hasError=true;
                massages= massages+"\n **SSN should be like 222114444";


            } else {
                temp= parseInt(etSSN.getText().toString());

            }
        }
        return temp;
    }
    private int gDOB() {

        SimpleDateFormat dobFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date dt = null;

        try {
            dt = dobFormat.parse(etDOB.getText().toString());

            return parseInt(etDOB.getText().toString());
            //return dt;

        } catch (ParseException e) {
            massages=massages + "\n" + "+The date must be of format mm/dd/yyyy separated by slashes.";

        }
        return 0;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //System.out.println("Start program hahahasssssssssssssssssssssssssssssssssssssssssssssssss");
        setContentView(R.layout.activity_sign_up_page);
         etFirstName=(EditText) findViewById(R.id.firstName);
        etDOB=(EditText) findViewById(R.id.BOD);
        etPassword=(EditText) findViewById(R.id.password);
        etSSN=(EditText) findViewById(R.id.SSN);
        etaddress=(EditText) findViewById(R.id.address);
        etconfirmPassword=(EditText) findViewById(R.id.confirmPassword);
        etLastName=(EditText) findViewById(R.id.lastName);
        etMiddleName=(EditText) findViewById(R.id.middleName);
        etstoreId=(EditText) findViewById(R.id.storeId);
        etUserName=(EditText) findViewById(R.id.userName);
        Massage=(TextView)findViewById(R.id.massage);


    }

    public String gfirstName(){
        massages="";

        if( etFirstName.getText().toString().isEmpty())
        {
            hasError= true;
            massages=massages+ "\n First Name Error";
        }
        return etFirstName.getText().toString();


    }
    public String glastName(){


        if( etLastName.getText().toString().isEmpty())
        {
            hasError= true;
            massages=massages+ "\n last Name Error";

        }
        return etFirstName.getText().toString();


    }

    public String gmiddleName(){


        if( etMiddleName.getText().toString().isEmpty())
        {

            massages=massages+ " \n middle Name Error";

        }
        return etFirstName.getText().toString();


    }
    public boolean userExit(){
        boolean temp=false;
        for (int i = 0; i < DriverDB.getUsersArrayList().size(); i++) {
            //check to see if a username user inputs exists
            if (etUserName.getText().toString().equals(DriverDB.getUsersArrayList().get(i).getUserName())) {
                hasError= true;
                massages=massages+ "\n user Name exit";
                temp= true;
            }
        }
        return temp;
    }
    public String guserName(){


        if( etMiddleName.getText().toString().isEmpty() && userExit())
        {
            hasError= true;
            massages=massages+ "\n **middle Name Error";

        }else {

            return etFirstName.getText().toString();
        }
        return etFirstName.getText().toString();


    }
    public int gStoreId(){
        int id=0;
        try{

            id=Integer.parseInt(etstoreId.getText().toString());
        }catch ( Exception e){
            hasError=true;
            massages=massages+"\n Store Id need to be int";
        }
            return id;
    }

    @Override
    public void onClick(View view) {
        System.out.print("here");
        switch (view.getId()){
            case R.id.backToSignIn:
                startActivity(new Intent(this, signIn.class));
                System.out.print("here");


                break;
            case R.id.confirmButton:
                System.out.print(gfirstName()+gmiddleName()+glastName()+guserName()+ etaddress.getText().toString()+ gSSN()+ gStoreId() );

               if(hasError ==false ){
                   //System.out.print("sdsfcsd"+ etFirstName.getEditableText().toString());

              //     Driver registerdata= new Driver(gfirstName(),gmiddleName(),glastName(),guserName(),gPassword(), etaddress.getText().toString(), gDOB(), gSSN(), gStoreId());
              //     DriverDB.getUsersArrayList().add(registerdata);
                   startActivity(new Intent(this, signIn.class));
                }else {
                   Massage.setText(massages);
                   Massage.setCursorVisible(true);
                   Massage.setTextColor(Color.RED);
                   hasError=false;
                   //massages="";
                }





                break;
        }

    }
}
