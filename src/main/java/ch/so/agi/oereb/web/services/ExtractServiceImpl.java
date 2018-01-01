package ch.so.agi.oereb.web.services;

import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.jvnet.ogc.gml.v_3_2_1.jts.JTSToGML321GeometryConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;

import ch.admin.geo.schemas.v_d.oereb._1_0.extract.GetExtractByIdResponseType;
import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.CantonCode;
import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.Extract;
import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.LanguageCode;
import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.LocalisedText;
import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.Map;
import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.RealEstateDPR;
import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.RealEstateType;
import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.RestrictionOnLandownership;
import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.Theme;
import ch.so.agi.oereb.web.domains.RealEstateDPREntity;
import ch.so.agi.oereb.web.domains.ThemeEntity;
import ch.so.agi.oereb.web.repositories.RealEstateDPREntityRepository;
import ch.so.agi.oereb.web.repositories.ThemeEntityRepository;
import ch.so.agi.oereb.web.services.RestrictionOnLandownershipService;
import ch.so.agi.oereb.web.utils.WMSImage;
import ch.so.agi.oereb.web.utils.WebMapService;
import ch.so.agi.oereb.web.utils.WebMapServiceException;
import net.opengis.gml.v_3_2_1.MultiSurfacePropertyType;
import net.opengis.gml.v_3_2_1.MultiSurfaceType;
import net.opengis.gml.v_3_2_1.PointPropertyType;
import net.opengis.gml.v_3_2_1.PointType;

// TODO: Exception handling!!!

@Service 
public class ExtractServiceImpl implements ExtractService {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Environment env;

	@Autowired
	private RealEstateDPREntityRepository realEstateDPREntityRepository;
				
	@Autowired
	private RealEstateDPRService realEstateDPRService;
	
	@Autowired
	private RestrictionOnLandownershipService restrictionService;
	
	@Autowired
	private ThemeService themeService;

	@Autowired
	private WebMapService webMapService;

	@Override
	public GetExtractByIdResponseType getDummy(String egrid, boolean isReduced) throws DatatypeConfigurationException, WebMapServiceException {		
		ch.admin.geo.schemas.v_d.oereb._1_0.extract.ObjectFactory objectFactoryExtract = 
				new ch.admin.geo.schemas.v_d.oereb._1_0.extract.ObjectFactory();
		
		ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.ObjectFactory objectFactoryExtractData =
				new ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.ObjectFactory();
		
		GetExtractByIdResponseType extractByIdResponseType = objectFactoryExtract.createGetExtractByIdResponseType();

		
		/* <Extract> */
		Extract extract = objectFactoryExtractData.createExtract();
		
		/* <Extract.RealEstate_DPR> */
		RealEstateDPR realEstateDPR = realEstateDPRService.getRealEstateDPRByEgrid(egrid);		
		extract.setRealEstate(realEstateDPR);
		/* </Extract.RealEstate_DPR> */
		
		/* <Extract.CreationDate> */		
		GregorianCalendar cal = new GregorianCalendar();
		DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
		XMLGregorianCalendar creationDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
		extract.setCreationDate(creationDate);
		/* </Extract.CreationDate> */		

		/*  <Extract.(Not)ConcernedTheme> */
		List<Theme> concernedThemeList = themeService.findThemesByEgrid(egrid, true);
		concernedThemeList.forEach((theme) -> {
			extract.getConcernedTheme().add(theme);
		});
		
		List<Theme> notConcernedThemeList = themeService.findThemesByEgrid(egrid, false);
		notConcernedThemeList.forEach((theme) -> {
			extract.getNotConcernedTheme().add(theme);
		});
		/* </Extract.(Not)ConcernedTheme> */

		/* <Extract.isReduced> */
		extract.setIsReduced(isReduced);
		/* </Extract.isReduced> */

		extractByIdResponseType.setExtract(extract);
		/* </Extract> */

		return extractByIdResponseType;
	}
}
