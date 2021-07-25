package co.edu.ierdminayticha.sgd.batchdocumentaryretention.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "\"HIJOS_CARPETA\"")
public class ChildrenEntity {

	@Id
	@Column(name = "\"ID\"")
	private Long id;
	@ManyToOne
	@JoinColumn(name = "\"ID_TIPO_NODO_FK\"")
	private NodeTypeEntity nodeType;

}