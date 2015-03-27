package se.mah.k3.pfi2.project.kronox;

import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
import java.util.Calendar;
import java.util.Date;

//
public class Post implements Comparable<Post>{
	/**
	 * stores date for 1 schedule post
	 * 
	 * That includes:
	 * -period startTime
	 * -period endTime
	 * -time in Date format
	 * -last edited time for displaying changed icon
	 * -program ID
	 * -teacher/admin signed code
	 * -room id
	 * -moment
	 * 
	 * 
	 * */
	private float x, y, vx, vy, ax, ay; // for animation
	private String startTid,slutTid,updaterad,editedBy,editedSince,programId,KursId,lararId,salID,moment,resursSignatur,biuldingId,building;
	public int sort;
	public Date startTidCal,updateradTidCal;
	private Calendar slutTidCal;
	private boolean raderad,temp,dubbelBokad,extern,onskad; // raderad är cancel, updaterad är ändrad
	public boolean deleteAnimate, stackupAnimate,hide,changed;
	int maxletters= 25; // in moment
	Point2D location;
	Dimension2D dimension;
	
	Post(){
		
		
		
	}

	Post(String update){ // dummy const
		
	
		
	}
	public void display() {

	}
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getVx() {
		return vx;
	}

	public void setVx(float vx) {
		this.vx = vx;
	}

	public float getVy() {
		return vy;
	}

	public void setVy(float vy) {
		this.vy = vy;
	}

	public float getAx() {
		return ax;
	}

	public void setAx(float ax) {
		this.ax = ax;
	}

	public float getAy() {
		return ay;
	}

	public void setAy(float ay) {
		this.ay = ay;
	}

	public String getStartTid() {
		return startTid;
	}

	public void setStartTid(String startTid) {
		this.startTid = startTid;
	}

	public String getSlutTid() {
		return slutTid;
	}

	public void setSlutTid(String slutTid) {
		this.slutTid = slutTid;
	}
	public Date getStartTidCal() {
		return startTidCal;
	}

	public void setStartTidCal(Date date) {
		this.startTidCal = date;
	}

	public Calendar getSlutTidCal() {
		return slutTidCal;
	}

	public void setSlutTidCal(Calendar slutTidCal) {
		this.slutTidCal = slutTidCal;
	}
	public String getUpdaterad() {
		return updaterad;
	}

	public void setUpdaterad(String updaterad) {
		this.updaterad = updaterad;
	}

	public String getEditedBy() {
		return editedBy;
	}

	public void setEditedBy(String editedBy) {
		this.editedBy = editedBy;
	}

	public String getEditedSince() {
		return editedSince;
	}

	public void setEditedSince(String editedBy) {
		this.editedBy = editedBy;
	}
	public String getProgramId() {
		return programId;
	}

	public void setProgramId(String programId) {
		this.programId = programId;
	}

	public String getKursId() {
		return KursId;
	}

	public void setKursId(String kursId) {
		KursId = kursId;
	}

	public String getLararId() {
		return lararId;
	}

	public void setLararId(String lararId) {
		this.lararId = lararId;
	}

	public String getSalID() {
		return salID;
	}

	public void setSalID(String salID) {
		this.salID = salID;
	}

	public String getMoment() {
		return moment;
	}

	public void setMoment(String moment) {
		moment=Constants.fixUTF8(moment);
		moment=Constants.fixHTML(moment);
		if(moment.length()>maxletters)moment=moment.substring(0,maxletters)+"...";
		
		this.moment = moment;
	}
	public String getResursSignatur() {
		return resursSignatur;
	}

	public void setResursSignatur(String setResursSignatur) {
		this.resursSignatur = resursSignatur;
	}

	public boolean isRaderad() {
		return raderad;
	}

	public void setRaderad(boolean raderad) {
		this.raderad = raderad;
	}

	public boolean isTemp() {
		return temp;
	}

	public void setTemp(boolean temp) {
		this.temp = temp;
	}

	public boolean isDubbelBokad() {
		return dubbelBokad;
	}

	public void setDubbelBokad(boolean dubbelBokad) {
		this.dubbelBokad = dubbelBokad;
	}

	public boolean isExtern() {
		return extern;
	}

	public void setExtern(boolean extern) {
		this.extern = extern;
	}

	public boolean isOnskad() {
		return onskad;
	}

	public void setOnskad(boolean onskad) {
		this.onskad = onskad;
	}

	public Point2D getLocation() {
		return location;
	}

	public void setLocation(Point2D location) {
		this.location = location;
	}
	
	public void setLocation(double x,double y) {
		this.location.setLocation(x, y);
	}


	public Dimension2D getDimension() {
		return dimension;
	}

	public void setDimension(Dimension2D dimension) {
		this.dimension = dimension;
	}
	public void setDimension(double x,double y) {
		this.dimension.setSize(x, y);
	}

	
	@Override
	public int compareTo(Post otherPost) {
		if(this.startTidCal.before(otherPost.startTidCal)){
			return (-1);
		}else if(this.startTidCal.after(otherPost.startTidCal))
			return 1;
		else{
		return 0;
		}
	}

	public String getBiuldingId() {
		return biuldingId;
	}

	public void setBiuldingId(String biuldingId) {
		this.biuldingId = biuldingId;
	}

	public void setBiulding(String biuldingString) {

		this.building=biuldingString;
	}

	public String getBiulding() {
		return this.building;
	}

	public void setUpdateradTidCal(Date date) {
		this.updateradTidCal=date;
		
	}
	public Date getUpdateradTidCal() {
	return  updateradTidCal;
		
	}

	public boolean getChanged() {
		return this.changed;
	}

	public void setChanged(boolean b) {
		this.changed=b;
	}



}
