# 프로젝트 설명
포르자 호라이즌 5의 주행 데이터를 전달 받아서 시각화하는 프로젝트

# 데이터 처리 파이프라인
1. UDP로 데이터 수집
2. Kafka Topic으로 UDP 데이터 전송
3. Kafka Connect를 이용해서 ElasticSearch로 저장
4. Grafana로 시각화

# 구현

### 참고 데이터
```
[1,0,0,0,-73,-40,1,0,-5,63,28,70,-41,8,-83,68,12,56,-17,69,104,-33,-92,62,-72,38,6,63,-92,-60,-17,64,0,16,57,-69,-128,-117,-119,-69,82,93,114,65,-104,17,-118,61,126,-81,71,-68,-105,-77,29,-66,55,2,37,63,-112,81,-118,-67,-102,25,-93,60,68,-37,-48,62,3,4,-103,62,82,42,26,63,24,-109,5,63,111,58,69,63,116,-44,109,62,-114,114,-118,62,-79,-86,-94,62,-96,-92,93,66,7,-125,58,66,99,23,53,66,118,-87,56,66,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-112,-62,-11,61,-112,-62,-11,61,-112,-62,-11,61,-112,-62,-11,61,113,100,-113,60,-3,13,-114,60,48,51,50,60,83,13,58,60,118,71,69,63,-22,125,110,62,55,-113,-118,62,73,-59,-94,62,-4,92,7,59,-12,-71,-23,-69,-20,117,-95,60,4,-13,87,60,-14,8,0,0,5,0,0,0,-104,3,0,0,2,0,0,0,8,0,0,0,13,0,0,0,0,0,0,0,0,0,0,0,-78,119,-125,-59,-6,-114,20,67,-75,-78,-24,-60,83,93,114,65,-67,-61,-51,72,126,-95,3,68,-61,5,-5,66,118,-50,-8,66,26,-52,-6,66,26,-52,-6,66,-36,-87,-122,-64,0,0,-128,63,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,100,102,12,65,0,0,0,-74,0,0,0,1,0,0,0]
```

# 기타
프로젝트 참고
- https://youtu.be/C_4C-1v9Src
- https://blog.voidmainvoid.net/478
- https://github.com/raweceek-temeletry/forza-horizon-5-UDP