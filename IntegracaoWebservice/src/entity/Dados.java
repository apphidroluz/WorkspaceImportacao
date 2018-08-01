package entity;

public class Dados implements Comparable<Dados> {

	private Integer code;

	private String measure;
	private String device;
	private String date;
	private String alarm;
	private String data_hist;
	private Integer indice;
	private Integer indice_antigo;
	private Double consumo;
	private Integer measuring;
	private String localizacao;
	private Integer codigo;
	private Integer haVazamento;
	private Integer houveVazamento;
	private Integer haDesmontagem;
	private Integer houveDesmontagem;
	private Integer medidorBloqueado;
	private Integer retornoAgua;

	public String getData_hist() {
		return data_hist;
	}

	public void setData_hist(String data_hist) {
		this.data_hist = data_hist;
	}

	public Integer getIndice() {
		return indice;
	}

	public void setIndice(Integer indice) {
		this.indice = indice;
	}

	public Integer getIndice_antigo() {
		return indice_antigo;
	}

	public void setIndice_antigo(Integer indice_antigo) {
		this.indice_antigo = indice_antigo;
	}

	public Double getConsumo() {
		return consumo;
	}

	public void setConsumo(Double consumo) {
		this.consumo = consumo;
	}

	public Integer getHaVazamento() {
		return haVazamento;
	}

	public void setHaVazamento(Integer haVazamento) {
		this.haVazamento = haVazamento;
	}

	public Integer getHouveVazamento() {
		return houveVazamento;
	}

	public void setHouveVazamento(Integer houveVazamento) {
		this.houveVazamento = houveVazamento;
	}

	public Integer getHaDesmontagem() {
		return haDesmontagem;
	}

	public void setHaDesmontagem(Integer haDesmontagem) {
		this.haDesmontagem = haDesmontagem;
	}

	public Integer getHouveDesmontagem() {
		return houveDesmontagem;
	}

	public void setHouveDesmontagem(Integer houveDesmontagem) {
		this.houveDesmontagem = houveDesmontagem;
	}

	public Integer getMedidorBloqueado() {
		return medidorBloqueado;
	}

	public void setMedidorBloqueado(Integer medidorBloqueado) {
		this.medidorBloqueado = medidorBloqueado;
	}

	public Integer getRetornoAgua() {
		return retornoAgua;
	}

	public void setRetornoAgua(Integer retornoAgua) {
		this.retornoAgua = retornoAgua;
	}

	public Dados() {
	}

	public Dados(Integer code, String measure, String device, String date, Integer measuring, String alarm) {
		this.code = code;
		this.measure = measure;
		this.device = device;
		this.alarm = alarm;
		this.date = date;
		this.measuring = measuring;
	}

	@Override
	public String toString() {
		return "Dados [code=" + code + ", measure=" + measure + ", device=" + device + ", date=" + date + ", alarm="
				+ alarm + ", data_hist=" + data_hist + ", indice=" + indice + ", indice_antigo=" + indice_antigo
				+ ", consumo=" + consumo + ", measuring=" + measuring + ", localizacao=" + localizacao + ", codigo="
				+ codigo + ", haVazamento=" + haVazamento + ", houveVazamento=" + houveVazamento + ", haDesmontagem="
				+ haDesmontagem + ", houveDesmontagem=" + houveDesmontagem + ", medidorBloqueado=" + medidorBloqueado
				+ ", retornoAgua=" + retornoAgua + "]";
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public String getMeasure() {
		return measure;
	}

	public void setMeasure(String measure) {
		this.measure = measure;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
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

	public String getAlarm() {
		return alarm;
	}

	public void setAlarm(String alarm) {
		this.alarm = alarm;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((device == null) ? 0 : device.hashCode());
		result = prime * result + ((measure == null) ? 0 : measure.hashCode());
		result = prime * result + ((measuring == null) ? 0 : measuring.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dados other = (Dados) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (device == null) {
			if (other.device != null)
				return false;
		} else if (!device.equals(other.device))
			return false;
		if (measure == null) {
			if (other.measure != null)
				return false;
		} else if (!measure.equals(other.measure))
			return false;
		if (measuring == null) {
			if (other.measuring != null)
				return false;
		} else if (!measuring.equals(other.measuring))
			return false;
		return true;
	}

	@Override
	public int compareTo(Dados o) {

		if (this.code > o.code) {
			return -1;
		} else if (this.code < o.code) {
			return 1;
		}

		// TODO Auto-generated method stub
		return 0;
	}

}
