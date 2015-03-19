package se.mah.k3.pfi2.project.kronox;

//
public class Post {
	/**
	 * stores date for 1 schedule post
	 * 
	 * That includes:
	 * -period startTime
	 * -period endTime
	 * -last edited time for displaying changed icon
	 * -program ID
	 * -teacher/admin signed code
	 * -room id
	 * -moment
	 * 
	 * 
	 * */
	private float x, y, vx, vy, ax, ay; // for animation
	private Cell[] cell= new Cell[5]; // diffrent colunm in canvas
	private String startTid,slutTid,updaterad,editedBy,editedSince,programId,KursId,lararId,salID,moment;
	private boolean raderad,temp,dubbelBokad,extern,onskad;
	

	Post(){
		
		
		
		
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

	public Cell[] getCell() {
		return cell;
	}

	public void setCell(Cell[] cell) {
		this.cell = cell;
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
		this.moment = moment;
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


}
