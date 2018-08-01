package entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Facturation {
	
	static SimpleDateFormat SDF=new
			SimpleDateFormat("dd/MM/yyyy");
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Integer id_FT;
	
	@Column(length = 18)
	private String localigacao;
	
	@Column
	private Integer indice;
	
	@Column
	private Integer indice_antigo;
	
	@Column
	private Double consumo;
	
	@Column
	private Integer desmontagem;
	
	@Column
	private Integer teve_desmontagem;
	
	@Column
	private Integer vazamento;
	
	@Column
	private Integer teve_vazamento;
	
	@Column
	private Integer medidor_bloqueado;
	
	@Column
	private Integer retorno_agua;
	
	@Column
	private String num_medidor;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date data_levant;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date data_hist;
	
	@Column
	private Integer emissao = 8;
	
	@Column
	private Integer levantamento = null;
	
	@OneToOne
	@JoinColumn(name = "cod_cad01")
	private Clientes cliente;
	
	
	public Facturation() {
		
	}

	public Facturation(Integer id_FT, String localigacao, Integer indice, Integer indice_antigo, Double consumo,
			Integer desmontagem, Integer teve_desmontagem, Integer vazamento, Integer teve_vazamento,
			Integer medidor_bloqueado, Integer retorno_agua, String num_medidor, Date data_levant, Date data_hist,
			Integer emissao, Integer levantamento, Clientes cliente) {
		
		this.id_FT = id_FT;
		this.localigacao = localigacao;
		this.indice = indice;
		this.indice_antigo = indice_antigo;
		this.consumo = consumo;
		this.desmontagem = desmontagem;
		this.teve_desmontagem = teve_desmontagem;
		this.vazamento = vazamento;
		this.teve_vazamento = teve_vazamento;
		this.medidor_bloqueado = medidor_bloqueado;
		this.retorno_agua = retorno_agua;
		this.num_medidor = num_medidor;
		this.data_levant = data_levant;
		this.data_hist = data_hist;
		this.emissao = emissao;
		this.levantamento = levantamento;
		this.cliente = cliente;
		
	}

	@Override
	public String toString() {
		return "Facturation [id_FT=" + id_FT + ", localigacao=" + localigacao + ", indice=" + indice
				+ ", indice_antigo=" + indice_antigo + ", consumo=" + consumo + ", desmontagem=" + desmontagem
				+ ", teve_desmontagem=" + teve_desmontagem + ", vazamento=" + vazamento + ", teve_vazamento="
				+ teve_vazamento + ", medidor_bloqueado=" + medidor_bloqueado + ", retorno_agua=" + retorno_agua
				+ ", num_medidor=" + num_medidor + ", data_levant=" + SDF.format(data_levant) + ", data_hist=" + SDF.format(data_hist)
				+ ", emissao=" + emissao + ", levantamento=" + levantamento + ", cliente=" + cliente  + "]";
	}

	public Integer getId_FT() {
		return id_FT;
	}

	public void setId_FT(Integer id_FT) {
		this.id_FT = id_FT;
	}

	public String getLocaligacao() {
		return localigacao;
	}

	public void setLocaligacao(String localigacao) {
		this.localigacao = localigacao;
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

	public Integer getDesmontagem() {
		return desmontagem;
	}

	public void setDesmontagem(Integer desmontagem) {
		this.desmontagem = desmontagem;
	}

	public Integer getTeve_desmontagem() {
		return teve_desmontagem;
	}

	public void setTeve_desmontagem(Integer teve_desmontagem) {
		this.teve_desmontagem = teve_desmontagem;
	}

	public Integer getVazamento() {
		return vazamento;
	}

	public void setVazamento(Integer vazamento) {
		this.vazamento = vazamento;
	}

	public Integer getTeve_vazamento() {
		return teve_vazamento;
	}

	public void setTeve_vazamento(Integer teve_vazamento) {
		this.teve_vazamento = teve_vazamento;
	}

	public Integer getMedidor_bloqueado() {
		return medidor_bloqueado;
	}

	public void setMedidor_bloqueado(Integer medidor_bloqueado) {
		this.medidor_bloqueado = medidor_bloqueado;
	}

	public Integer getRetorno_agua() {
		return retorno_agua;
	}

	public void setRetorno_agua(Integer retorno_agua) {
		this.retorno_agua = retorno_agua;
	}

	public String getNum_medidor() {
		return num_medidor;
	}

	public void setNum_medidor(String num_medidor) {
		this.num_medidor = num_medidor;
	}

	public Date getData_levant() {
		return data_levant;
	}

	public void setData_levant(Date data_levant) {
		this.data_levant = data_levant;
	}

	public Date getData_hist() {
		return data_hist;
	}

	public void setData_hist(Date data_hist) {
		this.data_hist = data_hist;
	}

	public Integer getEmissao() {
		return emissao;
	}

	public void setEmissao(Integer emissao) {
		this.emissao = emissao;
	}

	public Integer getLevantamento() {
		return levantamento;
	}

	public void setLevantamento(Integer levantamento) {
		this.levantamento = levantamento;
	}

	public Clientes getCliente() {
		return cliente;
	}

	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}
	

}
