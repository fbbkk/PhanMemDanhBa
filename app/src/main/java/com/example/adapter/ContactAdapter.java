package com.example.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.model.Contact;
import com.example.phanmemquanlydanhba.R;

import static com.example.phanmemquanlydanhba.R.id.txtPhone;

public class ContactAdapter extends ArrayAdapter<Contact> {
    Activity context;
    int resource;
    public ContactAdapter(Activity context, int resource) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View customView = this.context.getLayoutInflater().inflate(this.resource,null);
        TextView txtTen = (TextView) customView.findViewById(R.id.txtTen);
        TextView txtPhone = (TextView) customView.findViewById(R.id.txtPhone);
        ImageView imgCall = (ImageView) customView.findViewById(R.id.imgCall);
        ImageView imgSMS = (ImageView) customView.findViewById(R.id.imgSMS);
        ImageView imgDetail = (ImageView) customView.findViewById(R.id.imgDetail);
        imgCall=

        final Contact contact = getItem(position);
        txtTen.setText(contact.getTen());
        txtPhone.setText(contact.getPhone());
        imgCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xulyCall(contact);
            }
        });
        imgSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xulySMS(contact);
            }
        });
        imgDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xulyDetail(contact);
            }
        });

        return customView;
    }

    private void xulyDetail(Contact contact) {
        Toast.makeText(this.context,"Bạn muốn xem Detail "+contact.getPhone(),Toast.LENGTH_LONG).show();
    }

    private void xulySMS(Contact contact) {
        Toast.makeText(this.context,"Bạn muốn gửi tin nhắn cho "+contact.getPhone(),Toast.LENGTH_LONG).show();
    }

    private void xulyCall(Contact contact) {
        Toast.makeText(this.context,"Bạn muốn gọi cho "+contact.getPhone(),Toast.LENGTH_LONG).show();
    }
    
}
