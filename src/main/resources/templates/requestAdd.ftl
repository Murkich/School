<#import "parts/common2.ftl" as c>

<@c.page>
    <form action="request/add" method="post">

        <div class="form-group">
            <label for="formGroupExampleInput2">Наименование</label>
            <input type="text" class="form-control"
                   value="" name="name" id="formGroupExampleInput2"
                   placeholder="Учим язык весело!">
        </div>

        <div class="form-group">
            <select>
                <option>Выберите язык</option>
                <option value="eng">Английский</option>
                <option value="germ">Немецкий</option>
                <option value="franch">Французский</option>
            </select>
        </div>

        <div class="form-group">
            <label for="formGroupExampleInput2">Стоимость</label>
            <input type="text" class="form-control"
                   value="" name="cost" id="formGroupExampleInput2">
        </div>

        <div class="form-group">
            <label for="formGroupExampleInput">Начало курса</label>
            <input type="text" class="form-control"
                   value="" name="date_of_begin"  id="formGroupExampleInput"
                   placeholder="01.01.2022">
        </div>


        <div class="form-group">
            <label for="formGroupExampleInput">Окончание курса</label>
            <input type="text" class="form-control"
                   value="" name="date_of_end"  id="formGroupExampleInput"
                   placeholder="01.05.2022">
        </div>

        <div class="form-group">
            <label for="formGroupExampleInput">Всего мест</label>
            <input type="text" class="form-control"
                   value="" name="numberofseats"  id="formGroupExampleInput">
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <div><input type="submit" class="btn btn-info" value="Сохранить"/></div>
    </form>
</@c.page>