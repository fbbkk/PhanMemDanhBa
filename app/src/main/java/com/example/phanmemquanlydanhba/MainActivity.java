package com.example.phanmemquanlydanhba;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.adapter.ContactAdapter;
import com.example.model.Contact;

import java.util.Random;

import static com.example.phanmemquanlydanhba.R.id.lvContact;

public class MainActivity extends AppCompatActivity {

    ListView lvContact;
    ContactAdapter contactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addcontrols();
        fakeData();
    }

    private void fakeData() {
        Random random = new Random();
        for (int i=0;i<500;i++)
        {
            Contact contact = new Contact();
            contact.setTen("Ten "+i);
            String phone="098";
            int x=random.nextInt(3);
            if (x==1)
                phone="090";
            else if (x==2)
                phone="091";
            for (int p=0;p<7;p++)
            {
                phone+=random.nextInt(10);

            }
            contact.setPhone(phone);
            contactAdapter.add(contact);

        }
    }

    private void addcontrols() {
        lvContact = (ListView) findViewById(R.id.lvContact);
        contactAdapter = new ContactAdapter(MainActivity.this,R.layout.item);
        lvContact.setAdapter(contactAdapter);
    }
}
