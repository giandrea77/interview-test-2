package eu.cec.digit.comref.interview.persistent.domain;

import java.io.Serializable;

import javax.persistence.*;

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

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ISP_NAME", referencedColumnName = "NAME")
	private InternetServiceProvider internetServiceProvider;

}
