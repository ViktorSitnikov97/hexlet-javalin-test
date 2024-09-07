package gg.jte.generated.ondemand.users;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.util.NamedRoutes;
public final class JteindexGenerated {
	public static final String JTE_NAME = "users/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,3,6,6,11,11,11,11,11,11,11,11,11,16,16,18,18,19,19,22,22,22,22,22,22,22,22,22,22,22,22,25,25,28,28,28,28,30,30,30,30,30,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UsersPage page) {
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <h1 class=\"text-center p-5\">Пользователи</h1>\n    <form class=\"input-group\" action=\"/users\">\n        <input type=\"search\" class=\"form-control rounded\" placeholder=\"Search\"\n               aria-label=\"Search\" aria-describedby=\"search-addon\"\n               required name=\"term\"");
				var __jte_html_attribute_0 = page.getTerm();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" />\n        <input type=\"submit\" class=\"btn btn-outline-primary\" value=\"Search\">\n    </form>\n\n    <table class=\"table table-striped text-center p-5 text-dark\">\n        ");
				if (page.getUsers().isEmpty()) {
					jteOutput.writeContent("\n            <p class=\"text-center p-5\">Ни один пользователь не найден</p>\n        ");
				}
				jteOutput.writeContent("\n        ");
				for (var user : page.getUsers()) {
					jteOutput.writeContent("\n            <tr>\n                <td>\n                    <p><a");
					var __jte_html_attribute_1 = NamedRoutes.userPath(user.getId());
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
						jteOutput.writeContent(" href=\"");
						jteOutput.setContext("a", "href");
						jteOutput.writeUserContent(__jte_html_attribute_1);
						jteOutput.setContext("a", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(">");
					jteOutput.setContext("a", null);
					jteOutput.writeUserContent(user.getName());
					jteOutput.writeContent("</a></p>\n                </td>\n            </tr>\n        ");
				}
				jteOutput.writeContent("\n    </table>\n\n    ");
			}
		}, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n        <p>Just do it</p>\n    ");
			}
		});
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UsersPage page = (UsersPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
