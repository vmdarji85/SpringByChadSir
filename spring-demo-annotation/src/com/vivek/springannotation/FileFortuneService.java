package com.vivek.springannotation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class FileFortuneService implements FortuneService {

	private String fileName = "/Users/vivekdarji/Documents/SpringFramework-ByChad/fortune-data.txt";
	private List<String> theFortunes;

	// create a random number generator

	Random random = new Random();

	public FileFortuneService() {
		System.out.println(">> FileFortuneService: -> inside the default construcotr");
	}
	
	
	@PostConstruct
	public void loadTheFortunesFile() {
		File file = new File(fileName);
		
		System.out.println(">>FileFortuneService.loadTheFortunesFile() -> inside the PostConstruct method");

		System.out.println("Reading from file " + file);
		System.out.println("Is file exist :" + file.exists());

		theFortunes = new ArrayList<String>();

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {

			String templine;

			while ((templine = br.readLine()) != null) {
				theFortunes.add(templine);

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public String getFortune() {
		int index = random.nextInt(theFortunes.size());

		String myFortune = theFortunes.get(index);

		return myFortune;
	}

}
