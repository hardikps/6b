package com.example.prac6b3;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class MyDialogFragment extends DialogFragment implements OnClickListener {

    Button yes_button, no_button;
    Communicator communicator;

    @Override
    public void onAttach(Activity activity) {

        super.onAttach(activity);

        if (activity instanceof Communicator) {
            communicator = (Communicator) getActivity();
        } else {
            throw new ClassCastException(activity.toString()
                    + " must implemenet MyListFragment.communicator");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        setCancelable(false);
        getDialog().setTitle("Title");

        View view = inflater.inflate(R.layout.dialog_fragment, null, false);

        yes_button = (Button) view.findViewById(R.id.yesbtn);
        no_button = (Button) view.findViewById(R.id.nobtn);

        // setting onclick listener for buttons
        yes_button.setOnClickListener(this);
        no_button.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.yesbtn :
                dismiss();
                communicator.message("Dialog Yes btn clicked");
                break;

            case R.id.nobtn :
                dismiss();
                communicator.message("Dialog No btn clicked");
                break;
        }

    }

    public interface Communicator {
        public void message(String data);
    }

}