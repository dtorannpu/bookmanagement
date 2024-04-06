# 書籍管理APIリポジトリ

## 実行手順

* DBコンテナ起動
```
docker compose up
```

* DBマイグレーション
```
gradlew flywayMigrate
```

* jOOQコード生成
```
gradlew jooqCodegen
```

* Spring Boot起動
```
gradlew bootRun
```
