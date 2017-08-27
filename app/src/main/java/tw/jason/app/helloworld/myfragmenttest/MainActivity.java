package tw.jason.app.helloworld.myfragmenttest;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private F1Fragment f1;
    private F2Fragment f2;
    private FragmentManager fmgr;
    private FragmentTransaction tran;
    private boolean isF2;
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = (TextView)findViewById(R.id.title);

        f1 = F1Fragment.newInstance();
        f2 = new F2Fragment();


        fmgr = getFragmentManager();
        tran = fmgr.beginTransaction();

        tran.add(R.id.container,f1);
        tran.commit();


    }


    public void change(View view){
        isF2 = !isF2;

        tran = fmgr.beginTransaction();
        tran.replace(R.id.container,isF2?f2:f1);
        tran.addToBackStack(null);
        tran.commit();
    }
    public  TextView getMainTitle(){
        return  title;
    }
    public F2Fragment getF2(){
        return f2;
    }
}
