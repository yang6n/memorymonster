package cn.zhangxianli.memorymonster;

import android.os.Bundle;
import android.support.v4.util.LongSparseArray;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_iamhungry) {
            this.roar();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private LongSparseArray<Cake> largeBelly = new LongSparseArray<Cake>();



    private void roar() {
//        final ActivityManager activityManager = (ActivityManager)this.getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE);
//
//        Log.d("MONSTER", "LargeMemoryClass: " + activityManager.getLargeMemoryClass());
//
//        ActivityManager.MemoryInfo mi = new ActivityManager.MemoryInfo();
//
//        activityManager.getMemoryInfo(mi);

        int freeMemory = (int) Runtime.getRuntime().freeMemory();

        largeBelly.put(System.currentTimeMillis(), new Cake(new byte[freeMemory]));
        Log.d("MONSTER", "allocated bombByteArray with size: " + freeMemory);
    }

    private class Cake {
        private byte[] aCacke;

        private Cake(byte[] aCacke) {
            this.aCacke = aCacke;
        }
    }
}
