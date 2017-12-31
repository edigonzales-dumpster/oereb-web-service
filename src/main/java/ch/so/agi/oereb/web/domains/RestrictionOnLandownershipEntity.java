package ch.so.agi.oereb.web.domains;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class RestrictionOnLandownershipEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int t_id;
	
	private String information;
	
	private String theme;
	
	@Column(name = "sub_theme")
	private String subTheme;
	
	@Column(name = "law_status")
	private String lawStatus;	
}
