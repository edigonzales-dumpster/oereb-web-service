package ch.so.agi.oereb.web.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;

@Entity
public class RestrictionOnLandownershipEntity {
	private static final long serialVersionUID = 1L;

	@Id
	private int t_id;
	
	private String information;
	
	private String theme;
	
	@Column(name = "sub_theme")
	private String subTheme;
	
	@Column(name = "law_status")
	private String lawStatus;
	
	@Column(name = "area_share")
	private int areaShare;
	
	@Column(name = "length_share")
	private int lengthShare;
	
	@Column(name = "nr_of_points")
	private int nrOfPoints;
	
	@Column(name = "part_in_percent")
	private double partInPercent;
	
	private Polygon geom_area; 
	
	private LineString geom_line; 
	
	private Point geom_point; 
}
