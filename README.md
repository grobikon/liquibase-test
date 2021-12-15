##Работа с Liquibase в Spring Boot - https://devmark.ru/article/liquibase-spring-boot

Liquibase позволяет автоматизировать внесение обновлений в структуру БД. Каждое изменение описывается в декларативном стиле и версионируется. Обновления накатываются в заранее определённом порядке на данную БД, если они ещё не накатывались. Автоматизация процесса наката изменений на базу данных особенно важна, если у вас несколько различных экземпляров приложений и для каждого из них требуется поддерживать свою БД.


###Подключаем liquibase к приложению
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.liquibase:liquibase-core")
    runtimeOnly("org.postgresql:postgresql")

###Для подключения к БД добавим следующие настройки в файл application.yml (не забудьте подставить свои параметры):
    spring.datasource.driver-class-name=org.postgresql.Driver
    spring.datasource.url=jdbc:postgresql://localhost:5432/liquibase-test
    spring.datasource.username=postgres
    spring.datasource.password=root

    spring.liquibase.change-log=classpath:liquibase_db/changelog.yml

Параметр spring.liquibase.change-log в явном виде указывает расположение файла изменений liquibase. В данном случае он должен лежать в папке resources/liquibase/. Можно и не указывать этот параметр в настройках. Тогда изменения надо будет хранить в файле resources/db/changelog/db.changelog-master.yaml.