package kodlama.io.devs.business.abstracts;

import java.util.List;

import kodlama.io.devs.business.requests.technologyRequests.CreateTechnologyRequest;
import kodlama.io.devs.business.requests.technologyRequests.DeleteTechnologyRequest;
import kodlama.io.devs.business.requests.technologyRequests.UpdateTechnologyRequest;
import kodlama.io.devs.business.responses.languageResponse.GetByIdLanguageResponsse;
import kodlama.io.devs.business.responses.technologyResponse.GetAllTechnologyResponse;
import kodlama.io.devs.entities.concretes.Technology;

public interface TechnologyService {
	List<GetAllTechnologyResponse> getAll();
	GetAllTechnologyResponse byIdLanguageResponsse(int id);
	void add(CreateTechnologyRequest createTechnologyRequest);
    void add(Technology technology);
	void delete(int id);
	void update( UpdateTechnologyRequest updateTechnologyRequest,int id);
	
	
}
