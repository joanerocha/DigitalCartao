package joane.digitalcartao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;

import com.orm.SugarContext;

public class CartaoVacina extends AppCompatActivity {

//    TextView v11 = (TextView) findViewById(R.id.v11);
//    private boolean tomou = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartao_vacina);
        SugarContext.init(this);

    }

//    public boolean onTouchEvent(MotionEvent motionEvent){
//     if(tomou == true){
//         v11.getHighlightColor();
//     }
//        return tomou;
//    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        SugarContext.terminate();
    }
}
