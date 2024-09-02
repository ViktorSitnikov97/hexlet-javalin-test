package gg.jte.generated.ondemand.users;
import org.example.hexlet.dto.users.UsersPage;
public final class JteindexGenerated {
	public static final String JTE_NAME = "users/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,2,5,5,10,10,10,10,10,10,10,10,10,15,15,17,17,18,18,21,21,21,21,21,21,21,24,24,27,27,27,27,29,29,29,29,29,1,1,1,1};
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
					jteOutput.writeContent("\n            <tr>\n                <td>\n                    <p><a href = \"users/");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(user.getId());
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\">");
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
