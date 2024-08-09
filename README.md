# SML Admin Page

## 설명
**SML Admin Page**는 다양한 맞춤형 정보를 제공하는 관리자페이지 입니다.<br>
SML서비스와 독립적으로 실행되며 양방향 동기화 방식으로 데이터를 관리할수 있습니다.

## 기간
- 2024 06/25 ~ 2024 08/10

## 기술
- **백엔드**: Java-17, Spring Boot-3.1.4, Spring Data JPA
- **프론트엔드**: Thymeleaf, Bootstrap-5.3.3
- **데이터베이스**: MariaDB
- **빌드**: Gradle
- **호스팅**: OCI > Docker

## API Document




## 실행
### 실행 순서
<br>
<div align="center">

`프로젝트 클론` - `DB 커넥션 정보 작성` - `DB 연동` - `그래들 업데이트` - `빌드` - `배포`
</div><br><br>

1. `프로젝트 클론`<br>
```shell
git clone https://github.com/geonho1943/SML-admin-page.git
```
<br><br>
2. `DB 커넥션 정보 기입`<br>


```properties
#application.properties

#DB 정보
spring.application.name=smlAdminPage
spring.datasource.url=jdbc:mariadb://data.base.ip.address:port/share_my_list
#커넥션 정보
spring.datasource.username=root
spring.datasource.password=pw

spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
#초기 세팅에서 테이블 동기화가 완료되면 ddl-auto속성을 변경하세요!
spring.jpa.hibernate.ddl-auto=update

spring.jpa.show-sql=false
```
<br><br>

3. `빌드툴 업데이트, 빌드`<br>

- `gradlew update`<br>
- `gradlew - jar build`<br>
  실행 버튼을 누르면 해당 테스크가 실행 됩니다! OvO <br><br>

4. `서비스 실행`
```shell
nohup java -jar build/libs/smlAdminPage*.jar &
```
<br><br>

## ERD

![SML Admin Page mk2 (1)](https://github.com/user-attachments/assets/151ce3a3-cf97-4d3c-ab9e-740d432185f0)



## License
- [MIT License](https://github.com/geonho1943/shareMyList?tab=MIT-1-ov-file)