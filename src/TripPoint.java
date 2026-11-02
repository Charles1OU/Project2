import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

// @param time time of point in mins
// @param lat is the latitude of the point
//@param lon is the longitude of the point
public class TripPoint {
	private double lat;
private	double lon;
	private int time;
private	static ArrayList<TripPoint> trip = new ArrayList<TripPoint>();;
	
	TripPoint(int time, double lat, double lon) {
		 this.time = time;
	        this.lat = lat;
	        this.lon = lon;
	}
	//@return returns time of current TripPoint
	 public int getTime() {
	        return time;
	    }
//@return returns latitude of the current TripPoint
	    public double getLat() {
	        return lat;
	    }
//@return returns longitude of the current point
	    public double getLon() {
	        return lon;
	    }
	    //@return returns size of the arrayList
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
	    //@return Total time taken in the ArrayList
	    public static double totalTime() {
	        if (trip.size() < 2) {
	            return 0.0;
	        }

	        int initialTime = trip.get(0).getTime();
	        int finalTime = trip.get(trip.size() - 1).getTime();

	        return (finalTime - initialTime) / 60.0;
	    }
	    //@return distance from point A to point B
	    public static double haversineDistance(TripPoint a, TripPoint b) {
	    	double phi = b.getLat() - a.getLat();
	    	double lamba = b.getLon() - a.getLon();
	    	double angle = (1 - Math.cos(phi) + Math.cos(a.getLat()) * Math.cos(b.getLat())
	    	        * (1 - Math.cos(lamba))) / 2;
	    	double radians = angle * (Math.PI/180);
	    	double distance = 6371.2 * radians;
	    	
	    	
	    	return distance;
	    }
	    public static double totalDistance() {
	    	
	    }
	    public static double avgSpeed(TripPoint a, TripPoint b) {
	    	
	    }
}
