package kodlama.io.devs.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.devs.business.abstracts.LanguageService;
import kodlama.io.devs.business.abstracts.TechnologyService;
import kodlama.io.devs.business.requests.languageRequests.CreateLanguageRequest;
import kodlama.io.devs.business.requests.languageRequests.DeleteLanguageRequest;
import kodlama.io.devs.business.requests.languageRequests.UpdateLanguageRequest;
import kodlama.io.devs.business.requests.technologyRequests.CreateTechnologyRequest;
import kodlama.io.devs.business.responses.languageResponse.GetAllLanguageResponse;
import kodlama.io.devs.business.responses.languageResponse.GetByIdLanguageResponsse;
import kodlama.io.devs.business.responses.technologyResponse.GetAllTechnologyResponse;
import kodlama.io.devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.devs.dataAccess.abstracts.TechnologyRepository;
import kodlama.io.devs.entities.concretes.Language;
import kodlama.io.devs.entities.concretes.Technology;
@Service
public class LanguageManager implements LanguageService {
	private LanguageRepository languageRepository;
	private TechnologyRepository technologyRepository;
	private TechnologyService technologyService;
	
	@Autowired
	
	public LanguageManager(LanguageRepository languageRepository, TechnologyService technologyService,TechnologyRepository technologyRepository) {
		this.languageRepository = languageRepository;
		this.technologyService= technologyService;
		this.technologyRepository = technologyRepository;
	}

	@Override
	public List<GetAllLanguageResponse> getAll() {
		List<Language> languages = languageRepository.findAll();
		List<GetAllLanguageResponse> languageResponses = new ArrayList<GetAllLanguageResponse>();
		for(Language language : languages) {
			GetAllLanguageResponse responseItem = new GetAllLanguageResponse();
			responseItem.setId(language.getId());
			responseItem.setName(language.getName());
			Set<Technology> technologies = language.getTechnologies();
			List<String> technologyNames = new ArrayList<String>();
			
			for(Technology technology : technologies) {
				technologyNames.add(technology.getName());
				
			}
			responseItem.setTechnologyNames(technologyNames);
			languageResponses.add(responseItem);
		}
		
	
		return languageResponses;
	}

	@Override
	public GetByIdLanguageResponsse getById(int id)  {
		Language language = languageRepository.findById(id).get();
		GetByIdLanguageResponsse byIdLanguageResponsse = new GetByIdLanguageResponsse();
		byIdLanguageResponsse.setName(language.getName());
		byIdLanguageResponsse.setId(language.getId());
		return byIdLanguageResponsse;
		
	}

	@Override
	public void add(CreateLanguageRequest createLanguageRequest)  {
		Language language = new Language();
		language.setName(createLanguageRequest.getName());
		this.languageRepository.save(language);
		
		
		
	}


	@Override
	public GetByIdLanguageResponsse getResponseById(int id) {
		Language language = languageRepository.findById(id).get();
		GetByIdLanguageResponsse byIdLanguageResponsse = new GetByIdLanguageResponsse();
		byIdLanguageResponsse.setName(language.getName());
		byIdLanguageResponsse.setId(language.getId());
		
		return byIdLanguageResponsse;
	}

	@Override
	public void delete(int id) {
		languageRepository.deleteById(id);
		
	}

	@Override
	public void update(UpdateLanguageRequest updateLanguageRequest, int id) {
		Language language = languageRepository.findById(id).get();
		language.setName(updateLanguageRequest.getName());
		
		languageRepository.save(language);
	}

	

}
