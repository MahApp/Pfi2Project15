package se.mah.k3.pfi2.project.traficinfo;

import java.util.Calendar;
/**
 * A Journey has a start and an endstation. Stations between start and stop are not implemented in this version
 * @author K3LARA
 *
 */
public class Journey {
	private Calendar depDateTime;
	private Calendar arrDateTime;
	private String noOfChanges;
	private String lineOnFirstJourney;
	private String travelMinutes;
	private String timeToDeparture;
	private String noOfZones;
	private String lineTypeName;
	private String depTimeDeviation;
	private String arrTimeDeviation;
	private Station startStation;
	private Station endStation;
	
	private String depDeviationAffect;
	private String details;
	private String text;

	
	public Journey(Station startStation, Station endStation) {
		this.startStation = startStation;
		this.endStation = endStation;
	}
	public Calendar getDepDateTime() {
		return depDateTime;
	}
	public void setDepDateTime(Calendar depDateTime) {
		this.depDateTime = depDateTime;
	}
	public Calendar getArrDateTime() {
		return arrDateTime;
	}
	public void setArrDateTime(Calendar arrTime) {
		this.arrDateTime = arrTime;
	}
	public String getNoOfChanges() {
		return noOfChanges;
	}
	public void setNoOfChanges(String number) {
		this.noOfChanges = number;
	}
	
	public Station getStartStation(){
		return this.startStation;
	}
	
	public Station getEndStation(){
		return this.endStation;
	}
	
	public String getLineOnFirstJourney() {
		return lineOnFirstJourney;
	}
	
	public void setLineOnFirstJourney(String lineOnFirstJourney) {
		this.lineOnFirstJourney = lineOnFirstJourney;
	}
	
	public void setTravelTime(String travelMinutes) {
		this.travelMinutes = travelMinutes;
		
	}
	
	public String getTravelMinutes(){
		return this.travelMinutes;
	}
	public String getTimeToDeparture() {
		return timeToDeparture;
	}
	public void setTimeToDeparture(String timeToDeparture) {
		this.timeToDeparture = timeToDeparture;
	}
	public String getNoOfZones() {
		return noOfZones;
	}
	public void setNoOfZones(String noOfZones) {
		this.noOfZones = noOfZones;
	}
	public String getLineTypeName() {
		return lineTypeName;
	}
	public void setLineTypeName(String lineTypeName) {
		this.lineTypeName = lineTypeName;
	}
	public String getDepTimeDeviation() {
		return depTimeDeviation;
	}
	public void setDepTimeDeviation(String depTimeDeviation) {
		this.depTimeDeviation = depTimeDeviation;
	}
	public String getArrTimeDeviation() {
		return arrTimeDeviation;
	}
	public void setArrTimeDeviation(String arrTimeDeviation) {
		this.arrTimeDeviation = arrTimeDeviation;
	}
	public void setStartStation(Station startStation) {
		this.startStation = startStation;
	}
	public void setEndStation(Station endStation) {
		this.endStation = endStation;
	}
	
	
	public void setDepDeviationAffect(String depDeviationAffect){
				this.depDeviationAffect = depDeviationAffect;
	}
			
	public String getDepDeviationAffect(){
				return depDeviationAffect;
	}
	
	public void setDetails(String details){
		this.details = details;
	}
	
	public String getDetails(){
		return details;
	}
	
	public void setText(String text){
		this.text = text;
	}
	
	public String getText(){
		return text;
	}

	
}
