import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TripPoint {
	double lat;
	double lon;
	int time;
	public static ArrayList<TripPoint> trip = new ArrayList<TripPoint>();;
	
	TripPoint(int time, double lat, double lon) {
		 this.time = time;
	        this.lat = lat;
	        this.lon = lon;
	}
	 public int getTime() {
	        return time;
	    }

	    public double getLat() {
	        return lat;
	    }

	    public double getLon() {
	        return lon;
	    }
	    public int size() {
	        return trip.size();
	    }

	    public ArrayList<TripPoint> getTrip() {
	        return new ArrayList<TripPoint>(trip);
	    }
	    public static void readFile(String filename) throws IOException {
	        BufferedReader br = new BufferedReader(new FileReader(filename));

	        String reader = br.readLine();

	        while ((reader = br.readLine()) != null) {
	            String[] data = reader.split(",");

	            int time = Integer.parseInt(data[0]);
	            double lat = Double.parseDouble(data[1]);
	            double lon = Double.parseDouble(data[2]);

	            trip.add(new TripPoint(time, lat, lon));
	        }

	        br.close();
	    }
	    public static double totalTime() {
	        if (trip.size() < 2) {
	            return 0.0;
	        }

	        int initialTime = trip.get(0).getTime();
	        int finalTime = trip.get(trip.size() - 1).getTime();

	        return (finalTime - initialTime) / 60.0;
	    }
}
