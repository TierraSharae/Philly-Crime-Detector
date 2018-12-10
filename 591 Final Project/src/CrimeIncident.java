import java.util.Comparator; 
public class CrimeIncident {
	
	
	/**
	 * This program defines CrimeIncident objects by location and time  
	 * 
	 * @author TamaraPrabhakar
	 *
	 */
	
	
	private int zone;
	private int hour;
	
	public CrimeIncident(int hour, int zone) {
		super();
		this.hour = hour;
		this.zone = zone;
	}

	public int getZone() {
		return zone;
	}

	
	public int getHour() {
		return hour;
	}

	public static Comparator<CrimeIncident> TimeComparator = new Comparator<CrimeIncident>() {

		public int compare(CrimeIncident c1, CrimeIncident c2) {

		   int time1 = c1.getHour();
		   int time2 = c2.getHour();

		   /*For ascending order*/
		   return time1-time2;

	   }
	};
	
	   public static Comparator<CrimeIncident> ZoneComparator = new Comparator<CrimeIncident>() {

			public int compare(CrimeIncident c1, CrimeIncident c2) {

			   int zone1 = c1.getZone();
			   int zone2 = c2.getZone();

			   /*For ascending order*/
			   return zone1-zone2;

			}
		};
}
