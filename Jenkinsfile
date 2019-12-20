pipeline {
    agent any
stages{
     stage('Integration Testing and Report') {
         steps  {
                withMaven(maven: 'TestMaven') {
                bat 'mvn clean install'
                 publishHTML target: [
                            allowMissing: false,
                            alwaysLinkToLastBuild: false,
                            keepAll: true,
                            reportDir: 'target/site/serenity',
                            reportFiles: 'index.html',
                            reportName: 'Serenity Report'
                          ]
                 }
             }

        }
    }
}