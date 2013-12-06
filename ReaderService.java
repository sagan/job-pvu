package cn.panda.metro.android.package_name;
// change it to your package name here.

import android.app.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import android.util.*;
import android.app.*;
import android.content.*;

//
// 实现与读写器交互的接口
// 
public class ReaderService extends IntentService {

	/**
	 * required, parameter is thread name (id)
	 */
	public ReaderService() {
		super("ReaderService");
	}

	/**
	 * this event is thread-safe, running in the separate thread and 
	 * singleton mode, simple and works well
	 * triggered when receives request,
	 * all requests will be queued to execute by FIFO
	 *
	 */
	@Override
	protected void onHandleIntent(Intent intent) {
		try {
			// first route by intent.getIntExtra("type", 0)
			//
			// type value:
			// 0: (default): query card info (read only); 
			// 1: Trying to read card and process IN station transaction (write)
			// 2: Trying to read card and process OUT station transaction (write)
			// 3: Ticket Analyze ( read only )
			// 10: query reader info (read only)
			// -1: terminate and clear current session: ( to be determined)
			

			// in real circmstance, do the stuff in a new thread
			// do not block here.

			if( intent.getIntExtra("type", 0) == -1 ) {

			} else {
				Thread.sleep(3000); //simulate card reader

				Intent result = new Intent(Commons.READER_RECEIVER);

				// the following variables are necessary and required.
				result.putExtra("type", intent.getIntExtra("type"));
				result.putExtra("id", intent.getIntExtra("id"));
				// return process result: 0: ok, no error. Other values indicate error happened.
				result.putExtra("error", 0); 
				
				// acquired infomation	
				result.putExtra("ticket_type", "单程票");
				result.putExtra("ticket_num", "100002111");
				result.putExtra("ticket_count", "200");

				// send result via broadcast
				sendBroadcast( result );
			}

		} catch( Exception e ) {
		
		}
	}
}

