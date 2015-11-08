package com.world.farzeen.yesboss;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * A placeholder fragment containing a simple view.
 */
public class Frag_DeviceList extends Fragment {
    String devices[] = {
        "Main", "AC", "Fridge", "Motor", "Light 1", "Light 2", "Light 3", "Light 4"
    };

    public Frag_DeviceList() {
        ListView L;
        R.layout.fragment_main
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }
}
