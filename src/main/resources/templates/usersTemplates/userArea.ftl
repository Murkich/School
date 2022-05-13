<#import "../parts/common.ftl" as c>
<#import "../parts/login.ftl" as l>
<#include "../parts/security.ftl">
<@c.page>
<div  class = "container mt-5">
         <table class="table_blur" style="margin-top: 50px;">
             <thead>
             <tr>
                 <th> <a href = "/user/area/edit/${users.id}/" style="color:white">Редактировать информацию о себе</a></th>
              </tr>
              </thead>
          </table>

    <div>
        <div class="container mt-5">
        <div class="card">
            <div class="card-body">
                <div class="col-md-6 ">
                    <table class="table table-white table-hover " style="margin: 0px 0 0 250px">
                        <thead><tr><td><h2>Личные данные</h2></td></tr></thead>
                        <tbody>
                        <tr>
                            <td>Логин</td>
                            <td>${users.username}</td>
                        </tr>
                        <#if isUser>
                            <#list students as student>
                                <tr>
                                    <td>Фамилия</td>
                                    <td>${student.surname}</td>
                                </tr>
                                <tr>
                                    <td>Имя</td>
                                    <td>${student.name}</td>
                                </tr>
                                <tr>
                                    <td>Мобильный телефон</td>
                                    <td>${student.number}</td>
                                </tr>
                                <tr>
                                    <td>Email</td>
                                    <td>${student.email}</td>
                                </tr>
                            </#list>
                        </#if>
                        <#if isMentor>
                            <#list mentors as mentor>
                                <tr>
                                    <td>Фамилия</td>
                                    <td>${mentor.surname}</td>
                                </tr>
                                <tr>
                                    <td>Имя</td>
                                    <td>${mentor.name}</td>
                                </tr>
                                <tr>
                                    <td>Мобильный телефон</td>
                                    <td>${mentor.number}</td>
                                </tr>
                                <tr>
                                    <td>Email</td>
                                    <td>${mentor.email}</td>
                                </tr>
                            </#list>
                        </#if>
                        <#if isAdmin>
                            <#list admins as admin>
                                <tr>
                                    <td>Фамилия</td>
                                    <td>${admin.surname}</td>
                                </tr>
                                <tr>
                                    <td>Имя</td>
                                    <td>${admin.name}</td>
                                </tr>
                                <tr>
                                    <td>Мобильный телефон</td>
                                    <td>${admin.number}</td>
                                </tr>
                                <tr>
                                    <td>Email</td>
                                    <td>${admin.email}</td>
                                </tr>
                            </#list>
                        </#if>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        </div>
    </div>
</div>
</@c.page>