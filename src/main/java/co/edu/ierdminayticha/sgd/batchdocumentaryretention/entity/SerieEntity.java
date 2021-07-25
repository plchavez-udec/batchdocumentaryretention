package co.edu.ierdminayticha.sgd.batchdocumentaryretention.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "\"SERIES\"")
public class SerieEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SeqSerieId")
	@SequenceGenerator(name = "SeqSerieId", allocationSize = 1, sequenceName = "\"SEQ_SERIE_ID\"")
	@Column(name = "\"ID\"")
	private Long id;
	@ManyToOne
	@JoinColumn(name = "\"ID_TIPO_DISPOSICION_FK\"")
	private FinalDisposalTypeEntity finalDisposalType;
	@Column(name = "\"CODIGO\"")
	private String code;
	@Column(name = "\"NOMBRE\"")
	private String name;
	@Column(name = "\"PROCEDIMIENTO\"")
	private String process;
	@Column(name = "\"TIEMPO_RETENCION\"")
	private Long retentionTime;
	@Column(name = "\"FECHA_CREACION\"")
	private Date creationDate;
	@Column(name = "\"FECHA_MODIFICACION\"")
	private Date lastModifiedDate;

}
