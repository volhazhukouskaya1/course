pipeline { 
    agent any
    tools { 
        maven 'Maven' 
        allure 'Allure'
    }
   stages { 
        stage('Checkout') {
            steps { 
                echo 'Checking out code...' 
                git url: 'https://github.com/volhazhukouskaya1/course', branch: 'main'
            }
        }
        stage('Build') { 
            steps { 
                script {
                    echo 'Building...'
                    bat 'mvn clean install -e -X' 
                    } 
                }
         } 
         stage('Test') {
            steps { 
                script { 
                    echo 'Testing...'
                    bat 'mvn test' 
                    } 
                    junit '**/target/surefire-reports/*.xml' 
                }
            }
         stage('Allure Report') {
            steps { 
                echo 'Generating Allure report...' 
                allure([ includeProperties: false, 
                        jdk: '',
                        properties: [], 
                        reportBuildPolicy: 'ALWAYS', 
                        results: [[path: 'target/allure-results']] ]) 
            } 
          }
        }
        post { 
            always { 
                echo 'Cleaning up...' 
            } 
            success {
                echo 'Pipeline completed successfully!'
            } 
            failure { 
                echo 'Pipeline failed!' 
            }
        }
}
