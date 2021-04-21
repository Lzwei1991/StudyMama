package sg.com.studymama.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.javafaker.Faker;

@RestController
public class SearchController {

	private static final Logger LOG = LoggerFactory.getLogger(SearchController.class);
	private static final Faker FAKER = new Faker(new Locale("en-SG"));
	private static final List<String> CATEGORY_LIST = new ArrayList<String>(Arrays.asList("Groceries", "Restuarant",
			"Takeout", "Hotels", "Banks", "Gas Station", "Parking Lots", "Pharmacies", "Post Offices", "Medical"));

	private static final List<String> NAME_LIST = new ArrayList<String>(
			Arrays.asList("Dannel", "Aung", "Prakash", "XinYi"));
	
	@RequestMapping(method = RequestMethod.GET, value = "/search")
	public String searchCategory(@RequestParam("cat") String cat) {
		String search = "SEARCH CATEGORY: " + cat;
		LOG.info(cat);
		return search;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/fakecategorysearch")
	public String fakeCategorySearch() {
		String user = NAME_LIST.get(FAKER.number().numberBetween(0, NAME_LIST.size() - 1));
		String category = CATEGORY_LIST.get(FAKER.number().numberBetween(0, CATEGORY_LIST.size() - 1));
		String search = "FAKE SEARCH CATEGORY: " + user + " " + category;
		LOG.info(user + " " + category);
		return search;
	}
}
