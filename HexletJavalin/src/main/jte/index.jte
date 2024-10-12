@import org.example.hexlet.util.NamedRoutes
@import org.example.hexlet.dto.MainPage
@param MainPage page
@template.layout.page(
    content = @`
    @if(page.getCurrentUser() == null)
        <h2 class="text-center p-5" style="background-color: rgba(50, 130, 300, 10.05);">
            <p>Welcome to my mini-site, <a class="link-dark" href="${NamedRoutes.buildSessionsPath()}">Sign up!</a></p>
        </h2>
    @else
        <h2 class="text-center p-5" style="background-color: rgba(10, 350, 527, 30.05);">
            <p>Hello, ${page.getCurrentUser()}!</p>
        </h2>
    @endif
    <div class="text-left p-5">
        <ul class="nav-link">
            <li><a href="${NamedRoutes.usersPath()}" class="text-primary">Search for users</a></li>
            <li><a href="${NamedRoutes.coursesPath()}" class="link-info">Search for courses</a></li>
            <li><a href="${NamedRoutes.buildUserPath()}" class="link-success">Add User</a></li>
            <li><a href="${NamedRoutes.buildCoursePath()}" class="link-danger">Add Course</a></li>
        </ul>
    </div>
    `,
    footer = @`
        @if(!page.isVisited())
            <p>Это сообщение показывается только один раз. Если вы хотите увидеть его снова, сотрите куки</p>
        @endif
        @if(page.getCurrentUser() != null)
            <p><a href="${NamedRoutes.deleteSessionsPath()}" class="link-danger">Just click here</a></p>
        @else
        <p>Just do it</p>
        @endif
    `
)