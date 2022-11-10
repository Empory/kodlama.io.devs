package kodlama.io.devs.business.abstracts;

import java.util.List;

import kodlama.io.devs.business.requests.languageRequests.CreateLanguageRequest;
import kodlama.io.devs.business.requests.languageRequests.DeleteLanguageRequest;
import kodlama.io.devs.business.requests.languageRequests.UpdateLanguageRequest;
import kodlama.io.devs.business.responses.languageResponse.GetAllLanguageResponse;
import kodlama.io.devs.business.responses.languageResponse.GetByIdLanguageResponsse;
import kodlama.io.devs.entities.concretes.Language;

public interface LanguageService {
	List<GetAllLanguageResponse> getAll();
	GetByIdLanguageResponsse getResponseById(int id);
	void add(CreateLanguageRequest createLanguageRequest );
	void delete(int id);
	void update(UpdateLanguageRequest updateLanguageRequest,int id);
	GetByIdLanguageResponsse getById(int id);
	
}
