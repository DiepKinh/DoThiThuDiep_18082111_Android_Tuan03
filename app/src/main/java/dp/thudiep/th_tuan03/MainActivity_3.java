package dp.thudiep.th_tuan03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.transition.Fade;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity_3 extends AppCompatActivity {
    ImageView imgImage;
    Flower mChair;
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_3);

        btnBack = findViewById(R.id.btnback);
        imgImage = findViewById(R.id.imgImage);
        Intent intent = getIntent();
        if (intent != null){
            mChair = (Flower) intent.getSerializableExtra("key1");
            imgImage.setImageResource(mChair.getAnh());
            Fade fade = new Fade();
            View decor = getWindow().getDecorView();

            //below methods are used for adding enter and exit transition.
            getWindow().setEnterTransition(fade);
            getWindow().setExitTransition(fade);
        }

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity_3.this, MainActivity_2.class));
            }
        });
    }
}