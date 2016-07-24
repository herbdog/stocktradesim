import java.net.*;
import java.io.*;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;


public class ApiTest2 {
	public static void main(String[] args) throws Exception {
		//scheduled task timer
		int delay = 0;
		int period = 10000; //repeats every 10 seconds
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				try {
					String strURL = "https://download.finance.yahoo.com/d/quotes.csv?s=goog&f=ab"; //base url using goog
					ArrayList<String> stockList = new ArrayList<>();
					stockList.add("goog");
					URL myURL = new URL(strURL);
					BufferedReader in = new BufferedReader(new InputStreamReader(myURL.openStream()));
					String inputLine;
					int i = 0;
					while ((inputLine = in.readLine()) != null) {           
						System.out.print(stockList.get(i) + ": ");
						System.out.println(inputLine);
						i++;
					}
					in.close();	
				} catch (MalformedURLException e) {
					System.err.println("MalformedURLException thrown");
				} catch (IOException e) {
					System.err.println("IOException thrown");
				}
			}
		}, delay, period);
	}
}


