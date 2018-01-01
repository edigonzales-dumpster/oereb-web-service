package ch.so.agi.oereb.web.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vividsolutions.jts.geom.Polygon;

import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.LanguageCode;
import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.LocalisedText;
import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.ObjectFactory;
import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.Theme;
import ch.so.agi.oereb.web.domains.RealEstateDPREntity;
import ch.so.agi.oereb.web.domains.ThemeEntity;
import ch.so.agi.oereb.web.repositories.RealEstateDPREntityRepository;
import ch.so.agi.oereb.web.repositories.ThemeEntityRepository;

@Service
public class ThemeServiceImpl implements ThemeService {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ThemeEntityRepository themeEntityRepository;

	@Autowired
	private RealEstateDPREntityRepository realEstateDPREntityRepository;

	@Override
	public List<Theme> findThemesByEgrid(String egrid, boolean concerned) {
		ObjectFactory objectFactory = new ObjectFactory();
		
		RealEstateDPREntity realEstateDPREntity = realEstateDPREntityRepository.findOneByEgrid(egrid);
		
		List<Theme> themeList = new ArrayList<Theme>();

		List<ThemeEntity> themeEntityList = themeEntityRepository.findThemesByGeometry(realEstateDPREntity.getGeometry());
		themeEntityList.forEach((themeEntity) -> {
			
			Theme theme = objectFactory.createTheme();
			theme.setCode(themeEntity.getTheme());
			
			LocalisedText localisedText = objectFactory.createLocalisedText();
			localisedText.setLanguage(LanguageCode.fromValue("de")); // TODO
			localisedText.setText(themeEntity.getTitle());
			theme.setText(localisedText);

			if (concerned && themeEntity.isConcerned()) {
				themeList.add(theme);
			} else if (!concerned && !themeEntity.isConcerned()) {
				themeList.add(theme);
			}
		}); 
		
		return themeList;
	}

	@Override
	public List<Theme> findNotConcernedThemesByGeometry(Polygon limit) {
		ObjectFactory objectFactory = new ObjectFactory();
		
		List<Theme> notConcerndedThemeList = new ArrayList<Theme>();

		List<ThemeEntity> themeEntityList = themeEntityRepository.findThemesByGeometry(limit);
		themeEntityList.forEach((themeEntity) -> {
			if (!themeEntity.isConcerned()) {
				Theme theme = objectFactory.createTheme();
				theme.setCode(themeEntity.getTheme());
				
				LocalisedText localisedText = objectFactory.createLocalisedText();
				localisedText.setLanguage(LanguageCode.fromValue("de")); // TODO
				localisedText.setText(themeEntity.getTitle());
				theme.setText(localisedText);
				
				notConcerndedThemeList.add(theme);
			}
		}); 
		return notConcerndedThemeList;
	}

	@Override
	public Theme getThemeObjectByIliCode(String ilicode) {
		ObjectFactory objectFactory = new ObjectFactory();
		
		Theme theme = objectFactory.createTheme();			
		theme.setCode(ilicode);
		
		LocalisedText localisedText = objectFactory.createLocalisedText();
		localisedText.setLanguage(LanguageCode.fromValue("de")); // TODO
		
		ThemeEntity themeEntity = themeEntityRepository.getThemeByIliCode(ilicode);

		localisedText.setText(themeEntity.getTitle());
		theme.setText(localisedText);

		return theme;
	}
}
