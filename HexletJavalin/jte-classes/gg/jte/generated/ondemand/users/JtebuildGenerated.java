package gg.jte.generated.ondemand.users;
public final class JtebuildGenerated {
	public static final String JTE_NAME = "users/build.jte";
	public static final int[] JTE_LINE_INFO = {0,0,0,0,0,2,2,30,30,30,30,30,30,30,30};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor) {
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n        <form action=\"/users\" method=\"post\">\n            <div class=\"mb-3\">\n                <label class=\"form-label\">\n                    Name\n                    <input type=\"text\" class=\"form-control\" required name=\"name\" />\n                </label>\n            </div>\n            <div class=\"mb-3\">\n                <label class=\"form-label\">\n                    Email\n                    <input type=\"email\" class=\"form-control\" required name=\"email\" />\n                </label>\n            </div>\n            <div class=\"mb-3\">\n                <label class=\"form-label\">\n                    Password\n                    <input type=\"password\" class=\"form-control\" required name=\"password\" />\n                </label>\n            </div>\n            <div class=\"mb-3\">\n                <label class=\"form-label\">\n                    Password Confirmation\n                    <input type=\"password\" class=\"form-control\" required name=\"passwordConfirmation\" />\n                </label>\n            </div>\n            <input type=\"submit\" class=\"btn btn-primary\" value=\"Sign Up\" />\n        </form>\n    ");
			}
		}, null);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		render(jteOutput, jteHtmlInterceptor);
	}
}
