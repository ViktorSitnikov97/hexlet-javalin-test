@import org.example.hexlet.dto.users.UserPage
@import org.example.hexlet.util.NamedRoutes
@param UserPage page

@template.layout.page(

    content = @`
        <div class="mx-auto p-4 py-md-1">
            <h3>${page.getUser().getName()}</h3>
        </div>
        <div class="mx-auto p-4 py-md-1">
            <p>Email: ${page.getUser().getEmail()}</p>
        </div>
        <table>
            <tr>
                <div class="mx-auto p-4 py-md-3">
                <th><a class="btn btn-primary btn-sm offset-md-4" href="${NamedRoutes.userEditPath(page.getUser().getId())}" role="button">Update</a></th>
                <th>
                    <form action="${NamedRoutes.userDeletePath(page.getUser().getId())}"  method="post">
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

