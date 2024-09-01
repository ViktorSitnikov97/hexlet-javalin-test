@template.layout.page(
    content = @`
        <form action="/courses" method="post">
            <div class="mb-3">
                <label class="form-label">
                    Name
                    <input type="text" class="form-control" required name="name" />
                </label>
            </div>
            <div class="mb-3">
                <label class="form-label">
                    Description
                    <input type="text" class="form-control" required name="description" />
                </label>
            </div>
            <input type="submit" class="btn btn-primary" value="Add" />
        </form>
    `
)