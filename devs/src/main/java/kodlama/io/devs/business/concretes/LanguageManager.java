package kodlama.io.devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.devs.business.abstracts.LanguageService;
import kodlama.io.devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.devs.entities.concretes.Language;
@Service
public class LanguageManager implements LanguageService {
	private LanguageRepository languageRepository;
	List<Language> languages;
	@Autowired
	
	public LanguageManager(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	@Override
	public List<Language> getAll() {
		return languageRepository.getAll();
	}

	@Override
	public Language getById(int id)  {
		
		return null;
	}

	@Override
	public void add(Language language) throws Exception {
		for(Language lang:languages) {
			if(isNameExist(lang.getName())) {
				throw new Exception ("its already exist");
			}
		}
		if(language.getName()==null) {
			throw new Exception ("language name cannot be empty");
		}
		
	}

	private boolean isNameExist(String name) {
		for(Language lang: getAll()) {
			return true;
		}
		return false;
		
	}

	@Override
	public void delete(Language language) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Language language) {
		// TODO Auto-generated method stub
		
	}

}
