package co.edu.ierdminayticha.sgd.batchdocumentaryretention.entity;

import java.time.LocalDate;

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
@Table(name = "\"METADATOS\"")
public class MetadataEntity {

	@Id
	@SequenceGenerator(name = "\"SEQ_METADATA_ID\"", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "\"SEQ_METADATA_ID\"")
	@Column(name = "\"ID\"")
	private Long id;
	@Column(name = "\"ID_TIPO_DOCUMENTAL_FK\"")
	private Long documentaryType;
	@ManyToOne
	@JoinColumn(name = "\"ID_SERIE_FK\"")
	private SerieEntity serie;
	@ManyToOne
	@JoinColumn(name = "\"ID_SUBSERIE_FK\"")
	private SubSerieEntity subSerie;
	@Column(name = "\"ID_CARPETA_PADRE_FK\"")
	private Long parent;
	@Column(name = "\"NOMBRE\"")
	private String name;
	@Column(name = "\"COMENTARIO\"")
	private String comment;
	@Column(name = "\"TAMANO\"")
	private Integer size;
	@Column(name = "\"CODIGO_BINARIO\"")
	private String fieldId;
	@Column(name = "\"FECHA_CONSERVACION\"")
	private LocalDate preservationDate;
	@Column(name = "\"TIPO_CONTENIDO\"")
	private String contentType;
	@Column(name = "\"FAMILIA_DOCUMENTO\"")
	private String documentFamily;
	@Column(name = "\"USUARIO_CREACION\"")
	private String creationUser;
	@Column(name = "\"FECHA_CREACION\"")
	private LocalDate creationDate;
	@Column(name = "\"FECHA_MODIFICACION\"")
	private LocalDate lastModifiedDate;

}
