pipeline {
    agent any
    tools{
        maven 'MAVEN_HOME'
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/resadnaghiyev/spring-jenkins-docker-k8s']])
                sh 'mvn clean install'
            }
        }
        stage('Build docker image'){
            steps{
                script{
                    sh 'docker build -t resadnv/spring-jenkins-docker-k8s .'
                }
            }
        }
        stage('Push image to hub'){
            steps{
                script{
                    withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerhubpwd')]){
                        sh 'docker login -u resadnv -p ${dockerhubpwd}'
                    }
                    sh 'docker push resadnv/spring-jenkins-docker-k8s'
                }
            }
        }
        stage('Deploy to Kubernetes'){
            steps{
                script{
                    kubernetesDeploy (configs: 'mysql-configMap.yaml', kubeconfigId: 'k8sconfigpwd')
                    kubernetesDeploy (configs: 'mysql-secrets.yaml', kubeconfigId: 'k8sconfigpwd')
                    kubernetesDeploy (configs: 'db-deployment.yaml', kubeconfigId: 'k8sconfigpwd')
                    kubernetesDeploy (configs: 'app-deployment.yaml', kubeconfigId: 'k8sconfigpwd')
                }
            }
        }
    }
}