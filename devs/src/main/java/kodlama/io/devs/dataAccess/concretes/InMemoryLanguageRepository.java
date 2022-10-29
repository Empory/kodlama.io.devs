package kodlama.io.devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.devs.entities.concretes.Language;
@Repository
public class InMemoryLanguageRepository implements LanguageRepository{

	List<Language> languages;
	
	
	public InMemoryLanguageRepository() {
		languages = new ArrayList<Language>();
		languages.add(new Language(1,"C++"));
		languages.add(new Language(2,"C#"));
		languages.add(new Language(3,"Python"));
		languages.add(new Language(4,"C"));
		languages.add(new Language(5,"Java"));
		languages.add(new Language(6,"JavaScript"));
		
	}

	@Override
	public List<Language> getAll() {
		// TODO Auto-generated method stub
		return languages;
	}

	@Override
	public Language getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Language language) {
		// TODO Auto-generated method stub
		
		}
		
	

	public void delete(Language languages) {
		// TODO Auto-generated method stub
		
	}

	public void update(Language language) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Language language, int id) {
		// TODO Auto-generated method stub
		
	}

}
