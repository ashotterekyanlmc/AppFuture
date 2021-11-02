package com.teashot.appfuture.ui.models

data class Contact(
    val id: String,
    val name: String,
    val photo: String,
    val phone: String,
    val secondPhone: String? = null,
    val email: String? = null,
    val secondEmail: String? = null,
    val description: String
) {
    companion object {
        fun createDefaultContact() = Contact(
            id = "contact_one_id",
            name = "Paul Sherman",
            photo = "https://cs.pikabu.ru/images/big_size_comm/2013-12_1/13862236757361.jpg",
            phone = "+76543210987",
            secondPhone = "+79876543210",
            email = "hasta_la_vista@baby.com",
            secondEmail = "ill_be@back.ru",
            description = "I'm not a machine! В процессе написания одного веб-приложения возникла необходимость тестировать код на PHP, интенсивно взаимодействующий с БД MySQL. В проекте в качестве фреймворка модульного тестирования использовался порт xUnit — PHPUnit. В результате было принято решение писать тесты для модулей, непосредственно взаимодействующих с базой, подцепив плагин PHPUnit/DbUnit.\n Дальше я расскажу о тех трудностях, которые возникли при написании тестов и о том, каким способом я их преодолел.\n В ответ же хотелось бы получить комментарии знающих людей относительно корректности моих решений."
        )
    }
}
