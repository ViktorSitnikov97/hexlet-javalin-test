package gg.jte.generated.ondemand.users;
public final class JtebuildGenerated {
	public static final String JTE_NAME = "users/build.jte";
	public static final int[] JTE_LINE_INFO = {0,0,0,0,0,2,2,30,30,30,31,31,31,31,31,31};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor) {
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n        <form action=\"/users\" method=\"post\">\n            <div>\n                <label>\n                    Имя\n                    <input type=\"text\" name=\"name\" />\n                </label>\n            </div>\n            <div>\n                <label>\n                    Email\n                    <input type=\"email\" required name=\"email\" />\n                </label>\n            </div>\n            <div>\n                <label>\n                    Пароль\n                    <input type=\"password\" required name=\"password\" />\n                </label>\n            </div>\n            <div>\n                <label>\n                    Подтверждение пароля\n                    <input type=\"password\" required name=\"passwordConfirmation\" />\n                </label>\n            </div>\n            <input type=\"submit\" value=\"Зарегистрировать\" />\n        </form>\n    ");
			}
		}, null);
		jteOutput.writeContent("\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		render(jteOutput, jteHtmlInterceptor);
	}
}
