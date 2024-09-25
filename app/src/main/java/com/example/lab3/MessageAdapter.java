package com.example.lab3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {

    private List<Message> messageList;

    // Constructor
    public MessageAdapter(List<Message> messageList) {
        this.messageList = messageList;
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the item_message layout
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_message, parent, false);
        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        // Get the current message
        Message message = messageList.get(position);

        // Bind the message data to the views
        holder.messageTitle.setText(message.getTitle());
        holder.messageTime.setText(message.getTime());
        holder.messageDescription.setText(message.getDescription());
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    // ViewHolder class
    public static class MessageViewHolder extends RecyclerView.ViewHolder {

        TextView messageTitle;
        TextView messageTime;
        TextView messageDescription;

        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);

            // Find views by ID
            messageTitle = itemView.findViewById(R.id.messageTitle);
            messageTime = itemView.findViewById(R.id.messageTime);
            messageDescription = itemView.findViewById(R.id.messageDescription);
        }
    }
}
