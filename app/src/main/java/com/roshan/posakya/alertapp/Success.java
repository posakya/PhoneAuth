package com.roshan.posakya.alertapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.facebook.accountkit.Account;
import com.facebook.accountkit.AccountKit;
import com.facebook.accountkit.AccountKitCallback;
import com.facebook.accountkit.AccountKitError;
import com.facebook.accountkit.PhoneNumber;


public class Success extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        AccountKit.getCurrentAccount(new AccountKitCallback<Account>() {
            @Override
            public void onSuccess(final Account account) {

                EditText editPhone,editEmail,editUserId;

                editEmail = findViewById(R.id.editEmail);
                editPhone = findViewById(R.id.editPhone);
                editUserId = findViewById(R.id.editAddress);

                // Get Account Kit ID
                String accountKitId = account.getId();
                editUserId.setText(accountKitId);

                System.out.println("ID : "+accountKitId);

                // Get phone number
                PhoneNumber phoneNumber = account.getPhoneNumber();
                if (phoneNumber != null) {
                    String phoneNumberString = phoneNumber.toString();
                    editPhone.setText(phoneNumberString);
                }

                // Get email
                String email = account.getEmail();
                editEmail.setText(email);

                System.out.println("UserData : "+accountKitId +" \n Phone : "+phoneNumber.toString()+" \n Email : "+email);


            }

            @Override
            public void onError(final AccountKitError error) {
                // Handle Error
            }
        });
    }

    public void logout(View view) {
        AccountKit.logOut();
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();

        AccountKit.getCurrentAccount(new AccountKitCallback<Account>() {
            @Override
            public void onSuccess(final Account account) {

                EditText editPhone,editEmail,editUserId;

                editEmail = findViewById(R.id.editEmail);
                editPhone = findViewById(R.id.editPhone);
                editUserId = findViewById(R.id.editAddress);

                // Get Account Kit ID
                String accountKitId = account.getId();
                editUserId.setText(accountKitId);
                System.out.println("ID : "+accountKitId);
                // Get phone number
                PhoneNumber phoneNumber = account.getPhoneNumber();
                if (phoneNumber != null) {
                    String phoneNumberString = phoneNumber.toString();
                    editPhone.setText(phoneNumberString);
                }

                // Get email
                String email = account.getEmail();
                editEmail.setText(email);

                System.out.println("UserData : "+accountKitId +" \n Phone : "+phoneNumber.toString()+" \n Email : "+email);


            }

            @Override
            public void onError(final AccountKitError error) {
                // Handle Error
            }
        });
    }
}
