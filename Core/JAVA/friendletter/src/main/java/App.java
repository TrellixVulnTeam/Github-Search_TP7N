import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.staticFileLocation;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/", (request, response) ->{ //request for route happens at this location
            Map<String, Object> model = new HashMap<>(); // new model is made to store information
            return new ModelAndView(model, "hello.hbs"); // assemble individual pieces and render
                }, new HandlebarsTemplateEngine());

        get("/favorite_photos",(request, response) ->{
            Map<String, Object> model = new HashMap<>();
            return  new ModelAndView(model, "favorite_photos.hbs");
                }, new HandlebarsTemplateEngine());

        get("/form",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "form.hbs");
              }, new HandlebarsTemplateEngine());

        get("/greeting_card", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String recipient = request.queryParams("recipient");
            String sender = request.queryParams("sender");
            model.put("recipient", recipient);
            model.put("sender", sender);
            return new ModelAndView(model, "greeting_card.hbs");
            }, new HandlebarsTemplateEngine());
    }
}
