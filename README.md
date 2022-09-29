# 프로젝트 설명
포르자 호라이즌 5의 주행 데이터를 전달 받아서 시각화하는 프로젝트

# 데이터 처리 파이프라인
1. UDP로 데이터 수집
2. Kafka Topic으로 UDP 데이터 전송
3. Kafka Connect를 이용해서 ElasticSearch로 저장
4. Grafana로 시각화

# 기타
프로젝트 참고: https://youtu.be/C_4C-1v9Src
