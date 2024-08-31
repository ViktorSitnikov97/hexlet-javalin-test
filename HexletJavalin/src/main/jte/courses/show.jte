@import org.example.hexlet.dto.courses.CoursePage
@param CoursePage page

@template.layout.page(

    content = @`
        <h3>${page.getCourse().getName()}</h3>
        <p>Description: ${page.getCourse().getDescription()}</p>
    `,

    footer = @`
        <p>Just do it</p>
    `
)