@import org.example.hexlet.dto.users.UsersPage
@param UsersPage page
@template.layout.page(
    content = @`
    <h1>Пользователи</h1>
    <form action="/users" method="get">
        <input type="search" name="term" value="${page.getTerm()}">
        <input type="submit" value="Search">
    </form>

    <table class="table table-striped">
        @for(var user : page.getUsers())
            <tr>
                <td>
                    <p><a href = "users/${user.getId()}">${user.getFirstName()} ${user.getLastName()}</a></p>
                </td>
            </tr>
        @endfor
    </table>

    `,
    footer = @`
        <p>Just do it</p>
    `
)