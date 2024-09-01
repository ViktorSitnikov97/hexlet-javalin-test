package gg.jte.generated.ondemand.courses;
public final class JtebuildGenerated {
	public static final String JTE_NAME = "courses/build.jte";
	public static final int[] JTE_LINE_INFO = {0,0,0,0,0,2,2,18,18,18,18,18,18,18,18};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor) {
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n        <form action=\"/courses\" method=\"post\">\n            <div class=\"mb-3\">\n                <label class=\"form-label\">\n                    Name\n                    <input type=\"text\" class=\"form-control\" required name=\"name\" />\n                </label>\n            </div>\n            <div class=\"mb-3\">\n                <label class=\"form-label\">\n                    Description\n                    <input type=\"text\" class=\"form-control\" required name=\"description\" />\n                </label>\n            </div>\n            <input type=\"submit\" class=\"btn btn-primary\" value=\"Add\" />\n        </form>\n    ");
			}
		}, null);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		render(jteOutput, jteHtmlInterceptor);
	}
}
