# android-network-watcher
Check network/Bluetooth state and monitor changes.

## Usage

```java
@Override
public void onCreate(Bundle savedInstanceState) {

	// Check network (wifi/3g)
	boolean isIT = new NetworkWatcher().checkIT( (Context) <CONTEXT>);

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