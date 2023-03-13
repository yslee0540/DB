package 자바DB연결;

public class PageVO {
	private String ID;
	private String PW;
	private String NAME;
	private String NICKNAME;
	private String LET;
	
	
	
	public String getID() {
		return ID;
	}



	public void setID(String iD) {
		ID = iD;
	}



	public String getPW() {
		return PW;
	}



	public void setPW(String pW) {
		PW = pW;
	}



	public String getNAME() {
		return NAME;
	}



	public void setNAME(String nAME) {
		NAME = nAME;
	}



	public String getNICKNAME() {
		return NICKNAME;
	}



	public void setNICKNAME(String nICKNAME) {
		NICKNAME = nICKNAME;
	}



	public String getLET() {
		return LET;
	}



	public void setLET(String lET) {
		LET = lET;
	}



	@Override
	public String toString() {return "PageVO [ID=" + ID + ", PW=" + PW + ", NAME=" + NAME + ", NICKNAME=" + NICKNAME + ", LET=" + LET + "]";
	}


}
