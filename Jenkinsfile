pipeline {
    agent any
    tools {
        jdk 'JDK17'
        maven 'Maven_3.9.9'  // Name as configured in Jenkins' Global Tool Configuration
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'branch2', url: 'https://github.com/Alison0309/simple-java-maven-app.git'
            }
        }
        stage('Build') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'  // This will show test results in Jenkins
                }
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
            deleteDir() // Clean up the workspace after the build
        }
        success {
            echo 'Build succeeded!!!'
        }
        failure {
            echo 'Build failed!'
        }
    }
}
