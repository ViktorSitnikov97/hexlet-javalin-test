@import org.example.hexlet.dto.courses.BuildCoursePage
@import org.example.hexlet.util.NamedRoutes
@param BuildCoursePage page
@template.layout.page(
    page = page,
    content = @`
        @if(page.getErrors() != null)
            <ul class="text-danger">
            @for(var validation : page.getErrors().values())
                @for(var error : validation)
                    <li>${error.getMessage()}</li>
                @endfor
            @endfor
            </ul>
        @endif
        <form action="${NamedRoutes.coursesPath()}" method="post" class="text-center p-5">
            <div class="mb-3">
                <label class="form-label">
                    Title
                    <input type="text" class="form-control" required name="title" value="${page.getName()}"/>
                </label>
            </div>
            <div class="mb-3">
                <label class="form-label">
                    <label class="form-label">Description</label>
                    <textarea class="form-control" rows="20" cols="70" type="text" name="description">${page.getDescription()}</textarea>
                </label>
            </div>
            <input type="submit" class="btn btn-primary" value="Add" />
        </form>
    `
)