pipeline {
    agent any
    tools {
        maven "MAVEN"
    }
    stages {
        stage('Verify All Software Version') {
            steps {
                sh "git --version"
                sh "java -version"
                sh "mvn -version"
                sh "docker version"
                sh "docker-compose --version"
            }
        }
        stage('Build the Pet Clinic App') {
            steps {
                dir("./petClinic/"){
                    sh "ls"
                    sh "mvn clean package"
                }
            }
        }

        stage('Using Docker-Compose run all container') {
            steps {
                sh "docker-compose down"
                sh "docker-compose up --build -d"
                sh "docker images"
                sh "docker ps"
            }
        }
    }
}