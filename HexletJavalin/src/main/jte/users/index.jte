@import org.example.hexlet.dto.users.UsersPage
@import org.example.hexlet.util.NamedRoutes
@param UsersPage page
@template.layout.page(
page = page,
content = @`
    <h1 class="text-center p-5">Пользователи</h1>
    <form class="input-group" action="/users">
        <input type="search" class="form-control rounded" placeholder="Search"
               aria-label="Search" aria-describedby="search-addon"
               required name="term" value="${page.getTerm()}" />
        <input type="submit" class="btn btn-outline-primary" value="Search">
    </form>

    <table class="table table-striped">
        @if(page.getUsers().isEmpty())
            <p class="text-center p-5">Ни один пользователь не найден</p>
        @endif
        @for(var user : page.getUsers())
            <tr>
                <td>
                    ${user.getId()}
                </td>
                <td>
                    <a href = "${NamedRoutes.userPath(user.getId())}">${user.getName()}</a>
                </td>
            </tr>
        @endfor
    </table>

    `,
    footer = @`
        <p>Just do it</p>
    `
)