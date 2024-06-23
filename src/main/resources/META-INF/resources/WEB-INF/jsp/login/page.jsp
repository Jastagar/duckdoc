<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
</head>
<body>
    <form method="post" action="/login" style="display: flex; flex-direction: column; align-items: center;">
        <label>
            Name:
            <input id="name" name="name" type="text">
        </label><br>
        <label>
            Password:
            <input id="password" name="password" type="password">
        </label><br>
        <button>
            Submit
        </button>      
    </form>
</body>
</html>