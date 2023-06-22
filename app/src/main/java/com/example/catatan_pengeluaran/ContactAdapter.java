package com.example.catatan_pengeluaran;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder>{

    private LayoutInflater mInflater;
    private List<ContactModel> contactList;
    private LayoutInflater LayoutInflater;
    private Context context;
    private  OnItemClickListener listener;


    public ContactAdapter(List<ContactModel> contactList, Context context, OnItemClickListener listener) {
        this.mInflater = LayoutInflater.from(context);
        this.contactList = contactList;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ContactAdapter.ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_contact, null);
        return new ContactAdapter.ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.ContactViewHolder holder, int position) {
        holder.bindData(contactList.get(position));

    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public void setItem(List<ContactModel> Item) {contactList = Item;}

    public interface OnItemClickListener {
        void onItemClick(ContactModel item);
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder{
        TextView tvNama, tvHp, tvStatus;

        ImageView ivAvatar;


        public ContactViewHolder(@NonNull View itemView){
            super(itemView);
            ivAvatar = itemView.findViewById(R.id.icAvatar);
            tvNama = itemView.findViewById(R.id.tvNama);
            tvHp = itemView.findViewById(R.id.tvHp);
            tvStatus = itemView.findViewById(R.id.tvStatus);
        }

        public void bindData(final ContactModel item) {
            ivAvatar.setColorFilter(Color.parseColor((item.getColor())), PorterDuff.Mode.SRC_IN);
            tvNama.setText(item.getNama());
            tvHp.setText(item.getHp());
            tvStatus.setText((item.getStatus()));

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }
    }
}
