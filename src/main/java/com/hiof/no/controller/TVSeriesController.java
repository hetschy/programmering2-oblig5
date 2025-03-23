package com.hiof.no.controller;

import java.time.LocalDate;

import com.hiof.no.model.TVSeries;
import com.hiof.no.repository.TVSeriesRepository;

import io.javalin.http.Context;

public class TVSeriesController { // Oppgave 2.7a

	private TVSeriesRepository tvSeriesRepository;

	public TVSeriesController(TVSeriesRepository tvSeriesRepository) {
		this.tvSeriesRepository = tvSeriesRepository;
	}

	public void getAllTVSeries(Context ctx) {
		ctx.json(tvSeriesRepository.getAllTVSeries());
	}

	public void getTVSeriesByName(Context ctx) {
		String title = ctx.pathParam("tvseries-name");

		TVSeries fetchedTVSerie = tvSeriesRepository.getTVSeriesByTitle(title);

		if (fetchedTVSerie != null) {
			ctx.json(fetchedTVSerie);
		} else {
			ctx.result("Could not find TV-serie: " + title);
		}
	}

	public void addTVSeries(Context ctx) {
		String title = ctx.formParam("title");
		String desc = ctx.formParam("description");
		int day = Integer.parseInt(ctx.formParam("release-date-day"));
		int month = Integer.parseInt(ctx.formParam("release-date-month"));
		int year = Integer.parseInt(ctx.formParam("release-date-year"));
		LocalDate releaseDate = LocalDate.of(year, month, day);

		TVSeries addedTVSeries = new TVSeries(title, desc, releaseDate);
		tvSeriesRepository.addTVSeries(addedTVSeries);

		ctx.redirect("/tvseries/" + title);
	}

}
