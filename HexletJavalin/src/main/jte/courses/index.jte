@import org.example.hexlet.dto.courses.CoursesPage
@import org.example.hexlet.util.NamedRoutes
@param CoursesPage page
@template.layout.page(
    page = page,
    content = @`
        <h1 class="text-center p-5">Курсы</h1>
        <form class="input-group" action="${NamedRoutes.coursesPath()}">
            <input type="search" class="form-control rounded" placeholder="Search"
                   aria-label="Search" aria-describedby="search-addon"
                   required name="term" value="${page.getTerm()}" />
            <input type="submit" class="btn btn-outline-primary" value="Search">
        </form>

        <table class="table table-striped">
            @if(page.getCourses().isEmpty())
                <p class="text-center p-5">Ни один курс не найден</p>
            @endif
            @for(var course : page.getCourses())
                <tr>
                    <td>
                        ${course.getId()}
                    </td>
                    <td >
                        <a href = "${NamedRoutes.coursePath(course.getId())}">${course.getTitle()}</a>
                    </td>
                </tr>
            @endfor
        </table>
    `,
    footer = @`
    <p>Just do it</p>
    `
)