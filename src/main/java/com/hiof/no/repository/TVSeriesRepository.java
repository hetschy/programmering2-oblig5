package com.hiof.no.repository;

import java.util.ArrayList;

import com.hiof.no.model.TVSeries;

public interface TVSeriesRepository {

	void addListOfTVSeries(ArrayList<TVSeries> listOfTVSeries);

	void addTVSeries(TVSeries tvSeries); // Oppgave 2.2c

	ArrayList<TVSeries> getAllTVSeries();

	TVSeries getTVSeriesByTitle(String title);

}
