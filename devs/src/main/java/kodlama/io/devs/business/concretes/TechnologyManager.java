package kodlama.io.devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.swagger.v3.oas.annotations.servers.Server;
import kodlama.io.devs.business.abstracts.TechnologyService;
import kodlama.io.devs.business.requests.technologyRequests.CreateTechnologyRequest;
import kodlama.io.devs.business.requests.technologyRequests.DeleteTechnologyRequest;
import kodlama.io.devs.business.requests.technologyRequests.UpdateTechnologyRequest;
import kodlama.io.devs.business.responses.languageResponse.GetByIdLanguageResponsse;
import kodlama.io.devs.business.responses.technologyResponse.GetAllTechnologyResponse;
import kodlama.io.devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.devs.dataAccess.abstracts.TechnologyRepository;
import kodlama.io.devs.entities.concretes.Language;
import kodlama.io.devs.entities.concretes.Technology;
@Service
public class TechnologyManager implements TechnologyService {
	private TechnologyRepository technologyRepository;
	private LanguageRepository languageRepository;
	List<Technology> technologies;

	@Autowired
	
	public TechnologyManager(TechnologyRepository technologyRepository,LanguageRepository languageRepository, List<Technology> technologies) {
		this.technologyRepository = technologyRepository;
		this.languageRepository=languageRepository;
		}
	@Override
	public List<GetAllTechnologyResponse> getAll() {
		List<Technology> technologies = technologyRepository.findAll();
		List<GetAllTechnologyResponse> allTechnologyResponses = new ArrayList<GetAllTechnologyResponse>();
		for (Technology technology : technologies) {
			GetAllTechnologyResponse responseItem = new GetAllTechnologyResponse();
			responseItem.setId(technology.getId());
			responseItem.setName(technology.getName());
			
			allTechnologyResponses.add(responseItem);
		}
		return allTechnologyResponses;
	}
                         

	@Override
	public void add(CreateTechnologyRequest createTechnologyRequest) {
		Technology technology = new Technology();
		technology.setName(createTechnologyRequest.getName());
		this.technologyRepository.save(technology);
		
	}

	@Override
	public void delete(int id) {
		technologyRepository.deleteById(id);
		
	}

	

	@Override
	public void add(Technology technology) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	@Override
	public GetAllTechnologyResponse byIdLanguageResponsse(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void update(UpdateTechnologyRequest updateTechnologyRequest,int id) {
		Technology technology = technologyRepository.findById(id).get();
		Language language = languageRepository.findById(updateTechnologyRequest.getId()).get();
		technology.setName(updateTechnologyRequest.getName());
		technology.setLanguage(language);
		technologyRepository.save(technology);
		
	}

}
