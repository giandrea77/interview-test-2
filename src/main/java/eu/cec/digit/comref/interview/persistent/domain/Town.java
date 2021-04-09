package eu.cec.digit.comref.interview.persistent.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TOWN")
public class Town implements Serializable {

	private static final long serialVersionUID = 6085577047571202444L;

	@Id
	@Column(name = "NAME")
	private String name;

	@Column(name = "INHABITANTS")
	private Integer inhabitants;

	@JoinColumn(name = "ISP_NAME", referencedColumnName = "SPEED")
	private InternetServiceProvider internetServiceProvider;

}
