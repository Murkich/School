<#ftl encoding='UTF-8'>
<#import "../parts/common.ftl" as c>
<@c.page>

<div class = "container mt-5">
    <form action="/balanceCheck" method="post" enctype="multipart/form-data">
        <div class="container mt-5">
            <h3>Ваш баланс: ${card.cost} рублей</h3>
            <div class="card">
                <div class="card-body">
                    <div>
                        <div><input  hidden type="text" name="card_id" value="${card.id}"/></div>
                        <div class="form-group"><label for="formGroupExampleInput">Номер карты</label>
                            <input type="text" name="number" placeholder="1234 1234 1234 1234" class="form-control" id="formGroupExampleInput" >
                        </div>
                        <div class="form-group">
                            <label for="formGroupExampleInput">Месяц/год</label>
                            <input type="text" name="yemo" placeholder="MM/ГГ" class="form-control"/>
                        </div>
                        <div class="form-group">
                            <label for="formGroupExampleInput">Код</label>
                            <input type="text" name="cvv" placeholder="CVV/CVC" class="form-control"/>
                        </div>
                        <div class="form-group">
                            <label for="formGroupExampleInput">Имя и фамилия</label>
                            <input type="text" name = "fio" placeholder="Petrov Ivan" class="form-control"/>
                        </div>
                        <div class="form-group">
                            <label for="formGroupExampleInput">Сумма</label>
                            <input type="text" name = "cost" placeholder="" class="form-control"/>
                        </div>
                    </div>
                    <div>
                    </div>
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    <div><input type="submit" href = "/balancecheck" value="Пополнить" class="filter-button"/></div>
                    </div>
                </div>
            </div>
    </form>
</div>
</div>
</div></div>
</div>

<script src="https://code.jquery.com/jquery-3.1.1.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</@c.page>