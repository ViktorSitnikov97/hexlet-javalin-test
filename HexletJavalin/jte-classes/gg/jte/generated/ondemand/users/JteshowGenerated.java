package gg.jte.generated.ondemand.users;
import org.example.hexlet.dto.users.UserPage;
public final class JteshowGenerated {
	public static final String JTE_NAME = "users/show.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,3,3,8,8,9,9,9,9,9,9,11,11,12,12,12,13,13,15,15,17,17,17,17,19,19,19,21,21,21,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UserPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <h3>");
				jteOutput.setContext("h3", null);
				jteOutput.writeUserContent(page.getUser().getFirstName());
				jteOutput.writeContent(" ");
				jteOutput.setContext("h3", null);
				jteOutput.writeUserContent(page.getUser().getLastName());
				jteOutput.writeContent("</h3>\n\n    ");
				if (page.getUser().getEmail() != null) {
					jteOutput.writeContent("\n        <p>Email: ");
					jteOutput.setContext("p", null);
					jteOutput.writeUserContent(page.getUser().getEmail());
					jteOutput.writeContent("</p>\n    ");
				} else {
					jteOutput.writeContent("\n        <p>Email: not found</p>\n    ");
				}
				jteOutput.writeContent("\n\n    ");
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
