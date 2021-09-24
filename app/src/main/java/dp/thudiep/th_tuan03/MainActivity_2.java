package dp.thudiep.th_tuan03;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.transition.Fade;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity_2 extends AppCompatActivity implements OnClickListener{
    RecyclerView rcv;
    CustomRec adt;
    ArrayList<Flower> mChairs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);

        rcv = findViewById(R.id.rcv);
        mChairs = new ArrayList<>();

        mChairs.add(new Flower(R.drawable.removebg_flower,25,"Lavender"));
        mChairs.add(new Flower(R.drawable.removebg_plant_a,23,"Yellow"));
        mChairs.add(new Flower(R.drawable.removebg_plant_b,25,"LightLavender"));
        mChairs.add(new Flower(R.drawable.removebg_preview,18,"ShortLavender"));
        mChairs.add(new Flower(R.drawable.remove_bg,7,"ShortGreen"));
        adt=  new CustomRec(mChairs,this);

        rcv.setAdapter(adt);
        rcv.setHasFixedSize(true);
        rcv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

    }

    @Override
    public void itemClick(Flower chair, ImageView img) {
        Fade fade = new Fade();
        View decor = getWindow().getDecorView();
//        // we are   fade animation for enter transition.
        getWindow().setEnterTransition(fade);
//
//        // we are also setting fade animation for exit transition.
        getWindow().setExitTransition(fade);
//        // initializing our imageview.
        Intent intent = new Intent(MainActivity_2.this,MainActivity_3.class);

        intent.putExtra("key1",chair);
        ActivityOptionsCompat options =  ActivityOptionsCompat.makeSceneTransitionAnimation(
                MainActivity_2.this, img,
                ViewCompat.getTransitionName(img));
        startActivity(intent, options.toBundle());
    }

}