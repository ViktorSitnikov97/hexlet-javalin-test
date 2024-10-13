package gg.jte.generated.ondemand;
import org.example.hexlet.util.NamedRoutes;
import org.example.hexlet.dto.MainPage;
public final class JteindexGenerated {
	public static final String JTE_NAME = "index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,3,6,6,7,7,9,9,9,9,9,9,9,9,9,11,11,13,13,13,15,15,18,18,18,18,18,18,18,18,18,19,19,19,19,19,19,19,19,19,20,20,20,20,20,20,20,20,20,21,21,21,21,21,21,21,21,21,24,24,24,24,25,25,27,27,28,28,29,29,29,29,29,29,29,29,29,32,32,34,34,35,35,35,35,35,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, MainPage page) {
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, null, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    ");
				if (page.getCurrentUser() == null) {
					jteOutput.writeContent("\n        <h2 class=\"text-center p-5\" style=\"background-color: rgba(50, 130, 300, 10.05);\">\n            <p>Welcome to my mini-site, <a class=\"link-dark\"");
					var __jte_html_attribute_0 = NamedRoutes.buildSessionPath();
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
						jteOutput.writeContent(" href=\"");
						jteOutput.setContext("a", "href");
						jteOutput.writeUserContent(__jte_html_attribute_0);
						jteOutput.setContext("a", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(">Sign up!</a></p>\n        </h2>\n    ");
				} else {
					jteOutput.writeContent("\n        <h2 class=\"text-center p-5\" style=\"background-color: rgba(10, 350, 527, 30.05);\">\n            <p>Hello, ");
					jteOutput.setContext("p", null);
					jteOutput.writeUserContent(page.getCurrentUser());
					jteOutput.writeContent("!</p>\n        </h2>\n    ");
				}
				jteOutput.writeContent("\n    <div class=\"text-left p-5\">\n        <ul class=\"nav-link\">\n            <li><a");
				var __jte_html_attribute_1 = NamedRoutes.usersPath();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
					jteOutput.writeContent(" href=\"");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(__jte_html_attribute_1);
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" class=\"text-primary\">Search for users</a></li>\n            <li><a");
				var __jte_html_attribute_2 = NamedRoutes.coursesPath();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_2)) {
					jteOutput.writeContent(" href=\"");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(__jte_html_attribute_2);
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" class=\"link-info\">Search for courses</a></li>\n            <li><a");
				var __jte_html_attribute_3 = NamedRoutes.buildUserPath();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_3)) {
					jteOutput.writeContent(" href=\"");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(__jte_html_attribute_3);
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" class=\"link-success\">Add User</a></li>\n            <li><a");
				var __jte_html_attribute_4 = NamedRoutes.buildCoursePath();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_4)) {
					jteOutput.writeContent(" href=\"");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(__jte_html_attribute_4);
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" class=\"link-danger\">Add Course</a></li>\n        </ul>\n    </div>\n    ");
			}
		}, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n        ");
				if (!page.isVisited()) {
					jteOutput.writeContent("\n            <p class=\"alert alert-primary\" role=\"alert\">Это сообщение показывается только один раз. Если вы хотите увидеть его снова, сотрите куки</p>\n        ");
				}
				jteOutput.writeContent("\n        ");
				if (page.getCurrentUser() != null) {
					jteOutput.writeContent("\n            <form");
					var __jte_html_attribute_5 = NamedRoutes.logoutPath();
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_5)) {
						jteOutput.writeContent(" action=\"");
						jteOutput.setContext("form", "action");
						jteOutput.writeUserContent(__jte_html_attribute_5);
						jteOutput.setContext("form", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(" method=\"post\">\n                <input type=\"submit\" class=\"btn btn-danger\" value=\"Just click here\" />\n            </form>\n        ");
				} else {
					jteOutput.writeContent("\n        <p>Just do it</p>\n        ");
				}
				jteOutput.writeContent("\n    ");
			}
		});
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		MainPage page = (MainPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
