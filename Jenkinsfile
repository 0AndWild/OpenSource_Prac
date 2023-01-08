pipeline {

    agent any

    stages {
        // Global variable
        stage("Set Variable") {
            steps {
                script {
                    GIT_CREDENTIAL = 'Github'
                    GIT_REPOSITORY_URL = 'https://github.com/0AndWild/OpenSource_Prac'
                }
            }
            post {
                success {
                    echo "Set Variable Success"
                }
                failure {
                    echo "Set Variable Fail"
                }
            }
        }
        //Github clone
        stage("Github clone") {
            steps {
                echo"Cloning Repository"
                git branch: 'feat*',
                    credentialsId: GIT_CREDENTIAL,
                    url: GIT_REPOSITORY_URL
            }
            post {
                success {
                    echo "Git clone Success"
                }
                failure {
                    echo "Git clone Fail"
                }
            }
        }
        //Gradle build
        stage("Gradle build") {
            steps {
                sh '''
                    echo 'Build Gradle Start'
                    ./gradlew clean build
                '''
            }
            post {
                success {
                    echo "Gradle build Success"
                }
                failure {
                    echo "Gradle build Fail"
                }
            }
        }
    }
}
