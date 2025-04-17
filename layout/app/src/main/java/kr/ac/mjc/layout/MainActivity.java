package kr.ac.mjc.layout;

import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button joinBtn=findViewById(R.id.join_btn);

        joinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText idEt=findViewById(R.id.id_et);
                String id=idEt.getText().toString();
                if(id.equals("")){
                    Toast.makeText(MainActivity.this,"아이디를 입력해주세요",Toast.LENGTH_SHORT).show();
                    return;
                }
                EditText password1Et=findViewById(R.id.password1_et);
                EditText password2Et=findViewById(R.id.password2_et);

                String password1=password1Et.getText().toString();
                String password2=password2Et.getText().toString();
                if(password1.length()<4){
                    Toast.makeText(MainActivity.this,"비밀번호는 4자리이상 입력해주세요",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!password1.equals(password2)){
                    Toast.makeText(MainActivity.this,"비밀번호를 확인해주세요",Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(MainActivity.this,"회원가입이 완료되었습니다",Toast.LENGTH_SHORT).show();
                finish();-
            }
        });


    }
}