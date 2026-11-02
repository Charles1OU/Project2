import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TripPoint {
	double lat;
	double lon;
	int time;
	ArrayList<TripPoint> trip;
	
	TripPoint(int time, double lat, double lon) {
		 this.time = time;
	        this.lat = lat;
	        this.lon = lon;
	        this.trip = new ArrayList<TripPoint>();
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

	    public ArrayList<TripPoint> getTrip() {
	        return new ArrayList<TripPoint>(trip);
	    }
	    public void readFile(String filename) throws IOException {
	        BufferedReader br = new BufferedReader(new FileReader(filename));

	        String line = br.readLine();

	        while ((line = br.readLine()) != null) {
	            String[] data = line.split(",");

	            int time = Integer.parseInt(data[0]);
	            double lat = Double.parseDouble(data[1]);
	            double lon = Double.parseDouble(data[2]);

	            trip.add(new TripPoint(time, lat, lon));
	        }

	        br.close();
	    }
}
