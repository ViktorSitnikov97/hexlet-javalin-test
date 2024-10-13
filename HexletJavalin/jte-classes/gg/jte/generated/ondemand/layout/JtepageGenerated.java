package gg.jte.generated.ondemand.layout;
import gg.jte.Content;
import org.example.hexlet.util.NamedRoutes;
import org.example.hexlet.dto.BasePage;
public final class JtepageGenerated {
	public static final String JTE_NAME = "layout/page.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,3,3,26,26,26,26,26,26,26,26,26,26,29,29,29,29,29,29,29,29,29,35,35,36,36,38,38,38,40,40,42,42,42,44,44,45,45,46,46,46,49,49,52,52,52,55,55,59,59,59,3,4,5,5,5,5};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, BasePage page, Content content, Content footer) {
		jteOutput.writeContent("\n<!doctype html>\n<html lang=\"en\">\n    <head>\n        <meta charset=\"utf-8\" />\n        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\n        <title>Javalin Example</title>\n        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\"\n              rel=\"stylesheet\"\n              integrity=\"sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We\"\n              crossorigin=\"anonymous\">\n    </head>\n    <body>\n        <nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\n            <div class=\"collapse navbar-collapse\" id=\"navbarNavDropdown\">\n                <ul class=\"navbar-nav\">\n                    <li class=\"nav-item active\">\n                        <a class=\"nav-link\" href=\"/\">Home</a>\n                    </li>\n                    <li class=\"nav-item\">\n                        <a class=\"nav-link\"");
		var __jte_html_attribute_0 = NamedRoutes.usersPath();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(__jte_html_attribute_0);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">Users</a>\n                    </li>\n                    <li class=\"nav-item\">\n                        <a class=\"nav-link\"");
		var __jte_html_attribute_1 = NamedRoutes.coursesPath();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(__jte_html_attribute_1);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">Courses</a>\n                    </li>\n                </ul>\n            </div>\n        </nav>\n        <div class=\"mx-auto p-4 py-md-2\">\n            ");
		if (page != null && page.getFlash() != null) {
			jteOutput.writeContent("\n                ");
			if (page.getFlag()) {
				jteOutput.writeContent("\n                    <div class=\"alert alert-success\" role=\"alert\">\n                        ");
				jteOutput.setContext("div", null);
				jteOutput.writeUserContent(page.getFlash());
				jteOutput.writeContent("\n                    </div>\n                ");
			} else {
				jteOutput.writeContent("\n                    <div class=\"alert alert-danger\" role=\"alert\">\n                        ");
				jteOutput.setContext("div", null);
				jteOutput.writeUserContent(page.getFlash());
				jteOutput.writeContent("\n                    </div>\n                ");
			}
			jteOutput.writeContent("\n            ");
		}
		jteOutput.writeContent("\n            ");
		jteOutput.setContext("div", null);
		jteOutput.writeUserContent(content);
		jteOutput.writeContent("\n        </div>\n\n        ");
		if (footer != null) {
			jteOutput.writeContent("\n            <footer class=\"text-center text-lg-start bg-light text-muted\">\n                <div class=\"text-center p-4\" style=\"background-color: rgba(10, 0, 0, 0.01);\">\n                    ");
			jteOutput.setContext("div", null);
			jteOutput.writeUserContent(footer);
			jteOutput.writeContent("\n                </div>\n            </footer>\n        ");
		}
		jteOutput.writeContent("\n\n    </body>\n</html>\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		BasePage page = (BasePage)params.getOrDefault("page", null);
		Content content = (Content)params.get("content");
		Content footer = (Content)params.getOrDefault("footer", null);
		render(jteOutput, jteHtmlInterceptor, page, content, footer);
	}
}
