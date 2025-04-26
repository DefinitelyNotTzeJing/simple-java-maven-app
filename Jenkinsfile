pipeline {
    agent any
    tools {
        jdk 'JDK17'
        maven 'Maven_3.9.9'  // Name as configured in Jenkins Global Tool Configuration
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
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        stage('Deploy') {
            steps {
                bat 'start /b java -jar target\\my-app-1.0-SNAPSHOT.jar'
            }
        }
    }
    post {
        always {
            echo 'Stopping Java App (if running)'
            bat 'taskkill /F /IM java.exe || exit 0'
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
