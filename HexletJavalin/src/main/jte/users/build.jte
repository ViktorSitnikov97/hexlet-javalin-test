@import org.example.hexlet.dto.users.BuildUserPage
@import org.example.hexlet.util.NamedRoutes
@param BuildUserPage page
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
        <form action="${NamedRoutes.usersPath()}" method="post" class="text-center p-5">
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
                    <input type="password" class="form-control" required name="password" />
                </label>
            </div>
            <div class="mb-3">
                <label class="form-label">
                    Password Confirmation
                    <input type="password" class="form-control" required name="passwordConfirmation" />
                </label>
            </div>
            <input type="submit" class="btn btn-primary" value="Sign Up" />
        </form>
    `
)