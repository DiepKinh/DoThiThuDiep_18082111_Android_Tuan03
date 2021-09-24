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

public class MainActivity2_1 extends AppCompatActivity implements TayLorListener{
    RecyclerView rcv;
    ArrayList<Taylor> mTaylors;
    CustomTaylor adt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_1);

        rcv = findViewById(R.id.rcv);
        mTaylors = new ArrayList<>();
        mTaylors.add(new Taylor(R.drawable.taylor,"Love Story","Taylor Swift"));
        mTaylors.add(new Taylor(R.drawable.taylor,"Love Story","Taylor Swift"));
        mTaylors.add(new Taylor(R.drawable.taylor,"Love Story","Taylor Swift"));
        mTaylors.add(new Taylor(R.drawable.taylor,"Love Story","Taylor Swift"));
        mTaylors.add(new Taylor(R.drawable.taylor,"Love Story","Taylor Swift"));
        mTaylors.add(new Taylor(R.drawable.taylor,"Love Story","Taylor Swift"));
        mTaylors.add(new Taylor(R.drawable.taylor,"Love Story","Taylor Swift"));

        adt = new CustomTaylor(mTaylors,this);
        rcv.setAdapter(adt);
        rcv.setHasFixedSize(true);
        rcv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
    }

    @Override
    public void ItemClick(Taylor taylor, ImageView img) {
        Fade fade = new Fade();
        View decor = getWindow().getDecorView();
        getWindow().setEnterTransition(fade);
        getWindow().setExitTransition(fade);

        Intent intent = new Intent(MainActivity2_1.this, MainActivity2_2.class);
        intent.putExtra("taylor",taylor);

        ActivityOptionsCompat options =  ActivityOptionsCompat.makeSceneTransitionAnimation(
                MainActivity2_1.this, img,
                ViewCompat.getTransitionName(img));


        overridePendingTransition(R.anim.translate_2,R.anim.translate_1);
        startActivity(intent);
    }
}