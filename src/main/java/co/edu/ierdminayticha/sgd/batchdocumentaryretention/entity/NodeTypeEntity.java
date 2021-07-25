package co.edu.ierdminayticha.sgd.batchdocumentaryretention.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "\"TIPOS_NODOS\"")
public class NodeTypeEntity {

	@Id
	@SequenceGenerator(name = "\"SEQ_TIPOS_NODOS_ID\"", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "\"SEQ_TIPOS_NODOS_ID\"")
	@Column(name = "\"ID\"")
	private Long id;

	@Column(name = "\"NOMBRE\"")
	private String name;

}