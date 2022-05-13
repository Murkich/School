<#macro login path>
    <div>
        <div class="hedgehog-logo-wrapper"><h1>MUR'S Школа иностранных языков</h1></div>
        <form class="login-field-wrapper" action="${path}" method="post">
            <span>Авторизация</span>
            <div class="login-password-text"><input class="login-password-input" type="text" name="username" placeholder="Логин"/></div>
            <div class="login-password-text"><input class="login-password-input" type="password" name="password" placeholder="Пароль"/></div>
            <input type="hidden" name = "_csrf" value = "${_csrf.token}"/>
            <p></p>
            <div class=""><input class="btn btn-info" type="submit" value="Войти"/></div>
            <p></p>
            <a class="btn btn-info" href = "/reg">Зарегистрироваться</a>
        </form>
    </div>
</#macro>

<#macro logout>
            <form action="/logout" method="post">
                <input type="hidden" name = "_csrf" value = "${_csrf.token}"/>
                <input class="login-logout-header" type="submit" value="Выйти"/>
            </form>
</#macro>

