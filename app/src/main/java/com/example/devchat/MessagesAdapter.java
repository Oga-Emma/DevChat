package com.example.devchat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.devchat.model.MessageDTO;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MessagesAdapter extends RecyclerView.Adapter<MessagesAdapter.MessagesHolder> {
    static int MY_MESSAGE = 1;
    static int OTHER_MESSAGES = 2;


    SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss a, dd-MM-yy");

    @NonNull
    @Override
    public MessagesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View chatBubble;

        if(viewType == MY_MESSAGE){
            chatBubble = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.chat_bubble_me, parent, false);
        }else{
            chatBubble = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.chat_bubble_other_users, parent, false);
        }

        return new MessagesHolder(chatBubble);
    }

    @Override
    public int getItemViewType(int position) {
        // Just as an example, return 0 or 2 depending on position
        // Note that unlike in ListView adapters, types don't have to be contiguous
        if(position % 3 == 0){
            return MY_MESSAGE;
        }else{
            return OTHER_MESSAGES;
        }
    }


    @Override
    public void onBindViewHolder(@NonNull MessagesHolder holder, int position) {
        holder.bindView(new MessageDTO("Emmanuel", "Hello, Good morning, how was your night, hope you slept well", new Date()));
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class MessagesHolder extends RecyclerView.ViewHolder {
        TextView mMessageTextView;
        TextView mDateSentTextView;
        TextView mSendernameTextView;

        public MessagesHolder(@NonNull View itemView) {
            super(itemView);
            mMessageTextView = itemView.findViewById(R.id.message_tv);
            mDateSentTextView = itemView.findViewById(R.id.dateSent_tv);
            mSendernameTextView = itemView.findViewById(R.id.sender_name_tv);
        }

        public void bindView(MessageDTO message) {
            mSendernameTextView.setText(message.getSenderName());
            mMessageTextView.setText(message.getText());
            mDateSentTextView.setText(format.format(message.getDateSent()));
        }
    }
}
