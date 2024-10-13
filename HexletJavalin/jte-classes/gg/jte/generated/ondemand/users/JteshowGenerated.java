package gg.jte.generated.ondemand.users;
import org.example.hexlet.dto.users.UserPage;
import org.example.hexlet.util.NamedRoutes;
public final class JteshowGenerated {
	public static final String JTE_NAME = "users/show.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,4,4,9,9,11,11,11,14,14,14,19,19,19,19,19,19,19,19,19,21,21,21,21,21,21,21,21,21,28,28,28,28,30,30,30,32,32,32,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UserPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, null, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n        <div class=\"mx-auto p-4 py-md-1\">\n            <h3>");
				jteOutput.setContext("h3", null);
				jteOutput.writeUserContent(page.getUser().getName());
				jteOutput.writeContent("</h3>\n        </div>\n        <div class=\"mx-auto p-4 py-md-1\">\n            <p>Email: ");
				jteOutput.setContext("p", null);
				jteOutput.writeUserContent(page.getUser().getEmail());
				jteOutput.writeContent("</p>\n        </div>\n        <table>\n            <tr>\n                <div class=\"mx-auto p-4 py-md-3\">\n                <th><a class=\"btn btn-primary btn-sm offset-md-4\"");
				var __jte_html_attribute_0 = NamedRoutes.userEditPath(page.getUser().getId());
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" href=\"");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" role=\"button\">Update</a></th>\n                <th>\n                    <form");
				var __jte_html_attribute_1 = NamedRoutes.userDeletePath(page.getUser().getId());
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
					jteOutput.writeContent(" action=\"");
					jteOutput.setContext("form", "action");
					jteOutput.writeUserContent(__jte_html_attribute_1);
					jteOutput.setContext("form", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent("  method=\"post\">\n                        <input type=\"submit\" class=\"btn btn-danger btn-sm offset-md-4\" value=\"Delete\" />\n                    </form>\n                </th>\n                </div>\n            </tr>\n        </table>\n        ");
			}
		}, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n        <p>Just do it</p>\n    ");
			}
		});
		jteOutput.writeContent("\n\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UserPage page = (UserPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
