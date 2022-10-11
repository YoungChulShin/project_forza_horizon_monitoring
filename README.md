# 프로젝트 설명
포르자 호라이즌 5의 주행 데이터를 전달 받아서 시각화하는 프로젝트

# 데이터 처리 파이프라인
1. UDP로 데이터 수집
2. Kafka Topic으로 UDP 데이터 전송
3. Kafka Streams를 이용해서 트랙에서 진행중인 레이싱만 필터
4. Kafka Connect를 이용해서 ElasticSearch로 저장
5. Grafana로 시각화

# 동작 순서
1. docker-compose 실행
   ```
   docker-compose up -d
   ```
   - 카프카, 주키퍼, 엘라스틱서치, 키바나 실행
2. 카프카 토픽 생성
   ```
   ./kafka/bin/kafka-topics.sh --create --bootstrap-server localhost:19092 --topic forzadata --partitions 3 --replication-factor 2
   ./kafka/bin/kafka-topics.sh --create --bootstrap-server localhost:19092 --topic forzadata-racing --partitions 3 --replication-factor 2
   ```
   ```
   - 토픽이름
      - forzadata: 포르자 레이싱 raw 데이터
      - forzadata-racing: raw 데이터 중에서, 트랙에서 동작중인 데이터만 필터링
   - 파티션: 3 (docker-compose로 카프카 브로커가 3대 동작)
   - 복제 수: 2 (나 자신 외에 한대에 더 복제)
3. `forza-data-collector` 프로그램 실행
   - UDP를 이용해서 포르자 호라이즌 데이터를 전달 받고, 카프카로 데이터 전송
4. `forza-data-filter` 프로그램 실행
5. `kafka connect` 실행
4. 프로그램 종료
   ```
   docker-compose down
   ```


# 기타
프로젝트 참고
- https://youtu.be/C_4C-1v9Src
- https://blog.voidmainvoid.net/478
- https://github.com/raweceek-temeletry/forza-horizon-5-UDP
- https://github.com/Josua019/forza-dashboard/blob/main/Telemetry%20Server/FH5_packetformat.dat
