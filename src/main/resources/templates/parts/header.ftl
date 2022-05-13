<#include "security.ftl">
<header>
        <#include "security.ftl">
    <div class="headerlinewraper">
        <div class="headerline">
            <div class="header-center">
                <ul class="left-list">
                    <#if isUser>
                        <li><a href="/request/mycourse" style="margin: 0 0 0 -50px;" >Мои курсы</a></li>
                    </#if>
                    <#if isMentor>
                        <li><a href="/help">Помощь студентам</a></li>
                    </#if>
                    <#if isUser>
                        <li><a href="/balance">Пополнить баланс</a></li>
                    </#if>
                    <#if isAdmin>
                        <li><a href="/user" style="margin: 0px 0 0 -50px;">Управление пользователями</a></li>
                    </#if>
                </ul>
                <ul class="right-list">
                    <li></li>
                    <#if avtorisation>
                        <li><a href = "/user/area" style="margin: 0px 0 0 -20px;" >Личный кабинет</a></li>
                    </#if>
                    <#if isUser>
                        <li><a href = "/materials">Учебные материалы</a></li>
                    <#else>
                    <li></li>
                    </#if>
                </ul>
            </div>
        </div>

    </div>
    <div class="logout-login-wrapper">
        <div>
            <#if avtorisation>
                <form action="/logout" method="post">
                    <input type="hidden" name = "_csrf" value = "${_csrf.token}"/>
                    <input class="login-logout-header" type="submit" value="Выйти"/>
                </form>
            <#else>
                <form action="/templates/login" method="post">
                    <input type="hidden" name = "_csrf" value = "${_csrf.token}"/>
                    <input class="login-logout-header" type="submit" value="Войти"/>
                </form>
            </#if>
        </div>
    </div>
</header>