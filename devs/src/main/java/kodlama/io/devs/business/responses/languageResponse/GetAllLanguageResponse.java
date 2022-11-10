package kodlama.io.devs.business.responses.languageResponse;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllLanguageResponse {
	private int id;
	private String name;
	private List<String> technologyNames;

}
