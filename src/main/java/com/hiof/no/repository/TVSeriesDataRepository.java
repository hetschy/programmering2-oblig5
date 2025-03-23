package com.hiof.no.repository;

import java.time.LocalDate;
import java.util.ArrayList;

import com.hiof.no.model.Episode;
import com.hiof.no.model.TVSeries;

public class TVSeriesDataRepository implements TVSeriesRepository {

	private ArrayList<TVSeries> allTvSeries = new ArrayList<>();

	public TVSeriesDataRepository() { // Oppgave 2.2a

		Episode peakyS1E1 = new Episode("Episode #1.1", 1, 1, 58, LocalDate.parse("2013-09-12"),
				"Thomas Shelby plans to fix a horse race; some guns turn up stolen.");

		Episode peakyS1E2 = new Episode("Episode #1.2", 2, 1, 58, LocalDate.parse("2013-09-19"),
				"Thomas Shelby starts a feud with a gypsy family and finally meets with Inspector Campbell to talk about the stolen guns.");

		ArrayList<Episode> peakyEpisodes = new ArrayList<Episode>();
		peakyEpisodes.add(peakyS1E1);
		peakyEpisodes.add(peakyS1E2);

		TVSeries peakyBlinders = new TVSeries("Peaky Blinders",
				"A gangster family epic set in 1900s England, centering on a gang who sew razor blades in the peaks of their caps, and their fierce boss Tommy Shelby.",
				LocalDate.parse("2013-09-12"), peakyEpisodes);

		allTvSeries.add(peakyBlinders);
	}

	@Override
	public void addListOfTVSeries(ArrayList<TVSeries> listOfTVSeries) {
		throw new UnsupportedOperationException("Unimplemented method 'addListOfTVSeries'");
	}

	@Override
	public ArrayList<TVSeries> getAllTVSeries() { // Oppgave 2.2b
		return allTvSeries;
	}

	@Override
	public TVSeries getTVSeriesByTitle(String title) {
		for (TVSeries serie : allTvSeries) {
			if (serie.getTitle().equals(title)) {
				return serie;
			}
		}
		return null;
	}

	@Override
	public void addTVSeries(TVSeries tvSeries) { // Oppgave 2.2c
		allTvSeries.add(tvSeries);
	}

}
