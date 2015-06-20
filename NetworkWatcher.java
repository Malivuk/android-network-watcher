package com.{package};


import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


class NetworkWatcher {

    // Check if bluetooth is enabled
    public boolean checkBT() {

        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        return mBluetoothAdapter != null && mBluetoothAdapter.isEnabled();
    }


    // Check if data/wifi is enabled
    public boolean checkIT(Context context) {

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }


    // Enable bluetooth
    public void enableBT() {

        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        bluetoothAdapter.enable();
    }
}


class BluetoothListener extends BroadcastReceiver {

    MainActivity parentActivity;

    public BluetoothListener(MainActivity parentActivity) {
        this.parentActivity = parentActivity;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        final String action = intent.getAction();

        if (action.equals(BluetoothAdapter.ACTION_STATE_CHANGED)) {
            final int state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, BluetoothAdapter.ERROR);

            // Send broadcast when BT is ready
            if(state == BluetoothAdapter.STATE_ON) {

                // ...
            }

            // Check other states...
        }
    }
}
