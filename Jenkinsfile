pipeline {
    agent any
    parameters {
        choice(
            choices: ['Fast Send Campaign', 'Massive Campaign', 'Modulo SMS', 'Modulo Voz', 'Modulo WhatsApp', 'Ejecutar todo'],
            description: 'Listado de módulos que se puedes testerar. ',
            name: 'QuePruebas')

        booleanParam(name: 'EjecutarPruebas', defaultValue: false, description: 'Confirme en la casilla, si son necesarias la ejecución de pruebas funcionales.')
    }
    tools{
        maven 'Maven'
        jdk 'JDK'
    }
    stages {
//         stage('Git Checkout') {
//             steps {
//                 // git credentialsId: 'gitlab-aldeamo',
//                 //, branch: 'experimental'
//                 git credentialsId: 'personalGitHub', branch: 'master', url: 'https://github.com/JuaanO/ReportWeb.git'
//             }
//         }
        stage('Maven Compile') {
            steps {
                echo 'MAVEN COMPILE'
                // sh 'mvn clean compile'
            }
        }
        stage ('Send Message or View Report'){
            steps {
                script {
                    if (params.EjecutarPruebas == true) {
                        echo "EjecutarPruebas: ${params.EjecutarPruebas}"
                        switch(env.QuePruebas) {
                          case 'Fast Send Campaign':
                              sh 'mvn clean test -Dcucumber.filter.tags="@fastCampaign"'
                            break
                          case 'Massive Campaign':
                              sh 'mvn clean test -Dcucumber.filter.tags="@massiveCampaign"'
                            break
                          case 'Modulo SMS':
                              sh 'mvn clean test -Dcucumber.filter.tags="@SMS"'
                            break
                          case 'Modulo Voz':
                              sh 'mvn clean test -Dcucumber.filter.tags="@massiveCampaign2"'
                            break
                          case 'Modulo WhatsApp':
                              sh 'mvn clean test -Dcucumber.filter.tags="@WhatsApp"'
                            break
                          case 'Ejecutar todo':
                              sh 'mvn clean test'
                            break
                        }

                    } else {
                        echo "EjecutarPruebas: ${params.EjecutarPruebas}"
                    }
                }
            }
        }
    }
    post {
        always {
            echo 'Building finished successfully'
            cucumber failedFeaturesNumber: -1,
            failedScenariosNumber: -1,
            failedStepsNumber: -1,
            fileIncludePattern: '**/*.json',
            jsonReportDirectory: 'target/report/cucumber/',
            pendingStepsNumber: -1,
            reportTitle: 'Reporte de Test Ejecutados: ',
            skippedStepsNumber: -1,
            sortingMethod: 'ALPHABETICAL',
            undefinedStepsNumber: -1

            echo 'Sending email'
            bat "del test.zip"
            zip zipFile: 'test.zip', archive: false, dir: 'target/report/'
            emailext body: "${currentBuild.currentResult}: Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}\n More info at: ${env.BUILD_URL}", recipientProviders: [buildUser()],
            from: '', attachmentsPattern: '**/ExtentHtml.html, **/image.jpg, **/.zip', replyTo: '', subject: "Jenkins Build ${currentBuild.currentResult}: Job ${env.JOB_NAME}", to: 'juan.estrella@aldeamo.com'
        }
    }
}