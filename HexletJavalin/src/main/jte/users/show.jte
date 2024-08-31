@import org.example.hexlet.dto.users.UserPage
@param UserPage page

@template.layout.page(

    content = @`
    <h3>${page.getUser().getName()}</h3>
    <p>Email: ${page.getUser().getEmail()}</p>
    `,

    footer = @`
        <p>Just do it</p>
    `
)

