package com.sihsoyauhsoj.subwaytest3;

import androidx.appcompat.app.AppCompatActivity;

import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;
import com.sihsoyauhsoj.python.utils.*;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Python pyInstance;
        if(!Python.isStarted()){
            Python.start(new AndroidPlatform(this));
            pyInstance = Python.getInstance();
        } else{
            pyInstance = Python.getInstance();
        }
//        com.chaquo.python.PyObject pym = pyInstance.getModule("main"); //<-input module name here (what the python filename is, minus the .py)
//        com.chaquo.python.PyObject output = pym.callAttr("input", "this is a sentence and it is veeeeeeeeeeery long"); //<-input function name/args here

        com.chaquo.python.PyObject pym = pyInstance.getModule("subwayTest");
        com.chaquo.python.PyObject output = pym.callAttr("getCoordX", "2");

        String num = output.toString();
        handleText(num);
    }

    public void handleText(String text) {
        TextView t = (TextView) findViewById(R.id.textview);
//        String input = t.getText().toString();
//        Log.d("info", input);
        t.setText(text);
    }


}