package gg.jte.generated.ondemand.layout;
import gg.jte.Content;
import org.example.hexlet.util.NamedRoutes;
public final class JtepageGenerated {
	public static final String JTE_NAME = "layout/page.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,24,24,24,24,24,24,24,24,24,24,27,27,27,27,27,27,27,27,27,34,34,34,37,37,40,40,40,43,43,47,47,47,2,3,3,3,3};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Content content, Content footer) {
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
		jteOutput.writeContent(">Courses</a>\n                    </li>\n                </ul>\n            </div>\n        </nav>\n\n        <div class=\"mx-auto p-4 py-md-2\">\n            ");
		jteOutput.setContext("div", null);
		jteOutput.writeUserContent(content);
		jteOutput.writeContent("\n        </div>\n\n        ");
		if (footer != null) {
			jteOutput.writeContent("\n            <footer class=\"text-center text-lg-start bg-light text-muted\">\n                <div class=\"text-center p-4\" style=\"background-color: rgba(0, 0, 0, 0.05);\">\n                    ");
			jteOutput.setContext("div", null);
			jteOutput.writeUserContent(footer);
			jteOutput.writeContent("\n                </div>\n            </footer>\n        ");
		}
		jteOutput.writeContent("\n\n    </body>\n</html>\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Content content = (Content)params.get("content");
		Content footer = (Content)params.getOrDefault("footer", null);
		render(jteOutput, jteHtmlInterceptor, content, footer);
	}
}
