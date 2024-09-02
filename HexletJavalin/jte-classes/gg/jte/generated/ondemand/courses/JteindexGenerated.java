package gg.jte.generated.ondemand.courses;
import org.example.hexlet.dto.courses.CoursesPage;
public final class JteindexGenerated {
	public static final String JTE_NAME = "courses/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,2,5,5,10,10,10,10,10,10,10,10,10,15,15,17,17,18,18,21,21,21,21,21,21,21,24,24,26,26,26,26,28,28,28,28,28,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, CoursesPage page) {
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n        <h1 class=\"text-center p-5\">Курсы</h1>\n        <form class=\"input-group\" action=\"/courses\">\n            <input type=\"search\" class=\"form-control rounded\" placeholder=\"Search\"\n                   aria-label=\"Search\" aria-describedby=\"search-addon\"\n                   required name=\"term\"");
				var __jte_html_attribute_0 = page.getTerm();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" />\n            <input type=\"submit\" class=\"btn btn-outline-primary\" value=\"Search\">\n        </form>\n\n        <table class=\"table table-striped text-center p-5 text-dark\">\n            ");
				if (page.getCourses().isEmpty()) {
					jteOutput.writeContent("\n                <p class=\"text-center p-5\">Ни один курс не найден</p>\n            ");
				}
				jteOutput.writeContent("\n            ");
				for (var course : page.getCourses()) {
					jteOutput.writeContent("\n                <tr>\n                    <td>\n                        <p><a href = \"courses/");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(course.getId());
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\">");
					jteOutput.setContext("a", null);
					jteOutput.writeUserContent(course.getName());
					jteOutput.writeContent("</a></p>\n                    </td>\n                </tr>\n            ");
				}
				jteOutput.writeContent("\n        </table>\n    ");
			}
		}, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <p>Just do it</p>\n    ");
			}
		});
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		CoursesPage page = (CoursesPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
