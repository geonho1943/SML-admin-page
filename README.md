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

`프로젝트 클론` - `DB 커넥션 정보 작성` - `DB 연동` - `그래들 업데이트` - `빌드` - `실행`
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
#todo: 초기 세팅에서 테이블 동기화후 ddl-auto=update 속성 변경
spring.jpa.hibernate.ddl-auto=update

spring.jpa.show-sql=false
```
<br><br>

3. `빌드 툴 업데이트, 빌드`<br>

- `gradlew update`<br>
- `gradlew - jar build`<br>
  실행 버튼을 누르면 해당 테스크가 실행 됩니다 <br><br>

4. `서비스 실행`
```shell
nohup java -jar build/libs/smlAdminPage*.jar &
```
<br><br>

## ERD

![SML Admin Page mk2 (1)](https://github.com/user-attachments/assets/151ce3a3-cf97-4d3c-ab9e-740d432185f0)


## 간단 사용 설명서

SML Admin Page의 차트타입은 1일(1시간 간격), 1주(1일 간격), 1달(1일 간격)로 3가지 타입이 있습니다<br>
원하는 대상의 각 기능 사용 횟수를 원하는 시간 간격, 기간 정보로 시각화 데이터를 조회 할수 있습니다. 예를들어<br>

[ 1주일 동안의 playlist 조회 횟수가 가장 많은 날 중 playlist사용이 가장 많은 시간을 알아내고싶다 ] 면<br>
`playlist`의 `1주일`차트 를 요청해 playlist의 `check`count를 조회할 수 있습니다<br>
해당 카운트가 가장 높은 날이 1998년 03월 14일 이라면
`playlist`의 `1일`차트를 `1993 03 14` 까지 요청하면 그날의 사용횟수를 분석할 수 있습니다
또한 이 기능은 SML Admin page 의 main 화면에서 간단하게 사용해볼 수 있습니다
# todo: 해당 검색 화면 스크린샷 2장
더 자세한 데이터 조회를 원한다면 search chart 기능을 사용할 수 있습니다
`user, card, playlist` 의 `day, week, month` 타입으로 원하는시간`EndTime`동안 `Object Idx`의 데이터를 요청할 수 있습니다.
이 기능역시 main화면에서 간단하게 사용할 수 있습니다
# todo: 해당 검색 화면 스크린샷 


## License
- [MIT License](https://github.com/geonho1943/shareMyList?tab=MIT-1-ov-file)