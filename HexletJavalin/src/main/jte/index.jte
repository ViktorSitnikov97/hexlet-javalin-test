@import org.example.hexlet.util.NamedRoutes
@import org.example.hexlet.dto.MainPage
@param MainPage page
@template.layout.page(
    content = @`
    <h2 class="text-center p-5" style="background-color: rgba(103, 252, 202, 10.05);">
        <p>Welcome to my mini-site</p>
    </h2>
    <div class="text-left p-5">
        <ul>
            <li><a href="${NamedRoutes.usersPath()}" class="text-primary">Search for users</a></li>
            <li><a href="${NamedRoutes.coursesPath()}" class="text-primary">Search for courses</a></li>
            <li><a href="${NamedRoutes.buildUserPath()}" class="text-primary">Add User</a></li>
            <li><a href="${NamedRoutes.buildCoursePath()}" class="text-primary">Add Course</a></li>
        </ul>
    </div>
    `,
    footer = @`
        @if(!page.isVisited())
            <p>Это сообщение показывается только один раз. Если вы хотите увидеть его снова, сотрите куки</p>
        @endif
        <p>Just do it</p>

    `
)