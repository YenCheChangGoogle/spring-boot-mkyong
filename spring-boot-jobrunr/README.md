# Spring Boot JobRunr examples

https://mkyong.com/spring-boot/spring-boot-jobrunr-examples/

## How to run this?
```bash
$ git clone https://github.com/mkyong/spring-boot.git

$ cd spring-boot-jobrunr

$ mvn spring-boot:run
```

透過 http://localhost:8080/run-job?name=小張 可以置入工作任務 3秒會執行到下個階段

透過 http://localhost:8080/schedule-job?name=小張&when=PT3H 可以置入工作任務到排程

其中 when=PT3H 是表示 從現在起 3 小時後

P 表示期間（Period）。
T 表示時間（Time）。
3H 表示 3 小時（Hours）。
3M 表示 3 分鐘(Minutes)。

透過 http://localhost:8000/dashboard/jobs 可以觀看監控狀態