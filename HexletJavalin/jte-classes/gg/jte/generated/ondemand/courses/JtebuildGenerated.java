package gg.jte.generated.ondemand.courses;
import org.example.hexlet.dto.courses.BuildCoursePage;
public final class JtebuildGenerated {
	public static final String JTE_NAME = "courses/build.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,2,4,4,5,5,7,7,8,8,9,9,9,10,10,11,11,13,13,29,29,29,29,29,1,1,1,1};
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
				jteOutput.writeContent("\n        <form action=\"/courses\" method=\"post\">\n            <div class=\"mb-3\">\n                <label class=\"form-label\">\n                    Name\n                    <input type=\"text\" class=\"form-control\" required name=\"name\"/>\n                </label>\n            </div>\n            <div class=\"mb-3\">\n                <label class=\"form-label\">\n                    Description\n                    <input type=\"text\" class=\"form-control\" required name=\"description\"/>\n                </label>\n            </div>\n            <input type=\"submit\" class=\"btn btn-primary\" value=\"Add\" />\n        </form>\n    ");
			}
		}, null);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		BuildCoursePage page = (BuildCoursePage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
