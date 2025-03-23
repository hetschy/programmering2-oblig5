package com.hiof.no;

import com.hiof.no.controller.TVSeriesController;
import com.hiof.no.repository.TVSeriesDataRepository;
import com.hiof.no.repository.TVSeriesRepository;

import org.jetbrains.annotations.NotNull;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.vue.VueComponent;

public class Application {

	public static void main(String[] args) {

		Javalin app = Javalin.create(javalinConfig -> { // Oppgave 2.1
			javalinConfig.staticFiles.enableWebjars();
			javalinConfig.vue.vueInstanceNameInJs = "app";
		}).start();

		TVSeriesRepository tvSeriesRepository = new TVSeriesDataRepository();
		TVSeriesController tvSeriesController = new TVSeriesController(tvSeriesRepository); // Oppgave 2.7b

		app.get("/", new VueComponent("home-page")); // Oppgave 2.3

		app.get("/api/tvseries", new Handler() { // Oppgave 2.4a
			@Override
			public void handle(@NotNull Context ctx) throws Exception {
				tvSeriesController.getAllTVSeries(ctx);
			}
		});

		app.post("/api/add-tvseries", new Handler() { // Oppgave 2.6b
			@Override
			public void handle(@NotNull Context ctx) throws Exception {
				tvSeriesController.addTVSeries(ctx);
			}
		});

		app.get("/api/tvseries/{tvseries-name}", new Handler() { // Oppgave 2.5a
			@Override
			public void handle(@NotNull Context ctx) throws Exception {
				tvSeriesController.getTVSeriesByName(ctx);
			}
		});

		app.get("/tvseries", new VueComponent("tvseries-overview")); // Oppgave 2.4b

		app.get("/tvseries/{tvseries-name}", new VueComponent("tvseries-detail")); // Oppgave 2.5b

		app.get("/add-tvseries", new VueComponent("add-tvseries")); // Oppgave 2.6a

	}
}
