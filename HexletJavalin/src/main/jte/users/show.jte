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
        <div class="mx-auto p-4 py-md-3">
            <a class="btn btn-primary btn-sm" href="${NamedRoutes.userEditPath(page.getUser().getId())}" role="button">Update</a>
        </div>
        `,

    footer = @`
        <p>Just do it</p>
    `
)

