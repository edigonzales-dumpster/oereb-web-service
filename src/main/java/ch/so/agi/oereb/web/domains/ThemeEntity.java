package ch.so.agi.oereb.web.domains;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.vividsolutions.jts.geom.Polygon;

// TODO: Is geometry property needed if it will be used in the query (repository)?

@Entity
public class ThemeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int t_id;
	
	private String theme;
	
	private boolean concerned;
	
	private String title;

	public int getT_id() {
		return t_id;
	}

	public void setT_id(int t_id) {
		this.t_id = t_id;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public boolean isConcerned() {
		return concerned;
	}

	public void setConcerned(boolean concerned) {
		this.concerned = concerned;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
