package gg.jte.generated.ondemand.courses;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.util.NamedRoutes;
public final class JteshowGenerated {
	public static final String JTE_NAME = "courses/show.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,4,4,9,9,11,11,11,14,14,14,17,17,17,17,17,17,17,17,17,19,19,19,19,21,21,21,21,21,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, CoursePage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n        <div class=\"mx-auto p-4 py-md-1\">\n            <h3>");
				jteOutput.setContext("h3", null);
				jteOutput.writeUserContent(page.getCourse().getName());
				jteOutput.writeContent("</h3>\n        </div>\n        <div class=\"mx-auto p-4 py-md-1\">\n            <p>Description: ");
				jteOutput.setContext("p", null);
				jteOutput.writeUserContent(page.getCourse().getDescription());
				jteOutput.writeContent("</p>\n        </div>\n        <div class=\"mx-auto p-4 py-md-3\">\n            <a class=\"btn btn-primary btn-sm\"");
				var __jte_html_attribute_0 = NamedRoutes.courseEditPath(page.getCourse().getId());
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" href=\"");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" role=\"button\">Update</a>\n        </div>\n    ");
			}
		}, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n        <p>Just do it</p>\n    ");
			}
		});
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		CoursePage page = (CoursePage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
