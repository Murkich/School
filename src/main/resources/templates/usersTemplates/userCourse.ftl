<#import "../parts/common.ftl" as c>
<#import "../parts/login.ftl" as l>
<#include "../parts/security.ftl">
<@c.page>
    <div class="container mt-5" xmlns="http://www.w3.org/1999/html">
        <div><h1>MUR'S Школа иностранных языков</h1></div>
        <div  id = "cont" >
            <select id = "requestChoice" name ="filter">
                <option>Фильтр</option>
                <option value="http://localhost:8080/request/eng">Английский</option>
                <option value="http://localhost:8080/request/germ">Немецкий</option>
                <option value="http://localhost:8080/request/franch">Французский</option>
            </select>
            <table class="table-borderless">
                <thead>
                <form action="/request/find" method="get" class="find-wrapper" >
                    <tr>
                        <th><input type="text" name="findRequest_name" class="find-input-ares" placeholder="Наименование"></th>
                        <th>
                            <input type="submit" name="" value="Найти" class="filter-button">
                            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                        </th>
                    </tr>
                </form>
                </thead>
            </table>
            <br/>
            <form action="/request/cancel" method="get">
                <input type="submit" value="Отменить" class="filter-button">
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            </form>
            <div class="prokrutka" id="changeTable">
                <table class="table_blur" style="margin-top: 0;">
                    <thead>
                    <tr>
                        <th>id</th>
                        <th>Язык</th>
                        <th>Наименование</th>
                        <th>Стоимость</th>
                        <th>Начало курса</th>
                        <th>Окончание курса</th>
                        <th>Всего мест</th>
                        <th>Свободных мест</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <#if courses ??>
                        <#list courses as course>
                            <tr>
                                <#if course??>
                                    <td>${course.idcourse}</td>
                                    <td>${course.language}</td>
                                    <td>${course.name}</a></td>
                                    <td>${course.cost}</td>
                                    <td>${course.dateOfBegin}</td>
                                    <td>${course.dateOfEnd}</td>
                                    <td>${course.numberofseats}</td>
                                    <td>${course.numberoffreeseats}</td>
                                    <td><input type="radio" id="request_id" name="request_id" value="${course.idcourse}"></td>
                                </#if>
                            </tr>
                        </#list>
                    </#if>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</@c.page>
<style>
    .prokrutka {
        margin: 15px 0 0 0;
        height: 300px;
        width: 1100px;
        background: #fff;
        border: 1px solid #C1C1C1;
        overflow-y: scroll;
    }
</style>