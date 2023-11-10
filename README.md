#1. 도메인 주제: 
1-1. 시나리오: 배달의 민족
---
    1. 고객이 메뉴를 선택하여 주문한다. 
    2. 고객이 선택한 메뉴에 대해 결제한다.
    3. 결제 요청을 하고 결제가 완료되면 주문상태가 변경된다.
    4. 상점주인이 주문을 수락하지 않으면 주문이 취소된고 주문상태가 변경된다.
 ---


#2. 이벤트스토밍 모델

![image](https://github.com/devArare/baemin-choa/assets/135335032/c9792a3e-a564-46d9-8160-4ab432962885)

#3. 도메인 이벤트 1
- saga
![2 saga실습](https://github.com/devArare/baemin-choa/assets/135335032/5c98c0e2-9baa-4fc1-a054-b815f7952d85)

#4. 도메인 이벤트 2
- compensation &  correlation
![4 compensation](https://github.com/devArare/baemin-choa/assets/135335032/160895fb-c5a4-4077-856a-b91b2a4c0594)

## Model
www.msaez.io/#/storming/baemin-choa

## Before Running Services
### Make sure there is a Kafka server running
```
cd kafka
docker-compose up
```
- Check the Kafka messages:
```
cd infra
docker-compose exec -it kafka /bin/bash
cd /bin
./kafka-console-consumer --bootstrap-server localhost:9092 --topic
```

## Run the backend micro-services
See the README.md files inside the each microservices directory:

- order
- pay


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API
- order
```
 http :8088/orders id="id" userId="userId" orderId="orderId" orderName="orderName" qty="qty" status="status" orderDt="orderDt" address="address" 
```
- pay
```
 http :8088/paymentHistories id="id" userId="userId" orderId="orderId" orderName="orderName" payId="payId" paymentTyp="paymentTyp" totalAmount="totalAmount" status="status" payDt="payDt" 
```


## Run the frontend
```
cd frontend
npm i
npm run serve
```

## Test by UI
Open a browser to localhost:8088

## Required Utilities

- httpie (alternative for curl / POSTMAN) and network utils
```
sudo apt-get update
sudo apt-get install net-tools
sudo apt install iputils-ping
pip install httpie
```

- kubernetes utilities (kubectl)
```
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
```

- aws cli (aws)
```
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
```

- eksctl 
```
curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp
sudo mv /tmp/eksctl /usr/local/bin
```

