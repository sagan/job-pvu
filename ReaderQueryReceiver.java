package cn.panda.metro.android.psu;
// change it to your package name

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import android.util.*;
import android.app.*;
import android.os.*;
import android.content.*;



public class ReaderQueryReceiver extends BroadcastReceiver {
	public ReaderQueryReceiver(){
		//Commons.log("ReaderQueryReceiver construction");
	}

	@Override
	public void onReceive(Context context, Intent intent) {
		// do your work quickly!

		Intent reader_task =  new Intent(context, ReaderService.class);
		reader_task.putExtra("type", intent.getIntExtra("type", 0));
		reader_task.putExtra("id", intent.getIntExtra("id", 0));

		context.startService( reader_task  );
	}   

}
