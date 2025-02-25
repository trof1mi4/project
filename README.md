## ФИО: Бельков Трофим Александрович
## Преподаватель: Никита Карсканов

# Аннотация SpringBootApplication

`@SpringBootApplication` - ключевая аннотация, которая объединяет в себе следующие аннотации:

*   `@Configuration`:  Указывает, что класс содержит определения бинов, которые должны быть зарегистрированы в Spring Context.
*   `@EnableAutoConfiguration`:  Включает механизм автоматической конфигурации Spring Boot. 
*   `@ComponentScan`:  Включает сканирование компонентов в пакете, где расположен класс, аннотированный `@SpringBootApplication`, и его подпакетах.  

## Параметры SpringBootApplication (через аннотации)

**1. @Configuration (неявные параметры):**

*   `proxyBeanMethods` (boolean, по умолчанию: `true`): Определяет, проксируются ли `@Bean`-методы для обеспечения singleton поведения.

**2. @EnableAutoConfiguration:**

*   `exclude` (Class<?>[]): Классы автоматической конфигурации для исключения.
*   `excludeName` (String[]): Строковые имена классов автоматической конфигурации для исключения.

**3. @ComponentScan:**

*   `basePackages` (String[]): Базовые пакеты для сканирования компонентов.
*   `basePackageClasses` (Class<?>[]): Классы, чьи пакеты будут использоваться как базовые для сканирования.
*   `nameGenerator` (Class<? extends BeanNameGenerator>): Класс, генерирующий имена бинов.
*   `scopeResolver` (Class<? extends ScopeMetadataResolver>): Класс, определяющий область видимости бинов.
*   `resourcePattern` (String): Шаблон для поиска файлов классов компонентов.
*   `useDefaultFilters` (boolean, по умолчанию: `true`): Использовать стандартные фильтры (например, `@Component`).
*   `includeFilters` (ComponentScan.Filter[]): Фильтры для включения компонентов.
*   `excludeFilters` (ComponentScan.Filter[]): Фильтры для исключения компонентов.

   

        