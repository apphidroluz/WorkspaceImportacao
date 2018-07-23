package entity;

public class Dados {
	
	private Integer code;
	private String measure;
	private String device;
	private String date;
	//private String alarm;
	private Integer measuring;
		
	public Dados() {
	}

	public Dados(Integer code, String measure, String device, String date,  
			Integer measuring) {
		this.code = code;
		this.measure = measure;
		this.device = device;
		this.date = date;
		
		
		this.measuring = measuring;
	}
	
	@Override
	public String toString() {
		return "\n code:" + code + 
				"\n measure:" + measure + 
				"\n device:" + device + 
				"\n date:" + date +	
				
				"\n measuring:" + measuring;
	}

	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMeasure() {
		return measure;
	}
	public void setMeasure(String measure) {
		this.measure = measure;
	}
	public String getDevice() {
		return device;
	}
	public void setDevice(String device) {
		this.device = device;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public Integer getMeasuring() {
		return measuring;
	}
	public void setMeasuring(Integer measuring) {
		this.measuring = measuring;
	}
	

}
