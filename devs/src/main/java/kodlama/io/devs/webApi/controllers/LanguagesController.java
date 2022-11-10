package kodlama.io.devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.devs.business.abstracts.LanguageService;
import kodlama.io.devs.business.abstracts.TechnologyService;
import kodlama.io.devs.business.requests.languageRequests.CreateLanguageRequest;
import kodlama.io.devs.business.requests.languageRequests.DeleteLanguageRequest;
import kodlama.io.devs.business.requests.languageRequests.UpdateLanguageRequest;
import kodlama.io.devs.business.responses.languageResponse.GetAllLanguageResponse;
import kodlama.io.devs.business.responses.languageResponse.GetByIdLanguageResponsse;
import kodlama.io.devs.entities.concretes.Language;

@RestController //annotation
@RequestMapping("/api/languages")
public class LanguagesController {
	private LanguageService languageService;
	
	@Autowired
	public LanguagesController(LanguageService languageService ) {
		this.languageService = languageService;
		
	}
	@GetMapping("/getall")
	public List<GetAllLanguageResponse> getAll(){
		return languageService.getAll();
	}
	@GetMapping("/getbyid")
	public GetByIdLanguageResponsse getById(@PathVariable int id) throws Exception {
		return languageService.getById(id);
	}
	@PostMapping("/add-language")
	public void add(@RequestBody CreateLanguageRequest createLanguageRequest)  {
		this.languageService.add(createLanguageRequest);
		
	}
	
	@PutMapping("/update-language")
	public void update(@RequestBody int id, UpdateLanguageRequest updateLanguageRequest) throws Exception {
		languageService.update(updateLanguageRequest,id);
	}
	@DeleteMapping("/delete-language")
	public void delete(@RequestBody int id ,DeleteLanguageRequest deleteLanguageRequest ) throws Exception{
		languageService.delete(id);
	}
	

}
