package kr.ac.mjc.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class NextActivity extends AppCompatActivity implements View.OnClickListener {

    TextView nameTv;
    Button nextBtn;
    Button prevBtn;

    ImageView imageIv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        nameTv=findViewById(R.id.name_tv);
        nextBtn=findViewById(R.id.next_btn);
        prevBtn=findViewById(R.id.prev_btn);
        imageIv=findViewById(R.id.image_iv);

        Intent intent=getIntent();
        String name=intent.getStringExtra("name");
        nameTv.setText(name);   //TextView에 intent에서 받아온 이름 설정

        prevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("name","test1");
                setResult(RESULT_OK,intent);
                finish();
            }
        });
        nextBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent,1000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //사진 선택창에서 사용자가 사진을 선택했을때만 동작
        if(requestCode==1000&&resultCode==RESULT_OK){
            Uri uri=data.getData();
            imageIv.setImageURI(uri);
        }
    }
}
