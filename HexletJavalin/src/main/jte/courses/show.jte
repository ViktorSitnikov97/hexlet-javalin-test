@import org.example.hexlet.dto.courses.CoursePage
@import org.example.hexlet.util.NamedRoutes
@param CoursePage page

@template.layout.page(

    content = @`
        <div class="mx-auto p-4 py-md-1">
            <h3>${page.getCourse().getName()}</h3>
        </div>
        <div class="mx-auto p-4 py-md-1">
            <p>Description: ${page.getCourse().getDescription()}</p>
        </div>
        <div class="mx-auto p-4 py-md-3">
            <a class="btn btn-primary btn-sm" href="${NamedRoutes.courseEditPath(page.getCourse().getId())}" role="button">Update</a>
        </div>
    `,

    footer = @`
        <p>Just do it</p>
    `
)