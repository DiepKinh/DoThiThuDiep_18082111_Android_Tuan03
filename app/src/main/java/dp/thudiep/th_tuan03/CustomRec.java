package dp.thudiep.th_tuan03;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomRec extends RecyclerView.Adapter<CustomRec.ViewHolder> {
    ArrayList<Flower> mChairs;
    OnClickListener listener;

    public CustomRec(ArrayList<Flower> chairs, OnClickListener listener) {
        mChairs = chairs;
        this.listener = listener;
    }

    @NonNull
    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }



    @Override
    public int getItemCount() {
        return mChairs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Flower mChair;
        ImageView img;
        TextView txtName, txtPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imgAnh);
            txtName = itemView.findViewById(R.id.txtName);
            txtPrice = itemView.findViewById(R.id.txtPrice);

        }
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Flower chair = mChairs.get(position);
        holder.mChair = chair;
        holder.img.setImageResource(chair.getAnh());
        holder.txtName.setText(chair.getName());
        holder.txtPrice.setText(chair.getPrice()+" $");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.itemClick(chair, holder.img);
            }
        });
    }
}
