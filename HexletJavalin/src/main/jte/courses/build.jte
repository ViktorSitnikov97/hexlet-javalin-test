@import org.example.hexlet.dto.courses.BuildCoursePage
@param BuildCoursePage page
@template.layout.page(
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
        <form action="/courses" method="post">
            <div class="mb-3">
                <label class="form-label">
                    Name
                    <input type="text" class="form-control" required name="name"/>
                </label>
            </div>
            <div class="mb-3">
                <label class="form-label">
                    Description
                    <input type="text" class="form-control" required name="description"/>
                </label>
            </div>
            <input type="submit" class="btn btn-primary" value="Add" />
        </form>
    `
)