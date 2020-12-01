# Pre-requisites
* Minikube installed 
* Docker is installed 

___________
### Steps
* use cmd : eval $(minikube docker-env) to sync docker with minikube so that it will search images on kubernetes.
* Build an Image : docker build -t springboot-k8s:1.0 .
* Deploy config map :  kubectl apply -f Configmap.yaml
* Deploy deployment : kubectl apply -f deployment.yaml
* Deploy Service : kubectl apply -f svc.yaml
* for port forwarding use : minikube service springboot-configmap

#### Optional : if you want another configmap from where you will inject values into spring-boot application like Sys ENVs then you can use ```cmd :  kubectl create configmap spring-boot-configmaps-demo --from-literal=greeter.prefix="Bingo"```
And in deployment.yaml : 
```             
            - name: GREETING_PREFIX
              valueFrom:
                configMapKeyRef:
                  name: spring-app-config
                  key: greeter.prefix
```  
***

#### Note : Run cmd from inside project directory

****
### Endpoints: 
* {host: port}/msgs/{your-msg}
* {host: port}/msgs/greet/{user}

Ref : https://dzone.com/articles/k8s-knowhow-using-a-configmap