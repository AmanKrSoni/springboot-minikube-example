#Pre-requisites
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

***

#### Note : Run cmd from inside project directory

****
### Endpoints: 
* {host: port}/msgs/{your-msg}
* {host: port}/msgs/greet/{user}