pipeline {
    agent any
    parameters {
        choice(
            choices: ['Campañas Rapidas de SMS', 'Campañas Masivas de SMS', 'Campañas Rapidas de Voz', 'Campañas Masivas de Voz', 'Campañas Rapidas de WhatsApp', 'Campañas Masivas de WhatsApp', 'Ejecutar Todo'],
            description: 'Listado de módulos que se puedes testerar. ',
            name: 'QuePruebas')

        booleanParam(name: 'EjecutarPruebas', defaultValue: false, description: 'Confirme en la casilla, si son necesarias la ejecución de pruebas funcionales.')
    }
    tools{
        maven 'Maven'
        jdk 'JDK'
    }
    stages {
        stage('Git Checkout') {
            steps {
                // git credentialsId: 'gitlab-aldeamo',
                //, branch: 'experimental'
                git credentialsId: 'personalGitHub', branch: 'master', url: 'https://github.com/JuaanO/ReportWeb.git'
            }
        }
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
                            case 'Campañas Rapidas de SMS':
                                sh 'mvn clean test -Dcucumber.filter.tags="@fastCampaignSMS"'
                            break
                            case 'Campañas Masivas de SMS':
                                sh 'mvn clean test -Dcucumber.filter.tags="@massiveCampaignSMS"'
                            break
                            case 'Campañas Rapidas de Voz':
                                sh 'mvn clean test -Dcucumber.filter.tags="@fastCampaignVOZ"'
                            break
                            case 'Campañas Masivas de Voz':
                                sh 'mvn clean test -Dcucumber.filter.tags="@massiveCampaignVOZ"'
                            break
                            case 'Campañas Rapidas de WhatsApp':
                                sh 'mvn clean test -Dcucumber.filter.tags="@fastCampaignWhatsApp"'
                            break
                            case 'Campañas Masivas de WhatsApp':
                                sh 'mvn clean test -Dcucumber.filter.tags="@massiveCampaignWhatsApp"'
                            break
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
            // bat "del test.zip"
            // zip zipFile: 'test.zip', archive: false, dir: 'target/report/'
            // zip archive: true, dir: './maven/target', glob: '', zipFile: 'maven-target.zip'
                //                   sh 'mkdir archive'
                // sh 'echo test > archive/test.txt'
                // zip zipFile: 'test.zip', archive: false, dir: 'archive'
                // archiveArtifacts artifacts: 'test.zip', fingerprint: true

            script {
                // deleteDir()
                // sh 'mkdir archive'
                // sh 'echo test > archive/test.txt'
                // zip zipFile: 'prueba.zip', archive: false, dir: '/maven/target/report/'
                // zip archive: true, dir: '/maven/target/report/*.html', glob: '', zipFile: 'maven.zip'
                // archiveArtifacts artifacts: '**/*.zip', fingerprint: true
                // archiveArtifacts artifacts: 'maven-target.zip', fingerprint: false
                sh 'rm -rf archive'
                sh 'mkdir archive'
                sh 'echo test > archive/test.txt'
                zip zipFile: 'test.zip', archive: true , dir: ''
                archiveArtifacts artifacts: '**/*.html', fingerprint: true

            }

            // zip archive: true, dir: './maven/target', glob: '', zipFile: 'files.zip'
            emailext body: "${currentBuild.currentResult}: Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}\n More info at: ${env.BUILD_URL}", recipientProviders: [buildUser()],
            from: 'juanjose', attachmentsPattern: '**/*.html', replyTo: '', subject: "Jenkins Build ${currentBuild.currentResult}: Job ${env.JOB_NAME}", to: 'juan.estrella@aldeamo.com'
        }
    }
}