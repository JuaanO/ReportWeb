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
        stage('Git Checkout') {
            steps {
                // git credentialsId: 'gitlab-aldeamo',
                //, branch: 'experimental'
                git credentialsId: 'personalGitHub', branch: 'master', url: 'https://github.com/JuaanO/ReportWeb.git'
            }
        }
        stage('Maven Compile') {
            steps {
                echo 'el maven compile'
                // sh 'mvn clean compile'
            }
        }
        stage ('Send Message or View Report'){
            steps {
                script {
                    if (params.EjecutarPruebas == true) {
                        echo "EjecutarPruebas: ${params.EjecutarPruebas}"
//                         sh 'mvn clean test -Dcucumber.filter.tags="@fastCampaign1"'
                        switch(env.QuePruebas) {
                          case 'Fast Send Campaign':
                              echo "Fast Send Campaign"
                              sh 'mvn clean test -Dcucumber.filter.tags="@fastCampaign"'
                            break
                          case 'Massive Campaign':
                              echo "Massive Campaign"
                              sh 'mvn clean test -Dcucumber.filter.tags="@massiveCampaign"'
                            break
                          case 'Modulo SMS':
                              echo "Modulo SMS"
                              sh 'mvn clean test -Dcucumber.filter.tags="@SMS"'
                            break
                          case 'Modulo Voz':
                              echo "Modulo Voz"
                              sh 'mvn clean test -Dcucumber.filter.tags="@Voz"'
                            break
                          case 'Modulo WhatsApp':
                              echo "Modulo WhatsApp"
                              sh 'mvn clean test -Dcucumber.filter.tags="@fastCampaign1"'
                            break
                          case 'Ejecutar todo':
                              echo "Ejecutar todo"
                              sh 'mvn clean test'
                            break
                        }

                    } else {
                        echo "EjecutarPruebas: ${params.EjecutarPruebas}"
                    }
                    // sh 'mvn clean test -Dcucumber.filter.tags="@fastCampaign1"'
                    // if (params.doTest == 'Send Messages') { sh "mvn test -Dcucumber.options='-t @SendMessage'" }
                    // else if (params.doTest == 'View Reports') { sh "mvn test -Dcucumber.options='-t @ViewReport'" }
                    // else if (params.doTest == 'Send and View Reports') {sh "mvn test -Dcucumber.filter.tags='@SendMessage or @ViewReport'"}
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
            reportTitle: 'test features',
            skippedStepsNumber: -1,
            sortingMethod: 'ALPHABETICAL',
            undefinedStepsNumber: -1
        }
    }
}