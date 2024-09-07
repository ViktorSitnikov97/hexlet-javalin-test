package gg.jte.generated.ondemand.courses;
import org.example.hexlet.dto.courses.BuildCoursePage;
import org.example.hexlet.util.NamedRoutes;
public final class JtebuildGenerated {
	public static final String JTE_NAME = "courses/build.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,3,5,5,6,6,8,8,9,9,10,10,10,11,11,12,12,14,14,15,15,15,15,15,15,15,15,15,19,19,19,19,19,19,19,19,19,25,25,25,30,30,30,30,30,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, BuildCoursePage page) {
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n        ");
				if (page.getErrors() != null) {
					jteOutput.writeContent("\n            <ul class=\"text-danger\">\n            ");
					for (var validation : page.getErrors().values()) {
						jteOutput.writeContent("\n                ");
						for (var error : validation) {
							jteOutput.writeContent("\n                    <li>");
							jteOutput.setContext("li", null);
							jteOutput.writeUserContent(error.getMessage());
							jteOutput.writeContent("</li>\n                ");
						}
						jteOutput.writeContent("\n            ");
					}
					jteOutput.writeContent("\n            </ul>\n        ");
				}
				jteOutput.writeContent("\n        <form");
				var __jte_html_attribute_0 = NamedRoutes.coursesPath();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" action=\"");
					jteOutput.setContext("form", "action");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("form", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" method=\"post\" class=\"text-center p-5\">\n            <div class=\"mb-3\">\n                <label class=\"form-label\">\n                    Name\n                    <input type=\"text\" class=\"form-control\" required name=\"name\"");
				var __jte_html_attribute_1 = page.getName();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_1);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent("/>\n                </label>\n            </div>\n            <div class=\"mb-3\">\n                <label class=\"form-label\">\n                    <label class=\"form-label\">Description</label>\n                    <textarea class=\"form-control\" rows=\"20\" cols=\"70\" type=\"text\" name=\"description\">");
				jteOutput.setContext("textarea", null);
				jteOutput.writeUserContent(page.getDescription());
				jteOutput.writeContent("</textarea>\n                </label>\n            </div>\n            <input type=\"submit\" class=\"btn btn-primary\" value=\"Add\" />\n        </form>\n    ");
			}
		}, null);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		BuildCoursePage page = (BuildCoursePage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
