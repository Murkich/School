<#import "../parts/common.ftl" as c>
<#import "../parts/login.ftl" as l>
<#include "../parts/security.ftl">
<@c.page>
<div class = "container mt-5" style="margin: 15px 0 0 200px;">
    <div><h1>MUR'S Школа иностранных языков</h1></div>
    <form action="/user/find" method="get" class="find-wrapper" >
        <input type="text" name="find" placeholder="Фамилия" style="width: 250px" class="find-input-ares">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <input type="submit" value="Найти" class="filter-button">
     <table class="table-borderless">
         <form action="/user/edit" method="post">
         <thead>
         <tr>
             <button type = "submit" name="button" value ="block" class="btn btn-info">Заблокировать</button>
         </tr>
         <tr>
             <button type = "submit" name="button" value ="unblock" class="btn btn-info">Разблокировать</button>
         </tr>
         <tr>
             <button type = "submit" name="button" value ="up" class="btn btn-info">Админ up</button>
         </tr>
         <tr>
             <button type = "submit" name="button" value ="down" class="btn btn-info">Юзер down</button>
         </tr>
         </thead>
         </form>
     </table>
    <div class="prokrutka" id="changeTable">
    <table class="table_blur" style="margin-top: 0px;">
        <thead>
        <tr>
            <th>id</th>
            <th>login</th>
            <th>Фамилия</th>
            <th>Имя</th>
            <th>Номер телефона</th>
            <th>Email</th>
            <th>Роль</th>
            <th>Актив</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <#list users as user>
        <tr>
            <td>${user.iduser}</td>
            <td>${user.username}</td>
            <#if isUser>
                <#list students as student>
                    <td>${student.surname}</td>
                    <td>${student.name}</td>
                    <td>${student.number}</td>
                    <td>${student.email}</td>
                    <td><#list user.roles as role>${role}<#sep>, </#list></td>
                    <td><#list user.status as status>${status}<#sep>, </#list></td>
                </#list>
            </#if>
            <#if isMentor>
                <#list mentors as mentor>
                    <td>${mentor.surname}</td>
                    <td>${mentor.name}</td>
                    <td>${mentor.number}</td>
                    <td>${mentor.email}</td>
                    <td><#list user.roles as role>${role}<#sep>, </#list></td>
                    <td><#list user.status as status>${status}<#sep>, </#list></td>
                </#list>
            </#if>
            <#if isAdmin>
                <#list admins as admin>
                    <td>${admin.surname}</td>
                    <td>${admin.name}</td>
                    <td>${admin.number}</td>
                    <td>${admin.email}</td>
                    <td><#list user.roles as role>${role}<#sep>, </#list></td>
                    <td><#list user.status as status>${status}<#sep>, </#list></td>
                </#list>
            </#if>
            <td></td>
            <td><input type="radio" id="id" name="id" value="${user.id}"></td>
        </tr>
        </#list>
        </tbody>
    </table>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    </form>
</div>


<style>
    .prokrutka {
        margin: 15px 0 0 0;
        height: 350px; /* высота нашего блока */
        width: 1000px; /* ширина нашего блока */
        background: #fff; /* цвет фона, белый */
        border: 1px solid #C1C1C1; /* размер и цвет границы блока */
        overflow-y: scroll; /* прокрутка по вертикали */
    }
</style>
</@c.page>
