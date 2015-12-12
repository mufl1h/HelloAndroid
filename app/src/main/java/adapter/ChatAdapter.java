package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import hello.example.com.firebase.R;
import hello.example.com.firebase.model.User;

/**
 * Created by muflih on 12/12/15.
 */
public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatHolder>{
    private Context context;
    private List<User> list;

    public ChatAdapter(Context context, List<User> list) {
        this.context = context;
        this.list = list;
    }

    public ChatAdapter() {
    }

    @Override

    public ChatHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ChatHolder(LayoutInflater.from(context).inflate(R.layout.login, parent, false));
    }

    @Override
    public void onBindViewHolder(ChatHolder holder, int position) {
        holder.textView1.setText(list.get(position).getUsername());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ChatHolder extends RecyclerView.ViewHolder {
        TextView textView1;
        public ChatHolder(View itemView){
            super(itemView);
            textView1 = (TextView) itemView.findViewById(R.id.input_message);
        }
    }
}
