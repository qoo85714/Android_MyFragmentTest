package tw.jason.app.helloworld.myfragmenttest;

import android.content.Context;

import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class F1Fragment extends Fragment {
    private TextView mesg;
    private  View mainView;
    private  MainActivity mainActivity;
    private TextView mainTitle;
    public F1Fragment(){
        Log.i("brad","F1Fragment()");
    }
    public static F1Fragment newInstance() {
        F1Fragment f1Fragment = new F1Fragment();
        return f1Fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("brad","F1Fragment:onCreate()");
        mainActivity = (MainActivity)getActivity();
        mainTitle = mainActivity.getMainTitle();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (mainView == null) {
            mainView = inflater.inflate(R.layout.fragment_f1, container, false);
            mesg = (TextView) mainView.findViewById(R.id.f1mesg);
            final View f1test1 = mainView.findViewById(R.id.f1test1);
            f1test1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    f1test1();
                }
            });
            final View f1test2 = mainView.findViewById(R.id.f1test2);
            f1test2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    f1test2();
                }
            });
            final View f1test3 = mainView.findViewById(R.id.f1test3);
            f1test3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    f1test3();
                }
            });
        }

        return mainView;
    }

    private void f1test1(){
        mesg.setText("" + (int)(Math.random()*49+1));
    }
    private void f1test2(){
        mainTitle.setText("Title Changed");

    }
    private void f1test3(){
        TextView f2mesg = mainActivity.getF2().getF2mesg();
        if(f2mesg !=null){
            f2mesg.setText("Changed by F1");
        }


    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i("brad","F1Fragment:onAttach()");

    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("brad","F1Fragment:onDetach()");

    }


}
