package kodlama.io.devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kodlama.io.devs.business.abstracts.TechnologyService;
import kodlama.io.devs.business.requests.technologyRequests.CreateTechnologyRequest;
import kodlama.io.devs.business.requests.technologyRequests.DeleteTechnologyRequest;
import kodlama.io.devs.business.requests.technologyRequests.UpdateTechnologyRequest;
import kodlama.io.devs.business.responses.languageResponse.GetByIdLanguageResponsse;
import kodlama.io.devs.business.responses.technologyResponse.GetAllTechnologyResponse;

@RestController //annotation
@RequestMapping("/api/technologies")
public class TechnologiesController {
	private TechnologyService technologyService;
	
	@Autowired
	public TechnologiesController(TechnologyService technologyService) {
		this.technologyService = technologyService;
	}
	@GetMapping("/getall")
	public List<GetAllTechnologyResponse> getAll(){
		return technologyService.getAll();
	}
	
	@GetMapping("get/byid")
	public GetAllTechnologyResponse byIdLanguageResponsse(@PathVariable int id) {
		return technologyService.byIdLanguageResponsse(id);
		
	}
	
	@PostMapping("/add-technology")
	public void add(@RequestBody CreateTechnologyRequest createTechnologyRequest) {
		this.technologyService.add(createTechnologyRequest);
	}
	
	@DeleteMapping("/delete-technology")
	public void delete(@RequestBody int id,DeleteTechnologyRequest deleteTechnologyRequest) {
		this.technologyService.delete(id);
	}
	
	@PutMapping("update-technology")
	public void update(@RequestBody int id,UpdateTechnologyRequest updateTechnologyRequest) {
		this.technologyService.update(updateTechnologyRequest,id);
	}
}
