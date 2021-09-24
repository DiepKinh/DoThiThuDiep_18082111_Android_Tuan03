package dp.thudiep.th_tuan03;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomTaylor extends RecyclerView.Adapter<CustomTaylor.ViewHolder> {
    ArrayList<Taylor> mTaylors;
    TayLorListener listener;

    public CustomTaylor(ArrayList<Taylor> taylors, TayLorListener listener) {
        mTaylors = taylors;
        this.listener = listener;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_taylor,parent,false);
        return new ViewHolder(view);
    }



    @Override
    public int getItemCount() {
        return mTaylors.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Taylor mTaylor;
        ImageView imgTaylor;
        TextView txtSong, txtNameT;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgTaylor = itemView.findViewById(R.id.imgTaylor);
            txtSong = itemView.findViewById(R.id.txtSong);
            txtNameT = itemView.findViewById(R.id.txtNameT);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.ItemClick(mTaylor, imgTaylor);
                }
            });
        }
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Taylor taylor=  mTaylors.get(position);
        holder.mTaylor = taylor;
        holder.imgTaylor.setImageResource(taylor.getAnh());
        holder.txtSong.setText(taylor.getSong());
        holder.txtNameT.setText(taylor.getName());


    }
}
