package gg.jte.generated.ondemand;
public final class JteindexGenerated {
	public static final String JTE_NAME = "index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,0,0,0,3,3,15,15,15,15,17,17,17,17,17,17,17,17};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor) {
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <h2 class=\"text-center p-5\" style=\"background-color: rgba(103, 252, 202, 10.05);\">\n        <p>Welcome to my mini-site</p>\n    </h2>\n    <div class=\"text-left p-5\">\n        <ul>\n            <li><a href=\"/users\" class=\"text-primary\">Search for users</a></li>\n            <li><a href=\"/courses\" class=\"text-primary\">Search for courses</a></li>\n            <li><a href=\"/users/build\" class=\"text-primary\">Add User</a></li>\n            <li><a href=\"/courses/build\" class=\"text-primary\">Add Course</a></li>\n        </ul>\n    </div>\n    ");
			}
		}, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n        <p>Just do it</p>\n    ");
			}
		});
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		render(jteOutput, jteHtmlInterceptor);
	}
}
