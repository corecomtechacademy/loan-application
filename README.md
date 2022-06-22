To run this on ECS as a service run the following on AWS CLI:

aws ecs create-service --cluster loan-app --service-name loan-app --task-definition start-loan-application:1 --desired-count 1 --launch-type FARGATE --platform-version LATEST --network-configuration "awsvpcConfiguration={subnets=[subnet-0a2c32c9ea0dfffba],securityGroups=[sg-0334b2505b5d25fa0],assignPublicIp=ENABLED}"

To stop the service run:

aws ecs delete-service --cluster loan-app --service loan-app --force
