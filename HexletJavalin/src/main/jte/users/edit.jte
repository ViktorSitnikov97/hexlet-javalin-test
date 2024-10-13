@import org.example.hexlet.dto.users.EditUserPage
@import org.example.hexlet.util.NamedRoutes
@param EditUserPage page
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
    <form action="${NamedRoutes.userPath(page.getId())}" method="post" class="text-center p-5">
        <div class="mb-3">
            <label class="form-label">
                Name
                <input type="text" class="form-control" required name="name" value="${page.getName()}"/>
            </label>
        </div>
        <div class="mb-3">
            <label class="form-label">
                Email
                <input type="email" class="form-control" required name="email" value="${page.getEmail()}"/>
            </label>
        </div>
        <div class="mb-3">
            <label class="form-label">
                Password
                <input type="password" class="form-control" required name="password" value="${page.getPassword()}"/>
            </label>
        </div>
        <div class="mb-3">
            <label class="form-label">
                Password Confirmation
                <input type="password" class="form-control" required name="passwordConfirmation" />
            </label>
        </div>
        <input type="submit" class="btn btn-primary" value="Send" />
    </form>
`
)