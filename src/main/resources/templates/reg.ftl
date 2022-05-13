<#import "parts/common2.ftl" as c>

<@c.page>
    <div class = "container mt-5" >
        <form action="/user/add" method="post">
            <div class="form-group">
                <label for="formGroupExampleInput2">Фамилия</label>
                <input type="text" class="form-control ${(surnameError??)?string('is-invalid','')}"
                       value="<#if students??>${students.surname}</#if>"
                       name="surname" id="formGroupExampleInput2" placeholder="Петров">
            </div>
            <#if surnameError??>
                <div class="ismy-invalid">
                    ${surnameError}
                </div>
            </#if>

            <div class="form-group">
                <label for="formGroupExampleInput2">Имя</label>
                <input type="text" class="form-control ${(nameError??)?string('is-invalid','')}"
                       value="<#if students??>${students.name}</#if>" name="name"
                       id="formGroupExampleInput2" placeholder="Иван">
            </div>
            <#if nameError??>
                <div class="ismy-invalid">
                    ${nameError}
                </div>
            </#if>

            <div class="form-group">
                <label for="formGroupExampleInput2" >Телефон мобильный</label>
                <input type="text" class="form-control" class="form-control ${(numberError??)?string('is-invalid','')}"
                       value="<#if students??>${students.number}</#if>"
                       name="number" id="formGroupExampleInput2" placeholder="+375-33-333-33-33">
            </div>
            <#if numberError??>
                <div class="ismy-invalid">
                    ${numberError}
                </div>
            </#if>

            <div class="form-group">
                <label for="formGroupExampleInput2">Email</label>
                <input type="text" class="form-control ${(emailError??)?string('is-invalid','')}"
                       value="<#if students??>${students.email}</#if>"
                       name="email"  id="formGroupExampleInput" placeholder="sample@yandex.by">
            </div>
            <#if emailError??>
                <div class="ismy-invalid">
                    ${emailError}
                </div>
            </#if>

            <div class="form-group">
                <label for="formGroupExampleInput">Логин</label>
                <input type="text" class="form-control ${(usernameError??)?string('is-invalid','')}"
                       value="<#if user??>${user.username}</#if>"
                       name="username"  id="formGroupExampleInput" placeholder="Petrov">
            </div>
            <#if usernameError??>
                <div class="ismy-invalid">
                    ${usernameError}
                </div>
            </#if>

            <div class="form-group">
                <label for="formGroupExampleInput">Пароль</label>
                <input type="password" class="form-control ${(passwordError??)?string('is-invalid','')}"
                       name="password"  id="formGroupExampleInput">
            </div>
            <#if passwordError??>
                <div class="ismy-invalid">
                    ${passwordError}
                </div>
            </#if>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <div><input type="submit" class="btn btn-info" value="Сохранить"/></div>
        </form>
    </div>
</@c.page>