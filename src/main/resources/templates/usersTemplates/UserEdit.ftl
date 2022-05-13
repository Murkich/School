<#import "../parts/common.ftl" as c>
<#import "../parts/login.ftl" as l>
<#include "../parts/security.ftl">
<@c.page>
<div class = "container mt-5">
     <div class="add-wrapper">
        <form action="/user/area/edit" method="post" enctype="multipart/form-data">
            <div class="card">
                <div class="card-body">
                    <div>
                        <div><input  hidden type="text" name="user_id" value="${users.id}"/></div>
                        <div class="form-group"><label for="formGroupExampleInput">Логин</label>
                            <input type="text" name="username" value="${users.username}" class="form-control" id="formGroupExampleInput" >
                        </div>
                        <#if isUser>
                            <#list students as student>
                        <div class="form-group">
                            <label for="formGroupExampleInput">Фамилия</label>
                            <input type="text" name="surname"  value="${student.surname}" class="form-control"/>
                        </div>
                        <div class="form-group">
                            <label for="formGroupExampleInput">Имя</label>
                            <input type="text" name="name" value="${student.name}" class="form-control"/>
                        </div>
                                <div class="form-group">
                                    <label for="formGroupExampleInput">Мобильный телефон</label>
                                    <input type="text" name = "number" value="${student.number}" class="form-control"/>
                                </div>
                                <div class="form-group">
                                    <label for="formGroupExampleInput">Email</label>
                                    <input type="text" name = "email" value="${student.email}" class="form-control"/>
                                </div>
                            </#list>
                        </#if>
                        <#if isMentor>
                            <#list mentors as mentor>
                                <div class="form-group">
                                    <label for="formGroupExampleInput">Фамилия</label>
                                    <input type="text" name="surname"  value="${mentor.surname}" class="form-control"/>
                                </div>
                                <div class="form-group">
                                    <label for="formGroupExampleInput">Имя</label>
                                    <input type="text" name="name" value="${mentor.name}" class="form-control"/>
                                </div>
                                <div class="form-group">
                                    <label for="formGroupExampleInput">Мобильный телефон</label>
                                    <input type="text" name = "number" value="${mentor.number}" class="form-control"/>
                                </div>
                                <div class="form-group">
                                    <label for="formGroupExampleInput">Email</label>
                                    <input type="text" name = "email" value="${mentor.email}" class="form-control"/>
                                </div>
                            </#list>
                        </#if>
                        <#if isAdmin>
                            <#list admins as admin>
                                <div>
                                    <label for="formGroupExampleInput">Фамилия</label>
                                    <input type="text" name="surname"  value="${admin.surname}" class="form-control"/>
                                </div>
                                <div class="form-group">
                                    <label for="formGroupExampleInput">Имя</label>
                                    <input type="text" name="name" value="${admin.name}" class="form-control"/>
                                </div>
                                <div class="form-group">
                                    <label for="formGroupExampleInput">Мобильный телефон</label>
                                    <input type="text" name = "number" value="${admin.number}" class="form-control"/>
                                </div>
                                <div class="form-group">
                                    <label for="formGroupExampleInput">Email</label>
                                    <input type="text" name = "email" value="${admin.email}" class="form-control"/>
                                </div>
                            </#list>
                        </#if>
                    </div>
                </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <div><input type="submit" value="Сохранить" class="filter-button"/></div>
            </div>
        </form>
     </div>
</div>

</@c.page>