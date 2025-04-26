pipeline {
    agent any
    tools {
        maven 'Maven_3.9.9'  // MUST match the name you gave in Jenkins global config
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'branch2', url: 'https://github.com/Alison0309/simple-java-maven-app.git'
            }
        }
        stage('Build') {
            steps {
                bat '"%MAVEN_HOME%\\bin\\mvn" clean package -DskipTests'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }
        stage('Deploy') {
            steps {
                bat 'java -jar target\\my-app-1.0-SNAPSHOT.jar'
            }
        }
    }
    post {
        always {
            echo 'Cleaning up workspace'
            deleteDir()
        }
        success {
            echo 'Build succeeded!!!'
        }
        failure {
            echo 'Build failed!'
        }
    }
}
