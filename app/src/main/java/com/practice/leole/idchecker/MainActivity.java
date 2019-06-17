package com.practice.leole.idchecker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextView tvResult;
    EditText etIDNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        etIDNumber = (EditText) findViewById(R.id.etIDNumber);
        tvResult = (TextView) findViewById(R.id.tvResult);
    }

    public void btnSubmit_onClick(View v){

        String userEntryValue = etIDNumber.getText().toString();

        String birthYear;
        String birthMonth;
        String birthDay;

        int genderValue;
        String genderType;

        int citizenShipValue;
        String citizenshipType;

        //checksum digit missing;

        if(!userEntryValue.equals("") && etIDNumber.length() > 12)
        {
            birthYear = userEntryValue.substring(0, 2);
            birthMonth = userEntryValue.substring(2, 4);
            birthDay = userEntryValue.substring(4, 6);

            genderValue = Integer.parseInt(userEntryValue.charAt(6)+"");
            citizenShipValue = Integer.parseInt(userEntryValue.charAt(10)+"");

            if(validateBirthYear(birthYear)) {
                if (validateBirthMonth(birthMonth))
                    if (validateBirthDay(birthMonth, birthDay)){
                        genderType = validateGender(genderValue);
                        citizenshipType = validateCitizenship(citizenShipValue);

                        String result = String.format("");
                    }//end if

            }//end if

        }
        else
        {
            Toast.makeText(getBaseContext(),
                          "Please enter a valid 13 digit ID number.", Toast.LENGTH_LONG).show();
        }//if else
    }//btnSubmit_onClick()

    public boolean validateBirthYear(String birthYear){

       // Date dateObj = new Date();
        int centuryOfBirth;
        int age;
        int birthYearNumber = Integer.parseInt(birthYear);
        final int CURRENT_YEAR = 2017;


        if(birthYearNumber <= 99 && birthYearNumber >= 0 ){
            

            centuryOfBirth = Integer.parseInt("19" + birthYear);//19th Century

        }
        else{ // CREATE ELSE IF TO CHECK THE CENTURY MORE ACCURATELY

            centuryOfBirth = Integer.parseInt("20" + birthYear);//20th Century
        }

        age = CURRENT_YEAR - centuryOfBirth;

        if(age > 110){

            Toast.makeText(getBaseContext(), "Lol ... Your age is" + age + " ??? Are you immortal???", Toast.LENGTH_LONG).show();

        }else if(age < 10 && age > 0){

            Toast.makeText(getBaseContext(), "At age " + age + "??? you are a genius!!", Toast.LENGTH_LONG).show();
        }


        return false;

    }//validateBirthYear()

    public boolean validateBirthMonth(String birthMonth){

        boolean isValidMonthValue = true;

        int birthMonthNumber = Integer.parseInt(birthMonth);

        if(!(birthMonthNumber > 0 && birthMonthNumber <= 12)){

            Toast.makeText(getBaseContext(), "Invalid month in ID", Toast.LENGTH_LONG).show();
            isValidMonthValue = false;

        }//end if

        return isValidMonthValue;

    }//validateBirthMonth()

    public boolean validateBirthDay(String birthMonth, String birthDay){

        boolean isValidBirthDayInMonth = false;
        int birthMonthNumber = Integer.parseInt(birthMonth);
        int birthDayNumber = Integer.parseInt(birthDay);

        int[] daysInAMonth = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        switch(birthMonthNumber) {

            case 1:
                if(birthDayNumber > 0 && birthDayNumber <= daysInAMonth[birthDayNumber]) {
                    isValidBirthDayInMonth = true;
                } else{
                    Toast.makeText(getBaseContext(),"INVALID ID: January has only 1 - 31 days.", Toast.LENGTH_LONG).show();
                }//end if else

                break;
            case 2:
                if(birthDayNumber > 0 && birthDayNumber <= daysInAMonth[birthDayNumber]) {
                    isValidBirthDayInMonth = true;
                } else{
                    Toast.makeText(getBaseContext(),"INVALID ID: February has only 1 - 28 days.", Toast.LENGTH_LONG).show();
                }//end if else
                break;
            case 3:
                if(birthDayNumber > 0 && birthDayNumber <= daysInAMonth[birthDayNumber]) {
                    isValidBirthDayInMonth = true;
                } else{
                    Toast.makeText(getBaseContext(),"INVALID ID: March has only 1 - 31 days.", Toast.LENGTH_LONG).show();
                }//end if else
                break;
            case 4:
                if(birthDayNumber > 0 && birthDayNumber <= daysInAMonth[birthDayNumber]) {
                    isValidBirthDayInMonth = true;
                } else{
                    Toast.makeText(getBaseContext(),"INVALID ID: April has only 1 - 30 days.", Toast.LENGTH_LONG).show();
                }//end if else
                break;
            case 5:
                if(birthDayNumber > 0 && birthDayNumber <= daysInAMonth[birthDayNumber]) {
                    isValidBirthDayInMonth = true;
                } else{
                    Toast.makeText(getBaseContext(),"INVALID ID: May has only 1 - 31 days.", Toast.LENGTH_LONG).show();
                }//end if elseif
                break;
            case 6:
                if(birthDayNumber > 0 && birthDayNumber <= daysInAMonth[birthDayNumber]) {
                    isValidBirthDayInMonth = true;
                } else{
                    Toast.makeText(getBaseContext(),"INVALID ID: June has only 1 - 30 days.", Toast.LENGTH_LONG).show();
                }//end if else
                break;
            case 7:
                if(birthDayNumber > 0 && birthDayNumber <= daysInAMonth[birthDayNumber]) {
                    isValidBirthDayInMonth = true;
                } else{
                    Toast.makeText(getBaseContext(),"INVALID ID: July has only 1 - 31 days.", Toast.LENGTH_LONG).show();
                }//end if else
                break;
            case 8:
                if(birthDayNumber > 0 && birthDayNumber <= daysInAMonth[birthDayNumber]) {
                    isValidBirthDayInMonth = true;
                } else{
                    Toast.makeText(getBaseContext(),"INVALID ID: August has only 1 - 31 days.", Toast.LENGTH_LONG).show();
                }//end if else
                break;
            case 9:
                if(birthDayNumber > 0 && birthDayNumber <= daysInAMonth[birthDayNumber]) {
                    isValidBirthDayInMonth = true;
                } else{
                    Toast.makeText(getBaseContext(),"INVALID ID: September has only 1 - 30 days.", Toast.LENGTH_LONG).show();
                }//end if else
                break;
            case 10:
                if(birthDayNumber > 0 && birthDayNumber <= daysInAMonth[birthDayNumber]) {
                    isValidBirthDayInMonth = true;
                } else{
                    Toast.makeText(getBaseContext(),"INVALID ID: October has only 1 - 31 days.", Toast.LENGTH_LONG).show();
                }//end if else
                break;
            case 11:
                if(birthDayNumber > 0 && birthDayNumber <= daysInAMonth[birthDayNumber]) {
                    isValidBirthDayInMonth = true;
                } else{
                    Toast.makeText(getBaseContext(),"INVALID ID: November has only 1 - 30 days.", Toast.LENGTH_LONG).show();
                }//end if else
                break;
            case 12:
                if(birthDayNumber > 0 && birthDayNumber <= daysInAMonth[birthDayNumber]) {
                    isValidBirthDayInMonth = true;
                } else{
                    Toast.makeText(getBaseContext(),"INVALID ID: December has only 1 - 31 days.", Toast.LENGTH_LONG).show();
                }//end if else
                break;
            default:

                break;
        }

        return isValidBirthDayInMonth;

    }//validateBirthDay()

    public String validateGender(int genderValue){

        String gender = "Male";

        if(genderValue < 5)
            gender = "Female";

        return gender;

    }//validateGender()

    public String validateCitizenship(int citizenShipValue){

        String citizenship = "Permanent resident";

        if(citizenShipValue == 0)
            citizenship = "SA citizen";

        return citizenship;

    }//validateGender()
}
