@import org.example.hexlet.dto.courses.CoursePage
@import org.example.hexlet.util.NamedRoutes
@param CoursePage page

@template.layout.page(

    content = @`
        <div class="mx-auto p-4 py-md-1">
            <h3>${page.getCourse().getTitle()}</h3>
        </div>
        <div class="mx-auto p-4 py-md-1">
            <p>Description: ${page.getCourse().getDescription()}</p>
        </div>
        <table>
            <tr>
                <div class="mx-auto p-4 py-md-3">
                    <th>
                        <a class="btn btn-primary btn-sm offset-md-4" href="${NamedRoutes.courseEditPath(page.getCourse().getId())}" role="button">Update</a>
                    </th>
                    <th>
                        <form action="${NamedRoutes.courseDeletePath(page.getCourse().getId())}"  method="post">
                            <input type="submit" class="btn btn-danger btn-sm offset-md-4" value="Delete" />
                        </form>
                    </th>
                </div>
            </tr>
        </table>
    `,

    footer = @`
        <p>Just do it</p>
    `
)