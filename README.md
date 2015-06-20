# android-network-watcher
Check network and Bluetooth states and listen for changes.

```
@Override
public void onCreate(Bundle savedInstanceState) {

		// Check network
		boolean isIT = new NetworkHelper().checkIT( (Context) {CONTEXT});

		// Register BluetoothListener
		BluetoothListener mReceiver = new BluetoothListener(this);
		registerReceiver(mReceiver, filter);
}


@Override
public void onDestroy() {
    super.onDestroy();

    // Unregister receiver if set
    try {
        this.unregisterReceiver(mReceiver);
    } catch(IllegalArgumentException e) {
        System.out.println(e);
    }
}
```