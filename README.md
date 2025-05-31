# Spring Boot JPA Sharding

이 프로젝트는 Spring Boot와 JPA를 기반으로 Apache ShardingSphere를 통합하여 데이터베이스 샤딩을 구현한 템플릿. 수평 샤딩을 통해 대규모 데이터 처리에 적합한 구조를 제공

## 기술 스택

* **Java 17**
* **Spring Boot 3.x**
* **Spring Data JPA**
* **Apache ShardingSphere**
* **H2 Database**: 테스트 및 개발 환경용 인메모리 데이터베이스
* **Gradle**: 빌드 도구

## 프로젝트 구조

```
springboot-jpa-sharding/
├── src/
│   ├── main/
│   │   └── resources/
│   │       ├── application.yml    # Spring Boot 설정 파일
│   │       └── sharding-config.yml # ShardingSphere 설정 파일
├── build.gradle
└── settings.gradle
```

## 시작하기

### 1. 클론 및 빌드

```bash
git clone https://github.com/cheonkyu/springboot-jpa-sharding.git
cd springboot-jpa-sharding
./gradlew build
```

### 2. 애플리케이션 실행

```bash
./gradlew bootRun
```

애플리케이션은 기본적으로 `http://localhost:8080`에서 실행됩니다.

## 샤딩 설정 예시

`sharding-config.yml` 파일에서 샤딩 전략을 정의할 수 있습니다. 예를 들어, `user_id`를 기준으로 수평 샤딩을 설정할 수 있습니다.

```yaml
sharding:
  tables:
    user:
      actualDataNodes: ds${0..1}.user_${0..1}
      tableStrategy:
        inline:
          shardingColumn: user_id
          algorithmExpression: user_${user_id % 2}
  defaultDatabaseStrategy:
    inline:
      shardingColumn: user_id
      algorithmExpression: ds${user_id % 2}
```

## 참고 자료

* [Apache ShardingSphere 공식 문서](https://shardingsphere.apache.org/document/current/en/overview/)
* [Spring Boot 공식 문서](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
* [Spring Data JPA 공식 문서](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/)

