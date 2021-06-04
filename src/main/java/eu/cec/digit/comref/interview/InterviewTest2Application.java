package eu.cec.digit.comref.interview;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import eu.cec.digit.comref.interview.persistent.domain.InternetServiceProvider;
import eu.cec.digit.comref.interview.persistent.domain.Town;
import eu.cec.digit.comref.interview.persistent.repository.InternetServiceProviderRepository;
import eu.cec.digit.comref.interview.persistent.repository.TownRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class InterviewTest2Application implements CommandLineRunner {

	@Autowired
	private TownRepository townRepository;

	@Autowired
	private InternetServiceProviderRepository internetServiceProviderRepository;

	public static void main(String[] args) {
		SpringApplication.run(InterviewTest2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Starting test two");

	}

	/*
	 * TOWN
	 */

	public Town addTown(String name, Integer inhabitants, InternetServiceProvider internetServiceProvider) {

		Town town = new Town();
		town.setName(name);
		town.setInhabitants(inhabitants);
		town.setInternetServiceProvider(internetServiceProvider);

		return townRepository.save(town);

	}

	public Town updateTown(String name, Integer inhabitants, InternetServiceProvider internetServiceProvider) {

		Town town = getTown(name);
		town.setInhabitants(inhabitants);
		town.setInternetServiceProvider(internetServiceProvider);

		return townRepository.save(town);

	}

	public Town getTown(String name) {

		return townRepository.findById(name).orElse(null);

	}

	public void deleteTown(String name) {

		townRepository.deleteById(name);

	}

	public List<Town> getTowns() {

		return townRepository.findAll();

	}

	/*
	 * ISP
	 */

	public InternetServiceProvider addInternetServiceProvider(String name, Integer speed, Boolean available) {

		InternetServiceProvider internetServiceProvider = new InternetServiceProvider();
		internetServiceProvider.setAvailable(available);
		internetServiceProvider.setName(name);
		internetServiceProvider.setSpeed(speed);

		return internetServiceProviderRepository.save(internetServiceProvider);
	}

	public InternetServiceProvider getInternetServiceProvider(String name) {

		return internetServiceProviderRepository.findById(name).orElse(null);
	}

	public InternetServiceProvider updateInternetServiceProvider(String name, Integer speed, Boolean available) {

		InternetServiceProvider internetServiceProvider = getInternetServiceProvider(name);
		internetServiceProvider.setAvailable(available);
		internetServiceProvider.setName(name);
		internetServiceProvider.setSpeed(speed);

		return internetServiceProviderRepository.save(internetServiceProvider);
	}

	public void deleteInternetServiceProvider(String name) {
		internetServiceProviderRepository.deleteById(name);
	}

	public List<InternetServiceProvider> getInternetServiceProviders() {

		return internetServiceProviderRepository.findAll();
	}

	public List<InternetServiceProvider> getAvailableInternetServiceProviders() {
		
		return internetServiceProviderRepository.findAll();
	}

}
