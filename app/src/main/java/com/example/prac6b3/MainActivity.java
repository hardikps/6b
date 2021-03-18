package com.example.prac6b3;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.prac6b3.MyDialogFragment;
import com.example.prac6b3.R;

public class MainActivity extends Activity implements
        MyDialogFragment.Communicator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void showDialog(View view) {

        FragmentManager manager = getFragmentManager();
        MyDialogFragment mydialog = new MyDialogFragment();
        mydialog.show(manager, "mydialog");

    }

    @Override
    public void message(String data) {

        Toast.makeText(getApplicationContext(), data + " button clicked",
                Toast.LENGTH_SHORT).show();

    }

}