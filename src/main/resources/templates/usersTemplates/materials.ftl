<#ftl encoding='UTF-8'>
<#import "../parts/common.ftl" as c>
<@c.page>

    <div class="container mt-5 mb-5">
    <h3>Материалы для прохождения курсов</h3>

    <div class="row border rounded m-3 p-3">
        <block each="document : ${documents}">
            <div class="col">
                <div>
                    <img src="/static/img/pdfka.png" alt="no icon" width="50px">
                </div>
                <div>
                    <a href="https://list-english.ru/pdf/tests/Cracking.pdf">
                        Cracking the TOEFL iBT 2009 Edition
                    </a>
                </div>
                <div>
                    <img src="/static/img/pdfka.png" alt="no icon" width="50px">
                </div>
                <div>
                    <a href="https://list-english.ru/pdf/tests/Essay.pdf">
                        Essay Writing for English Tests
                    </a>
                </div>
                <div>
                    <img src="/static/img/pdfka.png" alt="no icon" width="50px">
                </div>
                <div>
                    <a href="https://list-english.ru/pdf/tests/Answers.pdf">
                        Answer to All TOEFL Essay Questions
                    </a>
                </div>
                <div>
                    <img src="/static/img/pdfka.png" alt="no icon" width="50px">
                </div>
                <div>
                    <a href="https://list-english.ru/pdf/tests/Cambridge.pdf">
                        IELTS 8 with answers, Cambridje books
                    </a>
                </div>
                <div>
                    <img src="/static/img/pdfka.png" alt="no icon" width="50px">
                </div>
                <div>
                    <a href="https://list-english.ru/pdf/tests/AcademicWriting.pdf">
                        Academic Writing Practice for IELTS
                    </a>
                </div>
                <div>
                    <img src="/static/img/pdfka.png" alt="no icon" width="50px">
                </div>
                <div>
                    <a href="https://vk.com/doc111050411_451624960?hash=7369CKktKAlwuFE4AQP8ZGUS6BtjWYzGFXYWghLtWsc">
                        Destination Delf A1
                    </a>
                </div>
                <div>
                    <img src="/static/img/pdfka.png" alt="no icon" width="50px">
                </div>
                <div>
                    <a href="https://vk.com/doc418426_438884558?hash=JASlyXRxiacMwrC8ERqW7MAXIG0HXlzhxKzBEXyLhJT">
                        Destination DELF A2 : Préparation au DELF scolaire et junior
                    </a>
                </div>
                <div>
                    <img src="/static/img/pdfka.png" alt="no icon" width="50px">
                </div>
                <div>
                    <a href="https://pdf.11klasov.net/12876-anglijskij-shag-za-shagom-v-3-chastjah-bonk-na-i-dr.html">
                        Английский шаг за шагом для начинающих
                    </a>
                </div>
            </div>
        </block>
    </div>

    <form action="@{/documents}" method="post" enctype="multipart/form-data">
        <div>
            <h4>После выполнения заданий, можете прикрепить свои ответы здесь</h4>
            <p>
                <input type="file" name="document" required>
            </p>
            <p>
                <input type="submit" value="Загрузить" class="btn btn-info">
            </p>
        </div>
    </form>
</@c.page>